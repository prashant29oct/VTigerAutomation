package vTiger.OrganizationTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.CreatingNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInformationPage;
import vTiger.ObjectRepository.OrganizationPage;

@Listeners(vTiger.GenericUtilities.ListernersImplementation.class)
public class CreateOrganizationTest extends BaseClass{

	@Test
	public void createOrganizationTest() throws IOException, InterruptedException {
        
        String org_name = eUtils.readDataFromTheExcelSheet("Organization", 1, 2)+jUtils.getRandomNumber();
     
        HomePage hp = new HomePage(driver);
        hp.clickOrganizationLink();
        
        OrganizationPage op = new OrganizationPage(driver);
        op.clickCreateOrgImage();
        
        CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
        cnop.createOrg(org_name);
        
        OrganizationInformationPage oip = new OrganizationInformationPage(driver);
        String OrgHeader = oip.getOrgHeader();
		
        Assert.assertTrue(OrgHeader.contains(org_name));
        System.out.println(org_name+"------"+"Organization is created"); 

}
	
}
