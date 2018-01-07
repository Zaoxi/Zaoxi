package Control;

import javax.swing.*;
import View.ViewManager;
import java.awt.event.*;
import java.io.IOException;
import View.*;

// Host�гο��� Host��ư ������
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
	
	// ��ư �̹��� ��ȯ �̺�Ʈ
	public void mouseEntered(MouseEvent e) {
		hostLabel.setIcon(FOCUS_BUTTON);
	}
	
	public void mouseExited(MouseEvent e) {
		hostLabel.setIcon(BUTTON);
	}
	
	// �г� ��ȯ �̺�Ʈ
	public void mouseClicked(MouseEvent e) {
		ui.getCard().show(ui.getContentPane(), "match");
		MatchingLabelThread animation = new MatchingLabelThread();
		animation.start();
		
		try {
			control.setHost(MultiHost.getInstance());
			control.getHost().start();
		} catch (NumberFormatException | IOException e1) {
			// TODO Auto-generated catch block
			new ErrorDialog("���� ���� ����!");
			e1.printStackTrace();
		}
		/*
		 * ���� ���� �߰� �ڵ� �ʿ��� �κ�
		 */
		
	}
}

// Host �гο��� Cancel ��ư ������
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
	}
}