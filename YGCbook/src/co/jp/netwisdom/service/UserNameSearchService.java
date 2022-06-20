package co.jp.netwisdom.service;

import java.util.List;
import co.jp.netwisdom.dao.UserinfoHobbyDAO;
import co.jp.netwisdom.entity.UserinfoHobby;

public class UserNameSearchService {
	public List<UserinfoHobby> userNameSearch(String username,String sex,String major) {

		UserinfoHobbyDAO userinfoHobbyDAO = new UserinfoHobbyDAO();
		return  userinfoHobbyDAO.findUserinfoAndHobby(username, sex, major);
}

}
