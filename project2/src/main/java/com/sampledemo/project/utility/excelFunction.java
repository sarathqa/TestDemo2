package com.sampledemo.project.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelFunction {
	
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	
	public static void loadWorkbook(String Filename)
	{
		try {
			FileInputStream fs= new FileInputStream(Filename);
			wb = new XSSFWorkbook(fs);
			//sh =wb.getSheetAt(sheetindex);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static int getcol(String sheetName) 
	{
		
		sh =wb.getSheet(sheetName);
		
		
		int lastCellNum = sh.getRow(0).getLastCellNum();
		 return lastCellNum;
		
	}
	public static int getrows(String sheetName) 
	{
		sh =wb.getSheet(sheetName);
		int lastRowNum = sh.getLastRowNum();
		 return lastRowNum;
		
	}
	
	
	public static String getdata(String sheetName, int rowno, int colno){
		sh =wb.getSheet(sheetName);
		Cell ce =sh.getRow(rowno).getCell(colno);
		
		
		if(ce.getCellType()==Cell.CELL_TYPE_STRING){
			return ce.getStringCellValue();
		}
			
		else{
			
			return NumberToTextConverter.toText(ce.getNumericCellValue());
			
			
		}
	
	}

	
}
