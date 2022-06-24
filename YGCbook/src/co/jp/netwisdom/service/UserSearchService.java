package co.jp.netwisdom.service;

import java.util.List;

import co.jp.netwisdom.Utils.MyBatisUtil;
import co.jp.netwisdom.entity.UserinfoHobby;
import co.jp.netwisdom.mapper.UserinfoHobbyMapper;

public class UserSearchService {
	public List<UserinfoHobby> userSearch(String username,String password, String sex, String major,String intro,String hobby) {

		// 获取mapper
		UserinfoHobbyMapper userinfoHobbyMapper = MyBatisUtil.getMapper(UserinfoHobbyMapper.class);

		// 发送請求，执行sql操作
		List<UserinfoHobby> list = userinfoHobbyMapper.UserinfoHobbySearch(username,password, sex, major, hobby);

		return list;
	}

}
