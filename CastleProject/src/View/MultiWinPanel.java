package View;

import javax.swing.*;
import java.awt.*;

//2018-01-04 ������ ����
//2018-01-06 ������ ���� - ���� ��Ʈ �̹��� �߰�
//��Ƽ�÷��� �¸� ȭ��
public class MultiWinPanel extends JPanel {
	JLabel background;
	JLabel winLabel;
	JLabel menuLabel;
	
	final private ImageIcon BACKGROUND = new ImageIcon("Image/Label/common_background.png");
	final private ImageIcon BUTTON = new ImageIcon("Image/Label/button.png");
	final private ImageIcon WIN = new ImageIcon("Image/Label/You-Win.png");
	
	public MultiWinPanel() {
		setSize(ViewManager.WIDTH, ViewManager.HEIGHT);
		setLayout(new CardLayout());
		
		// ������Ʈ ����
		background = new JLabel(BACKGROUND);
		winLabel = new JLabel(WIN);
		menuLabel = new JLabel(BUTTON);
		JLabel menu = new JLabel("Menu");
		
		// ������Ʈ ����
		background.setLayout(new BorderLayout());
		winLabel.setFont(new Font("win", Font.ITALIC, 50));
		winLabel.setHorizontalAlignment(SwingConstants.CENTER);
		menuLabel.setLayout(new CardLayout());
		menu.setFont(new Font("menu", Font.BOLD, 30));
		menu.setHorizontalAlignment(SwingConstants.CENTER);
		
		add(background);
		background.add(winLabel, BorderLayout.CENTER);
		background.add(menuLabel, BorderLayout.SOUTH);
		menuLabel.add(menu);
		
		setVisible(true);
	}
	
	public JLabel getMenuLabel() {
		return menuLabel;
	}
}
