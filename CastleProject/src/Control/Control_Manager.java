package Control;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import View.UIManager;

public class Control_Manager {
	private static Control_Manager instance = null;
	
	private UIManager ui;
	// 맵을 저장하는 배열
	private Map map = null;
	// 몬스터를 저장하는 리스트
	private ArrayList<Monster> monsterList;
	// 타워를 저장하는 리스트
	private ArrayList<Tower> towerList;
	// 게임의 상태를 체크하는 스레드의 플래그
	private boolean stateFlag = true;

	// 게임의 상태 스레드 제어 플래그
	private int gameFlag = 0;
	
	// 점수
	private int score = 0;
	// 자원
	private int money = 0;
	
	// 게임의 상태를 구분하는 상수
	final public static int MAIN = 0;
	final public static int STAGE1 = 1;
	final public static int STAGE2 = 2;
	final public static int STAGE3 = 3;
	final public static int STAGE4 = 4;
	final public static int STAGE5 = 5;
	final public static int STAGE6 = 6;
	final public static int STAGE7 = 7;
	final public static int STAGE8 = 8;
	final public static int STAGE9 = 9;
	final public static int STAGE10 = 10;
	final public static int SINGLE_WIN = 11;
	final public static int SINGLE_LOSE = 12;
	final public static int MULTI = 13;
	final public static int MULTI_WIN = 14;
	final public static int MULTI_LOSE = 15;
	
	final public static int SUM_STAGE = 10;
	
	private Control_Manager(UIManager v) {
		ui = v;
	}
	
	public static Control_Manager getInstance(UIManager v) {
		if(instance != null) instance = new Control_Manager(v);
		return instance;
	}
	
	// 게임의 상태를 설정
	public void setGameFlag(int state) {
		gameFlag = state;
	}
	// 게임의 상태를 반환
	public int getGameFlag() {
		return gameFlag;
	}
	
	public ArrayList<Monster> getMonsterList() {
		return monsterList;
	}
	
	// 점수와 자원을 관리하는 함수
	public int getScore() {
		return score;
	}
	public int getMoney() {
		return money;
	}
	public void setScore(int _score) {
		score = _score;
	}
	public void setMoney(int _money) {
		money = _money;
	}
	
	
	
	// 게임의 상태를 지속적으로 체크하면서 게임 상태를 전환시키는 스레드
	class CheckGameState extends Thread {
		final public static int STAGE1_NUM_MONSTER = 10;
		final public static int STAGE2_NUM_MONSTER = 20;
		final public static int STAGE3_NUM_MONSTER = 30;
		final public static int STAGE4_NUM_MONSTER = 40;
		final public static int STAGE5_NUM_MONSTER = 50;
		final public static int STAGE6_NUM_MONSTER = 60;
		final public static int STAGE7_NUM_MONSTER = 70;
		final public static int STAGE8_NUM_MONSTER = 80;
		final public static int STAGE9_NUM_MONSTER = 90;
		final public static int STAGE10_NUM_MONSTER = 100;
		
