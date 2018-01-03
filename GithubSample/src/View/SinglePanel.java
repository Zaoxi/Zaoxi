package View;
import java.awt.*;
import javax.swing.*;

public class SinglePanel extends JPanel {//2018/1/3 æ»¡æ»ÒUI¡¶¿€
   private JLabel mapLabel;
   private JButton tower0;
   private JButton tower1;
   private JButton tower2;
   private JButton tower3;
   private JButton tower4;
   private JButton tower5;
   
   private JLabel scoreLabel;
   private JTextField scoreField;
   private JLabel moneyLabel;
   private JTextField moneyField;
   
   private JPanel towerPanel;
   
   final ImageIcon mapImg = new ImageIcon("Image/Map/map_background.png");
   final ImageIcon tower0Img = new ImageIcon("Image/Tower/tower0.png");
   final ImageIcon tower1Img = new ImageIcon("Image/Tower/tower1.png");
   final ImageIcon tower2Img = new ImageIcon("Image/Tower/tower2.png");
   final ImageIcon tower3Img = new ImageIcon("Image/Tower/tower3.png");
   final ImageIcon tower4Img = new ImageIcon("Image/Tower/tower4.png");
   final ImageIcon tower5Img = new ImageIcon("Image/Tower/tower5.png");
   
   public SinglePanel() {
      setSize(1000, 640);
      setLayout(new BorderLayout());
      setBackground(Color.GRAY);
      
      mapLabel = new JLabel(mapImg);
      tower0 = new JButton(tower0Img);
      tower1 = new JButton(tower1Img);
      tower2 = new JButton(tower2Img);
      tower3 = new JButton(tower3Img);
      tower4 = new JButton(tower4Img);
      tower5 = new JButton(tower5Img);
      scoreLabel = new JLabel("Score: ");
      scoreLabel.setFont(new Font("Score: ", Font.BOLD, 30));
      scoreLabel.setForeground(Color.BLACK);
      moneyLabel = new JLabel("Money: ");
      moneyLabel.setFont(new Font("Money: ", Font.BOLD, 30));
      moneyLabel.setForeground(Color.BLACK);
      scoreField = new JTextField(5);
      scoreField.setEditable(false);
      scoreField.setFont(new Font("", Font.BOLD, 30));
      scoreField.setBackground(Color.LIGHT_GRAY);
      moneyField = new JTextField(5);
      moneyField.setEditable(false);
      moneyField.setFont(new Font("", Font.BOLD, 30));
      moneyField.setBackground(Color.LIGHT_GRAY);
      towerPanel = new JPanel();
      towerPanel.setSize(360, 640);
      towerPanel.setLayout(new GridLayout(5, 2, 10, 10));
      towerPanel.setBackground(Color.GRAY);
      mapLabel.setLayout(null);
      
      tower0.setText("100");
      tower1.setText("200");
      tower2.setText("300");
      tower3.setText("400");
      tower4.setText("500");
      tower5.setText("600");
      
      tower0.setFont(new Font("100", Font.ITALIC, 20));
      tower1.setFont(new Font("200", Font.ITALIC, 20));
      tower2.setFont(new Font("300", Font.ITALIC, 20));
      tower3.setFont(new Font("400", Font.ITALIC, 20));
      tower4.setFont(new Font("500", Font.ITALIC, 20));
      tower5.setFont(new Font("600", Font.ITALIC, 20));
      
      tower0.setBackground(Color.LIGHT_GRAY);
      tower1.setBackground(Color.LIGHT_GRAY);
      tower2.setBackground(Color.LIGHT_GRAY);
      tower3.setBackground(Color.LIGHT_GRAY);
      tower4.setBackground(Color.LIGHT_GRAY);
      tower5.setBackground(Color.LIGHT_GRAY);
      
      
      towerPanel.setLayout(new FlowLayout());
      
      JLabel title = new JLabel("        Tower        ");
      title.setFont(new Font("100", Font.BOLD, 40));
      title.setForeground(Color.BLACK);
      
      JLabel space = new JLabel("                  ");
      title.setFont(new Font("100", Font.BOLD, 40));
      
      towerPanel.add(title);
      towerPanel.add(scoreLabel);
      towerPanel.add(scoreField);
      towerPanel.add(moneyLabel);
      towerPanel.add(moneyField);
      towerPanel.add(space);
      towerPanel.add(tower0);
      towerPanel.add(tower1);
      towerPanel.add(tower2);
      towerPanel.add(tower3);
      towerPanel.add(tower4);
      towerPanel.add(tower5);
      
      add(mapLabel, BorderLayout.WEST);
      add(towerPanel, BorderLayout.CENTER);
      
      setVisible(true);
   }
   
   
   public JLabel getMapLabel() {
      return mapLabel;
   }
   public JTextField getScoreField() {
      return scoreField;
   }
   public JTextField getMoneyField() {
      return moneyField;
   }
   public JButton getTower0Btn() {
      return tower0;
   }
   public JButton getTower1Btn() {
      return tower1;
   }
   public JButton getTower2Btn() {
      return tower2;
   }
   public JButton getTower3Btn() {
      return tower3;
   }
   public JButton getTower4Btn() {
      return tower4;
   }
   public JButton getTower5Btn() {
      return tower5;
   }
}