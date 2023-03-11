package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage {
	
	@FindBy(xpath = "//span[@class='dvHeaderText']") private WebElement HeaderText;
	
	public CampaignInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getHeaderText() {
		return HeaderText;
	}
	
	public String getCampaignHeader()
	{
		return HeaderText.getText();
	}
	

}
