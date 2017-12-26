package Control;

//2차원의 맵 32 x 32를 정수형 2차원 배열로 표현 
public class MapArray {
	private static MapArray instance = null;
	private int[][] map;
	
	final int SIZE = 32;
	
	private MapArray() {
		instance = this;
		
		// 정수형 2차원 배열 map을 초기화 하는 작업
		map = new int[SIZE][];
		for(int i=0; i<SIZE; i++) {
			map[i] = new int[SIZE];
			for(int j=0; j<SIZE; j++) {
				map[i][j] = 0;
			}
		}
	}
	
	public static MapArray getInstance() {
		if(instance == null) {
			return new MapArray();
		}
		return instance;
	}
}