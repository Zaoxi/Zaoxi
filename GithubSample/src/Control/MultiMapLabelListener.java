package Control;

import javax.swing.*;

import Control.Map;

import java.awt.event.*;
import java.util.*;


public class MultiMapLabelListener extends MouseAdapter {
	final private ImageIcon focusImg = new ImageIcon("Image/Map/map_focus.png");
	private JLabel focusLabel;
	private JLabel mapLabel;
	private Point curPos;
	private Map map;
	private boolean cursorFlag = true;
	private Control_Manager control;
	
	// 타워를 선택했을 때, 그 타워의 정보를 담는 변수
	private Tower prevTower;
	
	public static int select = 0;
	final public static int NONE = 0;
	final public static int TOWER0 = 1;
	final public static int TOWER1 = 2;
	final public static int TOWER2 = 3;
	final public static int TOWER3 = 4;
	final public static int TOWER4 = 5;
	final public static int TOWER5 = 6;
	final public static int SELECT = 7;
	final public static int MONSTER0 = 8;
	final public static int MONSTER1 = 9;
	final public static int MONSTER2 = 10;
	final public static int MONSTER3 = 11;
	final public static int MONSTER4 = 12;
	final public static int MONSTER5 = 13;
	final public static int MONSTER6 = 14;
	final public static int MONSTER7 = 15;
	final public static int MONSTER8 = 16;
	final public static int MONSTER9 = 17;
	
	public MultiMapLabelListener() {
		control = Control_Manager.getInstance(null);
//		if(control.getGameFlag() >= Control_Manager.STAGE1 && Control_Manager.STAGE10 >= control.getGameFlag())
			mapLabel = control.getUI().getSinglePanel().getMapLabel();
//		else if(control.getGameFlag() == Control_Manager.MULTI) 
//			mapLabel = control.getUI().getMultiPanel().getMapLabel();
		
		focusLabel = new JLabel(focusImg);
		curPos = new Point(0, 0);
		map = control.getMapArray();
		
		mapLabel.add(focusLabel);
		focusLabel.setVisible(false);
		control = Control_Manager.getInstance(null);
	}

	// mouseMotionListern
	public void mouseMoved(MouseEvent e) {
		focusLabel.setVisible(true);
		curPos.setX(e.getX()/Point.WIDTH * Point.WIDTH);
		curPos.setY(e.getY()/Point.HEIGHT * Point.HEIGHT);
		
		focusLabel.setBounds(curPos.getX(), curPos.getY(), Point.WIDTH, Point.HEIGHT);
	}
	// mouseListener
	public void mouseExited(MouseEvent e) {
		focusLabel.setVisible(false);
		cursorFlag = false;
	}
	
