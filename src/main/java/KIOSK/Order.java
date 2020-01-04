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
	JButton bt1=new JButton("���ڳ�̾߳�S");
	JButton bt2=new JButton("���ڳ�̾߳�L");
	JButton bt3=new JButton("Ÿ�ھ߳�");
	JButton bt4=new JButton("�ſ��");
	JButton bt5=new JButton("��ü ���");
	JButton bt6=new JButton("����");
	JTable table;
	JScrollPane scroll;
	DefaultTableModel dtm;
	
	public Order() {
		
		super("�ֹ�â");
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
		bt1.setFont(new Font("���� ���",Font.BOLD,15));
		bt2.setBounds(300,50,150,100);
		bt2.setFont(new Font("���� ���",Font.BOLD,15));
		bt3.setBounds(500,50,150,100);
		bt3.setFont(new Font("���� ���",Font.BOLD,15));
		bt4.setBounds(700,50,150,100);
		bt4.setFont(new Font("���� ���",Font.BOLD,15));
		bt5.setBounds(100,175,150,100);
		bt5.setFont(new Font("���� ���",Font.BOLD,15));
		bt6.setBounds(300,175,150,100);
		bt6.setFont(new Font("���� ���",Font.BOLD,15));
		
		p.add(bt1);
		p.add(bt2);
		p.add(bt3);
		p.add(bt4);
		p.add(bt5);
		p.add(bt6);
	}
	private void Jtable() {
		Object[][] rowData= {null};
		Object[] columbName= {"�ֹ� ���","�ܰ�","����","����"};
		dtm= new DefaultTableModel(rowData,columbName);
		table= new JTable(dtm);
		scroll= new JScrollPane(table);
		southp.add(scroll);
		add("South",southp);
	}
	private void JText() {
		JLabel cost =new JLabel("�ѱݾ�");
		cost.setFont(new Font("���� ���",Font.BOLD,10));
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
		
		case "���ڳ�̾߳�S": addRow(event,3500,1);
		break;
		
		}
	}
	
	private void addRow(String name,int unit,int count) {
		
		int price=unit*count;
		
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		model.addRow(new String[] {name,Integer.toString(unit),Integer.toString(count),Integer.toString(price)});
	}
	
}
