package Control;
import java.io.*;
import java.util.ArrayList;

import View.ViewManager;

import javax.swing.*;


abstract class Monster {
	protected int hp; 		// ������ ü��
	protected int speed;		// ������ �ӵ�
	protected Point mapPos;		// map_array �迭 �󿡼� ������ ��ġ, centerPos���� �������� �Ǵ�
	protected Point realPos;	// map_label �󿡼� ������ ���� ��ǥ(x, y)
	protected Point centerPos;	// map_label�󿡼� ������ centerPos ��ǥ(x, y)
	protected int moveCount = 0;	// ������ �̹��� ��ȯ �ֱ� ī��Ʈ
	protected int changeState = 0;// ������ �̹��� ���� ��ȣ	
	protected int direction;
	
	protected int monsterNum;			// � �������� ǥ��
	protected JLabel mapLabel;
	
	final public static int MONSTER_FPS = 60;
	// Map
	protected Map map;
	
	// ���̺�� �̹���
	static public ImageIcon[][] imgDir = new ImageIcon[10][];
	protected JLabel monster;
	
	final static int DOWN = 0, UP = 1, RIGHT = 2, LEFT = 3;	// ���� �÷���
	final static int CHANGE = 3;				// ������ �̹����� ��ȯ �ֱ�
	
	// imgDir 2���� String �迭�� ���� �̹����� ��θ� �����ϴ� static �Լ�
	public static void setImageDir() {
		for(int i=0; i<imgDir.length; i++) {
			imgDir[i] = new ImageIcon[8];
			
			for(int j=0; j<4; j++) {
				for(int k=0; k<2; k++) {
					imgDir[i][j*2+k] = new ImageIcon("Image/Monster/monster" + i + "_" + j + "" + k + ".png");
				}
			}
		}
	}
	
	public Monster(int monster_num, int hp, int speed, Point real, Map _map, JLabel map_label) {
		monsterNum = monster_num;
		realPos = new Point(real.getX(), real.getY());
		this.hp = hp;
		this.speed = speed;
		map = _map;
		// ��ǥ�� ����
		centerPos = realPos.getCenterPosition();
		mapPos = centerPos.getMapPosition();			// centerPos���� �������� �Ǵ�
		moveCount = 0;
		mapLabel = map_label;
	}
	
	// ���Ͱ� ��θ� ���� move�Լ��� ȣ���ϴ� �Լ�
	public void ActiveMonster() {
		//direction = map.getMap()[mapPos.getX()][mapPos.getY()].getDirection();
		
		Point leftUp = new Point(realPos.getX() + 5, realPos.getY() + 5);
		Point rightDown = new Point(realPos.getX() + Point.WIDTH - 5, realPos.getY() + Point.HEIGHT - 5);
		
		if(leftUp.getX() > mapPos.getY()*Point.WIDTH && leftUp.getX() < mapPos.getY()*Point.WIDTH + Point.WIDTH/2
				&& leftUp.getY() > mapPos.getX()*Point.HEIGHT && leftUp.getY() < mapPos.getX()*Point.HEIGHT + Point.HEIGHT/2) {
			if(rightDown.getX() < (mapPos.getY() + 1)*Point.WIDTH && rightDown.getX() > mapPos.getY()*Point.WIDTH + Point.WIDTH/2
					&& rightDown.getY() < (mapPos.getX() + 1)*Point.HEIGHT &&  rightDown.getY() > mapPos.getX()*Point.HEIGHT + Point.HEIGHT/2) {
				direction = map.getMap()[mapPos.getX()][mapPos.getY()].getDirection();
			}
		}
		
	
		move(direction);
	}
	
