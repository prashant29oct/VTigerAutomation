package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	
	@Test
	public void sample1()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals(true, false);
		System.out.println("Step3");
		System.out.println("Step4");
		System.out.println("Step5");
	}
	
	@Test
	public void sample2()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("Step1");
		System.out.println("Step2");
		sa.assertTrue(false);
		System.out.println("Step3");
		System.out.println("Step4");
		sa.assertAll();
	}

}
