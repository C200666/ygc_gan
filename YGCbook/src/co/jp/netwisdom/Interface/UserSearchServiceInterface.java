package co.jp.netwisdom.Interface;

import java.util.List;

import co.jp.netwisdom.entity.UserinfoHobby;

public interface UserSearchServiceInterface {
	public List<UserinfoHobby> userSearch(String username,String password, String sex, String major,String intro,String hobby);
}
