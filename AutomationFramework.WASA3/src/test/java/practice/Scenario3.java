package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Scenario3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
	
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("TestYantra");
		WebElement IndustryDropDown = driver.findElement(By.name("industry"));
		Select s = new Select(IndustryDropDown);
		s.selectByValue("Chemicals");	
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
