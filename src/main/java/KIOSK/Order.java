package KIOSK;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Order extends JFrame implements ActionListener{
	
	int i=1,j=1;
	JPanel p=new JPanel();
	JPanel southp=new JPanel();
	JButton bt1=new JButton("오코노미야끼S");
	JButton bt2=new JButton("오코노미야끼L");
	JButton bt3=new JButton("타코야끼");
	JButton bt4=new JButton("매운맛");
	JButton bt5=new JButton("전체 취소");
	JButton bt6=new JButton("다음");
	JTable table;
	JScrollPane scroll;
	DefaultTableModel dtm;
	JTextField textfield=new JTextField(15);
	Font font=new Font("맑은 고딕",Font.BOLD,15);
	Excelmember excelmember;
	
	public Order() {	
		super("주문창");
		Jpanel();
		Jtable();
		JText();
		add("South",southp);
		add("Center",p);
		event();
		setSize(1000,750);
		setVisible(true);
	}
	public void Jpanel() {//버튼 만드는 메소드
		p.setLayout(null);
		bt1.setBounds(100,50,150,100);
		bt1.setFont(font);
		bt2.setBounds(300,50,150,100);
		bt2.setFont(font);
		bt3.setBounds(500,50,150,100);
		bt3.setFont(font);
		bt4.setBounds(700,50,150,100);
		bt4.setFont(font);
		bt5.setBounds(100,175,150,100);
		bt5.setFont(font);
		bt6.setBounds(300,175,150,100);
		bt6.setFont(font);
		
		p.add(bt1);
		p.add(bt2);
		p.add(bt3);
		p.add(bt4);
		p.add(bt5);
		p.add(bt6);
	}
	public void Jtable() {
		Object[] columbName= {"주문 목록","단가","수량","가격"};
		dtm= new DefaultTableModel(columbName,0);
		table= new JTable(dtm);
		scroll= new JScrollPane(table);
		southp.add(scroll);
		add("South",southp);
	}
	public void JText() {
		JLabel cost =new JLabel("총금액");
		cost.setFont(new Font("맑은 고딕",Font.BOLD,10));
		southp.add(cost);
		textfield.setText("0");
		southp.add(textfield);
	}
	public void event() {
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		bt5.addActionListener(this);
		bt6.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {//버튼을 눌렀을때, 작동하는 메소드입니다.
		
		String event = e.getActionCommand();
		switch(event) {
		case "오코노미야끼S":
			if(isexist(event))
				Update(event);
			else
				addRow(event,3500,1);
		break;
		case "오코노미야끼L": 
			if(isexist(event))
				Update(event);
			else
				addRow(event,4000,1);
		break;
		case "타코야끼": 
			if(isexist(event))
				Update(event);
			else
				addRow(event,3000,1);
		break;
		case "매운맛":
			if(isexist(event))
				break;
			else
				addRow(event,0,0);
			break;
		case "전체 취소":
			dtm.setRowCount(0);
			textfield.setText("0");
			break;
		case "다음":
			Next();
			break;
		}
	}
	public void addRow(String name,int unit,int count) {//테이블에 값이 없을 경우 테이블에 데이터를 추가하는 메소드입니다.
		int price=unit*count;
		int totalprice=Integer.parseInt(textfield.getText())+price;
		//DefaultTableModel model=(DefaultTableModel)table.getModel();
		dtm.addRow(new String[] {name,Integer.toString(unit),Integer.toString(count),Integer.toString(price)});
		textfield.setText(Integer.toString(totalprice));
	}
	
	public boolean isexist(String event) {//이 메소드는 테이블에 값이 있는지 없는지 확인하는 메소드입니다.
		for(int i=0;i<table.getRowCount();i++)
			if(event.equals(table.getValueAt(i, 0)))
				return true;
		return false;
	}
	public void Update(String event) {//같은 버튼을 누를 경우, 수량을 바꿔주는 메소드입니다.
		int i,totalprice=Integer.parseInt(textfield.getText());
		for(i=0;i<table.getRowCount();i++)
			if(event.equals(table.getValueAt(i, 0)))
				break;
		int unit=Integer.parseInt((String) table.getValueAt(i, 2))+1;
		int price=unit*Integer.parseInt((String) table.getValueAt(i, 1));
		totalprice+=Integer.parseInt((String) table.getValueAt(i, 1));
		table.setValueAt(Integer.toString(unit), i, 2);
		table.setValueAt(Integer.toString(price),i,3);
		textfield.setText(Integer.toString(totalprice));
	}
	public void Next() {//다음을 눌렀을때 작동하는 메소드
		ArrayList<Excelmember> next= new ArrayList<Excelmember>();//엑셀에 작성할 어레이리스트 만들기
		excelmember=new Excelmember(i,j,table,textfield);
		next.add(excelmember);//i는 전체넘버,j는 주문넘버입니다.
		i++;j++;
		if(j>30) j/=30;
		dtm.setRowCount(0);//다음 주문을 위한 테이블 초기와
		textfield.setText("0");
		new Payment(next);
	}
}