package Control;
import javax.swing.*;



public class Tower {
	// 타워의 이미지 레이블
	protected JLabel tower;
	// 타워의 실제 좌표
	protected Point realPos;
	// 타워의 맵행렬 상의 좌표
	protected Point mapPos;
	// 타워의 공격지점 좌표(맵 행렬상의 좌표)
	protected Point attackPos;
	// 맵 행렬
	protected Map map;
	// 맵 레이블
	protected JLabel mapLabel;
	// 타워의 공격 시작 플래그
	protected boolean attackFlag;
	// 타워의 공격 범위
	final public static int RANGE = 1;
	
	// real 포인트 객체에는 마우스의 위치를 입력해도 된다.
	public Tower(Point real, Map _map, JLabel map_label) {
		realPos = real;
		mapPos = realPos.getMapPosition();
		attackPos = null;
		attackFlag = false;
		map = _map;
		mapLabel = map_label;
	}
	// 타워의 공격지점을 설정하는 함수 ,맵행렬 좌표로 입력
	public void setAttackPosition(Point attack) {
		if(attack == null) {
			attackFlag = false;
			return;
		}
		attackPos = attack;
		attackFlag = true;
	}
	// 타워를 맵레이블에 추가하는 함수
	public void construct() {
		Point real = new Point(mapPos.getY()*Point.WIDTH, mapPos.getX()*Point.HEIGHT);
		tower.setBounds(real.getX(), real.getY(), Point.WIDTH, Point.HEIGHT);
		mapLabel.add(tower);
		
		map.getMap()[mapPos.getX()][mapPos.getY()].setTower(true);
	}
	
	public Point getAttackPosition() {
		return attackPos;
	}
	
	public Point getMapPosition() {
		return mapPos;
	}
	
	
	
	public void setTowerFalse() { }
}

class Tower0 extends Tower implements Runnable {
	// 발사 속도
	final public static int FIRE_SPEED = 800;
	// 비용
	final public static int COST = 100;
	private Bullet0 bullet;
	private boolean towerFlag = true;
	private ImageIcon TOWER0 = new ImageIcon("Image/Tower/tower0.png");
	
	public Tower0(Point real, Map _map, JLabel map_label) {
		super(real, _map, map_label);
		tower = new JLabel(TOWER0);
		construct();
	}
	
	public void setTowerFalse() {
		towerFlag = false;
	}
	
	public void run() {
		while(towerFlag) {
			try {
				if(attackFlag) {
					bullet = new Bullet0(this, realPos, mapLabel);
					Thread fire = new Thread(bullet);
					fire.start();
				}
				Thread.sleep(FIRE_SPEED);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Tower1 extends Tower implements Runnable {
	// 발사 속도
	final public static int FIRE_SPEED = 800;
	final public static int COST = 200;
	private Bullet1 bullet;
	private boolean towerFlag = true;
	private ImageIcon TOWER1 = new ImageIcon("Image/Tower/tower1.png");
	
	public Tower1(Point real, Map _map, JLabel map_label) {
		super(real, _map, map_label);
		tower = new JLabel(TOWER1);
		construct();
	}
	
	public void setTowerFalse() {
		towerFlag = false;
	}
	
	public void run() {
		while(towerFlag) {
			try {
				if(attackFlag) {
					bullet = new Bullet1(this, realPos, mapLabel);
					Thread fire = new Thread(bullet);
					fire.start();
				}
				Thread.sleep(FIRE_SPEED);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class Tower2 extends Tower implements Runnable {
	// 발사 속도
	final public static int FIRE_SPEED = 800;
	final public static int COST = 300;
	private Bullet2 bullet;
	private boolean towerFlag = true;
	private ImageIcon TOWER2 = new ImageIcon("Image/Tower/tower2.png");
	
	public Tower2(Point real, Map _map, JLabel map_label) {
		super(real, _map, map_label);
		tower = new JLabel(TOWER2);
		construct();
	}
	
	public void setTowerFalse() {
		towerFlag = false;
	}
	
	public void run() {
		while(towerFlag) {
			try {
				if(attackFlag) {
					bullet = new Bullet2(this, realPos, mapLabel);
					Thread fire = new Thread(bullet);
					fire.start();
				}
				Thread.sleep(FIRE_SPEED);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Tower3 extends Tower implements Runnable {
	// 발사 속도
	final public static int FIRE_SPEED = 800;
	final public static int COST = 400;
	private Bullet3 bullet;
	private boolean towerFlag = true;
	private ImageIcon TOWER3 = new ImageIcon("Image/Tower/tower3.png");
	
	public Tower3(Point real, Map _map, JLabel map_label) {
		super(real, _map, map_label);
		tower = new JLabel(TOWER3);
		construct();
	}
	
	public void setTowerFalse() {
		towerFlag = false;
	}
	
	public void run() {
		while(towerFlag) {
			try {
				if(attackFlag) {
					bullet = new Bullet3(this, realPos, mapLabel);
					Thread fire = new Thread(bullet);
					fire.start();
				}
				Thread.sleep(FIRE_SPEED);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Tower4 extends Tower implements Runnable {
	// 발사 속도
	final public static int FIRE_SPEED = 800;
	final public static int COST = 500;
	private Bullet4 bullet;
	private boolean towerFlag = true;
	private ImageIcon TOWER4 = new ImageIcon("Image/Tower/tower4.png");
	
	public Tower4(Point real, Map _map, JLabel map_label) {
		super(real, _map, map_label);
		tower = new JLabel(TOWER4);
		construct();
	}
	
	public void setTowerFalse() {
		towerFlag = false;
	}
	
	public void run() {
		while(towerFlag) {
			try {
				if(attackFlag) {
					bullet = new Bullet4(this, realPos, mapLabel);
					Thread fire = new Thread(bullet);
					fire.start();
				}
				Thread.sleep(FIRE_SPEED);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Tower5 extends Tower implements Runnable {
	// 발사 속도
	final public static int FIRE_SPEED = 800;
	final public static int COST = 600;
	private Bullet5 bullet;
	private boolean towerFlag = true;
	private ImageIcon TOWER5 = new ImageIcon("Image/Tower/tower5.png");
	
	public Tower5(Point real, Map _map, JLabel map_label) {
		super(real, _map, map_label);
		tower = new JLabel(TOWER5);
		construct();
	}
	
	public void setTowerFalse() {
		towerFlag = false;
	}
	
	public void run() {
		while(towerFlag) {
			try {
				if(attackFlag) {
					bullet = new Bullet5(this, realPos, mapLabel);
					Thread fire = new Thread(bullet);
					fire.start();
				}
				Thread.sleep(FIRE_SPEED);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}