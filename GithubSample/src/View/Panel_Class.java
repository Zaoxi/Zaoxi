package View;

import javax.swing.*;

class Main_Panel extends JPanel implements Main_Panel_Interface {
	static private Main_Panel instance = null;
	
	private Main_Panel() {
		instance = this;//singletone
	}
	
	static public Main_Panel getInstance() {
		if(instance == null)
			return new Main_Panel();
		
		return instance;
	}

	@Override
	public JLabel getSingleLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JLabel getMultiLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JLabel getExitLabel() {
		// TODO Auto-generated method stub
		return null;
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