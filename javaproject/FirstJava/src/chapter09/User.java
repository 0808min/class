package chapter09;

public class User {

	public int userIdx;
	public String userId;
	
	public User(int userIdx, String userId) {
		this.userIdx = userIdx;
		this.userId = userId;
	}

	public int getUserIdx() {
		return userIdx;
	}

	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
}
