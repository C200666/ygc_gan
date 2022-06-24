package co.jp.netwisdom.service;

import co.jp.netwisdom.Utils.MyBatisUtil;
import co.jp.netwisdom.entity.UserinfoHobby;
import co.jp.netwisdom.mapper.UserinfoHobbyMapper;

public class UserUpdateInitService {
	public UserinfoHobby userUpdateInit(String username) {

		// 获取mapper
		UserinfoHobbyMapper userinfoHobbyMapper = MyBatisUtil.getMapper(UserinfoHobbyMapper.class);

		// 发送請求，执行sql操作
		UserinfoHobby userinfoHobby = userinfoHobbyMapper.upUserinfoHobby(username);

		return userinfoHobby;

	}
}
