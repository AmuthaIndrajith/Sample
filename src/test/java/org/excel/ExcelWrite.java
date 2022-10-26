package org.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	public static void main(String[] args) throws IOException {

		// 1. Mention the location
		File f = new File("E:\\Selenium Training\\eclipsework\\FrameworkProject\\target\\testData\\Family.xlsx");
		boolean b = f.createNewFile();
		System.out.println(b);

		// 2. Type of Workbook
		Workbook w = new XSSFWorkbook();

		// 3. Create the Sheet
		Sheet s = w.createSheet("Varsikasri");

		// 4. Create the Row
		Row r = s.createRow(1);

		// 5. Create the Cell
		Cell c = r.createCell(0);

		// 6. Pass the value on the Cell
		c.setCellValue("InderAmmu");

		// 7. Update the Sheet
		FileOutputStream fout = new FileOutputStream(f);
		w.write(fout);
		System.out.println("SUCCESS");

	}

}
