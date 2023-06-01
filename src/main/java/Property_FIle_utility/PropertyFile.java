package Property_FIle_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
	public String common(String data) throws IOException {
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
	Properties pobj=new Properties();
	pobj.load(fis);
	String value = pobj.getProperty(data);
	return value;
	//String URL = pobj.getProperty("url");
	//String BRO = pobj.getProperty("browser");
	}
	

}
