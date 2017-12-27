package Control;

public class Point {
	private int x, y;
	// 640 x 640�� 80 x 80���� �� 64���� ������.
	final int WIDTH = 80, HEIGHT = 80;
	// �� ���� ����
	final int SIZE = 8;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// Map Label ���� ��ġ������ Center�� ��ȯ�ϴ� �Լ�
	public Point getCenterPosition() {
		return new Point(x + WIDTH/2, y + HEIGHT/2);
	}
	
	// Map Label ���� ��ġ������ �̿��Ͽ� 2���� �迭 map_array�󿡼� ��� ��ġ�ϴ��� ó���ϴ� �Լ�, center��ǥ�� �������� ����ؾߵȴ�.
	public Point getMapPosition() {
		if(x > 640 || x < 0 || y > 640 || y < 0)		// (x, y)�� ������ ������ ����ٸ�
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
