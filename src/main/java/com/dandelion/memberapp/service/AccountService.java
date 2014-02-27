package com.dandelion.memberapp.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dandelion.memberapp.contants.MemberContants;
import com.dandelion.memberapp.contants.NotificationContants;
import com.dandelion.memberapp.dao.data.AccountMapper;
import com.dandelion.memberapp.dao.data.FriendMapper;
import com.dandelion.memberapp.dao.data.MemberMapper;
import com.dandelion.memberapp.dao.data.MerchantMapper;
import com.dandelion.memberapp.dao.data.UserMapper;
import com.dandelion.memberapp.dao.data.WSUserSessionInfoMapper;
import com.dandelion.memberapp.exception.MemberAppException;
import com.dandelion.memberapp.exception.WebserviceErrors;
import com.dandelion.memberapp.model.bo.MemberInfo;
import com.dandelion.memberapp.model.bo.MerchantMemberInfo;
import com.dandelion.memberapp.model.po.Emailbean;
import com.dandelion.memberapp.model.po.Friend;
import com.dandelion.memberapp.model.po.FriendExample;
import com.dandelion.memberapp.model.po.Member;
import com.dandelion.memberapp.model.po.MemberExample;
import com.dandelion.memberapp.model.po.Merchant;
import com.dandelion.memberapp.model.po.MerchantExample;
import com.dandelion.memberapp.model.po.User;
import com.dandelion.memberapp.model.po.Wsusersession;
import com.dandelion.memberapp.model.vo.MemberListResponse;
import com.dandelion.memberapp.model.vo.MerchantDetailInfoResponse;
import com.dandelion.memberapp.model.vo.MerchantDetailListResponse;
import com.dandelion.memberapp.model.vo.MerchantInfoListResponse;
import com.dandelion.memberapp.util.Base64;
import com.dandelion.memberapp.util.ByteUtilities;
import com.dandelion.memberapp.util.MailUtil;
import com.dandelion.memberapp.util.Utilities;

@Service
public class AccountService {
	@Autowired
	private AccountMapper accountMapper;
	@Autowired
	private WSUserSessionInfoMapper wsUserSessionInfoMapper;
	@Autowired
	private MerchantMapper merchantMapper;
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private NotificationService notificationService;
	@Autowired
	private FriendMapper friendMapper;
	
