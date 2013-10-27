package com.dandelion.memberapp.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dandelion.memberapp.dao.model.Wsusersession;
import com.dandelion.memberapp.exception.MemberAppException;
import com.dandelion.memberapp.service.AccountService;

@Controller
@RequestMapping(value = "Account")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	
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
