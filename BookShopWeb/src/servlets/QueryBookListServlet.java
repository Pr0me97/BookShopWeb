package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BookDao;
import entity.Book;

public class QueryBookListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> blist=BookDao.queryAllBooks();
		request.getSession().setAttribute("blist", blist);
		String user=(String)request.getSession().getAttribute("username");
		String addFlag=request.getParameter("addFlag");
		if(user!=null&&"success".equals(addFlag))
			response.sendRedirect("bookList_logged.jsp?addFlag=success");
		else if(user!=null)
			response.sendRedirect("bookList_logged.jsp");
		else
			response.sendRedirect("bookList.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
