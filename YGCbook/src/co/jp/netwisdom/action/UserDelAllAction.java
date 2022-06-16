package co.jp.netwisdom.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserinfoDAO;
import co.jp.netwisdom.form.Userform;

//处理前台请求
public class UserDelAllAction extends Action {
	// 获取前台请求的参数值
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
		Userform userform = (Userform) form;
		
	
		String[] usernames = userform.getCheckOne();
		// 创建个运大象信息的卡车
		UserinfoDAO userinfodao = new UserinfoDAO();
		// 创建个运大象爱好的卡车
		HobbyDAO hobbydao = new HobbyDAO();
		
		
//		如果未选择任何选项且点击一括删除 执行检索按钮功能
		if(usernames == null){
			request.getRequestDispatcher("/userSearch.jsp").forward(request, response);
		}

		
		
		
		if(usernames != null){
			for(String username:usernames) {
				userinfodao.delUserInfo(username);
				hobbydao.delHobby(username);
			}
		}
		
		return mapping.findForward("userDelAll");
		
		 
	
	
	
	
	}
}
