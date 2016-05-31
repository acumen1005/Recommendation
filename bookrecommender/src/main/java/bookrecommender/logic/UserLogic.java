package bookrecommender.logic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookrecommender.bean.UserBean;
import bookrecommender.dao.UserDAO;

public class UserLogic {

	private UserDAO userDAO;
	
	public UserLogic() throws SQLException{
		userDAO = new UserDAO();
	}
	
	public String getUserNameByUserCode(String userCode) throws SQLException{
		return userDAO.selectUserNameByUserCode(userCode); 
	}
	
	public List<UserBean> getAllUserName() throws SQLException{
		return userDAO.selectAllUserName(); 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
