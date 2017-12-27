package Control;
import java.util.ArrayList;

class Area {
	// 타워가 존재하는지 표시
	private boolean istower = false;
	// 공격지점으로 설정되어 있는지 표시
	private boolean isattack = false;
	// road(길)인지 아닌지 표시
	private boolean isroad = false;
	// 공격지점으로 설정되어 있다면 몇개의 타워가 공격중인지 표시
	private ArrayList<Integer> attacking;
	
	// 타워의 총 수
	final int NUM_TOWER = 6;
	
	// 타워설정 값
	final int TOWER0 = 0;
	final int TOWER1 = 1;
	final int TOWER2 = 2;
	final int TOWER3 = 3;
	final int TOWER4 = 4;
	final int TOWER5 = 5;
	
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
	
	// 공격지점으로 설정되어 있다면, 몇개의 어떤타워들이 공격하고 있는지 반환하는 함수
	public ArrayList<Integer> getAttackingTower() {
		if(isattack)
			return attacking;
		return null;
	}
	// 타워의 존재를 설정하는 함수
	public void setTower(boolean exist) {
		istower = exist;
	}
	// 길로 설정하는 함수
	public void setRoad(boolean exist) {
		isroad = exist;
	}
	// 공격지점으로 설정하는 함수, 패러미터 중 attack = true 공격지점 설정, attack = false 공격지점 해제
	public void setAttack(int tower, boolean attack) {
		if(tower < 0 || tower >= NUM_TOWER)
			return;
		
		// 공격지점으로 설정할 경우 attack = true
		if(attack) {
			isattack = attack;
			attacking.set(tower, attacking.get(tower)+1);
		}
		else {	// 공격지점을 해제할 경우 attack = false
			int num = attacking.get(tower);
			if(num <= 0)
				return;
			
			attacking.set(tower, num - 1);
			
			// 현재 공격지점으로 설정되있는 타워가 존재하는지 검사
			for(int i=0; i<NUM_TOWER; i++) 
				if(attacking.get(i)!=0)
					return;
			
			isattack = false;
		}
	}
}

//2차원의 맵 8 x 8를 정수형 2차원 배열로 표현 
class Map {
	protected Area[][] map;
	
	final int SIZE = 8;
	
	
	public Map() {
		// 정수형 2차원 배열 map을 초기화 하는 작업
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
		
		// 1단계 맵 설정
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
		
		// 2단계 맵 설정
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
		
		// 3단계 맵 설정
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
		
		// 4단계 맵 설정
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
		
		// 5단계 맵 설정
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
		
		// 6단계 맵 설정
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
		
		// 7단계 맵 설정
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
		
		// 8단계 맵 설정
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
		
		// 9단계 맵 설정
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
		
		// 10단계 맵 설정
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