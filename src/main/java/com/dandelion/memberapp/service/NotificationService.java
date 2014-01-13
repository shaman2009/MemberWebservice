package com.dandelion.memberapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dandelion.memberapp.dao.data.NotificationMapper;
import com.dandelion.memberapp.model.bo.NotificationInfo;
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
		example.createCriteria().andTouseridfkEqualTo(userId).andIsdeletedEqualTo(false).andIsreadEqualTo(false);
		List<NotificationInfo> notificationInfoList = new ArrayList<NotificationInfo>();
		List<Notification> notificationList = notificationMapper.selectByExample(example);
		for (Notification notification : notificationList) {
			NotificationInfo notificationInfo = new NotificationInfo();
			notificationInfo.setId(notification.getId());
			notificationInfo.setFromuseridfk(notification.getFromuseridfk());
			notificationInfo.setTouseridfk(notification.getTouseridfk());
			notificationInfo.setContent(notification.getContent());
			notificationInfo.setIsread(notification.getIsread());
			notificationInfo.setIsdeleted(notification.getIsdeleted());
			notificationInfo.setCreateddate(notification.getCreateddate());
			notificationInfo.setModifieddate(notification.getModifieddate());
			notificationInfo.setSort(notification.getSort());
			notificationInfoList.add(notificationInfo);
		}
		
		NotificationListResponse notificationListResponse = new NotificationListResponse();
		notificationListResponse.setNotificationList(notificationInfoList);
		
		return notificationListResponse;
	}

	public void updateNotifications(Notification notification) {
		notificationMapper.updateByPrimaryKeySelective(notification);
	}
}
