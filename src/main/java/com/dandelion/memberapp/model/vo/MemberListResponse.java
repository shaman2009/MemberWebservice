package com.dandelion.memberapp.model.vo;

import java.util.ArrayList;
import java.util.List;

import com.dandelion.memberapp.model.bo.MemberInfo;

public class MemberListResponse {
	private List<MemberInfo> memberList;
	public MemberListResponse() {
		memberList = new ArrayList<MemberInfo>();
	}
	public List<MemberInfo> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<MemberInfo> memberList) {
		this.memberList = memberList;
	}

	
	
	
	
}
