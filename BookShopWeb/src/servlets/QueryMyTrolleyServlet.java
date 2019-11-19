package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.MyTrolleyDao;
import entity.MyTrolley;

public class QueryMyTrolleyServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=(String) request.getSession().getAttribute("username");
		List<MyTrolley> tlist=MyTrolleyDao.queryAllBooks(username);
		request.getSession().setAttribute("tlist", tlist);
		String addFlag=request.getParameter("addFlag");
		if("success".equals(addFlag)) {
			response.sendRedirect("myTrolley.jsp?addFlag=success");
		}else
			response.sendRedirect("myTrolley.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
