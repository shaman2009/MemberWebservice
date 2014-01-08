package com.dandelion.memberapp.model.bo;

import com.dandelion.memberapp.model.vo.MerchantDetailInfoResponse;

public class FeedInfo {
	private Long id;
	private String title;
	private Long userId;
	private String imageURL;
	private Long date;
	private String Content;
	private MerchantDetailInfoResponse merchantDetailInfoResponse;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public Long getDate() {
		return date;
	}
	public void setDate(Long date) {
		this.date = date;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public MerchantDetailInfoResponse getMerchantDetailInfoResponse() {
		return merchantDetailInfoResponse;
	}
	public void setMerchantDetailInfoResponse(
			MerchantDetailInfoResponse merchantDetailInfoResponse) {
		this.merchantDetailInfoResponse = merchantDetailInfoResponse;
	}
	
}
