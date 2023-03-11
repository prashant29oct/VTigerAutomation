package vTiger.ProductsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRepository.CreatingNewProductPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.ProductInformationPage;
import vTiger.ObjectRepository.ProductPage;

public class CreateProductTest extends BaseClass {

	@Test
	public void createProductTest() throws EncryptedDocumentException, IOException {
		
		HomePage hp = new HomePage(driver);
		hp.clickProductsLink();
		
		ProductPage pg = new ProductPage(driver);
		pg.clickCreateProductLink();
		
		String productName = eUtils.readDataFromTheExcelSheet("Product", 4, 2)+jUtils.getRandomNumber();
		String productCategory = eUtils.readDataFromTheExcelSheet("Product", 4, 3);
		
		CreatingNewProductPage cnpp = new CreatingNewProductPage(driver);
		cnpp.createProduct(productName, productCategory);
		
		ProductInformationPage pip = new ProductInformationPage(driver);
		String ProductHeader = pip.getProductHeaderText();
		if(ProductHeader.contains(productName))
		{
			System.out.println("Product Created Successfully");
		}else
		{
			System.out.println("Product is not created");
		}

	}

}
