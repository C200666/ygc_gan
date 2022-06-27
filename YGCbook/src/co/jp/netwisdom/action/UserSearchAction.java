package co.jp.netwisdom.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.jp.netwisdom.Interface.UserSearchServiceInterface;
import co.jp.netwisdom.entity.UserinfoHobby;
import co.jp.netwisdom.form.Userform;

@Controller(value = "/userSearch")
public class UserSearchAction extends Action {

	@Autowired
	private UserSearchServiceInterface userSearchService;

	// 获取前台请求的参数值
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Userform userform = (Userform) form;

		String username = userform.getUsername();
		String password = userform.getPassword();
		String sex = userform.getSex();
		String major = userform.getMajor();
		String intro = userform.getIntro();
		String hobby = request.getParameter("hobby");

		List<UserinfoHobby> list = userSearchService.userSearch(username, password, sex, major, intro, hobby);

		request.setAttribute("date", list);

		return mapping.findForward("userSearch");

	}

}
