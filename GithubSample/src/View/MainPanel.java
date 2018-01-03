package View;
import java.awt.*;
import javax.swing.*;

public class MainPanel extends JPanel {
   final ImageIcon backImg = new ImageIcon("Image/Label/main_background.png");
   final ImageIcon btnImg = new ImageIcon("Image/Label/button.png");
   
   final public static int BTN_WIDTH = 200;
   final public static int BTN_HEIGHT = 70;
   
   private JLabel backGround;
   private JLabel singleLabel;
   private JLabel multiLabel;
   private JLabel rankLabel;
   private JLabel exitLabel;
   private JLabel titleLabel;
   
   public MainPanel() {
      setSize(1000, 640);
      setLayout(new CardLayout());
      
      backGround = new JLabel(backImg);
      singleLabel = new JLabel(btnImg);
      multiLabel = new JLabel(btnImg);
      exitLabel = new JLabel(btnImg);
      rankLabel = new JLabel(btnImg);
      titleLabel = new JLabel("Tower Defense¡Ø");
      titleLabel.setFont(new Font("Tower Defense", Font.BOLD, 60));
      
      JLabel singleFont = new JLabel("Single Play");
      JLabel multiFont = new JLabel("Multi Play");
      JLabel rankFont = new JLabel("Ranking");
      JLabel exitFont = new JLabel("Exit");
      
      singleFont.setFont(new Font("Single Play", Font.ITALIC, 30));
      multiFont.setFont(new Font("Multi Play", Font.ITALIC, 30));
      rankFont.setFont(new Font("Ranking", Font.ITALIC, 30));
      exitFont.setFont(new Font("Exit", Font.ITALIC, 30));
      
      singleLabel.setLayout(new FlowLayout());
      multiLabel.setLayout(new FlowLayout());
      exitLabel.setLayout(new FlowLayout());
      rankLabel.setLayout(new FlowLayout());
      singleLabel.add(singleFont);
      multiLabel.add(multiFont);
      rankLabel.add(rankFont);
      exitLabel.add(exitFont);
      
      add(backGround);
      
      backGround.setLayout(null);
      
      backGround.add(singleLabel);
      backGround.add(multiLabel);
      backGround.add(exitLabel);
      backGround.add(titleLabel);
      backGround.add(rankLabel);
      
      singleLabel.setBounds(10, getHeight()/7 * 2, BTN_WIDTH, BTN_HEIGHT);
      multiLabel.setBounds(10, getHeight()/7 * 3, BTN_WIDTH, BTN_HEIGHT);
      rankLabel.setBounds(10, getHeight()/7 * 4, BTN_WIDTH, BTN_HEIGHT);
      exitLabel.setBounds(10, getHeight()/7 * 5, BTN_WIDTH, BTN_HEIGHT);
      titleLabel.setBounds(getWidth()/3, getHeight()/6, 500, 100);
      titleLabel.setForeground(Color.MAGENTA);
   
      
      setVisible(true);
   }
   
   public JLabel getSingleLabel() {
      return singleLabel;
   }
   public JLabel getMultiLabel() {
      return multiLabel;
   }
   public JLabel getExitLabel() {
      return exitLabel;
   }
   public JLabel getRankLabel() {
	   return rankLabel;
   }
}