package Control;
import javax.swing.*;
import java.util.*;

public class Bullet {
	// 탄환의 데미지
	protected int damage;
	// 탄환의 공격 지점 (맵 행렬상의 좌표)
	protected Point attackPos;
	// 탄환의 실제 좌표
	protected Point realPos;
	// 탄환의 중간 좌표
	protected Point centerPos;
	// 탄환의 맵 행렬 상의 좌표
	protected Point mapPos;
	// 탄환의 이미지 레이블
	protected JLabel bullet;
	// 탄환의 이펙트 레이블
	protected JLabel effect;
	// 이 상수는 포탄을 몇번 갱신하고 공격지점에 도착 할 것인지 결정한다. 즉, 작을수록 빠르다.
	final public static int BULLET_SPEED = 5;
	// 공격 지점과 시작 지점의 차이 / BULLET_SPEED
	protected Point term;
	// 이 포탄을 소유한 타워의 객체
	protected Tower tower;
	
	public Bullet(Tower _tower, int _damage, Point towerRealPos) {
		damage = _damage;
		realPos = new Point(towerRealPos.getX(), towerRealPos.getY());
		centerPos = realPos.getCenterPosition();
		mapPos = centerPos.getMapPosition();
		term = new Point(0, 0);
		tower = _tower;
	}
	// 공격 지점까지 가는 스피드를 설정한다.
	public void setAttackPosition() {
		int xTerm = attackPos.getY()*Point.WIDTH - realPos.getX();
		int yTerm = attackPos.getX()*Point.HEIGHT - realPos.getY();
		
		term.setX(xTerm/BULLET_SPEED);
		term.setY(yTerm/BULLET_SPEED);
	}
	
	// 탄환이 지정된 방향으로 움직인다.
	public void move() {
		realPos.setX(realPos.getX() + term.getX());
		realPos.setY(realPos.getY() + term.getY());
		centerPos.setX(centerPos.getX() + term.getX());
		centerPos.setY(centerPos.getY() + term.getY());
		
		mapPos = centerPos.getMapPosition();
	}
}

class Bullet0 extends Bullet implements Runnable {
	final ImageIcon imgBullet = new ImageIcon("Image/Bullet/bullet0.png");
	final ImageIcon imgEffect = new ImageIcon("Image/Effect/effect0.png");
	private JLabel mapLabel;
	private Control_Manager control;
	final public static int DAMAGE = 1;
	final public static int BULLET_MILLISECOND = 100;
	final public static int EFFECT_MILLISECOND = 500;
	
	public Bullet0(Tower _tower, Point towerRealPos, JLabel map_label) {
		super(_tower, DAMAGE, towerRealPos);
		bullet = new JLabel(imgBullet);
		effect = new JLabel(imgEffect);
		mapLabel = map_label;
		control = Control_Manager.getInstance(null);
	}
	
