package bookrecommender.logic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookrecommender.bean.RecommendBookBean;
import bookrecommender.dao.RecommendBookDAO;
import bookrecommender.dao.UserDAO;

public class RecommendBookLogic {

	private RecommendBookDAO recommendBookDAO;
	
	public RecommendBookLogic() throws SQLException{
		recommendBookDAO = new RecommendBookDAO();
	}
	
	public List<RecommendBookBean> getRecommendBookByUserName(String userName) throws SQLException{
		List<RecommendBookBean> list = new ArrayList<RecommendBookBean>();
		list = recommendBookDAO.selectRecommendBookByUserName(userName);
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
