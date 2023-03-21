package vTiger.ContactsTest;

import java.io.IOException;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.ContactInformationPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreatingNewContactPage;
import vTiger.ObjectRepository.CreatingNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInformationPage;
import vTiger.ObjectRepository.OrganizationPage;

@Listeners(vTiger.GenericUtilities.ListernersImplementation.class)
public class CreateContactWithOrgTest extends BaseClass {

	@Test
	public void createContactWithOrgTest() throws IOException {
		

		String lastname = eUtils.readDataFromTheExcelSheet("Contact", 4, 3)+jUtils.getRandomNumber();
		String orgName = eUtils.readDataFromTheExcelSheet("Contact", 4, 2)+jUtils.getRandomNumber();
		
		
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		OrganizationPage op = new OrganizationPage(driver);
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		ContactsPage cp = new ContactsPage(driver);
		ContactInformationPage cip = new ContactInformationPage(driver);
		
		
		hp.clickOrganizationLink();
		Reporter.log("Click on Org link successfull");
		
		op.clickCreateOrgImage();
		Reporter.log("Click on Create Org image successfull");
		
		cnop.createOrg(orgName);
		Reporter.log("Create Org successfull");
		
		String OrgHeader = oip.getOrgHeader();
		Assert.assertTrue(OrgHeader.contains(orgName));
		System.out.println(OrgHeader+"-----"+"Orgainization Created");
		
		
		hp.clickContactLink();
		Reporter.log("Click on Contact link successfull");
		
		cp.clickOnCreateContactImg();
		Reporter.log("Click on Create Contact Imgage successfull");
		
		cncp.createNewContact(driver, lastname, orgName);
		Reporter.log("Create new Contact successfull");
		
		String ContactHeader = cip.getContactHeader();
		Assert.assertTrue(ContactHeader.contains(lastname));
		System.out.println(ContactHeader+"------"+"Contact Created");
		
	}
}
