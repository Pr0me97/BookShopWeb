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
		user_pwd = Md5.md5(request.getParameter("user_pwd"));//��ҳ����ȡ���û��������MD5����
		user_type = request.getParameter("user_type");
		pwdInDB = UserDao.queryUserPwdById(username);
		typeInDB = UserDao.queryUserTypeById(username);
		int flag;     //�ж��Ƿ�ɹ���½���ɹ���Ϊ1��ʧ����Ϊ0
		if(pwdInDB.equals(user_pwd)&&typeInDB.equals(user_type))
			flag=1;
		else
			flag=0;
		if(flag==1) {
			request.getSession().setAttribute("username",username);//��½�ɹ����û���������Ϊusername��session��
			switch(typeInDB) {  //��½�ɹ����ж��û����ͣ���ת����Ӧ��ҳ��
			case "0":
				request.getRequestDispatcher("QueryBookListServlet").forward(request,response);break;
			case "1":
				request.getRequestDispatcher("QueryBookStockServlet").forward(request,response);break;
			}
		}
		else
			response.sendRedirect("login.jsp?error=yes"); //��½ʧ�ܺ��ط���½ҳ�棬������������ʾ
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}