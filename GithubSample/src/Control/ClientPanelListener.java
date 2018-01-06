package Control;

import javax.swing.*;
import View.ViewManager;
import java.awt.event.*;
import java.io.IOException;
import View.*;

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
	
	// 버튼 이미지 전환 이벤트
	public void mouseEntered(MouseEvent e) {
		joinLabel.setIcon(FOCUS_BUTTON);
	}
	
	public void mouseExited(MouseEvent e) {
		joinLabel.setIcon(BUTTON);
	}
	
	// 패널 전환 이벤트
	public void mouseClicked(MouseEvent e) {
		ui.getCard().show(ui.getContentPane(), "match");
		MatchingLabelThread animation = new MatchingLabelThread();
		animation.start();
		
		try {
			control.setClient(ClientSocket.getInstance());
			
			control.getClient().start();
			
			control.setGameFlag(Control_Manager.MULTI);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			new ErrorDialog("Connection Error");
			e1.printStackTrace();
		}
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
	
	// 버튼 이미지 전환 이벤트
	public void mouseEntered(MouseEvent e) {
		cancelLabel.setIcon(FOCUS_BUTTON);
	}
	
	public void mouseExited(MouseEvent e) {
		cancelLabel.setIcon(BUTTON);
	}
	
	// 패널 전환 이벤트
	public void mouseClicked(MouseEvent e) {
		ui.getCard().show(ui.getContentPane(), "main");
		
	}
}