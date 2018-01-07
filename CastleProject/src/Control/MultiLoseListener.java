package Control;

import javax.swing.*;
import View.ViewManager;
import java.awt.event.*;

// 멀티 플레이 패배 화면에서 menu 버튼 리스너
class MultiLoseMenuMouseListener extends MouseAdapter {
	private Control_Manager control;
	private ViewManager ui;
	private JLabel menuLabel;
	
	final private ImageIcon FOCUS_BUTTON = new ImageIcon("Image/Label/pressed_button.png");
	final private ImageIcon BUTTON = new ImageIcon("Image/Label/button.png");
	
	public MultiLoseMenuMouseListener() {
		control = Control_Manager.getInstance(null);
		ui = control.getUI();
		menuLabel = ui.getLosePanel().getMenuLabel();
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