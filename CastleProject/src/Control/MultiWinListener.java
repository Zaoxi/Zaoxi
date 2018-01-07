package Control;

import javax.swing.*;
import View.ViewManager;
import java.awt.event.*;

// 멀티플레이 승리화면 menu버튼 리스너
class MultiWinMenuMouseListener extends MouseAdapter {
	private Control_Manager control;
	private ViewManager ui;
	private JLabel menuLabel;
	
	final private ImageIcon FOCUS_BUTTON = new ImageIcon("Image/Label/pressed_button.png");
	final private ImageIcon BUTTON = new ImageIcon("Image/Label/button.png");
	
	public MultiWinMenuMouseListener() {
		control = Control_Manager.getInstance(null);
		ui = control.getUI();
		menuLabel = ui.getWinPanel().getMenuLabel();
	}
	
	// 버튼 이미지 전환 이벤트
	public void mouseEntered(MouseEvent e) {
		menuLabel.setIcon(FOCUS_BUTTON);
	}
	
	public void mouseExited(MouseEvent e) {
		menuLabel.setIcon(BUTTON);
	}
	
	// 패널 전환 이벤트
	public void mouseClicked(MouseEvent e) {
		ui.getCard().show(ui.getContentPane(), "main");
	}
}