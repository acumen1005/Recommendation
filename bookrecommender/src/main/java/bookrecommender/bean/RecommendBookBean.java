package bookrecommender.bean;

public class RecommendBookBean {

	private int id;
	private int userCode;
	private String recommendBook;
	private float rating;
	private int type;
	
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
	public String getRecommendBook(){
		return recommendBook;
	}
	
	public void setRecommendBook(String recommendBook){
		this.recommendBook = recommendBook;
	}
	
	public float getRating(){
		return rating;
	}
	
	public void setRating(float rating){
		this.rating = rating;
	}
	
	public int getType(){
		return type;
	}
	
	public void setType(int type){
		this.type = type;
	}
}
