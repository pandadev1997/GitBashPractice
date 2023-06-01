package Log_into_fb_using_Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Log_into_fb {

	public static void main(String[] args) throws SQLException  {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		Connection conn=null;
		try {
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dev","root","root");
		Statement statement = conn.createStatement();
		int update = statement.executeUpdate("insert into FB values('admin1','welcome');");
		ResultSet UN = statement.executeQuery("select * from FB where username='admin'");
		//ResultSet pw = statement.executeQuery("select * from FB;");
		while(UN.next()) {
			String username = UN.getString(1);
			String password = UN.getString(2);
			driver.get("https://www.facebook.com");
			driver.findElement(By.id("email")).sendKeys(username);
			driver.findElement(By.id("pass")).sendKeys(password);
			driver.findElement(By.name("login")).click();
		}
		}
		finally {
			conn.close();
		}
		
	}

}
