package practice;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import Property_FIle_utility.PropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

public class Automate_chrome {
	public static void main(String[] args) throws IOException {
		WebDriver driver=null;
		PropertyFile putil=new PropertyFile();
		String URL = putil.common("url");
		String BROWSER = putil.common("browser");
		
		if(BROWSER.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		 driver=new FirefoxDriver();
		}
		else
			System.out.println("invalid browser");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.xpath("//button[.='✕']")).click();
		WebElement ele = driver.findElement(By.xpath("//input[@class='_3704LK']"));
		ele.sendKeys("i phone 14");
		ele.submit();
		List<WebElement> pstar = driver.findElements(By.xpath("//div[.='4.6']"));
		List<WebElement> pname = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		for(int i=0;i<pstar.size()-1;i++) {
			System.out.println(pname.get(i).getText()+"--->"+pstar.get(i).getText());
			
		}
		WebElement prname = driver.findElement(By.xpath("//div[.='APPLE iPhone 14 (Purple, 128 GB)']"));
		WebElement pprice = driver.findElement(By.xpath("//div[.='APPLE iPhone 14 (Purple, 128 GB)']/ancestor::a[@class='_1fQZEK']/descendant::div[@class='_30jeq3 _1_WHN1']"));
		System.out.println(prname.getText()+"--->"+pprice.getText());
	}

}
