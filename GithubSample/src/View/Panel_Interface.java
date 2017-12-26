package View;

import java.io.*;

class PanelIndex {
	// Grid Layout을 이용하여 Panel 배열  중 적절한 패널의 인덱스 상수
	static int MAIN_MENU = 0;
	static int SINGLE_PLAY = 1;
	static int MULTI_PLAY = 2;
	
	static int NUM_PANEL = 3;
}

interface _Panel_ {
	// 3개의 패널 중 이 패널을 setVisible(true)로 설정하고 다른 패널을 false하는 함수
	boolean setPanelIndex();
	// 이 패널이 setVisible(true)로 설정되어 있는지 반환
	boolean getPanelIndex();
}


interface _Main_Panel_ {
	// 이미지 파일 경로 상수 File객체
	File BUTTON_IMG = new File("/Image/Label/button.png");
	File PRESSED_BUTTON_IMG = new File("/Image/Label/pressed_button.png");
	File MAIN_BACKGROUND_IMG = new File("/Image/Label/main_background.png");
}

interface _Single_Panel_ {
	// 이미지 파일 경로 상수 File객체
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

