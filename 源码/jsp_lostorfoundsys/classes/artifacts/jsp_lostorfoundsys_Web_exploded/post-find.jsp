<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="css/style.css" type="text/css" rel="stylesheet"/>
	<link href="css/main.css" type="text/css" rel="stylesheet"/>
	<link href="css/post.css" type="text/css" rel="stylesheet"/>
<title>发布招领信息——寻物招领平台</title>
</head>

<body>
	
	<%@include file="head.jsp" %>
	
	<!--寻物启事-->
	<div id="post">
		<div class="post_left">
			<div class="post_head">
				<h4>你正在发布招领信息</h4>
			</div>
			<div class="post_form">
				<form action="xiaoxiServlet?method=add_Findxiaoxi" enctype="multipart/form-data">
					<tbody>
						<tr><td>信息标题：<input type="text" size="40" name="zhuti"></td></tr><br/>
						<tr><td>捡到物品：<input type="text" size="20" name="wupin"></td></tr><br/>
						<tr><td>详细内容：<br/><textarea name="neirong" class="textarea"></textarea></td></tr><br/>
						<tr><td><p>请上传JPG格式图片</p>
						上传图片：<input type="file" name="pic"> 
     					</td></tr><br/>
						<tr><td>联系人&nbsp;：<input type="text" size="20" name="lianxiren"></td></tr><br/>
						<tr><td>联系电话：<input type="text" size="20" name="tel"></td></tr><br/>
						<tr><td><input class="post_button" type="submit" value="发布"></td></tr>
					</tbody>
				</form>
			</div>
		</div>
		<div class="post_right">
			<img src="images/select-zhao.png" width="131" height="131" alt=""/>
		</div>
		
	</div>
	
	
</body>
</html>