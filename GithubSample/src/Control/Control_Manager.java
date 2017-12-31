package Control;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import View.ViewManager;

public class Control_Manager {
	private static Control_Manager instance = null;
	
	private ViewManager ui;
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
	
	private Control_Manager(ViewManager v) {
		ui = v;
		
		CheckGameState startThread = new CheckGameState();
		startThread.start();
		addListener();
		
	}
	
	public void addListener() {
		ui.getMainPanel().getSingleLabel().addMouseListener(new SingleLabelActionListener());
		ui.getMainPanel().getMultiLabel().addMouseListener(new MultiLabelActionListener());
		ui.getMainPanel().getExitLabel().addMouseListener(new ExitLabelActionListener());
		// 싱글
		ui.getSinglePanel().getMapLabel().addMouseListener(new MapLabelListener());
		ui.getSinglePanel().getMapLabel().addMouseMotionListener(new MapLabelListener());
		
		// 싱글 버튼
		ui.getSinglePanel().getTower0Btn().addActionListener(new Tower0BtnListener());
		ui.getSinglePanel().getTower1Btn().addActionListener(new Tower1BtnListener());
		ui.getSinglePanel().getTower2Btn().addActionListener(new Tower2BtnListener());
		ui.getSinglePanel().getTower3Btn().addActionListener(new Tower3BtnListener());
		ui.getSinglePanel().getTower4Btn().addActionListener(new Tower4BtnListener());
		ui.getSinglePanel().getTower5Btn().addActionListener(new Tower5BtnListener());
		
		// 멀티
		
	}
	
	public static Control_Manager getInstance(ViewManager v) {
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
	
	public ArrayList<Tower> getTowerList() {
		return towerList;
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
	
	public ViewManager getUI() {
		return ui;
	}
	public Map getMapArray() {
		return map;
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
				if(gameFlag == STAGE1 && stateFlag) {
					setMoney(500); setScore(0);
					scoreFlag = true;
					moneyFlag = true;
					ScoreThread scoreThread = new ScoreThread();
					MoneyThread moneyThread = new MoneyThread();
					
					scoreThread.start();
					moneyThread.start();
					
					Stage1_Monster stage1 = new Stage1_Monster(this);
					stage1.start();
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
						// 게임 끝
						ui.getSinglePanel().getMapLabel().removeAll();
						for(int i=0; i<monsterList.size(); i++) {
							monsterList.get(i).setMonsterFalse();
						}
						for(int i=0; i<towerList.size(); i++) {
							towerList.get(i).setTowerFalse();
						}
						gameFlag = STAGE2;
					}
				}
				// Stage2
				if(gameFlag == STAGE2 && stateFlag) {
					setMoney(500);
					
					Stage2_Monster stage2 = new Stage2_Monster(this);
					stage2.start();
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
						// 게임 끝
						ui.getSinglePanel().getMapLabel().removeAll();
						for(int i=0; i<monsterList.size(); i++) {
							monsterList.get(i).setMonsterFalse();
						}
						for(int i=0; i<towerList.size(); i++) {
							towerList.get(i).setTowerFalse();
						}
						gameFlag = STAGE3;
					}
				}
				// Stage3
				if(gameFlag == STAGE3 && stateFlag) {
					setMoney(500);
					
					Stage3_Monster stage3 = new Stage3_Monster(this);
					stage3.start();
					
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
						// 게임 끝
						ui.getSinglePanel().getMapLabel().removeAll();
						for(int i=0; i<monsterList.size(); i++) {
							monsterList.get(i).setMonsterFalse();
						}
						for(int i=0; i<towerList.size(); i++) {
							towerList.get(i).setTowerFalse();
						}
						gameFlag = STAGE4;
					}
				}
				
