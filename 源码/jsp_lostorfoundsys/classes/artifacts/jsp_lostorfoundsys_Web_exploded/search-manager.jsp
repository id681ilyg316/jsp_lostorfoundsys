<%@page import="bean.Xiaoxi"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.XiaoxiDao"%>
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
			
			<%
				XiaoxiDao xiaoxi = new XiaoxiDao();
				ArrayList<Xiaoxi> xiaoxiList = xiaoxi.findsearchAll();
			%>
			<div class="menu_right">
				<div class="menu_right_head">
					<h3>寻物信息管理</h3>
				</div>
				<div class="menu_right_main">
					<div class="menu_table">
						<%
							Xiaoxi xx ;
							for(int i=0;i<xiaoxiList.size();i++){
							xx = (Xiaoxi)xiaoxiList.get(i);					
						%>
						<table>
							<tr>
								<td width="80px">类型</td>
								<td width="200px">主题</td>
								<td width="60px">物品</td>
								<td width="600px">内容</td>
							</tr>
							<tr>
								<td>寻物</td>
								<td><%=xx.getZhuti() %></td>
								<td><%=xx.getWupin() %></td>
								<td><%=xx.getNeirong() %></td>
							</tr>
							<tr>
								<td>联系人</td>
								<td>联系方式</td>
								<td>时间</td>
								<td>操作</td>
							</tr>
							<%
								request.setAttribute("id", xx.getId());
							%>
							<tr>
								<td><%=xx.getLianxiren() %></td>
								<td><%=xx.getTel() %></td>
								<td><%=xx.getShijian() %></td>
								<td><a href="xiaoxiServlet?method=deleteById_xiaoxi1&id=<%=xx.getId() %>">删除</a></td>
							</tr>
						</table>
						<hr>
						<%
							}
						%>
					</div>
				</div>
			</div>			
			
		</div>
	</div>
	
</body>
</html>
