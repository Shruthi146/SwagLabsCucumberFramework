package DBConnection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksCopy {
	
	static WebDriver driver;
	Properties prop;
	Connection con;
	Statement stmt;
	String username;
	String password;
	String browser;
	
	@Before
	public void init_driver() throws SQLException
	{
		prop = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator
					+ "resources" + File.separator + "cucumber.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		username=prop.getProperty("username");
		password=prop.getProperty("password");
		browser=prop.getProperty("browser");
		
		System.out.println("username : " + username + "  password : " + password + "  browser : " + browser);
		
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			System.out.println("Browser intialized");
		}
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/swaglabs","root","root"); //url/database name, username, password
		System.out.println("Connected to Database");
		stmt=con.createStatement();
		
		ResultSet rs=stmt.executeQuery("SELECT COUNT(*) FROM EMPLOYEES WHERE username='"+username+"'");
		rs.next();
		int count=rs.getInt(1);
		System.out.println("count : " + count);
		
		if(count==0)
		{
			stmt.execute("INSERT INTO EMPLOYEES VALUES ('"+username+"','"+password+"')");
			System.out.println("Data inserted...........");
		}
		else
		{
			System.out.println("Data present");
		}
		
		
	}
	
	 public static WebDriver getDriver() 
	 {
		 return driver;
	 }
	
	@After
	public void quitBrowser() throws SQLException
	{
		ResultSet rs=stmt.executeQuery("SELECT COUNT(*) FROM EMPLOYEES");
		rs.next();
		int count=rs.getInt(1);
		System.out.println("count of rows @After: " + count);
		
		if(count!=0)
		{
			stmt.execute("DELETE FROM EMPLOYEES WHERE username='"+username+"'");
			System.out.println("Data deleted");
		}
		con.close();
		System.out.println("Database closed");
		
		driver.quit();
		
	}
}
