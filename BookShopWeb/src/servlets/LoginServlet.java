package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import MD5.Md5;
import Dao.UserDao;

public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwdInDB="";
		String typeInDB="";
		String username="";
		String user_pwd="";
		String user_type="";
		username = request.getParameter("username");
		user_pwd = Md5.md5(request.getParameter("user_pwd"));//对页面提取的用户密码进行MD5加密
		user_type = request.getParameter("user_type");
		pwdInDB = UserDao.queryUserPwdById(username);
		typeInDB = UserDao.queryUserTypeById(username);
		int flag;     //判断是否成功登陆，成功则为1，失败则为0
		if(pwdInDB.equals(user_pwd)&&typeInDB.equals(user_type))
			flag=1;
		else
			flag=0;
		if(flag==1) {
			request.getSession().setAttribute("username",username);//登陆成功后将用户名存入名为username的session中
			switch(typeInDB) {  //登陆成功后判断用户类型，跳转至对应主页面
			case "0":
				request.getRequestDispatcher("QueryBookListServlet").forward(request,response);break;
			case "1":
				request.getRequestDispatcher("QueryBookStockServlet").forward(request,response);break;
			}
		}
		else
			response.sendRedirect("login.jsp?error=yes"); //登陆失败后重返登陆页面，并弹出错误提示
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}