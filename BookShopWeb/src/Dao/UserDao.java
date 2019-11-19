package Dao;

import java.sql.ResultSet;
import DBHelper.DBHelper;

public class UserDao {
	public static String queryUserPwdById(String username){     //通过用户id查询用户密码，查询用户登陆信息是否正确
		String pwd="";
		String sql="select pwd from login where username='"+username+"'";
		ResultSet rs = DBHelper.executeQuery(sql);
        try{
        	while(rs.next()) {
        		pwd=rs.getString(1);
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return pwd;
	}
	
	public static String queryUserTypeById(String username){     //通过用户id查询用户类型，查询用户登陆信息是否正确
		String type="";
		String sql="select user_type from login where username='"+username+"'";
		ResultSet rs = DBHelper.executeQuery(sql);
        try{
        	while(rs.next()) {
        		type=rs.getString(1);
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return type;
	}
	
	public static boolean checkUsernameExist(String username) {  //注册时用来判断用户名是否已经存在true为由重复用户名，false为无重复用户名
		boolean flag=false;
		String sql="select * from login where username='"+username+"'";
		ResultSet rs=DBHelper.executeQuery(sql);
		try {
			if(rs.next())
				flag=true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return flag;
	}
	
	public static void insertLoginInfo(String username,String pwd) { //注册用，新添用户登录信息
		String sql="insert into login(username,pwd) values('"+username+"','"+pwd+"')";
		DBHelper. executeUpdate(sql);
		DBHelper.closeConnection();
	}
}
