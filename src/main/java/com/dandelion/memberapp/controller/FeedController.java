package com.dandelion.memberapp.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.dandelion.memberapp.model.po.Feed;
import com.dandelion.memberapp.model.po.User;
import com.dandelion.memberapp.model.vo.FeedInfo;
import com.dandelion.memberapp.model.vo.FeedList;
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
	
	@RequestMapping(value = "/Accounts/{id}/Timeline", method = RequestMethod.GET) 
	public ResponseEntity<FeedList> getTimeline(@RequestParam(value = "j", required = true) String j, @PathVariable Long id) throws MemberAppException, JSONException {
		User user = userAuthentication.getCurrentUser();
		JSONObject requestJson = new JSONObject(j);
		Long sinceId = requestJson.optLong("sinceId");
		Long maxId = requestJson.optLong("maxId");
		Long limitCount = requestJson.optLong("limitCount");
		
		List<FeedInfo> feedInfoList = new ArrayList<FeedInfo>();
		List<Feed> feeds = feedService.getTimeline(user.getId(), sinceId, maxId, limitCount);
		
		for (Feed feed : feeds) {
			FeedInfo feedinfo = new FeedInfo();
			feedinfo.setId(feed.getId());
			feedinfo.setTitle(feed.getTitle());
			feedinfo.setUserId(feed.getUseridfk());
			feedinfo.setImageURL(feed.getImageurl());
			feedinfo.setDate(feed.getCreateddate().getTime());
			feedInfoList.add(feedinfo);
		}
		FeedList list = new FeedList();
		list.setList(feedInfoList);
		return new ResponseEntity<FeedList>(list, HttpStatus.OK);
	}
}
