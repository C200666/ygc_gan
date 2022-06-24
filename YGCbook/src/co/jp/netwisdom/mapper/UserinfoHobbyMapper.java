package co.jp.netwisdom.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import co.jp.netwisdom.entity.UserinfoHobby;

public interface UserinfoHobbyMapper {

	//执行查询
	public  List<UserinfoHobby> UserinfoHobbySearch(@Param("username")String username,@Param("password")String password,@Param("sex")String sex,@Param("major")String major,@Param("hobby")String hobby );
	//根据Username执行更新
	public  UserinfoHobby upUserinfoHobby(String username);

	public  List<UserinfoHobby> UserSearch(@Param("username")String username,@Param("password")String password,@Param("sex")String sex,@Param("major")String major );
}