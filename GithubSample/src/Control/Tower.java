package Control;
import javax.swing.*;



public class Tower {
	// 타워의 이미지 레이블
	protected JLabel tower;
	// 타워의 실제 좌표
	protected Point realPos;
	// 타워의 맵행렬 상의 좌표
	protected Point pos;
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
	// 발사 속도
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
