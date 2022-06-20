package co.jp.netwisdom.service;

import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserinfoDAO;

public class DeleteAllService {
	public void deleteAll(String[] usernames) {

		HobbyDAO hobbydao = new HobbyDAO();
		UserinfoDAO userinfodao = new UserinfoDAO();

		if(usernames != null){
			for(String username:usernames) {
				boolean upUserInfoFlag = true;
				upUserInfoFlag = userinfodao.delUserInfo(username);

				boolean upHobbyFlag = true;
				upHobbyFlag = hobbydao.delHobby(username);

				if(upUserInfoFlag && upHobbyFlag) {
					System.out.println("用户信息 爱好信息删除成功！！");
				}
			}
		}
	}	
}
