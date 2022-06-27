package co.jp.netwisdom.service;

import org.springframework.stereotype.Service;

import co.jp.netwisdom.Interface.UserUpdateinitServiceInterface;
import co.jp.netwisdom.Utils.MyBatisUtil;
import co.jp.netwisdom.entity.UserinfoHobby;
import co.jp.netwisdom.mapper.UserinfoHobbyMapper;

@Service
public class UserUpdateinitService implements UserUpdateinitServiceInterface {

	@Override
	public UserinfoHobby userUpdateinit(String username) {

		// 获取mapper
		UserinfoHobbyMapper userinfoHobbyMapper = MyBatisUtil.getMapper(UserinfoHobbyMapper.class);

		// 发送請求，执行sql操作
		UserinfoHobby userinfoHobby = userinfoHobbyMapper.upUserinfoHobby(username);

		return userinfoHobby;

	}
}
