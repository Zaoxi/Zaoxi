// This game was produced by Ahn & Joe Team.
// Tower Defense 0.5 Beta.
// This project is for everyone.
// When you use this code, you have to evidence the source.

package Control;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import View.ViewManager;

public class Control_Manager {
	private static Control_Manager instance = null;
	final private ImageIcon MAP_SINGLE = new ImageIcon("Image/Map/map_background.png");
	
	private ViewManager ui;
	// 맵을 저장하는 배열
	volatile private Map map = null;
	// 몬스터를 저장하는 리스트
	volatile private ArrayList<Monster> monsterList;
	// 타워를 저장하는 리스트
	volatile private ArrayList<Tower> towerList;
	// 게임의 상태를 체크하는 스레드의 플래그
	volatile private boolean stateFlag = true;
	
	
	CheckGameState stateThread;
	// 게임의 상태 스레드 제어 플래그
	volatile private int gameFlag = 0;
	
	// 점수
	volatile private int score = 0;
	// 자원
	volatile private int money = 0;
	
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
	final public static int SINGLE_LOSE = 11;
	final public static int MULTI = 12;
	final public static int MULTI_WIN = 13;
	final public static int MULTI_LOSE = 14;
	
	final public static int SUM_STAGE = 10;
	
	private Control_Manager(ViewManager v) {
		instance = this;
		ui = v;
		towerList = new ArrayList<Tower>();
		monsterList = new ArrayList<Monster>();
		
		addListener();
		Monster.setImageDir();
		stateThread = new CheckGameState();
		stateThread.start();
	}
	
	public void setMapArray(Map _map) {
		map = _map;
	}
	
	public boolean getStateFlag() {
		return stateFlag;
	}
	public void setStateFlag(boolean set) {
		stateFlag = set;
	}
	
	public static void main(String[] args) {
		ViewManager ui = new ViewManager();
		Control_Manager.getInstance(ui);
	}
	
	public void addListener() {
		// 메인 패널
		ui.getMainPanel().getSingleLabel().addMouseListener(new SingleLabelActionListener());
		ui.getMainPanel().getMultiLabel().addMouseListener(new MultiLabelActionListener());
		ui.getMainPanel().getExitLabel().addMouseListener(new ExitLabelActionListener());
		// 싱글 패널
		ui.getSinglePanel().getMapLabel().addMouseListener(new MapLabelListener());
		ui.getSinglePanel().getMapLabel().addMouseMotionListener(new MapLabelListener());
		ui.getSinglePanel().getTower0Btn().addActionListener(new Tower0BtnListener());
		ui.getSinglePanel().getTower1Btn().addActionListener(new Tower1BtnListener());
		ui.getSinglePanel().getTower2Btn().addActionListener(new Tower2BtnListener());
		ui.getSinglePanel().getTower3Btn().addActionListener(new Tower3BtnListener());
		ui.getSinglePanel().getTower4Btn().addActionListener(new Tower4BtnListener());
		ui.getSinglePanel().getTower5Btn().addActionListener(new Tower5BtnListener());
		
		// 호스트 클라이언스 선택 패널
		ui.getSelectPanel().getHostLabel().addMouseListener(new SelectHostBtnMouseListener());
		ui.getSelectPanel().getClientLabel().addMouseListener(new SelectClientBtnMouseListener());
		ui.getSelectPanel().getCancelLabel().addMouseListener(new SelectCancelBtnMouseListener());
		
		// 호스트 패널
		ui.getHostPanel().getHostLabel().addMouseListener(new HostHostBtnMouseListener());
		ui.getHostPanel().getCancelLabel().addMouseListener(new HostCancelBtnMouseListener());
		
		// 클라이언트 패널
		ui.getClientPanel().getJoinLabel().addMouseListener(new ClientJoinBtnMouseListener());
		ui.getClientPanel().getCancelLabel().addMouseListener(new ClientCancelBtnMouseListener());
		
		// 매칭 패널
		ui.getMatchPanel().getCancelLabel().addMouseListener(new MatchCancelBtnMouseListener());
		
		// 싱글 플레이 결과 패널
		ui.getSingleResultPanel().getRegistLabel().addMouseListener(new SingleResultRegistBtnMouseListener());
		ui.getSingleResultPanel().getCancelLabel().addMouseListener(new SingleResultCancelBtnMouseListener());
		
		// 멀티 패널
		
		// 순위 패널
		
	}
	
