package View;

import javax.swing.*;
import java.awt.*;

// 2018-01-04 조희재 구현
//2018-01-06 안종희 개선 - 각종 폰트 이미지 추가
// HostClientSelect 패널에서 Host버튼 클릭시 출력
// Port 번호와 유저 이름을 입력하는 패널
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
	final private ImageIcon NAME = new ImageIcon("Image/Label/Namebig.png");
	final private ImageIcon PORT = new ImageIcon("Image/Label/Portbig.png");
	
	public HostPanel() {
		setSize(ViewManager.WIDTH, ViewManager.HEIGHT);
		setLayout(new CardLayout());
		
		// 컴포넌트 생성
		background = new JLabel(BACKGROUND);
		nameLabel = new JLabel(NAME);
		portLabel = new JLabel(PORT);
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
		nameField.setBackground(Color.LIGHT_GRAY);
		portField.setFont(new Font("", Font.BOLD, 30));
		portField.setBackground(Color.LIGHT_GRAY);
		
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
