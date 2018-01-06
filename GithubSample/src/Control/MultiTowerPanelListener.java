package Control;
import java.awt.event.*;

class MultiTowerListener {
	protected static boolean selectFlag = false;
}

class MultiTower0BtnListener extends MultiTowerListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		if(!selectFlag) {
			MultiMapLabelListener.select = MultiMapLabelListener.TOWER0;
			selectFlag = true;
		}
		else {
			MultiMapLabelListener.select = MultiMapLabelListener.NONE;
			selectFlag = false;
		}
	}
}

class MultiTower1BtnListener extends MultiTowerListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		if(!selectFlag) {
			MultiMapLabelListener.select = MultiMapLabelListener.TOWER1;
			selectFlag = true;
		}
		else {
			MultiMapLabelListener.select = MultiMapLabelListener.NONE;
			selectFlag = false;
		}
	}
}

class MultiTower2BtnListener extends MultiTowerListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		if(!selectFlag) {
			MultiMapLabelListener.select = MultiMapLabelListener.TOWER2;
			selectFlag = true;
		}
		else {
			MultiMapLabelListener.select = MultiMapLabelListener.NONE;
			selectFlag = false;
		}
	}
}

class MultiTower3BtnListener extends MultiTowerListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		if(!selectFlag) {
			MultiMapLabelListener.select = MultiMapLabelListener.TOWER3;
			selectFlag = true;
		}
		else {
			MultiMapLabelListener.select = MultiMapLabelListener.NONE;
			selectFlag = false;
		}
	}
}

class MultiTower4BtnListener extends MultiTowerListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		if(!selectFlag) {
			MultiMapLabelListener.select = MultiMapLabelListener.TOWER4;
			selectFlag = true;
		}
		else {
			MultiMapLabelListener.select = MultiMapLabelListener.NONE;
			selectFlag = false;
		}
	}
}

class MultiTower5BtnListener extends MultiTowerListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		if(!selectFlag) {
			MultiMapLabelListener.select = MultiMapLabelListener.TOWER5;
			selectFlag = true;
		}
		else {
			MultiMapLabelListener.select = MultiMapLabelListener.NONE;
			selectFlag = false;
		}
	}
}