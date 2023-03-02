package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContactInformationPage {
	
	@FindBy(xpath = "//span[@class='dvHeaderText']") private WebElement HeaderText;

	
	

	public ContactInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getHeaderText() {
		return HeaderText;
	}
	
	public String getContactHeader()
	{
		return HeaderText.getText();
	}
	
}
