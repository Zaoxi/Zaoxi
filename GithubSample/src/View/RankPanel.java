package View;

import java.awt.*;
import javax.swing.*;

// �������� ��ŷ�� �����ִ� �г�, 1~10�� ������ ǥ��
public class RankPanel extends JPanel {
	private JLabel background;
	private JLabel rankTitle;
	private JLabel userPanel;
	private JLabel menuLabel;
	private JLabel[][] userList;
	
	final private ImageIcon BUTTON = new ImageIcon("Image/Label/button.png");
	final private ImageIcon BACKGROUND = new ImageIcon("Image/Label/common_background.png");
	
	public RankPanel() {
		setLayout(new CardLayout());
		
		// ������Ʈ ����
		background = new JLabel(BACKGROUND);
		rankTitle = new JLabel("Ranking");
		userPanel = new JLabel();
		menuLabel = new JLabel(BUTTON);
		userList = new JLabel[10][];
		
		// ���� ������ ��� ���̺� ���� �� �гο� ��ġ
		background.setLayout(new BorderLayout());
		userPanel.setLayout(new GridLayout(10, 2));
		for(int i=0; i<userList.length; i++) {
			userList[i] = new JLabel[2];
			
			for(int j=0; j<userList[i].length; j++) {
				userList[i][j] = new JLabel();
				userList[i][j].setFont(new Font("user", Font.ITALIC, 15));
				userList[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				userPanel.add(userList[i][j]);
			}
		}
		JLabel menu = new JLabel("Menu");
		
		// ������Ʈ ����
		rankTitle.setFont(new Font("rank", Font.BOLD, 40));
		rankTitle.setHorizontalAlignment(SwingConstants.CENTER);
		menu.setFont(new Font("menu", Font.BOLD, 40));
		menu.setHorizontalAlignment(SwingConstants.CENTER);
		menuLabel.setLayout(new CardLayout());
		
		menuLabel.add(menu);
		background.add(rankTitle, BorderLayout.NORTH);
		background.add(userPanel, BorderLayout.CENTER);
		background.add(menuLabel, BorderLayout.SOUTH);
		add(background);
		
		setVisible(true);
	}
	
	public JLabel[][] getUserLabel() {
		return userList;
	}
	public JLabel getMenuLabel() {
		return menuLabel;
	}
}
