package Control;
import java.io.*;
import View.UIManager;

import javax.swing.*;


abstract class Monster {
	protected int hp; 		// 몬스터의 체력
	protected int speed;		// 몬스터의 속도
	protected Point pos;		// map_array 배열 상에서 몬스터의 위치, center값을 기준으로 판단
	protected Point real_pos;	// map_label 상에서 몬스터의 실제 좌표(x, y)
	protected Point center;	// map_label상에서 몬스터의 center 좌표(x, y)
	protected int move_count;	// 몬스터의 이미지 전환 주기 카운트
	protected int changeState = 0;// 몬스터의 이미지 선택 번호	
	protected static int DIRECTION = -1;	// 몬스터의 방향
	protected int monsterNum;			// 어떤 몬스터인지 표시
	// Map
	protected Map map;
	
	// 레이블과 이미지
	static public ImageIcon[][] imgDir = new ImageIcon[10][];
	protected JLabel monster;
	
	final static int DOWN = 0, UP = 1, RI                    GHT = 2, LEFT = 3;	// 방향 플래그
	final static int CHANGE = 3;				// 몬스터의 이미지의 전환 주기
	
	// imgDir 2차원 String 배열에 몬스터 이미지의 경로를 설정하는 static 함수
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
		// 좌표값 설정
		center = real_pos.getCenterPosition();
		pos = center.getMapPosition();			// center값을 기준으로 판단
		move_count = 0;
	}
	
	// 몬스터가 경로를 따라서 move함수를 호출하는 함수
	public void ActiveMonster() {
		int direction = map.getMap()[pos.getX()][pos.getY()].getDirection();
		
		if(direction == -1)	// static DIRECTION 변수를 갱신
			DIRECTION = direction;
		
		move(DIRECTION);
	}
	
	// 몬스터가 지정된 방향으로 움직이는 함수
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
			// 행렬 위치 갱신
			pos = center.getMapPosition();
			
			if(move_count == CHANGE) {	// 일정한 주기로 몬스터의 이미지를 업데이트
				monster.setIcon(imgDir[monsterNum][direction*2 + changeState]);
				changeState++;
				if(changeState == 2)
					changeState = 0;
			}
		}
		System.out.println("Class Monster - move - 잘못된 상수입력");
		return;
	}
	// 몬스터가 공격받는 함수, damage만큼 hp감소, hp = 0이면 true, hp != 0이면 false 반환
	public boolean attacked(int damage) {
		hp = hp - damage;
		if(hp <= 0)
			return true;
		return false;
	}
	
}

class Monster0 extends Monster implements Runnable {
	// Monster0의 스피드
	public static int MONSTER0_SPEED = 3;
	public static int NUM = 0;
	private boolean monsterFlag = true;
	private UIManager ui;
	
	
	public Monster0(UIManager v, int hp, Point real, Map _map) {
		super(NUM, hp, MONSTER0_SPEED, real, _map);
		ui = v;
		
		// TODO Auto-generated constructor stub
		// 몬스터의 초기 위치와 방향 지정
		monster = new JLabel(imgDir[0][map.getMap()[pos.getX()][pos.getY()].getDirection()*2]);
	}

	@Override
	public void run() {
		// 몬스터 스레드가 실행되면 맵레이블 상에 몬스터 레이블을 ADD
		JLabel mapLabel = ui.getSinglePanel().getMapLabel();
		mapLabel.add(monster);
		monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// 몬스터가 일정한 주기로 지정된 방향에 따라서 움직인다.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		}
		
		// 몬스터가 죽으면 위의 반복문을 빠져나오게 된다, 이때 몬스터를 맵레이블 상에서 제거한다.
		mapLabel.remove(monster);
	}
	
	// MonsterN이 공격받는 함수
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// 몬스터의 hp가 0가 되었을 경우
			monsterFlag = false;
		}
		return monsterFlag;
	}
	
}

class Monster1 extends Monster implements Runnable {
	// Monster1의 스피드
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
		// 몬스터 스레드가 실행되면 맵레이블 상에 몬스터 레이블을 ADD
		JLabel mapLabel = ui.getSinglePanel().getMapLabel();
		mapLabel.add(monster);
		monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// 몬스터가 일정한 주기로 지정된 방향에 따라서 움직인다.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		}
		
		// 몬스터가 죽으면 위의 반복문을 빠져나오게 된다, 이때 몬스터를 맵레이블 상에서 제거한다.
		mapLabel.remove(monster);
	}
	
	// MonsterN이 공격받는 함수
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// 몬스터의 hp가 0가 되었을 경우
			monsterFlag = false;
		}
		return monsterFlag;
	}
}

class Monster2 extends Monster implements Runnable {
	// Monster2의 스피드
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
		// 몬스터 스레드가 실행되면 맵레이블 상에 몬스터 레이블을 ADD
		JLabel mapLabel = ui.getSinglePanel().getMapLabel();
		mapLabel.add(monster);
		monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// 몬스터가 일정한 주기로 지정된 방향에 따라서 움직인다.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		}
		
		// 몬스터가 죽으면 위의 반복문을 빠져나오게 된다, 이때 몬스터를 맵레이블 상에서 제거한다.
		mapLabel.remove(monster);
	}
	
	// MonsterN이 공격받는 함수
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// 몬스터의 hp가 0가 되었을 경우
			monsterFlag = false;
		}
		return monsterFlag;
	}
}

