package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario2 {

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
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("TestYantra");
		driver.findElement(By.name("button")).click();
		
		String OrganizationHeader = driver.findElement(By.xpath("//span[contains(text(),'TestYantra -  Organization Information')]")).getText();
		if (OrganizationHeader.contains("TestYantra")) {
			System.out.println("New oranization is created successfully");
		}else {
			System.out.println("new organization is not created");
		}
		WebElement element = driver.findElement(By.xpath("//img[contains(@src,'softed/images/user.PNG')]"));
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(2000);
		driver.quit();
	}

}
