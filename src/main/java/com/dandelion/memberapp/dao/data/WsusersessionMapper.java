package com.dandelion.memberapp.dao.data;

import com.dandelion.memberapp.model.po.Wsusersession;
import com.dandelion.memberapp.model.po.WsusersessionExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WsusersessionMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_wsusersession
	 * @mbggenerated  Sun Nov 24 23:38:35 CST 2013
	 */
	int countByExample(WsusersessionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_wsusersession
	 * @mbggenerated  Sun Nov 24 23:38:35 CST 2013
	 */
	int deleteByExample(WsusersessionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_wsusersession
	 * @mbggenerated  Sun Nov 24 23:38:35 CST 2013
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_wsusersession
	 * @mbggenerated  Sun Nov 24 23:38:35 CST 2013
	 */
	int insert(Wsusersession record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_wsusersession
	 * @mbggenerated  Sun Nov 24 23:38:35 CST 2013
	 */
	int insertSelective(Wsusersession record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_wsusersession
	 * @mbggenerated  Sun Nov 24 23:38:35 CST 2013
	 */
	List<Wsusersession> selectByExample(WsusersessionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_wsusersession
	 * @mbggenerated  Sun Nov 24 23:38:35 CST 2013
	 */
	Wsusersession selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_wsusersession
	 * @mbggenerated  Sun Nov 24 23:38:35 CST 2013
	 */
	int updateByExampleSelective(@Param("record") Wsusersession record,
			@Param("example") WsusersessionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_wsusersession
	 * @mbggenerated  Sun Nov 24 23:38:35 CST 2013
	 */
	int updateByExample(@Param("record") Wsusersession record,
			@Param("example") WsusersessionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_wsusersession
	 * @mbggenerated  Sun Nov 24 23:38:35 CST 2013
	 */
	int updateByPrimaryKeySelective(Wsusersession record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_wsusersession
	 * @mbggenerated  Sun Nov 24 23:38:35 CST 2013
	 */
	int updateByPrimaryKey(Wsusersession record);
}