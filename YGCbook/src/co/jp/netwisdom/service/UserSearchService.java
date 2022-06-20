package co.jp.netwisdom.service;

import java.util.List;

import co.jp.netwisdom.dao.UserinfoHobbyDAO;
import co.jp.netwisdom.entity.UserinfoHobby;

public class UserSearchService {
	public List<UserinfoHobby> userSearch(String username, String sex, String major, String intro, String hobby) {

		UserinfoHobbyDAO userinfoHobbyDAO = new UserinfoHobbyDAO();
		return userinfoHobbyDAO.findUserinfoAndHobby(username, sex, major, intro, hobby);

	}

}
