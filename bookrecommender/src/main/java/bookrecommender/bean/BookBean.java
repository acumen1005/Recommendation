package bookrecommender.bean;

public class BookBean {
	
	private int id;
	private int bookCode;
	private String bookName;
	
	public int getID(){
		return id;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public int getBookCode(){
		return bookCode;
	}
	
	public void setBookCode(int bookCode){
		this.bookCode = bookCode;
	}
	public String getBookName(){
		return bookName;
	}
	
	public void setBookName(String bookName){
		this.bookName = bookName;
	}
}
