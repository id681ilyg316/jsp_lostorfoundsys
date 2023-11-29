<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="css/style.css" type="text/css" rel="stylesheet"/>
	<link href="css/main.css" type="text/css" rel="stylesheet"/>
	<link href="css/post.css" type="text/css" rel="stylesheet"/>
<title>请先登录，登录后即可使用寻物招领平台</title>
</head>

<body>
	
	<!--顶部信息--登录信息-->
	<div id="top">
		<div class="top">
			<p>欢迎登录</p>
		</div>
	</div>
	
	<!--头部信息--导航栏-->
	<div id="head">
		<div class="head">
			<div class="head_1">
				<p>丢哪了？</p>
			</div>
			<div class="head_2">
				<p>登录成功后即可进入系统管理员界面</p>
			</div>
		</div>
	</div>
	
	<div id="login">
		<div class="login">
			<center>
				<form name="login" action="guanliyuanServlet?method=login" method="post">
					管理员账号：<input type="text" name="zhanghao" value="" placeholder="管理员账号"/>
					<br/>
					密&nbsp;&nbsp;&nbsp;码：<input type="password" name="mima" value="" placeholder="******"/>
					<br/>
					<br/><br/>
					<button class="login_button" type="submit">登录</button><br/><br/>
				</form>
			</center>
		</div>
	</div>
	
 
	
</body>
</html>