package View;

import javax.swing.*;

interface UIManagerInterface {
	// 각 패널의 객체를 반환하는 함수
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
