package dao;

public class User {
	private String userId;
	private String userPw;
	
	public User(String userId,String userPw) {
		this.userId=userId;
		this.userPw=userPw;
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public String getUserPw() {
		return this.userPw;
	}
}
