package vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	public String readDataFromTheExcelSheet(String SheetName, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(SheetName).getRow(row).getCell(cell).getStringCellValue();
		wb.close();
		return value;		
		
	}
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		int rowCount = sh.getLastRowNum();
		wb.close();
		return rowCount;
	}
	

}
