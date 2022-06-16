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
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class UserNameSearchAction extends Action {
//	获取前台请求的参数值
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		Userform userform = (Userform) form;
		
		
		String username = userform.getUsername();
		String sex = userform.getSex();
		String major = userform.getMajor();
		
		
//		新规DAO对象
		UserinfoHobbyDAO userinfoHobbyDAO = new UserinfoHobbyDAO();
//		传入输入的姓名性别等参数
		List<UserinfoHobby> list = userinfoHobbyDAO.findUserinfoAndHobby(username, sex, major);
		
		request.setAttribute("data", list);
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter pw = response.getWriter();
		JSONArray json = JSONArray.fromObject(list); //把列表的数据装换为json格式
		JSONObject jo = new JSONObject();
		jo.put("users", json);
		pw.print(jo);

//		if (list.size() >= 1) {
//			pw.print("1");
//		} else {
//			pw.print("0");
//		}

		return null;
		
		
	}
	
}
 