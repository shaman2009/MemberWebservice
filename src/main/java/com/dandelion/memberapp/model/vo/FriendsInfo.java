package com.dandelion.memberapp.model.vo;

import java.util.List;

public class FriendsInfo {
	List<UserInfo> voFollowings;
	List<UserInfo> voFollowers;
	public List<UserInfo> getVoFollowings() {
		return voFollowings;
	}
	public void setVoFollowings(List<UserInfo> voFollowings) {
		this.voFollowings = voFollowings;
	}
	public List<UserInfo> getVoFollowers() {
		return voFollowers;
	}
	public void setVoFollowers(List<UserInfo> voFollowers) {
		this.voFollowers = voFollowers;
	}
	
}
