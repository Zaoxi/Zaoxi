package Control;



class Monster {
	private int hp; 		// ������ ü��
	private int speed;		// ������ �ӵ�
	private Point pos;		// map_array �迭 �󿡼� ������ ��ġ
	private Point real_pos;	// map_label �󿡼� ������ ���� ��ǥ(x, y)
	private Point center;	// map_label�󿡼� ������ center ��ǥ(x, y)
	private int move_count;	// ������ �̹��� ��ȯ �ֱ� ī��Ʈ
	final int DOWN = 0, UP = 1, RIGHT = 2, LEFT = 3;	// ���� �÷���
	final int CHANGE = 3;				// ������ �̹����� ��ȯ �ֱ�
	
	public Monster() {
		
	}
}
