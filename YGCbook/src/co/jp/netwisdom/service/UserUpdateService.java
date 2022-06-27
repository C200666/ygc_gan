package co.jp.netwisdom.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.jp.netwisdom.Interface.UserUpdateServiceInterface;
import co.jp.netwisdom.Utils.MyBatisUtil;
import co.jp.netwisdom.dto.UserUpdateDto;
import co.jp.netwisdom.entity.Hobby;
import co.jp.netwisdom.entity.Userinfo;
import co.jp.netwisdom.mapper.HobbyMapper;
import co.jp.netwisdom.mapper.UserinfoMapper;

@Service
public class UserUpdateService implements UserUpdateServiceInterface{

	@Override
	public void userUpdate(UserUpdateDto dto) {

		String[] hobby = dto.getHobby();

		List<Hobby> hobbyList = new ArrayList<>();

		if (hobby == null) {
			hobby = new String[] { "" };
		}
		for (int i = 0; i < hobby.length; i++) {
			Hobby hobbyObj = new Hobby();
			hobbyObj.setUsername(dto.getUsername());
			hobbyObj.setHobby(hobby[i]);
			hobbyList.add(hobbyObj);
		}

		// 获取mapper
		UserinfoMapper userinfoMapper = MyBatisUtil.getMapper(UserinfoMapper.class);
		HobbyMapper hobbyMapper = MyBatisUtil.getMapper(HobbyMapper.class);
		// 发送請求，执行sql操作
		userinfoMapper.upUserinfoFlag(dto.getUsername());
		userinfoMapper
				.save(new Userinfo(dto.getUsername(), dto.getPassword(), dto.getSex(), dto.getMajor(), dto.getIntro()));

		hobbyMapper.upHobbyFlag(dto.getUsername());
		for (Hobby hobbys : hobbyList) {
			hobbyMapper.save(hobbys.getUsername(), hobbys.getHobby());

		}

	}

}
