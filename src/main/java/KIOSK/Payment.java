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
		//genderpanel();
		//agepanel();
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
		left.add(pay,BorderLayout.WEST);
		add(left);
	}
	public void genderpanel() {
		
		setLayout(new BorderLayout());
		Box gender=Box.createVerticalBox();
		gender.add(Box.createVerticalStrut(30));
		gender.add(new JCheckBox("남"));
		gender.add(Box.createVerticalStrut(30));
		gender.add(new JCheckBox("여"));
		gender.add(Box.createVerticalStrut(30));
		JPanel center=new JPanel(new BorderLayout());
		center.setBorder(new TitledBorder(new EtchedBorder(),"성별"));
		center.add(gender,BorderLayout.CENTER);
		add(center);
	}
	public void agepanel() {
		
	}
}
