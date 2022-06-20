package co.jp.netwisdom.service;

import java.util.ArrayList;
import java.util.List;
import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserinfoDAO;
import co.jp.netwisdom.dto.UserUpdateDto;
import co.jp.netwisdom.entity.Hobby;
import co.jp.netwisdom.entity.Userinfo;

public class UserUpdateService {
	public void userUpdate(UserUpdateDto dto) {

		String[] hobby = dto.getHobby();

		List<Hobby> hobbyList = new ArrayList<>();

		if(hobby == null) {
			hobby = new String[]{""};
		}
		for(int i = 0; i < hobby.length;i++) {
			Hobby hobbyObj = new Hobby();
			hobbyObj.setUsername(dto.getUsername());
			hobbyObj.setHobby(hobby[i]);
			hobbyList.add(hobbyObj);
		}

		HobbyDAO hobbyDAO = new HobbyDAO();
		UserinfoDAO userinfoDAO = new UserinfoDAO();

		boolean upUserInfoFlag = true;
		upUserInfoFlag = userinfoDAO.delUserInfo(dto.getUsername());
		upUserInfoFlag = userinfoDAO.save(new Userinfo(dto.getUsername(), dto.getPassword(), dto.getSex(), dto.getMajor(), dto.getIntro()));

		boolean upHobbyFlag = true;
		upHobbyFlag = hobbyDAO.delHobby(dto.getUsername());
		upHobbyFlag = hobbyDAO.save(hobbyList);

		if(upUserInfoFlag && upHobbyFlag) {
			System.out.println("用户信息 爱好信息更新成功！！");
		}else {
			System.out.println("用户信息 爱好信息更新失败！！");

		}
	}	

}
