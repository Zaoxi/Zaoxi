package View;
import javax.swing.*;
import Control.Control_Manager;
import java.awt.*;

public class ViewManager extends JFrame{
	private MainPanel mainPanel;
	private SinglePanel singlePanel;
	private MultiPanel multiPanel;
	private CardLayout card;
	
	public ViewManager() {
		setTitle("Tower Defense");
		setSize(1000, 680);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		card = new CardLayout();
		c.setLayout(card);
		
		mainPanel = new MainPanel();
		singlePanel = new SinglePanel();
		multiPanel = new MultiPanel();
		
		c.add("main", mainPanel);
		c.add("single", singlePanel);
		c.add("multi", multiPanel);
		
		this.setVisible(true);
	}
	
	public CardLayout getCard() {
		return card;
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
}
