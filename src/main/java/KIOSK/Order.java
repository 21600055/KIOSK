package KIOSK;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Order extends JFrame implements ActionListener{
	
	JPanel p=new JPanel();
	JPanel southp=new JPanel();
	JButton bt1=new JButton("¿ÀÄÚ³ë¹Ì¾ß³¢S");
	JButton bt2=new JButton("¿ÀÄÚ³ë¹Ì¾ß³¢L");
	JButton bt3=new JButton("Å¸ÄÚ¾ß³¢");
	JButton bt4=new JButton("¸Å¿î¸À");
	JButton bt5=new JButton("ÀüÃ¼ Ãë¼Ò");
	JButton bt6=new JButton("´ÙÀ½");
	JTable table;
	JScrollPane scroll;
	DefaultTableModel dtm;
	
	public Order() {	
		super("ÁÖ¹®Ã¢");
		Jpanel();
		Jtable();
		JText();
		add("South",southp);
		add("Center",p);
		event();
		setSize(1000,750); 
		setVisible(true);
	}
	private void Jpanel() {
		p.setLayout(null);
		bt1.setBounds(100,50,150,100);
		bt1.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,15));
		bt2.setBounds(300,50,150,100);
		bt2.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,15));
		bt3.setBounds(500,50,150,100);
		bt3.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,15));
		bt4.setBounds(700,50,150,100);
		bt4.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,15));
		bt5.setBounds(100,175,150,100);
		bt5.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,15));
		bt6.setBounds(300,175,150,100);
		bt6.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,15));
		
		p.add(bt1);
		p.add(bt2);
		p.add(bt3);
		p.add(bt4);
		p.add(bt5);
		p.add(bt6);
	}
	private void Jtable() {
		//Object[][] rowData= {null};
		Object[] columbName= {"ÁÖ¹® ¸ñ·Ï","´Ü°¡","¼ö·®","°¡°Ý"};
		dtm= new DefaultTableModel(columbName,0);
		table= new JTable(dtm);
		scroll= new JScrollPane(table);
		southp.add(scroll);
		add("South",southp);
	}
	private void JText() {
		JLabel cost =new JLabel("ÃÑ±Ý¾×");
		cost.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,10));
		southp.add(cost);
		southp.add(new JTextField(15));
	}
	private void event() {
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String event = e.getActionCommand();
		switch(event) {
		case "¿ÀÄÚ³ë¹Ì¾ß³¢S": 
			if(isexist(event))
				Update(event);
			else
				addRow(event,3500,1);
		break;
		case "¿ÀÄÚ³ë¹Ì¾ß³¢L": 
			if(isexist(event))
				Update(event);
			else
				addRow(event,4000,1);
		break;
		case "Å¸ÄÚ¾ß³¢": 
			if(isexist(event))
				Update(event);
			else
				addRow(event,3000,1);
		break;
		case "¸Å¿î¸À": addRow(event,0,0);
		}
	}
	private void addRow(String name,int unit,int count) {
		int price=unit*count;
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		model.addRow(new String[] {name,Integer.toString(unit),Integer.toString(count),Integer.toString(price)});
	}
	
	private boolean isexist(String event) {
		for(int i=0;i<table.getRowCount();i++)
			if(event.equals(table.getValueAt(i, 0)))
				return true;
		return false;
	}
	
	private void Update(String event) {
		int i;
		for(i=0;i<table.getRowCount();i++)
			if(event.equals(table.getValueAt(i, 0)))
				break;
		int unit=Integer.parseInt((String) table.getValueAt(i, 2))+1;
		int price=Integer.parseInt((String) table.getValueAt(i, 2))*Integer.parseInt((String) table.getValueAt(i, 1));
		table.setValueAt(Integer.toString(unit), i, 2);
		table.setValueAt(Integer.toString(price),i,3); 
	}
}