package co.jp.netwisdom.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import co.jp.netwisdom.dao.UserinfoHobbyDAO;
import co.jp.netwisdom.entity.UserinfoHobby;
import co.jp.netwisdom.form.Userform;

public class UserUpdateinitAction extends Action {
	// 获取前台请求的参数值
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		Userform userform = (Userform) form;
		
		String username = userform.getUsername();

		// 新规DAO对象
		UserinfoHobbyDAO userinfoHobbyDAO = new UserinfoHobbyDAO();
		// 传入输入的姓名性别等参数
		UserinfoHobby list = userinfoHobbyDAO.findUserinfoAndHobby(username);

		request.setAttribute("data", list);
		// 不会把参数清除再进行跳转
		
		return mapping.findForward("userInit");
	}
}
