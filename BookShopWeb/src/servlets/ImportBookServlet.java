package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BookDao;

public class ImportBookServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset=utf-8");
		 String book_id=request.getParameter("book_id");
		 String book_name=request.getParameter("book_name");
		 String book_writer=request.getParameter("book_writer");
		 float book_price=Float.parseFloat(request.getParameter("book_price"));
		 int book_sum=Integer.parseInt(request.getParameter("sum"));
		 BookDao.addBookList(book_id, book_name, book_writer, book_price, book_sum);
		 response.sendRedirect("QueryBookStockServlet");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
