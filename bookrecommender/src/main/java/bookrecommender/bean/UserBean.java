package bookrecommender.bean;

public class UserBean {
	
	private int id;
	private int userCode;
	private String userName;
	
	public int getID(){
		return id;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public int getUserCode(){
		return userCode;
	}
	
	public void setUserCode(int userCode){
		this.userCode = userCode;
	}
	public String getUserName(){
		return userName;
	}
	
	public void setUserName(String userName){
		this.userName = userName;
	}
}
