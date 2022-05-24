<html>
<head>
<title>用户注册页面</title>

</head>


<body style="text-align:center">
	<form action = "userRegister">
		姓名:
			<input type = "text" id="username" name="username" />
			<br>
		   	<br>
		密码:
			<input type="password" id="password" name = "password" />
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
			<option value="0" >软件工程</option>
			<option value="1" >英语</option>
			<option value="2" >数学</option> 
			</select>
			<br>
			<br>
		简介:
			<br>	
			<textarea id="intro" name = "intro">ligiaowuligiaogiao</textarea>
			<br>
			<br>
		
		<input type="submit" value="注册用户" />
		<input type="reset"  value="重置" />
	</form>
</body>
</html>