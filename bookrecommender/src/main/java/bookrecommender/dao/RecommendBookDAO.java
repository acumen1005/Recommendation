package bookrecommender.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookrecommender.bean.RecommendBookBean;
import bookrecommender.service.DataBaseService;

public class RecommendBookDAO {

	public static Connection conn = null;  
    public static Statement sta = null;  
    public static ResultSet rs = null;
	
	public RecommendBookDAO() throws SQLException{
		conn = DataBaseService.GetDataBaseService();
		sta = conn.createStatement();
	}
	
	public List<RecommendBookBean> selectRecommendBookByUserName(String userName) throws SQLException{
		List<RecommendBookBean> list = new ArrayList<RecommendBookBean>();
		
		String sql = String.format("select distinct * from recommendBook where userCode = (select userCode from user where userName = '%s')", userName);
		rs = sta.executeQuery(sql);
		while(rs.next()){
			RecommendBookBean recommendBookBean = new RecommendBookBean();
			recommendBookBean.setUserCode(rs.getInt("userCode"));
			recommendBookBean.setRecommendBook(rs.getString("recommendBook"));
			recommendBookBean.setRating(rs.getFloat("rating"));
			recommendBookBean.setType(rs.getInt("type"));
//			System.out.println(recommendBookBean.getType() + "type");
			list.add(recommendBookBean);
		}
		
		return list;
	}
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		RecommendBookDAO recommendBookDAO = new RecommendBookDAO();
		
		List<RecommendBookBean> list = recommendBookDAO.selectRecommendBookByUserName("299");
		
		System.out.println(list.size());
		
	}

	
}
