package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import DBHelper.DBHelper;
import entity.MyTrolley;
import entity.Order;

public class OrderDao {
	public static void addOrderInfo(String username,String book_id,String book_name,float book_price,String order_id) {
		String sql="insert into bookOrder(username,book_id,book_name,book_price,order_id) values('"+username+"','"+book_id+"','"+book_name+"','"+book_price+"','"+order_id+"')";
		DBHelper. executeUpdate(sql);
		DBHelper.closeConnection();
	}
	
	public static List<Order> queryMyOrder(String username){ //查询订单信息
		ArrayList<Order> list=new ArrayList<Order>();
		String sql="select distinct order_id,status from bookOrder where username='"+username+"'";
		ResultSet rs=DBHelper.executeQuery(sql);
		try {
			while(rs.next()) {
				Order o=new Order();
				o.setOrder_id(rs.getString(1));
				o.setStatus(rs.getString(2));
				list.add(o);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	}
	
	public static List<Order> queryOrderDetail(String username,String order_id){ //查询订单详情
		ArrayList<Order> list=new ArrayList<Order>();
		String sql="select book_id,book_name,book_price from bookOrder where username='"+username+"' and order_id='"+order_id+"'";
		ResultSet rs=DBHelper.executeQuery(sql);
		try {
			while(rs.next()) {
				Order o=new Order();
				o.setId(rs.getString(1));
				o.setName(rs.getString(2));
				o.setPrice(rs.getFloat(3));
				list.add(o);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	}
	
	public static List<Order> rootQueryOrderDetail(String order_id){ //查询订单详情
		ArrayList<Order> list=new ArrayList<Order>();
		String sql="select book_id,book_name,book_price from bookOrder where order_id='"+order_id+"'";
		ResultSet rs=DBHelper.executeQuery(sql);
		try {
			while(rs.next()) {
				Order o=new Order();
				o.setId(rs.getString(1));
				o.setName(rs.getString(2));
				o.setPrice(rs.getFloat(3));
				list.add(o);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	}
	
	public static float queryOrderSumPrice(String order_id) {
		String sql="select sum(book_price) from bookOrder where order_id='"+order_id+"'";
		ResultSet rs=DBHelper.executeQuery(sql);
		float sum_price = 0;
		try {
			while(rs.next()) {
				sum_price=rs.getFloat(1);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return sum_price;
	}
	
	public static List<Order> queryAllOrder(){
		ArrayList<Order> list=new ArrayList<Order>();
		String sql="select distinct order_id,status from bookOrder";
		ResultSet rs=DBHelper.executeQuery(sql);
		try {
			while(rs.next()) {
				Order o=new Order();
				o.setOrder_id(rs.getString(1));
				o.setStatus(rs.getString(2));
				list.add(o);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	}
	
	public static void updateOrderStatus(String order_id) {
		String sql="update bookOrder set status='已发货' where order_id='"+order_id+"'";
		DBHelper. executeUpdate(sql);
		DBHelper.closeConnection();
	}
}
