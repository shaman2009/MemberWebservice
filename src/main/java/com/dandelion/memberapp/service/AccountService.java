package com.dandelion.memberapp.service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dandelion.memberapp.dao.data.AccountMapper;
import com.dandelion.memberapp.dao.data.WSUserSessionInfoMapper;
import com.dandelion.memberapp.dao.model.User;
import com.dandelion.memberapp.dao.model.Wsusersession;
import com.dandelion.memberapp.exception.MemberAppException;
import com.dandelion.memberapp.exception.WebserviceErrors;
import com.dandelion.memberapp.util.Base64;
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


		// login success process.
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
		wsUserSessionInfoMapper.login(sessionInfo);
		return sessionInfo;
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
}