class Monster3 extends Monster implements Runnable {
	// Monster3의 스피드
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
		// 몬스터 스레드가 실행되면 맵레이블 상에 몬스터 레이블을 ADD
		JLabel mapLabel = ui.getSinglePanel().getMapLabel();
		mapLabel.add(monster);
		monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// 몬스터가 일정한 주기로 지정된 방향에 따라서 움직인다.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		}
		
		// 몬스터가 죽으면 위의 반복문을 빠져나오게 된다, 이때 몬스터를 맵레이블 상에서 제거한다.
		mapLabel.remove(monster);
	}
	
	// MonsterN이 공격받는 함수
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// 몬스터의 hp가 0가 되었을 경우
			monsterFlag = false;
		}
		return monsterFlag;
	}
}

class Monster4 extends Monster implements Runnable {
	// Monster4의 스피드
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
		// 몬스터 스레드가 실행되면 맵레이블 상에 몬스터 레이블을 ADD
		JLabel mapLabel = ui.getSinglePanel().getMapLabel();
		mapLabel.add(monster);
		monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// 몬스터가 일정한 주기로 지정된 방향에 따라서 움직인다.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		}
		
		// 몬스터가 죽으면 위의 반복문을 빠져나오게 된다, 이때 몬스터를 맵레이블 상에서 제거한다.
		mapLabel.remove(monster);
	}
	
	// MonsterN이 공격받는 함수
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// 몬스터의 hp가 0가 되었을 경우
			monsterFlag = false;
		}
		return monsterFlag;
	}
}

class Monster5 extends Monster implements Runnable {
	// Monster5의 스피드
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
		// 몬스터 스레드가 실행되면 맵레이블 상에 몬스터 레이블을 ADD
		JLabel mapLabel = ui.getSinglePanel().getMapLabel();
		mapLabel.add(monster);
		monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// 몬스터가 일정한 주기로 지정된 방향에 따라서 움직인다.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		}
		
		// 몬스터가 죽으면 위의 반복문을 빠져나오게 된다, 이때 몬스터를 맵레이블 상에서 제거한다.
		mapLabel.remove(monster);
	}
	
	// MonsterN이 공격받는 함수
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// 몬스터의 hp가 0가 되었을 경우
			monsterFlag = false;
		}
		return monsterFlag;
	}
}

class Monster6 extends Monster implements Runnable {
	// Monster6의 스피드
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
		// 몬스터 스레드가 실행되면 맵레이블 상에 몬스터 레이블을 ADD
		JLabel mapLabel = ui.getSinglePanel().getMapLabel();
		mapLabel.add(monster);
		monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// 몬스터가 일정한 주기로 지정된 방향에 따라서 움직인다.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		}
		
		// 몬스터가 죽으면 위의 반복문을 빠져나오게 된다, 이때 몬스터를 맵레이블 상에서 제거한다.
		mapLabel.remove(monster);
	}
	
	// MonsterN이 공격받는 함수
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// 몬스터의 hp가 0가 되었을 경우
			monsterFlag = false;
		}
		return monsterFlag;
	}
}

class Monster7 extends Monster implements Runnable {
	// Monster2의 스피드
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
		// 몬스터 스레드가 실행되면 맵레이블 상에 몬스터 레이블을 ADD
		JLabel mapLabel = ui.getSinglePanel().getMapLabel();
		mapLabel.add(monster);
		monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// 몬스터가 일정한 주기로 지정된 방향에 따라서 움직인다.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		}
		
		// 몬스터가 죽으면 위의 반복문을 빠져나오게 된다, 이때 몬스터를 맵레이블 상에서 제거한다.
		mapLabel.remove(monster);
	}
	
	// MonsterN이 공격받는 함수
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// 몬스터의 hp가 0가 되었을 경우
			monsterFlag = false;
		}
		return monsterFlag;
	}
}

class Monster8 extends Monster implements Runnable {
	// Monster8의 스피드
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
		// 몬스터 스레드가 실행되면 맵레이블 상에 몬스터 레이블을 ADD
		JLabel mapLabel = ui.getSinglePanel().getMapLabel();
		mapLabel.add(monster);
		monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// 몬스터가 일정한 주기로 지정된 방향에 따라서 움직인다.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		}
		
		// 몬스터가 죽으면 위의 반복문을 빠져나오게 된다, 이때 몬스터를 맵레이블 상에서 제거한다.
		mapLabel.remove(monster);
	}
	
	// MonsterN이 공격받는 함수
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// 몬스터의 hp가 0가 되었을 경우
			monsterFlag = false;
		}
		return monsterFlag;
	}
}

class Monster9 extends Monster implements Runnable {
	// Monster9의 스피드
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
		// 몬스터 스레드가 실행되면 맵레이블 상에 몬스터 레이블을 ADD
		JLabel mapLabel = ui.getSinglePanel().getMapLabel();
		mapLabel.add(monster);
		monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		
		// 몬스터가 일정한 주기로 지정된 방향에 따라서 움직인다.
		// TODO Auto-generated method stub
		while(monsterFlag) {
			ActiveMonster();
			
			monster.setBounds(real_pos.getX(), real_pos.getY(), Point.WIDTH, Point.HEIGHT);
		}
		
		// 몬스터가 죽으면 위의 반복문을 빠져나오게 된다, 이때 몬스터를 맵레이블 상에서 제거한다.
		mapLabel.remove(monster);
	}
	
	// MonsterN이 공격받는 함수
	public boolean attacked(int damage) {
		
		
		if(super.attacked(damage)) {	// 몬스터의 hp가 0가 되었을 경우
			monsterFlag = false;
		}
		return monsterFlag;
	}
}