package com.dandelion.memberapp.dao.data;

import com.dandelion.memberapp.model.po.User;
import com.dandelion.memberapp.model.po.UserExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user
	 * @mbggenerated  Thu Jan 16 19:58:43 CST 2014
	 */
	int countByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user
	 * @mbggenerated  Thu Jan 16 19:58:43 CST 2014
	 */
	int deleteByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user
	 * @mbggenerated  Thu Jan 16 19:58:43 CST 2014
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user
	 * @mbggenerated  Thu Jan 16 19:58:43 CST 2014
	 */
	int insert(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user
	 * @mbggenerated  Thu Jan 16 19:58:43 CST 2014
	 */
	int insertSelective(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user
	 * @mbggenerated  Thu Jan 16 19:58:43 CST 2014
	 */
	List<User> selectByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user
	 * @mbggenerated  Thu Jan 16 19:58:43 CST 2014
	 */
	User selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user
	 * @mbggenerated  Thu Jan 16 19:58:43 CST 2014
	 */
	int updateByExampleSelective(@Param("record") User record,
			@Param("example") UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user
	 * @mbggenerated  Thu Jan 16 19:58:43 CST 2014
	 */
	int updateByExample(@Param("record") User record,
			@Param("example") UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user
	 * @mbggenerated  Thu Jan 16 19:58:43 CST 2014
	 */
	int updateByPrimaryKeySelective(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user
	 * @mbggenerated  Thu Jan 16 19:58:43 CST 2014
	 */
	int updateByPrimaryKey(User record);
}