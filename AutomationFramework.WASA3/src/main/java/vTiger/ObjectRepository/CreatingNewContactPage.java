package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreatingNewContactPage extends WebDriverUtility {

	@FindBy(name = "lastname") private WebElement LastNameEdit;
	@FindBy(xpath = "//img[@alt='Select'][1]") private WebElement OrgLookUpLink;
	@FindBy(id = "search_txt") private WebElement SearchField;
	@FindBy(name = "search") private WebElement SearchBtn;
	@FindBy(xpath = "//a[@href='javascript:window.close();']") private WebElement OrgLink;
	@FindBy(name = "button") private WebElement SaveBtn;
	
	public CreatingNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getLastNameEdit() {
		return LastNameEdit;
	}

	public WebElement getOrgLookUpLink() {
		return OrgLookUpLink;
	}
	
	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getSearchField() {
		return SearchField;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public WebElement getOrgLink() {
		return OrgLink;
	}

	//Business Library
	public void createNewContact(String LastName) {
		
		LastNameEdit.sendKeys(LastName);
		SaveBtn.click();
	
	}
	
	public void createNewContact(WebDriver driver, String LastName, String OrgName)
	{
		
		LastNameEdit.sendKeys(LastName);
		OrgLookUpLink.click();
		switchToWindow(driver, "Account");
		SearchField.sendKeys(OrgName);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
		switchToWindow(driver, "Contact");
		SaveBtn.click();
	}

	
}
