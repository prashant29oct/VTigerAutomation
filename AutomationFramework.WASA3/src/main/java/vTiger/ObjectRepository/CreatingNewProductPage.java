package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreatingNewProductPage extends WebDriverUtility{

	@FindBy(name = "productname") private WebElement ProductNameEdit;
	@FindBy(name = "productcategory") private WebElement ProductCategoryDropDown;
	@FindBy(name = "button") private WebElement SaveBtn;
	
	public CreatingNewProductPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}

	public WebElement getProductNameEdit() {
		return ProductNameEdit;
	}

	public WebElement getProductCategoryDropDown() {
		return ProductCategoryDropDown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	public void createProduct(String productName) {
		ProductNameEdit.sendKeys(productName);
		SaveBtn.click();
	}
	public void createProduct(String productName, String productCategory) {
		ProductNameEdit.sendKeys(productName);
	    handleDropdown(ProductCategoryDropDown, productCategory);
		SaveBtn.click();
}
}
