package View;

import java.awt.*;
import javax.swing.*;

// 2018-01-04 ������ ����
// 2018-01-06 ������ ���� - ���� ��Ʈ �̹��� �߰�
// HostClientSelectPanel���� Client���ý� ���
// ������ IP, Port��ȣ�� �Է��Ѵ�.
public class ClientPanel extends JPanel{
	private JLabel background;
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel ipLabel;
	private JTextField ipField;
	private JLabel portLabel;
	private JTextField portField;
	private JLabel joinBtn;
	private JLabel cancelBtn;
	
	final private ImageIcon BACKGROUND = new ImageIcon("Image/Label/common_background.png");
	final private ImageIcon BTN = new ImageIcon("Image/Label/button.png");
	final private ImageIcon NAME = new ImageIcon("Image/Label/Namebig.png");
	final private ImageIcon PORT = new ImageIcon("Image/Label/Portbig.png");
	final private ImageIcon IP = new ImageIcon("Image/Label/IP.png");
	
	
	public ClientPanel() {
		setSize(ViewManager.WIDTH, ViewManager.HEIGHT);
		setLayout(new CardLayout());
		
		// ������Ʈ ����
		background = new JLabel(BACKGROUND);
		nameLabel = new JLabel(NAME);
		nameField = new JTextField("User" + (int)(Math.random()*10000));
		ipLabel = new JLabel(IP);
		ipField = new JTextField("127.0.0.1");
		portLabel = new JLabel(PORT);
		portField = new JTextField("8888");
		joinBtn = new JLabel(BTN);
		cancelBtn = new JLabel(BTN);
		JLabel join = new JLabel("Join");
		JLabel cancel = new JLabel("Cancel");
		
		// ������Ʈ ����
		background.setSize(ViewManager.WIDTH, ViewManager.HEIGHT);
		background.setLayout(new GridLayout(4, 2, 30, 30));
		nameLabel.setFont(new Font("Name : ", Font.BOLD, 50));
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ipLabel.setFont(new Font("IP : ", Font.BOLD, 50));
		ipLabel.setHorizontalAlignment(SwingConstants.CENTER);
		portLabel.setFont(new Font("Port : ", Font.BOLD, 50));
		portLabel.setHorizontalAlignment(SwingConstants.CENTER);
		join.setFont(new Font("Name", Font.BOLD, 30));
		join.setHorizontalAlignment(SwingConstants.CENTER);
		cancel.setFont(new Font("Name", Font.BOLD, 30));
		cancel.setHorizontalAlignment(SwingConstants.CENTER);
		nameField.setFont(new Font("Name", Font.BOLD, 30));
		nameField.setBackground(Color.LIGHT_GRAY);
		ipField.setFont(new Font("Name", Font.BOLD, 30));
		ipField.setBackground(Color.LIGHT_GRAY);
		portField.setFont(new Font("Name", Font.BOLD, 30));
		portField.setBackground(Color.LIGHT_GRAY);
		joinBtn.setLayout(new CardLayout());
		cancelBtn.setLayout(new CardLayout());
		
		joinBtn.add(join);
		cancelBtn.add(cancel);
		background.add(nameLabel);
		background.add(nameField);
		background.add(ipLabel);
		background.add(ipField);
		background.add(portLabel);
		background.add(portField);
		background.add(joinBtn);
		background.add(cancelBtn);
		add(background);
		
		setVisible(true);
	}
	
	public JTextField getNameField() {
		return nameField;
	}
	public JTextField getIPField() {
		return ipField;
	}
	public JTextField getPortField() {
		return portField;
	}
	public JLabel getJoinLabel() {
		return joinBtn;
	}
	public JLabel getCancelLabel() {
		return cancelBtn;
	}
}
