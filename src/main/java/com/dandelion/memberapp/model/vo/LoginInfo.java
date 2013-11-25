package com.dandelion.memberapp.model.vo;

public class LoginInfo {

	private String sid;
	private int skey;
	private Long userId;
	private int accountType;
	
	public int getAccountType() {
		return accountType;
	}
	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public int getSkey() {
		return skey;
	}
	public void setSkey(int skey) {
		this.skey = skey;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
