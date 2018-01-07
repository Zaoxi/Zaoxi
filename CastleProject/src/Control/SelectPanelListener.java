package Control;
import java.awt.event.*;
import javax.swing.*;
import View.ViewManager;

// 호스트, 클라이언트 선택 패널에 대한 리스너
class SelectHostBtnMouseListener extends MouseAdapter {
	private Control_Manager control;
	private ViewManager ui;
	private JLabel hostLabel;
	
	final private ImageIcon FOCUS_BUTTON = new ImageIcon("Image/Label/pressed_button.png");
	final private ImageIcon BUTTON = new ImageIcon("Image/Label/button.png");
	
	public SelectHostBtnMouseListener() {
		control = Control_Manager.getInstance(null);
		ui = control.getUI();
		hostLabel = ui.getSelectPanel().getHostLabel();
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
		ui.getCard().show(ui.getContentPane(), "host");
	}
}

class SelectClientBtnMouseListener extends MouseAdapter {
	private Control_Manager control;
	private ViewManager ui;
	private JLabel clientLabel;
	
	final private ImageIcon FOCUS_BUTTON = new ImageIcon("Image/Label/pressed_button.png");
	final private ImageIcon BUTTON = new ImageIcon("Image/Label/button.png");
	
	public SelectClientBtnMouseListener() {
		control = Control_Manager.getInstance(null);
		ui = control.getUI();
		clientLabel = ui.getSelectPanel().getClientLabel();
	}
	
	// 버튼 이미지 전환 이벤트
	public void mouseEntered(MouseEvent e) {
		clientLabel.setIcon(FOCUS_BUTTON);
	}
	
	public void mouseExited(MouseEvent e) {
		clientLabel.setIcon(BUTTON);
	}
	
	// 패널 전환 이벤트
	public void mouseClicked(MouseEvent e) {
		ui.getCard().show(ui.getContentPane(), "client");
	}
}


class SelectCancelBtnMouseListener extends MouseAdapter {
	private Control_Manager control;
	private ViewManager ui;
	private JLabel cancelLabel;
	
	final private ImageIcon FOCUS_BUTTON = new ImageIcon("Image/Label/pressed_button.png");
	final private ImageIcon BUTTON = new ImageIcon("Image/Label/button.png");
	
	public SelectCancelBtnMouseListener() {
		control = Control_Manager.getInstance(null);
		ui = control.getUI();
		cancelLabel = ui.getSelectPanel().getCancelLabel();
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
