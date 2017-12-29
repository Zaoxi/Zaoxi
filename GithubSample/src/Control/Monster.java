package Control;
import java.io.*;
import javax.swing.*;


abstract class Monster {
	protected int hp; 		// ������ ü��
	protected int speed;		// ������ �ӵ�
	protected Point pos;		// map_array �迭 �󿡼� ������ ��ġ, center���� �������� �Ǵ�
	protected Point real_pos;	// map_label �󿡼� ������ ���� ��ǥ(x, y)
	protected Point center;	// map_label�󿡼� ������ center ��ǥ(x, y)
	protected int move_count;	// ������ �̹��� ��ȯ �ֱ� ī��Ʈ
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
					imgDir[i][j*2+k] = new ImageIcon("Image/Monster/monster" + i + "_" + j + k + ".png");
				}
			}
		}
	}
	
	public Monster(int hp, int speed, Point real) {
		real_pos = new Point(real.getX(), real.getY());
		this.hp = hp;
		this.speed = speed;
		
		// ��ǥ�� ����
		center = real_pos.getCenterPosition();
		pos = center.getMapPosition();			// center���� �������� �Ǵ�
		move_count = 0;
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
			
			if(move_count == CHANGE) {
				
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
