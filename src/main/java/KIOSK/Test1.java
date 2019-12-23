package KIOSK;

import java.awt.*;

public class Test1 extends Frame{
	
	Button bt1,bt2;
	public Test1(String arg) {
		
		super(arg);
		setBounds(100,100,400,400);
		Panel p=new Panel();
		
		bt1=new Button("주문");
		bt2=new Button("완성");
		TextArea txt1= new TextArea("Kiosk",5,10);
		txt1.setText("Kiosk2");
		txt1.setBackground(Color.white);
		txt1.setFont(new Font("궁서체",Font.BOLD,10));
		txt1.setForeground(Color.black);
		
		p.add(txt1);
		p.add(bt1);
		p.add(bt2);
		add(p);
		setVisible(true);
	}

}
