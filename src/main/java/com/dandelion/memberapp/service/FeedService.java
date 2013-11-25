package com.dandelion.memberapp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dandelion.memberapp.dao.data.TimelineMapper;
import com.dandelion.memberapp.model.po.Feed;

@Service
public class FeedService {
	@Autowired
	private TimelineMapper timelineMapper;
	
	public int publishFeed(Long userId, String content, String imageURL, String title) {
		Feed feed = new Feed();
		feed.setUseridfk(userId);
		feed.setContent(content);
		feed.setImageurl(imageURL);
		feed.setTitle(title);
		feed.setCreateddate(new Date());
		feed.setModifieddate(new Date());
		return timelineMapper.insertFeed(feed);
	}
	public List<Feed> getTimeline(Long userId, Long sinceId, Long maxId, Long limitCount) {
		if(sinceId == null) {
			sinceId = 1L;
		}
		if(maxId == null) {
			sinceId = 9999999L;
		}
		if(limitCount == null) {
			limitCount = 30L;
		}
		List<Feed> feeds = timelineMapper.getTimeline(userId, sinceId, maxId, limitCount);
		return feeds;
	}
}
