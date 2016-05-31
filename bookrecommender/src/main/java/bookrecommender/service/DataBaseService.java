package bookrecommender.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseService {
	public static final String url = "jdbc:mysql://127.0.0.1/br";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "67313688";  
  
    public static Connection conn = null;  
    public static Statement sta = null;  
    public static ResultSet rs = null;
  
    public static Connection GetDataBaseService() {  
        try {  
            Class.forName(name);//指定连接类型  
            conn = DriverManager.getConnection(url, user, password);//获取连接  
            
        } catch (Exception e) {  
            e.printStackTrace();  
        }
		return conn;  
    }  
  
    public void close() {  
        try {  
            this.conn.close();  
            this.sta.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  

    public static String getBookNameByBookCode(String bc){
    	String bookName = "";
    	
    	String sql = String.format("select distinct bookName from book where bookCode = %s ", bc);
    	try {
			rs = sta.executeQuery(sql);
			while(rs.next()){
				bookName = rs.getString("BookName");
	    	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return bookName;
    }
    
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		
		System.out.println(getBookNameByBookCode("3216007"));
	}

	
}  
    
