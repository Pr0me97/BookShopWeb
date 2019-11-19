<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
	<head>
    	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
		<link href="css/register.css" rel="stylesheet">
		<title>用户注册</title>
		<script language="javascript" type="text/javascript">
        function CheckForm() {
            if (document.register.username.value.length == 0||document.register.user_pwd1.value.length == 0||document.register.user_pwd2.value.length == 0) {
                alert("用户名或密码不能为空");
                return false;
            }else if(document.register.user_pwd1.value != document.register.user_pwd2.value){
            	alert("两次密码必须相同");
                return false;
            }
            return true;
        }
        var error='<%=request.getParameter("error")%>';
        if(error=='yes'){
        	alert("用户名被取走了");
        }
        
    	</script>
	</head>
	<body>
		<div class="container">
			<form id="register" name="register" method="post" class="form-register" onsubmit="return CheckForm();" action="RegisterServlet">
        		<h3 class="form-signin-heading" align="center">网上书店用户注册</h3>
       	 		<input type="text" id="username" name="username" class="form-control" placeholder="请输入用户名">
        		<input type="password" id="user_pwd1" name="user_pwd1" class="form-control" placeholder="请输入密码">
        		<input type="password" id="user_pwd2" name="user_pwd2" class="form-control" placeholder="请重复密码">
        		<br>
        		<input id="registerBtn" name="registerBtn" class="btn btn-lg btn-primary btn-block" type="submit" value="注册">
			</form>
		</div>
	</body>
</html>