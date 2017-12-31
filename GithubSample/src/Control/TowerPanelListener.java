package Control;
import java.awt.event.*;

class TowerListener {
	protected static boolean selectFlag = false;
}

class Tower0BtnListener extends TowerListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		if(!selectFlag) {
			MapLabelListener.select = MapLabelListener.TOWER0;
			selectFlag = true;
		}
		else
			MapLabelListener.select = MapLabelListener.NONE;
	}
}

class Tower1BtnListener extends TowerListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		if(!selectFlag)
			MapLabelListener.select = MapLabelListener.TOWER1;
		else 
			MapLabelListener.select = MapLabelListener.NONE;
	}
}

class Tower2BtnListener extends TowerListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		if(!selectFlag)
			MapLabelListener.select = MapLabelListener.TOWER2;
		else 
			MapLabelListener.select = MapLabelListener.NONE;
	}
}

class Tower3BtnListener extends TowerListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		if(!selectFlag)
			MapLabelListener.select = MapLabelListener.TOWER1;
		else 
			MapLabelListener.select = MapLabelListener.NONE;
	}
}

class Tower4BtnListener extends TowerListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		if(!selectFlag)
			MapLabelListener.select = MapLabelListener.TOWER1;
		else 
			MapLabelListener.select = MapLabelListener.NONE;
	}
}

class Tower5BtnListener extends TowerListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		if(!selectFlag)
			MapLabelListener.select = MapLabelListener.TOWER1;
		else 
			MapLabelListener.select = MapLabelListener.NONE;
	}
}