package bookrecommender.logic;

import java.sql.SQLException;
import java.util.List;

import bookrecommender.bean.BookBean;
import bookrecommender.bean.UserBean;
import bookrecommender.dao.BookDAO;
import bookrecommender.dao.UserDAO;

public class BookLogic {

	private BookDAO bookDAO;
	
	public BookLogic() throws SQLException{
		bookDAO = new BookDAO();
	}
	
	public List<BookBean> getRecommendBookByUserName(String userName) throws SQLException{
		return bookDAO.selectRecommendBookByUserName(userName);
	}
	
	public List<BookBean> getAllBookName() throws SQLException{
		return bookDAO.selectAllBookName(); 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