	// ���Ͱ� ������ �������� �����̴� �Լ�
	public void move(int direction) {
		
		if(direction >= DOWN && direction <= LEFT) {
			moveCount++;
			switch(direction) {
			case DOWN:
				realPos.setY(realPos.getY() + speed);
				centerPos.setY(centerPos.getY() + speed);
				break;
			case UP:
				realPos.setY(realPos.getY() - speed);
				centerPos.setY(centerPos.getY() - speed);
				break;
			case RIGHT:
				realPos.setX(realPos.getX() + speed);
				centerPos.setX(centerPos.getX() + speed);
				break;
			case LEFT:
				realPos.setX(realPos.getX() - speed);
				centerPos.setX(centerPos.getX() - speed);
				break;
			}
			// ��� ��ġ ����
			mapPos = centerPos.getMapPosition();
			if(moveCount == CHANGE) {	// ������ �ֱ�� ������ �̹����� ������Ʈ
				moveCount = 0;
				monster.setIcon(imgDir[monsterNum][direction*2 + changeState]);
				changeState++;
				if(changeState == 2)
					changeState = 0;
			}
		}
		return;
	}
	// ���Ͱ� ���ݹ޴� �Լ�, damage��ŭ hp����, hp = 0�̸� true, hp != 0�̸� false ��ȯ
	public boolean attacked(int damage) {
		hp = hp - damage;
		if(hp <= 0)
			return true;
		return false;
	}
	
	public Point getMapPosition() {
		return mapPos;
	}
	// ���Ͱ� ���� ������ �����Ͽ����� �Ǵ�
	public boolean isArrivedEnd() {
		Point end = map.getEndPosition();
		// ���������� ���ٸ� true
		if(end.getX() == mapPos.getX() && end.getY() == mapPos.getY())
			return true;
		return false;
	}
	
	public void setMonsterFalse() { } // ���� �����带 �����ϴ� �Լ�
}

class Monster0 extends Monster implements Runnable {
	// Monster0�� ���ǵ�
	final public static int MONSTER0_SPEED = 10;
	final public static int NUM = 0;
	final public static int HP = 20;
	final public static int MONEY = 20;
	
	private Control_Manager control;
	
	private boolean monsterFlag = true;
	
	public Monster0(Point real, Map _map, JLabel map_label) {
		super(NUM, HP, MONSTER0_SPEED, real, _map, map_label);
		
		// TODO Auto-generated constructor stub
		// ������ �ʱ� ��ġ�� ���� ����
		monster = new JLabel(imgDir[NUM][map.getMap()[mapPos.getX()][mapPos.getY()].getDirection()*2]);
		control = Control_Manager.getInstance(null);
		control.getMonsterList().add(this);
	}

	@Override
	public void run() {
		// ���� �����尡 ����Ǹ� �ʷ��̺� �� ���� ���̺��� ADD
		mapLabel.add(monster);
		monster.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// ���Ͱ� ������ �ֱ�� ������ ���⿡ ���� �����δ�.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
			if(isArrivedEnd()) {
				control.setGameFlag(Control_Manager.SINGLE_LOSE);
			}
			
			try {
				Thread.sleep(MONSTER_FPS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// ���Ͱ� ������ ���� �ݺ����� ���������� �ȴ�, �̶� ���͸� �ʷ��̺� �󿡼� �����Ѵ�.
		mapLabel.remove(monster);
		
		ArrayList<Monster> monsterList = control.getMonsterList();
		monsterList.remove(this);
		
		control.setMoney(control.getMoney() + MONEY);	// ���Ͱ� ������ �� ���
		control.setScore(control.getScore() + MONEY);
	}
	
	// MonsterN�� ���ݹ޴� �Լ�
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// ������ hp�� 0�� �Ǿ��� ���
			setMonsterFalse();
		}
		return monsterFlag;
	}
	public void setMonsterFalse() {
		monsterFlag = false;
	}
	
}

class Monster1 extends Monster implements Runnable {
	// Monster1�� ���ǵ�
	final public static int MONSTER1_SPEED = 2;
	final public static int NUM = 1;
	final public static int HP = 40;
	private boolean monsterFlag = true;
	private Control_Manager control;
	
	final public static int MONEY = 50;
	
	public Monster1(Point real, Map _map, JLabel map_label) {
		super(NUM, HP, MONSTER1_SPEED, real, _map, map_label);
		// TODO Auto-generated constructor stub
		
		monster = new JLabel(imgDir[NUM][map.getMap()[mapPos.getX()][mapPos.getY()].getDirection()*2]);
		
		control = Control_Manager.getInstance(null);
		control.getMonsterList().add(this);
	}

