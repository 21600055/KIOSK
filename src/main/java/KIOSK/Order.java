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
	JButton bt1=new JButton("���ڳ�̾߳�S");
	JButton bt2=new JButton("���ڳ�̾߳�L");
	JButton bt3=new JButton("Ÿ�ھ߳�");
	JButton bt4=new JButton("�ſ��");
	JButton bt5=new JButton("��ü ���");
	JButton bt6=new JButton("����");
	JTable table;
	JScrollPane scroll;
	DefaultTableModel dtm;
	JTextField textfield=new JTextField(15);
	Font font=new Font("���� ���",Font.BOLD,15);
	Excelmember excelmember;
	
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
	public void Jpanel() {//��ư ����� �޼ҵ�
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
		Object[] columbName= {"�ֹ� ���","�ܰ�","����","����"};
		dtm= new DefaultTableModel(columbName,0);
		table= new JTable(dtm);
		scroll= new JScrollPane(table);
		southp.add(scroll);
		add("South",southp);
	}
	public void JText() {
		JLabel cost =new JLabel("�ѱݾ�");
		cost.setFont(new Font("���� ���",Font.BOLD,10));
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
	public void actionPerformed(ActionEvent e) {//��ư�� ��������, �۵��ϴ� �޼ҵ��Դϴ�.
		
		String event = e.getActionCommand();
		switch(event) {
		case "���ڳ�̾߳�S":
			if(isexist(event))
				Update(event);
			else
				addRow(event,3500,1);
		break;
		case "���ڳ�̾߳�L": 
			if(isexist(event))
				Update(event);
			else
				addRow(event,4000,1);
		break;
		case "Ÿ�ھ߳�": 
			if(isexist(event))
				Update(event);
			else
				addRow(event,3000,1);
		break;
		case "�ſ��":
			if(isexist(event))
				break;
			else
				addRow(event,0,0);
			break;
		case "��ü ���":
			dtm.setRowCount(0);
			textfield.setText("0");
			break;
		case "����":
			Next();
			break;
		}
	}
	public void addRow(String name,int unit,int count) {//���̺� ���� ���� ��� ���̺� �����͸� �߰��ϴ� �޼ҵ��Դϴ�.
		int price=unit*count;
		int totalprice=Integer.parseInt(textfield.getText())+price;
		//DefaultTableModel model=(DefaultTableModel)table.getModel();
		dtm.addRow(new String[] {name,Integer.toString(unit),Integer.toString(count),Integer.toString(price)});
		textfield.setText(Integer.toString(totalprice));
	}
	
	public boolean isexist(String event) {//�� �޼ҵ�� ���̺� ���� �ִ��� ������ Ȯ���ϴ� �޼ҵ��Դϴ�.
		for(int i=0;i<table.getRowCount();i++)
			if(event.equals(table.getValueAt(i, 0)))
				return true;
		return false;
	}
	public void Update(String event) {//���� ��ư�� ���� ���, ������ �ٲ��ִ� �޼ҵ��Դϴ�.
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
	public void Next() {//������ �������� �۵��ϴ� �޼ҵ�
		ArrayList<Excelmember> next= new ArrayList<Excelmember>();//������ �ۼ��� ��̸���Ʈ �����
		excelmember=new Excelmember(i,j,table,textfield);
		next.add(excelmember);//i�� ��ü�ѹ�,j�� �ֹ��ѹ��Դϴ�.
		i++;j++;
		if(j>30) j/=30;
		dtm.setRowCount(0);//���� �ֹ��� ���� ���̺� �ʱ��
		textfield.setText("0");
		new Payment(next);
	}
}