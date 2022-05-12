package co.jp.netwisdom.dao;

import java.sql.SQLException;

import cn.key.dbManager.JdbcTemplate;
import co.jp.netwisdom.enity.Userinfo;

public class UserinfoDAO {
	
	private JdbcTemplate template = new JdbcTemplate();
	
	public boolean save(Userinfo user){
		int row = 0;
		String sql = "insert into userinfo(username,password,sex,major,intro)" + " values(?,?,?,?,?)";
		Object[] values = new Object[]{
				user.getUsername(),user.getPassword(),user.getSex(),user.getMajor(),user.getIntro()
		};
		
		try {
			row = template.updata(sql, values);
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return(row == 1);
	}
}