	@Override
	public void run() {
		// ���� �����尡 ����Ǹ� �ʷ��̺� �� ���� ���̺��� ADD
		mapLabel.add(monster);
		monster.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// ���Ͱ� ������ �ֱ�� ������ ���⿡ ���� �����δ�.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
			
			if(isArrivedEnd()) {
				control.setGameFlag(Control_Manager.SINGLE_LOSE);
			}
			
			try {
				Thread.sleep(MONSTER_FPS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// ���Ͱ� ������ ���� �ݺ����� ���������� �ȴ�, �̶� ���͸� �ʷ��̺� �󿡼� �����Ѵ�.
		mapLabel.remove(monster);
		
		ArrayList<Monster> monsterList = control.getMonsterList();
		monsterList.remove(this);
		
		control.setMoney(control.getMoney() + MONEY);	// ���Ͱ� ������ �� ���
		control.setScore(control.getScore() + MONEY);
	}
	
	// MonsterN�� ���ݹ޴� �Լ�
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// ������ hp�� 0�� �Ǿ��� ���
			setMonsterFalse();
		}
		return monsterFlag;
	}
	public void setMonsterFalse() {
		monsterFlag = false;
	}
}

class Monster2 extends Monster implements Runnable {
	// Monster2�� ���ǵ�
	final public static int MONSTER2_SPEED = 2;
	final public static int NUM = 2;
	final public static int HP = 60;
	private boolean monsterFlag = true;
	private Control_Manager control;
	final public static int MONEY = 80;
	
	public Monster2(Point real, Map _map, JLabel map_label) {
		super(NUM, HP, MONSTER2_SPEED, real, _map, map_label);
		// TODO Auto-generated constructor stub
		monster = new JLabel(imgDir[NUM][map.getMap()[mapPos.getX()][mapPos.getY()].getDirection()*2]);
		control = Control_Manager.getInstance(null);
		control.getMonsterList().add(this);
	}

	@Override
	public void run() {
		// ���� �����尡 ����Ǹ� �ʷ��̺� �� ���� ���̺��� ADD
		mapLabel.add(monster);
		monster.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// ���Ͱ� ������ �ֱ�� ������ ���⿡ ���� �����δ�.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
			
			if(isArrivedEnd()) {
				control.setGameFlag(Control_Manager.SINGLE_LOSE);
			}
			
			try {
				Thread.sleep(MONSTER_FPS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// ���Ͱ� ������ ���� �ݺ����� ���������� �ȴ�, �̶� ���͸� �ʷ��̺� �󿡼� �����Ѵ�.
		mapLabel.remove(monster);
		
		ArrayList<Monster> monsterList = control.getMonsterList();
		monsterList.remove(this);
		
		control.setMoney(control.getMoney() + MONEY);	// ���Ͱ� ������ �� ���
		control.setScore(control.getScore() + MONEY);
	}
	
	// MonsterN�� ���ݹ޴� �Լ�
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// ������ hp�� 0�� �Ǿ��� ���
			setMonsterFalse();
		}
		return monsterFlag;
	}
	public void setMonsterFalse() {
		monsterFlag = false;
	}
}

class Monster3 extends Monster implements Runnable {
	// Monster3�� ���ǵ�
	public static int MONSTER3_SPEED = 2;
	public static int NUM = 3;
	final public static int HP = 80;
	private boolean monsterFlag = true;
	private Control_Manager control;
	final public static int MONEY = 100;
	
	public Monster3(Point real, Map _map, JLabel map_label) {
		super(NUM, HP, MONSTER3_SPEED, real, _map, map_label);
		// TODO Auto-generated constructor stub
		monster = new JLabel(imgDir[NUM][map.getMap()[mapPos.getX()][mapPos.getY()].getDirection()*2]);
		control = Control_Manager.getInstance(null);
		control.getMonsterList().add(this);
	}

