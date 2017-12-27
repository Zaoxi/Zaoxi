package Control;

public class Point {
	private int x, y;
	// 640 x 640을 80 x 80으로 총 64개로 나눈다.
	final int WIDTH = 80, HEIGHT = 80;
	// 한 변의 개수
	final int SIZE = 8;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// Map Label 상의 위치정보의 Center를 반환하는 함수
	public Point getCenterPosition() {
		return new Point(x + WIDTH/2, y + HEIGHT/2);
	}
	
	// Map Label 상의 위치정보를 이용하여 2차원 배열 map_array상에서 어디에 위치하는지 처리하는 함수, center좌표를 기준으로 계산해야된다.
	public Point getMapPosition() {
		if(x > 640 || x < 0 || y > 640 || y < 0)		// (x, y)가 지정된 범위를 벗어난다면
			return null;
		
		int temp_x = x/WIDTH;
		int temp_y = y/HEIGHT;
		
		return new Point(temp_x, temp_y);
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
}
