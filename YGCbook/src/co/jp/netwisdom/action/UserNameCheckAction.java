package co.jp.netwisdom.action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import co.jp.netwisdom.entity.Userinfo;
import co.jp.netwisdom.form.Userform;
import co.jp.netwisdom.service.UserNameCheckService;

public class UserNameCheckAction extends Action {
	
	private UserNameCheckService userNameCheckService = new UserNameCheckService();
	
	// 获取前台请求的参数值
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Userform userform = (Userform) form;
		String username = userform.getUsername();

		Userinfo userinfo = userNameCheckService.userNameCheck(username);

		PrintWriter printWriter = response.getWriter();
		if (userinfo != null) {
			printWriter.print("1");
		} else {
			printWriter.print("0");
		}
		printWriter.close();

		return null;
	}

}
