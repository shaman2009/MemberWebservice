package com.dandelion.memberapp.model.vo;

import java.util.ArrayList;
import java.util.List;

import com.dandelion.memberapp.model.bo.MerchantMemberInfo;

public class MerchantDetailListResponse {
	private List<MerchantMemberInfo> merchantList;
	public MerchantDetailListResponse() {
		merchantList = new ArrayList<MerchantMemberInfo>();
	}
	public List<MerchantMemberInfo> getMerchantList() {
		return merchantList;
	}
	public void setMerchantList(List<MerchantMemberInfo> merchantList) {
		this.merchantList = merchantList;
	}

}
