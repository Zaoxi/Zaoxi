package View;
import java.awt.*;
import javax.swing.*;
import Control.*;
// Multiplay가 진행되는 패널
// 2017-12-27 안종희 구현
// 2018-01-06 안종희 개선 - 각종 폰트 이미지 추가
public class MultiPanel extends JPanel {
	private JLabel mapLabel;
	private JButton tower0;
	private JButton tower1;
	private JButton tower2;
	private JButton tower3;
	private JButton tower4;
	private JButton tower5;
	
	private JLabel scoreLabel;
	private JTextField scoreField;
	private JLabel moneyLabel;
	private JTextField moneyField;
	
	private JPanel towerPanel;
	
	private JButton monster0;
	private JButton monster1;
	private JButton monster2;
	private JButton monster3;
	private JButton monster4;
	private JButton monster5;
	private JButton monster6;
	private JButton monster7;
	private JButton monster8;
	private JButton monster9;
	
	final ImageIcon mapImg = new ImageIcon("Image/Map/multi_background.png");
	final ImageIcon tower0Img = new ImageIcon("Image/Tower/tower0.png");
	final ImageIcon tower1Img = new ImageIcon("Image/Tower/tower1.png");
	final ImageIcon tower2Img = new ImageIcon("Image/Tower/tower2.png");
	final ImageIcon tower3Img = new ImageIcon("Image/Tower/tower3.png");
	final ImageIcon tower4Img = new ImageIcon("Image/Tower/tower4.png");
	final ImageIcon tower5Img = new ImageIcon("Image/Tower/tower5.png");
	final ImageIcon monster0Img = new ImageIcon("Image/Monster/monster0_00.png");
	final ImageIcon monster1Img = new ImageIcon("Image/Monster/monster1_00.png");
	final ImageIcon monster2Img = new ImageIcon("Image/Monster/monster2_00.png");
	final ImageIcon monster3Img = new ImageIcon("Image/Monster/monster3_00.png");
	final ImageIcon monster4Img = new ImageIcon("Image/Monster/monster4_00.png");
	final ImageIcon monster5Img = new ImageIcon("Image/Monster/monster5_00.png");
	final ImageIcon monster6Img = new ImageIcon("Image/Monster/monster6_00.png");
	final ImageIcon monster7Img = new ImageIcon("Image/Monster/monster7_00.png");
	final ImageIcon monster8Img = new ImageIcon("Image/Monster/monster8_00.png");
	final ImageIcon monster9Img = new ImageIcon("Image/Monster/monster9_00.png");
	
	final private ImageIcon SCORE = new ImageIcon("Image/Label/score.png");
	final private ImageIcon MONEY = new ImageIcon("Image/Label/Money.png");
	
	
	final static int WIDTH = 1360;
	final static int HEIGHT = 640;
	
