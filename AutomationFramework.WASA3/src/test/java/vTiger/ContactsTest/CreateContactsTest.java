package vTiger.ContactsTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.ContactInformationPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreatingNewContactPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationPage;

public class CreateContactsTest extends BaseClass {

	@Test
	public void createContactTest() throws EncryptedDocumentException, IOException {
		
		String lastname = eUtils.readDataFromTheExcelSheet("Contact", 1, 0)+jUtils.getRandomNumber();
		
		HomePage hp = new HomePage(driver);
		hp.clickContactLink();
		
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createNewContact(lastname);
		
		ContactInformationPage cip = new ContactInformationPage(driver);
		String ContactHeader = cip.getContactHeader();
		
		if(ContactHeader.contains(lastname)) {
			System.out.println("Conact created successfully");
		}else {
			System.out.println("Contact not created");
		}
		
	}

}
