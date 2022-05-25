package co.jp.netwisdom.dao;

import java.sql.SQLException;

import cn.key.dbManager.JdbcTemplate;
import co.jp.netwisdom.entity.Userinfo;

public class UserinfoDAO {
//	引用Jdbc模板
	private JdbcTemplate template = new JdbcTemplate();
//	创建保存的数据库的方法
	public boolean save(Userinfo userinfo){
		int row = 0;
//		执行的sql文
		String sql = "insert into userinfo(username,password,sex,major,intro)" + " values(?,?,?,?,?)";
//		传值
		Object[] values = new Object[]{userinfo.getUsername(),userinfo.getPassword(),userinfo.getSex(),userinfo.getMajor(),userinfo.getIntro()};
//		捕捉  抛出异常
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
