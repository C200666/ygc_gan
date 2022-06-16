package co.jp.netwisdom.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import co.jp.netwisdom.dao.UserinfoHobbyDAO;
import co.jp.netwisdom.entity.UserinfoHobby;
import co.jp.netwisdom.form.Userform;

public class UserNameCheckAction extends Action {
	// 获取前台请求的参数值
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Userform userform = (Userform) form;

		String username = userform.getUsername();

		// 新规DAO对象
		UserinfoHobbyDAO userinfoHobbyDAO = new UserinfoHobbyDAO();
		// 传入输入的姓名性别等参数
		List<UserinfoHobby> list = userinfoHobbyDAO.checkUserName(username);

		PrintWriter pw = response.getWriter();

		if (list.size() >= 1) {
			pw.print("1");
		} else {
			pw.print("0");
		}

		return null;
	}

}