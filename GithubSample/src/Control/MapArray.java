package Control;

//2������ �� 32 x 32�� ������ 2���� �迭�� ǥ�� 
public class MapArray {
	private static MapArray instance = null;
	private int[][] map;
	
	final int SIZE = 32;
	
	private MapArray() {
		instance = this;
		
		// ������ 2���� �迭 map�� �ʱ�ȭ �ϴ� �۾�
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