	@Override
	public void run() {
		// ���� �����尡 ����Ǹ� �ʷ��̺� �� ���� ���̺��� ADD
		mapLabel.add(monster);
		monster.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// ���Ͱ� ������ �ֱ�� ������ ���⿡ ���� �����δ�.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
			
			if(isArrivedEnd()) {
				control.setGameFlag(Control_Manager.SINGLE_LOSE);
			}
			
			try {
				Thread.sleep(MONSTER_FPS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// ���Ͱ� ������ ���� �ݺ����� ���������� �ȴ�, �̶� ���͸� �ʷ��̺� �󿡼� �����Ѵ�.
		mapLabel.remove(monster);
		
		ArrayList<Monster> monsterList = control.getMonsterList();
		monsterList.remove(this);
		
		control.setMoney(control.getMoney() + MONEY);	// ���Ͱ� ������ �� ���
		control.setScore(control.getScore() + MONEY);
	}
	
	// MonsterN�� ���ݹ޴� �Լ�
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// ������ hp�� 0�� �Ǿ��� ���
			setMonsterFalse();
		}
		return monsterFlag;
	}
	public void setMonsterFalse() {
		monsterFlag = false;
	}
}

class Monster4 extends Monster implements Runnable {
	// Monster4�� ���ǵ�
	public static int MONSTER4_SPEED = 3;
	public static int NUM = 4;
	final public static int HP = 100;
	private boolean monsterFlag = true;
	private Control_Manager control;
	final public static int MONEY = 130;
	
	public Monster4(Point real, Map _map, JLabel map_label) {
		super(NUM, HP, MONSTER4_SPEED, real, _map, map_label);
		// TODO Auto-generated constructor stub
		monster = new JLabel(imgDir[NUM][map.getMap()[mapPos.getX()][mapPos.getY()].getDirection()*2]);
		control = Control_Manager.getInstance(null);
		control.getMonsterList().add(this);
	}

	@Override
	public void run() {
		// ���� �����尡 ����Ǹ� �ʷ��̺� �� ���� ���̺��� ADD
		mapLabel.add(monster);
		monster.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// ���Ͱ� ������ �ֱ�� ������ ���⿡ ���� �����δ�.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
			
			if(isArrivedEnd()) {
				control.setGameFlag(Control_Manager.SINGLE_LOSE);
			}
			
			try {
				Thread.sleep(MONSTER_FPS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// ���Ͱ� ������ ���� �ݺ����� ���������� �ȴ�, �̶� ���͸� �ʷ��̺� �󿡼� �����Ѵ�.
		mapLabel.remove(monster);
		
		ArrayList<Monster> monsterList = control.getMonsterList();
		monsterList.remove(this);
		
		control.setMoney(control.getMoney() + MONEY);	// ���Ͱ� ������ �� ���
		control.setScore(control.getScore() + MONEY);
	}
	
	// MonsterN�� ���ݹ޴� �Լ�
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// ������ hp�� 0�� �Ǿ��� ���
			setMonsterFalse();
		}
		return monsterFlag;
	}
	public void setMonsterFalse() {
		monsterFlag = false;
	}
}

class Monster5 extends Monster implements Runnable {
	// Monster5�� ���ǵ�
	public static int MONSTER5_SPEED = 3;
	public static int NUM = 5;
	final public static int HP = 120;
	private boolean monsterFlag = true;
	private Control_Manager control;
	final public static int MONEY = 150;
	
	public Monster5(Point real, Map _map, JLabel map_label) {
		super(NUM, HP, MONSTER5_SPEED, real, _map, map_label);
		// TODO Auto-generated constructor stub
		monster = new JLabel(imgDir[NUM][map.getMap()[mapPos.getX()][mapPos.getY()].getDirection()*2]);
		control = Control_Manager.getInstance(null);
		control.getMonsterList().add(this);
	}

	@Override
	public void run() {
		// ���� �����尡 ����Ǹ� �ʷ��̺� �� ���� ���̺��� ADD
		mapLabel.add(monster);
		monster.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// ���Ͱ� ������ �ֱ�� ������ ���⿡ ���� �����δ�.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
			
			if(isArrivedEnd()) {
				control.setGameFlag(Control_Manager.SINGLE_LOSE);
			}
			
			try {
				Thread.sleep(MONSTER_FPS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// ���Ͱ� ������ ���� �ݺ����� ���������� �ȴ�, �̶� ���͸� �ʷ��̺� �󿡼� �����Ѵ�.
		mapLabel.remove(monster);
		
		ArrayList<Monster> monsterList = control.getMonsterList();
		monsterList.remove(this);
		
		control.setMoney(control.getMoney() + MONEY);	// ���Ͱ� ������ �� ���
		control.setScore(control.getScore() + MONEY);
	}
	
	// MonsterN�� ���ݹ޴� �Լ�
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// ������ hp�� 0�� �Ǿ��� ���
			setMonsterFalse();
		}
		return monsterFlag;
	}
	public void setMonsterFalse() {
		monsterFlag = false;
	}
}

