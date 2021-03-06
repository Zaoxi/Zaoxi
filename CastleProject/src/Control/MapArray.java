package Control;
import java.util.ArrayList;
import javax.swing.*;

// 영역을 표현하는 클래스
class Area {
	// 타워가 존재하는지 표시
	private boolean istower = false;
	// 공격지점으로 설정되어 있는지 표시
	private boolean isattack = false;
	// road(길)인지 아닌지 표시
	private boolean isroad = false;
	// start 지점과 end 지점 표시
	private boolean isstart = false;
	private boolean isend = false;
	// 몬스터의 방향전환 플래그를 표시
	private int direction = -1;
	
	// 타워설정 값
	final public static int TOWER0 = 0;
	final public static int TOWER1 = 1;
	final public static int TOWER2 = 2;
	final public static int TOWER3 = 3;
	final public static int TOWER4 = 4;
	final public static int TOWER5 = 5;
	
	public Area() {

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
	
	// 타워의 존재를 설정하는 함수
	public void setTower(boolean exist) {
		istower = exist;
	}
	// 길로 설정하는 함수
	public void setRoad(boolean exist) {
		isroad = exist;
	}
	// start 지점으로 설정하는 함수
	public void setStart(boolean exist) {
		isstart = exist;
	}
	// end 지점으로 설정
	public void setEnd(boolean exist) {
		isend = exist;
	}
	
	// 몬스터의 경로를 설정하는 함수, Monster 클래스의 static 변수를 이용
	public void setDirection(int _direction) {
		direction = _direction;
	}
}

//2차원의 맵 8 x 8를 정수형 2차원 배열로 표현 
class Map {
	protected Area[][] map;
	final public static int MAP_NUM = 10;
	final public static int SIZE = 8;
	final public static int MAP_WIDTH = 640, MAP_HEIGHT = 640;
	final public static int IMG_WIDTH = MAP_WIDTH/SIZE, IMG_HEIGHT = MAP_HEIGHT/SIZE;
	
	final public static ImageIcon ROAD = new ImageIcon("Image/Map/road.png");
	protected JLabel mapLabel;
	
	// start, end지점을 저장하는 Point 객체
	protected Point start = null;
	protected Point end = null;
	
	public Map(JLabel map_label) {
		mapLabel = map_label;
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
	// start 위치를 반환하는 함수
	public Point getStartPosition() {
		return start;
	}
	// end 지점을 반환하는 함수
	public boolean getEndPosition(Point mapPos) {
		if(end.getX() == mapPos.getX() && end.getY() == mapPos.getY())
			return true;
		return false;
	}
	
	// 배열 위치를 지정하면 길 이미지를 삽입해주는 함수
	public void setRoadImg(int x, int y) {
		JLabel roadLabel = new JLabel(ROAD);
		roadLabel.setBounds(x*IMG_WIDTH, y*IMG_HEIGHT, IMG_WIDTH, IMG_HEIGHT);
		mapLabel.add(roadLabel);
	}
}

// 멀티플레이 맵
class MapMulti extends Map {
	final private int START_NUM = 4;
	final private int END_NUM = 4;
	
	private Point[] startMulti = new Point[START_NUM]; 
	private Point[] endMulti = new Point[END_NUM];
	
	public MapMulti(JLabel map_label) {
		super(map_label);
		
		map[1][0].setStart(true);
		map[3][0].setStart(true);
		map[4][0].setStart(true);
		map[6][0].setStart(true);
		startMulti[0] = new Point(1, 0);
		startMulti[1] = new Point(3, 0);
		startMulti[2] = new Point(4, 0);
		startMulti[3] = new Point(6, 0);
		
		map[1][7].setEnd(true);
		map[3][7].setEnd(true);
		map[4][7].setEnd(true);
		map[6][7].setEnd(true);
		endMulti[0] = new Point(1, 7);
		endMulti[1] = new Point(3, 7);
		endMulti[2] = new Point(4, 7);
		endMulti[3] = new Point(6, 7);
		
		// 맵 설정
		for(int i=0; i<SIZE; i++) {
			map[1][i].setRoad(true);
			map[1][i].setDirection(Monster.RIGHT);
			map[3][i].setRoad(true);
			map[3][i].setDirection(Monster.RIGHT);
			map[4][i].setRoad(true);
			map[4][i].setDirection(Monster.RIGHT);
			map[6][i].setRoad(true);
			map[6][i].setDirection(Monster.RIGHT);
		}
		
	}
	
