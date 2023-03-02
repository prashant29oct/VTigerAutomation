package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	@FindBy(xpath = "//img[@alt='Create Organization...']") private WebElement CreateOrgLink;
	@FindBy(linkText = "edit") private WebElement EditLink;
	@FindBy(linkText = "del") private WebElement DelLink;
	
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getCreateOrgLink() {
		return CreateOrgLink;
	}
	
	public WebElement getEditLink() {
		return EditLink;
	}

	public WebElement getDelLink() {
		return DelLink;
	}
	
	//Business Libraries
	
	public void clickCreateOrgImage()
	{
		CreateOrgLink.click();
	}
	
}
