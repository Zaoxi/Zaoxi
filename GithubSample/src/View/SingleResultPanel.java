package View;

import java.awt.*;
import javax.swing.*;

public class SingleResultPanel extends JPanel{
	private JLabel background;
	private JLabel resultLabel;
	private JLabel rankLabel;
	private JLabel scoreLabel;
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel registBtn;
	private JLabel cancelBtn;
	
	final private ImageIcon BUTTON = new ImageIcon("Image/Label/button.png");
	final private ImageIcon BACKGROUND = new ImageIcon("Image/Label/common_background.png");
	
	public SingleResultPanel() {
		setSize(ViewManager.WIDTH, ViewManager.HEIGHT);
		setLayout(new CardLayout());
		
		// 컴포넌트 생성
		background = new JLabel(BACKGROUND);
		JPanel northPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		resultLabel = new JLabel("Result");
		JLabel rank = new JLabel("Your Rank : ");
		rankLabel = new JLabel();
		JLabel score = new JLabel("Your Score : ");
		scoreLabel = new JLabel();
		nameLabel = new JLabel("Name : ");
		nameField = new JTextField("User" + (int)(Math.random()*10000));
		registBtn = new JLabel(BUTTON);
		cancelBtn = new JLabel(BUTTON);
		JLabel regist = new JLabel("Regist");
		JLabel cancel = new JLabel("Cancel");
		
		// 컴포넌트 조정
		background.setLayout(new GridLayout(5, 2, 20, 20));
		
		resultLabel.setFont(new Font("Result", Font.BOLD, 50));
		rankLabel.setFont(new Font("Rank", Font.BOLD, 50));
		scoreLabel.setFont(new Font("score", Font.BOLD, 50));
		nameLabel.setFont(new Font("name", Font.BOLD, 30));
		nameField.setFont(new Font("name", Font.BOLD, 30));
		regist.setFont(new Font("regist", Font.BOLD, 30));
		cancel.setFont(new Font("Cancel", Font.BOLD, 30));
		rank.setFont(new Font("rank", Font.BOLD, 30));
		score.setFont(new Font("score", Font.BOLD, 30));
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rankLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		regist.setHorizontalAlignment(SwingConstants.CENTER);
		cancel.setHorizontalAlignment(SwingConstants.CENTER);
		rank.setHorizontalAlignment(SwingConstants.CENTER);
		score.setHorizontalAlignment(SwingConstants.CENTER);
		
		registBtn.setLayout(new CardLayout());
		cancelBtn.setLayout(new CardLayout());
		
		background.add(resultLabel);
		background.add(new JLabel());
		background.add(rank);
		background.add(rankLabel);
		background.add(score);
		background.add(scoreLabel);
		background.add(nameLabel);
		background.add(nameField);
		background.add(registBtn);
		background.add(cancelBtn);
		registBtn.add(regist);
		cancelBtn.add(cancel);
		add(background);
		
		setVisible(true);
	}
	
	public JLabel getRankLabel() {
		return rankLabel;
	}
	public JLabel getScoreLabel() {
		return scoreLabel;
	}
	public JTextField getNameField() {
		return nameField;
	}
	public JLabel getRegistLabel() {
		return registBtn;
	}
	public JLabel getCancelLabel() {
		return cancelBtn;
	}
}
