package com.dandelion.memberapp.model.vo;

import java.util.Date;

public class UserInfo {
	private Long id;
	private String alias;
	private String useremail;
	private Date birthday;
	private Boolean gender;
	private String avatar;
	private Integer friendcount;
	private Integer fancount;
	private Integer followcount;
	private Integer articlecount;
	private String backgroundurl;
	private String phonenumber;
	private Integer accounttype;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Integer getFriendcount() {
		return friendcount;
	}
	public void setFriendcount(Integer friendcount) {
		this.friendcount = friendcount;
	}
	public Integer getFancount() {
		return fancount;
	}
	public void setFancount(Integer fancount) {
		this.fancount = fancount;
	}
	public Integer getFollowcount() {
		return followcount;
	}
	public void setFollowcount(Integer followcount) {
		this.followcount = followcount;
	}
	public Integer getArticlecount() {
		return articlecount;
	}
	public void setArticlecount(Integer articlecount) {
		this.articlecount = articlecount;
	}
	public String getBackgroundurl() {
		return backgroundurl;
	}
	public void setBackgroundurl(String backgroundurl) {
		this.backgroundurl = backgroundurl;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Integer getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(Integer accounttype) {
		this.accounttype = accounttype;
	}
	
}
