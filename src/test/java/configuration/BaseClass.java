package configuration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import testScripts.EconomyLot;
import testScripts.LongTermGarage;
import testScripts.LongTermSurface;
import testScripts.ShortTermHourly;
import testScripts.ValetParking;

public class BaseClass {
	
	protected static WebDriver dr = null;
	static ValetParking valet;
	static ShortTermHourly shortTerm;
	static LongTermGarage longGarage;
	static LongTermSurface longSurface;
	static EconomyLot economyLot;
	
	
	@BeforeTest
	@Parameters("Browser")
	public void setUp(String Browser)
	{
			if (Browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", 
					System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
			dr = new FirefoxDriver();

		} else if (Browser.equalsIgnoreCase("InternetExplorer")) {
			System.setProperty("webdriver.ie.driver", 
					System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
			dr = new InternetExplorerDriver();

		} else if (Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			dr = new ChromeDriver();
		}
		

		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(Configuration.implicitWait, TimeUnit.SECONDS);
		dr.get(Configuration.url);
	}
	
	
	
	
	@AfterTest
	public void close_Browser()
	{
		dr.quit();
	}	

}
