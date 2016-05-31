package bookrecommender.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import bookrecommender.bean.BookBean;
import bookrecommender.bean.RecommendBookBean;
import bookrecommender.bean.UserBean;
import bookrecommender.logic.BookLogic;
import bookrecommender.logic.RecommendBookLogic;
import bookrecommender.logic.UserLogic;

/**
 * Servlet implementation class BookResultServlet
 */
public class BookResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(" 00000000000000000 ");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String type = request.getParameter("type");
		String userName = request.getParameter("userName");
		
		if(type.equals("reader")){
			
			try {
				BookLogic bookLogic = new BookLogic();
				List<BookBean> list = new ArrayList<BookBean>();
				List<JSONObject> jsonList = new ArrayList<JSONObject>();
				list = bookLogic.getRecommendBookByUserName(userName);
				for(BookBean bookBean : list){
					JSONObject json = new JSONObject();
					json.put("bookName", bookBean.getBookName());
					
					jsonList.add(json);
				}
				
				out.print(jsonList.toString());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		else if(type.equals("recommender")){
			try {
				RecommendBookLogic recommendBookLogic = new RecommendBookLogic();
				List<RecommendBookBean> list = new ArrayList<RecommendBookBean>();
				List<JSONObject> jsonList = new ArrayList<JSONObject>();
				list = recommendBookLogic.getRecommendBookByUserName(userName);
			
				for(RecommendBookBean recommendBookBean : list){
					JSONObject json = new JSONObject();
					json.put("recommendBook", recommendBookBean.getRecommendBook());
					json.put("rating", recommendBookBean.getRating());
					json.put("type", recommendBookBean.getType());
					
					jsonList.add(json);
				}
				
				out.print(jsonList.toString());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(type.equals("user")){
			try {
				UserLogic userLogic = new UserLogic();
				List<UserBean> list = new ArrayList<UserBean>();
				List<JSONObject> jsonList = new ArrayList<JSONObject>();
				list = userLogic.getAllUserName();
			
				for(UserBean userBean : list){
					JSONObject json = new JSONObject();
					try {
						json.put("userName", userBean.getUserName());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					jsonList.add(json);
				}
				
				out.print(jsonList.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(type.equals("book")){
			System.out.println("-----------");
			try {
				BookLogic bookLogic = new BookLogic();
				List<BookBean> list = new ArrayList<BookBean>();
				List<JSONObject> jsonList = new ArrayList<JSONObject>();
				list = bookLogic.getAllBookName();
			
				for(BookBean bookBean : list){
					JSONObject json = new JSONObject();
					try {
						json.put("bookName", bookBean.getBookName());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					jsonList.add(json);
				}
				
				out.print(jsonList.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
