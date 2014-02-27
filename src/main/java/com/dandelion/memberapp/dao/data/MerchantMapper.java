package com.dandelion.memberapp.dao.data;

import com.dandelion.memberapp.model.po.Merchant;
import com.dandelion.memberapp.model.po.MerchantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_merchant
	 * @mbggenerated  Thu Jan 16 19:58:43 CST 2014
	 */
	int countByExample(MerchantExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_merchant
	 * @mbggenerated  Thu Jan 16 19:58:43 CST 2014
	 */
	int deleteByExample(MerchantExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_merchant
	 * @mbggenerated  Thu Jan 16 19:58:43 CST 2014
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_merchant
	 * @mbggenerated  Thu Jan 16 19:58:43 CST 2014
	 */
	int insert(Merchant record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_merchant
	 * @mbggenerated  Thu Jan 16 19:58:43 CST 2014
	 */
	int insertSelective(Merchant record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_merchant
	 * @mbggenerated  Thu Jan 16 19:58:43 CST 2014
	 */
	List<Merchant> selectByExample(MerchantExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_merchant
	 * @mbggenerated  Thu Jan 16 19:58:43 CST 2014
	 */
	Merchant selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_merchant
	 * @mbggenerated  Thu Jan 16 19:58:43 CST 2014
	 */
	int updateByExampleSelective(@Param("record") Merchant record,
			@Param("example") MerchantExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_merchant
	 * @mbggenerated  Thu Jan 16 19:58:43 CST 2014
	 */
	int updateByExample(@Param("record") Merchant record,
			@Param("example") MerchantExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_merchant
	 * @mbggenerated  Thu Jan 16 19:58:43 CST 2014
	 */
	int updateByPrimaryKeySelective(Merchant record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_merchant
	 * @mbggenerated  Thu Jan 16 19:58:43 CST 2014
	 */
	int updateByPrimaryKey(Merchant record);
}