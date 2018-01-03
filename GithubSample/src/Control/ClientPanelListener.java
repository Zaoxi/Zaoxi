package Control;

import javax.swing.*;
import View.ViewManager;
import java.awt.event.*;

class ClientJoinBtnMouseListener extends MouseAdapter {
	private Control_Manager control;
	private ViewManager ui;
	private JLabel joinLabel;
	
	final private ImageIcon FOCUS_BUTTON = new ImageIcon("Image/Label/pressed_button.png");
	final private ImageIcon BUTTON = new ImageIcon("Image/Label/button.png");
	
	public ClientJoinBtnMouseListener() {
		control = Control_Manager.getInstance(null);
		ui = control.getUI();
		joinLabel = ui.getClientPanel().getJoinLabel();
	}
	
	// ��ư �̹��� ��ȯ �̺�Ʈ
	public void mouseEntered(MouseEvent e) {
		joinLabel.setIcon(FOCUS_BUTTON);
	}
	
	public void mouseExited(MouseEvent e) {
		joinLabel.setIcon(BUTTON);
	}
	
	// �г� ��ȯ �̺�Ʈ
	public void mouseClicked(MouseEvent e) {
		ui.getCard().show(ui.getContentPane(), "match");
		MatchingLabelThread animation = new MatchingLabelThread();
		animation.start();
		/*
		 * ���� ���� �߰� �ڵ� �ʿ��� �κ�
		 */
		
	}
}

class ClientCancelBtnMouseListener extends MouseAdapter {
	private Control_Manager control;
	private ViewManager ui;
	private JLabel cancelLabel;
	
	final private ImageIcon FOCUS_BUTTON = new ImageIcon("Image/Label/pressed_button.png");
	final private ImageIcon BUTTON = new ImageIcon("Image/Label/button.png");
	
	public ClientCancelBtnMouseListener() {
		control = Control_Manager.getInstance(null);
		ui = control.getUI();
		cancelLabel = ui.getClientPanel().getCancelLabel();
	}
	
	// ��ư �̹��� ��ȯ �̺�Ʈ
	public void mouseEntered(MouseEvent e) {
		cancelLabel.setIcon(FOCUS_BUTTON);
	}
	
	public void mouseExited(MouseEvent e) {
		cancelLabel.setIcon(BUTTON);
	}
	
	// �г� ��ȯ �̺�Ʈ
	public void mouseClicked(MouseEvent e) {
		ui.getCard().show(ui.getContentPane(), "match");
		/*
		 * ���� ���� �߰� �ڵ� �ʿ��� �κ�
		 */
		
	}
}