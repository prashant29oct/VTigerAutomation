package vTiger.OrganizationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRepository.CreatingNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInformationPage;
import vTiger.ObjectRepository.OrganizationPage;

@Listeners(vTiger.GenericUtilities.ListernersImplementation.class)
public class CreateOrgWithMultipleTest extends BaseClass{

	@Test(dataProvider = "getData")
	public void createMultipleOrgTest(String ORGName, String IndustryType)
	{
		String OrgName = ORGName+jUtils.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.clickOrganizationLink();
		
		OrganizationPage op = new OrganizationPage(driver);
		op.clickCreateOrgImage();
		
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(OrgName, IndustryType);
		
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String OrgHeader = oip.getOrgHeader();
		Assert.assertTrue(OrgHeader.contains(OrgName));
		System.out.println("Organization Created");
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		Object[][] data = eUtils.readMutilpleData("Multiple");
		return data;
	}
}
