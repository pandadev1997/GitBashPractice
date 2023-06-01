package practice;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.Get;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import Property_FIle_utility.PropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Ty_Second_scenario {

	public static void main(String[] args) throws IOException {
		WebDriver driver=null;
		PropertyFile putil=new PropertyFile();
		String URL = putil.common("url");
		String BROWSER = putil.common("browser");
		
		if(BROWSER.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		 driver=new FirefoxDriver();
		}
		else
			System.out.println("invalid browser");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.xpath("//button[.='✕']")).click();
		WebElement ele = driver.findElement(By.xpath("//input[@class='_3704LK']"));
		ele.sendKeys("i phone");
		ele.submit();
		List<WebElement> prate = driver.findElements(By.xpath("//div[@class=\"_30jeq3 _1_WHN1\"]"));
		//ArrayList<String> rate=new ArrayList<String>();
		//for (WebElement rates : prate) {
		//	rate.add(rates.getText());
		//}
		List<WebElement> pname = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		//ArrayList<String> name=new ArrayList<String>();
		//for (WebElement names : pname) {
		//	name.add(names.getText());
		//}
		HashMap<String, String> p=new HashMap<String, String>();
		for(WebElement name:pname) {
			for(WebElement  rate:prate) {
				p.put(name.getText(), rate.getText());
			}
		}
		System.out.println(p.entrySet()+"\n");
//		for(int i=0;i<pname.size()-1;i++) {
//			System.out.println(p.get(i)+"--->"+p.get(i));
//			
//		}
//		for(Map.Entry<String, String> t:p.entrySet()){
//			System.out.println(t.getKey()+"--->"+t.getValue());
//		}

	}

}
