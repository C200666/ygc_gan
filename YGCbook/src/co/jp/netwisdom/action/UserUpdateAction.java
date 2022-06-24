package co.jp.netwisdom.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import co.jp.netwisdom.dto.UserUpdateDto;
import co.jp.netwisdom.form.Userform;
import co.jp.netwisdom.service.UserUpdateService;

//处理前台请求
public class UserUpdateAction extends Action {
	
	private UserUpdateService userUpdateService = new UserUpdateService();
	
	// 获取前台请求的参数值
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Userform userform = (Userform) form;

		UserUpdateDto dto = new UserUpdateDto();

		dto.setUsername(userform.getUsername());
		dto.setPassword(userform.getPassword());
		dto.setSex(userform.getSex());
		dto.setMajor(userform.getMajor());
		dto.setIntro(userform.getIntro());
		dto.setHobby(userform.getHobby());
		dto.setHobby(userform.getHobby());

		userUpdateService.userUpdate(dto);

		return mapping.findForward("userUpdate");

	}

}