	public Point getFirstStart() {
		return startMulti[0];
	}
	public Point getSecondStart() {
		return startMulti[1];
	}
	public Point getThirdStart() {
		return startMulti[2];
	}
	public Point getFourthStart() {
		return startMulti[3];
	}
	
	@Override
	public boolean getEndPosition(Point mapPos) {
		for(int i=0; i<END_NUM; i++) {
			if(endMulti[i].getX() == mapPos.getX() && endMulti[i].getY() == mapPos.getY())
				return true;
		}
		return false;
	}
}

// 싱글 플레이 맵
class MapArray1 extends Map {
	public MapArray1(JLabel map_label) {
		super(map_label);
		
		// 1단계 맵 설정
		// 시작 지점 설정
		map[0][0].setStart(true);
		start = new Point(0, 0);
		map[0][1].setEnd(true);
		end = new Point(0, 1);
		
		// 길 이미지 삽입, 길 표시
		for(int i=0; i<SIZE; i++) {
			if(i==0 || i == SIZE-1) {
				for(int j=0; j<SIZE; j++) {
					map[i][j].setRoad(true);
					//setRoadImg(i, j);
				}
			}
			else {
				map[i][0].setRoad(true);
				//setRoadImg(i, 0);
				map[i][SIZE-1].setRoad(true);
				//setRoadImg(i, SIZE-1);
			}
		}
		
		// 몬스터 경로 설정
		for(int i=0; i<SIZE; i++) {
			map[i][0].setDirection(Monster.DOWN);
			map[i][SIZE-1].setDirection(Monster.UP);
		}
		for(int i=1; i<SIZE; i++) {
			map[0][i].setDirection(Monster.LEFT);
			map[SIZE-1][SIZE-1-i].setDirection(Monster.RIGHT);
		}
	}
}

class MapArray2 extends Map {
	public MapArray2(JLabel map_label) {
		super(map_label);
		
		// 2단계 맵 설정
		// 시작 지점 설정
		// 시작 지점 설정
		map[0][0].setStart(true);
		start.setX(0);
		start.setY(0);
		map[0][1].setEnd(true);
		end.setX(0);
		end.setY(1);
				
		// 길 이미지 삽입, 길 표시
		for(int i=0; i<SIZE; i++) {
			if(i==0 || i == SIZE-1) {
				for(int j=0; j<SIZE; j++) {
					map[i][j].setRoad(true);
					setRoadImg(i, j);
				}
			}
			else {
				map[i][0].setRoad(true);
				setRoadImg(i, 0);
				map[i][SIZE-1].setRoad(true);
				setRoadImg(i, SIZE-1);
			}
		}
	
		// 몬스터 경로 설정
		map[0][0].setDirection(Monster.DOWN);
		map[SIZE-1][0].setDirection(Monster.RIGHT);
		map[SIZE-1][SIZE-1].setDirection(Monster.UP);
		map[0][SIZE-1].setDirection(Monster.LEFT);
	}
}

class MapArray3 extends Map {
	public MapArray3(JLabel map_label) {
		super(map_label);
		
		// 3단계 맵 설정
		// 시작 지점 설정
		map[0][0].setStart(true);
		start.setX(0);
		start.setY(0);
		map[0][1].setEnd(true);
		end.setX(0);
		end.setY(1);
				
		// 길 이미지 삽입, 길 표시
		for(int i=0; i<SIZE; i++) {
			if(i==0 || i == SIZE-1) {
				for(int j=0; j<SIZE; j++) {
					map[i][j].setRoad(true);
					setRoadImg(i, j);
				}
			}
			else {
				map[i][0].setRoad(true);
				setRoadImg(i, 0);
				map[i][SIZE-1].setRoad(true);
				setRoadImg(i, SIZE-1);
			}
		}
		
		// 몬스터 경로 설정
		map[0][0].setDirection(Monster.DOWN);
		map[SIZE-1][0].setDirection(Monster.RIGHT);
		map[SIZE-1][SIZE-1].setDirection(Monster.UP);
		map[0][SIZE-1].setDirection(Monster.LEFT);
	}
}

class MapArray4 extends Map {
	public MapArray4(JLabel map_label) {
		super(map_label);
		
		// 4단계 맵 설정
		// 시작 지점 설정
		map[0][0].setStart(true);
		start.setX(0);
		start.setY(0);
		map[0][1].setEnd(true);
		end.setX(0);
		end.setY(1);
				
		// 길 이미지 삽입, 길 표시
		for(int i=0; i<SIZE; i++) {
			if(i==0 || i == SIZE-1) {
				for(int j=0; j<SIZE; j++) {
					map[i][j].setRoad(true);
					setRoadImg(i, j);
				}
			}
			else {
				map[i][0].setRoad(true);
				setRoadImg(i, 0);
				map[i][SIZE-1].setRoad(true);
				setRoadImg(i, SIZE-1);
			}
		}
		
		// 몬스터 경로 설정
		map[0][0].setDirection(Monster.DOWN);
		map[SIZE-1][0].setDirection(Monster.RIGHT);
		map[SIZE-1][SIZE-1].setDirection(Monster.UP);
		map[0][SIZE-1].setDirection(Monster.LEFT);
	}
}

class MapArray5 extends Map {
	public MapArray5(JLabel map_label) {
		super(map_label);
		
		// 5단계 맵 설정
		// 시작 지점 설정
		map[0][0].setStart(true);
		start.setX(0);
		start.setY(0);
		map[0][1].setEnd(true);
		end.setX(0);
		end.setY(1);
				
		// 길 이미지 삽입, 길 표시
		for(int i=0; i<SIZE; i++) {
			if(i==0 || i == SIZE-1) {
				for(int j=0; j<SIZE; j++) {
					map[i][j].setRoad(true);
					setRoadImg(i, j);
				}
			}
			else {
				map[i][0].setRoad(true);
				setRoadImg(i, 0);
				map[i][SIZE-1].setRoad(true);
				setRoadImg(i, SIZE-1);
			}
		}
		
		// 몬스터 경로 설정
		map[0][0].setDirection(Monster.DOWN);
		map[SIZE-1][0].setDirection(Monster.RIGHT);
		map[SIZE-1][SIZE-1].setDirection(Monster.UP);
		map[0][SIZE-1].setDirection(Monster.LEFT);
	}
}

class MapArray6 extends Map {
	public MapArray6(JLabel map_label) {
		super(map_label);
		
		// 6단계 맵 설정
		// 시작 지점 설정
		map[0][0].setStart(true);
		start.setX(0);
		start.setY(0);
		map[0][1].setEnd(true);
		end.setX(0);
		end.setY(1);
		
		// 길 이미지 삽입, 길 표시
		for(int i=0; i<SIZE; i++) {
			if(i==0 || i == SIZE-1) {
				for(int j=0; j<SIZE; j++) {
					map[i][j].setRoad(true);
					setRoadImg(i, j);
				}
			}
			else {
				map[i][0].setRoad(true);
				setRoadImg(i, 0);
				map[i][SIZE-1].setRoad(true);
				setRoadImg(i, SIZE-1);
			}
		}
		
		// 몬스터 경로 설정
		map[0][0].setDirection(Monster.DOWN);
		map[SIZE-1][0].setDirection(Monster.RIGHT);
		map[SIZE-1][SIZE-1].setDirection(Monster.UP);
		map[0][SIZE-1].setDirection(Monster.LEFT);
	}
}

class MapArray7 extends Map {
	public MapArray7(JLabel map_label) {
		super(map_label);
		
		// 7단계 맵 설정
		// 시작 지점 설정
		map[0][0].setStart(true);
		start.setX(0);
		start.setY(0);
		map[0][1].setEnd(true);
		end.setX(0);
		end.setY(1);
				
		// 길 이미지 삽입, 길 표시
		for(int i=0; i<SIZE; i++) {
			if(i==0 || i == SIZE-1) {
				for(int j=0; j<SIZE; j++) {
					map[i][j].setRoad(true);
					setRoadImg(i, j);
				}
			}
			else {
				map[i][0].setRoad(true);
				setRoadImg(i, 0);
				map[i][SIZE-1].setRoad(true);
				setRoadImg(i, SIZE-1);
			}
		}
		
		// 몬스터 경로 설정
		map[0][0].setDirection(Monster.DOWN);
		map[SIZE-1][0].setDirection(Monster.RIGHT);
		map[SIZE-1][SIZE-1].setDirection(Monster.UP);
		map[0][SIZE-1].setDirection(Monster.LEFT);
	}
}

class MapArray8 extends Map {
	public MapArray8(JLabel map_label) {
		super(map_label);
		
		// 8단계 맵 설정
		// 시작 지점 설정
		map[0][0].setStart(true);
		start.setX(0);
		start.setY(0);
		map[0][1].setEnd(true);
		end.setX(0);
		end.setY(1);
		
		// 길 이미지 삽입, 길 표시
		for(int i=0; i<SIZE; i++) {
			if(i==0 || i == SIZE-1) {
				for(int j=0; j<SIZE; j++) {
					map[i][j].setRoad(true);
					setRoadImg(i, j);
				}
			}
			else {
				map[i][0].setRoad(true);
				setRoadImg(i, 0);
				map[i][SIZE-1].setRoad(true);
				setRoadImg(i, SIZE-1);
			}
		}
		
		// 몬스터 경로 설정
		map[0][0].setDirection(Monster.DOWN);
		map[SIZE-1][0].setDirection(Monster.RIGHT);
		map[SIZE-1][SIZE-1].setDirection(Monster.UP);
		map[0][SIZE-1].setDirection(Monster.LEFT);
	}
}

class MapArray9 extends Map {
	public MapArray9(JLabel map_label) {
		super(map_label);
		
		// 9단계 맵 설정
		// 시작 지점 설정
		map[0][0].setStart(true);
		start.setX(0);
		start.setY(0);
		map[0][1].setEnd(true);
		end.setX(0);
		end.setY(1);
		
		// 길 이미지 삽입, 길 표시
		for(int i=0; i<SIZE; i++) {
			if(i==0 || i == SIZE-1) {
				for(int j=0; j<SIZE; j++) {
					map[i][j].setRoad(true);
					setRoadImg(i, j);
				}
			}
			else {
				map[i][0].setRoad(true);
				setRoadImg(i, 0);
				map[i][SIZE-1].setRoad(true);
				setRoadImg(i, SIZE-1);
			}
		}
		
		// 몬스터 경로 설정
		map[0][0].setDirection(Monster.DOWN);
		map[SIZE-1][0].setDirection(Monster.RIGHT);
		map[SIZE-1][SIZE-1].setDirection(Monster.UP);
		map[0][SIZE-1].setDirection(Monster.LEFT);
	}
}

class MapArray10 extends Map {
	public MapArray10(JLabel map_label) {
		super(map_label);
		
		// 10단계 맵 설정
		// 시작 지점 설정
		map[0][0].setStart(true);
		start.setX(0);
		start.setY(0);
		map[0][1].setEnd(true);
		end.setX(0);
		end.setY(1);
		
		// 길 이미지 삽입, 길 표시
		for(int i=0; i<SIZE; i++) {
			if(i==0 || i == SIZE-1) {
				for(int j=0; j<SIZE; j++) {
					map[i][j].setRoad(true);
					setRoadImg(i, j);
				}
			}
			else {
				map[i][0].setRoad(true);
				setRoadImg(i, 0);
				map[i][SIZE-1].setRoad(true);
				setRoadImg(i, SIZE-1);
			}
		}
		
		// 몬스터 경로 설정
		map[0][0].setDirection(Monster.DOWN);
		map[SIZE-1][0].setDirection(Monster.RIGHT);
		map[SIZE-1][SIZE-1].setDirection(Monster.UP);
		map[0][SIZE-1].setDirection(Monster.LEFT);
	}
}