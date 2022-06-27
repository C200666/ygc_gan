package co.jp.netwisdom.service;

import org.springframework.stereotype.Service;

import co.jp.netwisdom.Interface.UserDeleteAllServiceInterface;
import co.jp.netwisdom.Utils.MyBatisUtil;
import co.jp.netwisdom.mapper.HobbyMapper;
import co.jp.netwisdom.mapper.UserinfoMapper;

@Service
public class UserDeleteAllService implements UserDeleteAllServiceInterface{

	@Override
	public void deleteAll(String[] usernames) {

		// 获取mapper
		UserinfoMapper userinfoMapper = MyBatisUtil.getMapper(UserinfoMapper.class);
		HobbyMapper hobbyMapper = MyBatisUtil.getMapper(HobbyMapper.class);
		// 发送請求，执行sql操作
		if(usernames!=null){
			for (String username : usernames) {
				userinfoMapper.upUserinfoFlag(username);
				hobbyMapper.upHobbyFlag(username);
			}
		}
	}
}
