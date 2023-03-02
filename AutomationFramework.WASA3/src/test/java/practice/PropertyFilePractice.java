package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties property = new Properties();
		property.load(fis);
		
		String URL = property.getProperty("url");
		String USERNAME = property.getProperty("username");
		System.out.println(URL);
		System.out.println(USERNAME);
	}

}
