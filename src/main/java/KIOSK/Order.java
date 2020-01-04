package KIOSK;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Order extends JFrame implements MouseListener,ActionListener{
	
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
		Object[][] rowData= {null};
		Object[] columbName= {"ÁÖ¹® ¸ñ·Ï","´Ü°¡","¼ö·®","°¡°Ý"};
		dtm= new DefaultTableModel(rowData,columbName);
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
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String event = e.getActionCommand();
		switch(event) {
		
		case "¿ÀÄÚ³ë¹Ì¾ß³¢S": addRow(event,3500,1);
		break;
		
		}
	}
	
	private void addRow(String name,int unit,int count) {
		
		int price=unit*count;
		
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		model.addRow(new String[] {name,Integer.toString(unit),Integer.toString(count),Integer.toString(price)});
	}
	
}
