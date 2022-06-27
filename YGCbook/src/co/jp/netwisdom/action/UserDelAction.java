package co.jp.netwisdom.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.jp.netwisdom.Interface.UserDeleteServiceInterface;
import co.jp.netwisdom.form.Userform;


@Controller(value="/userDel")
//处理前台请求
public class UserDelAction extends Action {

	@Autowired
	private UserDeleteServiceInterface userDeleteService;

	// 获取前台请求的参数值
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Userform userform = (Userform) form;

		String username = userform.getUsername();

		userDeleteService.userDelete(username);

		return mapping.findForward("userDel");
	}

}
