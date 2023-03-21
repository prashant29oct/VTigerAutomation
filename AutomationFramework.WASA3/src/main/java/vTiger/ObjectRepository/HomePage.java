package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{

	@FindBy(linkText = "Leads") private WebElement LeadLink;
	@FindBy(linkText = "Organizations") private WebElement OrganizationLink;
	@FindBy(linkText = "Products") private WebElement ProductsLink;
	@FindBy(linkText = "Contacts") private WebElement ContactsLink;
	@FindBy(linkText = "Campaigns") private WebElement CampaignsLink;
	@FindBy(linkText = "Quotes") private WebElement QuotesLink;
	@FindBy(linkText =  "More") private WebElement MouseHoverToMore;
	@FindBy(linkText = "Sign Out") private WebElement SignOutLink;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']") private WebElement MouseHoverToAdmin;
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLeadLink() {
		return LeadLink;
	}

	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}
	
	public WebElement getProductsLink() {
		return ProductsLink;
	}
	
	public WebElement getCampaignsLink() {
		return CampaignsLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}
	public WebElement getSignOutLink() {
		return SignOutLink;
	}
	
	
	public WebElement getQuotesLink() {
		return QuotesLink;
	}

	public WebElement getMouseHoverToAdmin() {
		return MouseHoverToAdmin;
	}
	
	public WebElement getMouseHoverToMore() {
		return MouseHoverToMore;
	}
	
	//Business Libraries
	public void clickOrganizationLink()
	{
		OrganizationLink.click();
	}
	
	public void clickContactLink() {
		ContactsLink.click();
	}
	
	
	public void clickProductsLink() {
		ProductsLink.click();
	}
	
	public void clickQuotesLink(WebDriver driver)
	{
		mouseHoverAction(driver, MouseHoverToMore);
		QuotesLink.click();
	}
	
	public void clickCampaignsLink(WebDriver driver) throws InterruptedException {
		mouseHoverAction(driver, MouseHoverToMore);
		CampaignsLink.click();
	}
	
	public void clickOnSignOut(WebDriver driver)
	{
		mouseHoverAction(driver, MouseHoverToAdmin);
		SignOutLink.click();
	}
}
