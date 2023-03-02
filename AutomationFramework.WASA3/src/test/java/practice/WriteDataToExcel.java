package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class WriteDataToExcel {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet("Contact");
	Row row = sheet.getRow(0);
	Cell cell = row.createCell(3);
	cell.setCellValue("Revenue");
	
	FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
	wb.write(fos);
	wb.close();
}
}
