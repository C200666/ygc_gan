package co.jp.netwisdom.mapper;

import org.apache.ibatis.annotations.Param;

public interface HobbyMapper {
	//执行保存
	public void save(@Param("username")String username,@Param("hobby")String hobby);
	//执行伦理删除 
	public boolean upHobbyFlag(String username); 
}