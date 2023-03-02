package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys("Verma");
		driver.findElement(By.name("button")).click();
		
		String ContactHeader = driver.findElement(By.xpath("//span[contains(text(),'Verma  -  Contact Information')]")).getText();
        if(ContactHeader.contains("Verma")) {
        	System.out.println("Contact Created Successfully");
        }else {
			System.out.println("Contact is not created");
		}
        WebElement element = driver.findElement(By.xpath("//img[contains(@src,'softed/images/user.PNG')]"));
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(2000);
		driver.quit();
	}

}
