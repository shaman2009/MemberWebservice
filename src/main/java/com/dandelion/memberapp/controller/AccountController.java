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
import com.dandelion.memberapp.model.po.User;
import com.dandelion.memberapp.model.po.Wsusersession;
import com.dandelion.memberapp.model.vo.FriendsInfo;
import com.dandelion.memberapp.model.vo.LoginInfo;
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
	
	@RequestMapping(value = "Register", method = RequestMethod.POST)
	public ResponseEntity<ResponseResult> register(@RequestParam(value = "j", required = true) String j)throws  JSONException, MemberAppException {

		JSONObject json = new JSONObject(j);
		String email = json.getString("email");
		String password = json.getString("password");
		String alias = json.optString("alias");
		int accountType = json.optInt("accountType");
		accountService.register(email, password, alias, accountType);
		return new ResponseEntity<ResponseResult>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "Login", method = RequestMethod.POST)
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
		userinfo.setAvatar(user.getAvataridfk());
		userinfo.setBackgroundurl(user.getBackgroundurl());
		userinfo.setBirthday(user.getBirthday());
		userinfo.setFancount(user.getFancount());
		userinfo.setFollowcount(user.getFollowcount());
		userinfo.setFriendcount(user.getFriendcount());
		userinfo.setGender(user.getGender());
		userinfo.setPhonenumber(user.getPhonenumber());
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
			info.setAvatar(user.getAvataridfk());
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
			user.setBirthday(birthday2);
			user.setGender(gender2);
			user.setUsersignature(userSignature);
			user.setPhonenumber(phoneNumber);
			accountService.updateUserInfo(user);
			return new ResponseEntity<ResponseResult>(HttpStatus.OK);
		} catch (JSONException e) {
			throw new RuntimeException(e);
		} catch (ParseException e) {
			throw new MemberAppException(WebserviceErrors.SERVER_INTERNAL_ERROR_CODE, WebserviceErrors.SERVER_INTERNAL_ERROR_MESSAGE, e);
		}
	}
	
	@RequestMapping(value = "/Friends/{id}", method = RequestMethod.PUT) 
	public ResponseEntity<ResponseResult> follow(@RequestParam(value = "j", required = true) String j, @PathVariable Long id) throws MemberAppException {
		User user = userAuthentication.getCurrentUser();
		accountService.follow(user.getId(), id);
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
			info.setAvatar(user.getAvataridfk());
			info.setAccounttype(user.getAccounttype());
			voFollowings.add(info);
		}
		List<User> followers = accountService.selectFollowers(self.getId());
		for (User user : followers) {
			UserInfo info = new UserInfo();
			info.setId(user.getId());
			info.setAlias(user.getAlias());
			info.setAvatar(user.getAvataridfk());
			info.setAccounttype(user.getAccounttype());
			voFollowers.add(info);
		}
		FriendsInfo friendsInfo = new FriendsInfo();
		friendsInfo.setVoFollowers(voFollowers);
		friendsInfo.setVoFollowings(voFollowings);
		return new ResponseEntity<FriendsInfo>(friendsInfo, HttpStatus.OK);
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
	@RequestMapping(value = "/ChangePassword/{email}", method = RequestMethod.POST)
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
	
	
	
}
