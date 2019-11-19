package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.MyTrolleyDao;
import Dao.OrderDao;
import entity.MyTrolley;

public class PlaceOrderServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=(String)request.getSession().getAttribute("username");
		String book_id;
		String book_name;
		float book_price;
		List<MyTrolley> tlist=MyTrolleyDao.queryAllBooks(username);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		String order_id=df.format(new Date());
		for(int i=0;i<tlist.size();i++) {
			book_id=tlist.get(i).getId();
			book_name=tlist.get(i).getName();
			book_price=tlist.get(i).getPrice();
			OrderDao.addOrderInfo(username, book_id, book_name, book_price, order_id);
		}
		MyTrolleyDao.clearMyTrolley(username);
		response.sendRedirect("QueryMyOrderServlet?addFlag=success");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