	public MultiPanel() {
		setSize(WIDTH, HEIGHT);
		setLayout(new BorderLayout());
		setBackground(Color.gray);
		
		mapLabel = new JLabel(mapImg);
		tower0 = new JButton(tower0Img);
		tower1 = new JButton(tower1Img);
		tower2 = new JButton(tower2Img);
		tower3 = new JButton(tower3Img);
		tower4 = new JButton(tower4Img);
		tower5 = new JButton(tower5Img);
		monster0 = new JButton(monster0Img);
		monster1 = new JButton(monster1Img);
		monster2 = new JButton(monster2Img);
		monster3 = new JButton(monster3Img);
		monster4 = new JButton(monster4Img);
		monster5 = new JButton(monster5Img);
		monster6 = new JButton(monster6Img);
		monster7 = new JButton(monster7Img);
		monster8 = new JButton(monster8Img);
		monster9 = new JButton(monster9Img);
		
		scoreLabel = new JLabel(SCORE);
		scoreLabel.setFont(new Font("Score: ", Font.BOLD, 30));
		moneyLabel = new JLabel(MONEY);
		moneyLabel.setFont(new Font("Money: ", Font.BOLD, 30));
		scoreField = new JTextField(5);
		scoreField.setEditable(false);
		scoreField.setBackground(Color.LIGHT_GRAY);
		scoreField.setFont(new Font("Money: ", Font.BOLD, 30));
		moneyField = new JTextField(5);
		moneyField.setEditable(false);
		moneyField.setBackground(Color.LIGHT_GRAY);
		moneyField.setFont(new Font("Money: ", Font.BOLD, 30));
		towerPanel = new JPanel();
		towerPanel.setSize(360, 640);
		towerPanel.setLayout(new GridLayout(5, 4, 10, 10));
		towerPanel.setBackground(Color.gray);
		
		tower0.setText("100");
		tower1.setText("300");
		tower2.setText("500");
		tower3.setText("800");
		tower4.setText("1300");
		tower5.setText("2000");
		monster0.setText("20");
		monster1.setText("50");
		monster2.setText("100");
		monster3.setText("200");
		monster4.setText("300");
		monster5.setText("500");
		monster6.setText("2000");
		monster7.setText("3000");
		monster8.setText("400");
		monster9.setText("8000");
		
		tower0.setFont(new Font("100", Font.ITALIC, 20));
		tower0.setBackground(Color.LIGHT_GRAY);
		tower1.setFont(new Font("200", Font.ITALIC, 20));
		tower1.setBackground(Color.LIGHT_GRAY);
		tower2.setFont(new Font("300", Font.ITALIC, 20));
		tower2.setBackground(Color.LIGHT_GRAY);
		tower3.setFont(new Font("400", Font.ITALIC, 20));
		tower3.setBackground(Color.LIGHT_GRAY);
		tower4.setFont(new Font("500", Font.ITALIC, 20));
		tower4.setBackground(Color.LIGHT_GRAY);
		tower5.setFont(new Font("600", Font.ITALIC, 20));
		tower5.setBackground(Color.LIGHT_GRAY);
		
		monster0.setFont(new Font("10", Font.ITALIC, 20));
		monster0.setBackground(Color.LIGHT_GRAY);
		monster1.setFont(new Font("20", Font.ITALIC, 20));
		monster1.setBackground(Color.LIGHT_GRAY);
		monster2.setFont(new Font("30", Font.ITALIC, 20));
		monster2.setBackground(Color.LIGHT_GRAY);
		monster3.setFont(new Font("40", Font.ITALIC, 20));
		monster3.setBackground(Color.LIGHT_GRAY);
		monster4.setFont(new Font("50", Font.ITALIC, 20));
		monster4.setBackground(Color.LIGHT_GRAY);
		monster5.setFont(new Font("60", Font.ITALIC, 20));
		monster5.setBackground(Color.LIGHT_GRAY);
		monster6.setFont(new Font("70", Font.ITALIC, 20));
		monster6.setBackground(Color.LIGHT_GRAY);
		monster7.setFont(new Font("80", Font.ITALIC, 20));
		monster7.setBackground(Color.LIGHT_GRAY);
		monster8.setFont(new Font("90", Font.ITALIC, 20));
		monster8.setBackground(Color.LIGHT_GRAY);
		monster9.setFont(new Font("100", Font.ITALIC, 20));
		monster9.setBackground(Color.LIGHT_GRAY);
		
		towerPanel.add(scoreLabel);
		towerPanel.add(scoreField);
		towerPanel.add(monster0);
		towerPanel.add(monster1);
		towerPanel.add(moneyLabel);
		towerPanel.add(moneyField);
		towerPanel.add(monster2);
		towerPanel.add(monster3);
		towerPanel.add(tower0);
		towerPanel.add(tower1);
		towerPanel.add(monster4);
		towerPanel.add(monster5);
		towerPanel.add(tower2);
		towerPanel.add(tower3);
		towerPanel.add(monster6);
		towerPanel.add(monster7);
		towerPanel.add(tower4);
		towerPanel.add(tower5);
		towerPanel.add(monster8);
		towerPanel.add(monster9);
		
		add(mapLabel, BorderLayout.WEST);
		add(towerPanel, BorderLayout.EAST);
		
		setVisible(true);
	}
	
	public JLabel getMapLabel() {
		return mapLabel;
	}
	public JTextField getScoreField() {
		return scoreField;
	}
	public JTextField getMoneyField() {
		return moneyField;
	}
	public JButton getTower0Btn() {
		return tower0;
	}
	public JButton getTower1Btn() {
		return tower1;
	}
	public JButton getTower2Btn() {
		return tower2;
	}
	public JButton getTower3Btn() {
		return tower3;
	}
	public JButton getTower4Btn() {
		return tower4;
	}
	public JButton getTower5Btn() {
		return tower5;
	}
	public JButton getMonster0Btn() {
		return monster0;
	}
	public JButton getMonster1Btn() {
		return monster1;
	}
	public JButton getMonster2Btn() {
		return monster2;
	}
	public JButton getMonster3Btn() {
		return monster3;
	}
	public JButton getMonster4Btn() {
		return monster4;
	}
	public JButton getMonster5Btn() {
		return monster5;
	}
	public JButton getMonster6Btn() {
		return monster6;
	}
	public JButton getMonster7Btn() {
		return monster7;
	}
	public JButton getMonster8Btn() {
		return monster8;
	}
	public JButton getMonster9Btn() {
		return monster9;
	}
}
