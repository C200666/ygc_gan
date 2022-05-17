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
import co.jp.netwisdom.enity.Hobby;
import co.jp.netwisdom.enity.Userinfo;

public class UserRigsterServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String major = request.getParameter("major");
		String intro = request.getParameter("intro");
		
		
		String[] hobbyArray = request.getParameterValues("hobby");
		
		List hobbyList = new ArrayList();
		
		for(int i = 0;i < hobbyArray.length;i++){
			Hobby hobbyObject = new Hobby();
			hobbyObject.setUsername(username);
			hobbyObject.setHobby(hobbyArray[i]);
			hobbyList.add(hobbyObject);
		}
		
		
		UserinfoDAO userinfodao = new UserinfoDAO();
		HobbyDAO hobbydao = new HobbyDAO();
		
		
		if (userinfodao.save(new Userinfo(username, password, sex, major, intro))&&hobbydao.save(hobbyList)) {
			System.out.println("开导");
			request.getRequestDispatcher("/userRegSuccess.jsp").forward(request, response);
		}else{
			System.out.println("导不了");
			request.getRequestDispatcher("/userRegFailed.jsp").forward(request, response);
		}
		
		
	}
}
 