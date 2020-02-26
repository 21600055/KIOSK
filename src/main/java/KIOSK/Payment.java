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
	//지불창 클래스입니다
	Box center=Box.createHorizontalBox();
	JComboBox<String> p,p1,p2,p3;
	JButton bt=new JButton("다음");
	String name[]= {"현금","토스","계좌이체","카카오뱅크"};
	String gender[]= {"남","여"};
	String age[]= {"어른","학생"};
	String count[]= {"1명","2명","3명","4명","5명"};
	Font font=new Font("맑은 고딕",Font.BOLD,50);
	Excelmember data=new Excelmember();
	
	public Payment(Excelmember row) {//컨스트럭터, row는 Order에서 받아온 주문 목록
		
		super("결제정보창");
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
	public void paypanel() {//결제 방식 정하는 콤보박스 초기화 메소드입니다.
		Box pay=Box.createVerticalBox();
		p=new JComboBox<String>(name);
		p.setPreferredSize(new Dimension(250,100));
		p.setFont(font);
		pay.add(p);
		JPanel left=new JPanel();
		left.setBorder(new TitledBorder(new EtchedBorder(),"결제수단"));
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
		center.setBorder(new TitledBorder(new EtchedBorder(),"성별"));
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
		right.setBorder(new TitledBorder(new EtchedBorder(),"나이 및 명수"));
		right.add(age);
		center.add(right);
	}
	public void event() {//이벤트 처리 메소드
		
		p.addActionListener(this);
		p1.addActionListener(this);
		p2.addActionListener(this);
		p3.addActionListener(this);
		bt.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {//이벤트 처리 메소드
		
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
	public void Next() {//다음을 눌렀을때 작동하는 메소드입니다
		new Dialogue(this,data);//주문번호는 ~~번입니다 라고 뜨는 다이얼로그 메소드입니다.
		new ExcelWrite(data);//엑셀 작성하는 메소드입니다
	}
	
}
