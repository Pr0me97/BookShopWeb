package Dao;

import java.sql.ResultSet;
import DBHelper.DBHelper;

public class UserDao {
	public static String queryUserPwdById(String username){     //ͨ���û�id��ѯ�û����룬��ѯ�û���½��Ϣ�Ƿ���ȷ
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
	
	public static String queryUserTypeById(String username){     //ͨ���û�id��ѯ�û����ͣ���ѯ�û���½��Ϣ�Ƿ���ȷ
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
	
	public static boolean checkUsernameExist(String username) {  //ע��ʱ�����ж��û����Ƿ��Ѿ�����trueΪ���ظ��û�����falseΪ���ظ��û���
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
	
	public static void insertLoginInfo(String username,String pwd) { //ע���ã������û���¼��Ϣ
		String sql="insert into login(username,pwd) values('"+username+"','"+pwd+"')";
		DBHelper. executeUpdate(sql);
		DBHelper.closeConnection();
	}
}
