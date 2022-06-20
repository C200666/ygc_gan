package co.jp.netwisdom.service;

import co.jp.netwisdom.dao.UserinfoHobbyDAO;
import co.jp.netwisdom.entity.UserinfoHobby;

public class UserUpdateInitService {
	public UserinfoHobby userUpdateInit(String username) {
		
		UserinfoHobbyDAO userinfoHobbyDAO = new UserinfoHobbyDAO(); 
		UserinfoHobby list = userinfoHobbyDAO.findUserinfoAndHobby(username);

		return list;
	}

}
