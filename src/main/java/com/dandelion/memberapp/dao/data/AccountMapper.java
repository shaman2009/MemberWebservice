package com.dandelion.memberapp.dao.data;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dandelion.memberapp.model.po.Emailbean;
import com.dandelion.memberapp.model.po.Friend;
import com.dandelion.memberapp.model.po.User;
public interface AccountMapper {
	public static final String USERBASERESULTMAP = "UserBaseResultMap";
	public static final String FRIENDBASERESULTMAP = "FriendBaseResultMap";
	
	
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
	Emailbean getEmailBean(Long id);
	
	@Select("select * from tb_emailbean where token = #{0} ")
	Emailbean getEmailBeanByToken(String token);
	
	@Insert("insert into tb_emailbean(id,token,expire) values (#{id}, #{token}, #{expire})")
	int insert(Emailbean emailbean);
	
	@Update("update tb_emailbean set token = #{token}, expire = #{expire} where id = #{id}")
	int update(Emailbean emailBean);
	
	@Delete("delete from tb_emailbean where id = #{0}")
	int delete(Long id);
	
	@Select("select * from tb_user as U " + "where ID = #{0}")
	@ResultMap(USERBASERESULTMAP)
	User getUserByID(Long userID);
	
	@Update("update tb_user " +
			"set Password = #{1} where ID = #{0}")
	int updatePass(Long id, String password);
	
	void updateUserInfo(User user);
	
	void insertUser(User user);
	
	@Select("select * from tb_user t where t.Alias like #{0} limit 30")
	@ResultMap(USERBASERESULTMAP)
	List<User> searchUser(String key);
	
	@Select("select * from tb_friend where fromuseridfk = #{0} and targetuseridfk = #{1}")
	@ResultMap(FRIENDBASERESULTMAP)
	List<Friend> selectFriend(Long fromUserId, Long targetUserId);
	
	@Select("select * from tb_friend t inner join tb_user b on t.targetuseridfk = b.id where fromuseridfk = #{0}")
	@ResultMap(USERBASERESULTMAP)
	List<User> selectFollowings(Long userId);
	
	@Select("select * from tb_friend t inner join tb_user b on t.fromuseridfk = b.id where targetuseridfk = #{0}")
	@ResultMap(USERBASERESULTMAP)
	List<User> selectFollowers(Long userId);
	
	int follow(Friend friend);
	
	//SET SQL_SAFE_UPDATES=0;
	@Delete("delete from tb_friend where fromuseridfk = #{0} and targetuseridfk = #{1}")
	int deleteFriend(Long fromUserId, Long targetUserId);
}
