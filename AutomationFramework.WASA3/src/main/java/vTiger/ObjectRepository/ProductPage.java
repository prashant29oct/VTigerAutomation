package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	@FindBy(xpath = "//img[@alt='Create Product...']") private WebElement CreateProductLink;
	
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getCreateProductLink() {
		return CreateProductLink;
	}
	
	public void clickCreateProductLink() {
		CreateProductLink.click();
	}
}