	//select ID from tb_TestConnection oopass
	public void register(String email, String password, String alias, int accountType) throws MemberAppException {
		//1.check email format
		if (!Utilities.checkEmailFormat(email)) {
			throw new MemberAppException(WebserviceErrors.EMAIL_INVALID_CODE, WebserviceErrors.EMAIL_INVALID_MESSAGE);
		}
		//2.check email if duplicated or not
		User user = accountMapper.getUserByEmail(email);
		if (user != null) {
			throw new MemberAppException(WebserviceErrors.EMAIL_DUPLICATED_CODE, WebserviceErrors.EMAIL_DUPLICATED_MESSAGE);
		}
		//3.insert userinfo into database
		user = new User();
		Date date = new Date();
		user.setUseremail(email);
		user.setPassword(password);
		user.setAlias(alias);
		user.setCreateddate(date);
		user.setModifieddate(date);
		user.setAccounttype(accountType);
		userMapper.insertSelective(user);
		user = accountMapper.getUserByEmail(email);
		Long userId = user.getId();
		Long idfk = createMerchantOrMemberAccount(userId, accountType, alias, email);
		if (MemberContants.ACCOUNT_TYPE_MEMBER == accountType) {
			user.setMemberidfk(idfk);
		} else {
			user.setMerchantidfk(idfk);
		}
		userMapper.updateByPrimaryKeySelective(user);
	}
	public Wsusersession login(String email, String password, String packageName, String identifier) throws MemberAppException {

		//1.check username and password
		User user = accountMapper.getUserByEmailAndPassword(email, password);

		if (user == null) {
			throw new MemberAppException(
					WebserviceErrors.EMAIL_PASSWORD_WRONG_CODE,
					WebserviceErrors.EMAIL_PASSWORD_WRONG_MESSAGE);
		}


		//2. generate new session   
		String identifier_decoded = Base64.decodeToString(identifier,Base64.NO_WRAP, "UTF-8").toUpperCase();
		List<Wsusersession> slist = wsUserSessionInfoMapper.getByAll(user.getId(), identifier_decoded, packageName);
		if (!slist.isEmpty()) {
			wsUserSessionInfoMapper.delete(slist.get(0).getId());
		}
		Wsusersession sessionInfo = new Wsusersession();
		sessionInfo.setId(UUID.randomUUID().toString());
		sessionInfo.setDeviceidentifier(identifier_decoded);
		sessionInfo.setPackagename(packageName);
		sessionInfo.setSessionkey(Math.abs(new Random().nextInt()));
		sessionInfo.setUseridfk(user.getId());
		sessionInfo.setCreateddate(new Date());
		sessionInfo.setAccounttype(user.getAccounttype());
		wsUserSessionInfoMapper.login(sessionInfo);
		return sessionInfo;
	}
	public void follow(Long fromId, Long targetId) throws MemberAppException {
		if(fromId.equals(targetId)) {
			throw new MemberAppException(WebserviceErrors.TARGETUSERID_INVALID_CODE,WebserviceErrors.TARGETUSERID_INVALID_MESSAGE); 
		}
		List<Friend> friends = accountMapper.selectFriend(fromId, targetId);
		if(friends.size() > 0) {
			return;
		}
		Friend friend = new Friend();
		friend.setFromuseridfk(fromId);
		friend.setTargetuseridfk(targetId);
		// follows + 1 followers + 1
		accountMapper.follow(friend);
		User user = userMapper.selectByPrimaryKey(fromId);
		if (MemberContants.ACCOUNT_TYPE_MEMBER == user.getAccounttype() ) {
			notificationService.addNotification(fromId, targetId, "", NotificationContants.MEMBER_REQUEST);
		} else {
			// update ismember == true
			FriendExample friendExample = new FriendExample();
			friendExample.createCriteria().andFromuseridfkEqualTo(targetId).andTargetuseridfkEqualTo(fromId);
			List<Friend> list = friendMapper.selectByExample(friendExample);
			if (list.isEmpty()) {
				throw new MemberAppException(
						WebserviceErrors.LIST_EMPTY_ERROR_CODE,
						WebserviceErrors.LIST_EMPTY_ERROR_MESSAGE); 
			}
			Friend friendx = list.get(0);
			friendx.setIsmember(true);
			friendMapper.updateByPrimaryKeySelective(friendx);
			notificationService.addNotification(fromId, targetId, "", NotificationContants.MEMBER_ACCEPT);
		}
	}
	public void unfollow(Long fromId, Long targetId) {
		// follows - 1 followers - 1
		accountMapper.deleteFriend(fromId, targetId);
	}
	public List<User> selectFollowings(Long userId) {
		List<User> users = accountMapper.selectFollowings(userId);
		// follows - 1 followers - 1
		return users;
	}
	// return ID is tb_friend ID  , it is wrong.
	@Deprecated
	public List<User> selectFollowers(Long userId) {
		List<User> users = accountMapper.selectFollowers(userId);
		// follows - 1 followers - 1
		return users;
	}
	public void updateUserInfo(User user) {
		user.setModifieddate(new Date());
		accountMapper.updateUserInfo(user);
	}
	public String changePassword(String email) {
		User user = new User();
		user.setPassword(email);
		user.setUseremail(email);
		accountMapper.insertUser(user);
//		List<User> list = accountMapper.getUserByEmail(email);
//		String s = String.valueOf(list.size());
		return "Dandelion";
	}
	
	public User getUserInfo(Long userId) {
		User user = accountMapper.getUserByID(userId);
		return user;
	}
	public List<User> searchUser(String key) {
		key = "%" + key + "%";
		List<User> users = accountMapper.searchUser(key);
		return users;
	}
	
