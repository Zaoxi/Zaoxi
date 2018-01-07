package Model;
import java.util.*;

public class UserList implements Comparable<UserList> {
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

	@Override
	public int compareTo(UserList user) {
		if(userScore > user.getScore())
			return 1;
		else if(userScore < user.getScore())
			return -1;
		return 0;
	}
}
