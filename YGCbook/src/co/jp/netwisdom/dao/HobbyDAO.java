package co.jp.netwisdom.dao;

import java.sql.SQLException;
import java.util.List;

import cn.key.dbManager.JdbcTemplate;
import co.jp.netwisdom.entity.Hobby;

public class HobbyDAO {

	private JdbcTemplate template = new JdbcTemplate();

	public boolean save(List<Hobby> list) {
		// 把大象从冰箱里拿出来的放入冷库的步骤 
		// 把冷库门打开
		String sql = "insert into hobby(username,hobby)" + "values(?,?)";

		try {
			// 遍历冰箱拿出每一个大象
			for (Hobby hobby : list) {
				// 把大象的名字和爱好贴个条放到object数组里
				Object[] values = new Object[] { hobby.getUsername(), hobby.getHobby() };
				// 扔到冷冻库里
				template.updata(sql, values);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return true;

	}

	// 伦理删除
	public boolean delHobby(String username) {
		int row = 0;
		// 执行的sql文
		String sql = "update hobby set delFlg='1' where hobby.username=?";
		// 传值
		Object[] values = new Object[] { username };
		// 捕捉 抛出异常
		try {
			row = template.updata(sql, values);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (row == 1);
	}
	
	
}