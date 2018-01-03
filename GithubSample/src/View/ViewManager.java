package View;
import javax.swing.*;
import Control.Control_Manager;
import java.awt.*;

public class ViewManager extends JFrame{
	private MainPanel mainPanel;
	private SinglePanel singlePanel;
	private MultiPanel multiPanel;
	private HostClientSelectPanel selectPanel;
	private HostPanel hostPanel;
	private ClientPanel clientPanel;
	private MatchPanel matchPanel;
	private SingleResultPanel singleResultPanel;
	private CardLayout card;
	final public static int WIDTH = 1000;
	final public static int HEIGHT = 640;
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	final private Image TITLE = toolkit.getImage("Image/Monster/monster6_00.png");

	
	public ViewManager() {
		setTitle("Tower Defense");
		setIconImage(TITLE);
		setSize(WIDTH, HEIGHT+40);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		card = new CardLayout();
		c.setLayout(card);
		
		mainPanel = new MainPanel();
		singlePanel = new SinglePanel();
		multiPanel = new MultiPanel();
		selectPanel = new HostClientSelectPanel();
		hostPanel = new HostPanel();
		clientPanel = new ClientPanel();
		matchPanel = new MatchPanel();
		singleResultPanel = new SingleResultPanel();
		
		c.add("main", mainPanel);
		c.add("single", singlePanel);
		c.add("multi", multiPanel);
		c.add("select", selectPanel);
		c.add("host", hostPanel);
		c.add("client", clientPanel);
		c.add("match", matchPanel);
		c.add("single_result", singleResultPanel);
		
		card.show(c, "main");
		
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
	public HostClientSelectPanel getSelectPanel() {
		return selectPanel;
	}
	public HostPanel getHostPanel() {
		return hostPanel;
	}
	public ClientPanel getClientPanel() {
		return clientPanel;
	}
	public MatchPanel getMatchPanel() {
		return matchPanel;
	}
	public SingleResultPanel getSingleResultPanel() {
		return singleResultPanel;
	}
}
