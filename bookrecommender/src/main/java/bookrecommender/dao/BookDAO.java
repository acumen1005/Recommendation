package bookrecommender.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookrecommender.bean.BookBean;
import bookrecommender.bean.RecommendBookBean;
import bookrecommender.bean.UserBean;
import bookrecommender.service.DataBaseService;

public class BookDAO {

	public static Connection conn = null;  
    public static Statement sta = null;  
    public static ResultSet rs = null;
	
	public BookDAO() throws SQLException{
		conn = DataBaseService.GetDataBaseService();
		sta = conn.createStatement();
	}
	
	public List<BookBean> selectRecommendBookByUserName(String userName) throws SQLException{
		List<BookBean> list = new ArrayList<BookBean>();
		
		String sql = String.format("select bookName from book b,user u,reader r where u.userCode=r.userCode and b.bookCode=r.bookCode and u.userName = '%s'", userName);
		
		rs = sta.executeQuery(sql);
		while(rs.next()){
			BookBean bookBean = new BookBean();
			bookBean.setBookName(rs.getString("bookName"));
			list.add(bookBean);
		}
		
		return list;
	}
	
	public List<BookBean> selectAllBookName() throws SQLException{
		
		List<BookBean> bookList = new ArrayList<BookBean>();
		
		String sql = String.format("select distinct bookName from book");
		rs = sta.executeQuery(sql);
		while(rs.next()){
			BookBean bookBean = new BookBean();
			bookBean.setBookName(rs.getString("bookName"));
			bookList.add(bookBean);
		}
		return bookList; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
