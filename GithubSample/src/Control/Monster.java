package Control;
import java.io.*;
import View.UIManager;

import javax.swing.*;


abstract class Monster {
	protected int hp; 		// ������ ü��
	protected int speed;		// ������ �ӵ�
	protected Point pos;		// map_array �迭 �󿡼� ������ ��ġ, center���� �������� �Ǵ�
	protected Point real_pos;	// map_label �󿡼� ������ ���� ��ǥ(x, y)
	protected Point center;	// map_label�󿡼� ������ center ��ǥ(x, y)
	protected int move_count;	// ������ �̹��� ��ȯ �ֱ� ī��Ʈ
	protected int changeState = 0;// ������ �̹��� ���� ��ȣ	
	protected static int DIRECTION = -1;	// ������ ����
	protected int monsterNum;			// � �������� ǥ��
	// Map
	protected Map map;
	
	// ���̺�� �̹���
	static public ImageIcon[][] imgDir = new ImageIcon[10][];
	protected JLabel monster;
	
	final static int DOWN = 0, UP = 1, RI                    GHT = 2, LEFT = 3;	// ���� �÷���
	final static int CHANGE = 3;				// ������ �̹����� ��ȯ �ֱ�
	
	// imgDir 2���� String �迭�� ���� �̹����� ��θ� �����ϴ� static �Լ�
	public static void setImageDir() {
		for(int i=0; i<imgDir.length; i++) {
			imgDir[i] = new ImageIcon[8];
			
			for(int j=0; j<4; j++) {
				for(int k=0; k<2; k++) {
					imgDir[i][j*2+k] = new ImageIcon("Image/Monster/monster" + i + "_" + j + k + ".png");
				}
			}
		}
	}
	
	public Monster(int monster_num, int hp, int speed, Point real, Map _map) {
		monsterNum = monster_num;
		real_pos = new Point(real.getX(), real.getY());
		this.hp = hp;
		this.speed = speed;
		map = _map;
		// ��ǥ�� ����
		center = real_pos.getCenterPosition();
		pos = center.getMapPosition();			// center���� �������� �Ǵ�
		move_count = 0;
	}
	
	// ���Ͱ� ��θ� ���� move�Լ��� ȣ���ϴ� �Լ�
	public void ActiveMonster() {
		int direction = map.getMap()[pos.getX()][pos.getY()].getDirection();
		
		if(direction == -1)	// static DIRECTION ������ ����
			DIRECTION = direction;
		
		move(DIRECTION);
	}
	
	// ���Ͱ� ������ �������� �����̴� �Լ�
	public void move(int direction) {
		if(direction >= DOWN && direction <= LEFT) {
			move_count++;
			switch(direction) {
			case DOWN:
				real_pos.setY(real_pos.getY() + speed);
				center.setY(center.getY() + speed);
				break;
			case UP:
				real_pos.setY(real_pos.getY() - speed);
				center.setY(center.getY() - speed);
				break;
			case RIGHT:
				real_pos.setX(real_pos.getX() + speed);
				center.setX(center.getX() + speed);
				break;
			case LEFT:
				real_pos.setX(real_pos.getX() - speed);
				center.setX(center.getX() - speed);
				break;
			}
			// ��� ��ġ ����
			pos = center.getMapPosition();
			
			if(move_count == CHANGE) {	// ������ �ֱ�� ������ �̹����� ������Ʈ
				monster.setIcon(imgDir[monsterNum][direction*2 + changeState]);
				changeState++;
				if(changeState == 2)
					changeState = 0;
			}
		}
		System.out.println("Class Monster - move - �߸��� ����Է�");
		return;
	}
	// ���Ͱ� ���ݹ޴� �Լ�, damage��ŭ hp����, hp = 0�̸� true, hp != 0�̸� false ��ȯ
	public boolean attacked(int damage) {
		hp = hp - damage;
		if(hp <= 0)
			return true;
		return false;
	}
	
}

