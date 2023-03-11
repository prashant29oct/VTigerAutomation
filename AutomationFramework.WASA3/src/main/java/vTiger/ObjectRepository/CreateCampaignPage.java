package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreateCampaignPage extends WebDriverUtility{
	
	@FindBy(name = "campaignname") private WebElement CampaignNameEdit;
	@FindBy(xpath = "//img[@alt='Select']") private WebElement ProductLookBtn;
	@FindBy(id = "search_txt") private WebElement SearchEdit;
	@FindBy(name = "search") private WebElement SearchBtn;
	@FindBy(xpath = "//a[@href='javascript:window.close();']") private WebElement ProductLink;
    @FindBy(id = "jscal_trigger_closingdate") private WebElement CalenderBtn;
    @FindBy(name = "button") private WebElement SaveBtn;
    
    
    public CreateCampaignPage(WebDriver driver)
    {
    	PageFactory.initElements(driver,this);
    }


	public WebElement getCampaignNameEdit() {
		return CampaignNameEdit;
	}


	public WebElement getProductLookBtn() {
		return ProductLookBtn;
	}


	public WebElement getSearchEdit() {
		return SearchEdit;
	}


	public WebElement getSearchBtn() {
		return SearchBtn;
	}


	public WebElement getProductLink() {
		return ProductLink;
	}


	public WebElement getCalenderBtn() {
		return CalenderBtn;
	}


	public WebElement getSaveBtn() {
		return SaveBtn;
	}
    
    //Business Libraries
	
	public void createCampaign(WebDriver driver,String campaignName,String productName)
	{
		CampaignNameEdit.sendKeys(campaignName);
		ProductLookBtn.click();
		switchToWindow(driver, "Products");
		SearchEdit.sendKeys(productName);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
		switchToWindow(driver, "Campaigns");
		SaveBtn.click();
		
	}
	
	
	
	
	
	
	
	
	
}
