package com.dandelion.memberapp.model.vo;

import java.util.ArrayList;
import java.util.List;

import com.dandelion.memberapp.model.bo.NotificationInfo;

public class NotificationListResponse {
	List<NotificationInfo> notificationList;
	public NotificationListResponse() {
		notificationList = new ArrayList<NotificationInfo>();
	}
	public List<NotificationInfo> getNotificationList() {
		return notificationList;
	}
	public void setNotificationList(List<NotificationInfo> notificationList) {
		this.notificationList = notificationList;
	}
	
}
