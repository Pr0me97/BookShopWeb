package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.MyTrolleyDao;

public class AddToTrolleyServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String book_id=request.getParameter("id");
		String book_name=request.getParameter("name");
		float book_price= Float.parseFloat(request.getParameter("price"));
		String username=(String) request.getSession().getAttribute("username");
		MyTrolleyDao.addBookToTrolley(book_id, book_name, book_price, username);
		response.sendRedirect("QueryBookListServlet?addFlag=success");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
