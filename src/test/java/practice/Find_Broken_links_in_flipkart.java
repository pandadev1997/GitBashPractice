package practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Find_Broken_links_in_flipkart {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		ArrayList<String> BrokenLinks=new ArrayList<String>();
		for(int i=0;i<allLinks.size();i++) {
			String Links = allLinks.get(i).getAttribute("href");
			int statuscode=0;
			try {
				URL url = new URL(Links);
				URLConnection urlConnection = url.openConnection();
				HttpURLConnection httpurlConnection = (HttpURLConnection)urlConnection;
				statuscode=httpurlConnection.getResponseCode();
//				 SoftAssert as=new SoftAssert();
//				 as.assertTrue(statuscode>=400);
//				 as.assertAll();
				if(statuscode>=400)
				 BrokenLinks.add(Links+" "+statuscode);
			} catch (Exception e) {
				continue;
			}
		}
		System.out.println(BrokenLinks);
	}

}
