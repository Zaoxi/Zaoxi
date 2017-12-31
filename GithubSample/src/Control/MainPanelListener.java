package Control;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import View.ViewManager;

// 싱글버튼 리스너
class SingleLabelActionListener extends MouseAdapter {
	private ViewManager ui;
	private Control_Manager control;
	final private ImageIcon entered = new ImageIcon("Image/Label/pressed_button.png");
	final private ImageIcon exited = new ImageIcon("Image/Label/button.png");
	private JLabel singleLabel;
	public SingleLabelActionListener() {
		control = Control_Manager.getInstance(null);
		ui = control.getUI();
		singleLabel = ui.getMainPanel().getSingleLabel();
		
	}
	public void mouseEntered(MouseEvent e) {
		singleLabel.setIcon(entered);
	}
	
	public void mouseExited(MouseEvent e) {
		singleLabel.setIcon(exited);
	}
	public void mouseClicked(MouseEvent e) {
		Container c = ui.getContentPane();
		((CardLayout)ui.getLayout()).show(c, "single");
		
		control.setGameFlag(Control_Manager.STAGE1);
	}
}
// 멀티버튼 리스너
class MultiLabelActionListener extends MouseAdapter {
	private ViewManager ui;
	private Control_Manager control;
	final private ImageIcon entered = new ImageIcon("Image/Label/pressed_button.png");
	final private ImageIcon exited = new ImageIcon("Image/Label/button.png");
	private JLabel multiLabel;
	public MultiLabelActionListener() {
		control = Control_Manager.getInstance(null);
		ui = control.getUI();
		multiLabel = ui.getMainPanel().getMultiLabel();
	}
	public void mouseEntered(MouseEvent e) {
		multiLabel.setIcon(entered);
	}
	
	public void mouseExited(MouseEvent e) {
		multiLabel.setIcon(exited);
	}
	public void mouseClicked(MouseEvent e) {
		Container c = ui.getContentPane();
		((CardLayout)ui.getLayout()).show(c, "multi");
		
		control.setGameFlag(Control_Manager.STAGE1);
		
		control.setGameFlag(Control_Manager.MULTI);
	}
}
// 나가기 버튼 리스너
class ExitLabelActionListener extends MouseAdapter {
	private ViewManager ui;
	private Control_Manager control;
	final private ImageIcon entered = new ImageIcon("Image/Label/pressed_button.png");
	final private ImageIcon exited = new ImageIcon("Image/Label/button.png");
	private JLabel exitLabel;
	public ExitLabelActionListener() {
		control = Control_Manager.getInstance(null);
		ui = control.getUI();
		exitLabel = ui.getMainPanel().getMultiLabel();
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