package practice;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Property_FIle_utility.PropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Webtable {

	public static void main(String[] args) throws IOException {
		PropertyFile pf=new PropertyFile();
		String URL = pf.common("url");
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		List<WebElement> col = driver.findElements(By.xpath("//*[@class='dataTable']/table/thread/tr/th"));
		System.out.println("column"+col.size());
	}

}
