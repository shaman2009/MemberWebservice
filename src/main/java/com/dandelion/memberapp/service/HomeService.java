package com.dandelion.memberapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dandelion.memberapp.dao.data.UserMapper;
import com.dandelion.memberapp.model.po.User;


@Service
public class HomeService {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeService.class);
	
	@Autowired
	private UserMapper userMapper;
	
	
	
	public void testNewBae() {
		User user = userMapper.selectByPrimaryKey(447L);

	}
}
