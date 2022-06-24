package co.jp.netwisdom.mapper;

import org.apache.ibatis.annotations.Param;

import co.jp.netwisdom.entity.Userinfo;

public interface UserinfoMapper {

		//执行保存
		public void save(Userinfo userinfo); 

		//执行伦理删除
		public boolean upUserinfoFlag(String username);

		//Ajax检查用户名
		public Userinfo userNameCheck(@Param("username")String username);

}		
