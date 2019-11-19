<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
	<head>
    	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
		<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
  		<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
        <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
		<title>图书更新</title>
		<style>
    		body{
    			background-color: rgb(245,246,247)
    		}
    		#navigation{
    			height:70px;
    		}
    		#main-page{
    			width:1000px;
    			height:800px;
    		}
    		#codingPart{
    			float:left;
    			width:500px;
    		}
    		#resultPart{
    			float:right;
    			width:500px;
    		}
    	</style>
    	<script language="javascript" type="text/javascript">
    	
    	</script>
	</head>
	
	<body>
		<div id="navigation">
			<nav class="navbar navbar-expand-sm bg-primary navbar-light fixed-top">
  				<a class="navbar-brand" style="font-size:30px" href="QueryBookStockServlet"><strong>在线书城</strong></a>
  				<ul class="navbar-nav">
    				<li class="nav-item">
      					<a class="nav-link" style="font-size:22px" href="QueryBookStockServlet">书库管理</a>
    				</li>
    				<li class="nav-item dropdown">
    					<a class="nav-link dropdown-toggle border border-top-0 border-bottom-0" data-toggle="dropdown" href="#" style="font-size:22px">我的</a>
    					<div class="dropdown-menu">
      						<a class="dropdown-item" href="RootCheckOrderServlet">订单管理</a>
      						<a class="dropdown-item" href="QueryDataServlet">账目</a>
      						<a class="dropdown-item" href="###">修改密码</a>
    					</div>
    				</li>
    				<li class="nav-item">
      					<a class="nav-link" style="font-size:22px" href="login.jsp">退出</a>
    				</li>
  				</ul>
			</nav>
		</div>
		<div id="main-page" class="mx-auto" style="text-align: center;">
		    <h2>${book_id}书籍信息更新</h2>
			<hr>
			<form method="post" class="form-inline" id="update" action="UpdateBookInfoServlet">
				<input type="text" id="name" name="name" class="form-control" placeholder="${book_name}">
				<input type="text" id="writer" name="writer" class="form-control" placeholder="${book_writer}">
				<input type="text" id="info" name="info" class="form-control" placeholder="${book_info}">
				<input type="number" id="price" name="price" min="0" step="0.01" class="form-control" style="width:150px;" placeholder="${book_price}">
				<input type="number" id="sum" name="sum" min="0" class="form-control" style="width:150px;" placeholder="${book_stock}">
				<input class="btn btn-primary" type="submit" style="text-align: center;" value="更新">
			</form>
		</div>
	</body>
</html>