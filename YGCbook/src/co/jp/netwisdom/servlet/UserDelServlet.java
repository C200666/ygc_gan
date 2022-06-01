package co.jp.netwisdom.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserinfoDAO;

//处理前台请求
public class UserDelServlet extends HttpServlet {
	// 获取前台请求的参数值
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		// 创建个运大象信息的卡车
		UserinfoDAO userinfodao = new UserinfoDAO();
		// 创建个运大象爱好的卡车
		HobbyDAO hobbydao = new HobbyDAO();

		 userinfodao.delUserInfo(username);

		 hobbydao.delHobby(username);

		// 将用户数据和爱好数据导入数据库，并且判断是否导入成功并跳转页面
		
			
			request.getRequestDispatcher("/userDelSuccess.jsp").forward(request, response);
		

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
