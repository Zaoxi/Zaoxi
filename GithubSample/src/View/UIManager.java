package View;

import java.awt.*;

import javax.swing.*;

interface UIManagerInterface {
	// 각 패널의 객체를 반환하는 함수
	Main_Panel getMainPanel();
	Single_Panel getSinglePanel();
	Multi_Panel getMultiPanel();
	// 각 레이블의 객체를 반환하는 함수
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
		//setLayout(new CardLayout());//setvisible로 창열고 닫기
		
		main_panel = Main_Panel.getInstance();//메인 메뉴 페널 열기(싱글톤)
		
		
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
