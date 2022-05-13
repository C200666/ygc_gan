package co.jp.netwisdom.dao;

import java.sql.SQLException;
import java.util.List;

import cn.key.dbManager.JdbcTemplate;
import co.jp.netwisdom.enity.Hobby;

public class HobbyDAO {
	private JdbcTemplate template = new JdbcTemplate();
	
	
	public boolean save(List list){
		
		int row = 0;
		String sql = "insert into hobby(username,hobby)"+"values(?,?)";
		
		try {
			
			for(Object object : list){
				Hobby hobbyObject = (Hobby)object;
				Object[] values = null;
				values = new Object[]{
						hobbyObject.getUsername(),
						hobbyObject.getHobby()};
				row = template.updata(sql, values);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (row == 1);
	
	}
}