package KIOSK;

import java.awt.*;

public class Button1 extends Frame{
	
	Button bt1,bt2;
	
	public Button1(String str) {
		
		super(str);
		Panel p= new Panel();
		
		bt1= new Button("�ֹ�");
		bt2= new Button("�ϼ�");
		
		p.add(bt1);
		p.add(bt2);
		add(p);
		setSize(200,200);
		setVisible(true);
	}
}