class Monster0 extends Monster implements Runnable {
	// Monster0�� ���ǵ�
	public static int MONSTER0_SPEED = 3;
	public static int NUM = 0;
	private boolean monsterFlag = true;
	private UIManager ui;
	
	
	public Monster0(UIManager v, int hp, Point real, Map _map) {
		super(NUM, hp, MONSTER0_SPEED, real, _map);
		ui = v;
		
		// TODO Auto-generated constructor stub
		// ������ �ʱ� ��ġ�� ���� ����
		monster = new JLabel(imgDir[0][map.getMap()[pos.getX()][pos.getY()].getDirection()*2]);
	}

	@Override
	public void run() {
		// ���� �����尡 ����Ǹ� �ʷ��̺� �� ���� ���̺��� ADD
		JLabel mapLabel = ui.getSinglePanel().getMapLabel();
		mapLabel.add(monster);
		monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// ���Ͱ� ������ �ֱ�� ������ ���⿡ ���� �����δ�.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		}
		
		// ���Ͱ� ������ ���� �ݺ����� ���������� �ȴ�, �̶� ���͸� �ʷ��̺� �󿡼� �����Ѵ�.
		mapLabel.remove(monster);
	}
	
	// MonsterN�� ���ݹ޴� �Լ�
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// ������ hp�� 0�� �Ǿ��� ���
			monsterFlag = false;
		}
		return monsterFlag;
	}
	
}

class Monster1 extends Monster implements Runnable {
	// Monster1�� ���ǵ�
	public static int MONSTER1_SPEED = 3;
	public static int NUM = 1;
	private boolean monsterFlag = true;
	private UIManager ui;
	
	public Monster1(UIManager v, int hp, Point real, Map _map) {
		super(NUM, hp, MONSTER1_SPEED, real, _map);
		// TODO Auto-generated constructor stub
		ui = v;
	}

	@Override
	public void run() {
		// ���� �����尡 ����Ǹ� �ʷ��̺� �� ���� ���̺��� ADD
		JLabel mapLabel = ui.getSinglePanel().getMapLabel();
		mapLabel.add(monster);
		monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// ���Ͱ� ������ �ֱ�� ������ ���⿡ ���� �����δ�.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		}
		
		// ���Ͱ� ������ ���� �ݺ����� ���������� �ȴ�, �̶� ���͸� �ʷ��̺� �󿡼� �����Ѵ�.
		mapLabel.remove(monster);
	}
	
	// MonsterN�� ���ݹ޴� �Լ�
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// ������ hp�� 0�� �Ǿ��� ���
			monsterFlag = false;
		}
		return monsterFlag;
	}
}

class Monster2 extends Monster implements Runnable {
	// Monster2�� ���ǵ�
	public static int MONSTER2_SPEED = 5;
	public static int NUM = 2;
	private boolean monsterFlag = true;
	private UIManager ui;
	
	public Monster2(UIManager v, int hp, Point real, Map _map) {
		super(NUM, hp, MONSTER2_SPEED, real, _map);
		// TODO Auto-generated constructor stub
		ui = v;
	}

	@Override
	public void run() {
		// ���� �����尡 ����Ǹ� �ʷ��̺� �� ���� ���̺��� ADD
		JLabel mapLabel = ui.getSinglePanel().getMapLabel();
		mapLabel.add(monster);
		monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// ���Ͱ� ������ �ֱ�� ������ ���⿡ ���� �����δ�.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		}
		
		// ���Ͱ� ������ ���� �ݺ����� ���������� �ȴ�, �̶� ���͸� �ʷ��̺� �󿡼� �����Ѵ�.
		mapLabel.remove(monster);
	}
	
	// MonsterN�� ���ݹ޴� �Լ�
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// ������ hp�� 0�� �Ǿ��� ���
			monsterFlag = false;
		}
		return monsterFlag;
	}
}

class Monster3 extends Monster implements Runnable {
	// Monster3�� ���ǵ�
	public static int MONSTER3_SPEED = 5;
	public static int NUM = 3;
	private boolean monsterFlag = true;
	private UIManager ui;
	
	public Monster3(UIManager v, int hp, Point real, Map _map) {
		super(NUM, hp, MONSTER3_SPEED, real, _map);
		// TODO Auto-generated constructor stub
		
		ui = v;
	}

