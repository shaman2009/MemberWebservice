package com.dandelion.memberapp.model.po;

public class Friend {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tb_friend.ID
	 * @mbggenerated  Mon Nov 25 11:34:32 CST 2013
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tb_friend.fromUserIDFK
	 * @mbggenerated  Mon Nov 25 11:34:32 CST 2013
	 */
	private Long fromuseridfk;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tb_friend.targetUserIDFK
	 * @mbggenerated  Mon Nov 25 11:34:32 CST 2013
	 */
	private Long targetuseridfk;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tb_friend.ID
	 * @return  the value of tb_friend.ID
	 * @mbggenerated  Mon Nov 25 11:34:32 CST 2013
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tb_friend.ID
	 * @param id  the value for tb_friend.ID
	 * @mbggenerated  Mon Nov 25 11:34:32 CST 2013
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tb_friend.fromUserIDFK
	 * @return  the value of tb_friend.fromUserIDFK
	 * @mbggenerated  Mon Nov 25 11:34:32 CST 2013
	 */
	public Long getFromuseridfk() {
		return fromuseridfk;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tb_friend.fromUserIDFK
	 * @param fromuseridfk  the value for tb_friend.fromUserIDFK
	 * @mbggenerated  Mon Nov 25 11:34:32 CST 2013
	 */
	public void setFromuseridfk(Long fromuseridfk) {
		this.fromuseridfk = fromuseridfk;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tb_friend.targetUserIDFK
	 * @return  the value of tb_friend.targetUserIDFK
	 * @mbggenerated  Mon Nov 25 11:34:32 CST 2013
	 */
	public Long getTargetuseridfk() {
		return targetuseridfk;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tb_friend.targetUserIDFK
	 * @param targetuseridfk  the value for tb_friend.targetUserIDFK
	 * @mbggenerated  Mon Nov 25 11:34:32 CST 2013
	 */
	public void setTargetuseridfk(Long targetuseridfk) {
		this.targetuseridfk = targetuseridfk;
	}
}