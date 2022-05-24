<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="co.jp.netwisdom.dao.UserinfoHobbyDAO" %>
<%@ page import="co.jp.netwisdom.dto.UserinfoHobbyDto" %>
<%@ page import="co.jp.netwisdom.entity.UserinfoHobby" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<% List<UserinfoHobby> list = (List<UserinfoHobby>)request.getAttribute("date");%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>用户检索页面</title>
	</head>


	<body style="text-align:center">
		<form action = "userSearch">
			姓名:
				<input type = "text" id="username" name="username" />
				<br>
				<br>
			性别:
				<input type="radio" name="sex" checked id="sex1" value="0" />男
				<input type="radio" name="sex"         id="sex2" value="1" />女
				<br>
				<br>
			爱好:
				<input type="checkbox" id = "hobby" name="hobby" value="0" />抠痞子
				<input type="checkbox" id = "hobby" name="hobby" value="1" />挂马子
				<input type="checkbox" id = "hobby" name="hobby" value="2" />追疯子
				<input type="checkbox" id = "hobby" name="hobby" value="3" />操傻子
				<input type="checkbox" id = "hobby" name="hobby" value="4" />扒老太太裤衩子
				<br>
				<br>
			专业:
				<select id="major" name = "major">
				<option value="" ></option> 
				<option value="0" >软件工程</option>
				<option value="1" >英语</option>
				<option value="2" >数学</option> 
				</select>
				<br>
				<br>
			
			<input type="submit" value="检索" />
			<input type="reset"  value="重置" />
			<br>
			<br>
			
			检索一览
			<hr>
			
			<table border="1" style="width:100%;text-align:center;">
				<tr style="background-color:#39C5BB">
				<th>姓名</th>
				<th>密码</th>
				<th>性别</th>
				<th>爱好</th>
				<th>专业</th>
				<th>简介</th>
				</tr>
				<%if(list != null){ %>
				<%for(UserinfoHobby UIH : list){ %>
				<tr>
				<td><%=UIH.getUsername() %></td>
				<td><%=UIH.getPassword() %></td> 
				<td><%=UIH.getSex() 	 %></td>
				<td><%=UIH.getHobby() 	 %></td>
				<td><%=UIH.getMajor()	 %></td>
				<td><%=UIH.getIntro() 	 %></td>
				</tr><%} %><%} %>
			</table>
			
			
		</form>
	</body>
</html>