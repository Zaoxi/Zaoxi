package Control;
import javax.swing.*;



public class Tower {
	// Ÿ���� �̹��� ���̺�
	protected JLabel tower;
	// Ÿ���� ���� ��ǥ
	protected Point realPos;
	// Ÿ���� ����� ���� ��ǥ
	protected Point pos;
	// Ÿ���� �������� ��ǥ(�� ��Ļ��� ��ǥ)
	protected Point attackPos;
	// �� ���
	protected Map map;
	// �� ���̺�
	protected JLabel mapLabel;
	// Ÿ���� ���� ���� �÷���
	protected boolean attackFlag;
	// Ÿ���� ���� ����
	final public static int RANGE = 1;
	
	public Tower(Point real, Map _map, JLabel map_label) {
		realPos = real;
		pos = realPos.getMapPosition();
		attackPos = null;
		attackFlag = false;
		map = _map;
		mapLabel = map_label;
	}
	
	public void setAttackPosition(Point attack) {
		attackPos = attack;
		attackFlag = true;
	}
	
	public Point getAttackPosition() {
		return attackPos;
	}
}

class Tower0 extends Tower implements Runnable {
	// �߻� �ӵ�
	final public static int FIRE_SPEED = 800;
	private Bullet0 bullet;
	private boolean towerFlag = true;
	
	public Tower0(Point real, Map _map, JLabel map_label, Control_Manager c) {
		super(real, _map, map_label);
		bullet = new Bullet0(this, realPos, map_label, c);
	}
	
	public void setTowerFalse() {
		towerFlag = false;
	}
	
	public void run() {
		while(towerFlag) {
			try {
				if(attackFlag) {
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
