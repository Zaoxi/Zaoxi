package Control;
import java.io.*;
import javax.swing.*;


abstract class Monster {
	protected int hp; 		// 몬스터의 체력
	protected int speed;		// 몬스터의 속도
	protected Point pos;		// map_array 배열 상에서 몬스터의 위치, center값을 기준으로 판단
	protected Point real_pos;	// map_label 상에서 몬스터의 실제 좌표(x, y)
	protected Point center;	// map_label상에서 몬스터의 center 좌표(x, y)
	protected int move_count;	// 몬스터의 이미지 전환 주기 카운트
	// 레이블과 이미지
	static public ImageIcon[][] imgDir = new ImageIcon[10][];
	protected JLabel monster;
	
	final static int DOWN = 0, UP = 1, RIGHT = 2, LEFT = 3;	// 방향 플래그
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
	
	public Monster(int hp, int speed, Point real) {
		real_pos = new Point(real.getX(), real.getY());
		this.hp = hp;
		this.speed = speed;
		
		// 좌표값 설정
		center = real_pos.getCenterPosition();
		pos = center.getMapPosition();			// center값을 기준으로 판단
		move_count = 0;
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
			
			if(move_count == CHANGE) {
				
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
