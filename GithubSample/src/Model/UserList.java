package Model;

public class UserList {
	private String userName;
	private int userScore;
	
	public UserList(String name, int score) {
		userName = name;
		userScore = score;
	}
	
	public void setName(String name) {
		userName = name;
	}
	public void setScore(int score) {
		userScore = score;
	}
	
	public String getName() {
		return userName;
	}
	public int getScore() {
		return userScore;
	}
}
