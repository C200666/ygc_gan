<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> <!-- 标签定义 -->
<html>
	<head>
		<title>用户注册页面</title>
	</head>
	<script src="jquery-3.2.1.min.js"></script>
	
	<script>
	function executeAjax(){
		$.ajax({
			url : 'userNameCheck.do?username=' + document.getElementById("username").value,
			type : 'get',  //数据发送方式
			dateType : 'text',	//接收数据格式
			error : function(flag){
			},
			async : true,
			success : function(flag){
				if(flag=="0"){
					document.getElementById("flag").innerHTML="用户名可使用";
					document.getElementById("userReg").disabled = false;
				}else{
					document.getElementById("flag").innerHTML="用户名已存在";
					document.getElementById("userReg").disabled = "disabled";
				}
			}
		});
	}
	</script>

	<body style="text-align:center">
		<form action = "userRegister.do">
		<!-- bundle= struts-config.xml文件下的key  key= applicationResources_zh_CN.properties 文件下的 name  -->
			<bean:message bundle="userResources" key="username"/>:
				<input onblur="executeAjax()" type = "text" id="username" name="username" />
				<br>
				<div><font color="red" id="flag"></font></div>
			   	<br>
			<bean:message bundle="userResources" key="password"/>:
				<input type="password" id="password" name = "password" />
				<br>
				<br>
			<bean:message bundle="userResources" key="sex"/>:
				<input type="radio" name="sex" checked id="sex1" value="0" /><bean:message bundle="userResources" key="male"/>
				<input type="radio" name="sex"         id="sex2" value="1" /><bean:message bundle="userResources" key="female"/>
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
				<select id="major" name = "major">
				<option value="0" ><bean:message bundle="userResources" key="software"/></option>
				<option value="1" ><bean:message bundle="userResources" key="english"/></option>
				<option value="2" ><bean:message bundle="userResources" key="math"/></option> 
				</select>
				<br>
				<br>
			<bean:message bundle="userResources" key="intro"/>:
				<br>	
				<textarea id="intro" name = "intro">ligiaowuligiaogiao</textarea>
				<br>
				<br>
			
			<input type="submit" value="<bean:message bundle="userResources" key="userRegister"/>" id="userReg"/>
			<input type="reset"  value="<bean:message bundle="userResources" key="reset"/>" />
		</form>
	</body>
</html>