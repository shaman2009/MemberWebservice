package com.dandelion.memberapp.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dandelion.memberapp.Contants.Contants;
import com.dandelion.memberapp.dao.data.AccountMapper;
import com.dandelion.memberapp.dao.data.WSUserSessionInfoMapper;
import com.dandelion.memberapp.dao.model.Emailbean;
import com.dandelion.memberapp.dao.model.User;
import com.dandelion.memberapp.dao.model.Wsusersession;
import com.dandelion.memberapp.exception.MemberAppException;
import com.dandelion.memberapp.exception.WebserviceErrors;
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
	
	//select ID from tb_TestConnection oopass
	public void register(String email, String password, String alias) throws MemberAppException {
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
		user.setId(UUID.randomUUID().toString());
		user.setUseremail(email);
		user.setPassword(password);
		user.setAlias(alias);
		user.setCreateddate(date);
		user.setModifieddate(date);
		accountMapper.insertUser(user);
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
		wsUserSessionInfoMapper.login(sessionInfo);
		return sessionInfo;
	}
	public void updateUserInfo(User user) {
		if (user.getGender() == null && user.getAlias() == null
				&& user.getUsersignature() == null
				&& user.getBirthday() == null && user.getPhonenumber() ==null) {
			return;
		}
		user.setModifieddate(new Date());
		accountMapper.updateUserInfo(user);
	}
	public String changePassword(String email) {
		User user = new User();
		String id = UUID.randomUUID().toString();
		user.setId(id);
		user.setPassword(email);
		user.setUseremail(email);
		accountMapper.insertUser(user);
//		List<User> list = accountMapper.getUserByEmail(email);
//		String s = String.valueOf(list.size());
		return "Dandelion";
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
			Date d = new Date(System.currentTimeMillis() + Contants.FORGET_PASSWORD_TOKEN_EXPIRE);
			emailBean.setExpire(d);
			accountMapper.insert(emailBean);
		} else {
			emailBean.setToken(key);
			Date d = new Date(System.currentTimeMillis() + Contants.FORGET_PASSWORD_TOKEN_EXPIRE);
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

}
