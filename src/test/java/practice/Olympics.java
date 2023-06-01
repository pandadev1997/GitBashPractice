package practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Olympics {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[.='✕']")).click();
		WebElement element = driver.findElement(By.xpath("//img[@alt='Fashion']"));
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		driver.findElement(By.xpath("//a[contains(@href,\"https://www.flipkart.com/mens-t\")]")).click();
		String price = driver.findElement(By.xpath("//img[contains(@src,'https://rukminim1.flixcart.com/image/612/612/xif0q/t-shirt/p')]/ancestor::div[@data-id='TSHGMV7HS55YMEGG']/descendant::div[@class='_30jeq3']")).getText();
		String name=driver.findElement(By.xpath("//img[contains(@src,'https://rukminim1.flixcart.com/image/612/612/xif0q/t-shirt/p')]/ancestor::div[@data-id='TSHGMV7HS55YMEGG']/descendant::div[@class='_2WkVRV']")).getText();
		System.out.println(name+"-->"+price);
	}

}
