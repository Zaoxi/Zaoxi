package View;

import java.awt.*;
import javax.swing.*;

// SinglePlay 결과가 출력되는 패널
// 2018-01-04 안종희 구현
// 2018-01-06 안종희 개선 - 각종 폰트 이미지 추가
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
	final private ImageIcon RESULT = new ImageIcon("Image/Label/GAMEOVER.png");
	final private ImageIcon RANK = new ImageIcon("Image/Label/Your-Rank.png");
	final private ImageIcon SCORE = new ImageIcon("Image/Label/Your-Score.png");
	final private ImageIcon NAME = new ImageIcon("Image/Label/Name.png");
	
	
	public SingleResultPanel() {
		setSize(ViewManager.WIDTH, ViewManager.HEIGHT);
		setLayout(new CardLayout());
		
		// 컴포넌트 생성
		background = new JLabel(BACKGROUND);
		JPanel northPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		resultLabel = new JLabel(RESULT);
		JLabel rank = new JLabel(RANK);
		rankLabel = new JLabel();
		JLabel score = new JLabel(SCORE);
		scoreLabel = new JLabel();
		nameLabel = new JLabel(NAME);
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
		nameField.setBackground(Color.LIGHT_GRAY);
		regist.setFont(new Font("regist", Font.BOLD, 30));
		cancel.setFont(new Font("Cancel", Font.BOLD, 30));
		rank.setFont(new Font("rank", Font.BOLD, 30));
		score.setFont(new Font("score", Font.BOLD, 30));
		
		//가운데로 정렬
		
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rankLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		regist.setHorizontalAlignment(SwingConstants.CENTER);
		cancel.setHorizontalAlignment(SwingConstants.CENTER);
		rank.setHorizontalAlignment(SwingConstants.CENTER);
		score.setHorizontalAlignment(SwingConstants.CENTER);
		
		// 버튼위에 마우스가 올라갔을때 장면전환을 위한 cardLayout
		registBtn.setLayout(new CardLayout());
		cancelBtn.setLayout(new CardLayout());
		
		// background 레이블 위에 컴포넌트 배치
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
	
	
	//이벤트 처리는 control에서
	//등수 출력, 점수 출력, 기록 저장을 위한 name 입력, cancel시 메인화면으로
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
