﻿<html>
<head>
<title>用户注册页面</title>

</head>


<body style="text-align:center">
	<form action = "userRegister.do">
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
			<input type="checkbox" id = "hobby" name="hobby" value="0" />唱
			<input type="checkbox" id = "hobby" name="hobby" value="1" />跳
			<input type="checkbox" id = "hobby" name="hobby" value="2" />rap
			<input type="checkbox" id = "hobby" name="hobby" value="3" />篮球
			<input type="checkbox" id = "hobby" name="hobby" value="4" />摸鱼
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