package co.jp.netwisdom.service;


import co.jp.netwisdom.entity.Userinfo;
import co.jp.netwisdom.mapper.UserinfoMapper;
import co.jp.netwisdom.Utils.MyBatisUtil;

public class UserNameCheckService {
	
		public Userinfo userNameCheck(String username) {

			// 获取mapper
			UserinfoMapper userinfoMapper = MyBatisUtil.getMapper(UserinfoMapper.class);

			//执行Ajax检查username的sql操作
			Userinfo userinfo = userinfoMapper.userNameCheck(username);
			
			return userinfo;

		}

}
