package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import DBHelper.DBHelper;
import entity.Book;;

public class BookDao {
	public static List<Book> queryAllBooks(){    //遍历所有书籍信息
		ArrayList<Book> list=new ArrayList<Book>();
		String sql="select book_id,book_name,book_writer,book_price from bookList";
		ResultSet rs=DBHelper.executeQuery(sql);
		try {
			while(rs.next()) {
				Book b=new Book();
				b.setId(rs.getString(1));
				b.setName(rs.getString(2));
				b.setWriter(rs.getString(3));
				b.setPrice(rs.getFloat(4));
				list.add(b);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	}
	
	public static List<Book> queryBookStock(){ //管理员查询图书库存量
		ArrayList<Book> list=new ArrayList<Book>();
		String sql="select book_id,book_name,book_writer,book_price,book_stock from bookList";
		ResultSet rs=DBHelper.executeQuery(sql);
		try {
			while(rs.next()) {
				Book b=new Book();
				b.setId(rs.getString(1));
				b.setName(rs.getString(2));
				b.setWriter(rs.getString(3));
				b.setPrice(rs.getFloat(4));
				b.setStock(rs.getInt(5));
				list.add(b);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	}
	
	public static void importBookExistStock(String book_id) {
		String sql="update bookList set book_stock=book_stock+1 where book_id='"+book_id+"'";
		DBHelper. executeUpdate(sql);
		DBHelper.closeConnection();
	}
	
	public static void addBookList(String book_id,String book_name,String book_writer,float book_price,int sum) {
		String sql="insert into bookList(book_id,book_name,book_writer,book_price,book_stock) values"
				+ "('"+book_id+"','"+book_name+"','"+book_writer+"',"+book_price+","+sum+")";
		DBHelper. executeUpdate(sql);
		DBHelper.closeConnection();
	}
	
	public static List<Book> queryBookInfo(String book_id){
		ArrayList<Book> list=new ArrayList<Book>();
		String sql="select book_name,book_writer,book_price,book_info,book_stock from bookList where"
				+ " book_id='"+book_id+"'";
		ResultSet rs=DBHelper.executeQuery(sql);
		try {
			while(rs.next()) {
				Book b=new Book();
				b.setName(rs.getString(1));
				b.setWriter(rs.getString(2));
				b.setPrice(rs.getFloat(3));
				b.setInfo(rs.getString(4));
				b.setStock(rs.getInt(5));
				list.add(b);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	}
	
	public static void updateBookInfo(String book_id,String book_name,String book_writer,String book_info,float book_price,int sum) {
		String sql="update bookList set book_name='"+book_name+"',book_writer='"+book_writer+"',book_info='"+book_info+"',book_price="+book_price+",book_stock="+sum+" where book_id='"+book_id+"'";
		System.out.print(sql);
		DBHelper. executeUpdate(sql);
		DBHelper.closeConnection();
	}
	
	public static List<Book> queryBookSale(){
		ArrayList<Book> list=new ArrayList<Book>();
		String sql="select book_id,book_name,count(1) from bookOrder where status='已发货' group by book_id";
		ResultSet rs=DBHelper.executeQuery(sql);
		try {
			while(rs.next()) {
				Book b=new Book();
				b.setName(rs.getString(2));
				b.setTotal_sale(rs.getInt(3));
				list.add(b);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	}
}
