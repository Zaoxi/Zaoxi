package View;
import java.awt.*;
import javax.swing.*;
import Control.MapArray;

// Singleton형 클래스
class Main_Panel extends JPanel implements _Main_Panel_, _Panel_{
	
}

// Singleton형 클래스
class Single_Panel extends JPanel implements _Single_Panel_, _Panel_ {
	
}

// Singleton형 클래스
class Multi_Panel extends JPanel implements _Multi_Panel_, _Panel_ {
	
}

public class Tower_Defense extends JFrame {
	private _Panel_[] panel = new _Panel_[PanelIndex.NUM_PANEL];
	
	public Tower_Defense() {
		
	}
}
