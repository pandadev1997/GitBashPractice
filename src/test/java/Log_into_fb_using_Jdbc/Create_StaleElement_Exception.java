package Log_into_fb_using_Jdbc;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_StaleElement_Exception {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver/domain/House_Rental_Application/");
		
		driver.findElement(By.xpath("//a[.='Login']")).click();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("admin",Keys.TAB,"admin");
		driver.navigate().refresh();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("admin",Keys.TAB,"admin");
	}
}
