package co.jp.netwisdom.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.key.dbManager.IResultSetMapping;
import co.jp.netwisdom.entity.UserinfoHobby;

public class UserinfoMapping implements IResultSetMapping{

	@Override
	public UserinfoHobby mapping(ResultSet rs) throws SQLException {
		int i = 1;
		UserinfoHobby userinfoHobby = new UserinfoHobby(rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++));
		return userinfoHobby;
	}
}
 