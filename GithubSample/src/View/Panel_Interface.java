package View;

import java.io.*;
import javax.swing.*;


interface Main_Panel_Interface {
	// 이미지 파일 경로 상수 File객체
	File BUTTON_IMG = new File("/Image/Label/button.png");
	File PRESSED_BUTTON_IMG = new File("/Image/Label/pressed_button.png");
	File MAIN_BACKGROUND_IMG = new File("/Image/Label/main_background.png");
	
	// Main Panel에 존재하는 레이블의 객체를 반환하는 함수
	JLabel getSingleLabel();
	JLabel getPressedSingleLabel();
	
	JLabel getMultiLabel();
	JLabel getPressedMultiLabel();
	
	JLabel getDifficultyLabel();
	JLabel getPressedDifficultyLabel();
	
	JLabel getExitLabel();
	JLabel getPressedExitLabel();
}

interface Single_Panel_Interface {
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
	
	// Single Panel 에 존재하는 점수 레이블과 자원 레이블을 반환하는 함수
	JLabel getScoreLabel();
	JLabel getMoneyLabel();
}

interface Multi_Panel_Interface {
	File MAP_BACKGROUND_IMG = new File("/Image/Map/map_background.png");
	File MAP_ROAD_IMG = new File("/Image/Map/road.png");
	File TOWER_IMG0 = new File("/Image/Tower/tower0.png");
	File TOWER_IMG1 = new File("/Image/Tower/tower1.png");
	File TOWER_IMG2 = new File("/Image/Tower/tower2.png");
	File TOWER_IMG3 = new File("/Image/Tower/tower3.png");
	File TOWER_IMG4 = new File("/Image/Tower/tower4.png");
	File TOWER_IMG5 = new File("/Image/Tower/tower5.png");
	File MENUBAR = new File("/Image/Label/single_menubar.png");
	
	// Multi Panel 에 존재하는 점수 레이블과 자원 레이블을 반환하는 함수
	JLabel getScoreLabel();
	JLabel getMoneyLabel();
}