	public static Control_Manager getInstance(ViewManager v) {
		if(instance == null) new Control_Manager(v);
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
		ui.getSinglePanel().getScoreField().setText(""+score);
		ui.getSingleResultPanel().getScoreLabel().setText("" + score);
	}
	public void setMoney(int _money) {
		money = _money;
		ui.getSinglePanel().getMoneyField().setText("" + money);
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
			final public static int STAGE2_NUM_MONSTER = 10;
			final public static int STAGE3_NUM_MONSTER = 10;
			final public static int STAGE4_NUM_MONSTER = 10;
			final public static int STAGE5_NUM_MONSTER = 10;
			final public static int STAGE6_NUM_MONSTER = 10;
			final public static int STAGE7_NUM_MONSTER = 10;
			final public static int STAGE8_NUM_MONSTER = 10;
			final public static int STAGE9_NUM_MONSTER = 10;
			final public static int STAGE10_NUM_MONSTER = 10;
			
			public void run() {
				while(stateFlag) {
					// Stage1
					if(gameFlag == STAGE1 && stateFlag) {
						setMoney(500); setScore(0);
						
						
						Stage1_Monster stage1 = new Stage1_Monster(this);
						stage1.start();
						synchronized(stage1) {
							try {
								stage1.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
						// 게임 끝
						ui.getSinglePanel().getMapLabel().removeAll();
						ui.getSinglePanel().getMapLabel().addMouseMotionListener(new MapLabelListener());
						MapLabelListener.select = MapLabelListener.NONE;
						ui.getSinglePanel().getMapLabel().setIcon(MAP_SINGLE);
						
						while(!monsterList.isEmpty()) {
							monsterList.get(monsterList.size() - 1).setMonsterFalse();
							monsterList.remove(monsterList.size() - 1);
						}
						while(!towerList.isEmpty()) {
							towerList.get(towerList.size() - 1).setTowerFalse();
							towerList.remove(towerList.size() - 1);
						}
						
						if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
							gameFlag = STAGE2;
						}
					}
					// Stage2
					if(gameFlag == STAGE2 && stateFlag) {
						setMoney(800);
						
						Stage2_Monster stage2 = new Stage2_Monster(this);
						stage2.start();
						synchronized(stage2) {
							try {
								stage2.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						ui.getSinglePanel().getMapLabel().removeAll();
						ui.getSinglePanel().getMapLabel().addMouseMotionListener(new MapLabelListener());
						MapLabelListener.select = MapLabelListener.NONE;
						ui.getSinglePanel().getMapLabel().setIcon(MAP_SINGLE);
						
						while(!monsterList.isEmpty()) {
							monsterList.get(monsterList.size() - 1).setMonsterFalse();
							monsterList.remove(monsterList.size() - 1);
						}
						while(!towerList.isEmpty()) {
							towerList.get(towerList.size() - 1).setTowerFalse();
							towerList.remove(towerList.size() - 1);
						}
						
						if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
							// 게임 끝
							
							gameFlag = STAGE3;
						}
					}
					// Stage3
					if(gameFlag == STAGE3 && stateFlag) {
						setMoney(1000);
						
						Stage3_Monster stage3 = new Stage3_Monster(this);
						stage3.start();
						
						synchronized(stage3) {
							try {
								stage3.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						ui.getSinglePanel().getMapLabel().removeAll();
						ui.getSinglePanel().getMapLabel().addMouseMotionListener(new MapLabelListener());
						MapLabelListener.select = MapLabelListener.NONE;
						ui.getSinglePanel().getMapLabel().setIcon(MAP_SINGLE);
						
						while(!monsterList.isEmpty()) {
							monsterList.get(monsterList.size() - 1).setMonsterFalse();
							monsterList.remove(monsterList.size() - 1);
						}
						while(!towerList.isEmpty()) {
							towerList.get(towerList.size() - 1).setTowerFalse();
							towerList.remove(towerList.size() - 1);
						}
						
						if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
							// 게임 끝

							gameFlag = STAGE4;
						}
					}
					
					// Stage4
					if(gameFlag == STAGE4 && stateFlag) {
						setMoney(1000);
						
						Stage4_Monster stage4 = new Stage4_Monster(this);
						stage4.start();
						
						synchronized(stage4) {
							try {
								stage4.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						ui.getSinglePanel().getMapLabel().removeAll();
						ui.getSinglePanel().getMapLabel().addMouseMotionListener(new MapLabelListener());
						MapLabelListener.select = MapLabelListener.NONE;
						ui.getSinglePanel().getMapLabel().setIcon(MAP_SINGLE);
						
						while(!monsterList.isEmpty()) {
							monsterList.get(monsterList.size() - 1).setMonsterFalse();
							monsterList.remove(monsterList.size() - 1);
						}
						while(!towerList.isEmpty()) {
							towerList.get(towerList.size() - 1).setTowerFalse();
							towerList.remove(towerList.size() - 1);
						}
						
						if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
							// 게임 끝
							
							gameFlag = STAGE5;
						}
					}
					
					// Stage5
					if(gameFlag == STAGE5 && stateFlag) {
						setMoney(1200);
						
						Stage5_Monster stage5 = new Stage5_Monster(this);
						stage5.start();
						
						synchronized(stage5) {
							try {
								stage5.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						ui.getSinglePanel().getMapLabel().removeAll();
						ui.getSinglePanel().getMapLabel().addMouseMotionListener(new MapLabelListener());
						MapLabelListener.select = MapLabelListener.NONE;
						ui.getSinglePanel().getMapLabel().setIcon(MAP_SINGLE);
						
						while(!monsterList.isEmpty()) {
							monsterList.get(monsterList.size() - 1).setMonsterFalse();
							monsterList.remove(monsterList.size() - 1);
						}
						while(!towerList.isEmpty()) {
							towerList.get(towerList.size() - 1).setTowerFalse();
							towerList.remove(towerList.size() - 1);
						}
						
						if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
							// 게임 끝
							
							gameFlag = STAGE6;
						}
					}
					// Stage6
					if(gameFlag == STAGE6 && stateFlag) {
						setMoney(1200);
						
						Stage6_Monster stage6 = new Stage6_Monster(this);
						stage6.start();
						
						synchronized(stage6) {
							try {
								stage6.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						ui.getSinglePanel().getMapLabel().removeAll();
						ui.getSinglePanel().getMapLabel().addMouseMotionListener(new MapLabelListener());
						MapLabelListener.select = MapLabelListener.NONE;
						ui.getSinglePanel().getMapLabel().setIcon(MAP_SINGLE);
						
						while(!monsterList.isEmpty()) {
							monsterList.get(monsterList.size() - 1).setMonsterFalse();
							monsterList.remove(monsterList.size() - 1);
						}
						while(!towerList.isEmpty()) {
							towerList.get(towerList.size() - 1).setTowerFalse();
							towerList.remove(towerList.size() - 1);
						}
						
						if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
							// 게임 끝
					
							gameFlag = STAGE7;
						}
					}
					
					// Stage7
					if(gameFlag == STAGE7 && stateFlag) {
						setMoney(1500);
						
						Stage7_Monster stage7 = new Stage7_Monster(this);
						stage7.start();
						
						synchronized(stage7) {
							try {
								stage7.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						ui.getSinglePanel().getMapLabel().removeAll();
						ui.getSinglePanel().getMapLabel().addMouseMotionListener(new MapLabelListener());
						MapLabelListener.select = MapLabelListener.NONE;
						ui.getSinglePanel().getMapLabel().setIcon(MAP_SINGLE);
						
						while(!monsterList.isEmpty()) {
							monsterList.get(monsterList.size() - 1).setMonsterFalse();
							monsterList.remove(monsterList.size() - 1);
						}
						while(!towerList.isEmpty()) {
							towerList.get(towerList.size() - 1).setTowerFalse();
							towerList.remove(towerList.size() - 1);
						}
						
						if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
							// 게임 끝
							
							gameFlag = STAGE8;
						}
					}
					
					// Stage8
					if(gameFlag == STAGE8 && stateFlag) {
						setMoney(1600);
						
						Stage8_Monster stage8 = new Stage8_Monster(this);
						stage8.start();
						
						synchronized(stage8) {
							try {
								stage8.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						ui.getSinglePanel().getMapLabel().removeAll();
						ui.getSinglePanel().getMapLabel().addMouseMotionListener(new MapLabelListener());
						MapLabelListener.select = MapLabelListener.NONE;
						ui.getSinglePanel().getMapLabel().setIcon(MAP_SINGLE);
						
						while(!monsterList.isEmpty()) {
							monsterList.get(monsterList.size() - 1).setMonsterFalse();
							monsterList.remove(monsterList.size() - 1);
						}
						while(!towerList.isEmpty()) {
							towerList.get(towerList.size() - 1).setTowerFalse();
							towerList.remove(towerList.size() - 1);
						}
						
						if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
							// 게임 끝
							
							gameFlag = STAGE9;
						}
					}
					
					// Stage9
					if(gameFlag == STAGE9 && stateFlag) {
						setMoney(1000);
						
						Stage9_Monster stage9 = new Stage9_Monster(this);
						stage9.start();
						
						synchronized(stage9) {
							try {
								stage9.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						ui.getSinglePanel().getMapLabel().removeAll();
						ui.getSinglePanel().getMapLabel().addMouseMotionListener(new MapLabelListener());
						MapLabelListener.select = MapLabelListener.NONE;
						ui.getSinglePanel().getMapLabel().setIcon(MAP_SINGLE);
						
						while(!monsterList.isEmpty()) {
							monsterList.get(monsterList.size() - 1).setMonsterFalse();
							monsterList.remove(monsterList.size() - 1);
						}
						while(!towerList.isEmpty()) {
							towerList.get(towerList.size() - 1).setTowerFalse();
							towerList.remove(towerList.size() - 1);
						}
						
						if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
							// 게임 끝
							
							gameFlag = STAGE10;
						}
					}
					
					// Stage10
					if(gameFlag == STAGE10 && stateFlag) {
						setMoney(800);
						
						Stage10_Monster stage10 = new Stage10_Monster(this);
						stage10.start();
						
						synchronized(stage10) {
							try {
								stage10.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						ui.getSinglePanel().getMapLabel().removeAll();
						ui.getSinglePanel().getMapLabel().addMouseMotionListener(new MapLabelListener());
						MapLabelListener.select = MapLabelListener.NONE;
						ui.getSinglePanel().getMapLabel().setIcon(MAP_SINGLE);
						
						while(!monsterList.isEmpty()) {
							monsterList.get(monsterList.size() - 1).setMonsterFalse();
							monsterList.remove(monsterList.size() - 1);
						}
						while(!towerList.isEmpty()) {
							towerList.get(towerList.size() - 1).setTowerFalse();
							towerList.remove(towerList.size() - 1);
						}
						
						if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
							// 게임 끝
							
							gameFlag = SINGLE_LOSE;
						}
					}
					
					// Single_lose
					if(gameFlag == SINGLE_LOSE && stateFlag) {
						
						//ui.getSinglePanel().getResultLabel().setVisible(true);
						
						// 테스트용
						gameFlag = MAIN;
						ui.getCard().show(ui.getContentPane(), "single_result");
						
						/*
						 * 점수를 기반으로 DB로부터 추출한 유저 리스트를 대상으로 
						 * 몇등인지 계산하는 메소드를 호출하는 부분
						 */
					}
					
					// Multi
					if(gameFlag == MULTI && stateFlag) {
						setMoney(2000);
						
						ui.getSinglePanel().getMapLabel().removeAll();
						ui.getSinglePanel().getMapLabel().addMouseListener(new MapLabelListener());
						ui.getSinglePanel().getMapLabel().addMouseListener(new MapLabelListener());
						for(int i=0; i<monsterList.size(); i++) {
							monsterList.get(i).setMonsterFalse();
							monsterList.remove(i);
						}
						for(int i=0; i<towerList.size(); i++) {
							towerList.get(i).setTowerFalse();
							towerList.remove(i);
						}
					}
				}
			}
		}

		
		// Stage1 Start Thread
		class Stage1_Monster extends Thread {
			private CheckGameState stateThread;
			
			public Stage1_Monster(CheckGameState t) {
				stateThread = t;
			}
			
			public void run() {
				synchronized(this) {
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
						Thread monsterThread = new Thread(monster0);
						monsterThread.start();
						sleep(1500);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 몬스터가 다 제거될때 까지 대기, 승 패를 판정
				while(!getMonsterList().isEmpty() && stateFlag) {
					if(gameFlag == SINGLE_LOSE) {
						break;
					}
				}
			
				notify();
				}
			}
		}
		
		// Stage2 Start Thread
		class Stage2_Monster extends Thread {
			private CheckGameState stateThread;
			
			public Stage2_Monster(CheckGameState t) {
				stateThread = t;
			}
			public void run() {
				synchronized(this) {
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
						Thread monsterThread0 = new Thread(monster0);
						monsterThread0.start();
						sleep(1500);
						
						if(getGameFlag() == SINGLE_LOSE) // 게임이 끝날 경우
							break;
						
						Monster1 monster1 = new Monster1(startPos, map, mapLabel);
						Thread monsterThread1 = new Thread(monster1);
						monsterThread1.start();
						sleep(1500);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 몬스터가 다 제거될때 까지 대기, 승 패를 판정
				while(!getMonsterList().isEmpty() && stateFlag) {
					if(gameFlag == SINGLE_LOSE) {
						break;
					}
				}
				
				notify();
				}
			}
		}
		
		// Stage3 Start Thread
		class Stage3_Monster extends Thread {
			private CheckGameState stateThread;
			
			public Stage3_Monster(CheckGameState t) {
				stateThread = t;
			}
			public void run() {
				synchronized(this) {
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
				while(!getMonsterList().isEmpty() && stateFlag) {
					if(gameFlag == SINGLE_LOSE) {
						break;
					}
				}
				notify();
				}
			}
		}
		
		// Stage4 Start Thread
		class Stage4_Monster extends Thread {
			private CheckGameState stateThread;
			
			public Stage4_Monster(CheckGameState t) {
				stateThread = t;
			}
			public void run() {
				synchronized(this) {
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
				while(!getMonsterList().isEmpty() && stateFlag) {
					if(gameFlag == SINGLE_LOSE) {
						break;
					}
				}
				notify();
				}
			}
		}
		
		// Stage5 Start Thread
		class Stage5_Monster extends Thread {
			private CheckGameState stateThread;
			
			public Stage5_Monster(CheckGameState t) {
				stateThread = t;
			}
			public void run() {
				synchronized(this) {
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
				while(!getMonsterList().isEmpty() && stateFlag) {
					if(gameFlag == SINGLE_LOSE) {
						break;
					}
				}
				notify();
				}
			}
		}
		
		// Stage6 Start Thread
		class Stage6_Monster extends Thread {
	private CheckGameState stateThread;
			
			public Stage6_Monster(CheckGameState t) {
				stateThread = t;
			}
			public void run() {
				synchronized(this) {
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
				while(!getMonsterList().isEmpty() && stateFlag) {
					if(gameFlag == SINGLE_LOSE) {
						break;
					}
				}
				notify();
				}
			}
		}
		
		// Stage7 Start Thread
		class Stage7_Monster extends Thread {
			private CheckGameState stateThread;
			
			public Stage7_Monster(CheckGameState t) {
				stateThread = t;
			}
			public void run() {
				synchronized(this) {
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
				while(!getMonsterList().isEmpty() && stateFlag) {
					if(gameFlag == SINGLE_LOSE) {
						break;
					}
				}
				notify();
				}
			}
		}
		
		// Stage8 Start Thread
		class Stage8_Monster extends Thread {
			private CheckGameState stateThread;
			
			public Stage8_Monster(CheckGameState t) {
				stateThread = t;
			}
			public void run() {
				synchronized(this) {
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
				while(!getMonsterList().isEmpty() && stateFlag) {
					if(gameFlag == SINGLE_LOSE) {
						break;
					}
				}
				notify();
				}
			}
		}
		
		// Stage9 Start Thread
		class Stage9_Monster extends Thread {
			private CheckGameState stateThread;
			
			public Stage9_Monster(CheckGameState t) {
				stateThread = t;
			}
			public void run() {
				synchronized(this) {
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
				while(!getMonsterList().isEmpty() && stateFlag) {
					if(gameFlag == SINGLE_LOSE) {
						break;
					}
				}
				notify();
				}
			}
		}
		
		// Stage10 Start Thread
		class Stage10_Monster extends Thread {
			private CheckGameState stateThread;
			
			public Stage10_Monster(CheckGameState t) {
				stateThread = t;
			}
			public void run() {
				synchronized(this) {
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
				while(!getMonsterList().isEmpty() && stateFlag) {
					if(gameFlag == SINGLE_LOSE) {
						break;
					}
				}
				notify();
				}
			}
		}
}
