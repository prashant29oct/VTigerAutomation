package vTiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class related of generic method related to webdriver actions
 * @author Prashant
 *
 */

public class WebDriverUtility {
	
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) 
	{
		driver.manage().window().maximize();
	}
	
	/**
	 *This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	public void waitForPage(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void handleDropdown(WebElement element, int index) 
	{
	    Select s = new Select(element);
	    s.selectByIndex(index);
	}
	
	public void handleDropdown(WebElement element, String value)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	public void handleDropdown(String text, WebElement element)
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	public void rightClickAction(WebDriver driver) 
	{
		Actions a = new Actions(driver);
		a.contextClick().perform();
	}
	
	public void rightClickAction(WebDriver driver, WebElement element)
	{
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}
	
	public void doubleClickAction(WebDriver driver)
	{
		Actions a = new Actions(driver);
		a.doubleClick().perform();
	}
	
	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	public void dragAndDropAction(WebDriver driver, WebElement srcElement, WebElement dstElement)
	{
		Actions a = new Actions(driver);
		a.dragAndDrop(srcElement, dstElement).perform();
	}
	
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	
	public void handleFrame(WebDriver driver, int index) 
	{
		 driver.switchTo().frame(index);
	}
	
	public void handleFrame(WebDriver driver, String nameOrId) 
	{
		 driver.switchTo().frame(nameOrId);
	}
	
	public void handleFrame(WebDriver driver, WebElement element) 
	{
		 driver.switchTo().frame(element);
	}
	
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	public void switchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",element);
	}
	
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		//step 1: Capture all the windows id
		Set<String> winIDs = driver.getWindowHandles();
	
		
		//step 2: Navigate to each window and compare the title
		
		for(String win:winIDs)
		{
			//Step3: switch the window and capture the title
		  String winTitle = driver.switchTo().window(win).getTitle();
		  
		  //step4: compare the title with required partial title
		  if(winTitle.contains(partialWinTitle))
		  {
			  break;
		  }
		}
	}
	 
	
	public String takeScreenShot(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\ScreenShots\\"+screenshotName+".png");
		FileUtils.copyFile(src, dest);
		
		return dest.getAbsolutePath();
	}
	
}
