package practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Icc_ranking {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement> teams = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		List<WebElement> matches = driver.findElements(By.xpath("//tbody/tr/td[3]"));
		List<WebElement> points = driver.findElements(By.xpath("//tbody/tr/td[4]"));
		ArrayList<String> p=new ArrayList<String>();
		for (WebElement q : matches) {
			p.add(q.getText());
		}
		ArrayList<String> t=new ArrayList<String>();
		for(WebElement r:points) {
			t.add(r.getText());
		}
		ArrayList<String> w=new ArrayList<String>();
		for(WebElement s:teams) {
			w.add(s.getText());
		}
		for(int i=0;i<teams.size();i++) {
			//System.out.println(teams.get(i).getText()+"-->"+matches.get(i).getText()+"--->"+points.get(i).getText());
			System.out.println(w.get(i)+"-->"+p.get(i)+"-->"+t.get(i));
		}
		Scanner s=new Scanner(System.in);
		System.out.println("Enter a team name");
		String teamname=s.next();
		//Boolean fla=false;
		for (WebElement Element : teams) {
			String text = Element.getText();
			if(Element.getText().equalsIgnoreCase(teamname))
					{
					System.out.println("present");
					//fla=true;
					break;
			}
			
			else if(!text.equalsIgnoreCase(teamname))
			// if(!fla)
				System.out.println("not present");
		}
		 List<WebElement> match = driver.findElements(By.xpath("//li[@class='ranking-format-menu__item']"));
		String odi="ODI";
		for (WebElement elemen : match) {
		if(elemen.getText().equals(odi))
			elemen.click();
	}
		Thread.sleep(4000);
		List<WebElement> chn = driver.findElements(By.xpath("//a[@class='content-tabs__tab content-tabs__tab--active']"));
        String wo="Women's";
        for (WebElement ele : chn) {
        	if(ele.getText().equals(wo))
        		ele.click();
			
		}
        
}
}