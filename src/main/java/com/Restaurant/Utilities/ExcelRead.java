package com.Restaurant.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Restaurant.BaseClass.BaseClass;

public class ExcelRead extends BaseClass{
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet s;
	
	public static String readStringData(int i, int j) throws IOException {
		f=new FileInputStream("C:\\Users\\user\\OneDrive\\Desktop\\Java Program\\Excel\\Book1.xlsx");
		w=new XSSFWorkbook(f);
		s=w.getSheet("Sheet1");
		Row r = s.getRow(i);
		Cell c = r.getCell(j);
		return c.getStringCellValue();
	}
	public static String readIntegerData(int i, int j) throws IOException {
		f=new FileInputStream("C:\\Users\\user\\OneDrive\\Desktop\\Java Program\\Excel\\Book1.xlsx");
		w=new XSSFWorkbook(f);
		s=w.getSheet("Sheet1");
		Row r = s.getRow(i);
		Cell c = r.getCell(j);
		int x = (int) c.getNumericCellValue();
		return String.valueOf(x);
		
		
	}

}
