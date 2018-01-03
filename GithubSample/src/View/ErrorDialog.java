package View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ErrorDialog extends JDialog {
	private String errName;
	private JLabel errInfo;
	private JButton closeBtn;
	private ErrorDialog instance;
	
	public ErrorDialog(String err) {
		instance = this;
		errName = err;
		this.setTitle("Exception!!");
		this.setLayout(new BorderLayout());
		this.setSize(300, 200);
		
		errInfo = new JLabel(err);
		errInfo.setFont(new Font("Error", Font.BOLD, 20));
		errInfo.setHorizontalAlignment(SwingConstants.CENTER);
		closeBtn = new JButton("Close");
		closeBtn.setFont(new Font("Close", Font.BOLD, 20));
		closeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				instance.dispose();
			}
		});
		this.add(errInfo, BorderLayout.CENTER);
		this.add(closeBtn, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
}
