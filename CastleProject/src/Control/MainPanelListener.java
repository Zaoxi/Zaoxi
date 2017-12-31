package Control;
import java.awt.event.*;
import javax.swing.*;
import View.UIManager;


class SingleLabelActionListener extends MouseAdapter {
	private UIManager ui;
	private Control_Manager control;
	final private ImageIcon entered = new ImageIcon("Image/Label/pressed_button.png");
	final private ImageIcon exited = new ImageIcon("Image/Label/button.png");
	private JLabel singleLabel;
	public SingleLabelActionListener(UIManager v, Control_Manager c) {
		ui = v;
		singleLabel = ui.getMainPanel().getSingleLabel();
		control = c;
	}
	public void mouseEntered(MouseEvent e) {
		singleLabel.setIcon(entered);
	}
	
	public void mouseExited(MouseEvent e) {
		singleLabel.setIcon(exited);
	}
	public void mouseClicked(MouseEvent e) {
		MainPanel main = ui.getMainPanel();
		SinglePanel single = ui.getSinglePanel();
		
		main.setVisible(false);
		single.setVisible(true);
		control.setGameFlag(Control_Manager.STAGE1);
	}
}

class MultiLabelActionListener extends MouseAdapter {
	private UIManager ui;
	private Control_Manager control;
	final private ImageIcon entered = new ImageIcon("Image/Label/pressed_button.png");
	final private ImageIcon exited = new ImageIcon("Image/Label/button.png");
	private JLabel multiLabel;
	public MultiLabelActionListener(UIManager v, Control_Manager c) {
		ui = v;
		multiLabel = ui.getMainPanel().getMultiLabel();
		control = c;
	}
	public void mouseEntered(MouseEvent e) {
		multiLabel.setIcon(entered);
	}
	
	public void mouseExited(MouseEvent e) {
		multiLabel.setIcon(exited);
	}
	public void mouseClicked(MouseEvent e) {
		MainPanel main = ui.getMainPanel();
		MultiPanel multi = ui.getMultiPanel();
		
		main.setVisible(false);
		multi.setVisible(true);	// 싱글 게임 시작
		control.setGameFlag(Control_Manager.STAGE1);
	}
}

class ExitLabelActionListener extends MouseAdapter {
	private UIManager ui;
	private Control_Manager control;
	final private ImageIcon entered = new ImageIcon("Image/Label/pressed_button.png");
	final private ImageIcon exited = new ImageIcon("Image/Label/button.png");
	private JLabel exitLabel;
	public ExitLabelActionListener(UIManager v, Control_Manager c) {
		ui = v;
		exitLabel = ui.getMainPanel().getMultiLabel();
		control = c;
	}
	public void mouseEntered(MouseEvent e) {
		exitLabel.setIcon(entered);
	}
	
	public void mouseExited(MouseEvent e) {
		exitLabel.setIcon(exited);
	}
	public void mouseClicked(MouseEvent e) {
		control.setStateFlag(false);
		System.exit(0);	// 게임종료
	}
}