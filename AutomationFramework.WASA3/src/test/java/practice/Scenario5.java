package practice;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;


public class Scenario5 {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		ExcelFileUtility eUtils = new ExcelFileUtility();
		PropertyFileUtility pUtils = new PropertyFileUtility();
		JavaUtility jUtils = new JavaUtility();
		WebDriverUtility wUtils = new WebDriverUtility();
	    
		String URL = pUtils.readDataFromPropertyFile("url");
        String BROWSER = pUtils.readDataFromPropertyFile("browser");
        String USERNAME = pUtils.readDataFromPropertyFile("username");
        String PASSWORD = pUtils.readDataFromPropertyFile("password");
        
        
		WebDriver driver = new ChromeDriver();
		wUtils.maximizeWindow(driver);
		wUtils.waitForPage(driver);
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
	
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys("Gupta");
		driver.findElement(By.xpath("//input[@name='account_name']//following-sibling::img")).click();
		
		wUtils.switchToWindow(driver, "Organizations");
		
		driver.findElement(By.linkText("Qspider300")).click();
		wUtils.switchToWindow(driver, "Contact");
		driver.findElement(By.name("button")).click();
		
		String ContactHeader = driver.findElement(By.xpath("//span[contains(text(),'Gupta  -  Contact Information')]")).getText();
        if(ContactHeader.contains("Gupta")) {
        	System.out.println("Contact Created Successfully");
        }else {
			System.out.println("Contact is not created");
		}
        WebElement element = driver.findElement(By.xpath("//img[contains(@src,'softed/images/user.PNG')]"));
		wUtils.mouseHoverAction(driver, element);
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(2000);
		driver.quit();

	}

}
