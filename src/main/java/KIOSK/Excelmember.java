package KIOSK;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.JTextField;

public class Excelmember {
	//이 클래스는 엑셀에 쓸 column들 constructor와 getter, setter입니다.
	private int Number;
	private String date;
	private int Ordernum;
	private int food=0;
	private int food1=0;
	private int food2=0;
	private int food3=0;
	private String totalprice;
	private String pay;
	private boolean paytrue;
	private boolean recive;
	private String gender;
	private String age;
	private String customercount;
	
	public Excelmember() {
		
	}
	
	public Excelmember(int i,int j,JTable table,JTextField textfield) {
		this.Number=i;
		this.date=new SimpleDateFormat("hh:mm:ss").format(new Date());
		this.Ordernum=j;
		this.totalprice=textfield.getText();
		for(int count=0;count<table.getRowCount();count++) {
			switch((String)table.getValueAt(count, 0)) {
			case "오코노미야끼S": this.food++; break;
			case "오코노미야끼L": this.food1++; break;
			case "타코야끼": this.food2++; break;
			case "매운맛" : this.food3++; break;
			}
		}
	}

	public int getNumber() {
		return Number;
	}

	public void setNumber(int number) {
		Number = number;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getOrdernum() {
		return Ordernum;
	}

	public void setOrdernum(int ordernum) {
		Ordernum = ordernum;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public int getFood1() {
		return food1;
	}

	public void setFood1(int food1) {
		this.food1 = food1;
	}

	public int getFood2() {
		return food2;
	}

	public void setFood2(int food2) {
		this.food2 = food2;
	}

	public int getFood3() {
		return food3;
	}

	public void setFood3(int food3) {
		this.food3 = food3;
	}

	public String getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public boolean isPaytrue() {
		return paytrue;
	}

	public void setPaytrue(boolean paytrue) {
		this.paytrue = paytrue;
	}

	public boolean isRecive() {
		return recive;
	}

	public void setRecive(boolean recive) {
		this.recive = recive;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCustomercount() {
		return customercount;
	}

	public void setCustomercount(String customercount) {
		this.customercount = customercount;
	}
	
}
