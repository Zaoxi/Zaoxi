package View;

import javax.swing.*;

interface UIManagerInterface {
	// �� �г��� ��ü�� ��ȯ�ϴ� �Լ�
	Main_Panel getMain();
	Single_Panel getSingle();
	Multi_Panel getMulti();
}

public class UIManager extends JFrame implements UIManagerInterface{
	private Main_Panel main_panel;
	private Single_Panel single_panel;
	private Multi_Panel multi_panel;
	
	public UIManager() {
		
	}

	@Override
	public Main_Panel getMain() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Single_Panel getSingle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Multi_Panel getMulti() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
