package Control;

import java.net.*;
import java.io.*;
import View.*;
import com.google.gson.*;

// 클라이언트의 소켓 클래스
public class ClientSocket extends Thread{
	private static ClientSocket instance = null;
	private Socket socket;
	private String ip;
	private int port;
	private PrintWriter pw;
	private BufferedReader br;
	private ServerWriter sw = null;
	
	private Control_Manager control;
	private ViewManager ui;
	private Gson gson;
	
	private boolean clientFlag = true;
	// 소켓 생성 후 연결
	private ClientSocket() throws UnknownHostException, IOException{
		instance = this;
		gson = new Gson();
		control = Control_Manager.getInstance(null);
		ui = control.getUI();
		
		ip = ui.getClientPanel().getIPField().getText();
		port = Integer.parseInt(ui.getClientPanel().getPortField().getText());
		
		socket = new Socket(ip, port);
		
		pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		sw = ServerWriter.getInstance(pw);
		
		control.setGameFlag(Control_Manager.MULTI);
	}
	// 싱글톤 패턴의 클래스
	public static ClientSocket getInstance() throws UnknownHostException, IOException {
		if(instance == null) new ClientSocket();
		return instance;
	}
	
	// 소켓을 닫는 메소드
	public void closeClient() {
		clientFlag = false;
		try {
			br.close();
			sw.close();
			socket.close();
			instance = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		// 레이블 애니메이션 중지
		MatchingLabelThread.disableMatching();
		
		try {
			while(clientFlag) {
				System.out.println("client");
				String json = br.readLine();
				GsonInfo info = gson.fromJson(json, GsonInfo.class);
				
				Point start;
				MapMulti map = (MapMulti)control.getMapArray();	
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
					// 실제 좌표로 전환
					int x = start.getX();
					int y = start.getY();
					
					start.setX(y*Point.WIDTH);
					start.setY(x*Point.HEIGHT);
					// 몬스터의 스레드
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
					control.setGameFlag(Control_Manager.MULTI_WIN);
					closeClient();
				}
			}
		} catch(SocketException e) {
			control.setGameFlag(Control_Manager.MULTI_WIN);
			closeClient();
			e.printStackTrace();
		}catch (IOException e) {
			new ErrorDialog("Connection Error");
		
			control.setClient(null);
			closeClient();
			control.setGameFlag(Control_Manager.MAIN);
		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
}


