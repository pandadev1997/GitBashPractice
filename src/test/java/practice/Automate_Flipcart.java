package practice;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Property_FIle_utility.PropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Automate_Flipcart{
	public static void main(String[] args) throws IOException, InterruptedException {
		PropertyFile p=new PropertyFile();
		String URL = p.common("url");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-Notification");
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement ele = driver.findElement(By.xpath("//div[text()='Home & Furniture']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		act.click(ele).perform();
		WebElement element = driver.findElement(By.xpath("//h2[text()='Home Furnishings']"));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		int y = element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")", element);
		WebElement ne = driver.findElement(By.xpath("//input[@class='_3704LK']"));
		ne.sendKeys("iphone14");
		ne.submit();
		driver.findElement(By.xpath("//div[text()='APPLE iPhone 14 ((PRODUCT)RED, 128 GB)']")).click();
		/*String partialTitle="apple-iphone-14-product-red-128-gb";
		Set<String> childids = driver.getWindowHandles();
		for(String allid:childids) {
			String currenttitle = driver.switchTo().window(allid).getTitle();
			if(currenttitle.contains(partialTitle)) {
				break;
			}
		}*/
		String parentid = driver.getWindowHandle();
		Set<String> childids = driver.getWindowHandles();
		for(String allid:childids) {
			WebDriver recentid = driver.switchTo().window(allid);
			if(recentid.equals(parentid)) {
				break;
			}
		}
		
		String value = driver.findElement(By.xpath("//span[text()='APPLE iPhone 14 ((PRODUCT)RED, 128 GB)']//ancestor::div[@class='_1AtVbE col-12-12']//descendant::div[text()='₹67,999']")).getText();
		System.out.println(value);
		
		WebElement el = driver.findElement(By.xpath("//a[text()='Flights']"));
		act.click(el).perform();
	//	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	//	wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(3000);
		Alert alt=driver.switchTo().alert();
		String text = alt.getText();
		System.out.println(text);
		alt.dismiss();
//		
//		if(text.contains("Block")) {
//			alt.dismiss();
//		}
		WebElement r = driver.findElement(By.xpath("//a[text()='Login']"));
		act.moveToElement(r);
		}
}
