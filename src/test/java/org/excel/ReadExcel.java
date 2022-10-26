package org.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static void main(String[] args) throws IOException {
		//1. Declare the location of ur excel sheet
		File f=new File("E:\\Selenium Training\\eclipsework\\FrameworkProject\\target\\testData\\Fam.xlsx");
		
		//2. To Read the file
		FileInputStream fin = new FileInputStream(f);
		
		//3. Type of Workbook
		Workbook w= new XSSFWorkbook(fin);
		
		//4. Get the sheet from Workbook
		Sheet s = w.getSheet("Family");
		
		//5. Check the word
		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			Row row = s.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				int cellType = cell.getCellType();
				if (cellType == 1) {
					String value = cell.getStringCellValue();
					if (value.contains("Avadi")) {
						cell.setCellValue("Osur");
					FileOutputStream fout=new FileOutputStream(f);
					w.write(fout);
					System.out.println("Updated");
					}
				}
			}
		}
		
		
		//5. Get the row
		Row r = s.getRow(4);
		
		//6. Get the cell
		Cell c = r.getCell(4);
		System.out.println(c);
		
		//7. Get the Physical Row
		int a = s.getPhysicalNumberOfRows();
		System.out.println("Physical Number of Rows: "+a);
		
		//8. Get the Physical Cell
		//Row row = s.getRow(1);
		int b = r.getPhysicalNumberOfCells();
		System.out.println("Physical Number of Cells: "+b);
		
		//9. Iterate all the Values and Resolving the Format issue
		//Sheet s = w.getSheet("Family");
		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			Row row = s.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				int cellType = cell.getCellType();
				
				if (cellType==1) {
					String value = cell.getStringCellValue();
					System.out.println(value);
					}
				else if (DateUtil.isCellDateFormatted(cell)) {
					Date date = cell.getDateCellValue();
					SimpleDateFormat sim=new SimpleDateFormat("dd, MMMM, yyyy");
					String value = sim.format(date);
					System.out.println(value);
					}
				else {
					double d = cell.getNumericCellValue();
					long l=(long)d;
					String value = String.valueOf(l);
					System.out.println(value);

				}
				
			}
		}
		
		
	}

}
