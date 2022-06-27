package co.jp.netwisdom.Interface;

import java.util.List;

import co.jp.netwisdom.entity.UserinfoHobby;

public interface UserNameSearchServiceInterface {
	public List<UserinfoHobby> userNameSearch(String username, String password, String sex, String major);
}
