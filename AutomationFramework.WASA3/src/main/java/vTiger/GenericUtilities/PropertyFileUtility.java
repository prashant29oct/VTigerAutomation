package vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic methods to read data from property file
 * @author Prashant
 *
 */
public class PropertyFileUtility {
	
	/**
	 * This method will read data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IConstantsUtility.propertyFilePath);
		Properties property = new Properties();
		property.load(fis);
	    String value = property.getProperty(key);
	    return value;
	}

}
