// This game was produced by Ahn & Joe Team.
// Tower Defense 1.0 Alpha
// This project is for everyone.
// When you use this code, you have to evidence the source.

package Control;

import javax.swing.*;
import java.util.*;
import View.*;
import Model.*;

public class Control_Manager {
	private static Control_Manager instance = null;
	final private ImageIcon MAP_SINGLE = new ImageIcon("Image/Map/map_background.png");
	
	private ViewManager ui;
	// ���� �����ϴ� �迭
	volatile private Map map = null;
	// ���͸� �����ϴ� ����Ʈ
	volatile private ArrayList<Monster> monsterList;
	// Ÿ���� �����ϴ� ����Ʈ
	volatile private ArrayList<Tower> towerList;
	// ������ ���¸� üũ�ϴ� �������� �÷���
	volatile private boolean stateFlag = true;
	
	
	CheckGameState stateThread;
	// ������ ���� ������ ���� �÷���
	volatile private int gameFlag = 0;
	
	// ����
	volatile private int score = 0;
	// �ڿ�
	volatile private int money = 0;
	// ȣ��Ʈ Ŭ����
	private MultiHost host = null;
	private ClientSocket client = null;
	
	
	// ������ ���¸� �����ϴ� ���
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
	public void setHost(MultiHost _host) {
		host = _host;
	}
	public MultiHost getHost() {
		return host;
	}
	public void setClient(ClientSocket _client) {
		client = _client;
	}
	public ClientSocket getClient() {
		return client;
	}
	
	public static void main(String[] args) {
		ViewManager ui = new ViewManager();
		Control_Manager.getInstance(ui);
	}
	
	public void addListener() {
		// ���� �г�
		ui.getMainPanel().getSingleLabel().addMouseListener(new SingleLabelActionListener());
		ui.getMainPanel().getMultiLabel().addMouseListener(new MultiLabelActionListener());
		ui.getMainPanel().getExitLabel().addMouseListener(new ExitLabelActionListener());
		ui.getMainPanel().getRankLabel().addMouseListener(new RankLabelActionListener());
		// �̱� �г�
		ui.getSinglePanel().getMapLabel().addMouseListener(new MapLabelListener());
		ui.getSinglePanel().getMapLabel().addMouseMotionListener(new MapLabelListener());
		ui.getSinglePanel().getTower0Btn().addActionListener(new Tower0BtnListener());
		ui.getSinglePanel().getTower1Btn().addActionListener(new Tower1BtnListener());
		ui.getSinglePanel().getTower2Btn().addActionListener(new Tower2BtnListener());
		ui.getSinglePanel().getTower3Btn().addActionListener(new Tower3BtnListener());
		ui.getSinglePanel().getTower4Btn().addActionListener(new Tower4BtnListener());
		ui.getSinglePanel().getTower5Btn().addActionListener(new Tower5BtnListener());
		
		// ȣ��Ʈ Ŭ���̾� ���� �г�
		ui.getSelectPanel().getHostLabel().addMouseListener(new SelectHostBtnMouseListener());
		ui.getSelectPanel().getClientLabel().addMouseListener(new SelectClientBtnMouseListener());
		ui.getSelectPanel().getCancelLabel().addMouseListener(new SelectCancelBtnMouseListener());
		
		// ȣ��Ʈ �г�
		ui.getHostPanel().getHostLabel().addMouseListener(new HostHostBtnMouseListener());
		ui.getHostPanel().getCancelLabel().addMouseListener(new HostCancelBtnMouseListener());
		
		// Ŭ���̾�Ʈ �г�
		ui.getClientPanel().getJoinLabel().addMouseListener(new ClientJoinBtnMouseListener());
		ui.getClientPanel().getCancelLabel().addMouseListener(new ClientCancelBtnMouseListener());
		
		// ��Ī �г�
		ui.getMatchPanel().getCancelLabel().addMouseListener(new MatchCancelBtnMouseListener());
		
		// �̱� �÷��� ��� �г�
		ui.getSingleResultPanel().getRegistLabel().addMouseListener(new SingleResultRegistBtnMouseListener());
		ui.getSingleResultPanel().getCancelLabel().addMouseListener(new SingleResultCancelBtnMouseListener());
		
		// ��Ƽ �г�
		ui.getMultiPanel().getMapLabel().addMouseListener(new MultiMapLabelListener());
		ui.getMultiPanel().getMapLabel().addMouseMotionListener(new MultiMapLabelListener());
		ui.getMultiPanel().getTower0Btn().addActionListener(new MultiTower0BtnListener());
		ui.getMultiPanel().getTower1Btn().addActionListener(new MultiTower1BtnListener());
		ui.getMultiPanel().getTower2Btn().addActionListener(new MultiTower2BtnListener());
		ui.getMultiPanel().getTower3Btn().addActionListener(new MultiTower3BtnListener());
		ui.getMultiPanel().getTower4Btn().addActionListener(new MultiTower4BtnListener());
		ui.getMultiPanel().getTower5Btn().addActionListener(new MultiTower5BtnListener());
		ui.getMultiPanel().getMonster0Btn().addActionListener(new MultiMonster0BtnListener());
		ui.getMultiPanel().getMonster1Btn().addActionListener(new MultiMonster1BtnListener());
		ui.getMultiPanel().getMonster2Btn().addActionListener(new MultiMonster2BtnListener());
		ui.getMultiPanel().getMonster3Btn().addActionListener(new MultiMonster3BtnListener());
		ui.getMultiPanel().getMonster4Btn().addActionListener(new MultiMonster4BtnListener());
		ui.getMultiPanel().getMonster5Btn().addActionListener(new MultiMonster5BtnListener());
		ui.getMultiPanel().getMonster6Btn().addActionListener(new MultiMonster6BtnListener());
		ui.getMultiPanel().getMonster7Btn().addActionListener(new MultiMonster7BtnListener());
		ui.getMultiPanel().getMonster8Btn().addActionListener(new MultiMonster8BtnListener());
		ui.getMultiPanel().getMonster9Btn().addActionListener(new MultiMonster9BtnListener());
		
		// ��Ƽ �¸� �г�
		ui.getWinPanel().getMenuLabel().addMouseListener(new MultiWinMenuMouseListener());
		ui.getLosePanel().getMenuLabel().addMouseListener(new MultiLoseMenuMouseListener());
		
		// ���� �г�
		ui.getRankPanel().getMenuLabel().addMouseListener(new RankPanelMenuMouseListener());
	}
	
