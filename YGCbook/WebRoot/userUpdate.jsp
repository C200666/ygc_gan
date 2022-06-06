<%@page import="java.sql.Date"%>
<%@page import="co.jp.netwisdom.entity.Userinfo"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="co.jp.netwisdom.dao.UserinfoHobbyDAO" %>
<%@ page import="co.jp.netwisdom.dao.HobbyDAO" %>
<%@ page import="co.jp.netwisdom.dto.UserinfoHobbyDto" %>
<%@ page import="co.jp.netwisdom.entity.UserinfoHobby" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<% 	UserinfoHobby list = (UserinfoHobby)request.getAttribute("data");%>





<html>
<head>
<title>用户更新页面</title>

<script>
function changeActionName(changeActionName){
	document.getElementById("form").action="userDel.do";
	}
</script>
</head>


   
<body style="text-align:center">
	<%if(list != null){%>
	<form action = "userUpdate.do" id="form">
		姓名:
			<input type = "text" id="username" name="username" readonly value="<%=list.getUsername() %>">
			<br>
		   	<br>
		   	
		密码:
			<input type="password" id="password" name = "password" value="<%=list.getPassword() %>"/>
			<br>
			<br>
		性别:
			<input type="radio" name="sex"  id="sex1" value="0" <%if("0".equals(list.getSex())){%>checked<%} %>/>男
			<input type="radio" name="sex"  id="sex2" value="1" <%if("1".equals(list.getSex())){%>checked<%} %>/>女
			<br>
			<br>
		爱好:
			<input type="checkbox" id = "hobby" name="hobby" value="0" <%if(list.getHobby().contains("0")){%>checked<%} %>/>唱
			<input type="checkbox" id = "hobby" name="hobby" value="1" <%if(list.getHobby().contains("1")){%>checked<%} %>/>跳
			<input type="checkbox" id = "hobby" name="hobby" value="2" <%if(list.getHobby().contains("2")){%>checked<%} %>/>rap
			<input type="checkbox" id = "hobby" name="hobby" value="3" <%if(list.getHobby().contains("3")){%>checked<%} %>/>篮球
			<input type="checkbox" id = "hobby" name="hobby" value="4" <%if(list.getHobby().contains("4")){%>checked<%} %>/>摸鱼
			<br>
			<br>
			
		专业:
			<select id="major" name = "major">
			<option value="0" <%if("0".equals(list.getMajor())){%>selected<%} %>>软件工程</option>
			<option value="1" <%if("1".equals(list.getMajor())){%>selected<%} %>>英语</option>
			<option value="2" <%if("2".equals(list.getMajor())){%>selected<%} %>>数学</option> 
			</select>
			<br>
			<br>
		简介:	
			<br>	
			<textarea id="intro" name = "intro" ><%=list.getIntro() %></textarea>
			<br>
			<br>
		
		<input type="submit" value="更新用户"  />
		<input type="submit" value="删除用户" onclick="changeActionName('userDel')" />
		<input type="reset"  value="重置" />
		<%}%>
	</form>
</body>
</html>