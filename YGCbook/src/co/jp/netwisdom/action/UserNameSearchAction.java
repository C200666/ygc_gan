package co.jp.netwisdom.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.jp.netwisdom.Interface.UserNameSearchServiceInterface;
import co.jp.netwisdom.entity.UserinfoHobby;
import co.jp.netwisdom.form.Userform;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller(value = "/userNameSearch")
public class UserNameSearchAction extends Action {
	
	@Autowired
	private UserNameSearchServiceInterface userNameSearchService;


	// 获取前台请求的参数值
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Userform userform = (Userform) form;

		String username = userform.getUsername();
		String password = userform.getPassword();
		String sex = userform.getSex();
		String major = userform.getMajor();

		List<UserinfoHobby> list = userNameSearchService.userNameSearch(username, password, sex, major);

		response.setContentType("text/html;charset=UTF-8");

		PrintWriter pw = response.getWriter();
		JSONArray json = JSONArray.fromObject(list); // 把列表的数据装换为json格式
		JSONObject jo = new JSONObject();
		jo.put("users", json);
		pw.print(jo);

		return null;

	}

}
