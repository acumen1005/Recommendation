package bookrecommender;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.mahout.cf.taste.common.TasteException;

public class TaskTimer {

	final static int TIME = 60 * 60 * 24;
	
	
	public static void runTask(){
		Runnable runnable = new Runnable() {  
            public void run() {  
                // task to run goes here  
                try {
                	String filePath = this.getClass().getResource("/").getPath();
                	filePath = filePath + "douban-rating-300.txt";
					BookResult.runBookResult(filePath);
				} catch (TasteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }  
        };  
        ScheduledExecutorService service = Executors  
                .newSingleThreadScheduledExecutor();  
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间  
        service.scheduleAtFixedRate(runnable, 10, TIME, TimeUnit.SECONDS); 
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runTask();
	}

}
