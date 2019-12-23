package KIOSK;

import java.awt.*;

public class Textarea extends Frame{
	
	public Textarea(String arg){
		
		super(arg);
		Panel p=new Panel();
		
		TextArea txt1=new TextArea(10,30);
		TextField txt2=new TextField("Hello java",20);
		txt1.setText("java world");
		txt1.setBackground(Color.white);
		txt1.setFont(new Font("±Ã¼­Ã¼",Font.BOLD,10));
		txt1.setForeground(Color.black);
		txt2.setForeground(Color.black);
		p.add(txt1);
		p.add(txt2);
		add(p);
		setSize(200,200);
		setVisible(true);
		
	}
}
