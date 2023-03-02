package vTiger.GenericUtilities;
/**
 * This class consists of basic config annotations of TestNG
 * @author Prashant
 *
 */

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

public class BaseClass {
	
	public ExcelFileUtility eUtils = new ExcelFileUtility();
	public PropertyFileUtility pUtils = new PropertyFileUtility();
	public JavaUtility jUtils = new JavaUtility();
	public WebDriverUtility wUtils = new WebDriverUtility();
	
	public WebDriver driver;

	@BeforeSuite
	public void bsCongig()
	{
		System.out.println("Database config successfully");
	}
	
	@BeforeClass
	public void bcConfig() throws IOException
	{
		String URL = pUtils.readDataFromPropertyFile("url");
		String BROWSER = pUtils.readDataFromPropertyFile("browser");
		
		//Launch the browser - runtime polymorphism
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			System.out.println("----- "+BROWSER+" Launched succesfully-----");
		}else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			System.out.println("----- "+BROWSER+" Launched succesfully-----");
		}else
		{
			System.out.println("Incompatible browser");
		}
		
		wUtils.maximizeWindow(driver);
		wUtils.waitForPage(driver);
		driver.get(URL);
	}
	
	@BeforeMethod
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtils.readDataFromPropertyFile("username");
		String PASSWORD = pUtils.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("----- Login successful -----");
	}
	
	@AfterMethod
	public void amConfig()
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnSignOut(driver);
		System.out.println("----- Logout successful -----");
	}
	
	@AfterClass
	public void acConfig()
	{
		driver.quit();
		System.out.println("----- Browser Closed successfully -----");
	}
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("Database close successfully");
	}
}

