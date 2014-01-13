package com.dandelion.memberapp.model.vo;

import java.util.ArrayList;
import java.util.List;

public class MerchantDetailListResponse {
	private List<MerchantDetailInfoResponse> merchantList;
	public MerchantDetailListResponse() {
		merchantList = new ArrayList<MerchantDetailInfoResponse>();
	}
	public List<MerchantDetailInfoResponse> getMerchantList() {
		return merchantList;
	}
	public void setMerchantList(List<MerchantDetailInfoResponse> merchantList) {
		this.merchantList = merchantList;
	}

}
