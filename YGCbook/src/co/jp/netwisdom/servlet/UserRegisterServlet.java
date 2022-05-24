package co.jp.netwisdom.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserinfoDAO;
import co.jp.netwisdom.entity.Hobby;
import co.jp.netwisdom.entity.Userinfo;
//处理前台请求
public class UserRegisterServlet extends HttpServlet {
//	获取前台请求的参数值
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String major = request.getParameter("major");
		String intro = request.getParameter("intro");
		
		String[] hobbyArray = request.getParameterValues("hobby");
		List hobbyList = new ArrayList();
		if(hobbyArray == null){
			hobbyArray = new String[]  {""};
		}
		for(int i = 0;i < hobbyArray.length;i++){
			Hobby hobbyObject = new Hobby();
			hobbyObject.setUsername(username);
			hobbyObject.setHobby(hobbyArray[i]);
		}
		
//		DAO(data access object:数据访问操作 增删改查)
		UserinfoDAO userinfodao = new UserinfoDAO();
		HobbyDAO hobbydao = new HobbyDAO();
		
//		将用户数据和爱好数据导入数据库，并且判断是否导入成功并跳转页面
		if (userinfodao.save(new Userinfo(username, password, sex, major, intro))&&hobbydao.save(hobbyList)) {
			System.out.println("开导");
			request.getRequestDispatcher("/userRegSuccess.jsp").forward(request, response);
		}else{
			System.out.println("导不了");
		}
		
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	
	
	
	
	
	
	
	
}
 