	public static Control_Manager getInstance(ViewManager v) {
		if(instance == null) new Control_Manager(v);
		return instance;
	}
	
	// ������ ���¸� ����
	public void setGameFlag(int state) {
		gameFlag = state;
	}
	// ������ ���¸� ��ȯ
	public int getGameFlag() {
		return gameFlag;
	}
	
	public ArrayList<Monster> getMonsterList() {
		return monsterList;
	}
	
	public ArrayList<Tower> getTowerList() {
		return towerList;
	}
	
	// ������ �ڿ��� �����ϴ� �Լ�
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
		ui.getMultiPanel().getScoreField().setText(""+score);
	}
	public void setMoney(int _money) {
		money = _money;
		ui.getSinglePanel().getMoneyField().setText("" + money);
		ui.getMultiPanel().getMoneyField().setText("" + money);
	}
	
	public ViewManager getUI() {
		return ui;
	}
	public Map getMapArray() {
		return map;
	}
	
	// ������ ���¸� ���������� üũ�ϸ鼭 ���� ���¸� ��ȯ��Ű�� ������
		class CheckGameState extends Thread {
			final public static int STAGE1_NUM_MONSTER = 10;
			final public static int STAGE2_NUM_MONSTER = 20;
			final public static int STAGE3_NUM_MONSTER = 30;
			final public static int STAGE4_NUM_MONSTER = 40;
			final public static int STAGE5_NUM_MONSTER = 50;
			final public static int STAGE6_NUM_MONSTER = 50;
			final public static int STAGE7_NUM_MONSTER = 50;
			final public static int STAGE8_NUM_MONSTER = 50;
			final public static int STAGE9_NUM_MONSTER = 50;
			final public static int STAGE10_NUM_MONSTER = 50;
			
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
						// ���� ��
						ui.getSinglePanel().getMapLabel().removeAll();
						ui.getSinglePanel().getMapLabel().addMouseMotionListener(new MapLabelListener());
						MapLabelListener.select = MapLabelListener.NONE;
						ui.getSinglePanel().getMapLabel().setIcon(MAP_SINGLE);
						
						// ���� ������ ���� ���� �ӽ� ������ ����
						int tempScore = getScore();
						
						while(!monsterList.isEmpty()) {
							monsterList.get(monsterList.size() - 1).setMonsterFalse();
							monsterList.remove(monsterList.size() - 1);
						}
						while(!towerList.isEmpty()) {
							towerList.get(towerList.size() - 1).setTowerFalse();
							towerList.remove(towerList.size() - 1);
						}
						
						setScore(tempScore);
						
						if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
							gameFlag = STAGE2;
						}
					}
					// Stage2
					if(gameFlag == STAGE2 && stateFlag) {
						setMoney(500);
						
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
						
						// ���� ������ ���� ���� �ӽ� ������ ����
						int tempScore = getScore();
						
						while(!monsterList.isEmpty()) {
							monsterList.get(monsterList.size() - 1).setMonsterFalse();
							monsterList.remove(monsterList.size() - 1);
						}
						while(!towerList.isEmpty()) {
							towerList.get(towerList.size() - 1).setTowerFalse();
							towerList.remove(towerList.size() - 1);
						}
						setScore(tempScore);
						
						if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
							// ���� ��
							
							gameFlag = STAGE3;
						}
					}
					// Stage3
					if(gameFlag == STAGE3 && stateFlag) {
						setMoney(500);
						
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
						
						// ���� ������ ���� ���� �ӽ� ������ ����
						int tempScore = getScore();
						
						while(!monsterList.isEmpty()) {
							monsterList.get(monsterList.size() - 1).setMonsterFalse();
							monsterList.remove(monsterList.size() - 1);
						}
						while(!towerList.isEmpty()) {
							towerList.get(towerList.size() - 1).setTowerFalse();
							towerList.remove(towerList.size() - 1);
						}
						
						setScore(tempScore);
						
						if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
							// ���� ��

							gameFlag = STAGE4;
						}
					}
					
					// Stage4
					if(gameFlag == STAGE4 && stateFlag) {
						setMoney(500);
						
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
						
						// ���� ������ ���� ���� �ӽ� ������ ����
						int tempScore = getScore();
						
						while(!monsterList.isEmpty()) {
							monsterList.get(monsterList.size() - 1).setMonsterFalse();
							monsterList.remove(monsterList.size() - 1);
						}
						while(!towerList.isEmpty()) {
							towerList.get(towerList.size() - 1).setTowerFalse();
							towerList.remove(towerList.size() - 1);
						}
						
						setScore(tempScore);
						
						if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
							// ���� ��
							
							gameFlag = STAGE5;
						}
					}
					
					// Stage5
					if(gameFlag == STAGE5 && stateFlag) {
						setMoney(500);
						
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
						
						// ���� ������ ���� ���� �ӽ� ������ ����
						int tempScore = getScore();
						
						while(!monsterList.isEmpty()) {
							monsterList.get(monsterList.size() - 1).setMonsterFalse();
							monsterList.remove(monsterList.size() - 1);
						}
						while(!towerList.isEmpty()) {
							towerList.get(towerList.size() - 1).setTowerFalse();
							towerList.remove(towerList.size() - 1);
						}
						
						setScore(tempScore);
						
						if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
							// ���� ��
							
							gameFlag = STAGE6;
						}
					}
					// Stage6
					if(gameFlag == STAGE6 && stateFlag) {
						setMoney(500);
						
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
						
						// ���� ������ ���� ���� �ӽ� ������ ����
						int tempScore = getScore();
						
						while(!monsterList.isEmpty()) {
							monsterList.get(monsterList.size() - 1).setMonsterFalse();
							monsterList.remove(monsterList.size() - 1);
						}
						while(!towerList.isEmpty()) {
							towerList.get(towerList.size() - 1).setTowerFalse();
							towerList.remove(towerList.size() - 1);
						}
						
						setScore(tempScore);
						
						if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
							// ���� ��
					
							gameFlag = STAGE7;
						}
					}
					
					// Stage7
					if(gameFlag == STAGE7 && stateFlag) {
						setMoney(500);
						
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
						
						// ���� ������ ���� ���� �ӽ� ������ ����
						int tempScore = getScore();
						
						while(!monsterList.isEmpty()) {
							monsterList.get(monsterList.size() - 1).setMonsterFalse();
							monsterList.remove(monsterList.size() - 1);
						}
						while(!towerList.isEmpty()) {
							towerList.get(towerList.size() - 1).setTowerFalse();
							towerList.remove(towerList.size() - 1);
						}
						
						setScore(tempScore);
						
						if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
							// ���� ��
							
							gameFlag = STAGE8;
						}
					}
					
					// Stage8
					if(gameFlag == STAGE8 && stateFlag) {
						setMoney(500);
						
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
						
						// ���� ������ ���� ���� �ӽ� ������ ����
						int tempScore = getScore();
						
						while(!monsterList.isEmpty()) {
							monsterList.get(monsterList.size() - 1).setMonsterFalse();
							monsterList.remove(monsterList.size() - 1);
						}
						while(!towerList.isEmpty()) {
							towerList.get(towerList.size() - 1).setTowerFalse();
							towerList.remove(towerList.size() - 1);
						}
						
						setScore(tempScore);
						
						if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
							// ���� ��
							
							gameFlag = STAGE9;
						}
					}
					
					// Stage9
					if(gameFlag == STAGE9 && stateFlag) {
						setMoney(500);
						
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
						
						// ���� ������ ���� ���� �ӽ� ������ ����
						int tempScore = getScore();
						
						while(!monsterList.isEmpty()) {
							monsterList.get(monsterList.size() - 1).setMonsterFalse();
							monsterList.remove(monsterList.size() - 1);
						}
						while(!towerList.isEmpty()) {
							towerList.get(towerList.size() - 1).setTowerFalse();
							towerList.remove(towerList.size() - 1);
						}
						
						setScore(tempScore);
						
						if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
							// ���� ��
							
							gameFlag = STAGE10;
						}
					}
					
					// Stage10
					if(gameFlag == STAGE10 && stateFlag) {
						setMoney(500);
						
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
						
						// ���� ������ ���� ���� �ӽ� ������ ����
						int tempScore = getScore();
						
						while(!monsterList.isEmpty()) {
							monsterList.get(monsterList.size() - 1).setMonsterFalse();
							monsterList.remove(monsterList.size() - 1);
						}
						while(!towerList.isEmpty()) {
							towerList.get(towerList.size() - 1).setTowerFalse();
							towerList.remove(towerList.size() - 1);
						}
						
						setScore(tempScore);
						
						if(STAGE1 <= gameFlag && gameFlag <= STAGE10) {
							// ���� ��
							
							gameFlag = SINGLE_LOSE;
						}
					}
					
					// Single_lose
					if(gameFlag == SINGLE_LOSE && host == null && client == null && stateFlag) {
						gameFlag = MAIN;
						ui.getCard().show(ui.getContentPane(), "single_result");
						// DB�� ���� ���� ����Ʈ ����
						RankManager rankManager = new RankManager();
						ArrayList<UserList> userList = rankManager.getUserList();
						rankManager.closeDB();
						// ���� ����Ʈ ���� �������� �������� ����
						Collections.sort(userList);
						Collections.reverse(userList);
						
						// ������ ����Ʈ�� ������� ���� ������ ����� ���
						int rank = 1;
						
						while(!userList.isEmpty() && rank <= userList.size() && userList.get(rank - 1).getScore() > getScore()) {
							rank++;
						}
						// �̱� ��� �гο� ���� ���
						ui.getSingleResultPanel().getRankLabel().setText(rank + "��");
					}
					
					if(gameFlag == SINGLE_LOSE && (host != null || client != null) && stateFlag) {
						ServerWriter.getInstance(null).send(new GsonInfo(0, 0, GsonInfo.LOSE));
						ui.setSize(ViewManager.WIDTH, ViewManager.HEIGHT + 40);
						gameFlag = MULTI_LOSE;
					}
					
					// Multi
					if(gameFlag == MULTI && stateFlag) {
						// ��Ƽ�÷��� �� ui�� ����� 1360x680���� ��ȯ
						ui.setSize(ViewManager.WIDTH + 360, ViewManager.HEIGHT + 40);
						ui.getCard().show(ui.getContentPane(), "multi");
						setMoney(1500); setScore(0);
						
						MultiStage multiStage = new MultiStage(this);
						multiStage.start();
						
						synchronized(multiStage) {
							try {
								multiStage.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						ui.setSize(ViewManager.WIDTH, ViewManager.HEIGHT + 40);
						ui.getMultiPanel().getMapLabel().removeAll();
						ui.getMultiPanel().getMapLabel().addMouseMotionListener(new MultiMapLabelListener());
						
						int tempScore = getScore();
						
						while(!monsterList.isEmpty()) {
							monsterList.get(monsterList.size() - 1).setMonsterFalse();
							monsterList.remove(monsterList.size() - 1);
						}
						while(!towerList.isEmpty()) {
							towerList.get(towerList.size() - 1).setTowerFalse();
							towerList.remove(towerList.size() - 1);
						}
						
						setScore(tempScore);
					}
					
					if(gameFlag == MULTI_LOSE && stateFlag) {
						ui.setSize(ViewManager.WIDTH, ViewManager.HEIGHT + 40);
						ui.getCard().show(ui.getContentPane(), "multi_lose");
						
						if(host != null) {
							host.closeHost();
							host = null;
						}
						else if(client != null) {
							client.closeClient();
							client = null;
						}
						
						gameFlag = MAIN;
					}
					if(gameFlag == MULTI_WIN && stateFlag) {
						ui.setSize(ViewManager.WIDTH, ViewManager.HEIGHT + 40);
						ui.getCard().show(ui.getContentPane(), "multi_win");
						
						if(host != null) {
							host.closeHost();
							host = null;
						}
						else if(client != null) {
							client.closeClient();
							client = null;
						}
						
						gameFlag = MAIN;
					}
				}
			}
		}
		
		// MultiPlay Thread 
		class MultiStage extends Thread {
			private CheckGameState stateThread;
			
			public MultiStage(CheckGameState t) {
				stateThread = t;
			}
			
			public void run() {
				synchronized(this) {
					JLabel mapLabel = ui.getMultiPanel().getMapLabel();
					map = new MapMulti(mapLabel);
					Point[] startPos = new Point[4];
					startPos[0] = new Point(1, 0);
					startPos[1] = new Point(3, 0);
					startPos[2] = new Point(4, 0);
					startPos[3] = new Point(6, 0);
					// ��� ��ǥ�� ���� ��ǥ�� ��ȯ
					for(int i=0; i<startPos.length; i++) {
						int x = startPos[i].getX();
						int y = startPos[i].getY();
						startPos[i].setX(y*Point.WIDTH);
						startPos[i].setY(x*Point.HEIGHT);
					}
					int monsterStage = 0;
					int countMonster = 0;
					int sumCount = 0;
					Thread monsterThread;
					try {
						Thread.sleep(3000);
						while(gameFlag == MULTI && stateFlag) {
							sumCount++;
							if(sumCount == 100) {
								sumCount = 0;
							int i = (int)(Math.random()*4);
							
							
							if(monsterStage == 0) {
								countMonster++;
									Monster0 monster0 = new Monster0(startPos[i], map, mapLabel);
									monsterList.add(monster0);
									monsterThread = new Thread(monster0);
									monsterThread.start();
								
								if(countMonster == 10) {
									monsterStage = 1;
									countMonster = 0;
								}
							}
							else if(monsterStage == 1) {
								countMonster++;
									Monster1 monster1 = new Monster1(startPos[i], map, mapLabel);
									monsterList.add(monster1);
									monsterThread = new Thread(monster1);
									monsterThread.start();
								
								if(countMonster == 10) {
									monsterStage = 2;
									countMonster = 0;
								}
							}
							else if(monsterStage == 2) {
								countMonster++;
									Monster2 monster2 = new Monster2(startPos[i], map, mapLabel);
									monsterList.add(monster2);
									monsterThread = new Thread(monster2);
									monsterThread.start();
								
								if(countMonster == 10) {
									monsterStage = 3;
									countMonster = 0;
								}
							}
							else if(monsterStage == 3) {
								countMonster++;
									Monster3 monster3 = new Monster3(startPos[i], map, mapLabel);
									monsterList.add(monster3);
									monsterThread = new Thread(monster3);
									monsterThread.start();
								
								if(countMonster == 10) {
									monsterStage = 4;
									countMonster = 0;
								}
							}
							else if(monsterStage == 4) {
								countMonster++;
									Monster4 monster4 = new Monster4(startPos[i], map, mapLabel);
									monsterList.add(monster4);
									monsterThread = new Thread(monster4);
									monsterThread.start();
								if(countMonster == 10) {
									monsterStage = 5;
									countMonster = 0;
								}
							}
							else if(monsterStage == 5) {
								countMonster++;
									Monster5 monster5 = new Monster5(startPos[i], map, mapLabel);
									monsterList.add(monster5);
									monsterThread = new Thread(monster5);
									monsterThread.start();
								if(countMonster == 10) {
									monsterStage = 6;
									countMonster = 0;
								}
							}
							else if(monsterStage == 6) {
								countMonster++;
									Monster6 monster6 = new Monster6(startPos[i], map, mapLabel);
									monsterList.add(monster6);
									monsterThread = new Thread(monster6);
									monsterThread.start();
								
								if(countMonster == 10) {
									monsterStage = 7;
									countMonster = 0;
								}
							}
							else if(monsterStage == 7) {
								countMonster++;
									Monster7 monster7 = new Monster7(startPos[i], map, mapLabel);
									monsterList.add(monster7);
									monsterThread = new Thread(monster7);
									monsterThread.start();
								
								if(countMonster == 10) {
									monsterStage = 8;
									countMonster = 0;
								}
							}
							else if(monsterStage == 8) {
								countMonster++;
									Monster8 monster8 = new Monster8(startPos[i], map, mapLabel);
									monsterList.add(monster8);
									monsterThread = new Thread(monster8);
									monsterThread.start();
								
								if(countMonster == 10) {
									monsterStage = 9;
									countMonster = 0;
								}
							}
							else if(monsterStage == 9) {
									Monster9 monster9 = new Monster9(startPos[i], map, mapLabel);
									monsterList.add(monster9);
									monsterThread = new Thread(monster9);
									monsterThread.start();
							}
						}
							sleep(100);
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					notify();
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
				// Stage1�� ���� �ε�
				JLabel mapLabel = ui.getSinglePanel().getMapLabel();
				map = new MapArray1(mapLabel);
				// ���� ������ ����
				Point startPos = map.getStartPosition();
				startPos.setX(startPos.getX()*Point.WIDTH);
				startPos.setY(startPos.getY()*Point.HEIGHT);
				try {
					Thread.sleep(3000);	// ó�� 3�ʰ� ���
					for(int i=0; i<CheckGameState.STAGE1_NUM_MONSTER; i++) {
						
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						// �� 1.5�� ���� ���͸� ��ȯ
						Monster0 monster0 = new Monster0(startPos, map, mapLabel);
						Thread monsterThread = new Thread(monster0);
						monsterThread.start();
						sleep(1500);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// ���Ͱ� �� ���ŵɶ� ���� ���, �� �и� ����
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
				// Stage1�� ���� �ε�
				JLabel mapLabel = ui.getSinglePanel().getMapLabel();
				map = new MapArray1(mapLabel);
				// ���� ������ ����
				Point startPos = map.getStartPosition();
				startPos.setX(startPos.getX()*Point.WIDTH);
				startPos.setY(startPos.getY()*Point.HEIGHT);
				try {
					Thread.sleep(3000);	// ó�� 3�ʰ� ���
					for(int i=0; i<CheckGameState.STAGE2_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						// �� 1.5�� ���� ���͸� ��ȯ
						Monster0 monster0 = new Monster0(startPos, map, mapLabel);
						Thread monsterThread0 = new Thread(monster0);
						monsterThread0.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE2_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						// �� 1.5�� ���� ���͸� ��ȯ
						Monster1 monster1 = new Monster1(startPos, map, mapLabel);
						Thread monsterThread1 = new Thread(monster1);
						monsterThread1.start();
						sleep(1500);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// ���Ͱ� �� ���ŵɶ� ���� ���, �� �и� ����
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
				// Stage1�� ���� �ε�
				JLabel mapLabel = ui.getSinglePanel().getMapLabel();
				map = new MapArray1(mapLabel);
				// ���� ������ ����
				Point startPos = map.getStartPosition();
				startPos.setX(startPos.getX()*Point.WIDTH);
				startPos.setY(startPos.getY()*Point.HEIGHT);
				try {
					Thread.sleep(3000);	// ó�� 3�ʰ� ���
					for(int i=0; i<CheckGameState.STAGE3_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						// �� 1.5�� ���� ���͸� ��ȯ
						Monster0 monster0 = new Monster0(startPos, map, mapLabel);
						Thread monsterThread0 = new Thread(monster0);
						monsterThread0.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE3_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster1 monster1 = new Monster1(startPos, map, mapLabel);
						Thread monsterThread1 = new Thread(monster1);
						monsterThread1.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE3_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster2 monster2 = new Monster2(startPos, map, mapLabel);
						Thread monsterThread2 = new Thread(monster2);
						monsterThread2.start();
						sleep(1500);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// ���Ͱ� �� ���ŵɶ� ���� ���, �� �и� ����
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
				// Stage1�� ���� �ε�
				JLabel mapLabel = ui.getSinglePanel().getMapLabel();
				map = new MapArray1(mapLabel);
				// ���� ������ ����
				Point startPos = map.getStartPosition();
				startPos.setX(startPos.getX()*Point.WIDTH);
				startPos.setY(startPos.getY()*Point.HEIGHT);
				try {
					Thread.sleep(3000);	// ó�� 3�ʰ� ���
					for(int i=0; i<CheckGameState.STAGE4_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						// �� 1.5�� ���� ���͸� ��ȯ
						Monster0 monster0 = new Monster0(startPos, map, mapLabel);
						Thread monsterThread0 = new Thread(monster0);
						monsterThread0.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE4_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster1 monster1 = new Monster1(startPos, map, mapLabel);
						Thread monsterThread1 = new Thread(monster1);
						monsterThread1.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE4_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster2 monster2 = new Monster2(startPos, map, mapLabel);
						Thread monsterThread2 = new Thread(monster2);
						monsterThread2.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE4_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster3 monster3 = new Monster3(startPos, map, mapLabel);
						Thread monsterThread3 = new Thread(monster3);
						monsterThread3.start();
						sleep(1500);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// ���Ͱ� �� ���ŵɶ� ���� ���, �� �и� ����
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
				// Stage1�� ���� �ε�
				JLabel mapLabel = ui.getSinglePanel().getMapLabel();
				map = new MapArray1(mapLabel);
				// ���� ������ ����
				Point startPos = map.getStartPosition();
				startPos.setX(startPos.getX()*Point.WIDTH);
				startPos.setY(startPos.getY()*Point.HEIGHT);
				try {
					Thread.sleep(3000);	// ó�� 3�ʰ� ���
					for(int i=0; i<CheckGameState.STAGE5_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						// �� 1.5�� ���� ���͸� ��ȯ
						Monster0 monster0 = new Monster0(startPos, map, mapLabel);
						Thread monsterThread0 = new Thread(monster0);
						monsterThread0.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE5_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						// �� 1.5�� ���� ���͸� ��ȯ
						Monster1 monster1 = new Monster1(startPos, map, mapLabel);
						Thread monsterThread1 = new Thread(monster1);
						monsterThread1.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE5_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						// �� 1.5�� ���� ���͸� ��ȯ
						Monster2 monster2 = new Monster2(startPos, map, mapLabel);
						Thread monsterThread2 = new Thread(monster2);
						monsterThread2.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE5_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						// �� 1.5�� ���� ���͸� ��ȯ
						Monster3 monster3 = new Monster3(startPos, map, mapLabel);
						Thread monsterThread3 = new Thread(monster3);
						monsterThread3.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE5_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						// �� 1.5�� ���� ���͸� ��ȯ
						Monster4 monster4 = new Monster4(startPos, map, mapLabel);
						Thread monsterThread4 = new Thread(monster4);
						monsterThread4.start();
						sleep(1500);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// ���Ͱ� �� ���ŵɶ� ���� ���, �� �и� ����
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
				// Stage1�� ���� �ε�
				JLabel mapLabel = ui.getSinglePanel().getMapLabel();
				map = new MapArray1(mapLabel);
				// ���� ������ ����
				Point startPos = map.getStartPosition();
				startPos.setX(startPos.getX()*Point.WIDTH);
				startPos.setY(startPos.getY()*Point.HEIGHT);
				try {
					Thread.sleep(3000);	// ó�� 3�ʰ� ���
					for(int i=0; i<CheckGameState.STAGE6_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						// �� 1.5�� ���� ���͸� ��ȯ
						Monster0 monster0 = new Monster0(startPos, map, mapLabel);
						Thread monsterThread0 = new Thread(monster0);
						monsterThread0.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE6_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster1 monster1 = new Monster1(startPos, map, mapLabel);
						Thread monsterThread1 = new Thread(monster1);
						monsterThread1.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE6_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster2 monster2 = new Monster2(startPos, map, mapLabel);
						Thread monsterThread2 = new Thread(monster2);
						monsterThread2.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE6_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster3 monster3 = new Monster3(startPos, map, mapLabel);
						Thread monsterThread3 = new Thread(monster3);
						monsterThread3.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE6_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster4 monster4 = new Monster4(startPos, map, mapLabel);
						Thread monsterThread4 = new Thread(monster4);
						monsterThread4.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE6_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster5 monster5 = new Monster5(startPos, map, mapLabel);
						Thread monsterThread5 = new Thread(monster5);
						monsterThread5.start();
						sleep(1500);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// ���Ͱ� �� ���ŵɶ� ���� ���, �� �и� ����
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
				// Stage1�� ���� �ε�
				JLabel mapLabel = ui.getSinglePanel().getMapLabel();
				map = new MapArray1(mapLabel);
				// ���� ������ ����
				Point startPos = map.getStartPosition();
				startPos.setX(startPos.getX()*Point.WIDTH);
				startPos.setY(startPos.getY()*Point.HEIGHT);
				try {
					Thread.sleep(3000);	// ó�� 3�ʰ� ���
					for(int i=0; i<CheckGameState.STAGE7_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						// �� 1.5�� ���� ���͸� ��ȯ
						Monster0 monster0 = new Monster0(startPos, map, mapLabel);
						Thread monsterThread0 = new Thread(monster0);
						monsterThread0.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE7_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster1 monster1 = new Monster1(startPos, map, mapLabel);
						Thread monsterThread1 = new Thread(monster1);
						monsterThread1.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE7_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster2 monster2 = new Monster2(startPos, map, mapLabel);
						Thread monsterThread2 = new Thread(monster2);
						monsterThread2.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE7_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster3 monster3 = new Monster3(startPos, map, mapLabel);
						Thread monsterThread3 = new Thread(monster3);
						monsterThread3.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE7_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster4 monster4 = new Monster4(startPos, map, mapLabel);
						Thread monsterThread4 = new Thread(monster4);
						monsterThread4.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE7_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster5 monster5 = new Monster5(startPos, map, mapLabel);
						Thread monsterThread5 = new Thread(monster5);
						monsterThread5.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE7_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster6 monster6 = new Monster6(startPos, map, mapLabel);
						Thread monsterThread6 = new Thread(monster6);
						monsterThread6.start();
						sleep(1500);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// ���Ͱ� �� ���ŵɶ� ���� ���, �� �и� ����
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
				// Stage1�� ���� �ε�
				JLabel mapLabel = ui.getSinglePanel().getMapLabel();
				map = new MapArray1(mapLabel);
				// ���� ������ ����
				Point startPos = map.getStartPosition();
				startPos.setX(startPos.getX()*Point.WIDTH);
				startPos.setY(startPos.getY()*Point.HEIGHT);
				try {
					Thread.sleep(3000);	// ó�� 3�ʰ� ���
					for(int i=0; i<CheckGameState.STAGE8_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						// �� 1.5�� ���� ���͸� ��ȯ
						Monster0 monster0 = new Monster0(startPos, map, mapLabel);
						Thread monsterThread0 = new Thread(monster0);
						monsterThread0.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE8_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster1 monster1 = new Monster1(startPos, map, mapLabel);
						Thread monsterThread1 = new Thread(monster1);
						monsterThread1.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE8_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster2 monster2 = new Monster2(startPos, map, mapLabel);
						Thread monsterThread2 = new Thread(monster2);
						monsterThread2.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE8_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster3 monster3 = new Monster3(startPos, map, mapLabel);
						Thread monsterThread3 = new Thread(monster3);
						monsterThread3.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE8_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster4 monster4 = new Monster4(startPos, map, mapLabel);
						Thread monsterThread4 = new Thread(monster4);
						monsterThread4.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE8_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster5 monster5 = new Monster5(startPos, map, mapLabel);
						Thread monsterThread5 = new Thread(monster5);
						monsterThread5.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE8_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster6 monster6 = new Monster6(startPos, map, mapLabel);
						Thread monsterThread6 = new Thread(monster6);
						monsterThread6.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE8_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster7 monster7 = new Monster7(startPos, map, mapLabel);
						Thread monsterThread7 = new Thread(monster7);
						monsterThread7.start();
						sleep(1500);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// ���Ͱ� �� ���ŵɶ� ���� ���, �� �и� ����
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
				// Stage1�� ���� �ε�
				JLabel mapLabel = ui.getSinglePanel().getMapLabel();
				map = new MapArray1(mapLabel);
				// ���� ������ ����
				Point startPos = map.getStartPosition();
				startPos.setX(startPos.getX()*Point.WIDTH);
				startPos.setY(startPos.getY()*Point.HEIGHT);
				try {
					Thread.sleep(3000);	// ó�� 3�ʰ� ���
					for(int i=0; i<CheckGameState.STAGE9_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						// �� 1.5�� ���� ���͸� ��ȯ
						Monster0 monster0 = new Monster0(startPos, map, mapLabel);
						Thread monsterThread0 = new Thread(monster0);
						monsterThread0.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE9_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster1 monster1 = new Monster1(startPos, map, mapLabel);
						Thread monsterThread1 = new Thread(monster1);
						monsterThread1.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE9_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster2 monster2 = new Monster2(startPos, map, mapLabel);
						Thread monsterThread2 = new Thread(monster2);
						monsterThread2.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE9_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster3 monster3 = new Monster3(startPos, map, mapLabel);
						Thread monsterThread3 = new Thread(monster3);
						monsterThread3.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE9_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster4 monster4 = new Monster4(startPos, map, mapLabel);
						Thread monsterThread4 = new Thread(monster4);
						monsterThread4.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE9_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster5 monster5 = new Monster5(startPos, map, mapLabel);
						Thread monsterThread5 = new Thread(monster5);
						monsterThread5.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE9_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster6 monster6 = new Monster6(startPos, map, mapLabel);
						Thread monsterThread6 = new Thread(monster6);
						monsterThread6.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE9_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster7 monster7 = new Monster7(startPos, map, mapLabel);
						Thread monsterThread7 = new Thread(monster7);
						monsterThread7.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE9_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster8 monster8 = new Monster8(startPos, map, mapLabel);
						Thread monsterThread8 = new Thread(monster8);
						monsterThread8.start();
						sleep(1500);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// ���Ͱ� �� ���ŵɶ� ���� ���, �� �и� ����
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
				// Stage1�� ���� �ε�
				JLabel mapLabel = ui.getSinglePanel().getMapLabel();
				map = new MapArray1(mapLabel);
				// ���� ������ ����
				Point startPos = map.getStartPosition();
				startPos.setX(startPos.getX()*Point.WIDTH);
				startPos.setY(startPos.getY()*Point.HEIGHT);
				try {
					Thread.sleep(3000);	// ó�� 3�ʰ� ���
					for(int i=0; i<CheckGameState.STAGE10_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						// �� 1.5�� ���� ���͸� ��ȯ
						Monster0 monster0 = new Monster0(startPos, map, mapLabel);
						Thread monsterThread0 = new Thread(monster0);
						monsterThread0.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE10_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster1 monster1 = new Monster1(startPos, map, mapLabel);
						Thread monsterThread1 = new Thread(monster1);
						monsterThread1.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE10_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster2 monster2 = new Monster2(startPos, map, mapLabel);
						Thread monsterThread2 = new Thread(monster2);
						monsterThread2.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE10_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster3 monster3 = new Monster3(startPos, map, mapLabel);
						Thread monsterThread3 = new Thread(monster3);
						monsterThread3.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE10_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster4 monster4 = new Monster4(startPos, map, mapLabel);
						Thread monsterThread4 = new Thread(monster4);
						monsterThread4.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE10_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster5 monster5 = new Monster5(startPos, map, mapLabel);
						Thread monsterThread5 = new Thread(monster5);
						monsterThread5.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE10_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster6 monster6 = new Monster6(startPos, map, mapLabel);
						Thread monsterThread6 = new Thread(monster6);
						monsterThread6.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE10_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster7 monster7 = new Monster7(startPos, map, mapLabel);
						Thread monsterThread7 = new Thread(monster7);
						monsterThread7.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE10_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster8 monster8 = new Monster8(startPos, map, mapLabel);
						Thread monsterThread8 = new Thread(monster8);
						monsterThread8.start();
						sleep(1500);
					}
					for(int i=0; i<CheckGameState.STAGE10_NUM_MONSTER; i++) {
						if(getGameFlag() == SINGLE_LOSE) // ������ ���� ���
							break;
						Monster9 monster9 = new Monster9(startPos, map, mapLabel);
						Thread monsterThread9 = new Thread(monster9);
						monsterThread9.start();
						sleep(1500);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// ���Ͱ� �� ���ŵɶ� ���� ���, �� �и� ����
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
