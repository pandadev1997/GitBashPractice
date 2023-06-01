package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TY_First_scenario {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		String countryname="india";
		List<WebElement> countrnames = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		List<WebElement> countrymatch = driver.findElements(By.xpath("//tbody/tr/td[3]"));
		for(int i=0;i<countrnames.size()-1;i++) {
			System.out.println(countrnames.get(i).getText()+"--->"+countrymatch.get(i).getText());
		}
		//Boolean flag=false;
		for (WebElement w : countrnames) {
			String text = w.getText();
			if(w.getText().equalsIgnoreCase(countryname)) {
				System.out.println("country present");
				//flag=true;
				break;
			}
			else if(!text.equals(countryname))
				System.out.println("country not present");
			
		}
	}

}
