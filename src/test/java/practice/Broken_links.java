package practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Broken_links {

	public static void main(String[] args) throws IOException {
    	WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in");
	     List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
	     List<String> brokenLinks = new ArrayList<String>();
	     for(int i=0;i<allLinks.size();i++) {
	    	 String links = allLinks.get(i).getAttribute("href");
	    	 int statuscode=0;
	    	 try {
	    		 URL url = new URL(links);
		    	 URLConnection urlConnection = url.openConnection();
		    	 HttpURLConnection htttpUrlConnection = (HttpURLConnection)urlConnection;
		    	 statuscode=htttpUrlConnection.getResponseCode();
		    	 if(statuscode>=400) {
		    		 brokenLinks.add(links+" "+statuscode);
		    	 }
				
			} catch (Exception e) {
				continue;
			}
	     }
	    	 System.out.println(brokenLinks);
	     
		
		

	}

}
