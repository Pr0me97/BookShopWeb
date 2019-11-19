<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
    	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
		<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
  		<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
        <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
		<title>订单详情</title>
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
    		#buyBtn{
    			width:200px;
    		}
    	</style>
	</head>
	
	<body>
		<div id="navigation">
			<nav class="navbar navbar-expand-sm bg-primary navbar-light fixed-top">
  				<a class="navbar-brand" style="font-size:30px" href="QueryBookListServlet"><strong>在线书城</strong></a>
  				<ul class="navbar-nav">
    				<li class="nav-item">
      					<a class="nav-link" style="font-size:22px" href="QueryBookListServlet">书库</a>
    				</li>
    				<li class="nav-item dropdown">
    					<a class="nav-link dropdown-toggle border border-top-0 border-bottom-0" data-toggle="dropdown" href="#" style="font-size:22px">我的</a>
    					<div class="dropdown-menu">
      						<a class="dropdown-item" href="QueryMyOrderServlet">我的订单</a>
      						<a class="dropdown-item" href="QueryMyTrolleyServlet">我的购物车</a>
      						<a class="dropdown-item" href="###">修改密码</a>
    					</div>
    				</li>
    				<li class="nav-item">
      					<a class="nav-link" style="font-size:22px" href="login.jsp">退出</a>
    				</li>
  				</ul>
			</nav>
		</div>
		<div id="main-page" class="mx-auto">
			<form id="myTrolley" name="myTrolley" method="post" action="PlaceOrderServlet">
				<table class="table table-striped table-bordered table-hover">
					<tbody>
						<tr>
							<td colspan="3" style="text-align:center;color:red"><strong style="font-size:16pt;color:black">订单详情</strong></td></tr>
                	        <tr style="background-color:lightgoldenrodyellow">
            	            <th width="25%">书籍ID</th>
            	            <th width="25%">书名</th>
            	            <th width="25%">价格</th>
            	        </tr>
					</tbody>
					<c:forEach var="e" items="${orderDetailList}">
						<tr>
	           				<td>${e.id}</td>
             				<td>${e.name}</td>
             				<td>${e.price}</td>
     					</tr>
     				</c:forEach>
     				<tr><td colspan="3" style="text-align: right">总价：${sum_price}</td></tr>
				</table>
			</form>
		</div>
	</body>
</html>