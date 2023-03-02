package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {
	
	@FindBy(name = "accountname") private WebElement OrgNameEdit;
	@FindBy(name = "button") private WebElement SaveBtn;
	
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrgNameEdit() {
		return OrgNameEdit;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	public void createOrg(String orgName)
	{
		OrgNameEdit.sendKeys(orgName);
		SaveBtn.click();
	}
	
}
