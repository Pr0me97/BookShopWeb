package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.OrderDao;
import entity.Order;

public class QueryMyOrderServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=(String)request.getSession().getAttribute("username");
		List<Order> olist=OrderDao.queryMyOrder(username);
		request.getSession().setAttribute("olist", olist);
		String addFlag=request.getParameter("addFlag");
		if("success".equals(addFlag)) {
			response.sendRedirect("myOrder.jsp?addFlag=success");
		}else
			response.sendRedirect("myOrder.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
