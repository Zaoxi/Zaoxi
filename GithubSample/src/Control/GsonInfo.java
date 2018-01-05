package Control;

// 멀티 플레이시 소켓통신을 실시 할 Gson 정보 클래스
public class GsonInfo {
	// 멀티 플레이 맵 상에서 라인 정보(맨 위 : 1, 맨 아래 : 4)
	private int line;
	// 멀티플레이 몬스터 정보
	private int monsterNum;
	// 멀티플레이 정보의 타입 ("monster", "lose")
	private String type;
	// type
	final static public String MONSTER = "monster", LOSE = "lose";
	// line
	final public static int FIRST = 1;
	final public static int SECOND = 3;
	final public static int THIRD = 4;
	final public static int FOURTH = 6;
	
	// 몬스터의 정보 상수
	final public static int MONSTER0 = 0;
	final public static int MONSTER1 = 1;
	final public static int MONSTER2 = 2;
	final public static int MONSTER3 = 3;
	final public static int MONSTER4 = 4;
	final public static int MONSTER5 = 5;
	final public static int MONSTER6 = 6;
	final public static int MONSTER7 = 7;
	final public static int MONSTER8 = 8;
	final public static int MONSTER9 = 9;
	
	public GsonInfo(int _line, int monster_num, String _type) {
		line = _line;
		monsterNum = monster_num;
		type = _type;
	}
	
	public int getLine() {
		return line;
	}
	public int getMonster() {
		return monsterNum;
	}
	public String getType() {
		return type;
	}
	public void setLine(int _line) {
		line = _line;
	}
	public void setMonster(int num) {
		monsterNum = num;
	}
	public void setType(String _type) {
		type = _type;
	}
}
