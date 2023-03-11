package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	
	@FindBy(xpath = "//img[@alt='Create Campaign...']") private WebElement CreateCampaignBtn;
	
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getCreateCampaignBtn() {
		return CreateCampaignBtn;
	}
	
	public void clickCreateCampaignBtn()
	{
		CreateCampaignBtn.click();
	}

}
