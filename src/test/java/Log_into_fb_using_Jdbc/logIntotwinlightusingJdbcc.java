package Log_into_fb_using_Jdbc;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class logIntotwinlightusingJdbcc {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver/domain/House_Rental_Application/");
		
		driver.findElement(By.xpath("//a[.='Login']")).click();
		
		Driver driverref=new Driver();
		DriverManager.deregisterDriver(driverref);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dev","root","root");
		Statement statement = con.createStatement();
		ResultSet data = statement.executeQuery("select * from Twinlightnew where username='debasishpanda777@gmail.com' and userpassword='Dev@123';");
	while(data.next()) {
		String un=data.getString(3);
		String pw=data.getString(4);
		System.out.println(un+" "+pw);
		
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(un,Keys.TAB,pw,Keys.ENTER);
		driver.findElement(By.xpath("//a[.='Register']")).click();
	}
	ResultSet fn = statement.executeQuery("select fullname,mobile,alternatemob,email,plotno,availableroom,country,state,city,rent,deposit,facility,description,landmark,address from userReg;");
	while(fn.next()) {
		String name = fn.getString(1);
		String mob = fn.getString(2);
		String alt_mob = fn.getString(3);
		String email = fn.getString(4);
		String plot = fn.getString(5);
		String room = fn.getString(6);
		String country = fn.getString(7);
		String state = fn.getString(8);
		String city = fn.getString(9);
		String rent = fn.getString(10);
		String deposit = fn.getString(11);
		String facility = fn.getString(12);
		String description = fn.getString(13);
		String landmark = fn.getString(14);
		String add = fn.getString(15);
		
		System.out.println(name+" "+country);
		
		driver.findElement(By.id("fullname")).sendKeys(name);
		driver.findElement(By.id("mobile")).sendKeys(mob);
		driver.findElement(By.id("alternat_mobile")).sendKeys(alt_mob);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("plot_number")).sendKeys(plot);
		driver.findElement(By.id("rooms")).sendKeys(room);
		driver.findElement(By.id("country")).sendKeys(country);
		driver.findElement(By.id("state")).sendKeys(state);
		driver.findElement(By.id("city")).sendKeys(city);
		driver.findElement(By.id("rent")).sendKeys(rent);
		driver.findElement(By.id("deposit")).sendKeys(deposit);
		driver.findElement(By.id("accommodation")).sendKeys(facility);
		driver.findElement(By.id("description")).sendKeys(description);
		driver.findElement(By.id("landmark")).sendKeys(landmark);
		driver.findElement(By.id("address")).sendKeys(add);
		File f=new File("./src/test/resources/File.txt");
		String path = f.getAbsolutePath();
		driver.findElement(By.xpath("//h2[.='Register Room']/parent::div/descendant::input[@type='file']")).sendKeys(path);
		
		driver.findElement(By.xpath("//h2[.='Register Room']/parent::div/descendant::button[@type='submit']")).click();
		
		
		
	}
	
	}

}
