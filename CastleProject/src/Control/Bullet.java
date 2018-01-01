package Control;
import javax.swing.*;
import java.util.*;

public class Bullet {
	// źȯ�� ������
	protected int damage;
	// źȯ�� ���� ���� (�� ��Ļ��� ��ǥ)
	protected Point attackPos;
	// źȯ�� ���� ��ǥ
	protected Point realPos;
	// źȯ�� �߰� ��ǥ
	protected Point centerPos;
	// źȯ�� �� ��� ���� ��ǥ
	protected Point mapPos;
	// źȯ�� �̹��� ���̺�
	protected JLabel bullet;
	// źȯ�� ����Ʈ ���̺�
	protected JLabel effect;
	// �� ����� ��ź�� ��� �����ϰ� ���������� ���� �� ������ �����Ѵ�. ��, �������� ������.
	final public static int BULLET_SPEED = 5;
	// ���� ������ ���� ������ ���� / BULLET_SPEED
	protected Point term;
	// �� ��ź�� ������ Ÿ���� ��ü
	protected Tower tower;
	
	public Bullet(Tower _tower, int _damage, Point towerRealPos) {
		damage = _damage;
		realPos = new Point(towerRealPos.getX(), towerRealPos.getY());
		centerPos = realPos.getCenterPosition();
		mapPos = centerPos.getMapPosition();
		term = new Point(0, 0);
		tower = _tower;
	}
	// ���� �������� ���� ���ǵ带 �����Ѵ�.
	public void setAttackPosition() {
		int xTerm = attackPos.getY()*Point.WIDTH - realPos.getX();
		int yTerm = attackPos.getX()*Point.HEIGHT - realPos.getY();
		
		term.setX(xTerm/BULLET_SPEED);
		term.setY(yTerm/BULLET_SPEED);
	}
	
	// źȯ�� ������ �������� �����δ�.
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
		// �������� ��ǥ�� �����ϰ� �ӵ�������
		attackPos = tower.getAttackPosition();
		
		
		setAttackPosition();
		// BULLET_SPEED��ŭ �̵��ϰ� �Ҹ�
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
		// ����Ʈ�� �̹��� ��ȯ
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
		// �������� ��ǥ�� �����ϰ� �ӵ�������
		attackPos = tower.getAttackPosition();
		
		
		setAttackPosition();
		// BULLET_SPEED��ŭ �̵��ϰ� �Ҹ�
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
		// ����Ʈ�� �̹��� ��ȯ
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
		// �������� ��ǥ�� �����ϰ� �ӵ�������
		attackPos = tower.getAttackPosition();
		
		
		setAttackPosition();
		// BULLET_SPEED��ŭ �̵��ϰ� �Ҹ�
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
		// ����Ʈ�� �̹��� ��ȯ
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
		// �������� ��ǥ�� �����ϰ� �ӵ�������
		attackPos = tower.getAttackPosition();
		
		
		setAttackPosition();
		// BULLET_SPEED��ŭ �̵��ϰ� �Ҹ�
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
		// ����Ʈ�� �̹��� ��ȯ
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
		// �������� ��ǥ�� �����ϰ� �ӵ�������
		attackPos = tower.getAttackPosition();
		
		
		setAttackPosition();
		// BULLET_SPEED��ŭ �̵��ϰ� �Ҹ�
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
		// ����Ʈ�� �̹��� ��ȯ
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
		// �������� ��ǥ�� �����ϰ� �ӵ�������
		attackPos = tower.getAttackPosition();
		
		
		setAttackPosition();
		// BULLET_SPEED��ŭ �̵��ϰ� �Ҹ�
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
		// ����Ʈ�� �̹��� ��ȯ
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

