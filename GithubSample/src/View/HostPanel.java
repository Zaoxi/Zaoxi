package View;

import javax.swing.*;
import java.awt.*;

public class HostPanel extends JPanel {
	private JLabel background;
	private JLabel nameLabel;
	private JLabel portLabel;
	private JTextField nameField;
	private JTextField portField;
	private JLabel hostBtn;
	private JLabel cancelBtn;
	
	final private ImageIcon BACKGROUND = new ImageIcon("Image/Label/common_background.png");
	final private ImageIcon BUTTON = new ImageIcon("Image/Label/button.png");
	
	public HostPanel() {
		setSize(ViewManager.WIDTH, ViewManager.HEIGHT);
		setLayout(new CardLayout());
		
		// 컴포넌트 생성
		background = new JLabel(BACKGROUND);
		nameLabel = new JLabel("Name : ");
		portLabel = new JLabel("Port : ");
		nameField = new JTextField("User" + (int)(Math.random()*10000));
		portField = new JTextField("8888");
		hostBtn = new JLabel(BUTTON);
		cancelBtn = new JLabel(BUTTON);
		JLabel host = new JLabel("Host");
		JLabel cancel = new JLabel("Cancel");
		
		// 컴포넌트 조정
		background.setSize(1000, 640);
		background.setLayout(new GridLayout(3, 2, 30, 30));
		nameLabel.setFont(new Font("Name", Font.BOLD, 50));
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		portLabel.setFont(new Font("Host", Font.BOLD, 50));
		portLabel.setHorizontalAlignment(SwingConstants.CENTER);
		host.setFont(new Font("Host", Font.BOLD, 30));
		host.setHorizontalAlignment(SwingConstants.CENTER);
		cancel.setFont(new Font("Cancel", Font.BOLD, 30));
		cancel.setHorizontalAlignment(SwingConstants.CENTER);
		nameField.setFont(new Font("", Font.BOLD, 30));
		portField.setFont(new Font("", Font.BOLD, 30));
		
		hostBtn.setLayout(new CardLayout());
		hostBtn.setSize(MainPanel.BTN_WIDTH, MainPanel.BTN_HEIGHT);
		cancelBtn.setLayout(new CardLayout());
		cancelBtn.setSize(MainPanel.BTN_WIDTH, MainPanel.BTN_HEIGHT);
		hostBtn.add(host);
		cancelBtn.add(cancel);
		
		background.add(nameLabel);
		background.add(nameField);
		background.add(portLabel);
		background.add(portField);
		background.add(hostBtn);
		background.add(cancelBtn);
		add(background);
		
		setVisible(true);
	}
	
	public JTextField getNameField() {
		return nameField;
	}
	public JTextField getPortField() {
		return portField;
	}
	public JLabel getHostLabel() {
		return hostBtn;
	}
	public JLabel getCancelLabel() {
		return cancelBtn;
	}
}
