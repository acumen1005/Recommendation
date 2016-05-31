package bookrecommender.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookrecommender.TaskTimer;

/**
 * Servlet implementation class TaskTimerServlet
 */
public class TaskTimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init() throws ServletException{
		
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskTimerServlet() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("推荐算法开始运行！");
		//启动类
		TaskTimer.runTask();
    }
    

}
