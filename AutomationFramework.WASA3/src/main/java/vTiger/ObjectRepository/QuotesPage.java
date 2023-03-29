package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuotesPage {

	@FindBy(xpath = "//img[@alt='Create Quote...']") private WebElement CreateQuoteBtn;
	
	public QuotesPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getCreateQuoteBtn() {
		return CreateQuoteBtn;
	}
	
	public void clickCreateQuoteBtn()
	{
		CreateQuoteBtn.click();
	}
}
