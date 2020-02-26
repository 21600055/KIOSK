 package KIOSK;

import java.util.ArrayList;
import java.util.Date;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.apache.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	
	Excelmember data=new Excelmember();
	String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	String way="C:\\Users\\user\\Desktop\\"+today+"HAC��� ���.xlsx";
	ArrayList<Excelmember> list=new ArrayList<Excelmember>(); 
	
	public ExcelWrite(Excelmember row) {//���� �ۼ��ϴ� �޼ҵ��Դϴ�. poi �ܺζ��̺귯�� ����ϴ�.
		data=row;
		File file=new File(way);
		if(file.exists()) {
			xlsxReader();
		} else {
			xlsxWriter();
		}
	}
	public void xlsxWriter() {//���� ���� ó�� �ۼ��Ҷ� ���� �޼ҵ��Դϴ�.
		 XSSFWorkbook workbook = new XSSFWorkbook();
		 XSSFSheet sheet= workbook.createSheet();
		 XSSFRow row=sheet.createRow(0);
		 XSSFCell cell;
		 
		 cell=row.createCell(0);
		 cell.setCellValue("No.");
		 cell=row.createCell(1);
		 cell.setCellValue("Timecode");
		 cell=row.createCell(2);
		 cell.setCellValue("�ֹ���ȣ");
		 cell=row.createCell(3);
		 cell.setCellValue("����S");
		 cell=row.createCell(4);
		 cell.setCellValue("����L");
		 cell=row.createCell(5);
		 cell.setCellValue("Ÿ��");
		 cell=row.createCell(6);
		 cell.setCellValue("�ſ��");
		 cell=row.createCell(7);
		 cell.setCellValue("�Ѱ���");
		 cell=row.createCell(8);
		 cell.setCellValue("��������");
		 cell=row.createCell(9);
		 cell.setCellValue("�����Ϸ�");
		 cell=row.createCell(10);
		 cell.setCellValue("����");
		 cell=row.createCell(11);
		 cell.setCellValue("����");
		 cell=row.createCell(12);
		 cell.setCellValue("�/�л�");
		 cell=row.createCell(13);
		 cell.setCellValue("����");
		 
		 row=sheet.createRow(data.getNumber());
		 cell=row.createCell(0);
		 cell.setCellValue(data.getNumber());
		 cell=row.createCell(1);
		 cell.setCellValue(data.getDate());
		 cell=row.createCell(2);
		 cell.setCellValue(data.getOrdernum());
		 cell=row.createCell(3);
		 cell.setCellValue(data.getFood());
		 cell=row.createCell(4);
		 cell.setCellValue(data.getFood1());
		 cell=row.createCell(5);
		 cell.setCellValue(data.getFood2());
		 cell=row.createCell(6);
		 cell.setCellValue(data.getFood3());
		 cell=row.createCell(7);
		 cell.setCellValue(data.getTotalprice());
		 cell=row.createCell(8);
		 cell.setCellValue(data.getPay());
		 cell=row.createCell(9);
		 cell.setCellValue(data.isPaytrue());
		 cell=row.createCell(10);
		 cell.setCellValue(data.isRecive());
		 cell=row.createCell(11);
		 cell.setCellValue(data.getGender());
		 cell=row.createCell(12);
		 cell.setCellValue(data.getAge());
		 cell=row.createCell(13);
		 cell.setCellValue(data.getCustomercount());
		 
		 File file=new File(way);
		 FileOutputStream fos=null;
		 
		 try {
			 fos=new FileOutputStream(file);
			 workbook.write(fos);
		 } catch(FileNotFoundException e) {
			 e.printStackTrace();
		 } catch(IOException e) {
			 e.printStackTrace();
		 } finally {
			 try {
				 if(workbook!=null) workbook.close();
				 if(fos!=null)fos.close();
			 } catch(IOException e){
				 e.printStackTrace();
			 }
		 }
	}

	public void xlsxReader() {//������ ������, ������ �о�ͼ� �ٽ� Update �޼ҵ�� �����ϴ�.
		
		FileInputStream fis=null;
		XSSFWorkbook workbook=null;
		
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
		list.add(data);
		Update();
	}
	
	public void Update() {//������Ʈ �޼ҵ�
		 XSSFWorkbook workbook = new XSSFWorkbook();
		 XSSFSheet sheet= workbook.createSheet();
		 XSSFRow row=sheet.createRow(0);
		 XSSFCell cell;
		 
		 cell=row.createCell(0);
		 cell.setCellValue("No.");
		 cell=row.createCell(1);
		 cell.setCellValue("Timecode");
		 cell=row.createCell(2);
		 cell.setCellValue("�ֹ���ȣ");
		 cell=row.createCell(3);
		 cell.setCellValue("����S");
		 cell=row.createCell(4);
		 cell.setCellValue("����L");
		 cell=row.createCell(5);
		 cell.setCellValue("Ÿ��");
		 cell=row.createCell(6);
		 cell.setCellValue("�ſ��");
		 cell=row.createCell(7);
		 cell.setCellValue("�Ѱ���");
		 cell=row.createCell(8);
		 cell.setCellValue("��������");
		 cell=row.createCell(9);
		 cell.setCellValue("�����Ϸ�");
		 cell=row.createCell(10);
		 cell.setCellValue("����");
		 cell=row.createCell(11);
		 cell.setCellValue("����");
		 cell=row.createCell(12);
		 cell.setCellValue("�/�л�");
		 cell=row.createCell(13);
		 cell.setCellValue("����");
		 
		 Excelmember temp;
		 for(int rowindex=0;rowindex<list.size();rowindex++) {
			 temp=list.get(rowindex);
			 row=sheet.createRow(rowindex+1);
			 cell=row.createCell(0);
			 cell.setCellValue(temp.getNumber());
			 cell=row.createCell(1);
			 cell.setCellValue(temp.getDate());
			 cell=row.createCell(2);
			 cell.setCellValue(temp.getOrdernum());
			 cell=row.createCell(3);
			 cell.setCellValue(temp.getFood());
			 cell=row.createCell(4);
			 cell.setCellValue(temp.getFood1());
			 cell=row.createCell(5);
			 cell.setCellValue(temp.getFood2());
			 cell=row.createCell(6);
			 cell.setCellValue(temp.getFood3());
			 cell=row.createCell(7);
			 cell.setCellValue(temp.getTotalprice());
			 cell=row.createCell(8);
			 cell.setCellValue(temp.getPay());
			 cell=row.createCell(9);
			 cell.setCellValue(temp.isPaytrue());
			 cell=row.createCell(10);
			 cell.setCellValue(temp.isRecive());
			 cell=row.createCell(11);
			 cell.setCellValue(temp.getGender());
			 cell=row.createCell(12);
			 cell.setCellValue(temp.getAge());
			 cell=row.createCell(13);
			 cell.setCellValue(temp.getCustomercount());
		 }
		 File file=new File(way);
		 FileOutputStream fos=null;
		 
		 try {
			 fos=new FileOutputStream(file);
			 workbook.write(fos);
		 } catch(FileNotFoundException e) {
			 e.printStackTrace();
		 } catch(IOException e) {
			 e.printStackTrace();
		 } finally {
			 try {
				 if(workbook!=null) workbook.close();
				 if(fos!=null)fos.close();
			 } catch(IOException e){
				 e.printStackTrace();
			 }
		 }
	}
}