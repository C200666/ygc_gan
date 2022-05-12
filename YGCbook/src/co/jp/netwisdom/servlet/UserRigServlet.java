package co.jp.netwisdom.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import co.jp.netwisdom.dao.UserinfoDAO;
import co.jp.netwisdom.enity.Userinfo;

public class UserRigServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String major = request.getParameter("major");
		String intro = request.getParameter("intro");
		//TODO
		//String hobby = request.getParameter("hobby");
		UserinfoDAO dao = new UserinfoDAO();
		
		
		if (dao.save(new Userinfo(username, password, sex, major, intro))) {
			System.out.println("用户信息他妈的导进来了");
		}else{
			System.out.println("¿我用户信息呢？");
		}
		
		
	
	
	}
	
	
}
 