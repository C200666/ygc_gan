package co.jp.netwisdom.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import cn.key.dbManager.JdbcTemplate;
import co.jp.netwisdom.entity.UserinfoHobby;
import co.jp.netwisdom.mapping.UserinfoMapping;

public class UserinfoHobbyDAO {
//	引用Jdbc模板
	private JdbcTemplate template = new JdbcTemplate();

	public List<UserinfoHobby> findUserinfoAndHobby(String username,String sex,String major,String hobby){
//		拿到前台的参数后执行sql文 查找参数
		String sql = "select userinfo.username,password,sex,major,intro,GROUP_CONCAT(hobby) hobby "
				+ "from userinfo "
				+ "left join hobby "
				+ "on userinfo.username = hobby.username "
				+ "where 1=1";
		
		if(!"".equals(username)){
			sql +=   " and userinfo.username='" + username + "'";
		}
		
		if (sex!=null) {
			sql +=   " and sex='" + sex + "'";
		}
		
		if (hobby!=null) {
			sql +=   " and hobby='" + hobby + "'";
		} 
		
		if(!"".equals(major)){
			sql += " and major='" + major + "'";
		}
		
		sql += " GROUP BY userinfo.username";
		
		List<UserinfoHobby> list = new Vector<UserinfoHobby>();
		try{
			list = template.selete(sql, new UserinfoMapping());
		}catch (SQLException e){
			e.printStackTrace();
		}
		 
		return list;
	}
}
