package View;

import java.awt.*;

import javax.swing.*;

interface UIManagerInterface {
	// �� �г��� ��ü�� ��ȯ�ϴ� �Լ�
	Main_Panel getMainPanel();
	Single_Panel getSinglePanel();
	Multi_Panel getMultiPanel();
	// �� ���̺��� ��ü�� ��ȯ�ϴ� �Լ�
	Single_Exit getSingleExitLabel();
	Multi_Exit getMultiExitLabel();
	Multi_Login getMultiLoginLabel();
	
}

public class UIManager extends JFrame implements UIManagerInterface{
	private Main_Panel main_panel;
	private Single_Panel single_panel;
	private Multi_Panel multi_panel;
	private Single_Exit single_exit_label;
	private Multi_Exit multi_exit_label;
	private Multi_Login multi_login_label;
	
	public UIManager() {
		
		setTitle("Tower Defense!!");
		setSize(1000,640);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLayout(new CardLayout());//setvisible�� â���� �ݱ�
		
		main_panel = Main_Panel.getInstance();//���� �޴� ��� ����(�̱���)
		
		
		this.add(main_panel);//error
		
		setVisible(true);
		
		
		
		
	}

	@Override
	public Main_Panel getMainPanel() {


		
		return null;
	}

	@Override
	public Single_Panel getSinglePanel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Multi_Panel getMultiPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Single_Exit getSingleExitLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Multi_Exit getMultiExitLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Multi_Login getMultiLoginLabel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		
	new UIManager();
		
		
		
		
		
		
		
	}
	
	
}
