package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

	@Test(dataProvider = "phone")
	public void dataProviderPractice(String phone, int price)
	{
		System.out.println(phone+"------"+price);
	}
	
	@DataProvider(name = "phone")
	public Object[][] getData()
	{
		Object[][] data = new Object[3][2];
		
		data[0][0] = "Samsung";
		data[0][1] = 1200;
		
		data[1][0] = "Nokia";
		data[1][1] = 1000;
		
		data[2][0] = "Iphone14";
		data[2][1] = 2000;
		
		return data;
	}
}
