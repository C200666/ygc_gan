package co.jp.netwisdom.action;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserinfoDAO;
import co.jp.netwisdom.entity.Hobby;
import co.jp.netwisdom.entity.Userinfo;
import co.jp.netwisdom.form.Userform;

//处理前台请求
public class UserRegisterAction extends Action {
	// 获取前台请求的参数值
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		Userform userform = (Userform) form;
		
		String username = userform.getUsername();
		String password = userform.getPassword();
		String sex = userform.getSex();
		String major = userform.getMajor();
		String intro = userform.getIntro();
		// 看大象选择的爱好
		String[] hobby = userform.getHobby();
		// 买个冰箱 该冰箱只能放大象《泛型》
		List<Hobby> hobbyList = new ArrayList<>();

		// hobbyArray == null的情况下 给大象塞进冰箱但不给null
		if (hobby == null) {

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
		if (hobby != null) {
			// 遍历所选的hobby 把hobbyobject放进List里面(循环遍历大象的爱好)
			for (int i = 0; i < hobby.length; i++) {
				// 创建一个hobby类的对象 循环一次创建一次 （创建一个大象）
				Hobby hobbyObject = new Hobby();
				// 给姓名设置属性值 （给大象名字）
				hobbyObject.setUsername(username);
				// 给爱好设置属性值 （给大象个爱好）
				hobbyObject.setHobby(hobby[i]);
				// 把大象装冰箱里
				hobbyList.add(hobbyObject);
			}
		}
		// DAO(data access object:数据访问操作 增删改查)
		// 创建个运大象信息的卡车
		UserinfoDAO userinfodao = new UserinfoDAO();
		// 创建个运大象爱好的卡车
		HobbyDAO hobbydao = new HobbyDAO();
		
		
		
		userinfodao.save(new Userinfo(username,password,sex,major,intro));	
		hobbydao.save(hobbyList);

		// 将用户数据和爱好数据导入数据库，并且判断是否导入成功并跳转页面
		return mapping.findForward("userReg");

	}


}
