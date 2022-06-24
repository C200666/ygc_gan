package co.jp.netwisdom.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import co.jp.netwisdom.dto.UserRigisterDto;
import co.jp.netwisdom.form.Userform;
import co.jp.netwisdom.service.UserRigsterService;

//处理前台请求
public class UserRegisterAction extends Action {
	
	
	private UserRigsterService userRigsterService = new UserRigsterService();
	
	
	// 获取前台请求的参数值
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Userform userform = (Userform) form;

		UserRigisterDto dto = new UserRigisterDto();
		dto.setUsername(userform.getUsername());
		dto.setPassword(userform.getPassword());
		dto.setSex(userform.getSex());
		dto.setMajor(userform.getMajor());
		dto.setIntro(userform.getIntro());
		dto.setHobby(userform.getHobby());

		boolean successFlag = userRigsterService.UserRigster(dto);

		// 判断导入数据是否成功并执行重定向
		if (successFlag) {
			return mapping.findForward("userReg");
		} else {
			return mapping.findForward("userNoReg");
		}
	}
}