				// Stage4
				if(gameFlag == STAGE4 && stateFlag) {
					setMoney(500);
					
					Stage4_Monster stage4 = new Stage4_Monster(this);
					stage4.start();
					
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
						// 게임 끝
						ui.getSinglePanel().getMapLabel().removeAll();
						for(int i=0; i<monsterList.size(); i++) {
							monsterList.get(i).setMonsterFalse();
						}
						for(int i=0; i<towerList.size(); i++) {
							towerList.get(i).setTowerFalse();
						}
						gameFlag = STAGE5;
					}
				}
				
				// Stage5
				if(gameFlag == STAGE5 && stateFlag) {
					setMoney(500);
					
					Stage5_Monster stage5 = new Stage5_Monster(this);
					stage5.start();
					
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
						// 게임 끝
						ui.getSinglePanel().getMapLabel().removeAll();
						for(int i=0; i<monsterList.size(); i++) {
							monsterList.get(i).setMonsterFalse();
						}
						for(int i=0; i<towerList.size(); i++) {
							towerList.get(i).setTowerFalse();
						}
						gameFlag = STAGE6;
					}
				}
				// Stage6
				if(gameFlag == STAGE6 && stateFlag) {
					setMoney(500);
					
					Stage6_Monster stage6 = new Stage6_Monster(this);
					stage6.start();
					
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
						// 게임 끝
						ui.getSinglePanel().getMapLabel().removeAll();
						for(int i=0; i<monsterList.size(); i++) {
							monsterList.get(i).setMonsterFalse();
						}
						for(int i=0; i<towerList.size(); i++) {
							towerList.get(i).setTowerFalse();
						}
						gameFlag = STAGE7;
					}
				}
				
				// Stage7
				if(gameFlag == STAGE7 && stateFlag) {
					setMoney(500);
					
					Stage7_Monster stage7 = new Stage7_Monster(this);
					stage7.start();
					
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
						// 게임 끝
						ui.getSinglePanel().getMapLabel().removeAll();
						for(int i=0; i<monsterList.size(); i++) {
							monsterList.get(i).setMonsterFalse();
						}
						for(int i=0; i<towerList.size(); i++) {
							towerList.get(i).setTowerFalse();
						}
						gameFlag = STAGE8;
					}
				}
				
				// Stage8
				if(gameFlag == STAGE8 && stateFlag) {
					setMoney(500);
					
					Stage8_Monster stage8 = new Stage8_Monster(this);
					stage8.start();
					
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
						// 게임 끝
						ui.getSinglePanel().getMapLabel().removeAll();
						for(int i=0; i<monsterList.size(); i++) {
							monsterList.get(i).setMonsterFalse();
						}
						for(int i=0; i<towerList.size(); i++) {
							towerList.get(i).setTowerFalse();
						}
						gameFlag = STAGE9;
					}
				}
				
				// Stage9
				if(gameFlag == STAGE9 && stateFlag) {
					setMoney(500);
					
					Stage9_Monster stage9 = new Stage9_Monster(this);
					stage9.start();
					
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
						// 게임 끝
						ui.getSinglePanel().getMapLabel().removeAll();
						for(int i=0; i<monsterList.size(); i++) {
							monsterList.get(i).setMonsterFalse();
						}
						for(int i=0; i<towerList.size(); i++) {
							towerList.get(i).setTowerFalse();
						}
						gameFlag = STAGE10;
					}
				}
				
				// Stage10
				if(gameFlag == STAGE10 && stateFlag) {
					setMoney(500);
					
					Stage10_Monster stage10 = new Stage10_Monster(this);
					stage10.start();
					
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
						// 게임 끝
						ui.getSinglePanel().getMapLabel().removeAll();
						for(int i=0; i<monsterList.size(); i++) {
							monsterList.get(i).setMonsterFalse();
						}
						for(int i=0; i<towerList.size(); i++) {
							towerList.get(i).setTowerFalse();
						}
						gameFlag = SINGLE_WIN;
					}
				}
				
				// Single_lose
				if(gameFlag == SINGLE_LOSE && stateFlag) {
					
					//ui.getSinglePanel().getResultLabel().setVisible(true);
					
					// 테스트용
					gameFlag = MAIN;
					ui.getSinglePanel().setVisible(false);
					ui.getMainPanel().setVisible(true);
					
					
					// 게임 끝
					ui.getSinglePanel().getMapLabel().removeAll();
					for(int i=0; i<monsterList.size(); i++) {
						monsterList.get(i).setMonsterFalse();
					}
					for(int i=0; i<towerList.size(); i++) {
						towerList.get(i).setTowerFalse();
					}
					
					
					
					scoreFlag = false;
					moneyFlag = false;
				}
				// Single_win
				if(gameFlag == SINGLE_WIN && stateFlag) {
					
					
					// 테스트용
					gameFlag = MAIN;
					ui.getSinglePanel().setVisible(false);
					ui.getMainPanel().setVisible(true);
					
					
					// 게임 끝
					ui.getSinglePanel().getMapLabel().removeAll();
					for(int i=0; i<monsterList.size(); i++) {
						monsterList.get(i).setMonsterFalse();
					}
					for(int i=0; i<towerList.size(); i++) {
						towerList.get(i).setTowerFalse();
					}
					
					
					
					scoreFlag = false;
					moneyFlag = false;
				}
				
				// Multi
				if(gameFlag == MULTI && stateFlag) {
					setMoney(500);
					
					ui.getMultiPanel().getMapLabel().removeAll();
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
		private CheckGameState stateThread;
		
		public Stage1_Monster(CheckGameState t) {
			stateThread = t;
		}
		
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
					Monster0 monster0 = new Monster0(startPos, map, mapLabel);
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
			stateThread.notify();
		}
	}
	
	// Stage2 Start Thread
	class Stage2_Monster extends Thread {
		private CheckGameState stateThread;
		
		public Stage2_Monster(CheckGameState t) {
			stateThread = t;
		}
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
				for(int i=0; i<CheckGameState.STAGE2_NUM_MONSTER; i++) {
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					// 약 1.5초 마다 몬스터를 소환
					Monster0 monster0 = new Monster0(startPos, map, mapLabel);
					Monster1 monster1 = new Monster1(startPos, map, mapLabel);
					monsterList.add(monster0);
					monsterList.add(monster1);
					Thread monsterThread0 = new Thread(monster0);
					Thread monsterThread1 = new Thread(monster1);
					monsterThread0.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread1.start();
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
			stateThread.notify();
		}
	}
	
	// Stage3 Start Thread
	class Stage3_Monster extends Thread {
		private CheckGameState stateThread;
		
		public Stage3_Monster(CheckGameState t) {
			stateThread = t;
		}
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
					Monster0 monster0 = new Monster0(startPos, map, mapLabel);
					Monster1 monster1 = new Monster1(startPos, map, mapLabel);
					Monster2 monster2 = new Monster2(startPos, map, mapLabel);
					monsterList.add(monster0);
					monsterList.add(monster1);
					monsterList.add(monster2);
					Thread monsterThread0 = new Thread(monster0);
					Thread monsterThread1 = new Thread(monster1);
					Thread monsterThread2 = new Thread(monster2);
					monsterThread0.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread1.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread2.start();
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
			stateThread.notify();
		}
	}
	
	// Stage4 Start Thread
	class Stage4_Monster extends Thread {
		private CheckGameState stateThread;
		
		public Stage4_Monster(CheckGameState t) {
			stateThread = t;
		}
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
					Monster0 monster0 = new Monster0(startPos, map, mapLabel);
					Monster1 monster1 = new Monster1(startPos, map, mapLabel);
					Monster2 monster2 = new Monster2(startPos, map, mapLabel);
					Monster3 monster3 = new Monster3(startPos, map, mapLabel);
					monsterList.add(monster0);
					monsterList.add(monster1);
					monsterList.add(monster2);
					monsterList.add(monster3);
					Thread monsterThread0 = new Thread(monster0);
					Thread monsterThread1 = new Thread(monster1);
					Thread monsterThread2 = new Thread(monster2);
					Thread monsterThread3 = new Thread(monster3);
					monsterThread0.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread1.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread2.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread3.start();
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
			stateThread.notify();
		}
	}
	
	// Stage5 Start Thread
	class Stage5_Monster extends Thread {
		private CheckGameState stateThread;
		
		public Stage5_Monster(CheckGameState t) {
			stateThread = t;
		}
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
					Monster0 monster0 = new Monster0(startPos, map, mapLabel);
					Monster1 monster1 = new Monster1(startPos, map, mapLabel);
					Monster2 monster2 = new Monster2(startPos, map, mapLabel);
					Monster3 monster3 = new Monster3(startPos, map, mapLabel);
					Monster4 monster4 = new Monster4(startPos, map, mapLabel);
					monsterList.add(monster0);
					monsterList.add(monster1);
					monsterList.add(monster2);
					monsterList.add(monster3);
					monsterList.add(monster4);
					Thread monsterThread0 = new Thread(monster0);
					Thread monsterThread1 = new Thread(monster1);
					Thread monsterThread2 = new Thread(monster2);
					Thread monsterThread3 = new Thread(monster3);
					Thread monsterThread4 = new Thread(monster4);
					monsterThread0.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread1.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread2.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread3.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread4.start();
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
			stateThread.notify();
		}
	}
	
	// Stage6 Start Thread
	class Stage6_Monster extends Thread {
private CheckGameState stateThread;
		
		public Stage6_Monster(CheckGameState t) {
			stateThread = t;
		}
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
					Monster0 monster0 = new Monster0(startPos, map, mapLabel);
					Monster1 monster1 = new Monster1(startPos, map, mapLabel);
					Monster2 monster2 = new Monster2(startPos, map, mapLabel);
					Monster3 monster3 = new Monster3(startPos, map, mapLabel);
					Monster4 monster4 = new Monster4(startPos, map, mapLabel);
					Monster5 monster5 = new Monster5(startPos, map, mapLabel);
					monsterList.add(monster0);
					monsterList.add(monster1);
					monsterList.add(monster2);
					monsterList.add(monster3);
					monsterList.add(monster4);
					monsterList.add(monster5);
					Thread monsterThread0 = new Thread(monster0);
					Thread monsterThread1 = new Thread(monster1);
					Thread monsterThread2 = new Thread(monster2);
					Thread monsterThread3 = new Thread(monster3);
					Thread monsterThread4 = new Thread(monster4);
					Thread monsterThread5 = new Thread(monster5);
					monsterThread0.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread1.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread2.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread3.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread4.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread5.start();
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
			stateThread.notify();
		}
	}
	
	// Stage7 Start Thread
	class Stage7_Monster extends Thread {
		private CheckGameState stateThread;
		
		public Stage7_Monster(CheckGameState t) {
			stateThread = t;
		}
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
					Monster0 monster0 = new Monster0(startPos, map, mapLabel);
					Monster1 monster1 = new Monster1(startPos, map, mapLabel);
					Monster2 monster2 = new Monster2(startPos, map, mapLabel);
					Monster3 monster3 = new Monster3(startPos, map, mapLabel);
					Monster4 monster4 = new Monster4(startPos, map, mapLabel);
					Monster5 monster5 = new Monster5(startPos, map, mapLabel);
					Monster6 monster6 = new Monster6(startPos, map, mapLabel);
					monsterList.add(monster0);
					monsterList.add(monster1);
					monsterList.add(monster2);
					monsterList.add(monster3);
					monsterList.add(monster4);
					monsterList.add(monster5);
					monsterList.add(monster6);
					Thread monsterThread0 = new Thread(monster0);
					Thread monsterThread1 = new Thread(monster1);
					Thread monsterThread2 = new Thread(monster2);
					Thread monsterThread3 = new Thread(monster3);
					Thread monsterThread4 = new Thread(monster4);
					Thread monsterThread5 = new Thread(monster5);
					Thread monsterThread6 = new Thread(monster6);
					monsterThread0.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread1.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread2.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread3.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread4.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread5.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread6.start();
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
			stateThread.notify();
		}
	}
	
	// Stage8 Start Thread
	class Stage8_Monster extends Thread {
		private CheckGameState stateThread;
		
		public Stage8_Monster(CheckGameState t) {
			stateThread = t;
		}
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
					Monster0 monster0 = new Monster0(startPos, map, mapLabel);
					Monster1 monster1 = new Monster1(startPos, map, mapLabel);
					Monster2 monster2 = new Monster2(startPos, map, mapLabel);
					Monster3 monster3 = new Monster3(startPos, map, mapLabel);
					Monster4 monster4 = new Monster4(startPos, map, mapLabel);
					Monster5 monster5 = new Monster5(startPos, map, mapLabel);
					Monster6 monster6 = new Monster6(startPos, map, mapLabel);
					Monster7 monster7 = new Monster7(startPos, map, mapLabel);
					monsterList.add(monster0);
					monsterList.add(monster1);
					monsterList.add(monster2);
					monsterList.add(monster3);
					monsterList.add(monster4);
					monsterList.add(monster5);
					monsterList.add(monster6);
					monsterList.add(monster7);
					Thread monsterThread0 = new Thread(monster0);
					Thread monsterThread1 = new Thread(monster1);
					Thread monsterThread2 = new Thread(monster2);
					Thread monsterThread3 = new Thread(monster3);
					Thread monsterThread4 = new Thread(monster4);
					Thread monsterThread5 = new Thread(monster5);
					Thread monsterThread6 = new Thread(monster6);
					Thread monsterThread7 = new Thread(monster7);
					monsterThread0.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread1.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread2.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread3.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread4.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread5.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread6.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread7.start();
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
			stateThread.notify();
		}
	}
	
	// Stage9 Start Thread
	class Stage9_Monster extends Thread {
		private CheckGameState stateThread;
		
		public Stage9_Monster(CheckGameState t) {
			stateThread = t;
		}
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
					Monster0 monster0 = new Monster0(startPos, map, mapLabel);
					Monster1 monster1 = new Monster1(startPos, map, mapLabel);
					Monster2 monster2 = new Monster2(startPos, map, mapLabel);
					Monster3 monster3 = new Monster3(startPos, map, mapLabel);
					Monster4 monster4 = new Monster4(startPos, map, mapLabel);
					Monster5 monster5 = new Monster5(startPos, map, mapLabel);
					Monster6 monster6 = new Monster6(startPos, map, mapLabel);
					Monster7 monster7 = new Monster7(startPos, map, mapLabel);
					Monster8 monster8 = new Monster8(startPos, map, mapLabel);
					monsterList.add(monster0);
					monsterList.add(monster1);
					monsterList.add(monster2);
					monsterList.add(monster3);
					monsterList.add(monster4);
					monsterList.add(monster5);
					monsterList.add(monster6);
					monsterList.add(monster7);
					monsterList.add(monster8);
					Thread monsterThread0 = new Thread(monster0);
					Thread monsterThread1 = new Thread(monster1);
					Thread monsterThread2 = new Thread(monster2);
					Thread monsterThread3 = new Thread(monster3);
					Thread monsterThread4 = new Thread(monster4);
					Thread monsterThread5 = new Thread(monster5);
					Thread monsterThread6 = new Thread(monster6);
					Thread monsterThread7 = new Thread(monster7);
					Thread monsterThread8 = new Thread(monster8);
					monsterThread0.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread1.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread2.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread3.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread4.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread5.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread6.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread7.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread8.start();
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
			stateThread.notify();
		}
	}
	
	// Stage10 Start Thread
	class Stage10_Monster extends Thread {
		private CheckGameState stateThread;
		
		public Stage10_Monster(CheckGameState t) {
			stateThread = t;
		}
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
					Monster0 monster0 = new Monster0(startPos, map, mapLabel);
					Monster1 monster1 = new Monster1(startPos, map, mapLabel);
					Monster2 monster2 = new Monster2(startPos, map, mapLabel);
					Monster3 monster3 = new Monster3(startPos, map, mapLabel);
					Monster4 monster4 = new Monster4(startPos, map, mapLabel);
					Monster5 monster5 = new Monster5(startPos, map, mapLabel);
					Monster6 monster6 = new Monster6(startPos, map, mapLabel);
					Monster7 monster7 = new Monster7(startPos, map, mapLabel);
					Monster8 monster8 = new Monster8(startPos, map, mapLabel);
					Monster9 monster9 = new Monster9(startPos, map, mapLabel);
					monsterList.add(monster0);
					monsterList.add(monster1);
					monsterList.add(monster2);
					monsterList.add(monster3);
					monsterList.add(monster4);
					monsterList.add(monster5);
					monsterList.add(monster6);
					monsterList.add(monster7);
					monsterList.add(monster8);
					monsterList.add(monster9);
					Thread monsterThread0 = new Thread(monster0);
					Thread monsterThread1 = new Thread(monster1);
					Thread monsterThread2 = new Thread(monster2);
					Thread monsterThread3 = new Thread(monster3);
					Thread monsterThread4 = new Thread(monster4);
					Thread monsterThread5 = new Thread(monster5);
					Thread monsterThread6 = new Thread(monster6);
					Thread monsterThread7 = new Thread(monster7);
					Thread monsterThread8 = new Thread(monster8);
					Thread monsterThread9 = new Thread(monster9);
					monsterThread0.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread1.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread2.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread3.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread4.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread5.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread6.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread7.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread8.start();
					sleep(1500);
					if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
						break;
					monsterThread9.start();
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
			stateThread.notify();
		}
	}
	
	private boolean moneyFlag = true;
	// 자원을 관리하는 스레드
	class MoneyThread extends Thread {
		private JTextField moneyField;
		private Control_Manager control;
		public MoneyThread() {
			control = Control_Manager.getInstance(null);
			if(control.getGameFlag() >= Control_Manager.STAGE1 && Control_Manager.STAGE10 >= control.getGameFlag())
				moneyField = control.getUI().getSinglePanel().getMoneyField();
			else if(control.getGameFlag() == Control_Manager.MULTI) 
				moneyField = control.getUI().getMultiPanel().getMoneyField();
		}
		
		public boolean getMoneyFlag() {
			return moneyFlag;
		}
		public void setMoneyFlag(boolean set) {
			moneyFlag = set;
		}
		public void run() {
			while(moneyFlag) {
				moneyField.setText("" + control.getMoney());
				
				try {	// 300 미리초 마다 갱신
					sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private boolean scoreFlag = true;	
	// 점수를 관리하는 스레드
	class ScoreThread extends Thread {
		private JTextField scoreField;

		private Control_Manager control;
		public ScoreThread() {
			control = Control_Manager.getInstance(null);
			if(control.getGameFlag() >= Control_Manager.STAGE1 && Control_Manager.STAGE10 >= control.getGameFlag())
				scoreField = control.getUI().getSinglePanel().getMoneyField();
			else if(control.getGameFlag() == Control_Manager.MULTI) 
				scoreField = control.getUI().getMultiPanel().getMoneyField();
		}
		
		public boolean getScoreFlag() {
			return scoreFlag;
		}
		public void setScoreFlag(boolean set) {
			scoreFlag = set;
		}
		public void run() {
			while(scoreFlag) {
				scoreField.setText("" + control.getScore());
				
				try {	// 300 미리초 마다 갱신
					sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}