	@Override
	public void run() {
		// ���� �����尡 ����Ǹ� �ʷ��̺� �� ���� ���̺��� ADD
		JLabel mapLabel = ui.getSinglePanel().getMapLabel();
		mapLabel.add(monster);
		monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// ���Ͱ� ������ �ֱ�� ������ ���⿡ ���� �����δ�.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		}
		
		// ���Ͱ� ������ ���� �ݺ����� ���������� �ȴ�, �̶� ���͸� �ʷ��̺� �󿡼� �����Ѵ�.
		mapLabel.remove(monster);
	}
	
	// MonsterN�� ���ݹ޴� �Լ�
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// ������ hp�� 0�� �Ǿ��� ���
			monsterFlag = false;
		}
		return monsterFlag;
	}
}

class Monster4 extends Monster implements Runnable {
	// Monster4�� ���ǵ�
	public static int MONSTER4_SPEED = 4;
	public static int NUM = 4;
	private boolean monsterFlag = true;
	private UIManager ui;
	
	public Monster4(UIManager v, int hp, Point real, Map _map) {
		super(NUM, hp, MONSTER4_SPEED, real, _map);
		// TODO Auto-generated constructor stub
		
		ui = v;
	}

	@Override
	public void run() {
		// ���� �����尡 ����Ǹ� �ʷ��̺� �� ���� ���̺��� ADD
		JLabel mapLabel = ui.getSinglePanel().getMapLabel();
		mapLabel.add(monster);
		monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// ���Ͱ� ������ �ֱ�� ������ ���⿡ ���� �����δ�.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		}
		
		// ���Ͱ� ������ ���� �ݺ����� ���������� �ȴ�, �̶� ���͸� �ʷ��̺� �󿡼� �����Ѵ�.
		mapLabel.remove(monster);
	}
	
	// MonsterN�� ���ݹ޴� �Լ�
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// ������ hp�� 0�� �Ǿ��� ���
			monsterFlag = false;
		}
		return monsterFlag;
	}
}

class Monster5 extends Monster implements Runnable {
	// Monster5�� ���ǵ�
	public static int MONSTER5_SPEED = 5;
	public static int NUM = 5;
	private boolean monsterFlag = true;
	private UIManager ui;
	
	public Monster5(UIManager v, int hp, Point real, Map _map) {
		super(NUM, hp, MONSTER5_SPEED, real, _map);
		// TODO Auto-generated constructor stub
		
		ui = v;
	}

	@Override
	public void run() {
		// ���� �����尡 ����Ǹ� �ʷ��̺� �� ���� ���̺��� ADD
		JLabel mapLabel = ui.getSinglePanel().getMapLabel();
		mapLabel.add(monster);
		monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// ���Ͱ� ������ �ֱ�� ������ ���⿡ ���� �����δ�.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		}
		
		// ���Ͱ� ������ ���� �ݺ����� ���������� �ȴ�, �̶� ���͸� �ʷ��̺� �󿡼� �����Ѵ�.
		mapLabel.remove(monster);
	}
	
	// MonsterN�� ���ݹ޴� �Լ�
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// ������ hp�� 0�� �Ǿ��� ���
			monsterFlag = false;
		}
		return monsterFlag;
	}
}

class Monster6 extends Monster implements Runnable {
	// Monster6�� ���ǵ�
	public static int MONSTER6_SPEED = 5;
	public static int NUM = 6;
	private boolean monsterFlag = true;
	private UIManager ui;
	
	public Monster6(UIManager v, int hp, Point real, Map _map) {
		super(NUM, hp, MONSTER6_SPEED, real, _map);
		// TODO Auto-generated constructor stub
		
		ui = v;
	}

	@Override
	public void run() {
		// ���� �����尡 ����Ǹ� �ʷ��̺� �� ���� ���̺��� ADD
		JLabel mapLabel = ui.getSinglePanel().getMapLabel();
		mapLabel.add(monster);
		monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// ���Ͱ� ������ �ֱ�� ������ ���⿡ ���� �����δ�.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		}
		
		// ���Ͱ� ������ ���� �ݺ����� ���������� �ȴ�, �̶� ���͸� �ʷ��̺� �󿡼� �����Ѵ�.
		mapLabel.remove(monster);
	}
	
