package vTiger.QuotesTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRepository.CreateNewQuotesPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.QuotesInfoPage;
import vTiger.ObjectRepository.QuotesPage;

@Listeners(vTiger.GenericUtilities.ListernersImplementation.class)
public class CreateQuoteTest extends BaseClass{
	
	@Test
	public void createQuoteTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		HomePage hp = new HomePage(driver);
		hp.clickQuotesLink(driver);
		
		QuotesPage qp = new QuotesPage(driver);
		qp.clickCreateQuoteBtn();
		
		String subName = eUtils.readDataFromTheExcelSheet("Quotes", 1, 2);
		String stageName = eUtils.readDataFromTheExcelSheet("Quotes", 1, 3);
		String orgName = eUtils.readDataFromTheExcelSheet("Quotes", 1, 4);
		String billAdd = eUtils.readDataFromTheExcelSheet("Quotes", 1, 5);
		String productName = eUtils.readDataFromTheExcelSheet("Quotes", 1, 6);
		
		CreateNewQuotesPage cnqp = new CreateNewQuotesPage(driver);
		cnqp.createQuotes(driver, subName, stageName, orgName, billAdd, productName);
		QuotesInfoPage qip = new QuotesInfoPage(driver);
		String QuoteHeader = qip.getQuotesHeader();
		Assert.assertTrue(QuoteHeader.contains(subName));
	}

}
