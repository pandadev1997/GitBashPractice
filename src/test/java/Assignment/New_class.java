package Assignment;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class New_class {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.spicejet.com/");
		
		driver.findElement(By.xpath("//div[@data-testid=\"round-trip-radio-button\"]")).click();
		//modification
		
		driver.findElement(By.xpath("//div[text()=\"From\"]")).click();
		Thread.sleep(3000);
		

		
		driver.findElement(By.xpath("//input[@autocapitalize=\"sentences\"]//../preceding-sibling::div[text()=\"From\"]")).sendKeys("mang");
		
		driver.findElement(By.xpath("//div[text()='To']")).sendKeys("banga");
		
		driver.findElement(By.xpath("//div[text()='Departure Date']")).click();
		
		driver.findElement(By.xpath("//div[@data-testid=\"undefined-month-June-2023\"]/descendant::div[text()=\"25\"]")).click();
		
		driver.findElement(By.xpath("//div[text()=\"Return Date\"]")).click();
		
		while(true)
		try {
			
			driver.findElement(By.xpath("//div[@data-testid=\"undefined-month-August-2023\"]/descendant::div[text()=\"19\"]")).click();
			break;
		} 
		
		catch (Exception e)
		
		{
			driver.findElement(By.xpath("//div[@class=\"r-1loqt21 r-u8s1d r-11xbo3g r-1v2oles r-1otgn73 r-16zfatd r-1i6wzkk r-lrvibr r-184en5c css-1dbjc4n\"]")).click();
			
		}
		
		driver.findElement(By.xpath("//div[@data-testid=\"home-page-flight-cta\"]")).click();

	}

}
