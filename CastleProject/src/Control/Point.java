package Control;

// 2017-12-23 ������ ���� ����
// ��ǥ���� ������ ���� Ŭ����
public class Point {
	private int x, y;
	// 640 x 640�� 80 x 80���� �� 64���� ������.
	final public static int WIDTH = 80, HEIGHT = 80;
	// �� ���� ����
	final public static int SIZE = 8;
	
	// ��������
	final public static int TERM = 10;
	
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
//		if(x > 640 || x < 0 || y > 640 || y < 0)		// (x, y)�� ������ ������ ����ٸ�
//			return null;
		
		int temp_y = x/WIDTH;
		int temp_x = y/HEIGHT;
		
		return new Point(temp_x, temp_y);
	}
	
	
	public static boolean getEnterPerfectly(Point center, Point map_pos) {
		Point temp = new Point(map_pos.getX(), map_pos.getY());
		temp.setX(map_pos.getX()*WIDTH);
		temp.setY(map_pos.getY()*HEIGHT);
		
		// center��ǥ�� map�� �� ��ġ�� �������� �̳��� ���ٸ� true�� ��ȯ, else false
		if(temp.getX() - TERM < center.getX() && temp.getX() + TERM > center.getX()) {
			if(temp.getY() - TERM < center.getY() && temp.getY() + TERM > center.getY())
				return true;
		}
		
		return false;
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
