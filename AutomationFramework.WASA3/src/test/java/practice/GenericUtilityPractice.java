package practice;

import java.io.IOException;

import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException {
		
		PropertyFileUtility pfu = new PropertyFileUtility();
		String URL = pfu.readDataFromPropertyFile("url");
		System.out.println(URL);
		
		JavaUtility jUtil = new JavaUtility();
		System.out.println(jUtil.getSystemDate());
		System.out.println(jUtil.getSystemDateInFormat());
		System.out.println(jUtil.getRandomNumber());
	
	}

}
