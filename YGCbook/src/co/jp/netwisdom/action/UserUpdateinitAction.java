package co.jp.netwisdom.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.jp.netwisdom.Interface.UserUpdateinitServiceInterface;
import co.jp.netwisdom.entity.UserinfoHobby;
import co.jp.netwisdom.form.Userform;

@Controller(value = "/userUpdateInit")
public class UserUpdateinitAction extends Action {
	
	@Autowired
	private UserUpdateinitServiceInterface userUpdateinitService;
	
	// 获取前台请求的参数值
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		Userform userform = (Userform) form;
		
		String username = userform.getUsername();
		
		UserinfoHobby list = userUpdateinitService.userUpdateinit(username);

		request.setAttribute("data", list);
		
		return mapping.findForward("userInit");
	}
}
