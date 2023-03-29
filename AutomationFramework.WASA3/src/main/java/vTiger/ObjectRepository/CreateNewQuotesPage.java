package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreateNewQuotesPage extends WebDriverUtility{

	@FindBy(name = "subject") private WebElement SubjectEdit;
	@FindBy(name = "quotestage") private WebElement QuoteStageDropDown;
	@FindBy(xpath = "//img[contains(@onclick,'return window.open')]") private WebElement OrgNameLookUpBtn;
	@FindBy(name = "bill_street") private WebElement BillAddressEdit;
	@FindBy(xpath = "//b[text()='Copy Billing address']/../input") private WebElement CopyRadioBtn;
	@FindBy(id = "searchIcon1") private WebElement ProductLookBtn;
	@FindBy(id = "comment1") private WebElement ItemDetailsEdit;
	@FindBy(id = "search_txt") private WebElement SearchEdit;
	@FindBy(name = "search") private WebElement SearchBtn;
	@FindBy(name = "button") private WebElement SaveBtn;
	@FindBy(id = "qty1") private WebElement QuantityEdit;
	@FindBy(id = "listPrice1") private WebElement ListPriceEdit;
	
	
	public CreateNewQuotesPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getSubjectEdit() {
		return SubjectEdit;
	}


	public WebElement getQuoteStageDropDown() {
		return QuoteStageDropDown;
	}


	public WebElement getOrgNameLookUpBtn() {
		return OrgNameLookUpBtn;
	}


	public WebElement getBillAddressEdit() {
		return BillAddressEdit;
	}


	public WebElement getCopyRadioBtn() {
		return CopyRadioBtn;
	}


	public WebElement getProductLookBtn() {
		return ProductLookBtn;
	}


	public WebElement getSearchEdit() {
		return SearchEdit;
	}


	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	

	public WebElement getItemDetailsEdit() {
		return ItemDetailsEdit;
	}


	public WebElement getSearchBtn() {
		return SearchBtn;
	}


	public WebElement getQuantityEdit() {
		return QuantityEdit;
	}


	public WebElement getListPriceEdit() {
		return ListPriceEdit;
	}
	
	public void createQuotes(WebDriver driver,String subjectName,String stageName,String orgName,String billAddress, String productName) throws InterruptedException
	{
		SubjectEdit.sendKeys(subjectName);
		handleDropdown(QuoteStageDropDown, stageName);
		OrgNameLookUpBtn.click();
		switchToWindow(driver, "Accounts");
		SearchEdit.sendKeys(orgName);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Quotes");
		BillAddressEdit.sendKeys(billAddress);
		CopyRadioBtn.click();
		scrollAction(driver, ItemDetailsEdit);
		ProductLookBtn.click();
		switchToWindow(driver, "Products");
		SearchEdit.sendKeys(productName);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
		switchToWindow(driver, "Quotes");
		QuantityEdit.sendKeys("50");
		ListPriceEdit.sendKeys("1000");
		Thread.sleep(5000);
		
		SaveBtn.click();
		
	}
}
