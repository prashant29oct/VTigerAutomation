package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreatingNewOrganizationPage extends WebDriverUtility {
	
	@FindBy(name = "accountname") private WebElement OrgNameEdit;
	@FindBy(name = "industry") private WebElement IndustryDropDown;
	@FindBy(name = "button") private WebElement SaveBtn;
	
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrgNameEdit() {
		return OrgNameEdit;
	}
	
	

	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	public void createOrg(String orgName)
	{
		OrgNameEdit.sendKeys(orgName);
		SaveBtn.click();
	}
	
	public void createOrg(String orgName, String Industry)
	{
		OrgNameEdit.sendKeys(orgName);
		handleDropdown(IndustryDropDown, Industry);
		SaveBtn.click();
	}
	
}
