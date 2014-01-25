package com.dandelion.memberapp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dandelion.memberapp.exception.MemberAppException;
import com.dandelion.memberapp.exception.WebserviceErrors;
import com.dandelion.memberapp.interceptors.UserAuthentication;
import com.dandelion.memberapp.model.po.Friend;
import com.dandelion.memberapp.model.po.Member;
import com.dandelion.memberapp.model.po.Merchant;
import com.dandelion.memberapp.model.po.User;
import com.dandelion.memberapp.model.po.Wsusersession;
import com.dandelion.memberapp.model.vo.FriendsInfo;
import com.dandelion.memberapp.model.vo.LoginInfo;
import com.dandelion.memberapp.model.vo.MemberListResponse;
import com.dandelion.memberapp.model.vo.MerchantDetailInfoResponse;
import com.dandelion.memberapp.model.vo.MerchantDetailListResponse;
import com.dandelion.memberapp.model.vo.MerchantInfoListResponse;
import com.dandelion.memberapp.model.vo.ResponseResult;
import com.dandelion.memberapp.model.vo.UserInfo;
import com.dandelion.memberapp.model.vo.UserList;
import com.dandelion.memberapp.service.AccountService;

@Controller
public class AccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private AccountService accountService;
	@Autowired
	private UserAuthentication userAuthentication;
	
	@RequestMapping(value = "/Register", method = RequestMethod.POST)
	public ResponseEntity<ResponseResult> register(@RequestParam(value = "j", required = true) String j)throws  JSONException, MemberAppException {

		JSONObject json = new JSONObject(j);
		String email = json.getString("email");
		String password = json.getString("password");
		String alias = json.optString("alias");
		int accountType = json.optInt("accountType");
		accountService.register(email, password, alias, accountType);
		return new ResponseEntity<ResponseResult>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public ResponseEntity<LoginInfo> login(@RequestParam(value = "j", required = true) String j) throws JSONException, MemberAppException {
		JSONObject json = new JSONObject(j);
		String email = json.getString("email");
		String password = json.getString("password");
		String packageName = json.getString("packageName");
		String identifier = json.getString("identifier");
		final Wsusersession sessionInfo = accountService.login(email, password,packageName, identifier);
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setSkey(sessionInfo.getSessionkey());
		loginInfo.setSid(sessionInfo.getId());
		loginInfo.setUserId(sessionInfo.getUseridfk());
		loginInfo.setAccountType(sessionInfo.getAccounttype());
		
		return new ResponseEntity<LoginInfo>(loginInfo, HttpStatus.OK);
	}
	@RequestMapping(value = "/Accounts/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserInfo> getUserInfo(@RequestParam(value = "j", required = true) String j, @PathVariable Long id) throws MemberAppException {
		User self = userAuthentication.getCurrentUser();
		User user = accountService.getUserInfo(id);
		UserInfo userinfo = new UserInfo();
		if(id.equals(self.getId())) {
			userinfo.setUseremail(user.getUseremail());
		}
		userinfo.setId(user.getId());
		userinfo.setAlias(user.getAlias());
		userinfo.setAccounttype(user.getAccounttype());
		userinfo.setFancount(user.getFancount());
		userinfo.setFollowcount(user.getFollowcount());
		userinfo.setFriendcount(user.getFriendcount());
		return new ResponseEntity<UserInfo>(userinfo, HttpStatus.OK);
	}
	@RequestMapping(value = "/Accounts", method = RequestMethod.GET)
	public ResponseEntity<UserList> searchUser(@RequestParam(value = "j", required = true) String j) throws MemberAppException, JSONException {
		JSONObject requestJson = new JSONObject(j);
		String key = requestJson.getString("key");
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		List<User> users = accountService.searchUser(key);
		for (User user : users) {
			UserInfo info = new UserInfo();
			info.setId(user.getId());
			info.setAlias(user.getAlias());
			info.setAccounttype(user.getAccounttype());
			userInfos.add(info);
		}
		UserList userList = new UserList();
		userList.setUsers(userInfos);
		return new ResponseEntity<UserList>(userList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/Accounts/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ResponseResult> updateUserInfo(@RequestParam(value = "j", required = true) String j, @PathVariable Long id) throws MemberAppException {
		try {
			JSONObject json = new JSONObject(j);
			User user = userAuthentication.getCurrentUser();
			String alias = null;
			if (!json.isNull("alias"))
				alias = json.getString("alias");
			String birthday = null;
			if (!json.isNull("birthday"))
				birthday = json.getString("birthday");
			Date birthday2 = null;
			if (birthday != null) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-M-d");
				birthday2 = simpleDateFormat.parse(birthday);
			}
			String gender = null;
			if (!json.isNull("gender"))
				gender = json.getString("gender");
			Boolean gender2 = null;
			if (gender != null) {
				if (gender == "f")
					gender2 = false;
				else
					gender2 = true;
			}
			String userSignature = null;
			if (!json.isNull("userSignature")) {
				userSignature = json.getString("userSignature");
			}
			String phoneNumber = json.optString("phoneNumber");
			user.setAlias(alias);
			accountService.updateUserInfo(user);
			return new ResponseEntity<ResponseResult>(HttpStatus.OK);
		} catch (JSONException e) {
			throw new RuntimeException(e);
		} catch (ParseException e) {
			throw new MemberAppException(WebserviceErrors.SERVER_INTERNAL_ERROR_CODE, WebserviceErrors.SERVER_INTERNAL_ERROR_MESSAGE, e);
		}
	}
	
	@RequestMapping(value = "/Friends/{id}", method = RequestMethod.POST) 
	public ResponseEntity<ResponseResult> follow(@RequestParam(value = "j", required = true) String j, @PathVariable Long id) throws MemberAppException {
		User user = userAuthentication.getCurrentUser();
		accountService.follow(user.getId(), id);
		return new ResponseEntity<ResponseResult>(HttpStatus.OK);
	}
	/**
	 * update member info such as amout amoutcount and score.
	 * @param j
	 * @param id (not userid , tb_friend primary key) 
	 * @return
	 * @throws MemberAppException
	 * @throws JSONException 
	 */
	@RequestMapping(value = "/Friends/{id}", method = RequestMethod.PUT) 
	public ResponseEntity<ResponseResult> updateMemberInfo(@RequestParam(value = "j", required = true) String j, @PathVariable Long id) throws MemberAppException, JSONException {
		JSONObject json = new JSONObject(j);
		long amount = json.optLong("amount");
		long amountcount = json.optLong("amountcount");
		long score = json.optLong("score");
		Friend friend = new Friend();
		friend.setId(id);
		friend.setAmount(amount);
		friend.setAmountcount(amountcount);
		friend.setScore(score);
		accountService.updateMemberInfo(friend);
		return new ResponseEntity<ResponseResult>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/Friends/{id}", method = RequestMethod.DELETE) 
	public ResponseEntity<ResponseResult> unfollow(@RequestParam(value = "j", required = true) String j, @PathVariable Long id) {
		User user = userAuthentication.getCurrentUser();
		accountService.unfollow(user.getId(), id);
		return new ResponseEntity<ResponseResult>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/Friends/{id}", method = RequestMethod.GET) 
	public ResponseEntity<FriendsInfo> getFriends(@RequestParam(value = "j", required = true) String j, @PathVariable Long id) {
		User self = userAuthentication.getCurrentUser();
		List<UserInfo> voFollowings = new ArrayList<UserInfo>();
		List<UserInfo> voFollowers = new ArrayList<UserInfo>();
		List<User> followings = accountService.selectFollowings(self.getId());
		for (User user : followings) {
			UserInfo info = new UserInfo();
			info.setId(user.getId());
			info.setAlias(user.getAlias());
			info.setAccounttype(user.getAccounttype());
			voFollowings.add(info);
		}
		List<User> followers = accountService.selectFollowers(self.getId());
		for (User user : followers) {
			UserInfo info = new UserInfo();
			info.setId(user.getId());
			info.setAlias(user.getAlias());
			info.setAccounttype(user.getAccounttype());
			voFollowers.add(info);
		}
		FriendsInfo friendsInfo = new FriendsInfo();
		friendsInfo.setVoFollowers(voFollowers);
		friendsInfo.setVoFollowings(voFollowings);
		return new ResponseEntity<FriendsInfo>(friendsInfo, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/MyMembers", method = RequestMethod.GET) 
	public ResponseEntity<MemberListResponse> getMyMembers(@RequestParam(value = "j", required = true) String j) throws MemberAppException {
		User self = userAuthentication.getCurrentUser();
		MemberListResponse memberListResponse = accountService.getMyMembers(self.getId());
		return new ResponseEntity<MemberListResponse>(memberListResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/MyMerchants", method = RequestMethod.GET) 
	public ResponseEntity<MerchantDetailListResponse> getMyMerchants(@RequestParam(value = "j", required = true) String j) throws MemberAppException {
		User self = userAuthentication.getCurrentUser();
		MerchantDetailListResponse merchantDetailListResponse = accountService.getMyMerchants(self.getId());
		return new ResponseEntity<MerchantDetailListResponse>(merchantDetailListResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/ForgetPassword", method = RequestMethod.POST)
	public ResponseEntity<ResponseResult> getBackPassword(@RequestParam(value = "j", required = true) String j) throws MemberAppException, JSONException {
		JSONObject json = new JSONObject(j);
		String email = json.getString("email");
		accountService.getForgetPasswordToken(email);
		return new ResponseEntity<ResponseResult>(HttpStatus.OK);
	}
	
	
	//web
	@RequestMapping(value = "/ResetPassword", method = RequestMethod.GET)
	public String resetPassword(Locale locale, Model model, @RequestParam(value = "key", required = false) String key) {
//		boolean b = accountService.checkForgetPasswordToken(key);
//		model.addAttribute("key",key);
//		if(b) {
//			return "forgetpassword";
//		} else {
//			return "error";
//		}
		
		return "forgetpassword";
	}
	
	
	//web
	@RequestMapping(value = "/SubmitResetPassword", method = RequestMethod.POST)
	public String submitResetPassword(Model model, @RequestParam(value = "password") String password, @RequestParam(value = "key") String key) throws MemberAppException {
		model.addAttribute("password",password);
		model.addAttribute("key",key);
		accountService.forgetPassword(key, password);
		return "forgetpassword";
	}
	@RequestMapping(value = "/ChangePassword", method = RequestMethod.POST)
	public ModelAndView changePassword(@RequestParam(value = "j", required = true) String j) throws JSONException {
			JSONObject json = new JSONObject(j);
			String email = json.getString("email");
			String res = accountService.changePassword(email);
			JSONObject result = new JSONObject();
			result.put("email", res);
			return new ModelAndView("json", "j", result.toString());
	}
	
	@RequestMapping(value = "Test") 
	public ResponseEntity<ResponseResult> test(@RequestParam(value ="j" , required = false) String j) throws MemberAppException {
		if(("820").equals(j)) {
			System.out.println(j);
			throw new MemberAppException(WebserviceErrors.SERVER_INTERNAL_ERROR_CODE,WebserviceErrors.SERVER_INTERNAL_ERROR_MESSAGE);
		}
		ResponseResult responseResult = new ResponseResult();
		responseResult.setSuccess(true);
		return new ResponseEntity<ResponseResult>(HttpStatus.OK);
	}
	
	
	// Merchant 
	@RequestMapping(value = "/Merchants", method = RequestMethod.GET)
	public ResponseEntity<MerchantInfoListResponse> searchMerchant(@RequestParam(value = "j", required = true) String j) throws MemberAppException, JSONException {
		JSONObject requestJson = new JSONObject(j);
		String key = requestJson.optString("key");
		Long merchantId = requestJson.optLong("merchantId");
		MerchantInfoListResponse merchantInfoListResponse = accountService.searchMerchant(key, merchantId);
		return new ResponseEntity<MerchantInfoListResponse>(merchantInfoListResponse, HttpStatus.OK);
	}
	@RequestMapping(value = "/Merchants/{id}", method = RequestMethod.GET)
	public ResponseEntity<MerchantDetailInfoResponse> getMerchant(@RequestParam(value = "j", required = true) String j, @PathVariable Long id) throws MemberAppException {
		return new ResponseEntity<MerchantDetailInfoResponse>(accountService.getMerchant(id), HttpStatus.OK);
	}
	@RequestMapping(value = "/Merchants/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateMerchant(@RequestParam(value = "j", required = true) String j, @PathVariable Long id) throws MemberAppException, JSONException {
		JSONObject requestJson = new JSONObject(j);
		String avatarUrl = requestJson.optString("avatarUrl");
		String name = requestJson.optString("name");
		String address = requestJson.optString("address");
		String phone = requestJson.optString("phone");
		String email = requestJson.optString("email");
		String merchantType = requestJson.optString("merchantType");
		String introduction = requestJson.optString("introduction");
		boolean nameRequired = requestJson.optBoolean("nameRequired");
		boolean sexRequired = requestJson.optBoolean("sexRequired");
		boolean phoneRequired = requestJson.optBoolean("phoneRequired");
		boolean addressRequired = requestJson.optBoolean("addressRequired");
		boolean emailRequired = requestJson.optBoolean("emailRequired");
		boolean memberSetting = requestJson.optBoolean("memberSetting");
		boolean birthdayRequired = requestJson.optBoolean("birthdayRequired");
		int amountRequired = requestJson.optInt("amountRequired");
		int amountCountRequired = requestJson.optInt("amountCountRequired");
		boolean scorePlan = requestJson.optBoolean("scorePlan");
		String backgroundurl = requestJson.optString("backgroundurl");
		
		Date d = new Date();
		Merchant merchant = new Merchant();
		merchant.setAvatarurl(avatarUrl);
		merchant.setName(name);
		merchant.setAddress(address);
		merchant.setPhone(phone);
		merchant.setEmail(email);
		merchant.setMerchanttype(merchantType);
		merchant.setIntroduction(introduction);
		merchant.setNamerequired(nameRequired);
		merchant.setSexrequired(sexRequired);
		merchant.setPhonerequired(phoneRequired);
		merchant.setAddressrequired(addressRequired);
		merchant.setEmailrequired(emailRequired);
		merchant.setBirthdayrequired(birthdayRequired);
		merchant.setMembersetting(memberSetting);
		merchant.setAmountrequired(amountRequired);
		merchant.setAmountcountrequired(amountCountRequired);
		merchant.setScoreplan(scorePlan);
		merchant.setModifieddate(d);
		merchant.setBackgroundurl(backgroundurl);
		accountService.updateMerchant(merchant, id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	public static void main(String[] args) {
		String s = "累計積分 : 262";
        String[] strs = s.split(":");
        long nowScore = Long.valueOf(strs[1].trim());
        System.out.println(nowScore);
	}
	// Member
	@RequestMapping(value = "/Members/{id}", method = RequestMethod.GET)
	public ResponseEntity<Member> getMember(@RequestParam(value = "j", required = true) String j, @PathVariable Long id) throws MemberAppException {
		return new ResponseEntity<Member>(accountService.getMember(id), HttpStatus.OK);
	}
	@RequestMapping(value = "/Members/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Member> updateMember(@RequestParam(value = "j", required = true) String j, @PathVariable Long id) throws MemberAppException, JSONException {
		JSONObject requestJson = new JSONObject(j);
		String avatarUrl = requestJson.optString("avatarUrl");
		String backgroundUrl = requestJson.optString("backgroundUrl");
		String name = requestJson.optString("name");
		int sex = requestJson.optInt("sex");
		//性别 0代表 男 1 代表女 
		long birthday = requestJson.optLong("birthday");
		String address = requestJson.optString("address");
		String phone = requestJson.optString("phone");
		String introduction = requestJson.optString("introduction");
		Date d = new Date();
		Member member = new Member();
		member.setAvatarurl(avatarUrl);
		member.setBackgroundurl(backgroundUrl);
		member.setName(name);
		member.setSex(sex);
		member.setBirthday(new Date(birthday));
		member.setAddress(address);
		member.setPhone(phone);
		member.setIntroduction(introduction);
		member.setCreateddate(d);
		member.setModifieddate(d);
		accountService.updateMember(member, id);
		return new ResponseEntity<Member>(HttpStatus.OK);
	}
	
	//TODO 
	// Notification System feed
	
}
