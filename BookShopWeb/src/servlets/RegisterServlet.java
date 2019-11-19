package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.UserDao;
import MD5.Md5;

public class RegisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username="";
		String pwd2="";
		username=request.getParameter("username");
		pwd2=Md5.md5(request.getParameter("user_pwd2"));
		boolean username_flag=UserDao.checkUsernameExist(username);//用户名是否存在
		if(username_flag==false) {
			UserDao.insertLoginInfo(username, pwd2);
			request.getRequestDispatcher("login.jsp?info=registerSuccess").forward(request,response);
		}else {
			response.sendRedirect("register.jsp?error=yes"); //用户名有重复
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
