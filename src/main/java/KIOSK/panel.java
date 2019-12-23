package KIOSK;

import java.awt.*;

public class panel extends Frame{
	
	public panel(String str) {
		
		super(str);
		Panel panel1= new Panel();
		panel1.setBackground(Color.BLACK);
		add(panel1);
		setSize(300,300);
		setVisible(true);
	}
}
