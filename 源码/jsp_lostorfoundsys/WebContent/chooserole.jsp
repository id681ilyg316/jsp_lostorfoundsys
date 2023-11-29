<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>选择身份，进行登录</title>
    </head>
    <body>
    	<h4>请选择您的身份</h4>
		<form action="" method="post">
			<p>
				<input type="radio" name="login" value="admin"/>管理员
			    <input type="radio" name="login" value="user"/>普通用户
			</p>
		</form>
 	</body>
</html>