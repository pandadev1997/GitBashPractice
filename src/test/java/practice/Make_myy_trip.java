package practice;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Make_myy_trip {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/flights/");
		
		//click on roundtrip
		driver.findElement(By.xpath("(//span[@class='tabsCircle appendRight5'])[position()=2]")).click();
		
		//select the from city
		String src="chennai";
		//driver.findElement(By.xpath("//input[@placeholder=\'From\']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys(src);
		driver.findElement(By.xpath("//p[.='Chennai, India']")).click();
		
		//select to city
		String dest="goa";
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys(dest);
		driver.findElement(By.xpath("//p[.='Goa - Dabolim Airport, India']")).click();
		
		//select the travel date
		Date d=new Date();
		System.out.println(d);
		String a[]=d.toString().split(" ");
		String day = a[0];
		String month = a[1];
		String date = a[2];
		String year = a[5];
		String currentdate = day+" "+month+" "+date+" "+year;
		driver.findElement(By.xpath("//div[@aria-label='"+currentdate+"']")).click();
		
		//return date
		
		String rday="Tue";
		String rmonth="Sep";
		String rdate="19";
		String ryear="2023";
		String returndate=rday+" "+rmonth+" "+rdate+" "+ryear;
		
		for(; ;) {
		try {
			driver.findElement(By.xpath("//div[@aria-label='"+returndate+"']")).click();
			break;
		} catch (Exception e) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
		
		}
		
		//select number of passenger travel
		driver.findElement(By.xpath("//span[.='Travellers & Class']")).click();
		driver.findElement(By.xpath("//li[@data-cy='adults-3']")).click();
		driver.findElement(By.xpath("//button[.='APPLY']")).click();
		driver.findElement(By.xpath("//a[.='Search']")).click();
		Thread.sleep(5000);
	}

}
