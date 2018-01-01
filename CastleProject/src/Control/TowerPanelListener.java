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
		else {
			MapLabelListener.select = MapLabelListener.NONE;
			selectFlag = false;
		}
	}
}

class Tower1BtnListener extends TowerListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		if(!selectFlag) {
			MapLabelListener.select = MapLabelListener.TOWER1;
			selectFlag = true;
		}
		else {
			MapLabelListener.select = MapLabelListener.NONE;
			selectFlag = false;
		}
	}
}

class Tower2BtnListener extends TowerListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		if(!selectFlag) {
			MapLabelListener.select = MapLabelListener.TOWER2;
			selectFlag = true;
		}
		else {
			MapLabelListener.select = MapLabelListener.NONE;
			selectFlag = false;
		}
	}
}

class Tower3BtnListener extends TowerListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		if(!selectFlag) {
			MapLabelListener.select = MapLabelListener.TOWER3;
			selectFlag = true;
		}
		else {
			MapLabelListener.select = MapLabelListener.NONE;
			selectFlag = false;
		}
	}
}

class Tower4BtnListener extends TowerListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		if(!selectFlag) {
			MapLabelListener.select = MapLabelListener.TOWER4;
			selectFlag = true;
		}
		else {
			MapLabelListener.select = MapLabelListener.NONE;
			selectFlag = false;
		}
	}
}

class Tower5BtnListener extends TowerListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		if(!selectFlag) {
			MapLabelListener.select = MapLabelListener.TOWER5;
			selectFlag = true;
		}
		else {
			MapLabelListener.select = MapLabelListener.NONE;
			selectFlag = false;
		}
	}
}