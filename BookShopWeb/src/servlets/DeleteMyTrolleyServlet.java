package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.MyTrolleyDao;

public class DeleteMyTrolleyServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String book_id=request.getParameter("book_id");
		String username=(String) request.getSession().getAttribute("username");
		MyTrolleyDao.deleteMyTrolley(username, book_id);
		response.sendRedirect("QueryMyTrolleyServlet");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
