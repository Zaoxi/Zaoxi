package View;
import java.awt.*;
import javax.swing.*;

public class SinglePanel extends JPanel {
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
	
	final ImageIcon mapImg = new ImageIcon("Image/Map/map_background.png");
	final ImageIcon tower0Img = new ImageIcon("Image/Tower/tower0.png");
	final ImageIcon tower1Img = new ImageIcon("Image/Tower/tower1.png");
	final ImageIcon tower2Img = new ImageIcon("Image/Tower/tower2.png");
	final ImageIcon tower3Img = new ImageIcon("Image/Tower/tower3.png");
	final ImageIcon tower4Img = new ImageIcon("Image/Tower/tower4.png");
	final ImageIcon tower5Img = new ImageIcon("Image/Tower/tower5.png");
	
	public SinglePanel() {
		setSize(1000, 640);
		setLayout(new BorderLayout());
		
		mapLabel = new JLabel(mapImg);
		tower0 = new JButton(tower0Img);
		tower1 = new JButton(tower1Img);
		tower2 = new JButton(tower2Img);
		tower3 = new JButton(tower3Img);
		tower4 = new JButton(tower4Img);
		tower5 = new JButton(tower5Img);
		scoreLabel = new JLabel("Score: ");
		scoreLabel.setFont(new Font("Score: ", Font.BOLD, 20));
		moneyLabel = new JLabel("Money: ");
		moneyLabel.setFont(new Font("Money: ", Font.BOLD, 20));
		scoreField = new JTextField(5);
		scoreField.setEditable(false);
		moneyField = new JTextField(5);
		moneyField.setEditable(false);
		towerPanel = new JPanel();
		towerPanel.setSize(360, 640);
		towerPanel.setLayout(new GridLayout(5, 2, 10, 10));
		mapLabel.setLayout(null);
		
		tower0.setText("100");
		tower1.setText("200");
		tower2.setText("300");
		tower3.setText("400");
		tower4.setText("500");
		tower5.setText("600");
		
		tower0.setFont(new Font("100", Font.ITALIC, 20));
		tower1.setFont(new Font("200", Font.ITALIC, 20));
		tower2.setFont(new Font("300", Font.ITALIC, 20));
		tower3.setFont(new Font("400", Font.ITALIC, 20));
		tower4.setFont(new Font("500", Font.ITALIC, 20));
		tower5.setFont(new Font("600", Font.ITALIC, 20));
		
		towerPanel.add(scoreLabel);
		towerPanel.add(scoreField);
		towerPanel.add(moneyLabel);
		towerPanel.add(moneyField);
		towerPanel.add(tower0);
		towerPanel.add(tower1);
		towerPanel.add(tower2);
		towerPanel.add(tower3);
		towerPanel.add(tower4);
		towerPanel.add(tower5);
		
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
}
