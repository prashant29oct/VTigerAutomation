package practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import vTiger.ObjectRepository.LoginPage;

public class PomClassPractice {

	public static void main(String[] args) throws InterruptedException {

          WebDriver driver  = new ChromeDriver();
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
          driver.get("http://localhost:8888/");
          
          LoginPage lp = new LoginPage(driver);
     //     lp.getUsernameEdit().sendKeys("admin");
      //    lp.getPasswordEdit().sendKeys("admin");
        //  lp.getSubmitBtn().click();
          lp.loginToApp("admin", "admin");
          
          Thread.sleep(2000);
          
          driver.quit();
          

	}

}
