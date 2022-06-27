package co.jp.netwisdom.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.jp.netwisdom.Interface.UserSearchServiceInterface;
import co.jp.netwisdom.Utils.MyBatisUtil;
import co.jp.netwisdom.entity.UserinfoHobby;
import co.jp.netwisdom.mapper.UserinfoHobbyMapper;

@Service
public class UserSearchService implements UserSearchServiceInterface{

	@Override
	public List<UserinfoHobby> userSearch(String username,String password, String sex, String major,String intro,String hobby) {

		// 获取mapper
		UserinfoHobbyMapper userinfoHobbyMapper = MyBatisUtil.getMapper(UserinfoHobbyMapper.class);

		// 发送請求，执行sql操作
		List<UserinfoHobby> list = userinfoHobbyMapper.UserinfoHobbySearch(username,password, sex, major, hobby);

		return list;
	}

}
