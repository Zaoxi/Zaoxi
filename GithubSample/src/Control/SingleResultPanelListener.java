package Control;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

import View.*;
import Model.*;

class SingleResultRegistBtnMouseListener extends MouseAdapter {
	private Control_Manager control;
	private ViewManager ui;
	private JLabel registLabel;
	
	final private ImageIcon FOCUS_BUTTON = new ImageIcon("Image/Label/pressed_button.png");
	final private ImageIcon BUTTON = new ImageIcon("Image/Label/button.png");
	
	public SingleResultRegistBtnMouseListener() {
		control = Control_Manager.getInstance(null);
		ui = control.getUI();
		registLabel = ui.getSingleResultPanel().getRegistLabel();
	}
	
	// ��ư �̹��� ��ȯ �̺�Ʈ
	public void mouseEntered(MouseEvent e) {
		registLabel.setIcon(FOCUS_BUTTON);
	}
	
	public void mouseExited(MouseEvent e) {
		registLabel.setIcon(BUTTON);
	}
	
	// �г� ��ȯ �̺�Ʈ
	public void mouseClicked(MouseEvent e) {
		JTextField nameField = ui.getSingleResultPanel().getNameField();
		
		if(nameField.getText().equals("")) {
			nameField.setText("User" + (int)(Math.random()*10000));
			return;
		}
		
		// DB ����
		RankManager rankManager = new RankManager();
		try {
			rankManager.registUser(nameField.getText(), control.getScore());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			new ErrorDialog("DB Connection Error!");
			return;
		}
		rankManager.closeDB();
		/*
		 * DB ���� �߰� �ڵ� �ʿ��� �κ�
		 */
		ui.getCard().show(ui.getContentPane(), "main");
	}
}

class SingleResultCancelBtnMouseListener extends MouseAdapter {
	private Control_Manager control;
	private ViewManager ui;
	private JLabel cancelLabel;
	
	final private ImageIcon FOCUS_BUTTON = new ImageIcon("Image/Label/pressed_button.png");
	final private ImageIcon BUTTON = new ImageIcon("Image/Label/button.png");
	
	public SingleResultCancelBtnMouseListener() {
		control = Control_Manager.getInstance(null);
		ui = control.getUI();
		cancelLabel = ui.getSingleResultPanel().getCancelLabel();
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
		ui.getCard().show(ui.getContentPane(), "main");
		control.setScore(0);
	}
}