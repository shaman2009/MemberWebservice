package com.dandelion.memberapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dandelion.memberapp.dao.data.FeedMapper;
import com.dandelion.memberapp.dao.data.TimelineMapper;
import com.dandelion.memberapp.exception.MemberAppException;
import com.dandelion.memberapp.model.bo.FeedInfo;
import com.dandelion.memberapp.model.po.Feed;
import com.dandelion.memberapp.model.po.FeedExample;
import com.dandelion.memberapp.model.vo.FeedListResponse;
import com.dandelion.memberapp.model.vo.MerchantDetailInfoResponse;

@Service
public class FeedService {
	@Autowired
	private TimelineMapper timelineMapper;
	@Autowired
	private AccountService accountService;
	@Autowired
	private FeedMapper feedMapper;
	
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
	public FeedListResponse getTimeline(Long userId, Long sinceId, Long maxId, Long limitCount) throws MemberAppException {
		if(sinceId == null || sinceId.equals(0L)) {
			sinceId = 1L;
		}
		if(maxId == null || maxId.equals(0L)) {
			maxId = 9999999L;
		}
		if(limitCount == null || limitCount.equals(0L)) {
			limitCount = 30L;
		}
		FeedListResponse feedListResponse = new FeedListResponse();
		List<FeedInfo> feedInfoList = new ArrayList<FeedInfo>();
		List<Feed> feeds = timelineMapper.getTimeline(userId, sinceId, maxId, limitCount);
		for (Feed feed : feeds) {
			long id = feed.getUseridfk();
			FeedInfo feedinfo = new FeedInfo();
			feedinfo.setId(feed.getId());
			feedinfo.setTitle(feed.getTitle());
			feedinfo.setUserId(id);
			feedinfo.setImageURL(feed.getImageurl());
			feedinfo.setDate(feed.getCreateddate().getTime());
			feedinfo.setContent(feed.getContent());
			MerchantDetailInfoResponse merchantDetailInfoResponse = accountService.getMerchant(id);
			feedinfo.setMerchantDetailInfoResponse(merchantDetailInfoResponse);
			feedInfoList.add(feedinfo);
		}
		feedListResponse.setFeedList(feedInfoList);
		return feedListResponse;
	}
	
	public FeedListResponse getMyPosts(Long userId, Long sinceId, Long maxId, Long limitCount) throws MemberAppException {
		if(sinceId == null || sinceId.equals(0L)) {
			sinceId = 1L;
		}
		if(maxId == null || maxId.equals(0L)) {
			maxId = 9999999L;
		}
		if(limitCount == null || limitCount.equals(0L)) {
			limitCount = 30L;
		}
		
		FeedListResponse feedListResponse = new FeedListResponse();
		List<FeedInfo> feedInfoList = new ArrayList<FeedInfo>();
		
		FeedExample feedExample = new FeedExample(); 
		feedExample.createCriteria().andUseridfkEqualTo(userId);
		feedExample.setOrderByClause("createddate desc");
		List<Feed> feeds = feedMapper.selectByExample(feedExample);
		for (Feed feed : feeds) {
			long id = feed.getUseridfk();
			FeedInfo feedinfo = new FeedInfo();
			feedinfo.setId(feed.getId());
			feedinfo.setTitle(feed.getTitle());
			feedinfo.setUserId(id);
			feedinfo.setImageURL(feed.getImageurl());
			feedinfo.setDate(feed.getCreateddate().getTime());
			feedinfo.setContent(feed.getContent());
			MerchantDetailInfoResponse merchantDetailInfoResponse = accountService.getMerchant(id);
			feedinfo.setMerchantDetailInfoResponse(merchantDetailInfoResponse);
			feedInfoList.add(feedinfo);
		}
		feedListResponse.setFeedList(feedInfoList);
		return feedListResponse;
	}
}
