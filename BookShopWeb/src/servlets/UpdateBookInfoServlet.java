package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BookDao;

public class UpdateBookInfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String book_id= (String) request.getSession().getAttribute("book_id");
		String book_name=request.getParameter("name");
		String book_writer=request.getParameter("writer");
		String book_price=request.getParameter("price");
		String book_stock=request.getParameter("sum");
		String book_info=request.getParameter("info");
		if(book_name=="")
			book_name=(String) request.getSession().getAttribute("book_name");
		if(book_writer=="")
			book_writer=(String) request.getSession().getAttribute("book_writer");
		if(book_info=="")
			book_info=(String) request.getSession().getAttribute("book_info");
		if(book_price=="")
			book_price=request.getSession().getAttribute("book_price").toString();
		if(book_stock=="")
			book_stock=request.getSession().getAttribute("book_stock").toString();
		BookDao.updateBookInfo(book_id, book_name, book_writer, book_info, Float.parseFloat(book_price),Integer.parseInt(book_stock));
		response.sendRedirect("QueryBookStockServlet");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
