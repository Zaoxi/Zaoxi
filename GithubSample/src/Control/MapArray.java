package Control;
import java.util.ArrayList;
import javax.swing.*;

// ������ ǥ���ϴ� Ŭ����
class Area {
	// Ÿ���� �����ϴ��� ǥ��
	private boolean istower = false;
	// ������������ �����Ǿ� �ִ��� ǥ��
	private boolean isattack = false;
	// road(��)���� �ƴ��� ǥ��
	private boolean isroad = false;
	// start ������ end ���� ǥ��
	private boolean isstart = false;
	private boolean isend = false;
	// ������ ��θ� ǥ��
	private int direction = -1;
	
	// ������������ �����Ǿ� �ִٸ� ��� Ÿ���� ���������� ǥ��
	private ArrayList<Integer> attacking;
	
	// Ÿ���� �� ��
	final public static int NUM_TOWER = 6;
	
	// Ÿ������ ��
	final public static int TOWER0 = 0;
	final public static int TOWER1 = 1;
	final public static int TOWER2 = 2;
	final public static int TOWER3 = 3;
	final public static int TOWER4 = 4;
	final public static int TOWER5 = 5;
	
	public Area() {
		attacking = new ArrayList<Integer>(NUM_TOWER);
		
		for(int i=0; i<NUM_TOWER; i++)
			attacking.add(0);
	}
	
	public boolean isTower() {
		return istower;
	}
	public boolean isAttack() {
		return isattack;
	}
	public boolean isRoad() {
		return isroad;
	}
	public boolean isStart() {
		return isstart;
	}
	public boolean isEnd() {
		return isend;
	}
	public int getDirection() {
		return direction;
	}
	
	// ������������ �����Ǿ� �ִٸ�, ��� �Ÿ������ �����ϰ� �ִ��� ��ȯ�ϴ� �Լ�
	public ArrayList<Integer> getAttackingTower() {
		if(isattack)
			return attacking;
		return null;
	}
	// Ÿ���� ���縦 �����ϴ� �Լ�
	public void setTower(boolean exist) {
		istower = exist;
	}
	// ��� �����ϴ� �Լ�
	public void setRoad(boolean exist) {
		isroad = exist;
	}
	// start �������� �����ϴ� �Լ�
	public void setStart(boolean exist) {
		isstart = exist;
	}
	public void setEnd(boolean exist) {
		isend = exist;
	}
	
	// ������ ��θ� �����ϴ� �Լ�, Monster Ŭ������ static ������ �̿�
	public void setDirection(int _direction) {
		direction = _direction;
	}
	
	// ������������ �����ϴ� �Լ�, �з����� �� attack = true �������� ����, attack = false �������� ����
	public void setAttack(int tower, boolean attack) {
		if(tower < 0 || tower >= NUM_TOWER)
			return;
		
		// ������������ ������ ��� attack = true
		if(attack) {
			isattack = attack;
			attacking.set(tower, attacking.get(tower)+1);
		}
		else {	// ���������� ������ ��� attack = false
			int num = attacking.get(tower);
			if(num <= 0) {
				isattack = attack;
				return;
			}
			
			attacking.set(tower, num - 1);
			
			// ���� ������������ �������ִ� Ÿ���� �����ϴ��� �˻�
			for(int i=0; i<NUM_TOWER; i++) 
				if(attacking.get(i)!=0)
					return;
			
			isattack = false;
		}
	}
}

//2������ �� 8 x 8�� ������ 2���� �迭�� ǥ�� 
class Map {
	protected Area[][] map;
	
	final public static int SIZE = 8;
	final public static ImageIcon ROAD = new ImageIcon("Image/Map/road.png");
	
	
	public Map() {
		// ������ 2���� �迭 map�� �ʱ�ȭ �ϴ� �۾�
		map = new Area[SIZE][];
		for(int i=0; i<SIZE; i++) {
			map[i] = new Area[SIZE];
			for(int j=0; j<SIZE; j++) {
				map[i][j] = new Area();
			}
		}
	}
	public Area[][] getMap() {
		return map;
	}
}

