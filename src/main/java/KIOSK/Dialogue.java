package KIOSK;

import java.awt.*;

public class Dialogue extends Frame{
	
	public Dialogue() {
		
		super("다이얼로그 테스트");
		Dialog d=new Dialog(this,"작은 다이알로그");
		setBounds(0,0,400,400);
		setVisible(true);
		d.setSize(200,200);
		d.setVisible(true);
	}
}
