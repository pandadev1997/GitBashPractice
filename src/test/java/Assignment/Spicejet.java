package Assignment;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Spicejet {
	public static void main(String[] args)throws Throwable {
		ChromeOptions option=new ChromeOptions();
		//option.addArguments("--disable-notification");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.easemytrip.com/");
//		Thread.sleep(2000);
//		try {
//			Alert alt=driver.switchTo().alert();
//			alt.accept();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		driver.findElement(By.xpath("//li[.='Round Trip ']")).click();
		String src="goa";
		Thread.sleep(2000);
		driver.findElement(By.id("FromSector_show")).click();
		driver.findElement(By.xpath("(//input[@placeholder=\"From\"])[position()=3]")).sendKeys(src);
		driver.findElement(By.xpath("//span[.='Goa(GOI)']")).click();
		
		String dest="chennai";
		Thread.sleep(2000);
		driver.findElement(By.id("Editbox13_show")).click();
		driver.findElement(By.xpath("//span[.='Chennai(MAA)']")).click();
		
		Date d=new Date();
//		String a[]=d.toString().split(" ");
//		String day = a[0];
//		String month = a[1];
//		String date = a[2];
//		String year = a[5];
//		String currentdate = date+"/"+month+"/"+year;
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yy");
		String currentdate = sdf.format(d);
		
		driver.findElement(By.xpath("//input[@placeholder='Departure']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("10/05/2023")).click();
		//driver.findElement(By.xpath("//span[@id='"+currentdate+"']")).click();
		
		//return date
		
		driver.findElement(By.id("divRtnCal")).click();
		driver.findElement(By.id("27/05/2023")).click();
		
		//travelers
		driver.findElement(By.id("myFunction4")).click();
		for(int i=0;i<2;i++) {
			driver.findElement(By.xpath("(//button[@id='add'])[position()=1]")).click();
		}
		driver.findElement(By.xpath("(//a[.='Done'])[position()=1]")).click();
		
		driver.findElement(By.xpath("//button[@onclick='SearchFlightWithArmyTest();']")).click();
	}

}
