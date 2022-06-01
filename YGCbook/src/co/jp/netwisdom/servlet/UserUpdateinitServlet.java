package co.jp.netwisdom.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.jp.netwisdom.dao.UserinfoHobbyDAO;
import co.jp.netwisdom.entity.UserinfoHobby;

public class UserUpdateinitServlet extends HttpServlet {
	// 获取前台请求的参数值
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");

		// 新规DAO对象
		UserinfoHobbyDAO userinfoHobbyDAO = new UserinfoHobbyDAO();
		// 传入输入的姓名性别等参数
		UserinfoHobby list = userinfoHobbyDAO.findUserinfoAndHobby(username);

		request.setAttribute("data", list);
		// 不会把参数清除再进行跳转
		request.getRequestDispatcher("/userUpdate.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
