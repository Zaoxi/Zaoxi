package View;

import javax.swing.*;
import java.awt.*;

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
		background.setLayout(new GridLayout(2, 1, 100, 0));
		matchLabel.setFont(new Font("Name", Font.BOLD, 100));
		matchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cancel.setFont(new Font("Name", Font.BOLD, 30));
		cancel.setHorizontalAlignment(SwingConstants.CENTER);
		
		cancelBtn.setLayout(new CardLayout());
		cancelBtn.add(cancel);
		background.add(matchLabel);
		background.add(cancelBtn);
		add(background);
		
		setVisible(true);
	}
	
	public JLabel getCancelLabel() {
		return cancelBtn;
	}
}
