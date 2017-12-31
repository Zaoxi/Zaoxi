package Control;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

// �� ��Ļ󿡼� ���콺 Ŀ���� ����
public class MapLabelListener extends MouseAdapter {
	
	final private ImageIcon focusImg = new ImageIcon("Image/Map/map_focus.png");
	private JLabel focusLabel;
	private JLabel mapLabel;
	private Point curPos;
	private Map map;
	private boolean cursorFlag = true;
	private Control_Manager control;
	
	// Ÿ���� �������� ��, �� Ÿ���� ������ ��� ����
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
	
	
	public MapLabelListener() {
		Control_Manager control = Control_Manager.getInstance(null);
		if(control.getGameFlag() >= Control_Manager.STAGE1 && Control_Manager.STAGE10 >= control.getGameFlag())
			mapLabel = control.getUI().getSinglePanel().getMapLabel();
		else if(control.getGameFlag() == Control_Manager.MULTI) 
			mapLabel = control.getUI().getMultiPanel().getMapLabel();
		
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
		Point pos = new Point(e.getX()/Point.WIDTH, e.getY()/Point.HEIGHT);
		
		if(select == NONE) {	// �ƹ��͵� ���õ��� �ʾ�����, �� ���̺� ���� Ÿ���� �����ϴ� ��츸 ����
			if(map.getMap()[pos.getX()][pos.getY()].isTower()) {
				ArrayList<Tower> towerList = control.getTowerList();
				
				for(int i=0; i<towerList.size(); i++) {
					Point towerPos = towerList.get(i).getMapPosition();
					
					if(towerPos.getX() == pos.getX() && towerPos.getY() == pos.getY()) {
						select = SELECT;
						prevTower = towerList.get(i);
					}
						
				}
			}
		}
		else if(!map.getMap()[pos.getX()][pos.getY()].isRoad() && !map.getMap()[pos.getX()][pos.getY()].isTower()) {
			if(select == TOWER0) { // Ÿ��0
				if(control.getMoney() >= Tower0.COST) {
					control.setMoney(control.getMoney() - Tower0.COST);
					Tower0 tower = new Tower0(new Point(pos.getX()*Point.WIDTH, pos.getY()*Point.HEIGHT), map, mapLabel);
					ArrayList<Tower> towerList = control.getTowerList();
					towerList.add(tower);
					Thread towerThread = new Thread(tower);
					towerThread.start();
				}
				else
					select = NONE;
			}
			else if(select == TOWER1) { // Ÿ��1
				if(control.getMoney() >= Tower1.COST) {
					control.setMoney(control.getMoney() - Tower1.COST);
					Tower1 tower = new Tower1(new Point(pos.getX()*Point.WIDTH, pos.getY()*Point.HEIGHT), map, mapLabel);
					ArrayList<Tower> towerList = control.getTowerList();
					towerList.add(tower);
					Thread towerThread = new Thread(tower);
					towerThread.start();
				}
				else
					select = NONE;
			}
			else if(select == TOWER2) { // Ÿ��2
				if(control.getMoney() >= Tower2.COST) {
					control.setMoney(control.getMoney() - Tower2.COST);
					Tower2 tower = new Tower2(new Point(pos.getX()*Point.WIDTH, pos.getY()*Point.HEIGHT), map, mapLabel);
					ArrayList<Tower> towerList = control.getTowerList();
					towerList.add(tower);
					Thread towerThread = new Thread(tower);
					towerThread.start();
				}
				else
					select = NONE;
			}
			else if(select == TOWER3) {	// Ÿ��3
				if(control.getMoney() >= Tower3.COST) {
					control.setMoney(control.getMoney() - Tower3.COST);
					Tower3 tower = new Tower3(new Point(pos.getX()*Point.WIDTH, pos.getY()*Point.HEIGHT), map, mapLabel);
					ArrayList<Tower> towerList = control.getTowerList();
					towerList.add(tower);
					Thread towerThread = new Thread(tower);
					towerThread.start();
				}
				else
					select = NONE;
			}
			else if(select == TOWER4) {	// Ÿ��4
				if(control.getMoney() >= Tower4.COST) {
					control.setMoney(control.getMoney() - Tower4.COST);
					Tower4 tower = new Tower4(new Point(pos.getX()*Point.WIDTH, pos.getY()*Point.HEIGHT), map, mapLabel);
					ArrayList<Tower> towerList = control.getTowerList();
					towerList.add(tower);
					Thread towerThread = new Thread(tower);
					towerThread.start();
				}
				else
					select = NONE;
			}
			else if(select == TOWER5) {	// Ÿ��5
				if(control.getMoney() >= Tower5.COST) {
					control.setMoney(control.getMoney() - Tower5.COST);
					Tower5 tower = new Tower5(new Point(pos.getX()*Point.WIDTH, pos.getY()*Point.HEIGHT), map, mapLabel);
					ArrayList<Tower> towerList = control.getTowerList();
					towerList.add(tower);
					Thread towerThread = new Thread(tower);
					towerThread.start();
				}
				else
					select = NONE;
			}
		}
		else if(select == SELECT) {	// �� ���̺� ���� Ÿ���� �������� ���
			if(pos.getX() == prevTower.getMapPosition().getX() && pos.getY() == prevTower.getMapPosition().getY()) { // Ÿ���� �ٽ� Ŭ������ ���
				prevTower.setAttackPosition(null);
			}
			else if(pos.getX() >= prevTower.getMapPosition().getX() - 1 && pos.getX() <= prevTower.getMapPosition().getX() + 1) {	// ��ȿ�� ���� ���� Ŭ�� ���� ���
				if(pos.getY() >= prevTower.getMapPosition().getY() - 1 && pos.getY() <= prevTower.getMapPosition().getY() + 1) {
					prevTower.setAttackPosition(new Point(pos.getX(), pos.getY()));
				}
			}
			select = NONE;
		}
	}
}
