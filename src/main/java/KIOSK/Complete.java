package KIOSK;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Complete extends JFrame implements ActionListener{
	//완성 버튼 클래스입니다.
	String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	String way="C:\\Users\\user\\Desktop\\"+today+"HAC장사 장부.xlsx";
	ArrayList<Excelmember> list=new ArrayList<Excelmember>();
	JFrame f=new JFrame();
	JPanel p=new JPanel(),p1=new JPanel(),p2=new JPanel(),p3;
	JTable table;
	DefaultTableModel dtm;
	JButton bt=new JButton("결제 완료");
	JButton bt1=new JButton("수령 완료");
	JButton bt2=new JButton("새로 고침");
	Button btn[]=new Button[6];
	int i=0;//손님용 화면에 출력하는 주문 번호 인덱스값입니다.
	
	public Complete() {//컨스트럭터
		
		super("완성화면");
		f.setTitle("손님용 출력화면");
		
		Jtable();
		Jbutton();
		SecondPanel();
		ExcelReader();
		add("South",p);
		add("Center",p1);
		f.add(p2);
		f.add(p3);
		event();
		setSize(1000,750);
		setVisible(true);
		f.setSize(1000,750);
		f.setVisible(true);
	}
	
	public void Jtable() {// 완성화면 테이블 만드는 메소드
		Object[] columbName= {"No.","Timecode","주문번호","오코S","오코L","타코","매운맛","총가격","결제수단","결제완료","수령","성별","어른/학생","고객수"};
		
		JScrollPane scroll;
		dtm= new DefaultTableModel(columbName,0);
		table= new JTable(dtm);
		scroll= new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(900,550));
		p.add(scroll);
	}
	
	public void Jbutton() {//완성화면 버튼 만드는 메소드

		Font font=new Font("맑은 고딕",Font.BOLD,15);
		p1.setLayout(null);
		bt.setBounds(100, 50, 150, 100);
		bt.setFont(font);
		bt1.setBounds(400, 50, 150, 100);
		bt1.setFont(font);
		bt2.setBounds(700, 50, 150, 100);
		bt2.setFont(font);
		
		p1.add(bt);
		p1.add(bt1);
		p1.add(bt2);
	}
	
	public void SecondPanel() {//손님용 출력화면 만드는 메소드
		p2.setLayout(new GridLayout(3,2));
		ImageIcon icon1=new ImageIcon("C:\\Git\\KIOSK\\src\\main\\java\\image.jpg");
		ImageIcon icon2=new ImageIcon("C:\\Git\\KIOSK\\src\\main\\java\\image2.png");
		p3=new JPanel() {
			Image bg=icon1.getImage();
			Image bg1=icon2.getImage();
			public void paint(Graphics g) {
				g.drawImage(bg,500,0,500,375,null);
				g.drawImage(bg1,500,375,500,375,null);
			}
		};
		p3.setLayout(null);
		p2.setBounds(0, 0, 500, 750);
		p3.setBounds(500, 0, 500, 750);
		for(int i=0;i<6;i++) {
			btn[i]=new Button(" ");
			btn[i].setFont(new Font("맑은 고딕",Font.BOLD,70));
			p2.add(btn[i]);
		}
	}
	public void ExcelReader() {//엑셀에서 데이터를 읽어와서 arraylist에 추가하는 메소드
		
		FileInputStream fis=null;
		XSSFWorkbook workbook=null;
		list.clear();
		try {
			fis=new FileInputStream(way);
			workbook=new XSSFWorkbook(fis);
			
			XSSFSheet curSheet;
			XSSFRow curRow;
			XSSFCell curCell;
			curSheet =workbook.getSheetAt(0);
			Excelmember temp;
			
			for(int rowindex=1;rowindex<curSheet.getPhysicalNumberOfRows();rowindex++) {
				curRow=curSheet.getRow(rowindex);
				temp=new Excelmember();
				int t=0;
				String t1="";
				boolean t2=false;
				for(int cellindex=0;cellindex<curRow.getPhysicalNumberOfCells();cellindex++) {
					curCell=curRow.getCell(cellindex);
					
					switch(curCell.getCellType()) {
					
					case XSSFCell.CELL_TYPE_NUMERIC:
						t=(int) curCell.getNumericCellValue();
						break;
					case XSSFCell.CELL_TYPE_STRING:
						t1=curCell.getStringCellValue();
						break;
					case XSSFCell.CELL_TYPE_BOOLEAN:
						t2=curCell.getBooleanCellValue();
						break;
					}
					
					switch(cellindex) {
					
					case 0:temp.setNumber(t); break;
					case 1:temp.setDate(t1); break;
					case 2:temp.setOrdernum(t);break;
					case 3:temp.setFood(t);break;
					case 4:temp.setFood1(t);break;
					case 5:temp.setFood2(t);break;
					case 6:temp.setFood3(t);break;
					case 7:temp.setTotalprice(t1);break;
					case 8:temp.setPay(t1);break;
					case 9:temp.setPaytrue(t2);break;
					case 10:temp.setRecive(t2);break;
					case 11:temp.setGender(t1);break;
					case 12:temp.setAge(t1);break;
					case 13:temp.setCustomercount(t1);break;
					}
				}
				list.add(temp);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(workbook!=null) workbook.close();
				if(fis!=null) fis.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		dtm.setRowCount(0);//테이블 새로고침을 위해서 row를 전부 지움
		select();
	}
	
	public void select() {//arraylist에서 결제완료 또는 수령완료가 false면 테이블에 추가함
		
		String t[]=new String[14];
		
		for(Excelmember temp:list) {
			t[0]=Integer.toString(temp.getNumber());
			t[1]=temp.getDate();
			t[2]=Integer.toString(temp.getOrdernum());
			t[3]=Integer.toString(temp.getFood());
			t[4]=Integer.toString(temp.getFood1());
			t[5]=Integer.toString(temp.getFood2());
			t[6]=Integer.toString(temp.getFood3());
			t[7]=temp.getTotalprice();
			t[8]=temp.getPay();
			t[9]=Boolean.toString(temp.isPaytrue());	
			t[10]=Boolean.toString(temp.isRecive());
			t[11]=temp.getGender();
			t[12]=temp.getAge();
			t[13]=temp.getCustomercount();
			
			if((temp.isRecive()==false)||(temp.isPaytrue()==false)) {
				dtm.addRow(t);
			}
		}
	}
	
	public void Paycomplete() {//완성화면에서 결제완료 버튼을 눌렀을때, 작동하는 메소드
		int n=table.getSelectedRow();
		int row=Integer.parseInt((String)table.getValueAt(n, 0));
		if(n>=0&&n<table.getRowCount()) {//선택한 행의 테이블값을 true로 바꿔줌.
			table.setValueAt("true", n, 9);
		}
		Update(row,9);
		ExcelReader();
	}
	public void Receivecomplete() {//완성화면에서 수령완료 버튼을 눌렀을때 작동하는 메소드
		int n=table.getSelectedRow();
		int row=Integer.parseInt((String)table.getValueAt(n, 0));
		String num=(String)table.getValueAt(n, 2);
		if(n>=0&&n<table.getRowCount()) {//선택한 행의 테이블값을 true로 바꿔줌.
			table.setValueAt("true", n, 10);
		}
		Update(row,10);
		ExcelReader();
		PrintNumber(num);
	}
	public void Update(int row,int column) {//실제 엑셀 파일의 셀값에 접근해서 true로 바꿔줌
		FileOutputStream fos=null;
		InputStream fis=null;
		
		try {
			fis=new FileInputStream(way);
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheetAt(0);
			sheet.getRow(row).createCell(column).setCellValue(true);
			fos=new FileOutputStream(way);
			workbook.write(fos);
			workbook.close();
		} catch(IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis!=null) fis.close();
				if(fos!=null) fos.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void PrintNumber(String num) {//손님용 화면애 번호를 출력하는 메소드입니다.
		if(i==6) i%=6;
		btn[i].setLabel(num);
		i++;
	}
	public void event() {//이벤트 처리 메소드
		
		bt.addActionListener(this);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {//이벤트 처리 메소드
		
		String event=e.getActionCommand();
		switch(event) {
		
		case "결제 완료": Paycomplete();
			break;
		case "수령 완료": Receivecomplete();
			break;
		case "새로 고침": ExcelReader(); 
			break;
			
		}
	}	
}