	// MonsterN�� ���ݹ޴� �Լ�
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// ������ hp�� 0�� �Ǿ��� ���
			monsterFlag = false;
		}
		return monsterFlag;
	}
}

class Monster7 extends Monster implements Runnable {
	// Monster2�� ���ǵ�
	public static int MONSTER7_SPEED = 5;
	public static int NUM = 7;
	private boolean monsterFlag = true;
	private UIManager ui;
	
	public Monster7(UIManager v, int hp, Point real, Map _map) {
		super(NUM, hp, MONSTER7_SPEED, real, _map);
		// TODO Auto-generated constructor stub
		
		ui = v;
	}

	@Override
	public void run() {
		// ���� �����尡 ����Ǹ� �ʷ��̺� �� ���� ���̺��� ADD
		JLabel mapLabel = ui.getSinglePanel().getMapLabel();
		mapLabel.add(monster);
		monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// ���Ͱ� ������ �ֱ�� ������ ���⿡ ���� �����δ�.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		}
		
		// ���Ͱ� ������ ���� �ݺ����� ���������� �ȴ�, �̶� ���͸� �ʷ��̺� �󿡼� �����Ѵ�.
		mapLabel.remove(monster);
	}
	
	// MonsterN�� ���ݹ޴� �Լ�
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// ������ hp�� 0�� �Ǿ��� ���
			monsterFlag = false;
		}
		return monsterFlag;
	}
}

class Monster8 extends Monster implements Runnable {
	// Monster8�� ���ǵ�
	public static int MONSTER8_SPEED = 5;
	public static int NUM = 8;
	private boolean monsterFlag = true;
	private UIManager ui;
	
	public Monster8(UIManager v, int hp, Point real, Map _map) {
		super(NUM, hp, MONSTER8_SPEED, real, _map);
		// TODO Auto-generated constructor stub
		
		ui = v;
	}

	@Override
	public void run() {
		// ���� �����尡 ����Ǹ� �ʷ��̺� �� ���� ���̺��� ADD
		JLabel mapLabel = ui.getSinglePanel().getMapLabel();
		mapLabel.add(monster);
		monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// ���Ͱ� ������ �ֱ�� ������ ���⿡ ���� �����δ�.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		}
		
		// ���Ͱ� ������ ���� �ݺ����� ���������� �ȴ�, �̶� ���͸� �ʷ��̺� �󿡼� �����Ѵ�.
		mapLabel.remove(monster);
	}
	
	// MonsterN�� ���ݹ޴� �Լ�
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// ������ hp�� 0�� �Ǿ��� ���
			monsterFlag = false;
		}
		return monsterFlag;
	}
}

class Monster9 extends Monster implements Runnable {
	// Monster9�� ���ǵ�
	public static int MONSTER9_SPEED = 5;
	public static int NUM = 9;
	private boolean monsterFlag = true;
	private UIManager ui;
	
	
	public Monster9(UIManager v, int hp, Point real, Map _map) {
		super(NUM, hp, MONSTER9_SPEED, real, _map);
		// TODO Auto-generated constructor stub
		
		ui = v;
	}

	@Override
	public void run() {
		// ���� �����尡 ����Ǹ� �ʷ��̺� �� ���� ���̺��� ADD
		JLabel mapLabel = ui.getSinglePanel().getMapLabel();
		mapLabel.add(monster);
		monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// ���Ͱ� ������ �ֱ�� ������ ���⿡ ���� �����δ�.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		}
		
		// ���Ͱ� ������ ���� �ݺ����� ���������� �ȴ�, �̶� ���͸� �ʷ��̺� �󿡼� �����Ѵ�.
		mapLabel.remove(monster);
	}
	
	// MonsterN�� ���ݹ޴� �Լ�
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// ������ hp�� 0�� �Ǿ��� ���
			monsterFlag = false;
		}
		return monsterFlag;
	}
}