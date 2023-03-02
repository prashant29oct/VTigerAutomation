package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateLeadTestCasePractice {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		WebElement homePageElement = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		if(homePageElement.isDisplayed()) {
			System.out.println("Home page is displayed");
		}else {
			System.out.println("Home page is not displayed");
		}
		driver.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("Dubey");
		driver.findElement(By.name("company")).sendKeys("Samsung");
		driver.findElement(By.name("button")).click();
		
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Lead Information')]"));
		if (element.isDisplayed()) {
			System.out.println("New lead is created successfully");
		}else {
			System.out.println("New lead is not created");
		}
		Thread.sleep(2000);
		driver.quit();
		

	}

}
