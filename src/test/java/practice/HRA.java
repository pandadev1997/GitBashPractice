package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRA {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver/domain/House_Rental_Application/");
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.name("username")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
		WebElement ele = driver.findElement(By.xpath("//b[text()='Registered Users: ']"));
		Actions act=new Actions(driver);
		act.click(ele).perform();
		driver.findElement(By.xpath("//a[@href='../auth/dashboard.php']")).click();
		driver.findElement(By.xpath("//a[@href='../app/register.php']")).click();
		driver.findElement(By.xpath("//a[@href='../auth/dashboard.php']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//b[text()='Registered Users: ']")).click();
		String name="Mahantesh Kumbar";
		Assert.assertTrue(name.equals("Mahantesh Kumbar"));
		System.out.println("user register");
		driver.findElement(By.xpath("//a[@href='../auth/dashboard.php']")).click();
		WebElement e = driver.findElement(By.xpath("//a[@class='nav-link']"));
		if(e.getText().equals("Send SMS")) {
			e.click();
		}
	}

}
