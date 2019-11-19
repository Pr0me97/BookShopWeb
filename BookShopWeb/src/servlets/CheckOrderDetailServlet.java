package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.OrderDao;
import entity.Order;

public class CheckOrderDetailServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=(String) request.getSession().getAttribute("username");
		String order_id=request.getParameter("order_id");
		List<Order> olist=OrderDao.queryOrderDetail(username, order_id);
		float sum_price=OrderDao.queryOrderSumPrice(order_id);
		request.getSession().setAttribute("orderDetailList", olist);
		request.getSession().setAttribute("sum_price", sum_price);
		response.sendRedirect("checkOrderDetail.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
