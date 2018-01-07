// This code was produced by Joe.

package View;

import javax.swing.*;
import java.awt.*;

// 2018-01-04 ������ ����
// ��Ƽ �÷��̽� Host�� ������ ��������, Client�� ������ ������ ������ �����ϴ� �������̽�
public class HostClientSelectPanel extends JPanel{
	private JLabel background;
	private JLabel hostBtn;
	private JLabel clientBtn;
	private JLabel cancelBtn;
	final private ImageIcon BACKGROUND = new ImageIcon("Image/Label/common_background.png");
	final private ImageIcon BUTTON = new ImageIcon("Image/Label/button.png");
	
	public HostClientSelectPanel() {
		setSize(ViewManager.WIDTH, ViewManager.HEIGHT);
		int xMargin = 50;
		setLayout(new CardLayout());
		// ������Ʈ ����
		background = new JLabel(BACKGROUND);
		hostBtn = new JLabel(BUTTON);
		clientBtn = new JLabel(BUTTON);
		cancelBtn = new JLabel(BUTTON);
		JLabel host = new JLabel("Host");
		JLabel client = new JLabel("Client");
		JLabel cancel = new JLabel("Cancel");
		
		// ������Ʈ ����
		background.setSize(1000, 640);
		background.setLayout(null);
		host.setFont(new Font("Host", Font.BOLD, 30));
		client.setFont(new Font("Client", Font.BOLD, 30));
		cancel.setFont(new Font("Cancel", Font.BOLD, 30));
		hostBtn.setBounds((ViewManager.WIDTH - xMargin*2)/8 + xMargin, ViewManager.HEIGHT/2, MainPanel.BTN_WIDTH, MainPanel.BTN_HEIGHT);
		clientBtn.setBounds((ViewManager.WIDTH - xMargin*2)/8 * 3 + xMargin, ViewManager.HEIGHT/2, MainPanel.BTN_WIDTH, MainPanel.BTN_HEIGHT);
		cancelBtn.setBounds((ViewManager.WIDTH - xMargin*2)/8 * 5 + xMargin, ViewManager.HEIGHT/2, MainPanel.BTN_WIDTH, MainPanel.BTN_HEIGHT);
		hostBtn.setLayout(new FlowLayout());
		clientBtn.setLayout(new FlowLayout());
		cancelBtn.setLayout(new FlowLayout());
		
		hostBtn.add(host);
		clientBtn.add(client);
		cancelBtn.add(cancel);
		
		background.add(hostBtn);
		background.add(clientBtn);
		background.add(cancelBtn);
		add(background);
		setVisible(true);
	}
	
	public JLabel getHostLabel() {
		return hostBtn;
	}
	public JLabel getClientLabel() {
		return clientBtn;
	}
	public JLabel getCancelLabel() {
		return cancelBtn;
	}
}
