package com.dandelion.memberapp.model.vo;

import java.util.ArrayList;
import java.util.List;

import com.dandelion.memberapp.model.po.Merchant;


public class MerchantInfoListResponse {
	List<Merchant> merchantList;
	
	public MerchantInfoListResponse() {
		merchantList = new ArrayList<Merchant>();
	}

	public List<Merchant> getMerchantList() {
		return merchantList;
	}

	public void setMerchantList(List<Merchant> merchantList) {
		this.merchantList = merchantList;
	}
	
}
