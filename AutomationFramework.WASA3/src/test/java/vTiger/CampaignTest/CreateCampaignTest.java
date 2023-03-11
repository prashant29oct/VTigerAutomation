package vTiger.CampaignTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRepository.CampaignInformationPage;
import vTiger.ObjectRepository.CampaignPage;
import vTiger.ObjectRepository.CreateCampaignPage;
import vTiger.ObjectRepository.CreatingNewProductPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.ProductInformationPage;
import vTiger.ObjectRepository.ProductPage;

public class CreateCampaignTest extends BaseClass{

	@Test
	public void createCampaignTest() throws EncryptedDocumentException, IOException, InterruptedException  {
		 
		
		HomePage hp = new HomePage(driver);
		hp.clickProductsLink();
		
		ProductPage pg = new ProductPage(driver);
		pg.clickCreateProductLink();
		
		String ProductName = eUtils.readDataFromTheExcelSheet("Campaign", 4, 3)+jUtils.getRandomNumber();
		CreatingNewProductPage cnpp = new CreatingNewProductPage(driver);
		cnpp.createProduct(ProductName);
		
	    ProductInformationPage pip = new ProductInformationPage(driver);
	    String ProductHeader = pip.getProductHeaderText();
		Assert.assertTrue(ProductHeader.contains(ProductName));
		System.out.println(ProductName+"------"+"Campaign Created");
		
		hp.clickCampaignsLink(driver);
		
		CampaignPage cp = new CampaignPage(driver);
		cp.clickCreateCampaignBtn();
		
		String CampaignName = eUtils.readDataFromTheExcelSheet("Campaign", 4, 2)+jUtils.getRandomNumber();
		
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.createCampaign(driver,CampaignName, ProductName);
		
		CampaignInformationPage cip2 = new CampaignInformationPage(driver);
		String camHeader = cip2.getCampaignHeader();
		Assert.assertTrue(camHeader.contains(CampaignName));
		System.out.println(CampaignName+"------"+"Campaign Created");
	}
}
