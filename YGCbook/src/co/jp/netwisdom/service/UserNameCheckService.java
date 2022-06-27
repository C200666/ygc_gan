package co.jp.netwisdom.service;


import co.jp.netwisdom.entity.Userinfo;
import co.jp.netwisdom.mapper.UserinfoMapper;

import org.springframework.stereotype.Service;

import co.jp.netwisdom.Interface.UserNameCheckServiceInterface;
import co.jp.netwisdom.Utils.MyBatisUtil;

@Service
public class UserNameCheckService implements UserNameCheckServiceInterface {
		@Override
		public Userinfo userNameCheck(String username) {

			// 获取mapper
			UserinfoMapper userinfoMapper = MyBatisUtil.getMapper(UserinfoMapper.class);

			//执行Ajax检查username的sql操作
			Userinfo userinfo = userinfoMapper.userNameCheck(username);
			
			return userinfo;

		}

}
