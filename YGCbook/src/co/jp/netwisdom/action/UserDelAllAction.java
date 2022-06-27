package co.jp.netwisdom.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import co.jp.netwisdom.Interface.UserDeleteAllServiceInterface;
import co.jp.netwisdom.form.Userform;


@Controller(value="/userDelAll")
//处理前台请求
public class UserDelAllAction extends Action {
	
	@Autowired
	private UserDeleteAllServiceInterface DeleteAllService;


	// 获取前台请求的参数值
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Userform userform = (Userform) form;

		String[] usernames = userform.getCheckOne();

		DeleteAllService.deleteAll(usernames);

		return mapping.findForward("userDelAll");

	}
}
