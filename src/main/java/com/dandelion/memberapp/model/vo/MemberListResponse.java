package com.dandelion.memberapp.model.vo;

import java.util.ArrayList;
import java.util.List;

import com.dandelion.memberapp.model.po.Member;

public class MemberListResponse {
	private List<Member> memberList;
	public MemberListResponse() {
		memberList = new ArrayList<Member>();
	}
	public List<Member> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}
	
	
	
	
}
