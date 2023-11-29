<%@page import="bean.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>

	<!--顶部信息--登录信息-->
	
	
	<div id="top">
		
		<div class="top">
			<p>你好：欢迎使用寻物招领平台</p>
		</div>
	</div>
	
	<!--头部信息--导航栏-->
	<div id="head">
		<div class="head">
			<div class="head_1">
				<a href="index.jsp"><p>丢哪了？</p></a>
			</div>
			<div class="head_2">
				<a href="search.jsp"><p>寻物</p></a>
			</div>
			<div class="head_3">
				<a href="find.jsp"><p>招领</p></a>
			</div>

			<div class="head_4">
				<a target="_blank" href="login.jsp"><p>管理后台</p></a>
			</div>
			<div class="head_5">
				<form name="search" action="xiaoxiServlet?method=findMohu_Xiaoxi" method="post">
					<input type="text" placeholder="输入物品特征快速搜索" name="zhuti" class="search">
					<button class="search_text" type="submit"></button>
				</form>
			</div>

		</div>
	</div>
	
</body>
</html>