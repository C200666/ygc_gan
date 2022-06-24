package co.jp.netwisdom.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.InputStream;

public class MyBatisUtil {
	private static SqlSessionFactory sqlSessionFactory = null;

	private static SqlSession getSqlSession(boolean SqlSession) {
		InputStream inputStream = null;
		if (null == sqlSessionFactory) {
			String resource = "MyBatis_config.xml";
			try {
				inputStream = Resources.getResourceAsStream(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			} catch (Exception e) {
				System.err.println(e);
				e.getStackTrace();
			}
		}

		// 获取Session
		SqlSession sqlSession = sqlSessionFactory.openSession(SqlSession);
		return sqlSession;
	}
	//使用泛型封装getMapper
    public static <T extends Object> T getMapper(Class<T> c) {
        SqlSession sqlSession = getSqlSession(true); 
        return sqlSession.getMapper(c);
    }
}