package View;

import javax.swing.*;

interface Single_Exit_Interface {
	
	// Single_Exit ���̺� ���� ���̺� ��ü���� ��ȯ�ϴ� �Լ�
	JLabel getRankLabel();
	JLabel getScoreLabel();
	JTextField getNameField();
	JLabel getMenuLabel();
	JLabel getPressedMenuLabel();
}

interface Multi_Exit_Interface {
	
	// Multi_Exit ���̺� ���� ���̺� ��ü���� ��ȯ�ϴ� �Լ�
	JLabel getResultLabel();
	JLabel getMenuLabel();
	JLabel getPressedMenuLabel();
}

class Single_Exit extends JLabel implements Single_Exit_Interface {

	@Override
	public JLabel getRankLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JLabel getScoreLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JTextField getNameField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JLabel getMenuLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JLabel getPressedMenuLabel() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

class Multi_Exit extends JLabel implements Multi_Exit_Interface {

	@Override
	public JLabel getResultLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JLabel getMenuLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JLabel getPressedMenuLabel() {
		// TODO Auto-generated method stub
		return null;
	}
	
}