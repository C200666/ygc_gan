<%@page import="java.sql.Date"%>
<%@page import="co.jp.netwisdom.entity.Userinfo"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="co.jp.netwisdom.dao.UserinfoHobbyDAO" %>
<%@ page import="co.jp.netwisdom.dao.HobbyDAO" %>
<%@ page import="co.jp.netwisdom.dto.UserinfoHobbyDto" %>
<%@ page import="co.jp.netwisdom.entity.UserinfoHobby" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
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
		<bean:message bundle="userResources" key="username"/>:
			<input type = "text" id="username" name="username" readonly value="<%=list.getUsername() %>">
			<br>
		   	<br>
		   	
		<bean:message bundle="userResources" key="password"/>:
			<input type="password" id="password" name = "password" value="<%=list.getPassword() %>"/>
			<br>
			<br>
		<bean:message bundle="userResources" key="sex"/>:
			<input type="radio" name="sex"  id="sex1" value="0" <%if("0".equals(list.getSex())){%>checked<%} %>/><bean:message bundle="userResources" key="male"/>
			<input type="radio" name="sex"  id="sex2" value="1" <%if("1".equals(list.getSex())){%>checked<%} %>/><bean:message bundle="userResources" key="female"/>
			<br>
			<br>
		<bean:message bundle="userResources" key="hobby"/>:
			<input type="checkbox" id = "hobby" name="hobby" value="0" <%if(list.getHobby().contains("0")){%>checked<%} %>/><bean:message bundle="userResources" key="song"/>
			<input type="checkbox" id = "hobby" name="hobby" value="1" <%if(list.getHobby().contains("1")){%>checked<%} %>/><bean:message bundle="userResources" key="jump"/>
			<input type="checkbox" id = "hobby" name="hobby" value="2" <%if(list.getHobby().contains("2")){%>checked<%} %>/><bean:message bundle="userResources" key="rap"/>
			<input type="checkbox" id = "hobby" name="hobby" value="3" <%if(list.getHobby().contains("3")){%>checked<%} %>/><bean:message bundle="userResources" key="basketball"/>
			<input type="checkbox" id = "hobby" name="hobby" value="4" <%if(list.getHobby().contains("4")){%>checked<%} %>/><bean:message bundle="userResources" key="touchfish"/>
			<br>
			<br>
			
		<bean:message bundle="userResources" key="major"/>:
			<select id="major" name = "major">
			<option value="0" <%if("0".equals(list.getMajor())){%>selected<%} %>><bean:message bundle="userResources" key="software"/></option>
			<option value="1" <%if("1".equals(list.getMajor())){%>selected<%} %>><bean:message bundle="userResources" key="english"/></option>
			<option value="2" <%if("2".equals(list.getMajor())){%>selected<%} %>><bean:message bundle="userResources" key="math"/>:</option> 
			</select>
			<br>
			<br>
		<bean:message bundle="userResources" key="intro"/>:	
			<br>	
			<textarea id="intro" name = "intro" ><%=list.getIntro() %></textarea>
			<br>
			<br>
		
		<input type="submit" value="<bean:message bundle="userResources" key="userupdate"/>"  />
		<input type="submit" value="<bean:message bundle="userResources" key="userdelete"/>" onclick="changeActionName('userDel')" />
		<input type="reset"  value="<bean:message bundle="userResources" key="reset"/>" />
		<%}%>
	</form>
</body>
</html>