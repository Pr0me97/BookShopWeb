package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.OrderDao;
import entity.Order;

public class RootCheckOrderDetailServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String order_id=request.getParameter("order_id");
		List<Order> olist=OrderDao.rootQueryOrderDetail(order_id);
		float sum_price=OrderDao.queryOrderSumPrice(order_id);
		request.getSession().setAttribute("rootCheckOrderDetailList", olist);
		request.getSession().setAttribute("sum_price", sum_price);
		response.sendRedirect("rootCheckOrderDetail.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
