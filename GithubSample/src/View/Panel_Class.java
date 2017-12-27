package View;

import java.awt.*;

import javax.swing.*;

class Main_Panel extends JFrame implements Main_Panel_Interface{
	static private Main_Panel instance = null;
	Font f = new Font("ITALIC",Font.ITALIC,20);
	ImageIcon im;
	
	
	
	private Main_Panel() {
		instance = this;//Singleton
		
		setTitle("Tower Defense!!");
		setSize(1000,640);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//im = new ImageIcon(Main_Panel_Interface.BUTTON_IMG)
		
		
	
		JPanel menu_panel = new JPanel();//아래 레이블들을 부착할 패널
		JLabel title_label = new JLabel("                             Tower Defense※");//제목
		title_label.setFont(new Font("Bold",Font.BOLD,40));
		
		
		//add to Frame
		

		add(title_label,BorderLayout.CENTER);
		add(menu_panel,BorderLayout.SOUTH);
		
		menu_panel.setLayout(new GridLayout(8,1));
		menu_panel.add(getSingleLabel());
		menu_panel.add(getMultiLabel());
		menu_panel.add(getExitLabel());
		
		
		
		setVisible(true);

	}
	
	static public Main_Panel getInstance() {
		if(instance == null)
			return new Main_Panel();
		
		return instance;
	}
	
	

	@Override
	public JLabel getSingleLabel() {//set추가
		JLabel single_play_label = new JLabel("   Single Play  ");
		
		single_play_label.setFont(f);
		
		
		
		return single_play_label;
	}

	@Override
	public JLabel getMultiLabel() {
	JLabel multi_play_label = new JLabel("   Multi Play  ");
		
	multi_play_label.setFont(f);
		
		
		
		return multi_play_label;
	}


	@Override
	public JLabel getExitLabel() {
		JLabel exit_label = new JLabel("   EXIT  ");
		
		exit_label.setFont(f);
		
		
		
		return exit_label;
	}
}

class Single_Panel extends JPanel implements Single_Panel_Interface {
// ...	
	
	
	@Override
	public JLabel getScoreLabel() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public JLabel getMoneyLabel() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public JLabel getMapLabel() {
		// TODO Auto-generated method stub
		return null;
	}
}

class Multi_Panel extends JPanel implements Multi_Panel_Interface {
//...
	

	@Override
	public JLabel getScoreLabel() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public JLabel getMoneyLabel() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public JLabel getMapLabel() {
		// TODO Auto-generated method stub
		return null;
	}
}