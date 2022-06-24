package co.jp.netwisdom.service;

import co.jp.netwisdom.Utils.MyBatisUtil;
import co.jp.netwisdom.mapper.HobbyMapper;
import co.jp.netwisdom.mapper.UserinfoMapper;

public class DeleteAllService {
	public void deleteAll(String[] usernames) {

		// 获取mapper
		UserinfoMapper userinfoMapper = MyBatisUtil.getMapper(UserinfoMapper.class);
		HobbyMapper hobbyMapper = MyBatisUtil.getMapper(HobbyMapper.class);
		// 发送請求，执行sql操作
		for (String username : usernames) {
			userinfoMapper.upUserinfoFlag(username);
			hobbyMapper.upHobbyFlag(username);
		}
	}
}
