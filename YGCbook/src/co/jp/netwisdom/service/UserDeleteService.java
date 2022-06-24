package co.jp.netwisdom.service;

import co.jp.netwisdom.Utils.MyBatisUtil;
import co.jp.netwisdom.mapper.HobbyMapper;
import co.jp.netwisdom.mapper.UserinfoMapper;

public class UserDeleteService {
	public void userDelete(String username) {
		// 获取mapper
		UserinfoMapper userinfoMapper = MyBatisUtil.getMapper(UserinfoMapper.class);
		HobbyMapper hobbyMapper = MyBatisUtil.getMapper(HobbyMapper.class);

		// 发送請求，执行sql操作
		userinfoMapper.upUserinfoFlag(username);
		hobbyMapper.upHobbyFlag(username);
	}
}
