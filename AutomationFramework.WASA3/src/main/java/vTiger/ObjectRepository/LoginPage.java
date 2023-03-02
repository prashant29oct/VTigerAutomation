package vTiger.ObjectRepository;
/**
 * 
 * @author Prashant
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //rule1 : create a pom class for every web page
    
	// Identify WebElement with @FindBy, @FindAll and @FindBys
	@FindBy(name = "user_name") 
	private WebElement UsernameEdit;
	
	@FindAll({@FindBy(name = "user_password"),@FindBy(xpath = "//input[@type='password']")}) 
	private WebElement PasswordEdit;
	
	@FindBy(id="submitButton")
	private WebElement SubmitBtn;
	
	//Create a constructor to initialize these web element
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}

	//Provide getter to access these elements
	public WebElement getUsernameEdit() {
		return UsernameEdit;
	}

	public WebElement getPasswordEdit() {
		return PasswordEdit;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	//Business Libraries - generic methods specific to current project
	public void loginToApp(String Username, String Password)
	{
		UsernameEdit.sendKeys(Username);
		PasswordEdit.sendKeys(Password);
		SubmitBtn.click();
	}
	
}
