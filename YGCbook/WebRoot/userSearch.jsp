<%@page import="co.jp.netwisdom.form.Userform"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="co.jp.netwisdom.dao.UserinfoHobbyDAO" %>
<%@ page import="co.jp.netwisdom.dao.HobbyDAO" %>
<%@ page import="co.jp.netwisdom.dto.UserinfoHobbyDto" %>
<%@ page import="co.jp.netwisdom.entity.UserinfoHobby" %>
<%@ page import="co.jp.netwisdom.form.Userform" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<% List<UserinfoHobby> list = (List<UserinfoHobby>)request.getAttribute("date");%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>用户检索页面</title>
		
		<script src="jquery-3.2.1.min.js"></script>
		
		<script>
        function checkAll(){
            
            var checkboxs = document.getElementsByName("checkOne");
            var checkOne = false;
                for(var i=0;i<checkboxs.length;i++){
                    if(document.getElementById("checkedAll").checked){
                        checkOne = true;
                }
                    checkboxs[i].checked=checkOne;
            }
        }
        function changeActionName(changeActionName){
        	document.getElementById("form").action="userDelAll.do";
        }
        
        function userUpdate(username){
        	window.location.href="userUpdateinit.do?username=" + username;
        }
        
        function userDel(username){
        	window.location.href="userDel.do?username=" + username;
        }
        
        
        function executeAjax(){
        	var sex;
        	if(document.getElementsByName("sex")[0].checked){
        		sex = 0;
        	}else if(document.getElementsByName("sex")[1].checked){
        		sex = 1;
        	}else{
        		sex = "";
        	}
        	var major = document.getElementById("major").value;
        	//TODO获取完整的爱好列表
        	$.ajax({
        		url : 'userNameSearch.do?username=' + document.getElementById("username").value+'&sex='+ sex +'&major='+ major,
        		type : 'post', // 数据发送方式
        		dataType : 'json', // 接受数据格式
        		async : true,// 异步加载
        		success : function(users) {
        			// 删除第一行列表
            		while($("#table tr").length>1){
            			$("#table tr").eq(1).remove();
            		}
        			for(var i = 0;i<users.users.length; i++){
        				username = users.users[i].username;
        				password = users.users[i].password;
        				sex = users.users[i].sex.replace("0", "男").replace("1", "女");
        				
        				hobby = users.users[i].hobby.replace("0", "唱").replace("1", "跳").replace("2", "rap").replace("3", "篮球").replace("4", "摸鱼");
        				
        				major = users.users[i].major.replace("0", "软件工程").replace("1", "英语").replace("2", "数学");
        				
        				intro = users.users[i].intro;
        				
        				var bgc;
        				if(i % 2 == 0){
        					bgc="#9393FF";
    					}else{
    						bgc="#FF8EFF";
    					} 
        				
        				
        				var usertable =
        					'<tr bgcolor="'+ bgc +'">'+
        				'<td style="width:3px"><input type="checkbox" name="checkOne" value='+ username +'></td>'+
        				'<td><a href="userUpdateinit.do?username='+username+'">'+username+'</a></td>'+
        				'<td >' + password + '</td>'+
        				'<td >' + sex + '</td>'+
        				'<td >' + hobby + '</td>'+
        				'<td >' + major + '</td>'+
        				'<td >' + intro + '</td>'+
        				'<td ><input type="button" value="更新" onClick=userUpdate('+ username +')></td>'+
        				'<td ><input type="button" value="删除" onClick=userDel('+ username +')></td>'+
        				'</tr>';
        				$("#table").append(usertable);
	        		}
        			$("#table").append('<tr>'+
        					'<td colspan="9">'+
        					'<input type="submit" value="一括删除" onclick="changeActionName()">'+
        					'</td>'+
        			'</tr>');
	        	},
        		error : function(users) {alert(456);}
        	});
        }
		</script>
		
	</head>
	<body style="text-align:center">
		<form action="userSearch.do" id="form">
			<bean:message bundle="userResources" key="username"/>:
				<input onblur="executeAjax()" type = "text" id="username" name="username" />
				<br>
				<br>
			<bean:message bundle="userResources" key="sex"/>:
				<input onblur="executeAjax()" type="radio" name="sex"  id="sex1" value="0" /><bean:message bundle="userResources" key="male"/>
				<input onblur="executeAjax()" type="radio" name="sex"  id="sex2" value="1" /><bean:message bundle="userResources" key="female"/>
				<br>
				<br>
			<bean:message bundle="userResources" key="hobby"/>:
				<input type="checkbox" id = "hobby" name="hobby" value="0" /><bean:message bundle="userResources" key="song"/>
				<input type="checkbox" id = "hobby" name="hobby" value="1" /><bean:message bundle="userResources" key="jump"/>
				<input type="checkbox" id = "hobby" name="hobby" value="2" /><bean:message bundle="userResources" key="rap"/>
				<input type="checkbox" id = "hobby" name="hobby" value="3" /><bean:message bundle="userResources" key="basketball"/>
				<input type="checkbox" id = "hobby" name="hobby" value="4" /><bean:message bundle="userResources" key="touchfish"/>
				<br>
				<br>
			<bean:message bundle="userResources" key="major"/>:
				<select onblur="executeAjax()" id="major" name = "major">
				<option value="" >-</option> 
				<option value="0" ><bean:message bundle="userResources" key="software"/></option>
				<option value="1" ><bean:message bundle="userResources" key="english"/></option>
				<option value="2" ><bean:message bundle="userResources" key="math"/></option> 
				</select>
				<br>
				<br>
			
			<input type="submit" value="<bean:message bundle="userResources" key="inquire"/>" />
			<input type="reset"  value="<bean:message bundle="userResources" key="reset"/>" />
			<br>
			<br>
			
			<bean:message bundle="userResources" key="information"/>
			<hr>
			
			<table id="table" border="1" style="width:100%;text-align:center;">
				<tr style="background-color:#39C5BB">
				<td><input type="checkbox" onclick="checkAll()" id="checkedAll" /></td>
				<th><bean:message bundle="userResources" key="username"/></th>
				<th><bean:message bundle="userResources" key="password"/></th>
				<th><bean:message bundle="userResources" key="sex"/></th>
				<th><bean:message bundle="userResources" key="hobby"/></th>
				<th><bean:message bundle="userResources" key="major"/></th>
				<th><bean:message bundle="userResources" key="intro"/></th>
				<th><bean:message bundle="userResources" key="update"/></th>
				<th><bean:message bundle="userResources" key="delete"/></th>
				</tr>
				<%int i = 0; %>
				<%if(list != null){ %>
					<%for(UserinfoHobby UH : list){ i++;%>
					<%if(i % 2 == 0){ %><tr style=background-color:#9393FF>
					<%}else{ %><tr style=background-color:#FF8EFF><%} %>
					<td><input type="checkbox" name="checkOne" value="<%=UH.getUsername() %>" /></td>
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
					<td><%=UH.getIntro() %></td>
					
					<td><input type="button" value="<bean:message bundle="userResources" key="update"/>" onClick="window.location.href='userUpdateinit?username=<%=UH.getUsername() %>'" /></td>
					<td><input type="button" value="<bean:message bundle="userResources" key="delete"/>" onClick="window.location.href='userDel?username=<%=UH.getUsername() %>'" /></td>
					</tr>
					<%} %><%} %>
					<tr>
					<td colspan="9"><input type="submit" value="<bean:message bundle="userResources" key="deleteall"/>" onClick="changeActionName()" /></td>
					</tr>
					
			</table>
		</form>
	</body>
</html>