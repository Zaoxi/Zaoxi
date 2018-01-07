package Control;
import java.awt.event.*;
import javax.swing.*;
import View.ViewManager;

// ȣ��Ʈ, Ŭ���̾�Ʈ ���� �гο� ���� ������
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
	
	// ��ư �̹��� ��ȯ �̺�Ʈ
	public void mouseEntered(MouseEvent e) {
		hostLabel.setIcon(FOCUS_BUTTON);
	}
	
	public void mouseExited(MouseEvent e) {
		hostLabel.setIcon(BUTTON);
	}
	
	// �г� ��ȯ �̺�Ʈ
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
	
	// ��ư �̹��� ��ȯ �̺�Ʈ
	public void mouseEntered(MouseEvent e) {
		clientLabel.setIcon(FOCUS_BUTTON);
	}
	
	public void mouseExited(MouseEvent e) {
		clientLabel.setIcon(BUTTON);
	}
	
	// �г� ��ȯ �̺�Ʈ
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
