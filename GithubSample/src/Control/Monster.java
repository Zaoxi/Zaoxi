package Control;



class Monster {
	private int hp; 		// 몬스터의 체력
	private int speed;		// 몬스터의 속도
	private Point pos;		// map_array 배열 상에서 몬스터의 위치
	private Point real_pos;	// map_label 상에서 몬스터의 실제 좌표(x, y)
	private Point center;	// map_label상에서 몬스터의 center 좌표(x, y)
	private int move_count;	// 몬스터의 이미지 전환 주기 카운트
	final int DOWN = 0, UP = 1, RIGHT = 2, LEFT = 3;	// 방향 플래그
	final int CHANGE = 3;				// 몬스터의 이미지의 전환 주기
	
	public Monster() {
		
	}
}
