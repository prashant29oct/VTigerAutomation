package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	@FindAll({@FindBy(xpath = "//img[@alt='Create Contact...']"),@FindBy(xpath = "//img[@title='Create Contact...']")})
	private WebElement CreateConatctLink;
	
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getCreateConatctLink() {
		return CreateConatctLink;
	}

	public void clickOnCreateContactImg() 
	{
	CreateConatctLink.click();
	
}
}
