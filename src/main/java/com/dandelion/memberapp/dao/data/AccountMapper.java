package com.dandelion.memberapp.dao.data;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.dandelion.memberapp.dao.model.User;
public interface AccountMapper {
	static final String USERBASERESULTMAP = "UserBaseResultMap";
	
	@Select("select * from tb_user t where t.UserEmail = #{email} limit 1")
	@ResultMap(USERBASERESULTMAP)
	User getUserByEmail(String email);
	@Select("select * from tb_user t where t.UserEmail = #{0} and t.Password = #{1} limit 1")
	@ResultMap(USERBASERESULTMAP)
	User getUserByEmailAndPassword(String email, String password);
	void insertUser(User user);
}
