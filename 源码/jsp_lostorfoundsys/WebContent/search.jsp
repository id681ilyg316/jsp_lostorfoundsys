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
<title>寻物招领平台</title>
</head>

<body>
	
	<%@include file="head.jsp" %>
 
	
	<!--失物招领信息-->
	<div id="main">
		<div class="main">
			<center><h4>最新寻物启事</h4></center>
			
			<%
				XiaoxiDao xiaoxi = new XiaoxiDao();
				ArrayList<Xiaoxi> xiaoxiList = xiaoxi.findsearchAll();
			%>
			<div class="main_left">
			
				<%
					Xiaoxi xx ;
					for(int i=0;i<xiaoxiList.size();i++){
					xx = (Xiaoxi)xiaoxiList.get(i);					
				%>
				<div class="main_center">
					<div class="main_center_title">
						<h4><%=xx.getZhuti() %></h4>
					</div>
					<hr>
					<div class="main_center_text">
						<p><b>【寻物】<%=xx.getWupin() %></b><br/><%=xx.getNeirong() %></p>
					</div>
					<div class="main_center_image">
					<%
						String fileName = xx.getImagesName();
						//System.out.println("./imgs/"+fileName);
					%>
						<img src="./imgs/<%=fileName %>"   style="height:200px;weight:200px"/>
					</div>
					<hr>
					<div class="main_center_tel">
						<div class="main_center_tel_left">
							<p>联系人：<%=xx.getLianxiren() %></p>
						</div>
						<div class="main_center_tel_right">
							<p>联系方式：<%=xx.getTel() %></p>
						</div>
					</div>
					<hr>
					<div class="main_center_date">
						<span>时间：<%=xx.getShijian() %></span>
					</div>
				</div>
				<%
					}
				%>
			</div>
		</div>
	</div>
	
	
	<!--底部信息
	<div id="foot">
		<div class="foot">
			<center><h4>版权归个人所有</h4></center>
		</div>
	</div>-->
	
</body>
</html>