package View;
import javax.swing.*;
import Control.Control_Manager;
import java.awt.*;

// View 파트를 관리하는 ViewManager 클래스 
// 2017-12-27 안종희 구현
// 2018-01-04 조희재 개선 - 클라이언트, 호스트, 선택, 랭킹 패널 추가
// 2018-01-06 안종희 개선 - 각종 폰트 이미지 추가
public class ViewManager extends JFrame{
	private MainPanel mainPanel;
	private SinglePanel singlePanel;
	private MultiPanel multiPanel;
	private HostClientSelectPanel selectPanel;
	private HostPanel hostPanel;
	private ClientPanel clientPanel;
	private MatchPanel matchPanel;
	private SingleResultPanel singleResultPanel;
	private RankPanel rankPanel;
	private MultiWinPanel winPanel;
	private MultiLosePanel losePanel;
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
		rankPanel = new RankPanel();
		winPanel = new MultiWinPanel();
		losePanel = new MultiLosePanel();
		
		c.add("main", mainPanel);
		c.add("single", singlePanel);
		c.add("multi", multiPanel);
		c.add("select", selectPanel);
		c.add("host", hostPanel);
		c.add("client", clientPanel);
		c.add("match", matchPanel);
		c.add("single_result", singleResultPanel);
		c.add("rank", rankPanel);
		c.add("multi_win", winPanel);
		c.add("multi_lose", losePanel);
		
		card.show(c, "main");
		
		this.setVisible(true);
	}
	
	public CardLayout getCard() {
		return card;
	}
	
	public MultiLosePanel getLosePanel() {
		return losePanel;
	}
	public MultiWinPanel getWinPanel() {
		return winPanel;
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
	public RankPanel getRankPanel() {
		return rankPanel;
	}
}
