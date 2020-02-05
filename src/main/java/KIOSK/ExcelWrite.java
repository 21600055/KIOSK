 package KIOSK;

import java.util.ArrayList;
import java.util.Date;
import java.io.File;
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
	String way="D:\\"+today+"HAC��� ���.xlsx";
	public ExcelWrite(ArrayList<Excelmember> row) {
		data=row.get(0);
		xlsxwriter();
	}
	public void xlsxwriter() {
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
}
