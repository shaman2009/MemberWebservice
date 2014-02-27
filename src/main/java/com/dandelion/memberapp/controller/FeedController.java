package com.dandelion.memberapp.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dandelion.memberapp.exception.MemberAppException;
import com.dandelion.memberapp.interceptors.UserAuthentication;
import com.dandelion.memberapp.model.po.User;
import com.dandelion.memberapp.model.vo.FeedListResponse;
import com.dandelion.memberapp.model.vo.ResponseResult;
import com.dandelion.memberapp.service.FeedService;

@Controller
public class FeedController {
	@Autowired
	private UserAuthentication userAuthentication;
	@Autowired
	private FeedService feedService;
	
	
	@RequestMapping(value = "/Feeds", method = RequestMethod.POST) 
	public ResponseEntity<ResponseResult> publishFeed(@RequestParam(value = "j", required = true) String j) throws MemberAppException, JSONException {
		User user = userAuthentication.getCurrentUser();
		JSONObject requestJson = new JSONObject(j);
		String content = requestJson.optString("content");
		String imageURL = requestJson.optString("imageURL");
		String title = requestJson.optString("title");
		feedService.publishFeed(user.getId(), content, imageURL, title);
		
		return new ResponseEntity<ResponseResult>(HttpStatus.OK);
	}		
	
	@RequestMapping(value = "/Timeline", method = RequestMethod.GET) 
	public ResponseEntity<FeedListResponse> getTimeline(@RequestParam(value = "j", required = true) String j) throws MemberAppException, JSONException {
		User user = userAuthentication.getCurrentUser();
		JSONObject requestJson = new JSONObject(j);
		Long sinceId = requestJson.optLong("sinceId");
		Long maxId = requestJson.optLong("maxId");
		Long limitCount = requestJson.optLong("limitCount");
		FeedListResponse feedListResponse = feedService.getTimeline(user.getId(), sinceId, maxId, limitCount);
		return new ResponseEntity<FeedListResponse>(feedListResponse, HttpStatus.OK);
	}
	@RequestMapping(value = "/MyPosts", method = RequestMethod.GET) 
	public ResponseEntity<FeedListResponse> getMyPosts(@RequestParam(value = "j", required = true) String j) throws MemberAppException, JSONException {
		User user = userAuthentication.getCurrentUser();
		JSONObject requestJson = new JSONObject(j);
		Long sinceId = requestJson.optLong("sinceId");
		Long maxId = requestJson.optLong("maxId");
		Long limitCount = requestJson.optLong("limitCount");
		FeedListResponse feedListResponse = feedService.getMyPosts(user.getId(), sinceId, maxId, limitCount);
		return new ResponseEntity<FeedListResponse>(feedListResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/MerchantPosts/{id}", method = RequestMethod.GET) 
	public ResponseEntity<FeedListResponse> getMerchantPosts(@RequestParam(value = "j", required = true) String j, @PathVariable Long id) throws MemberAppException, JSONException {
		JSONObject requestJson = new JSONObject(j);
		Long sinceId = requestJson.optLong("sinceId");
		Long maxId = requestJson.optLong("maxId");
		Long limitCount = requestJson.optLong("limitCount");
		FeedListResponse feedListResponse = feedService.getMyPosts(id, sinceId, maxId, limitCount);
		return new ResponseEntity<FeedListResponse>(feedListResponse, HttpStatus.OK);
	}
}
