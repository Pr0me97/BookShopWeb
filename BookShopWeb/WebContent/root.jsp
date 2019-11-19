<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
    	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
		<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
  		<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
        <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
		<title>管理员主页</title>
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
		    <h2>图书库存管理</h2>
			<hr>
			<h5>进货：</h5>
			<form method="post" class="form-inline" id="import" action="ImportBookServlet">
				<input type="text" id="book_id" name="book_id" class="form-control" placeholder="书籍ID">
				<input type="text" id="book_name" name="book_name" class="form-control" placeholder="书名">
				<input type="text" id="book_writer" name="book_writer" class="form-control" placeholder="作者">
				<input type="number" id="book_price" name="book_price" min="0" step="0.01" class="form-control" style="width:150px;" placeholder="价格">
				<input type="number" id="sum" name="sum" min="0" class="form-control" style="width:150px;" placeholder="进货量">
				<input class="btn btn-primary" type="submit" style="text-align: center;" value="进货">
			</form>
			<hr>
			<table class="table table-striped table-bordered table-hover">
				<tbody>
					<tr>
						<td colspan="6" style="text-align:center;color:red"><strong style="font-size:16pt;color:black">书库</strong></td></tr>
                        <tr style="background-color:lightgoldenrodyellow">
                        <th width="20%">书籍ID</th>
                        <th width="20%">书名</th>
                        <th width="20%">作者</th>
                        <th width="10%">价格</th>
                        <th width="20%">库存</th>
                        <th width="10%">操作</th>
                    </tr>
				</tbody>
				<c:forEach var="e" items="${book_StockList}">
					<tr>
	           			<td>${e.id}</td>
             			<td>${e.name}</td>
             			<td>${e.writer}</td>
             			<td>${e.price}</td>
             			<td>${e.stock}</td>
             			<td>
             				<a href="ImportBookExistServlet?book_id=${e.id}">进货</a>
             				<a href="QueryBookInfoServlet?book_id=${e.id}">更新</a>
             			</td>
     			</tr>
     			</c:forEach>
			</table>
		</div>
	</body>
</html>