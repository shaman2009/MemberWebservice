package com.dandelion.memberapp.model.bo;

import java.util.Date;

/**
 * Return API MyMembers
 * @author FengxiangZhu
 *
 */
public class MemberInfo {
	private Long id;
	private Long useridfk;
	private String avatarurl;
	private String backgroundurl;
	private String name;
	private Integer sex;
	private Date birthday;
	private String address;
	private String phone;
	private String introduction;
	private Date createddate;
	private Date modifieddate;
	private Long friendId;
	private boolean ismember;
	private Long amount;
	private Long amountcount;
	private Long score;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUseridfk() {
		return useridfk;
	}
	public void setUseridfk(Long useridfk) {
		this.useridfk = useridfk;
	}
	public String getAvatarurl() {
		return avatarurl;
	}
	public void setAvatarurl(String avatarurl) {
		this.avatarurl = avatarurl;
	}
	public String getBackgroundurl() {
		return backgroundurl;
	}
	public void setBackgroundurl(String backgroundurl) {
		this.backgroundurl = backgroundurl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	public Date getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}
	public Long getFriendId() {
		return friendId;
	}
	public void setFriendId(Long friendId) {
		this.friendId = friendId;
	}
	public boolean isIsmember() {
		return ismember;
	}
	public void setIsmember(boolean ismember) {
		this.ismember = ismember;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Long getAmountcount() {
		return amountcount;
	}
	public void setAmountcount(Long amountcount) {
		this.amountcount = amountcount;
	}
	public Long getScore() {
		return score;
	}
	public void setScore(Long score) {
		this.score = score;
	}
	
	
}
