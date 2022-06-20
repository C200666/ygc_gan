package co.jp.netwisdom.service;

import java.util.List;

import co.jp.netwisdom.entity.UserinfoHobby;
import co.jp.netwisdom.dao.UserinfoHobbyDAO;;

public class UserNameCheckService {
	public List<UserinfoHobby> userNameCheck(String username) {
		
		UserinfoHobbyDAO userInfoHobbyDAO = new UserinfoHobbyDAO();
		return userInfoHobbyDAO.checkUserName(username); 

}

}
