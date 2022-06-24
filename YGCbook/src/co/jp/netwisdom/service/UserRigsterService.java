package co.jp.netwisdom.service;

import java.util.ArrayList;
import java.util.List;

import co.jp.netwisdom.Utils.MyBatisUtil;
import co.jp.netwisdom.dto.UserRigisterDto;
import co.jp.netwisdom.entity.Hobby;
import co.jp.netwisdom.entity.Userinfo;
import co.jp.netwisdom.mapper.HobbyMapper;
import co.jp.netwisdom.mapper.UserinfoMapper;

public class UserRigsterService {
	public boolean UserRigster(UserRigisterDto dto) {

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

		boolean successFlag = true;

		// 获取mapper
		HobbyMapper hobbyMapper = MyBatisUtil.getMapper(HobbyMapper.class);
		UserinfoMapper userinfoMapper = MyBatisUtil.getMapper(UserinfoMapper.class);

		// 发送請求，执行sql操作
		userinfoMapper.save(new Userinfo(dto.getUsername(), dto.getPassword(), dto.getSex(), dto.getMajor(), dto.getIntro()));

		for (Hobby hobbys : hobbyList) {
			hobbyMapper.save(hobbys.getUsername(), hobbys.getHobby());
		}

		// 判断导入数据是否成功
		if (successFlag) {
			System.out.println("用户信息 爱好信息导入数据库成功！！");
		} else {
			System.out.println("用户信息 爱好信息导入数据库失败！！");
			successFlag = false;
		}
		return successFlag;
	}

}
