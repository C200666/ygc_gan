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
public class UserUpdateServlet extends HttpServlet {
	// 获取前台请求的参数值
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String major = request.getParameter("major");
		String intro = request.getParameter("intro");
		// 看大象选择的爱好
		String[] hobbyArray = request.getParameterValues("hobby");
		// 买个冰箱 该冰箱只能放大象《泛型》
		List<Hobby> hobbyList = new ArrayList<>();

		// 循环前对数组判空 当不为空时执行（看看大象有没有选爱好）
		if (hobbyArray == null) {

			// 创建一个hobby类的对象 循环一次创建一次 （创建一个大象）
			Hobby hobbyObject = new Hobby();
			// 给姓名设置属性值 （给大象名字）
			hobbyObject.setUsername(username);
			// 给爱好设置属性值 （给大象个爱好）
			hobbyObject.setHobby("");
			// 把大象装冰箱里
			hobbyList.add(hobbyObject);

		}
		// 循环前对数组判空 当不为空时执行（看看大象有没有选爱好）
		if (hobbyArray != null) {
			// 遍历所选的hobby 把hobbyobject放进List里面(循环遍历大象的爱好)
			for (int i = 0; i < hobbyArray.length; i++) {
				// 创建一个hobby类的对象 循环一次创建一次 （创建一个大象）
				Hobby hobbyObject = new Hobby();
				// 给姓名设置属性值 （给大象名字）
				hobbyObject.setUsername(username);
				// 给爱好设置属性值 （给大象个爱好）
				hobbyObject.setHobby(hobbyArray[i]);
				// 把大象装冰箱里
				hobbyList.add(hobbyObject);
			}
		}

		// DAO(data access object:数据访问操作 增删改查)
		// 创建个运大象信息的卡车
		UserinfoDAO userinfodao = new UserinfoDAO();
		// 创建个运大象爱好的卡车
		HobbyDAO hobbydao = new HobbyDAO();

		boolean delUserInfo = true;
		delUserInfo = userinfodao.delUserInfo(username);
		delUserInfo = userinfodao.save(new Userinfo(username, password, sex, major, intro));

		boolean delHobby = true;
		delHobby = hobbydao.delHobby(username);
		delHobby = hobbydao.save(hobbyList);

		// 将用户数据和爱好数据导入数据库，并且判断是否导入成功并跳转页面
		if (delUserInfo && delHobby) {
			System.out.println("更新成功");
			request.getRequestDispatcher("/userUpdateSuccess.jsp").forward(request, response);
		} else {
			System.out.println("更新失败");
		}

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
