package View;

import java.io.*;

class PanelIndex {
	// Grid Layout�� �̿��Ͽ� Panel �迭  �� ������ �г��� �ε��� ���
	static int MAIN_MENU = 0;
	static int SINGLE_PLAY = 1;
	static int MULTI_PLAY = 2;
	
	static int NUM_PANEL = 3;
}

interface _Panel_ {
	// 3���� �г� �� �� �г��� setVisible(true)�� �����ϰ� �ٸ� �г��� false�ϴ� �Լ�
	boolean setPanelIndex();
	// �� �г��� setVisible(true)�� �����Ǿ� �ִ��� ��ȯ
	boolean getPanelIndex();
}


interface _Main_Panel_ {
	// �̹��� ���� ��� ��� File��ü
	File BUTTON_IMG = new File("/Image/Label/button.png");
	File PRESSED_BUTTON_IMG = new File("/Image/Label/pressed_button.png");
	File MAIN_BACKGROUND_IMG = new File("/Image/Label/main_background.png");
}

interface _Single_Panel_ {
	// �̹��� ���� ��� ��� File��ü
	File MAP_BACKGROUND_IMG = new File("/Image/Map/map_background.png");
	File MAP_ROAD_IMG = new File("/Image/Map/road.png");
	File TOWER_IMG0 = new File("/Image/Tower/tower0.png");
	File TOWER_IMG1 = new File("/Image/Tower/tower1.png");
	File TOWER_IMG2 = new File("/Image/Tower/tower2.png");
	File TOWER_IMG3 = new File("/Image/Tower/tower3.png");
	File TOWER_IMG4 = new File("/Image/Tower/tower4.png");
	File TOWER_IMG5 = new File("/Image/Tower/tower5.png");
	File MENUBAR = new File("/Image/Label/single_menubar.png");
}

interface _Multi_Panel_ {
	File MAP_BACKGROUND_IMG = new File("/Image/Map/map_background.png");
	File MAP_ROAD_IMG = new File("/Image/Map/road.png");
	File TOWER_IMG0 = new File("/Image/Tower/tower0.png");
	File TOWER_IMG1 = new File("/Image/Tower/tower1.png");
	File TOWER_IMG2 = new File("/Image/Tower/tower2.png");
	File TOWER_IMG3 = new File("/Image/Tower/tower3.png");
	File TOWER_IMG4 = new File("/Image/Tower/tower4.png");
	File TOWER_IMG5 = new File("/Image/Tower/tower5.png");
	File MENUBAR = new File("/Image/Label/single_menubar.png");
}

