package com.dandelion.memberapp.model.po;

import java.util.Date;

public class Emailbean {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tb_emailbean.ID
	 * @mbggenerated  Tue Dec 31 16:48:21 CST 2013
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tb_emailbean.token
	 * @mbggenerated  Tue Dec 31 16:48:21 CST 2013
	 */
	private String token;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tb_emailbean.expire
	 * @mbggenerated  Tue Dec 31 16:48:21 CST 2013
	 */
	private Date expire;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tb_emailbean.ID
	 * @return  the value of tb_emailbean.ID
	 * @mbggenerated  Tue Dec 31 16:48:21 CST 2013
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tb_emailbean.ID
	 * @param id  the value for tb_emailbean.ID
	 * @mbggenerated  Tue Dec 31 16:48:21 CST 2013
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tb_emailbean.token
	 * @return  the value of tb_emailbean.token
	 * @mbggenerated  Tue Dec 31 16:48:21 CST 2013
	 */
	public String getToken() {
		return token;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tb_emailbean.token
	 * @param token  the value for tb_emailbean.token
	 * @mbggenerated  Tue Dec 31 16:48:21 CST 2013
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tb_emailbean.expire
	 * @return  the value of tb_emailbean.expire
	 * @mbggenerated  Tue Dec 31 16:48:21 CST 2013
	 */
	public Date getExpire() {
		return expire;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tb_emailbean.expire
	 * @param expire  the value for tb_emailbean.expire
	 * @mbggenerated  Tue Dec 31 16:48:21 CST 2013
	 */
	public void setExpire(Date expire) {
		this.expire = expire;
	}
}