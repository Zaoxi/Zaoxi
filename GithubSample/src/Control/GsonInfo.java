package Control;

// ��Ƽ �÷��̽� ��������� �ǽ� �� Gson ���� Ŭ����
public class GsonInfo {
	// ��Ƽ �÷��� �� �󿡼� ���� ����(�� �� : 1, �� �Ʒ� : 4)
	private int line;
	// ��Ƽ�÷��� ���� ����
	private int monsterNum;
	// ��Ƽ�÷��� ������ Ÿ�� ("monster", "lose")
	private String type;
	// type
	final static public String MONSTER = "monster", LOSE = "lose";
	// line
	final public static int FIRST = 1;
	final public static int SECOND = 3;
	final public static int THIRD = 4;
	final public static int FOURTH = 6;
	
	// ������ ���� ���
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
