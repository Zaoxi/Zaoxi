package View;
import javax.swing.*;
import Control.Control_Manager;
import java.awt.*;

public class ViewManager extends JFrame{
	private MainPanel mainPanel;
	private SinglePanel singlePanel;
	private MultiPanel multiPanel;
	
	public ViewManager() {
		setTitle("Tower Defense");
		setSize(1000, 640);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new CardLayout());
		
		mainPanel = new MainPanel();
		singlePanel = new SinglePanel();
		multiPanel = new MultiPanel();
		
		c.add("main", mainPanel);
		c.add("single", singlePanel);
		c.add("multi", multiPanel);
		
		((CardLayout)c.getLayout()).show(c, "main");
		
		setSize(1000, 640);
		this.setVisible(true);
	}
	
	public MainPanel getMainPanel() {
		return mainPanel;
	}
	public SinglePanel getSinglePanel() {
		return singlePanel;
	}
	public MultiPanel getMultiPanel() {
		return multiPanel;
	}
	
	public static void main(String[] args) {
		ViewManager ui = new ViewManager();
		Control_Manager.getInstance(ui);
	}
}
