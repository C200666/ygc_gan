package co.jp.netwisdom.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import co.jp.netwisdom.entity.UserinfoHobby;
import co.jp.netwisdom.form.Userform;
import co.jp.netwisdom.service.UserUpdateInitService;

public class UserUpdateinitAction extends Action {
	
	private UserUpdateInitService userUpdateInitService = new UserUpdateInitService();
	
	// 获取前台请求的参数值
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		Userform userform = (Userform) form;
		
		String username = userform.getUsername();
		
		UserinfoHobby list = userUpdateInitService.userUpdateInit(username);

		request.setAttribute("data", list);
		
		return mapping.findForward("userInit");
	}
}
