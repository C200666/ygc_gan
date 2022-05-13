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
		
		
		
		
		
		
		username = "a";
		String[] hobbyArray = {"1","2","3"};
		
		Hobby hobby1 = new Hobby();
		hobby1.setUsername(username);
		hobby1.setHobby(hobbyArray[0]);
		
		Hobby hobby2 = new Hobby();
		hobby2.setUsername(username);
		hobby2.setHobby(hobbyArray[1]);
		
		Hobby hobby3 = new Hobby();
		hobby3.setUsername(username);
		hobby3.setHobby(hobbyArray[2]);
		
		List hobbyList = new ArrayList();
		hobbyList.add(hobby1);
		hobbyList.add(hobby2);
		hobbyList.add(hobby3);
		
		 
		HobbyDAO dao1 = new HobbyDAO();
		dao1.save(hobbyList);
		
		
		if (dao1.save(hobbyList)){
			System.out.println("爱好信息他妈的导进来了");
		}else{
			System.out.println("¿我爱好信息呢？");
		}
		
	}
}
 