package co.jp.netwisdom.action;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import co.jp.netwisdom.dao.UserinfoHobbyDAO;
import co.jp.netwisdom.dto.HobbyDto;
import co.jp.netwisdom.dto.UserinfoHobbyDto;
import co.jp.netwisdom.entity.UserinfoHobby;
import co.jp.netwisdom.form.Userform;

public class UserSearchAction extends Action {
//	获取前台请求的参数值
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		Userform userform = (Userform) form;
		
		
		String username = userform.getUsername();
		String sex = userform.getSex();
		String major = userform.getMajor();
		String intro = userform.getIntro();
		String hobby = request.getParameter("hobby");
		
		
//		新规DAO对象
		UserinfoHobbyDAO userinfoHobbyDAO = new UserinfoHobbyDAO();
//		传入输入的姓名性别等参数
		List<UserinfoHobby> list = userinfoHobbyDAO.findUserinfoAndHobby(username, sex, major,intro,hobby);
		
		List<UserinfoHobbyDto> UserinfoHobbyDto = new ArrayList<UserinfoHobbyDto>();
//		 标识dto是否被创建
 		List<String> userNames = new ArrayList<String>();
		
		System.out.println("用户信息如下");
		for(UserinfoHobby UserinfoHobby:list){
			
//			当用户名不存在时，证明UserinfoHobbydto未创建
			if(!userNames.contains(UserinfoHobby.getUsername())){
				UserinfoHobbyDto dto = new UserinfoHobbyDto(UserinfoHobby.getUsername(),
															UserinfoHobby.getPassword(), 
															UserinfoHobby.getSex(), 
															UserinfoHobby.getMajor(), 
															UserinfoHobby.getIntro());
//				将创建的UserinfoHobbydto加到画面展示中去
				UserinfoHobbyDto.add(dto);
//				将用户名加到用户名List里去
				userNames.add(UserinfoHobby.getUsername());
//				将爱好加入子dto中
				dto.getHobbyList().add(new HobbyDto(UserinfoHobby.getHobby()));
			}else{
//				取得以往添加过得大dto
				for(UserinfoHobbyDto temp: UserinfoHobbyDto){
					if(temp.getUsername().equals(UserinfoHobby.getUsername())){
//						将爱好加入子dto中
						temp.getHobbyList().add(new HobbyDto(UserinfoHobby.getHobby()));
					}
				}
				
			}
			
		}
		for(UserinfoHobbyDto result: UserinfoHobbyDto){
				System.out.println("姓名：" + result.getUsername());
				System.out.println("密码：" + result.getPassword());
				System.out.println("性别：" + result.getSex());
				System.out.println("专业：" + result.getMajor());
				System.out.println("简介：" + result.getIntro());
				System.out.print("爱好：");
				for(HobbyDto hobbyDto: result.getHobbyList()){
					
					System.out.print(hobbyDto.getHobby());
				}
				System.out.println();
				System.out.println("---------------------------------------------------------------------------------");
			}
		
			request.setAttribute("date",list);
		
		
			return mapping.findForward("userSearch");
		
		
	}
	
}
 