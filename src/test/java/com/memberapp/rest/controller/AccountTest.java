package com.memberapp.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class AccountTest {
	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;
	private static final String REGISTERURL = "/Register";
	private static final String ACCOUNTURL = "/Accounts";
	private static final String LOGINURL = "/Login";

	@Before
	public void setup() {
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
	@Test
	public void UpdateUserTest() throws Exception {
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
		String loginResponse = this.mockMvc.perform(post(LOGINURL)
					.param("j", loginRequestParams.toString()))
					.andExpect(status().isOk())
					.andReturn().getResponse().getContentAsString();
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
		JSONObject response = new JSONObject(loginResponse);
		String sid = response.getString("sid");
		String userId = response.getString("userId");
		JSONObject updateUserRequestParams = new JSONObject();
		updateUserRequestParams.put("alias", "updateAliasTest");
		updateUserRequestParams.put("sid", sid);
		this.mockMvc.perform(get(ACCOUNTURL + "/" + userId)
					.param("j", updateUserRequestParams.toString()))
					.andDo(print())
					.andExpect(status().isOk());
	}

	public void AccountGetTest() throws Exception {
		this.mockMvc.perform(get("/Account/Test")
					.param("j", "8210")
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))
					.andDo(print())
					.andExpect(status().isOk());
	}
	
	
}
