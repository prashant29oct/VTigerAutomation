package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadDataFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sheet = wb.getSheet("Contact");
		
		Row row = sheet.getRow(4);
		Cell cell = row.getCell(2);
		
		String data = cell.getStringCellValue();
		
		System.out.println(data);
		
		String data2 = wb.getSheet("Organization").getRow(1).getCell(1).getStringCellValue();
		System.out.println(data2);
		wb.close();
		
		
	}

}
