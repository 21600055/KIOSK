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
	String way="D:\\"+today+"HAC장사 장부.xlsx";
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
		 cell.setCellValue("주문번호");
		 cell=row.createCell(3);
		 cell.setCellValue("오코S");
		 cell=row.createCell(4);
		 cell.setCellValue("오코L");
		 cell=row.createCell(5);
		 cell.setCellValue("타코");
		 cell=row.createCell(6);
		 cell.setCellValue("매운맛");
		 cell=row.createCell(7);
		 cell.setCellValue("총가격");
		 cell=row.createCell(8);
		 cell.setCellValue("결제수단");
		 cell=row.createCell(9);
		 cell.setCellValue("결제완료");
		 cell=row.createCell(10);
		 cell.setCellValue("수령");
		 cell=row.createCell(11);
		 cell.setCellValue("성별");
		 cell=row.createCell(12);
		 cell.setCellValue("어른/학생");
		 cell=row.createCell(13);
		 cell.setCellValue("고객수");
		 
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
