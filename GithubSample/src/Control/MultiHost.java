package Control;

import java.net.*;
import java.io.*;
import View.*;
import com.google.gson.*;

// Host로 멀티플레이 서버 생성시 만들어지는 클래스
public class MultiHost extends Thread {
	private static MultiHost instance = null;
	// 출력과 입
	private ServerSocket server;
	private Socket socket;
	private PrintWriter pr;
	private BufferedReader br;
	
	private Control_Manager control;
	private ViewManager ui;
	private ServerWriter sw = null;
	private MapMulti map;
	
	private Gson gson;
	private boolean serverFlag = true;
	
	private MultiHost() throws NumberFormatException, IOException {
		instance = this;
		serverFlag = true;
		control = Control_Manager.getInstance(null);
		ui = control.getUI();
		gson = new Gson();
		sw = null;
		// 서버 생성
		server = new ServerSocket(Integer.parseInt(ui.getHostPanel().getPortField().getText()));
		
	}
	
	public static MultiHost getInstance() throws NumberFormatException, IOException {
		if(instance == null) new MultiHost();
		return instance;
	}
	
	public void closeHost() {
		instance = null;
		serverFlag = false;
		try {
			socket.close();
			
			if(sw != null) {
				sw.close();
				sw = null;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		try {
			socket = server.accept();
			// 서버로 accept 신호가 들어오면 멀티 플레이 시작
			ui.getCard().show(ui.getContentPane(), "multi");
			// 레이블 애니메이션 중지
			MatchingLabelThread.disableMatching();
			// 입력 출력 스트림 생성
			pr = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// 출력 스레드 생성
			sw = ServerWriter.getInstance(pr);
			map = (MapMulti)control.getMapArray();
			while(serverFlag) {
				String json = br.readLine();
				GsonInfo info = gson.fromJson(json, GsonInfo.class);
				
				Point start;
				if(info.getType().equals(GsonInfo.MONSTER)) {
					if(info.getLine() == GsonInfo.FIRST) {
						start = map.getFirstStart();
					}
					else if(info.getLine() == GsonInfo.SECOND) {
						start = map.getSecondStart();
					}
					else if(info.getLine() == GsonInfo.THIRD) {
						start = map.getThirdStart();
					}
					else  { // GsonInfo.FOURTH
						start = map.getFourthStart();
					}
					
					Thread monsterThread;
					
					switch(info.getMonster()) {
					case GsonInfo.MONSTER0:
						Monster0 monster0 = new Monster0(start, map, ui.getMultiPanel().getMapLabel());
						control.getMonsterList().add(monster0);
						monsterThread = new Thread(monster0);
						monsterThread.start();
						break;
					case GsonInfo.MONSTER1:
						Monster1 monster1 = new Monster1(start, map, ui.getMultiPanel().getMapLabel());
						control.getMonsterList().add(monster1);
						monsterThread = new Thread(monster1);
						monsterThread.start();
						break;
					case GsonInfo.MONSTER2:
						Monster2 monster2 = new Monster2(start, map, ui.getMultiPanel().getMapLabel());
						control.getMonsterList().add(monster2);
						monsterThread = new Thread(monster2);
						monsterThread.start();
						break;
					case GsonInfo.MONSTER3:
						Monster3 monster3 = new Monster3(start, map, ui.getMultiPanel().getMapLabel());
						control.getMonsterList().add(monster3);
						monsterThread = new Thread(monster3);
						monsterThread.start();
						break;
					case GsonInfo.MONSTER4:
						Monster4 monster4 = new Monster4(start, map, ui.getMultiPanel().getMapLabel());
						control.getMonsterList().add(monster4);
						monsterThread = new Thread(monster4);
						monsterThread.start();
						break;
					case GsonInfo.MONSTER5:
						Monster5 monster5 = new Monster5(start, map, ui.getMultiPanel().getMapLabel());
						control.getMonsterList().add(monster5);
						monsterThread = new Thread(monster5);
						monsterThread.start();
						break;
					case GsonInfo.MONSTER6:
						Monster6 monster6 = new Monster6(start, map, ui.getMultiPanel().getMapLabel());
						control.getMonsterList().add(monster6);
						monsterThread = new Thread(monster6);
						monsterThread.start();
						break;
					case GsonInfo.MONSTER7:
						Monster7 monster7 = new Monster7(start, map, ui.getMultiPanel().getMapLabel());
						control.getMonsterList().add(monster7);
						monsterThread = new Thread(monster7);
						monsterThread.start();
						break;
					case GsonInfo.MONSTER8:
						Monster8 monster8 = new Monster8(start, map, ui.getMultiPanel().getMapLabel());
						control.getMonsterList().add(monster8);
						monsterThread = new Thread(monster8);
						monsterThread.start();
						break;
					case GsonInfo.MONSTER9:
						Monster9 monster9 = new Monster9(start, map, ui.getMultiPanel().getMapLabel());
						control.getMonsterList().add(monster9);
						monsterThread = new Thread(monster9);
						monsterThread.start();
						break;
					}
				}
				else if(info.getType().equals(GsonInfo.LOSE)) {
					
				
				/*
				 * 멀티플레이 관련 코드를
				 * 삽입해야되는 부분
				 */
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
}
