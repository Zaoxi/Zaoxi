package Control;

import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import Model.RankManager;
import java.awt.*;
import java.util.*;
import View.ErrorDialog;
import View.ViewManager;
import Model.*;

// 싱글버튼 리스너
class SingleLabelActionListener extends MouseAdapter {
	private ViewManager ui;
	private Control_Manager control;
	final private ImageIcon entered = new ImageIcon("Image/Label/pressed_button.png");
	final private ImageIcon exited = new ImageIcon("Image/Label/button.png");
	private JLabel singleLabel;
	public SingleLabelActionListener() {
		control = Control_Manager.getInstance(null);
		ui = control.getUI();
		singleLabel = ui.getMainPanel().getSingleLabel();
		
	}
	public void mouseEntered(MouseEvent e) {
		singleLabel.setIcon(entered);
	}
	
	public void mouseExited(MouseEvent e) {
		singleLabel.setIcon(exited);
	}
	public void mouseClicked(MouseEvent e) {
		Container c = ui.getContentPane();
		ui.getCard().show(c, "single");
		
		control.setGameFlag(Control_Manager.STAGE1);
	}
}
// 멀티버튼 리스너
class MultiLabelActionListener extends MouseAdapter {
	private ViewManager ui;
	private Control_Manager control;
	final private ImageIcon entered = new ImageIcon("Image/Label/pressed_button.png");
	final private ImageIcon exited = new ImageIcon("Image/Label/button.png");
	private JLabel multiLabel;
	public MultiLabelActionListener() {
		control = Control_Manager.getInstance(null);
		ui = control.getUI();
		multiLabel = ui.getMainPanel().getMultiLabel();
	}
	public void mouseEntered(MouseEvent e) {
		multiLabel.setIcon(entered);
	}
	
	public void mouseExited(MouseEvent e) {
		multiLabel.setIcon(exited);
	}
	public void mouseClicked(MouseEvent e) {
		Container c = ui.getContentPane();
		ui.getCard().show(c, "select");
	}
}
// 랭킹 버튼 리스너
class RankLabelActionListener extends MouseAdapter {
	private ViewManager ui;
	private Control_Manager control;
	final private ImageIcon entered = new ImageIcon("Image/Label/pressed_button.png");
	final private ImageIcon exited = new ImageIcon("Image/Label/button.png");
	private JLabel rankLabel;
	public RankLabelActionListener() {
		control = Control_Manager.getInstance(null);
		ui = control.getUI();
		rankLabel = ui.getMainPanel().getRankLabel();
	}
	public void mouseEntered(MouseEvent e) {
		rankLabel.setIcon(entered);
	}
	
	public void mouseExited(MouseEvent e) {
		rankLabel.setIcon(exited);
	}
	// DB와 연결하여 유저 정보 갱신
	public void mouseClicked(MouseEvent e) {
		// DB와 연결하여 유저 리스트를 갱신하고 오름차순으로 정렬 후 10위 까지만 레이블에 출력한다.
		RankManager rankManager = new RankManager();
		ArrayList<UserList> userList = rankManager.getUserList();
		rankManager.closeDB();
		
		Collections.sort(userList);
		Collections.reverse(userList);
		
		JLabel[][] userLabels = ui.getRankPanel().getUserLabel();
		
		for(int i=0; i<userLabels.length; i++) {
			userLabels[i][0].setText(userList.get(i).getName());
			userLabels[i][1].setText("" + userList.get(i).getScore());
			if(userList.size() - 1 == i)
				break;
		}
		
		Container c = ui.getContentPane();
		ui.getCard().show(c, "rank");
	}
}


// 나가기 버튼 리스너
class ExitLabelActionListener extends MouseAdapter {
	private ViewManager ui;
	private Control_Manager control;
	final private ImageIcon entered = new ImageIcon("Image/Label/pressed_button.png");
	final private ImageIcon exited = new ImageIcon("Image/Label/button.png");
	private JLabel exitLabel;
	public ExitLabelActionListener() {
		control = Control_Manager.getInstance(null);
		ui = control.getUI();
		exitLabel = ui.getMainPanel().getExitLabel();
	}
	public void mouseEntered(MouseEvent e) {
		exitLabel.setIcon(entered);
	}
	
	public void mouseExited(MouseEvent e) {
		exitLabel.setIcon(exited);
	}
	public void mouseClicked(MouseEvent e) {
		control.setStateFlag(false);
		System.exit(0);	// 게임종료
	}
}