class Monster6 extends Monster implements Runnable {
	// Monster6�� ���ǵ�
	public static int MONSTER6_SPEED = 3;
	public static int NUM = 6;
	final public static int HP = 140;
	private boolean monsterFlag = true;
	private Control_Manager control;
	final public static int MONEY = 200;
	
	public Monster6(Point real, Map _map, JLabel map_label) {
		super(NUM, HP, MONSTER6_SPEED, real, _map, map_label);
		// TODO Auto-generated constructor stub
		monster = new JLabel(imgDir[NUM][map.getMap()[mapPos.getX()][mapPos.getY()].getDirection()*2]);
		control = Control_Manager.getInstance(null);
		control.getMonsterList().add(this);
	}

	@Override
	public void run() {
		// ���� �����尡 ����Ǹ� �ʷ��̺� �� ���� ���̺��� ADD
		mapLabel.add(monster);
		monster.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// ���Ͱ� ������ �ֱ�� ������ ���⿡ ���� �����δ�.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
			
			if(isArrivedEnd()) {
				control.setGameFlag(Control_Manager.SINGLE_LOSE);
			}
			
			try {
				Thread.sleep(MONSTER_FPS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// ���Ͱ� ������ ���� �ݺ����� ���������� �ȴ�, �̶� ���͸� �ʷ��̺� �󿡼� �����Ѵ�.
		mapLabel.remove(monster);
		
		ArrayList<Monster> monsterList = control.getMonsterList();
		monsterList.remove(this);
		
		control.setMoney(control.getMoney() + MONEY);	// ���Ͱ� ������ �� ���
		control.setScore(control.getScore() + MONEY);
	}
	
	// MonsterN�� ���ݹ޴� �Լ�
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// ������ hp�� 0�� �Ǿ��� ���
			setMonsterFalse();
		}
		return monsterFlag;
	}
	public void setMonsterFalse() {
		monsterFlag = false;
	}
}

class Monster7 extends Monster implements Runnable {
	// Monster2�� ���ǵ�
	public static int MONSTER7_SPEED = 3;
	public static int NUM = 7;
	final public static int HP = 160;
	private boolean monsterFlag = true;
	private Control_Manager control;
	final public static int MONEY = 200;
	
	public Monster7(Point real, Map _map, JLabel map_label) {
		super(NUM, HP, MONSTER7_SPEED, real, _map, map_label);
		// TODO Auto-generated constructor stub
		monster = new JLabel(imgDir[NUM][map.getMap()[mapPos.getX()][mapPos.getY()].getDirection()*2]);
		control = Control_Manager.getInstance(null);
		control.getMonsterList().add(this);
	}

	@Override
	public void run() {
		// ���� �����尡 ����Ǹ� �ʷ��̺� �� ���� ���̺��� ADD
		mapLabel.add(monster);
		monster.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// ���Ͱ� ������ �ֱ�� ������ ���⿡ ���� �����δ�.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
			
			if(isArrivedEnd()) {
				control.setGameFlag(Control_Manager.SINGLE_LOSE);
			}
			
			try {
				Thread.sleep(MONSTER_FPS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// ���Ͱ� ������ ���� �ݺ����� ���������� �ȴ�, �̶� ���͸� �ʷ��̺� �󿡼� �����Ѵ�.
		mapLabel.remove(monster);
		
		ArrayList<Monster> monsterList = control.getMonsterList();
		monsterList.remove(this);
		
		control.setMoney(control.getMoney() + MONEY);	// ���Ͱ� ������ �� ���
		control.setScore(control.getScore() + MONEY);
	}
	
	// MonsterN�� ���ݹ޴� �Լ�
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// ������ hp�� 0�� �Ǿ��� ���
			setMonsterFalse();
		}
		return monsterFlag;
	}
	public void setMonsterFalse() {
		monsterFlag = false;
	}
}

