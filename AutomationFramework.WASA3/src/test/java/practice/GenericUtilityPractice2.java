package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import vTiger.GenericUtilities.ExcelFileUtility;

public class GenericUtilityPractice2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		ExcelFileUtility efu = new ExcelFileUtility();
		String value = efu.readDataFromTheExcelSheet("Contact",4,2);
		System.out.println(value);
		
		System.out.println(efu.getRowCount("Organization"));

	}

}