	public MerchantInfoListResponse searchMerchant(String key, Long merchantId) throws MemberAppException {
		List<Merchant> merchantList = new ArrayList<Merchant>();
		MerchantInfoListResponse merchantInfoListResponse = new MerchantInfoListResponse();
		if (merchantId == 0 ) {
			key = "%" + key + "%";
			MerchantExample merchantExample = new MerchantExample();
			merchantExample.createCriteria().andNameLike(key);
			merchantList = merchantMapper.selectByExample(merchantExample);

		} else {
			Merchant merchant = merchantMapper.selectByPrimaryKey(merchantId);
			if (merchant == null) {
				throw new MemberAppException(
						WebserviceErrors.MERCHANT_NOT_FOUND_CODE,
						WebserviceErrors.MERCHANT_NOT_FOUND_MESSAGE);
			}
			merchantList.add(merchant);
		}
		merchantInfoListResponse.setMerchantList(merchantList);
		return merchantInfoListResponse;
	}
	public Emailbean getForgetPasswordToken(final String email) throws MemberAppException {
		if (!Utilities.checkEmailFormat(email)) {
			throw new MemberAppException(WebserviceErrors.EMAIL_INVALID_CODE,WebserviceErrors.EMAIL_INVALID_MESSAGE);
		}
		final User user = accountMapper.getUserByEmail(email);
		if (user == null) {
			throw new MemberAppException(WebserviceErrors.USER_NOT_FOUND_CODE,WebserviceErrors.USER_NOT_FOUND_MESSAGE);
		}
		Emailbean emailBean = accountMapper.getEmailBean(user.getId());
		
		final String key = MailUtil.spliceString(email);
		
		try {
			AsyncTaskExecutor task = new SimpleAsyncTaskExecutor();
			task.execute(new Runnable() {
				@Override
				public void run() {
					try {
						boolean b = false;
						b = MailUtil.sendMailViaSpring(user, email, key);
						if(!b) {
							throw new MemberAppException(WebserviceErrors.EMAIL_SEND_ERROR_CODE,WebserviceErrors.EMAIL_SEND_ERROR_MESSAGE);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (emailBean == null) {
			emailBean = new Emailbean();
			emailBean.setId(user.getId());
			emailBean.setToken(key);
			Date d = new Date(System.currentTimeMillis() + MemberContants.FORGET_PASSWORD_TOKEN_EXPIRE);
			emailBean.setExpire(d);
			accountMapper.insert(emailBean);
		} else {
			emailBean.setToken(key);
			Date d = new Date(System.currentTimeMillis() + MemberContants.FORGET_PASSWORD_TOKEN_EXPIRE);
			emailBean.setExpire(d);
			accountMapper.update(emailBean);
		}

		return emailBean;
	}
	
	public boolean checkForgetPasswordToken(String forgetPasswordToken) {
		Emailbean emailBean = accountMapper.getEmailBeanByToken(forgetPasswordToken);
		if (emailBean == null) {
			return false;
		}
		if (emailBean.getExpire().before(new Date())) {
			return false;
		}
		return true;
	}
	@Transactional(value = "user", rollbackFor = { SQLException.class })
	public void forgetPassword(String forgetPasswordToken, String newPassword)
			throws MemberAppException {
		String password_md5;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			password_md5 = ByteUtilities.toHexString(md.digest(newPassword.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

		Emailbean emailBean = accountMapper.getEmailBeanByToken(forgetPasswordToken);
		if (emailBean == null) {
			throw new MemberAppException(
					WebserviceErrors.FORGET_PASSWORD_TOKEN_NOT_FOUND,
					WebserviceErrors.FORGET_PASSWORD_TOKEN_NOT_FOUND_MESSAGE);
		}

		if (emailBean.getExpire().before(new Date())) {
			// expired
			throw new MemberAppException(
					WebserviceErrors.FORGET_PASSWORD_TOKEN_EXPIRED,
					WebserviceErrors.FORGET_PASSWORD_TOKEN_EXPIRED_MESSAGE);
		}

		User user = accountMapper.getUserByID(emailBean.getId());
		accountMapper.updatePass(user.getId(), password_md5);
		accountMapper.delete(emailBean.getId());

	}
	
	public Long createMerchantOrMemberAccount(Long userId, Integer accountType, String name, String email) {
		Long id = 0L;
		Date d = new Date();
		if (MemberContants.ACCOUNT_TYPE_MEMBER == accountType) {
			Member member = new Member();
			member.setUseridfk(userId);
			member.setName(name);
			member.setCreateddate(d);
			member.setModifieddate(d);
			memberMapper.insertSelective(member);
			MemberExample memberExample = new MemberExample();
			memberExample.createCriteria().andUseridfkEqualTo(userId);
			id = memberMapper.selectByExample(memberExample).get(0).getId();
		} else if (MemberContants.ACCOUNT_TYPE_MERCHANT == accountType) {
			Merchant merchant = new Merchant();
			merchant.setUseridfk(userId);
			merchant.setName(name);
			merchant.setEmail(email);
			merchant.setCreateddate(d);
			merchant.setModifieddate(d);
			merchantMapper.insertSelective(merchant);
			MerchantExample merchantExample = new MerchantExample();
			merchantExample.createCriteria().andUseridfkEqualTo(userId);
			id = merchantMapper.selectByExample(merchantExample).get(0).getId();
		}
		return id;
	}
	public MerchantDetailInfoResponse getMerchant(Long userId) throws MemberAppException {
		MerchantDetailInfoResponse merchantDetailInfo = new MerchantDetailInfoResponse();
		MerchantExample example = new MerchantExample();
		example.createCriteria().andUseridfkEqualTo(userId);
		List<Merchant> merchantList = merchantMapper.selectByExample(example);
		if (merchantList.isEmpty()) {
			throw new MemberAppException(
					WebserviceErrors.MERCHANT_NOT_FOUND_CODE,
					WebserviceErrors.MERCHANT_NOT_FOUND_MESSAGE);
		}
		Merchant merchant = merchantList.get(0);

		merchantDetailInfo.setAvatarurl(merchant.getAvatarurl());
		merchantDetailInfo.setName(merchant.getName());
		merchantDetailInfo.setAddress(merchant.getAddress());
		merchantDetailInfo.setPhone(merchant.getPhone());
		merchantDetailInfo.setEmail(merchant.getEmail());
		merchantDetailInfo.setMerchanttype(merchant.getMerchanttype());
		merchantDetailInfo.setIntroduction(merchant.getIntroduction());
		merchantDetailInfo.setNamerequired(merchant.getNamerequired());
		merchantDetailInfo.setSexrequired(merchant.getSexrequired());
		merchantDetailInfo.setPhonerequired(merchant.getPhonerequired());
		merchantDetailInfo.setAddressrequired(merchant.getAddressrequired());
		merchantDetailInfo.setEmailrequired(merchant.getEmailrequired());
		merchantDetailInfo.setBirthdayrequired(merchant.getBirthdayrequired());
		merchantDetailInfo.setMembersetting(merchant.getMembersetting());
		merchantDetailInfo.setAmountrequired(merchant.getAmountrequired());
		merchantDetailInfo.setAmountcountrequired(merchant.getAmountcountrequired());
		merchantDetailInfo.setScoreplan(merchant.getScoreplan());
		merchantDetailInfo.setBackgroundurl(merchant.getBackgroundurl());
		merchantDetailInfo.setMerchantId(merchant.getId());
		
		User user = userMapper.selectByPrimaryKey(merchant.getUseridfk());
		if (null == user ) {
			throw new MemberAppException(
					WebserviceErrors.USER_NOT_FOUND_CODE,
					WebserviceErrors.USER_NOT_FOUND_MESSAGE);
		}
		merchantDetailInfo.setUserId(user.getId());
		merchantDetailInfo.setUseremail(user.getUseremail());
		merchantDetailInfo.setFriendcount(user.getFriendcount());
		merchantDetailInfo.setFancount(user.getFancount());
		merchantDetailInfo.setFollowcount(user.getFollowcount());
		merchantDetailInfo.setArticlecount(user.getArticlecount());
		return merchantDetailInfo;
	}
	public void updateMerchant(Merchant merchant, Long userId) throws MemberAppException {
		MerchantExample example = new MerchantExample();
		example.createCriteria().andUseridfkEqualTo(userId);
		List<Merchant> merchantList = merchantMapper.selectByExample(example);
		if (merchantList.isEmpty()) {
			throw new MemberAppException(
					WebserviceErrors.MERCHANT_NOT_FOUND_CODE,
					WebserviceErrors.MERCHANT_NOT_FOUND_MESSAGE);
		}
		Long merchantId = merchantList.get(0).getId();
		merchant.setId(merchantId);
		merchantMapper.updateByPrimaryKeySelective(merchant);
	}
	public Member getMember(Long userId) throws MemberAppException {
		MemberExample example = new MemberExample();
		example.createCriteria().andUseridfkEqualTo(userId);
		List<Member> memberList = memberMapper.selectByExample(example);
		if (memberList.isEmpty()) {
			throw new MemberAppException(
					WebserviceErrors.MEMBER_NOT_FOUND_CODE,
					WebserviceErrors.MEMBER_NOT_FOUND_MESSAGE);
		}
		return memberList.get(0);
	}
	public void updateMember(Member member, Long userId) throws MemberAppException {
		MemberExample example = new MemberExample();
		example.createCriteria().andUseridfkEqualTo(userId);
		List<Member> memberList = memberMapper.selectByExample(example); 
		if (memberList.isEmpty()) {
			throw new MemberAppException(
					WebserviceErrors.MEMBER_NOT_FOUND_CODE,
					WebserviceErrors.MEMBER_NOT_FOUND_MESSAGE);
		}
		Long memberId = memberList.get(0).getId();
		member.setId(memberId);
		memberMapper.updateByPrimaryKeySelective(member);
	}
	public MemberListResponse getMyMembers(Long id) throws MemberAppException {
		MemberListResponse memberListResponse = new MemberListResponse();
		List<MemberInfo> memberList = new ArrayList<MemberInfo>();
		FriendExample friendExample = new FriendExample();
		friendExample.createCriteria().andTargetuseridfkEqualTo(id);
		List<Friend> friends = friendMapper.selectByExample(friendExample);
		
		for (Friend friend : friends) {
			long userId = friend.getFromuseridfk();
			Member member = getMember(userId);
			MemberInfo memberInfo = new MemberInfo();
			memberInfo.setId(member.getId());
			memberInfo.setUseridfk(member.getUseridfk());
			memberInfo.setAvatarurl(member.getAvatarurl());
			memberInfo.setBackgroundurl(member.getBackgroundurl());
			memberInfo.setName(member.getName());
			memberInfo.setSex(member.getSex());
			memberInfo.setBirthday(member.getBirthday());
			memberInfo.setAddress(member.getAddress());
			memberInfo.setPhone(member.getPhone());
			memberInfo.setIntroduction(member.getIntroduction());
			memberInfo.setCreateddate(member.getCreateddate());
			memberInfo.setModifieddate(member.getModifieddate());
			

			
			memberInfo.setFriendId(friend.getId());
			memberInfo.setIsmember(friend.getIsmember());
			memberInfo.setAmount(friend.getAmount());
			memberInfo.setAmountcount(friend.getAmountcount());
			memberInfo.setScore(friend.getScore());
			memberList.add(memberInfo);
		}
		memberListResponse.setMemberList(memberList);
		return memberListResponse;
	}
	public MerchantDetailListResponse getMyMerchants(Long id) throws MemberAppException {
		MerchantDetailListResponse merchantDetailListResponse = new MerchantDetailListResponse();
		List<MerchantMemberInfo> merchantList = new ArrayList<MerchantMemberInfo>();
		FriendExample friendExample = new FriendExample();
		friendExample.createCriteria().andFromuseridfkEqualTo(id);
		List<Friend> friends = friendMapper.selectByExample(friendExample);
		for (Friend friend : friends) {
			long userId = friend.getTargetuseridfk();
			MerchantDetailInfoResponse merchantDetailInfoResponse = getMerchant(userId);
			merchantDetailInfoResponse.setBackgroundurl(friend.getId().toString());
			MerchantMemberInfo merchantMemberInfo = new MerchantMemberInfo();
			merchantMemberInfo.setUserId(userId);
			merchantMemberInfo.setMerchantId(merchantDetailInfoResponse.getMerchantId());
			merchantMemberInfo.setAvatarurl(merchantDetailInfoResponse.getAvatarurl());
			merchantMemberInfo.setName(merchantDetailInfoResponse.getName());
			merchantMemberInfo.setAddress(merchantDetailInfoResponse.getAddress());
			merchantMemberInfo.setPhone(merchantDetailInfoResponse.getPhone());
			merchantMemberInfo.setEmail(merchantDetailInfoResponse.getEmail());
			merchantMemberInfo.setMerchanttype(merchantDetailInfoResponse.getMerchanttype());
			merchantMemberInfo.setIntroduction(merchantDetailInfoResponse.getIntroduction());
			merchantMemberInfo.setNamerequired(merchantDetailInfoResponse.getNamerequired());
			merchantMemberInfo.setSexrequired(merchantDetailInfoResponse.getSexrequired());
			merchantMemberInfo.setPhonerequired(merchantDetailInfoResponse.getPhonerequired());
			merchantMemberInfo.setAddressrequired(merchantDetailInfoResponse.getAddressrequired());
			merchantMemberInfo.setEmailrequired(merchantDetailInfoResponse.getEmailrequired());
			merchantMemberInfo.setBirthdayrequired(merchantDetailInfoResponse.getBirthdayrequired());
			merchantMemberInfo.setMembersetting(merchantDetailInfoResponse.getMembersetting());
			merchantMemberInfo.setAmountrequired(merchantDetailInfoResponse.getAmountrequired());
			merchantMemberInfo.setAmountcountrequired(merchantDetailInfoResponse.getAmountcountrequired());
			merchantMemberInfo.setScoreplan(merchantDetailInfoResponse.getScoreplan());
			merchantMemberInfo.setBackgroundurl(merchantDetailInfoResponse.getBackgroundurl());
			
			//error friend
//			FriendExample memberInfoExample  = new FriendExample();
//			memberInfoExample.createCriteria().andFromuseridfkEqualTo(friend.getTargetuseridfk()).andTargetuseridfkEqualTo(id);
//			List<Friend> list = friendMapper.selectByExample(memberInfoExample);
//			if (list.isEmpty()) {
//				throw new MemberAppException(
//						WebserviceErrors.LIST_EMPTY_ERROR_CODE,
//						WebserviceErrors.LIST_EMPTY_ERROR_MESSAGE); 
//			}
//			Friend memberInfo = list.get(0);
			merchantMemberInfo.setFriendId(friend.getId());
			merchantMemberInfo.setIsmember(friend.getIsmember());
			merchantMemberInfo.setAmount(friend.getAmount());
			merchantMemberInfo.setAmountcount(friend.getAmountcount());
			merchantMemberInfo.setScore(friend.getScore());
			merchantList.add(merchantMemberInfo);
		}
		merchantDetailListResponse.setMerchantList(merchantList);
		return merchantDetailListResponse;
	}
	public void updateMemberInfo(Friend friend) {
		friendMapper.updateByPrimaryKeySelective(friend);
	}

}
