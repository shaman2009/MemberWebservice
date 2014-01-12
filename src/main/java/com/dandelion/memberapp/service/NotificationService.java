package com.dandelion.memberapp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dandelion.memberapp.dao.data.NotificationMapper;
import com.dandelion.memberapp.model.po.Notification;
import com.dandelion.memberapp.model.po.NotificationExample;
import com.dandelion.memberapp.model.vo.NotificationListResponse;

@Service
public class NotificationService {
	@Autowired
	private NotificationMapper notificationMapper;
	
	
	
	public void addNotification(Long fromUserId, Long toUserId, String content, int sort) {
		Date d = new Date();
		Notification notification = new Notification();
		notification.setFromuseridfk(fromUserId);
		notification.setTouseridfk(toUserId);
		notification.setSort(sort);
		notification.setContent(content);
		notification.setCreateddate(d);
		notification.setModifieddate(d);
		notificationMapper.insertSelective(notification);
	}

	public NotificationListResponse getNotifications(Long userId) {
		NotificationExample example = new NotificationExample();
		example.createCriteria().andTouseridfkEqualTo(userId).andIsdeletedEqualTo(false);
		List<Notification> notificationList = notificationMapper.selectByExample(example);
		NotificationListResponse notificationListResponse = new NotificationListResponse();
		notificationListResponse.setNotificationList(notificationList);
		
		
		
		
		return notificationListResponse;
	}

	public void updateNotifications(Notification notification) {
		notificationMapper.updateByPrimaryKeySelective(notification);
	}
}
