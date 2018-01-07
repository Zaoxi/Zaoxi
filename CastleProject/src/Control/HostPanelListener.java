package Control;

import javax.swing.*;
import View.ViewManager;
import java.awt.event.*;
import java.io.IOException;
import View.*;

// Host패널에서 Host버튼 리스너
class HostHostBtnMouseListener extends MouseAdapter {
	private Control_Manager control;
	private ViewManager ui;
	private JLabel hostLabel;
	
	final private ImageIcon FOCUS_BUTTON = new ImageIcon("Image/Label/pressed_button.png");
	final private ImageIcon BUTTON = new ImageIcon("Image/Label/button.png");
	
	public HostHostBtnMouseListener() {
		control = Control_Manager.getInstance(null);
		ui = control.getUI();
		hostLabel = ui.getHostPanel().getHostLabel();
	}
	
	// 버튼 이미지 전환 이벤트
	public void mouseEntered(MouseEvent e) {
		hostLabel.setIcon(FOCUS_BUTTON);
	}
	
	public void mouseExited(MouseEvent e) {
		hostLabel.setIcon(BUTTON);
	}
	
	// 패널 전환 이벤트
	public void mouseClicked(MouseEvent e) {
		ui.getCard().show(ui.getContentPane(), "match");
		MatchingLabelThread animation = new MatchingLabelThread();
		animation.start();
		
		try {
			control.setHost(MultiHost.getInstance());
			control.getHost().start();
		} catch (NumberFormatException | IOException e1) {
			// TODO Auto-generated catch block
			new ErrorDialog("서버 생성 에러!");
			e1.printStackTrace();
		}
		/*
		 * 서버 관련 추가 코딩 필요한 부분
		 */
		
	}
}

// Host 패널에서 Cancel 버튼 리스너
class HostCancelBtnMouseListener extends MouseAdapter {
	private Control_Manager control;
	private ViewManager ui;
	private JLabel cancelLabel;
	
	final private ImageIcon FOCUS_BUTTON = new ImageIcon("Image/Label/pressed_button.png");
	final private ImageIcon BUTTON = new ImageIcon("Image/Label/button.png");
	
	public HostCancelBtnMouseListener() {
		control = Control_Manager.getInstance(null);
		ui = control.getUI();
		cancelLabel = ui.getHostPanel().getCancelLabel();
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