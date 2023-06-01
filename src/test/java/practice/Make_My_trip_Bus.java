package practice;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Make_My_trip_Bus {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/flights/");
		
		//click on Bus
	driver.findElement(By.xpath("//a[@href='https://www.makemytrip.com/bus-tickets/']")).click();
	
	String src="chennai";
	Thread.sleep(2000);
	driver.findElement(By.id("fromCity")).click();
	driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(src);
	driver.findElement(By.xpath("//span[.='Chennai, Tamil Nadu']")).click();
	
	//Enter tocity
	
	String dest="bengaluru";
	Thread.sleep(2000);
	//driver.findElement(By.id("toCity")).click();
	driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(dest);
	driver.findElement(By.xpath("//span[.='Bangalore (Bengaluru), Karnataka']")).click();
	
	Date d=new Date();
	String a[]=d.toString().split(" ");
	String day = a[0];
	String mon = a[1];
	String date = a[2];
	String year = a[5];
	String tripdate=day+" "+mon+" "+date+" "+year;
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@aria-label='"+tripdate+"']")).click();
	driver.findElement(By.id("search_button")).click();
	
	//print all the busname with price
	List<WebElement> busname = driver.findElements(By.xpath("//span[@class='latoBlack font22 blackText appendRight15']"));
	List<WebElement> busprice = driver.findElements(By.xpath("//span[@class='sc-ckVGcZ dYlDBG']"));
	
	//For lowest bus price
	ArrayList<String> p=new ArrayList<String>();
	for(WebElement rate:busprice) {
		p.add(rate.getText());
	}
	//Collections.sort(p);
	//System.out.println(p);
	Object b[]=p.toArray();
	Arrays.sort(b);
//	for(int i=0;i<b.length;i++) {
//		System.out.println(b[i]);
//	}
//	System.out.println("lowest price"+b[2]);
    String value=(String) b[2];
    for(int j=0;j<busname.size();j++) {
    	if(busprice.get(j).getText().equals(value)) {
    		String travelersname=busname.get(j).getText();
    		System.out.println("busname->"+travelersname+" "+value);
    		break;
    	}
    }
	}
	
	}

	
	
	
	

