package KIOSK; 

import java.awt.*;
import javax.swing.*;

public class Test2 extends JFrame{
	
	public Test2(String arg) {
		
		super("��ư �� ���̺�");
		JPanel p=new JPanel();
		JButton bt1=new JButton("�ֹ�");
		JButton bt2=new JButton("�ϼ�");
		
		p.setLayout(null);
		bt1.setBounds(250,50,150,150);
		bt1.setFont(new Font("���� ���",Font.BOLD,30));
		bt2.setBounds(550,50,150,150);
		bt2.setFont(new Font("���� ���",Font.BOLD,30));
		
		p.add(bt1);
		p.add(bt2);
		add(p);
		setSize(1000,750);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
