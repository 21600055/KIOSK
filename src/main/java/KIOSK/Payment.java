package KIOSK;
	
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Payment extends JFrame implements ActionListener{
	//����â Ŭ�����Դϴ�
	Box center=Box.createHorizontalBox();
	JComboBox<String> p,p1,p2,p3;
	JButton bt=new JButton("����");
	String name[]= {"����","�佺","������ü","īī����ũ"};
	String gender[]= {"��","��"};
	String age[]= {"�","�л�"};
	String count[]= {"1��","2��","3��","4��","5��"};
	Font font=new Font("���� ���",Font.BOLD,50);
	Excelmember data=new Excelmember();
	
	public Payment(Excelmember row) {//����Ʈ����, row�� Order���� �޾ƿ� �ֹ� ���
		
		super("��������â");
		data=row;
		data.setPay(name[0]);
		data.setGender(gender[0]);
		data.setAge(age[0]);
		data.setCustomercount(count[0]);
		paypanel();
		genderpanel();
		agepanel();
		add(center,BorderLayout.CENTER);
		event();
		setSize(1000,750);
		setVisible(true);
	}
	public void paypanel() {//���� ��� ���ϴ� �޺��ڽ� �ʱ�ȭ �޼ҵ��Դϴ�.
		Box pay=Box.createVerticalBox();
		p=new JComboBox<String>(name);
		p.setPreferredSize(new Dimension(250,100));
		p.setFont(font);
		pay.add(p);
		JPanel left=new JPanel();
		left.setBorder(new TitledBorder(new EtchedBorder(),"��������"));
		left.add(pay);
		center.add(left);
	}
	public void genderpanel() {
		
		Box gender=Box.createVerticalBox();
		p1=new JComboBox<String>(this.gender);
		p1.setPreferredSize(new Dimension(250,100));
		p1.setFont(font);
		gender.add(p1);
		JPanel center=new JPanel();
		center.setBorder(new TitledBorder(new EtchedBorder(),"����"));
		center.add(gender);
		this.center.add(center);
	}
	public void agepanel() {
		
		Box age=Box.createVerticalBox();
		p2=new JComboBox<String>(this.age);
		p2.setPreferredSize(new Dimension(250,100));
		p2.setFont(font);
		age.add(p2);
		p3=new JComboBox<String>(count);
		p3.setPreferredSize(new Dimension(250,100));
		p3.setFont(font);
		age.add(p3);
		bt.setFont(font);
		age.add(bt);
		JPanel right=new JPanel();
		right.setBorder(new TitledBorder(new EtchedBorder(),"���� �� ���"));
		right.add(age);
		center.add(right);
	}
	public void event() {//�̺�Ʈ ó�� �޼ҵ�
		
		p.addActionListener(this);
		p1.addActionListener(this);
		p2.addActionListener(this);
		p3.addActionListener(this);
		bt.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {//�̺�Ʈ ó�� �޼ҵ�
		
		if(e.getSource().equals(p)) {
			JComboBox cb=(JComboBox)e.getSource();
			data.setPay((String)cb.getSelectedItem());
		}
		if(e.getSource().equals(p1)) {
			JComboBox cb=(JComboBox)e.getSource();
			data.setGender((String)cb.getSelectedItem());
		}
		if(e.getSource().equals(p2)) {
			JComboBox cb=(JComboBox)e.getSource();
			data.setAge((String)cb.getSelectedItem());
		}
		if(e.getSource().equals(p3)) {
			JComboBox cb=(JComboBox)e.getSource();
			data.setCustomercount((String)cb.getSelectedItem());
		}
		if(e.getSource().equals(bt)) {
			Next();
		}
	}
	public void Next() {//������ �������� �۵��ϴ� �޼ҵ��Դϴ�
		new Dialogue(this,data);//�ֹ���ȣ�� ~~���Դϴ� ��� �ߴ� ���̾�α� �޼ҵ��Դϴ�.
		new ExcelWrite(data);//���� �ۼ��ϴ� �޼ҵ��Դϴ�
	}
	
}
