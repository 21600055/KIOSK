package KIOSK;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Payment extends JFrame{
	
	Box center=Box.createHorizontalBox();
	
	public Payment(ArrayList<Excelmember> row) {
		
		super("결제정보창");
		paypanel();
		genderpanel();
		agepanel();
		add(center,BorderLayout.CENTER);
		setSize(1000,750);
		setVisible(true);
	}
	public void paypanel() {
		
		setLayout(new BorderLayout());
		Box pay=Box.createVerticalBox();
		pay.add(Box.createVerticalStrut(30));
		pay.add(new JCheckBox("현금"));
		pay.add(Box.createVerticalStrut(30));
		pay.add(new JCheckBox("토스"));
		pay.add(Box.createVerticalStrut(30));
		pay.add(new JCheckBox("계좌이체"));
		pay.add(Box.createVerticalStrut(30));
		pay.add(new JCheckBox("카카오뱅크"));
		pay.add(Box.createVerticalStrut(30));
		JPanel left=new JPanel(new BorderLayout());
		left.setBorder(new TitledBorder(new EtchedBorder(),"결제수단"));
		left.add(pay,BorderLayout.CENTER);
		center.add(left);
	}
	public void genderpanel() {
		
		setLayout(new BorderLayout());
		Box gender=Box.createVerticalBox();
		gender.add(Box.createVerticalStrut(30));
		gender.add(new JCheckBox("남").setFont(new Font()));
		gender.add(Box.createVerticalStrut(30));
		gender.add(new JCheckBox("여"));
		gender.add(Box.createVerticalStrut(30));
		JPanel center=new JPanel(new BorderLayout());
		center.setBorder(new TitledBorder(new EtchedBorder(),"성별"));
		center.add(gender,BorderLayout.CENTER);
		this.center.add(center);
	}
	public void agepanel() {
		
		setLayout(new BorderLayout());
		Box age=Box.createVerticalBox();
		age.add(Box.createVerticalStrut(30));
		age.add(new JCheckBox("어른"));
		age.add(Box.createVerticalStrut(30));
		age.add(new JCheckBox("학생"));
		age.add(Box.createVerticalStrut(30));
		JPanel right=new JPanel(new BorderLayout());
		right.setBorder(new TitledBorder(new EtchedBorder(),"나이 및 명수"));
		right.add(age,BorderLayout.CENTER);
		center.add(right);
	}
}
