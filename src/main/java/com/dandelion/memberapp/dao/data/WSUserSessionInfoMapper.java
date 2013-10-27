package com.dandelion.memberapp.dao.data;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.dandelion.memberapp.dao.model.Wsusersession;

public interface WSUserSessionInfoMapper {
	@Select("select ID from tb_wsusersession where UserIDFK=#{0} and DeviceIdentifier=#{1} and PackageName=#{2} limit 1")
	List<Wsusersession> getByAll(String userID, String deviceIdentifier, String packageName);

	@Insert("insert into tb_wsusersession (ID, SessionKey, UserIDFK,	DeviceIdentifier, PackageName) values " +
			"(#{id,jdbcType=CHAR}, #{sessionkey,jdbcType=INTEGER}, #{useridfk,jdbcType=CHAR}, " +
			"#{deviceidentifier,jdbcType=NVARCHAR},	#{packagename,jdbcType=NVARCHAR})")
	int login(Wsusersession sessionInfo);

	@Delete("delete from tb_wsusersession where ID=#{0}")
	int delete(String id);
	
	@Select("select  ID from tb_wsusersession where ID=#{0} limit 1")
	Wsusersession getSessionExist(UUID ID);
	
	@Select("select SessionKey from tb_wsusersession where ID=#{0}")
	Wsusersession getKeyByID(UUID ID);
}
