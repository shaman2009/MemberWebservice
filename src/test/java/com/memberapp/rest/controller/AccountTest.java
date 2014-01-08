package com.memberapp.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author FengxiangZhu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class AccountTest {
	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;
	private static final String REGISTERURL = "/Register";
	private static final String LOGINURL = "/Login";
	private static final String ACCOUNTURL = "/Accounts";
	private static final String FRIENDURL = "/Friends";
	private static final String FEEDURL = "/Feeds";
	private static final String TIMELINE = "/Timeline";
	private static final String FORGETPASSWORDURL = "/ForgetPassword";
	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void RegisterTest() throws Exception {
		String email = UUID.randomUUID().toString() + "@junit.com";
		String password = UUID.randomUUID().toString();
		JSONObject registerRequestParams = new JSONObject();
		registerRequestParams.put("email", email);
		registerRequestParams.put("password", password);
		registerRequestParams.put("accountType", 0);
		registerRequestParams.put("alias", UUID.randomUUID().toString());
		this.mockMvc.perform(post(REGISTERURL)
					.param("j", registerRequestParams.toString()))
					.andDo(print())
					.andExpect(status().isOk());
	}	
	
	@Test
	public void LoginTest() throws Exception {
		String email = UUID.randomUUID().toString() + "@junit.com";
		String password = UUID.randomUUID().toString();
		JSONObject registerRequestParams = new JSONObject();
		registerRequestParams.put("email", email);
		registerRequestParams.put("password", password);
		registerRequestParams.put("accountType", 0);
		registerRequestParams.put("alias", UUID.randomUUID().toString());
		this.mockMvc.perform(post(REGISTERURL)
					.param("j", registerRequestParams.toString()))
					.andExpect(status().isOk());
		JSONObject loginRequestParams = new JSONObject();
		loginRequestParams.put("email", email);
		loginRequestParams.put("password", password);
		loginRequestParams.put("packageName", "com.dandelion.memberapp");
		loginRequestParams.put("identifier", UUID.randomUUID());
		this.mockMvc.perform(post(LOGINURL)
					.param("j", loginRequestParams.toString()))
					.andDo(print())
					.andExpect(status().isOk());
	}
	
//	@Test
	public void ForgetPasswordTest() throws Exception {
		JSONObject forgetPasswordRequestParams = new JSONObject();
		forgetPasswordRequestParams.put("email", "wow2009zfx@gmail.com");
		this.mockMvc.perform(post(FORGETPASSWORDURL)
					.param("j", forgetPasswordRequestParams.toString()))
					.andDo(print())
					.andExpect(status().isOk());
	}	
	@Test
	public void UpdateUserTest() throws Exception {
		String email = UUID.randomUUID().toString() + "@junit.com";
		String password = UUID.randomUUID().toString();
		String loginResponse = loginAndRegister(email, password);
		JSONObject response = new JSONObject(loginResponse);
		String sid = response.getString("sid");
		String userId = response.getString("userId");
		JSONObject updateUserRequestParams = new JSONObject();
		updateUserRequestParams.put("alias", "updateAliasTest");
		updateUserRequestParams.put("sid", sid);
		this.mockMvc.perform(put(ACCOUNTURL + "/" + userId)
					.param("j", updateUserRequestParams.toString()))
					.andDo(print())
					.andExpect(status().isOk());
	}
	
	@Test
	public void SearchUserTest() throws Exception {
		String email = UUID.randomUUID().toString() + "@junit.com";
		String password = UUID.randomUUID().toString();
		String loginResponse = loginAndRegister(email, password);
		JSONObject response = new JSONObject(loginResponse);
		String sid = response.getString("sid");
		String userId = response.getString("userId");
		JSONObject searchUserRequestParams = new JSONObject();
		searchUserRequestParams.put("key", "1");
		searchUserRequestParams.put("sid", sid);
		this.mockMvc.perform(get(ACCOUNTURL)
					.param("j", searchUserRequestParams.toString()))
					.andDo(print())
					.andExpect(status().isOk());
	}
	
	@Test
	public void getUserInfoTest() throws Exception {
		String email = UUID.randomUUID().toString() + "@junit.com";
		String password = UUID.randomUUID().toString();
		String loginResponse = loginAndRegister(email, password);
		JSONObject response = new JSONObject(loginResponse);
		String sid = response.getString("sid");
		String userId = response.getString("userId");
		JSONObject getUserRequestParams = new JSONObject();
		getUserRequestParams.put("alias", "updateAliasTest");
		getUserRequestParams.put("sid", sid);
		this.mockMvc.perform(get(ACCOUNTURL + "/" + userId)
					.param("j", getUserRequestParams.toString()))
					.andDo(print())
					.andExpect(status().isOk());
	}
	
	@Test
	public void followTest() throws Exception {
		String email = UUID.randomUUID().toString() + "@junit.com";
		String password = UUID.randomUUID().toString();
		String loginResponse = loginAndRegister(email, password);
		String targetemail = UUID.randomUUID().toString() + "@junit.com";
		String targetpassword = UUID.randomUUID().toString();
		String targetLoginResponse = loginAndRegister(targetemail, targetpassword);
		JSONObject response = new JSONObject(loginResponse);
		String sid = response.getString("sid");
		String userId = response.getString("userId");
		JSONObject targetResponse = new JSONObject(targetLoginResponse);
		String targetSid = targetResponse.getString("sid");
		String targetUserId = targetResponse.getString("userId");
		//follow
		JSONObject followRequestParams = new JSONObject();
		followRequestParams.put("sid", sid);
		this.mockMvc.perform(put(FRIENDURL + "/" + targetUserId)
					.param("j", followRequestParams.toString()))
					.andDo(print())
					.andExpect(status().isOk());
		this.mockMvc.perform(get(FRIENDURL + "/" + targetUserId)
				.param("j", followRequestParams.toString()))
				.andDo(print())
				.andExpect(status().isOk());
		followRequestParams.put("sid", targetSid);
		this.mockMvc.perform(get(FRIENDURL + "/" + targetUserId)
				.param("j", followRequestParams.toString()))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
	@Test
	public void unFollowTest() throws Exception {
		String email = UUID.randomUUID().toString() + "@junit.com";
		String password = UUID.randomUUID().toString();
		String loginResponse = loginAndRegister(email, password);
		String targetemail = UUID.randomUUID().toString() + "@junit.com";
		String targetpassword = UUID.randomUUID().toString();
		String targetLoginResponse = loginAndRegister(targetemail, targetpassword);
		JSONObject response = new JSONObject(loginResponse);
		String sid = response.getString("sid");
		String userId = response.getString("userId");
		JSONObject targetResponse = new JSONObject(targetLoginResponse);
		String targetSid = targetResponse.getString("sid");
		String targetUserId = targetResponse.getString("userId");
		//follow
		JSONObject followRequestParams = new JSONObject();
		followRequestParams.put("sid", sid);
		this.mockMvc.perform(put(FRIENDURL + "/" + targetUserId)
					.param("j", followRequestParams.toString()))
					.andDo(print())
					.andExpect(status().isOk());
		//unfollow
		this.mockMvc.perform(delete(FRIENDURL + "/" + targetUserId)
					.param("j", followRequestParams.toString()))
					.andDo(print())
					.andExpect(status().isOk());
	}
	
	@Test
	public void postFeedTest() throws Exception {
		String email = UUID.randomUUID().toString() + "@junit.com";
		String password = UUID.randomUUID().toString();
		String loginResponse = loginAndRegister(email, password);
		JSONObject response = new JSONObject(loginResponse);
		String sid = response.getString("sid");
		String userId = response.getString("userId");
		//postFeed
		JSONObject postRequestParams = new JSONObject();
		postRequestParams.put("sid", sid);
		postRequestParams.put("content", "Dandelion is perfect");
		postRequestParams.put("imageURL", "www.google.com");
		postRequestParams.put("title", "Dandelion");
		this.mockMvc.perform(post(FEEDURL)
					.param("j", postRequestParams.toString()))
					.andDo(print())
					.andExpect(status().isOk());
	}
	@Test
	public void getTimelineTest() throws Exception {
		
		String email = UUID.randomUUID().toString() + "@junit.com";
		String password = UUID.randomUUID().toString();
		String loginResponse = loginAndRegister(email, password);
		String targetemail = UUID.randomUUID().toString() + "@junit.com";
		String targetpassword = UUID.randomUUID().toString();
		String targetLoginResponse = loginAndRegister(targetemail, targetpassword);
		JSONObject response = new JSONObject(loginResponse);
		String sid = response.getString("sid");
		String userId = response.getString("userId");
		JSONObject targetResponse = new JSONObject(targetLoginResponse);
		String targetSid = targetResponse.getString("sid");
		String targetUserId = targetResponse.getString("userId");
		//follow
		JSONObject followRequestParams = new JSONObject();
		followRequestParams.put("sid", sid);
		this.mockMvc.perform(put(FRIENDURL + "/" + targetUserId)
					.param("j", followRequestParams.toString()))
					.andDo(print())
					.andExpect(status().isOk());
		//postFeed
		JSONObject postRequestParams = new JSONObject();
		postRequestParams.put("sid", targetSid);
		postRequestParams.put("content", "Dandelion is perfect");
		postRequestParams.put("imageURL", "www.google.com");
		postRequestParams.put("title", "Dandelion");
		this.mockMvc.perform(post(FEEDURL)
					.param("j", postRequestParams.toString()))
					.andExpect(status().isOk());
		//getTimeline
		JSONObject getTimelineRequestParams = new JSONObject();
		getTimelineRequestParams.put("sid", sid);
		this.mockMvc.perform(get(TIMELINE + ACCOUNTURL + "/"  + userId)
					.param("j", getTimelineRequestParams.toString()))
					.andDo(print())
					.andExpect(status().isOk());
	}

	
	@Test
	public void SearchMerchantTest() throws Exception {
		String email = UUID.randomUUID().toString() + "@junit.com";
		String password = UUID.randomUUID().toString();
		String loginResponse = loginAndRegister(email, password);
		JSONObject response = new JSONObject(loginResponse);
		String sid = response.getString("sid");
		String userId = response.getString("userId");
		JSONObject searchUserRequestParams = new JSONObject();
		searchUserRequestParams.put("key", "1");
		searchUserRequestParams.put("sid", sid);
		this.mockMvc.perform(get("/Merchants")
					.param("j", searchUserRequestParams.toString()))
					.andDo(print())
					.andExpect(status().isOk());
	}
	
	@Test
	public void getMerchantTest() throws Exception {
		String email = UUID.randomUUID().toString() + "@junit.com";
		String password = UUID.randomUUID().toString();
		String loginResponse = loginAndRegister(email, password);
		JSONObject response = new JSONObject(loginResponse);
		String sid = response.getString("sid");
		String userId = response.getString("userId");
		JSONObject searchUserRequestParams = new JSONObject();
		searchUserRequestParams.put("key", "1");
		searchUserRequestParams.put("merchantId", "2001");
		searchUserRequestParams.put("sid", sid);
		String merchantsResponse = this.mockMvc.perform(get("/Merchants")
					.param("j", searchUserRequestParams.toString()))
					.andDo(print())
					.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
		JSONObject responseJson = new JSONObject(merchantsResponse);
		long id = responseJson.getJSONArray("merchantList").getJSONObject(0).getLong("useridfk");
		
		 this.mockMvc.perform(get("/Merchants/" + id)
				.param("j", searchUserRequestParams.toString()))
				.andDo(print())
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
	}
	
	
	@Test
	public void updateMerchantTest() throws Exception {
		String email = UUID.randomUUID().toString() + "@junit.com";
		String password = UUID.randomUUID().toString();
		String loginResponse = loginAndRegister(email, password);
		JSONObject response = new JSONObject(loginResponse);
		String sid = response.getString("sid");
		String userId = response.getString("userId");
		JSONObject searchUserRequestParams = new JSONObject();
		searchUserRequestParams.put("key", "1");
		searchUserRequestParams.put("sid", sid);
		String merchantsResponse = this.mockMvc.perform(get("/Merchants")
					.param("j", searchUserRequestParams.toString()))
					.andDo(print())
					.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
		JSONObject responseJson = new JSONObject(merchantsResponse);
		long id = responseJson.getJSONArray("merchantList").getJSONObject(0).getLong("useridfk");
		

			
		 
		 searchUserRequestParams.put("name", "cc");
		 this.mockMvc.perform(MockMvcRequestBuilders.put("/Merchants/" + id)
				.param("j", searchUserRequestParams.toString()))
				.andDo(print())
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		 
		 String merchantResponse = this.mockMvc.perform(MockMvcRequestBuilders.get("/Merchants/" + id)
					.param("j", searchUserRequestParams.toString()))
					.andDo(print())
					.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		 
		 Assert.assertEquals("cc", new JSONObject(merchantResponse).getString("name"));
	}
	
	
	
	
	
	
	@Test
	public void getMemberTest() throws Exception {
		String email = UUID.randomUUID().toString() + "@junit.com";
		String password = UUID.randomUUID().toString();
		String loginResponse = memberLoginAndRegister(email, password);
		JSONObject response = new JSONObject(loginResponse);
		String sid = response.getString("sid");
		String userId = response.getString("userId");
		JSONObject searchUserRequestParams = new JSONObject();
		searchUserRequestParams.put("key", "1");
		searchUserRequestParams.put("sid", sid);
		String memberResponse = this.mockMvc.perform(get("/Members/" + userId)
					.param("j", searchUserRequestParams.toString()))
					.andDo(print())
					.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

	}
	@Test
	public void updateMemberTest() throws Exception {
		String email = UUID.randomUUID().toString() + "@junit.com";
		String password = UUID.randomUUID().toString();
		String loginResponse = memberLoginAndRegister(email, password);
		JSONObject response = new JSONObject(loginResponse);
		String sid = response.getString("sid");
		String userId = response.getString("userId");
		JSONObject searchUserRequestParams = new JSONObject();
		searchUserRequestParams.put("key", "1");
		searchUserRequestParams.put("sid", sid);


		
		 searchUserRequestParams.put("name", "cc");
		 this.mockMvc.perform(MockMvcRequestBuilders.put("/Members/" + userId)
				.param("j", searchUserRequestParams.toString()))
				.andDo(print())
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		 
		String memberResponse = this.mockMvc.perform(get("/Members/" + userId)
				.param("j", searchUserRequestParams.toString()))
				.andDo(print())
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		 Assert.assertEquals("cc", new JSONObject(memberResponse).getString("name"));
	}
	
	
	
	
	
	
	
	
	
	//////////////////////////////
	public String loginAndRegister(String email, String password) throws Exception {
		JSONObject registerRequestParams = new JSONObject();
		registerRequestParams.put("email", email);
		registerRequestParams.put("password", password);
		registerRequestParams.put("accountType", 1);
		registerRequestParams.put("alias", UUID.randomUUID().toString());
		this.mockMvc.perform(post(REGISTERURL)
					.param("j", registerRequestParams.toString()))
					.andExpect(status().isOk());
		JSONObject loginRequestParams = new JSONObject();
		loginRequestParams.put("email", email);
		loginRequestParams.put("password", password);
		loginRequestParams.put("packageName", "com.dandelion.memberapp");
		loginRequestParams.put("identifier", UUID.randomUUID());
		String loginResponse = this.mockMvc.perform(post(LOGINURL)
					.param("j", loginRequestParams.toString()))
					.andExpect(status().isOk())
					.andReturn().getResponse().getContentAsString();
		return loginResponse;
	}
	public void AccountGetTest() throws Exception {
		this.mockMvc.perform(get("/Account/Test")
					.param("j", "8210")
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))
					.andDo(print())
					.andExpect(status().isOk());
	}
	public String memberLoginAndRegister(String email, String password) throws Exception {
		JSONObject registerRequestParams = new JSONObject();
		registerRequestParams.put("email", email);
		registerRequestParams.put("password", password);
		registerRequestParams.put("accountType", 0);
		registerRequestParams.put("alias", UUID.randomUUID().toString());
		this.mockMvc.perform(post(REGISTERURL)
					.param("j", registerRequestParams.toString()))
					.andExpect(status().isOk());
		JSONObject loginRequestParams = new JSONObject();
		loginRequestParams.put("email", email);
		loginRequestParams.put("password", password);
		loginRequestParams.put("packageName", "com.dandelion.memberapp");
		loginRequestParams.put("identifier", UUID.randomUUID());
		String loginResponse = this.mockMvc.perform(post(LOGINURL)
					.param("j", loginRequestParams.toString()))
					.andExpect(status().isOk())
					.andReturn().getResponse().getContentAsString();
		return loginResponse;
	}
	

	@Test
	public void getNotificationsTest() throws Exception {
		String email = UUID.randomUUID().toString() + "@junit.com";
		String password = UUID.randomUUID().toString();
		String loginResponse = loginAndRegister(email, password);
		String targetemail = UUID.randomUUID().toString() + "@junit.com";
		String targetpassword = UUID.randomUUID().toString();
		String targetLoginResponse = loginAndRegister(targetemail, targetpassword);
		JSONObject response = new JSONObject(loginResponse);
		String sid = response.getString("sid");
		String userId = response.getString("userId");
		JSONObject targetResponse = new JSONObject(targetLoginResponse);
		String targetSid = targetResponse.getString("sid");
		String targetUserId = targetResponse.getString("userId");
		//follow
		JSONObject followRequestParams = new JSONObject();
		followRequestParams.put("sid", sid);
		this.mockMvc.perform(put(FRIENDURL + "/" + targetUserId)
					.param("j", followRequestParams.toString()))
					.andDo(print())
					.andExpect(status().isOk());
		followRequestParams.put("sid", targetSid);
		this.mockMvc.perform(get("/Notifications/Accounts/" + targetUserId)
				.param("j", followRequestParams.toString()))
				.andDo(print())
				.andExpect(status().isOk());
	}
	@Test
	public void updateNotificationsTest() throws Exception {
		String email = UUID.randomUUID().toString() + "@junit.com";
		String password = UUID.randomUUID().toString();
		String loginResponse = loginAndRegister(email, password);
		String targetemail = UUID.randomUUID().toString() + "@junit.com";
		String targetpassword = UUID.randomUUID().toString();
		String targetLoginResponse = loginAndRegister(targetemail, targetpassword);
		JSONObject response = new JSONObject(loginResponse);
		String sid = response.getString("sid");
		String userId = response.getString("userId");
		JSONObject targetResponse = new JSONObject(targetLoginResponse);
		String targetSid = targetResponse.getString("sid");
		String targetUserId = targetResponse.getString("userId");
		//follow
		JSONObject followRequestParams = new JSONObject();
		followRequestParams.put("sid", sid);
		this.mockMvc.perform(put(FRIENDURL + "/" + targetUserId)
					.param("j", followRequestParams.toString()))
					.andDo(print())
					.andExpect(status().isOk());
		followRequestParams.put("sid", targetSid);
		
		String notificationList = this.mockMvc.perform(get("/Notifications/Accounts/" + targetUserId)
				.param("j", followRequestParams.toString()))
				.andDo(print())
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		Long notificationId = new JSONObject(notificationList).getJSONArray("notificationList").getJSONObject(0).getLong("id");
		followRequestParams.put("isRead", true);
		 this.mockMvc.perform(put("/Notifications/" + notificationId +  "/Accounts/" + targetUserId)
					.param("j", followRequestParams.toString()))
					.andDo(print())
					.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		 notificationList = this.mockMvc.perform(get("/Notifications/Accounts/" + targetUserId)
					.param("j", followRequestParams.toString()))
					.andDo(print())
					.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		Assert.assertEquals(true, new JSONObject(notificationList).getJSONArray("notificationList").getJSONObject(0).getBoolean("isread"));
	}
	
}
