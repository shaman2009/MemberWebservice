package com.dandelion.memberapp.dao.data;

import java.util.UUID;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dandelion.memberapp.dao.model.EmailBean;
import com.dandelion.memberapp.dao.model.User;
public interface AccountMapper {
	static final String USERBASERESULTMAP = "UserBaseResultMap";
	
	@Select("select * from tb_user t where t.UserEmail = #{email} limit 1")
	@ResultMap(USERBASERESULTMAP)
	User getUserByEmail(String email);
	
	@Select("select * from tb_user t where t.UserEmail = #{0} and t.Password = #{1} limit 1")
	@ResultMap(USERBASERESULTMAP)
	User getUserByEmailAndPassword(String email, String password);
	
	@Select("select  * from tb_user as U "
			+ "inner join tb_wsusersession as WS on WS.UserIDFK = U.ID "
			+ "where WS.ID = #{0}")
	@ResultMap(USERBASERESULTMAP)
	User getBySessionID(String sid);
	
	
	@Select("select * from tb_emailbean as u where u.id = #{0} ")
	EmailBean getEmailBean(String id);
	
	@Select("select * from tb_emailbean where token = #{0} ")
	EmailBean getEmailBeanByToken(String token);
	
	@Insert("insert into tb_emailbean(id,token,expire) values (#{id}, #{token}, #{expire})")
	int insert(EmailBean emailbean);
	
	@Update("update tb_emailbean set token = #{token}, expire = #{expire} where id = #{id}")
	int update(EmailBean emailBean);
	
	@Delete("delete from tb_emailbean where id = #{0}")
	int delete(String id);
	
	void updateUserInfo(User user);
	
	void insertUser(User user);
}