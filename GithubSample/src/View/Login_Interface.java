package View;
import javax.swing.*;


interface Multi_Login_Interface {
	// Multi_Login ���̺� ���� ���̺� ��ü���� ��ȯ�ϴ� �Լ�
	JTextField getIDField();
	JLabel getLoginLabel();
	JLabel getPressedLoginLabel();
	JLabel getCancelLabel();
	JLabel getPressedCancelLabel();
}


class Multi_Login extends JLabel implements Multi_Login_Interface {

	@Override
	public JTextField getIDField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JLabel getLoginLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JLabel getPressedLoginLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JLabel getCancelLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JLabel getPressedCancelLabel() {
		// TODO Auto-generated method stub
		return null;
	}
	
}