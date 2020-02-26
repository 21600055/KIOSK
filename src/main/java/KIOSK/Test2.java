package KIOSK; 

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Test2 extends JFrame implements ActionListener{
	
	JPanel p=new JPanel();
	JButton bt1=new JButton("주문");
	JButton bt2=new JButton("완성");
	JTable table=new JTable();
	ArrayList<Excelmember> list=new ArrayList<Excelmember>();
	
	public Test2(String arg) {
		
		super("메인화면");	
		p.setLayout(null);
		bt1.setBounds(250,50,150,150);
		bt1.setFont(new Font("맑은 고딕",Font.BOLD,30));
		bt2.setBounds(550,50,150,150);
		bt2.setFont(new Font("맑은 고딕",Font.BOLD,30));
		
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
		
		case "주문":new Order(); break;
		case "완성":new Complete();break;
		//아마 엑셀에서 수령이랑 결제 false로 되어있는 것들만 테이블로 읽어오고 실시간으로 업데이트. 아직 어떻게 할지 모르니 차선책으로 새로고침 버튼을 추가하여 테이블 갱신을 하는게 어떤지 생각해봄
		} 
	}
	
	
}