class MapArray1 extends Map {
	public MapArray1() {
		super();
		
		// 1�ܰ� �� ����
		for(int i=0; i<SIZE; i++) {
			if(i==0 || i == SIZE-1) {
				for(int j=0; j<SIZE; j++) {
					map[i][j].setRoad(true);
				}
			}
			else {
				map[i][0].setRoad(true);
				map[i][SIZE-1].setRoad(true);
			}
		}
	}
}

class MapArray2 extends Map {
	public MapArray2() {
		super();
		
		// 2�ܰ� �� ����
		for(int i=0; i<SIZE; i++) {
			if(i==0 || i == SIZE-1) {
				for(int j=0; j<SIZE; j++) {
					map[i][j].setRoad(true);
					}
				}
			else {
				map[i][0].setRoad(true);
				map[i][SIZE-1].setRoad(true);
			}
		}
	}
}

class MapArray3 extends Map {
	public MapArray3() {
		super();
		
		// 3�ܰ� �� ����
		for(int i=0; i<SIZE; i++) {
			if(i==0 || i == SIZE-1) {
				for(int j=0; j<SIZE; j++) {
					map[i][j].setRoad(true);
					}
				}
			else {
				map[i][0].setRoad(true);
				map[i][SIZE-1].setRoad(true);
			}
		}
	}
}

class MapArray4 extends Map {
	public MapArray4() {
		super();
		
		// 4�ܰ� �� ����
		for(int i=0; i<SIZE; i++) {
			if(i==0 || i == SIZE-1) {
				for(int j=0; j<SIZE; j++) {
					map[i][j].setRoad(true);
					}
				}
			else {
				map[i][0].setRoad(true);
				map[i][SIZE-1].setRoad(true);
			}
		}
	}
}

class MapArray5 extends Map {
	public MapArray5() {
		super();
		
		// 5�ܰ� �� ����
		for(int i=0; i<SIZE; i++) {
			if(i==0 || i == SIZE-1) {
				for(int j=0; j<SIZE; j++) {
					map[i][j].setRoad(true);
					}
				}
			else {
				map[i][0].setRoad(true);
				map[i][SIZE-1].setRoad(true);
			}
		}
	}
}

class MapArray6 extends Map {
	public MapArray6() {
		super();
		
		// 6�ܰ� �� ����
		for(int i=0; i<SIZE; i++) {
			if(i==0 || i == SIZE-1) {
				for(int j=0; j<SIZE; j++) {
					map[i][j].setRoad(true);
					}
				}
			else {
				map[i][0].setRoad(true);
				map[i][SIZE-1].setRoad(true);
			}
		}
	}
}

class MapArray7 extends Map {
	public MapArray7() {
		super();
		
		// 7�ܰ� �� ����
		for(int i=0; i<SIZE; i++) {
			if(i==0 || i == SIZE-1) {
				for(int j=0; j<SIZE; j++) {
					map[i][j].setRoad(true);
					}
				}
			else {
				map[i][0].setRoad(true);
				map[i][SIZE-1].setRoad(true);
			}
		}
	}
}

class MapArray8 extends Map {
	public MapArray8() {
		super();
		
		// 8�ܰ� �� ����
		for(int i=0; i<SIZE; i++) {
			if(i==0 || i == SIZE-1) {
				for(int j=0; j<SIZE; j++) {
					map[i][j].setRoad(true);
					}
				}
			else {
				map[i][0].setRoad(true);
				map[i][SIZE-1].setRoad(true);
			}
		}
	}
}

class MapArray9 extends Map {
	public MapArray9() {
		super();
		
		// 9�ܰ� �� ����
		for(int i=0; i<SIZE; i++) {
			if(i==0 || i == SIZE-1) {
				for(int j=0; j<SIZE; j++) {
					map[i][j].setRoad(true);
					}
				}
			else {
				map[i][0].setRoad(true);
				map[i][SIZE-1].setRoad(true);
			}
		}
	}
}

class MapArray10 extends Map {
	public MapArray10() {
		super();
		
		// 10�ܰ� �� ����
		for(int i=0; i<SIZE; i++) {
			if(i==0 || i == SIZE-1) {
				for(int j=0; j<SIZE; j++) {
					map[i][j].setRoad(true);
					}
				}
			else {
				map[i][0].setRoad(true);
				map[i][SIZE-1].setRoad(true);
			}
		}
	}
}