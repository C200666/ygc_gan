<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="co.jp.netwisdom.dao.UserinfoHobbyDAO" %>
<%@ page import="co.jp.netwisdom.dao.HobbyDAO" %>
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
		<form action = "userSearch.do">
			姓名:
				<input type = "text" id="username" name="username" />
				<br>
				<br>
			性别:
				<input type="radio" name="sex"  id="sex1" value="0" />男
				<input type="radio" name="sex"  id="sex2" value="1" />女
				<br>
				<br>
			爱好:
				<input type="checkbox" id = "hobby" name="hobby" value="0" />唱
				<input type="checkbox" id = "hobby" name="hobby" value="1" />跳
				<input type="checkbox" id = "hobby" name="hobby" value="2" />rap
				<input type="checkbox" id = "hobby" name="hobby" value="3" />篮球
				<input type="checkbox" id = "hobby" name="hobby" value="4" />摸鱼
				<br>
				<br>
			专业:
				<select id="major" name = "major">
				<option value="" >-</option> 
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
				<%int i = 0; %>
				<%if(list != null){ %>
					<%for(UserinfoHobby UH : list){ i++;%>
					<%if(i % 2 == 0){ %><tr style=background-color:#9393FF>
					<%}else{ %><tr style=background-color:#FF8EFF><%} %>
					<td><a href="userUpdateinit.do?username=<%=UH.getUsername() %>"><%=UH.getUsername() %></a></td>
					<td><%=UH.getPassword() %></td> 
					<td>
						<%=UH.getSex().replace("0", "男").replace("1", "女") %>
					</td>
					<td>
						<%=UH.getHobby().replace("0", "唱").replace("1", "跳").replace("2", "rap").replace("3", "篮球").replace("4", "摸鱼")%>
					</td>
					<td>
						<%=UH.getMajor().replace("0", "软件工程").replace("1", "英语").replace("2", "数学")%>
					</td>
					<td><%=UH.getIntro() 	%></td>
					</tr><%} %><%} %>
			</table>
			
			
		</form>
	</body>
</html>