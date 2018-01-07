package View;

import javax.swing.*;
import java.awt.*;

//2018-01-04 조희재 구현
// 매칭 대기 화면
public class MatchPanel extends JPanel{
	private JLabel background;
	private JLabel matchLabel;
	private JLabel cancelBtn;
	
	private ImageIcon BACKGROUND = new ImageIcon("Image/Label/common_background.png");
	private ImageIcon BUTTON = new ImageIcon("Image/Label/button.png");
	
	public MatchPanel() {
		setSize(ViewManager.WIDTH, ViewManager.HEIGHT);
		setLayout(new CardLayout());
		
		// 컴포넌트 생성
		background = new JLabel(BACKGROUND);
		matchLabel = new JLabel("Matching.");
		
		cancelBtn = new JLabel(BUTTON);
		JLabel cancel = new JLabel("Cancel");
		
		// 컴포넌트 조정
		background.setLayout(new BorderLayout());
		matchLabel.setFont(new Font("Name", Font.BOLD, 100));
		matchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cancel.setFont(new Font("Name", Font.BOLD, 30));
		cancel.setHorizontalAlignment(SwingConstants.CENTER);
		
		cancelBtn.setLayout(new CardLayout());
		cancelBtn.setSize(MainPanel.BTN_WIDTH, MainPanel.BTN_HEIGHT);
		cancelBtn.add(cancel);
		background.add(matchLabel, BorderLayout.CENTER);
		background.add(cancelBtn, BorderLayout.SOUTH);
		add(background);
		
		setVisible(true);
	}
	
	public JLabel getMatchiLabel() {
		return matchLabel;
	}
	public JLabel getCancelLabel() {
		return cancelBtn;
	}
}
