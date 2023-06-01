package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Spice {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.spicejet.com/");
		
		driver.findElement(By.xpath("//div[@data-testid=\"round-trip-radio-button\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[position()=1]")).sendKeys("chen");
		driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[position()=2]")).sendKeys("goa");
		driver.findElement(By.xpath("//div[.='Goa (Dabolim)']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[.='Departure Date']")).click();
		//driver.findElement(By.cssSelector("//img[@src='https://www.spicejet.com/public/v1.svg']/ancestor::div[@class='css-1dbjc4n r-14lw9ot']/descendant::div[@data-testid='departure-date-dropdown-label-test-id']/child::div[2]/child::div[.='Thu, 11 May 2023']")).click();
		//driver.findElement(By.xpath("")).click();
		Thread.sleep(4000);
		//driver.findElement(By.xpath("//div[.='Wed, 10 May 2023']")).click();
		driver.findElement(By.xpath("(//div[@data-testid='undefined-calendar-day-12'])[1]")).click();
		
		driver.findElement(By.xpath("(//div[@data-testid='undefined-calendar-day-5'])[1]")).click();
	}

}
