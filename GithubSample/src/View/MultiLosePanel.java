package View;

import javax.swing.*;
import java.awt.*;

//2018-01-04 ������ ����
//2018-01-06 ������ ���� - ���� ��Ʈ �̹��� �߰�
// ��Ƽ�÷��� �й� ȭ��
public class MultiLosePanel extends JPanel {
	JLabel background;
	JLabel loseLabel;
	JLabel menuLabel;
	
	final private ImageIcon BACKGROUND = new ImageIcon("Image/Label/common_background.png");
	final private ImageIcon BUTTON = new ImageIcon("Image/Label/button.png");
	final private ImageIcon LOSE = new ImageIcon("Image/Label/You-Lose.png");
	
	public MultiLosePanel() {
		setSize(ViewManager.WIDTH, ViewManager.HEIGHT);
		setLayout(new CardLayout());
		
		// ������Ʈ ����
		background = new JLabel(BACKGROUND);
		loseLabel = new JLabel(LOSE);
		menuLabel = new JLabel(BUTTON);
		JLabel menu = new JLabel("Menu");
		
		// ������Ʈ ����
		background.setLayout(new BorderLayout());
		loseLabel.setFont(new Font("lose", Font.ITALIC, 50));
		loseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		menuLabel.setLayout(new CardLayout());
		menu.setFont(new Font("menu", Font.BOLD, 30));
		menu.setHorizontalAlignment(SwingConstants.CENTER);
		
		add(background);
		background.add(loseLabel, BorderLayout.CENTER);
		background.add(menuLabel, BorderLayout.SOUTH);
		menuLabel.add(menu);
		
		setVisible(true);
	}
	
	public JLabel getMenuLabel() {
		return menuLabel;
	}
}
