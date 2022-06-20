package co.jp.netwisdom.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import co.jp.netwisdom.entity.UserinfoHobby;
import co.jp.netwisdom.form.Userform;
import co.jp.netwisdom.service.UserSearchService;

public class UserSearchAction extends Action {
	// 获取前台请求的参数值
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Userform userform = (Userform) form;

		String username = userform.getUsername();
		String sex = userform.getSex();
		String major = userform.getMajor();
		String intro = userform.getIntro();
		String hobby = request.getParameter("hobby");

		List<UserinfoHobby> list = new UserSearchService().userSearch(username, sex, major, intro, hobby);

		request.setAttribute("date", list);

		return mapping.findForward("userSearch");

	}

}
