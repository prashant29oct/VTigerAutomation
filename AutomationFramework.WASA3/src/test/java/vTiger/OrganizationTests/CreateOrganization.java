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
import org.testng.annotations.Test;

import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;

public class CreateOrganization {

	@Test
	public void createOrganizationTest() throws IOException, InterruptedException {
		
		ExcelFileUtility eUtils = new ExcelFileUtility();
		PropertyFileUtility pUtils = new PropertyFileUtility();
		JavaUtility jUtils = new JavaUtility();
		WebDriverUtility wUtils = new WebDriverUtility();
	    
		String URL = pUtils.readDataFromPropertyFile("url");
        String BROWSER = pUtils.readDataFromPropertyFile("browser");
        String USERNAME = pUtils.readDataFromPropertyFile("username");
        String PASSWORD = pUtils.readDataFromPropertyFile("password");
        
        String org_name = eUtils.readDataFromTheExcelSheet("Organization", 1, 2)+jUtils.getRandomNumber();
        
        WebDriver driver = null;
        if(BROWSER.equalsIgnoreCase("chrome")) {
        	driver = new ChromeDriver();
        }else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
              System.out.println("Invalid browser name");
		}
        
        wUtils.maximizeWindow(driver);
        wUtils.waitForPage(driver);
        driver.get(URL);
        
        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(org_name);
		driver.findElement(By.name("button")).click();
		
		String OrganizationHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (OrganizationHeader.contains(org_name)) {
			System.out.println("New oranization is created successfully");
		}else {
			System.out.println("new organization is not created");

	}   
		WebElement element = driver.findElement(By.xpath("//img[contains(@src,'softed/images/user.PNG')]"));
		wUtils.mouseHoverAction(driver, element);
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(2000);
		driver.quit();

}
}