	public void mouseClicked(MouseEvent e) {
		map = control.getMapArray();
		Point pos = new Point(e.getY()/Point.HEIGHT, e.getX()/Point.WIDTH);
		
		if(select == NONE) {	// 아무것도 선택되지 않았을때, 맵 레이블 상의 타워를 선택하는 경우만 존재
			if(map.getMap()[pos.getX()][pos.getY()].isTower()) {
				ArrayList<Tower> towerList = control.getTowerList();
				
				for(int i=0; i<towerList.size(); i++) {
					Point towerPos = towerList.get(i).getMapPosition();
					
					if(towerPos.getX() == pos.getX() && towerPos.getY() == pos.getY()) {
						select = SELECT;
						prevTower = towerList.get(i);
						System.out.println("select" + prevTower);
					}
					
				}
			}
		}
		else if(!map.getMap()[pos.getX()][pos.getY()].isRoad() && !map.getMap()[pos.getX()][pos.getY()].isTower()) {
			if(select == TOWER0) { // 타워0
				if(control.getMoney() >= Tower0.COST) {
					control.setMoney(control.getMoney() - Tower0.COST);
					Tower0 tower = new Tower0(new Point(pos.getY()*Point.WIDTH, pos.getX()*Point.HEIGHT), map, mapLabel);
					ArrayList<Tower> towerList = control.getTowerList();
					towerList.add(tower);
					Thread towerThread = new Thread(tower);
					towerThread.start();
				}
				
			}
			else if(select == TOWER1) { // 타워1
				if(control.getMoney() >= Tower1.COST) {
					control.setMoney(control.getMoney() - Tower1.COST);
					Tower1 tower = new Tower1(new Point(pos.getY()*Point.WIDTH, pos.getX()*Point.HEIGHT), map, mapLabel);
					ArrayList<Tower> towerList = control.getTowerList();
					towerList.add(tower);
					Thread towerThread = new Thread(tower);
					towerThread.start();
				}
				
			}
			else if(select == TOWER2) { // 타워2
				if(control.getMoney() >= Tower2.COST) {
					control.setMoney(control.getMoney() - Tower2.COST);
					Tower2 tower = new Tower2(new Point(pos.getY()*Point.WIDTH, pos.getX()*Point.HEIGHT), map, mapLabel);
					ArrayList<Tower> towerList = control.getTowerList();
					towerList.add(tower);
					Thread towerThread = new Thread(tower);
					towerThread.start();
				}
				
			}
			else if(select == TOWER3) {	// 타워3
				if(control.getMoney() >= Tower3.COST) {
					control.setMoney(control.getMoney() - Tower3.COST);
					Tower3 tower = new Tower3(new Point(pos.getY()*Point.WIDTH, pos.getX()*Point.HEIGHT), map, mapLabel);
					ArrayList<Tower> towerList = control.getTowerList();
					towerList.add(tower);
					Thread towerThread = new Thread(tower);
					towerThread.start();
				}
				
			}
			else if(select == TOWER4) {	// 타워4
				if(control.getMoney() >= Tower4.COST) {
					control.setMoney(control.getMoney() - Tower4.COST);
					Tower4 tower = new Tower4(new Point(pos.getY()*Point.WIDTH, pos.getX()*Point.HEIGHT), map, mapLabel);
					ArrayList<Tower> towerList = control.getTowerList();
					towerList.add(tower);
					Thread towerThread = new Thread(tower);
					towerThread.start();
				}
				
			}
			else if(select == TOWER5) {	// 타워5
				if(control.getMoney() >= Tower5.COST) {
					control.setMoney(control.getMoney() - Tower5.COST);
					Tower5 tower = new Tower5(new Point(pos.getY()*Point.WIDTH, pos.getX()*Point.HEIGHT), map, mapLabel);
					ArrayList<Tower> towerList = control.getTowerList();
					towerList.add(tower);
					Thread towerThread = new Thread(tower);
					towerThread.start();
				}
				
			}
		}
		else if(select == SELECT) {	// 맵 레이블 상의 타워를 선택했을 경우
			if(pos.getX() == prevTower.getMapPosition().getX() && pos.getY() == prevTower.getMapPosition().getY()) { // 타워를 다시 클릭했을 경우
				prevTower.setAttackPosition(null);
			}
			else if(pos.getX() >= prevTower.getMapPosition().getX() - 1 && pos.getX() <= prevTower.getMapPosition().getX() + 1) {	// 유효한 범위 내를 클릭 했을 경우
				if(pos.getY() >= prevTower.getMapPosition().getY() - 1 && pos.getY() <= prevTower.getMapPosition().getY() + 1) {
					prevTower.setAttackPosition(new Point(pos.getX(), pos.getY()));
					System.out.println("(" + pos.getX() + ", " + pos.getY() + ")");
				}
			}
		}
		else if(select == MONSTER0) {
			if(control.getMoney() >= Monster0.COST) {
				control.setMoney(control.getMoney() - Monster0.COST);
				ServerWriter sw = ServerWriter.getInstance(null);
				MapMulti multiMap = (MapMulti)map;
				GsonInfo info;
				if(pos.getX() == GsonInfo.FIRST) {
					info = new GsonInfo(GsonInfo.FIRST, GsonInfo.MONSTER0, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.SECOND) {
					info = new GsonInfo(GsonInfo.SECOND, GsonInfo.MONSTER0, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.THIRD) {
					info = new GsonInfo(GsonInfo.THIRD, GsonInfo.MONSTER0, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.FOURTH) {
					info = new GsonInfo(GsonInfo.FOURTH, GsonInfo.MONSTER0, GsonInfo.MONSTER);
					sw.send(info);
				}
			}
		}
		else if(select == MONSTER1) {
			if(control.getMoney() >= Monster1.COST) {
				control.setMoney(control.getMoney() - Monster1.COST);
				ServerWriter sw = ServerWriter.getInstance(null);
				MapMulti multiMap = (MapMulti)map;
				GsonInfo info;
				if(pos.getX() == GsonInfo.FIRST) {
					info = new GsonInfo(GsonInfo.FIRST, GsonInfo.MONSTER1, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.SECOND) {
					info = new GsonInfo(GsonInfo.SECOND, GsonInfo.MONSTER1, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.THIRD) {
					info = new GsonInfo(GsonInfo.THIRD, GsonInfo.MONSTER1, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.FOURTH) {
					info = new GsonInfo(GsonInfo.FOURTH, GsonInfo.MONSTER1, GsonInfo.MONSTER);
					sw.send(info);
				}
			}
		}
		else if(select == MONSTER2) {
			if(control.getMoney() >= Monster2.COST) {
				control.setMoney(control.getMoney() - Monster2.COST);
				ServerWriter sw = ServerWriter.getInstance(null);
				MapMulti multiMap = (MapMulti)map;
				GsonInfo info;
				if(pos.getX() == GsonInfo.FIRST) {
					info = new GsonInfo(GsonInfo.FIRST, GsonInfo.MONSTER2, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.SECOND) {
					info = new GsonInfo(GsonInfo.SECOND, GsonInfo.MONSTER2, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.THIRD) {
					info = new GsonInfo(GsonInfo.THIRD, GsonInfo.MONSTER2, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.FOURTH) {
					info = new GsonInfo(GsonInfo.FOURTH, GsonInfo.MONSTER2, GsonInfo.MONSTER);
					sw.send(info);
				}
			}
		}
		else if(select == MONSTER3) {
			if(control.getMoney() >= Monster3.COST) {
				control.setMoney(control.getMoney() - Monster3.COST);
				ServerWriter sw = ServerWriter.getInstance(null);
				MapMulti multiMap = (MapMulti)map;
				GsonInfo info;
				if(pos.getX() == GsonInfo.FIRST) {
					info = new GsonInfo(GsonInfo.FIRST, GsonInfo.MONSTER3, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.SECOND) {
					info = new GsonInfo(GsonInfo.SECOND, GsonInfo.MONSTER3, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.THIRD) {
					info = new GsonInfo(GsonInfo.THIRD, GsonInfo.MONSTER3, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.FOURTH) {
					info = new GsonInfo(GsonInfo.FOURTH, GsonInfo.MONSTER3, GsonInfo.MONSTER);
					sw.send(info);
				}
			}
		}
		else if(select == MONSTER4) {
			if(control.getMoney() >= Monster4.COST) {
				control.setMoney(control.getMoney() - Monster4.COST);
				ServerWriter sw = ServerWriter.getInstance(null);
				MapMulti multiMap = (MapMulti)map;
				GsonInfo info;
				if(pos.getX() == GsonInfo.FIRST) {
					info = new GsonInfo(GsonInfo.FIRST, GsonInfo.MONSTER4, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.SECOND) {
					info = new GsonInfo(GsonInfo.SECOND, GsonInfo.MONSTER4, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.THIRD) {
					info = new GsonInfo(GsonInfo.THIRD, GsonInfo.MONSTER4, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.FOURTH) {
					info = new GsonInfo(GsonInfo.FOURTH, GsonInfo.MONSTER4, GsonInfo.MONSTER);
					sw.send(info);
				}
			}
		}
		else if(select == MONSTER5) {
			if(control.getMoney() >= Monster5.COST) {
				control.setMoney(control.getMoney() - Monster5.COST);
				ServerWriter sw = ServerWriter.getInstance(null);
				MapMulti multiMap = (MapMulti)map;
				GsonInfo info;
				if(pos.getX() == GsonInfo.FIRST) {
					info = new GsonInfo(GsonInfo.FIRST, GsonInfo.MONSTER5, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.SECOND) {
					info = new GsonInfo(GsonInfo.SECOND, GsonInfo.MONSTER5, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.THIRD) {
					info = new GsonInfo(GsonInfo.THIRD, GsonInfo.MONSTER5, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.FOURTH) {
					info = new GsonInfo(GsonInfo.FOURTH, GsonInfo.MONSTER5, GsonInfo.MONSTER);
					sw.send(info);
				}
			}
		}
		else if(select == MONSTER6) {
			if(control.getMoney() >= Monster6.COST) {
				control.setMoney(control.getMoney() - Monster6.COST);
				ServerWriter sw = ServerWriter.getInstance(null);
				MapMulti multiMap = (MapMulti)map;
				GsonInfo info;
				if(pos.getX() == GsonInfo.FIRST) {
					info = new GsonInfo(GsonInfo.FIRST, GsonInfo.MONSTER6, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.SECOND) {
					info = new GsonInfo(GsonInfo.SECOND, GsonInfo.MONSTER6, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.THIRD) {
					info = new GsonInfo(GsonInfo.THIRD, GsonInfo.MONSTER6, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.FOURTH) {
					info = new GsonInfo(GsonInfo.FOURTH, GsonInfo.MONSTER6, GsonInfo.MONSTER);
					sw.send(info);
				}
			}
		}
		else if(select == MONSTER7) {
			if(control.getMoney() >= Monster7.COST) {
				control.setMoney(control.getMoney() - Monster7.COST);
				ServerWriter sw = ServerWriter.getInstance(null);
				MapMulti multiMap = (MapMulti)map;
				GsonInfo info;
				if(pos.getX() == GsonInfo.FIRST) {
					info = new GsonInfo(GsonInfo.FIRST, GsonInfo.MONSTER7, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.SECOND) {
					info = new GsonInfo(GsonInfo.SECOND, GsonInfo.MONSTER7, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.THIRD) {
					info = new GsonInfo(GsonInfo.THIRD, GsonInfo.MONSTER7, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.FOURTH) {
					info = new GsonInfo(GsonInfo.FOURTH, GsonInfo.MONSTER7, GsonInfo.MONSTER);
					sw.send(info);
				}
			}
		}
		else if(select == MONSTER8) {
			if(control.getMoney() >= Monster8.COST) {
				control.setMoney(control.getMoney() - Monster8.COST);
				ServerWriter sw = ServerWriter.getInstance(null);
				MapMulti multiMap = (MapMulti)map;
				GsonInfo info;
				if(pos.getX() == GsonInfo.FIRST) {
					info = new GsonInfo(GsonInfo.FIRST, GsonInfo.MONSTER8, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.SECOND) {
					info = new GsonInfo(GsonInfo.SECOND, GsonInfo.MONSTER8, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.THIRD) {
					info = new GsonInfo(GsonInfo.THIRD, GsonInfo.MONSTER8, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.FOURTH) {
					info = new GsonInfo(GsonInfo.FOURTH, GsonInfo.MONSTER8, GsonInfo.MONSTER);
					sw.send(info);
				}
			}
		}
		else if(select == MONSTER9) {
			if(control.getMoney() >= Monster9.COST) {
				control.setMoney(control.getMoney() - Monster9.COST);
				ServerWriter sw = ServerWriter.getInstance(null);
				MapMulti multiMap = (MapMulti)map;
				GsonInfo info;
				if(pos.getX() == GsonInfo.FIRST) {
					info = new GsonInfo(GsonInfo.FIRST, GsonInfo.MONSTER9, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.SECOND) {
					info = new GsonInfo(GsonInfo.SECOND, GsonInfo.MONSTER9, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.THIRD) {
					info = new GsonInfo(GsonInfo.THIRD, GsonInfo.MONSTER9, GsonInfo.MONSTER);
					sw.send(info);
				}
				else if(pos.getX() == GsonInfo.FOURTH) {
					info = new GsonInfo(GsonInfo.FOURTH, GsonInfo.MONSTER9, GsonInfo.MONSTER);
					sw.send(info);
				}
			}
		}
		
		
		select = NONE;
		TowerListener.selectFlag = false;
	}
	
}
