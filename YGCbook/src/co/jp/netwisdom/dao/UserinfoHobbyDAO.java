package co.jp.netwisdom.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import cn.key.dbManager.JdbcTemplate;
import co.jp.netwisdom.entity.UserinfoHobby;
import co.jp.netwisdom.mapping.UserinfoMapping;

public class UserinfoHobbyDAO {
	// 引用Jdbc模板
	private JdbcTemplate template = new JdbcTemplate();

	public List<UserinfoHobby> findUserinfoAndHobby(String username, String sex, String major, String intro,
			String hobby) {
		// 拿到前台的参数后执行sql文 查找参数
		String sql = "select userinfo.username,password,sex,major,intro,GROUP_CONCAT(hobby) hobby " + "from userinfo "
				+ "left join hobby " + "on userinfo.username = hobby.username " + "where 1=1";

		if (!"".equals(username)) {
			sql += " and userinfo.username='" + username + "'";
		}

		if (sex != null) {
			sql += " and sex='" + sex + "'";
		}

		if (hobby != null) {
			sql += " and hobby='" + hobby + "'";
		}

		if (major != null && !"".equals(major)) {
			sql += " and major='" + major + "'";
		}
		sql += " and userinfo.delFlg='0' and hobby.delFlg='0'";

		sql += " GROUP BY userinfo.username";

		List<UserinfoHobby> list = new Vector<UserinfoHobby>();
		try {
			list = template.selete(sql, new UserinfoMapping());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public UserinfoHobby findUserinfoAndHobby(String username) {
		// 拿到前台的参数后执行sql文 查找参数
		String sql = "select userinfo.username,password,sex,major,intro,GROUP_CONCAT(hobby) hobby " + "from userinfo "
				+ "left join hobby " + "on userinfo.username = hobby.username " + "where 1=1";

		if (!"".equals(username)) {
			sql += " and userinfo.username='" + username + "'";
		}
		sql += " and userinfo.delFlg='0' and hobby.delFlg='0'";

		sql += " GROUP BY userinfo.username";

		List<UserinfoHobby> list = new Vector<UserinfoHobby>();
		try {
			list = template.selete(sql, new UserinfoMapping());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list.get(0);
	}

	public List<UserinfoHobby> checkUserName(String username) {
		// 拿到前台的参数后执行sql文 查找参数
		String sql = "select * from userinfo where delFlg='0' and username='" + username + "'";

		List<UserinfoHobby> list = new Vector<UserinfoHobby>();

		try {
			list = template.selete(sql, new UserinfoMapping());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<UserinfoHobby> findUserinfoAndHobby(String username, String sex, String major) {
		// 拿到前台的参数后执行sql文 查找参数
		String sql = "select userinfo.username,password,sex,major,intro,GROUP_CONCAT(hobby) hobby " + "from userinfo "
				+ "left join hobby " + "on userinfo.username = hobby.username " + "where 1=1";

		if (!"".equals(username)) {
			sql += " and userinfo.username='" + username + "'";
		}

		if (sex != null && !"".equals(sex)) {
			sql += " and sex='" + sex + "'";
		}

		if (major != null && !"".equals(major)) {
			sql += " and major='" + major + "'";
		}
		sql += " and userinfo.delFlg='0' and hobby.delFlg='0'";

		sql += " GROUP BY userinfo.username";

		List<UserinfoHobby> list = new Vector<UserinfoHobby>();
		try {
			list = template.selete(sql, new UserinfoMapping());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
}