	public void run() {
		mapLabel.add(bullet);
		bullet.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
		// 공격지점 좌표를 설정하고 속도를설정
		attackPos = tower.getAttackPosition();
		
		
		setAttackPosition();
		// BULLET_SPEED만큼 이동하고 소멸
		for(int i=0; i<BULLET_SPEED; i++) {
			move();
			bullet.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
			try {
				Thread.sleep(BULLET_MILLISECOND);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 이펙트로 이미지 전환
		mapLabel.remove(bullet);
		mapLabel.add(effect);
		effect.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
		
		ArrayList<Monster> monster = control.getMonsterList();
		for(int i=0; i<monster.size(); i++) {
			Point temp = monster.get(i).getMapPosition();
			if(temp.getX() == mapPos.getX() && temp.getY() == mapPos.getY()) {
				monster.get(i).attacked(damage);
			}
		}
		
		try {
			Thread.sleep(EFFECT_MILLISECOND);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mapLabel.remove(effect);
	}
}


class Bullet1 extends Bullet implements Runnable {
	final ImageIcon imgBullet = new ImageIcon("Image/Bullet/bullet1.png");
	final ImageIcon imgEffect = new ImageIcon("Image/Effect/effect1.png");
	private JLabel mapLabel;
	private Control_Manager control;
	final public static int DAMAGE = 3;
	final public static int BULLET_MILLISECOND = 100;
	final public static int EFFECT_MILLISECOND = 500;
	
	public Bullet1(Tower _tower, Point towerRealPos, JLabel map_label) {
		super(_tower, DAMAGE, towerRealPos);
		bullet = new JLabel(imgBullet);
		effect = new JLabel(imgEffect);
		mapLabel = map_label;
		control = Control_Manager.getInstance(null);
	}
	
	public void run() {
		mapLabel.add(bullet);
		bullet.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
		// 공격지점 좌표를 설정하고 속도를설정
		attackPos = tower.getAttackPosition();
		
		
		setAttackPosition();
		// BULLET_SPEED만큼 이동하고 소멸
		for(int i=0; i<BULLET_SPEED; i++) {
			move();
			bullet.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
			try {
				Thread.sleep(BULLET_MILLISECOND);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 이펙트로 이미지 전환
		mapLabel.remove(bullet);
		mapLabel.add(effect);
		effect.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
		
		ArrayList<Monster> monster = control.getMonsterList();
		for(int i=0; i<monster.size(); i++) {
			Point temp = monster.get(i).getMapPosition();
			if(temp.getX() == mapPos.getX() && temp.getY() == mapPos.getY()) {
				monster.get(i).attacked(damage);
			}
		}
		
		try {
			Thread.sleep(EFFECT_MILLISECOND);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mapLabel.remove(effect);
	}
}

class Bullet2 extends Bullet implements Runnable {
	final ImageIcon imgBullet = new ImageIcon("Image/Bullet/bullet2.png");
	final ImageIcon imgEffect = new ImageIcon("Image/Effect/effect2.png");
	private JLabel mapLabel;
	private Control_Manager control;
	final public static int DAMAGE = 5;
	final public static int BULLET_MILLISECOND = 100;
	final public static int EFFECT_MILLISECOND = 500;
	
	public Bullet2(Tower _tower, Point towerRealPos, JLabel map_label) {
		super(_tower, DAMAGE, towerRealPos);
		bullet = new JLabel(imgBullet);
		effect = new JLabel(imgEffect);
		mapLabel = map_label;
		control = Control_Manager.getInstance(null);
	}
	
	public void run() {
		mapLabel.add(bullet);
		bullet.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
		// 공격지점 좌표를 설정하고 속도를설정
		attackPos = tower.getAttackPosition();
		
		
		setAttackPosition();
		// BULLET_SPEED만큼 이동하고 소멸
		for(int i=0; i<BULLET_SPEED; i++) {
			move();
			bullet.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
			try {
				Thread.sleep(BULLET_MILLISECOND);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 이펙트로 이미지 전환
		mapLabel.remove(bullet);
		mapLabel.add(effect);
		effect.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
		
		ArrayList<Monster> monster = control.getMonsterList();
		for(int i=0; i<monster.size(); i++) {
			Point temp = monster.get(i).getMapPosition();
			if(temp.getX() == mapPos.getX() && temp.getY() == mapPos.getY()) {
				monster.get(i).attacked(damage);
			}
		}
		
		try {
			Thread.sleep(EFFECT_MILLISECOND);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mapLabel.remove(effect);
	}
}

class Bullet3 extends Bullet implements Runnable {
	final ImageIcon imgBullet = new ImageIcon("Image/Bullet/bullet3.png");
	final ImageIcon imgEffect = new ImageIcon("Image/Effect/effect3.png");
	private JLabel mapLabel;
	private Control_Manager control;
	final public static int DAMAGE = 10;
	final public static int BULLET_MILLISECOND = 100;
	final public static int EFFECT_MILLISECOND = 500;
	
	public Bullet3(Tower _tower, Point towerRealPos, JLabel map_label) {
		super(_tower, DAMAGE, towerRealPos);
		bullet = new JLabel(imgBullet);
		effect = new JLabel(imgEffect);
		mapLabel = map_label;
		control = Control_Manager.getInstance(null);
	}
	
	public void run() {
		mapLabel.add(bullet);
		bullet.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
		// 공격지점 좌표를 설정하고 속도를설정
		attackPos = tower.getAttackPosition();
		
		
		setAttackPosition();
		// BULLET_SPEED만큼 이동하고 소멸
		for(int i=0; i<BULLET_SPEED; i++) {
			move();
			bullet.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
			try {
				Thread.sleep(BULLET_MILLISECOND);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 이펙트로 이미지 전환
		mapLabel.remove(bullet);
		mapLabel.add(effect);
		effect.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
		
		ArrayList<Monster> monster = control.getMonsterList();
		for(int i=0; i<monster.size(); i++) {
			Point temp = monster.get(i).getMapPosition();
			if(temp.getX() == mapPos.getX() && temp.getY() == mapPos.getY()) {
				monster.get(i).attacked(damage);
			}
		}
		
		try {
			Thread.sleep(EFFECT_MILLISECOND);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mapLabel.remove(effect);
	}
}

class Bullet4 extends Bullet implements Runnable {
	final ImageIcon imgBullet = new ImageIcon("Image/Bullet/bullet4.png");
	final ImageIcon imgEffect = new ImageIcon("Image/Effect/effect4.png");
	private JLabel mapLabel;
	private Control_Manager control;
	final public static int DAMAGE = 15;
	final public static int BULLET_MILLISECOND = 100;
	final public static int EFFECT_MILLISECOND = 500;
	
	public Bullet4(Tower _tower, Point towerRealPos, JLabel map_label) {
		super(_tower, DAMAGE, towerRealPos);
		bullet = new JLabel(imgBullet);
		effect = new JLabel(imgEffect);
		mapLabel = map_label;
		control = Control_Manager.getInstance(null);
	}
	
	public void run() {
		mapLabel.add(bullet);
		bullet.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
		// 공격지점 좌표를 설정하고 속도를설정
		attackPos = tower.getAttackPosition();
		
		
		setAttackPosition();
		// BULLET_SPEED만큼 이동하고 소멸
		for(int i=0; i<BULLET_SPEED; i++) {
			move();
			bullet.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
			try {
				Thread.sleep(BULLET_MILLISECOND);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 이펙트로 이미지 전환
		mapLabel.remove(bullet);
		mapLabel.add(effect);
		effect.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
		
		ArrayList<Monster> monster = control.getMonsterList();
		for(int i=0; i<monster.size(); i++) {
			Point temp = monster.get(i).getMapPosition();
			if(temp.getX() == mapPos.getX() && temp.getY() == mapPos.getY()) {
				monster.get(i).attacked(damage);
			}
		}
		
		try {
			Thread.sleep(EFFECT_MILLISECOND);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mapLabel.remove(effect);
	}
}

class Bullet5 extends Bullet implements Runnable {
	final ImageIcon imgBullet = new ImageIcon("Image/Bullet/bullet5.png");
	final ImageIcon imgEffect = new ImageIcon("Image/Effect/effect5.png");
	private JLabel mapLabel;
	private Control_Manager control;
	final public static int DAMAGE = 20;
	final public static int BULLET_MILLISECOND = 100;
	final public static int EFFECT_MILLISECOND = 500;
	
	public Bullet5(Tower _tower, Point towerRealPos, JLabel map_label) {
		super(_tower, DAMAGE, towerRealPos);
		bullet = new JLabel(imgBullet);
		effect = new JLabel(imgEffect);
		mapLabel = map_label;
		control = Control_Manager.getInstance(null);
	}
	
	public void run() {
		mapLabel.add(bullet);
		bullet.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
		// 공격지점 좌표를 설정하고 속도를설정
		attackPos = tower.getAttackPosition();
		
		
		setAttackPosition();
		// BULLET_SPEED만큼 이동하고 소멸
		for(int i=0; i<BULLET_SPEED; i++) {
			move();
			bullet.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
			try {
				Thread.sleep(BULLET_MILLISECOND);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 이펙트로 이미지 전환
		mapLabel.remove(bullet);
		mapLabel.add(effect);
		effect.setBounds(realPos.getX(), realPos.getY(), Point.WIDTH, Point.HEIGHT);
		
		ArrayList<Monster> monster = control.getMonsterList();
		for(int i=0; i<monster.size(); i++) {
			Point temp = monster.get(i).getMapPosition();
			if(temp.getX() == mapPos.getX() && temp.getY() == mapPos.getY()) {
				monster.get(i).attacked(damage);
			}
		}
		
		try {
			Thread.sleep(EFFECT_MILLISECOND);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mapLabel.remove(effect);
	}
}

