package com.dandelion.memberapp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dandelion.memberapp.dao.model.EmailBean;
import com.dandelion.memberapp.dao.model.User;
import com.dandelion.memberapp.dao.model.Wsusersession;
import com.dandelion.memberapp.exception.MemberAppException;
import com.dandelion.memberapp.exception.WebserviceErrors;
import com.dandelion.memberapp.interceptors.UserAuthentication;
import com.dandelion.memberapp.service.AccountService;

@Controller
@RequestMapping(value = "Account")
public class AccountController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private UserAuthentication userAuthentication;
	
	@RequestMapping(value = "Register")
	public ModelAndView register(@RequestParam(value = "j", required = true) String j)throws  JSONException, MemberAppException {

		JSONObject json = new JSONObject(j);
		String email = json.getString("email");
		String password = json.getString("password");
		String alias = json.getString("alias");
		accountService.register(email, password, alias);
		JSONObject result = new JSONObject();
		return new ModelAndView("json", "j", result.toString());
	}
	
	@RequestMapping(value = "Login")
	public ModelAndView login(@RequestParam(value = "j", required = true) String j) throws JSONException, MemberAppException {
		JSONObject json = new JSONObject(j);
		String email = json.getString("email");
		String password = json.getString("password");
		String packageName = json.getString("packageName");
		String identifier = json.getString("identifier");
		final Wsusersession sessionInfo = accountService.login(email, password,packageName, identifier);
		JSONObject result = new JSONObject();
		result.put("sid", sessionInfo.getId());
		result.put("skey", sessionInfo.getSessionkey());
		result.put("userId", sessionInfo.getUseridfk());
		return new ModelAndView("json", "j", result.toString());
	}
	@RequestMapping(value = "Update")
	public ModelAndView updateUserInfo(@RequestParam(value = "j", required = true) String j) throws MemberAppException {
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
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
						"yyyy-M-d");
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
			if (!json.isNull("userSignature"))
				userSignature = json.getString("userSignature");
			
			String phoneNumber = json.optString("phoneNumber");
			
			user.setAlias(alias);
			user.setBirthday(birthday2);
			user.setGender(gender2);
			user.setUsersignature(userSignature);
			user.setPhonenumber(phoneNumber);
			
			accountService.updateUserInfo(user);

			JSONObject result = new JSONObject();
			return new ModelAndView("json", "j", result.toString());
		} catch (JSONException e) {
			throw new RuntimeException(e);
		} catch (ParseException e) {
			throw new MemberAppException(WebserviceErrors.SERVER_INTERNAL_ERROR_CODE, WebserviceErrors.SERVER_INTERNAL_ERROR_MESSAGE, e);
		}
	}
	
	
	@RequestMapping(value = "ForgetPassword")
	@Rollback()
	public ModelAndView getBackPassword(@RequestParam(value = "j", required = true) String j) throws MemberAppException {
		JSONObject json;
		JSONObject result;
		try {
			json = new JSONObject(j);
			String email = json.getString("email");
			
			EmailBean bean = accountService.getForgetPasswordToken(email);
			
			result = new JSONObject();
			result.put("email", email);
			result.put("token", bean.getToken());
			result.put("expire", bean.getExpire().getTime());
			result.put("userId", bean.getId());
			
		} catch (JSONException e) {
			throw new MemberAppException(WebserviceErrors.SERVER_INTERNAL_ERROR_CODE,WebserviceErrors.SERVER_INTERNAL_ERROR_MESSAGE, e);
		} 
		return new ModelAndView("json", "j", result.toString());
	}
	@RequestMapping(value = "ChangePassword")
	public ModelAndView changePassword(@RequestParam(value = "j", required = true) String j) throws JSONException {
			JSONObject json = new JSONObject(j);
			String email = json.getString("email");
			String res = accountService.changePassword(email);
			JSONObject result = new JSONObject();
			result.put("email", res);
			return new ModelAndView("json", "j", result.toString());
	}
}
