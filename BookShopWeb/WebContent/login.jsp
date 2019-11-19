<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
	<head>
    	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
		<link href="css/signin.css" rel="stylesheet">
		<title>用户登录</title>
		<script language="javascript" type="text/javascript">
        function CheckForm() {
            if (document.login.username.value.length == 0||document.login.user_pwd.value.length == 0) {
                alert("用户名或密码不能为空");
                return false;
            }
            return true;
        }
        
        var error='<%=request.getParameter("error")%>';
        if(error=='yes'){
        	alert("用户名或密码有误");
        }
        
        var info='<%=request.getParameter("info")%>';
        if(info=='registerSuccess'){
        	alert("注册成功");
        }
    	</script>
	</head>
	<body>
		<div class="container">
			<form id="login" name="login" method="post" class="form-signin" onsubmit="return CheckForm();" action="LoginServlet">
        		<h3 class="form-signin-heading" align="center">网上书店系统</h3>
       	 		<input type="text" id="username" name="username" class="form-control" placeholder="请输入用户名">
        		<input type="password" id="user_pwd" name="user_pwd" class="form-control" placeholder="请输入密码">
        		<select id="user_type" name="user_type" class="form-control">
        			<option value="0" selected>会员</option>
      				<option value="1">管理员</option>
        		</select>
        		<br>
        		<input id="loginBtn" name="loginBtn" class="btn btn-lg btn-primary btn-block" type="submit" value="登录">
        		<br>
        		<input id="registerBtn" name="registerBtn" class="btn btn-lg btn-primary btn-block" type="button" onclick="window.location.href='register.jsp'" value="注册">
			</form>
		</div>
	</body>
</html>