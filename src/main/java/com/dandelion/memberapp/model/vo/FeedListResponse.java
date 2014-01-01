package com.dandelion.memberapp.model.vo;

import java.util.ArrayList;
import java.util.List;

import com.dandelion.memberapp.model.bo.FeedInfo;

public class FeedListResponse {
	List<FeedInfo> feedList;

	public FeedListResponse() {
		feedList = new ArrayList<FeedInfo>();
	}

	public List<FeedInfo> getFeedList() {
		return feedList;
	}

	public void setFeedList(List<FeedInfo> feedList) {
		this.feedList = feedList;
	}
	
}
