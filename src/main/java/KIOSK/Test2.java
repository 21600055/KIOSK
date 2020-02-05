package KIOSK; 

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Test2 extends JFrame implements ActionListener{
	
	JPanel p=new JPanel();
	JButton bt1=new JButton("¡÷πÆ");
	JButton bt2=new JButton("øœº∫");
	JTable table=new JTable();
	ArrayList<Excelmember> list=new ArrayList<Excelmember>();
	
	public Test2(String arg) {
		
		super("∏ﬁ¿Œ»≠∏È");	
		p.setLayout(null);
		bt1.setBounds(250,50,150,150);
		bt1.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,30));
		bt2.setBounds(550,50,150,150);
		bt2.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,30));
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		p.add(bt1);
		p.add(bt2);
		add(p);
		setSize(1000,750);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String event=e.getActionCommand();
		
		switch(event) {
		
		case "¡÷πÆ":new Order();
					//table=new Order().getTable();
		break;
		case "øœº∫":;
		break;
		case "ø¢ºø√‚∑¬":;
		break;
		} 
	}
	
	
}