package Assignment;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Olympics {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		//Scanner s=new Scanner(System.in);
		//System.out.println("Enter a country name");
		//String name=s.next();
		//WebElement cname = driver.findElement(By.xpath("//span[.='"+name+"']"));
		List<WebElement> cname = driver.findElements(By.xpath("//span[@data-cy='country-name']"));
		
		//All gold medal
		List<WebElement> gmedals = driver.findElements(By.xpath("//div[@title='Gold']"));
		
		//All silver medals
		List<WebElement> smedals = driver.findElements(By.xpath("//div[@title='Silver']"));
		
		//All bronze medal
		List<WebElement> bmedals = driver.findElements(By.xpath("//div[@title='Bronze']"));
		
		//Total medal
		List<WebElement> tmedals = driver.findElements(By.xpath("//div[@title='']"));
		String countryname="Austria";
		for(int i=0;i<cname.size();i++) {
			
			if(cname.get(i).getText().equals(countryname)) {
				String gldmedal=gmedals.get(i).getText();
				String slvmedals=smedals.get(i).getText();
				String brnmedals=bmedals.get(i).getText();
				String Totalm=tmedals.get(i).getText();
			
			System.out.println("country name"+"->"+countryname+" "+"goldmedals"+"->"+gldmedal+" "+"silvermedals"+"->"+slvmedals+" "+"Bronze medals"+"->"+brnmedals+" "+"total medal won"+"->"+Totalm);
			break;
		}
			 //if(!cname.equals(countryname)) {
				//System.out.println("country is not present in the list");
			
		}
		
		

	}

}
