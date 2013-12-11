package com.dandelion.memberapp.dao.data;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.dandelion.memberapp.model.po.Feed;

public interface TimelineMapper {
	
	int insertFeed(Feed feed);
	
	@Select("select * from tb_feed f where f.id in ( select targetuseridfk from tb_friend t where fromuseridfk  = #{0}) and f.id >= #{1} and f.id < #{2} ;")
	@ResultMap("FeedBaseResultMap")
	List<Feed> getTimeline(Long userId, Long sinceId, Long maxId, Long limitCount);
	
	
}
