package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import DBHelper.DBHelper;
import entity.MyTrolley;

public class MyTrolleyDao {
	public static void addBookToTrolley(String book_id,String book_name,float price,String username) {
		String sql="insert into myTrolley(book_id,book_name,book_price,username) values('"+book_id+"','"+book_name+"','"+price+"','"+username+"')";
		DBHelper. executeUpdate(sql);
		DBHelper.closeConnection();
	}
	
	public static List<MyTrolley> queryAllBooks(String username){    //遍历用户购物车信息
		ArrayList<MyTrolley> list=new ArrayList<MyTrolley>();
		String sql="select book_id,book_name,book_price from myTrolley where username='"+username+"'";
		ResultSet rs=DBHelper.executeQuery(sql);
		try {
			while(rs.next()) {
				MyTrolley t=new MyTrolley();
				t.setId(rs.getString(1));
				t.setName(rs.getString(2));
				t.setPrice(rs.getFloat(3));
				list.add(t);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	}
	
	public static void deleteMyTrolley(String username,String book_id) {
		String sql="delete from myTrolley where username='"+username+"' and book_id='"+book_id+"'";
		DBHelper. executeUpdate(sql);
		DBHelper.closeConnection();
	}
	
	public static void clearMyTrolley(String username) { //用于下单后清空用户的购物车
		String sql="delete from myTrolley where username='"+username+"'";
		DBHelper. executeUpdate(sql);
		DBHelper.closeConnection();
	}
}
