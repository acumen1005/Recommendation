package bookrecommender.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookrecommender.bean.UserBean;
import bookrecommender.service.DataBaseService;

public class UserDAO {
	
    public static Connection conn = null;  
    public static Statement sta = null;  
    public static ResultSet rs = null;
	
	public UserDAO() throws SQLException{
		conn = DataBaseService.GetDataBaseService();
		sta = conn.createStatement();
	}
	
	public String selectUserNameByUserCode(String userCode) throws SQLException{
		String userName = "";
		String sql = String.format("select distinct userName from user where userCode = %s", userCode);
		rs = sta.executeQuery(sql);
		while(rs.next()){
			userName = rs.getString("userName");
		}
		return userName; 
	}
	
	public List<UserBean> selectAllUserName() throws SQLException{
		
		List<UserBean> userList = new ArrayList<UserBean>();
		
		String userName = "";
		String sql = String.format("select distinct userName from user");
		rs = sta.executeQuery(sql);
		while(rs.next()){
			UserBean userBean = new UserBean();
			userBean.setUserName(rs.getString("userName"));
			userList.add(userBean);
		}
		return userList; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
