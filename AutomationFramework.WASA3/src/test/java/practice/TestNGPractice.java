package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test()
	public void createUser()
	{
		System.out.println("create");
		Assert.fail();
	}
    
	@Test(dependsOnMethods = "createUser")
	public void updateUser() {
		System.out.println("update");
	}
	
	@Test(dependsOnMethods = {"createUser","updateUser"})
	public void deleteUser() {
		System.out.println("delete");
	}
}
