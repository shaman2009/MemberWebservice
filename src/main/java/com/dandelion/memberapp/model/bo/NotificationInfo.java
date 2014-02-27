package com.dandelion.memberapp.model.bo;

import java.util.Date;

import com.dandelion.memberapp.model.po.Member;

public class NotificationInfo {
	private Long id;
	private Long fromuseridfk;
	private Long touseridfk;
	private String content;
	private Boolean isread;
	private Boolean isdeleted;
	private Date createddate;
	private Date modifieddate;
	private Integer sort;
	private Member member;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getFromuseridfk() {
		return fromuseridfk;
	}
	public void setFromuseridfk(Long fromuseridfk) {
		this.fromuseridfk = fromuseridfk;
	}
	public Long getTouseridfk() {
		return touseridfk;
	}
	public void setTouseridfk(Long touseridfk) {
		this.touseridfk = touseridfk;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Boolean getIsread() {
		return isread;
	}
	public void setIsread(Boolean isread) {
		this.isread = isread;
	}
	public Boolean getIsdeleted() {
		return isdeleted;
	}
	public void setIsdeleted(Boolean isdeleted) {
		this.isdeleted = isdeleted;
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
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
}
