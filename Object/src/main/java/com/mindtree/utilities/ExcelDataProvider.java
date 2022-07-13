package com.mindtree.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.*;

public class ExcelDataProvider {
	
	HSSFWorkbook wb;
	public ExcelDataProvider() {
		File src=new File("C:\\Users\\mindc1may275\\Desktop\\java\\Object\\textdata\\Data.xls");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			
			wb=new HSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read Excel File"+e.getMessage());
		}
		
	}
	
	public String getStringData(int sheetindex,int row,int column) {
		return wb.getSheetAt(sheetindex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumericData(String sheetName,int row,int column) {
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}
	
	public String getStringData(String sheetName,int row,int column) {
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}

}
