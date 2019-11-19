package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BookDao;
import entity.Book;

public class QueryBookInfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String book_id=request.getParameter("book_id");
		List<Book> list=BookDao.queryBookInfo(book_id);
		String book_name=list.get(0).getName();
		float book_price=list.get(0).getPrice();
		String book_writer=list.get(0).getWriter();
		int book_stock=list.get(0).getStock();
		String book_info=list.get(0).getInfo();
		request.getSession().setAttribute("book_id", book_id);
		request.getSession().setAttribute("book_name", book_name);
		request.getSession().setAttribute("book_price", book_price);
		request.getSession().setAttribute("book_writer", book_writer);
		request.getSession().setAttribute("book_stock", book_stock);
		request.getSession().setAttribute("book_info", book_info);
		response.sendRedirect("updateBookList.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
