<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" type="text/css" rel="stylesheet"/>
	<link href="css/main.css" type="text/css" rel="stylesheet"/>
	<link href="css/post.css" type="text/css" rel="stylesheet"/>
<title>管理员后台——寻物招领平台</title>
</head>

<body>
	
	<!--顶部信息--登录信息-->
	<div id="top">
		<div class="top">
			<p>你好：管理员</p>
		</div>
	</div>
	
	<!--头部信息--导航栏-->
	<div id="head">
		<div class="head">
			<div class="head_1">
				<p>丢哪了？</p>
			</div>
			<div class="head_2">
				<p>管理员后台————欢迎</p>
			</div>
		</div>
	</div>
	
	<div id="menu">
		<div class="menu">
			
			<%@include file="admin-menu.jsp" %>
			
			<div class="menu_right">
				<div class="menu_right_head">
					<h3>欢迎访问寻物招领平台——后台管理</h3>
				</div>
			</div>			
			
		</div>
	</div>
	
</body>
</html>
