package Control;

import java.awt.event.*;
import javax.swing.*;

import View.ViewManager;


class RankPanelMenuMouseListener extends MouseAdapter{
	private Control_Manager control;
	private ViewManager ui;
	private JLabel menuLabel;
	
	final private ImageIcon FOCUS_BUTTON = new ImageIcon("Image/Label/pressed_button.png");
	final private ImageIcon BUTTON = new ImageIcon("Image/Label/button.png");
	
	public RankPanelMenuMouseListener() {
		control = Control_Manager.getInstance(null);
		ui = control.getUI();
		menuLabel = ui.getRankPanel().getMenuLabel();
	}
	
	// ��ư �̹��� ��ȯ �̺�Ʈ
	public void mouseEntered(MouseEvent e) {
		menuLabel.setIcon(FOCUS_BUTTON);
	}
	
	public void mouseExited(MouseEvent e) {
		menuLabel.setIcon(BUTTON);
	}
	
	// �г� ��ȯ �̺�Ʈ
	public void mouseClicked(MouseEvent e) {
		ui.getCard().show(ui.getContentPane(), "main");
	}
}