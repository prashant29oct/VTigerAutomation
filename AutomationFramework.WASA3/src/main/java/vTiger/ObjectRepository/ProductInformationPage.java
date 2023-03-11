package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {

	@FindBy(className = "lvtHeaderText") private WebElement HeaderText;
	
	public ProductInformationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getHeaderText() {
		return HeaderText;
	}
	
	public String getProductHeaderText() {
		return HeaderText.getText();
	}
}