		public void run() {
			while(stateFlag) {
				// Stage1
				while(gameFlag == STAGE1 && stateFlag) {
					setMoney(500); setScore(0);
					
					Stage1_Monster stage1 = new Stage1_Monster();
					stage1.start();
					
					
				}
				if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
					// 게임 끝
					ui.getSinglePanel().getMapLabel().removeAll();
					for(int i=0; i<monsterList.size(); i++) {
						monsterList.get(i).setMonsterFalse();
					}
					setGameFlag(STAGE2);
				}
				// Stage2
				while(gameFlag == STAGE2 && stateFlag) {
					setMoney(500);
					
					Stage2_Monster stage2 = new Stage2_Monster();
					stage2.start();
					
				}
				if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
					// 게임 끝
					ui.getSinglePanel().getMapLabel().removeAll();
					for(int i=0; i<monsterList.size(); i++) {
						monsterList.get(i).setMonsterFalse();
					}
					setGameFlag(STAGE3);
				}
				// Stage3
				while(gameFlag == STAGE3 && stateFlag) {
					setMoney(500);
					
					Stage3_Monster stage3 = new Stage3_Monster();
					stage3.start();
					
					ui.getSinglePanel().getMapLabel().removeAll();
					for(int i=0; i<monsterList.size(); i++) {
						monsterList.get(i).setMonsterFalse();
					}
				}
				if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
					// 게임 끝
					ui.getSinglePanel().getMapLabel().removeAll();
					for(int i=0; i<monsterList.size(); i++) {
						monsterList.get(i).setMonsterFalse();
					}
					setGameFlag(STAGE4);
				}
				// Stage4
				while(gameFlag == STAGE4 && stateFlag) {
					setMoney(500);
					
					Stage4_Monster stage4 = new Stage4_Monster();
					stage4.start();
					
					ui.getSinglePanel().getMapLabel().removeAll();
					for(int i=0; i<monsterList.size(); i++) {
						monsterList.get(i).setMonsterFalse();
					}
				}
				if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
					// 게임 끝
					ui.getSinglePanel().getMapLabel().removeAll();
					for(int i=0; i<monsterList.size(); i++) {
						monsterList.get(i).setMonsterFalse();
					}
					setGameFlag(STAGE5);
				}
				// Stage5
				while(gameFlag == STAGE5 && stateFlag) {
					setMoney(500);
					
					Stage5_Monster stage5 = new Stage5_Monster();
					stage5.start();
					
					ui.getSinglePanel().getMapLabel().removeAll();
					for(int i=0; i<monsterList.size(); i++) {
						monsterList.get(i).setMonsterFalse();
					}
				}
				if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
					// 게임 끝
					ui.getSinglePanel().getMapLabel().removeAll();
					for(int i=0; i<monsterList.size(); i++) {
						monsterList.get(i).setMonsterFalse();
					}
					setGameFlag(STAGE6);
				}
				// Stage6
				while(gameFlag == STAGE6 && stateFlag) {
					setMoney(500);
					
					Stage6_Monster stage6 = new Stage6_Monster();
					stage6.start();
					
					ui.getSinglePanel().getMapLabel().removeAll();
					for(int i=0; i<monsterList.size(); i++) {
						monsterList.get(i).setMonsterFalse();
					}
				}
				if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
					// 게임 끝
					ui.getSinglePanel().getMapLabel().removeAll();
					for(int i=0; i<monsterList.size(); i++) {
						monsterList.get(i).setMonsterFalse();
					}
					setGameFlag(STAGE7);
				}
				// Stage7
				while(gameFlag == STAGE7 && stateFlag) {
					setMoney(500);
					
					Stage7_Monster stage7 = new Stage7_Monster();
					stage7.start();
					
					ui.getSinglePanel().getMapLabel().removeAll();
					for(int i=0; i<monsterList.size(); i++) {
						monsterList.get(i).setMonsterFalse();
					}
				}
				if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
					// 게임 끝
					ui.getSinglePanel().getMapLabel().removeAll();
					for(int i=0; i<monsterList.size(); i++) {
						monsterList.get(i).setMonsterFalse();
					}
					setGameFlag(STAGE8);
				}
				// Stage8
				while(gameFlag == STAGE8 && stateFlag) {
					setMoney(500);
					
					Stage8_Monster stage8 = new Stage8_Monster();
					stage8.start();
					
					ui.getSinglePanel().getMapLabel().removeAll();
					for(int i=0; i<monsterList.size(); i++) {
						monsterList.get(i).setMonsterFalse();
					}
				}
				if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
					// 게임 끝
					ui.getSinglePanel().getMapLabel().removeAll();
					for(int i=0; i<monsterList.size(); i++) {
						monsterList.get(i).setMonsterFalse();
					}
					setGameFlag(STAGE9);
				}
				// Stage9
				while(gameFlag == STAGE9 && stateFlag) {
					setMoney(500);
					
					Stage9_Monster stage9 = new Stage9_Monster();
					stage9.start();
					
					ui.getSinglePanel().getMapLabel().removeAll();
					for(int i=0; i<monsterList.size(); i++) {
						monsterList.get(i).setMonsterFalse();
					}
				}
				if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
					// 게임 끝
					ui.getSinglePanel().getMapLabel().removeAll();
					for(int i=0; i<monsterList.size(); i++) {
						monsterList.get(i).setMonsterFalse();
					}
					setGameFlag(STAGE10);
				}
				// Stage10
				while(gameFlag == STAGE10 && stateFlag) {
					setMoney(500);
					
					Stage10_Monster stage10 = new Stage10_Monster();
					stage10.start();
					
					ui.getSinglePanel().getMapLabel().removeAll();
					for(int i=0; i<monsterList.size(); i++) {
						monsterList.get(i).setMonsterFalse();
					}
				}
				if(1 <= gameFlag && gameFlag <= 10) {
					// 게임 끝
					ui.getSinglePanel().getMapLabel().removeAll();
					for(int i=0; i<monsterList.size(); i++) {
						monsterList.get(i).setMonsterFalse();
					}
					setGameFlag(SINGLE_WIN);
				}
				// Single_lose
				while(gameFlag == SINGLE_LOSE && stateFlag) {
					
				}
				// Single_win
				while(gameFlag == SINGLE_WIN && stateFlag) {
					
				}
				
				// Multi
				while(gameFlag == MULTI && stateFlag) {
					setMoney(500);
					
					ui.getSinglePanel().getMapLabel().removeAll();
					for(int i=0; i<monsterList.size(); i++) {
						monsterList.get(i).setMonsterFalse();
					}
				}
			}
		}
	}
	public void setStateFlag(boolean state) {
		stateFlag = state;
	}
	
	// Stage1 Start Thread
	class Stage1_Monster extends Thread {
		public void run() {
			// Stage1의 맵을 로드
			JLabel mapLabel = ui.getSinglePanel().getMapLabel();
			map = new MapArray1(mapLabel);
			// 시작 지점을 설정
			Point startPos = map.getStartPosition();
			startPos.setX(startPos.getX()*Point.WIDTH);
			startPos.setY(startPos.getY()*Point.HEIGHT);
			try {
				Thread.sleep(3000);	// 처음 3초간 대기
				for(int i=0; i<CheckGameState.STAGE1_NUM_MONSTER; i++) {
					
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					// 약 1.5초 마다 몬스터를 소환
					Monster0 monster0 = new Monster0(Control_Manager.getInstance(ui), startPos, map, mapLabel);
					monsterList.add(monster0);
					Thread monsterThread = new Thread(monster0);
					monsterThread.start();
					sleep(1500);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 몬스터가 다 제거될때 까지 대기, 승 패를 판정
			boolean lose = false;
			while(getMonsterList().isEmpty() && stateFlag) {
				if(gameFlag == SINGLE_LOSE) {
					lose = true;
					break;
				}
			}
			if(!lose) {
				gameFlag = SINGLE_WIN;
			}
			
		}
	}
	
	// Stage2 Start Thread
	class Stage2_Monster extends Thread {
		public void run() {
			// Stage1의 맵을 로드
			JLabel mapLabel = ui.getSinglePanel().getMapLabel();
			map = new MapArray1(mapLabel);
			// 시작 지점을 설정
			Point startPos = map.getStartPosition();
			startPos.setX(startPos.getX()*Point.WIDTH);
			startPos.setY(startPos.getY()*Point.HEIGHT);
			try {
				Thread.sleep(3000);	// 처음 3초간 대기
				for(int i=0; i<CheckGameState.STAGE1_NUM_MONSTER; i++) {
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					// 약 1.5초 마다 몬스터를 소환
					Monster0 monster0 = new Monster0(Control_Manager.getInstance(ui), startPos, map, mapLabel);
					monsterList.add(monster0);
					Thread monsterThread = new Thread(monster0);
					monsterThread.start();
					sleep(1500);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 몬스터가 다 제거될때 까지 대기, 승 패를 판정
			boolean lose = false;
			while(getMonsterList().isEmpty() && stateFlag) {
				if(gameFlag == SINGLE_LOSE) {
					lose = true;
					break;
				}
			}
			if(!lose) {
				gameFlag = SINGLE_WIN;
			}
			
		}
	}
	
	// Stage3 Start Thread
	class Stage3_Monster extends Thread {
		public void run() {
			// Stage1의 맵을 로드
			JLabel mapLabel = ui.getSinglePanel().getMapLabel();
			map = new MapArray1(mapLabel);
			// 시작 지점을 설정
			Point startPos = map.getStartPosition();
			startPos.setX(startPos.getX()*Point.WIDTH);
			startPos.setY(startPos.getY()*Point.HEIGHT);
			try {
				Thread.sleep(3000);	// 처음 3초간 대기
				for(int i=0; i<CheckGameState.STAGE1_NUM_MONSTER; i++) {
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					// 약 1.5초 마다 몬스터를 소환
					Monster0 monster0 = new Monster0(Control_Manager.getInstance(ui), startPos, map, mapLabel);
					monsterList.add(monster0);
					Thread monsterThread = new Thread(monster0);
					monsterThread.start();
					sleep(1500);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 몬스터가 다 제거될때 까지 대기, 승 패를 판정
			boolean lose = false;
			while(getMonsterList().isEmpty() && stateFlag) {
				if(gameFlag == SINGLE_LOSE) {
					lose = true;
					break;
				}
			}
			if(!lose) {
				gameFlag = SINGLE_WIN;
			}
			
		}
	}
	
	// Stage4 Start Thread
	class Stage4_Monster extends Thread {
		public void run() {
			// Stage1의 맵을 로드
			JLabel mapLabel = ui.getSinglePanel().getMapLabel();
			map = new MapArray1(mapLabel);
			// 시작 지점을 설정
			Point startPos = map.getStartPosition();
			startPos.setX(startPos.getX()*Point.WIDTH);
			startPos.setY(startPos.getY()*Point.HEIGHT);
			try {
				Thread.sleep(3000);	// 처음 3초간 대기
				for(int i=0; i<CheckGameState.STAGE1_NUM_MONSTER; i++) {
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					// 약 1.5초 마다 몬스터를 소환
					Monster0 monster0 = new Monster0(Control_Manager.getInstance(ui), startPos, map, mapLabel);
					monsterList.add(monster0);
					Thread monsterThread = new Thread(monster0);
					monsterThread.start();
					sleep(1500);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 몬스터가 다 제거될때 까지 대기, 승 패를 판정
			boolean lose = false;
			while(getMonsterList().isEmpty() && stateFlag) {
				if(gameFlag == SINGLE_LOSE) {
					lose = true;
					break;
				}
			}
			if(!lose) {
				gameFlag = SINGLE_WIN;
			}
			
		}
	}
	
	// Stage5 Start Thread
	class Stage5_Monster extends Thread {
		public void run() {
			// Stage1의 맵을 로드
			JLabel mapLabel = ui.getSinglePanel().getMapLabel();
			map = new MapArray1(mapLabel);
			// 시작 지점을 설정
			Point startPos = map.getStartPosition();
			startPos.setX(startPos.getX()*Point.WIDTH);
			startPos.setY(startPos.getY()*Point.HEIGHT);
			try {
				Thread.sleep(3000);	// 처음 3초간 대기
				for(int i=0; i<CheckGameState.STAGE1_NUM_MONSTER; i++) {
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					// 약 1.5초 마다 몬스터를 소환
					Monster0 monster0 = new Monster0(Control_Manager.getInstance(ui), startPos, map, mapLabel);
					monsterList.add(monster0);
					Thread monsterThread = new Thread(monster0);
					monsterThread.start();
					sleep(1500);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 몬스터가 다 제거될때 까지 대기, 승 패를 판정
			boolean lose = false;
			while(getMonsterList().isEmpty() && stateFlag) {
				if(gameFlag == SINGLE_LOSE) {
					lose = true;
					break;
				}
			}
			if(!lose) {
				gameFlag = SINGLE_WIN;
			}
			
		}
	}
	
	// Stage6 Start Thread
	class Stage6_Monster extends Thread {
		public void run() {
			// Stage1의 맵을 로드
			JLabel mapLabel = ui.getSinglePanel().getMapLabel();
			map = new MapArray1(mapLabel);
			// 시작 지점을 설정
			Point startPos = map.getStartPosition();
			startPos.setX(startPos.getX()*Point.WIDTH);
			startPos.setY(startPos.getY()*Point.HEIGHT);
			try {
				Thread.sleep(3000);	// 처음 3초간 대기
				for(int i=0; i<CheckGameState.STAGE1_NUM_MONSTER; i++) {
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					// 약 1.5초 마다 몬스터를 소환
					Monster0 monster0 = new Monster0(Control_Manager.getInstance(ui), startPos, map, mapLabel);
					monsterList.add(monster0);
					Thread monsterThread = new Thread(monster0);
					monsterThread.start();
					sleep(1500);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 몬스터가 다 제거될때 까지 대기, 승 패를 판정
			boolean lose = false;
			while(getMonsterList().isEmpty() && stateFlag) {
				if(gameFlag == SINGLE_LOSE) {
					lose = true;
					break;
				}
			}
			if(!lose) {
				gameFlag = SINGLE_WIN;
			}
			
		}
	}
	
	// Stage7 Start Thread
	class Stage7_Monster extends Thread {
		public void run() {
			// Stage1의 맵을 로드
			JLabel mapLabel = ui.getSinglePanel().getMapLabel();
			map = new MapArray1(mapLabel);
			// 시작 지점을 설정
			Point startPos = map.getStartPosition();
			startPos.setX(startPos.getX()*Point.WIDTH);
			startPos.setY(startPos.getY()*Point.HEIGHT);
			try {
				Thread.sleep(3000);	// 처음 3초간 대기
				for(int i=0; i<CheckGameState.STAGE1_NUM_MONSTER; i++) {
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					// 약 1.5초 마다 몬스터를 소환
					Monster0 monster0 = new Monster0(Control_Manager.getInstance(ui), startPos, map, mapLabel);
					monsterList.add(monster0);
					Thread monsterThread = new Thread(monster0);
					monsterThread.start();
					sleep(1500);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 몬스터가 다 제거될때 까지 대기, 승 패를 판정
			boolean lose = false;
			while(getMonsterList().isEmpty() && stateFlag) {
				if(gameFlag == SINGLE_LOSE) {
					lose = true;
					break;
				}
			}
			if(!lose) {
				gameFlag = SINGLE_WIN;
			}
			
		}
	}
	
	// Stage8 Start Thread
	class Stage8_Monster extends Thread {
		public void run() {
			// Stage1의 맵을 로드
			JLabel mapLabel = ui.getSinglePanel().getMapLabel();
			map = new MapArray1(mapLabel);
			// 시작 지점을 설정
			Point startPos = map.getStartPosition();
			startPos.setX(startPos.getX()*Point.WIDTH);
			startPos.setY(startPos.getY()*Point.HEIGHT);
			try {
				Thread.sleep(3000);	// 처음 3초간 대기
				for(int i=0; i<CheckGameState.STAGE1_NUM_MONSTER; i++) {
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					// 약 1.5초 마다 몬스터를 소환
					Monster0 monster0 = new Monster0(Control_Manager.getInstance(ui), startPos, map, mapLabel);
					monsterList.add(monster0);
					Thread monsterThread = new Thread(monster0);
					monsterThread.start();
					sleep(1500);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 몬스터가 다 제거될때 까지 대기, 승 패를 판정
			boolean lose = false;
			while(getMonsterList().isEmpty() && stateFlag) {
				if(gameFlag == SINGLE_LOSE) {
					lose = true;
					break;
				}
			}
			if(!lose) {
				gameFlag = SINGLE_WIN;
			}
			
		}
	}
	
	// Stage9 Start Thread
	class Stage9_Monster extends Thread {
		public void run() {
			// Stage1의 맵을 로드
			JLabel mapLabel = ui.getSinglePanel().getMapLabel();
			map = new MapArray1(mapLabel);
			// 시작 지점을 설정
			Point startPos = map.getStartPosition();
			startPos.setX(startPos.getX()*Point.WIDTH);
			startPos.setY(startPos.getY()*Point.HEIGHT);
			try {
				Thread.sleep(3000);	// 처음 3초간 대기
				for(int i=0; i<CheckGameState.STAGE1_NUM_MONSTER; i++) {
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					// 약 1.5초 마다 몬스터를 소환
					Monster0 monster0 = new Monster0(Control_Manager.getInstance(ui), startPos, map, mapLabel);
					monsterList.add(monster0);
					Thread monsterThread = new Thread(monster0);
					monsterThread.start();
					sleep(1500);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 몬스터가 다 제거될때 까지 대기, 승 패를 판정
			boolean lose = false;
			while(getMonsterList().isEmpty() && stateFlag) {
				if(gameFlag == SINGLE_LOSE) {
					lose = true;
					break;
				}
			}
			if(!lose) {
				gameFlag = SINGLE_WIN;
			}
			
		}
	}
	
	// Stage10 Start Thread
	class Stage10_Monster extends Thread {
		public void run() {
			// Stage1의 맵을 로드
			JLabel mapLabel = ui.getSinglePanel().getMapLabel();
			map = new MapArray1(mapLabel);
			// 시작 지점을 설정
			Point startPos = map.getStartPosition();
			startPos.setX(startPos.getX()*Point.WIDTH);
			startPos.setY(startPos.getY()*Point.HEIGHT);
			try {
				Thread.sleep(3000);	// 처음 3초간 대기
				for(int i=0; i<CheckGameState.STAGE1_NUM_MONSTER; i++) {
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					// 약 1.5초 마다 몬스터를 소환
					Monster0 monster0 = new Monster0(Control_Manager.getInstance(ui), startPos, map, mapLabel);
					monsterList.add(monster0);
					Thread monsterThread = new Thread(monster0);
					monsterThread.start();
					sleep(1500);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 몬스터가 다 제거될때 까지 대기, 승 패를 판정
			boolean lose = false;
			while(getMonsterList().isEmpty() && stateFlag) {
				if(gameFlag == SINGLE_LOSE) {
					lose = true;
					break;
				}
			}
			if(!lose) {
				gameFlag = SINGLE_WIN;
			}
			
		}
	}
	
	
	
}


