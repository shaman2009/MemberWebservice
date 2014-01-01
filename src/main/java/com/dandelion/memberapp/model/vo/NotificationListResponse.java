package com.dandelion.memberapp.model.vo;

import java.util.ArrayList;
import java.util.List;

import com.dandelion.memberapp.model.po.Notification;

public class NotificationListResponse {
	List<Notification> notificationList;
	public NotificationListResponse() {
		notificationList = new ArrayList<Notification>();
	}
	public List<Notification> getNotificationList() {
		return notificationList;
	}
	public void setNotificationList(List<Notification> notificationList) {
		this.notificationList = notificationList;
	}
	
}