class Monster8 extends Monster implements Runnable {
	// Monster8�� ���ǵ�
	public static int MONSTER8_SPEED = 5;
	public static int NUM = 8;
	final public static int HP = 180;
	private boolean monsterFlag = true;
	private Control_Manager control;
	final public static int MONEY = 200;
	
	public Monster8(Point real, Map _map, JLabel map_label) {
		super(NUM, HP, MONSTER8_SPEED, real, _map, map_label);
		// TODO Auto-generated constructor stub
		monster = new JLabel(imgDir[NUM][map.getMap()[mapPos.getX()][mapPos.getY()].getDirection()*2]);
		control = Control_Manager.getInstance(null);
		control.getMonsterList().add(this);
	}

	@Override
	public void run() {
		// ���� �����尡 ����Ǹ� �ʷ��̺� �� ���� ���̺��� ADD
		mapLabel.add(monster);
		monster.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// ���Ͱ� ������ �ֱ�� ������ ���⿡ ���� �����δ�.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
			
			if(isArrivedEnd()) {
				control.setGameFlag(Control_Manager.SINGLE_LOSE);
			}
			
			try {
				Thread.sleep(MONSTER_FPS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// ���Ͱ� ������ ���� �ݺ����� ���������� �ȴ�, �̶� ���͸� �ʷ��̺� �󿡼� �����Ѵ�.
		mapLabel.remove(monster);
		
		ArrayList<Monster> monsterList = control.getMonsterList();
		monsterList.remove(this);
		
		control.setMoney(control.getMoney() + MONEY);	// ���Ͱ� ������ �� ���
		control.setScore(control.getScore() + MONEY);
	}
	
	// MonsterN�� ���ݹ޴� �Լ�
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// ������ hp�� 0�� �Ǿ��� ���
			setMonsterFalse();
		}
		return monsterFlag;
	}
	
	public void setMonsterFalse() {
		monsterFlag = false;
	}
}

class Monster9 extends Monster implements Runnable {
	// Monster9�� ���ǵ�
	public static int MONSTER9_SPEED = 5;
	public static int NUM = 9;
	final public static int HP = 200;
	private boolean monsterFlag = true;
	private Control_Manager control;
	final public static int MONEY = 200;
	
	public Monster9(Point real, Map _map, JLabel map_label) {
		super(NUM, HP, MONSTER9_SPEED, real, _map, map_label);
		// TODO Auto-generated constructor stub
		monster = new JLabel(imgDir[NUM][map.getMap()[mapPos.getX()][mapPos.getY()].getDirection()*2]);
		control = Control_Manager.getInstance(null);
		control.getMonsterList().add(this);
	}

	@Override
	public void run() {
		// ���� �����尡 ����Ǹ� �ʷ��̺� �� ���� ���̺��� ADD
		mapLabel.add(monster);
		monster.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// ���Ͱ� ������ �ֱ�� ������ ���⿡ ���� �����δ�.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
			
			if(isArrivedEnd()) {
				control.setGameFlag(Control_Manager.SINGLE_LOSE);
			}
			
			try {
				Thread.sleep(MONSTER_FPS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// ���Ͱ� ������ ���� �ݺ����� ���������� �ȴ�, �̶� ���͸� �ʷ��̺� �󿡼� �����Ѵ�.
		mapLabel.remove(monster);
		
		ArrayList<Monster> monsterList = control.getMonsterList();
		monsterList.remove(this);
		
		control.setMoney(control.getMoney() + MONEY);	// ���Ͱ� ������ �� ���
		control.setScore(control.getScore() + MONEY);
	}
	
	// MonsterN�� ���ݹ޴� �Լ�
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// ������ hp�� 0�� �Ǿ��� ���
			setMonsterFalse();
		}
		return monsterFlag;
	}
	
	public void setMonsterFalse() {
		monsterFlag = false;
	}
}