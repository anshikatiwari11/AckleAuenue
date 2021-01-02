package pageObjects;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import configuration.Configuration;


public class ParkingCost {
	
	private WebDriver dr;

	By startingDate = By.id("StartingDate");
	By leavingDate = By.id("LeavingDate");
	By startingTime = By.id("StartingTime");
	By leavingTime = By.id("LeavingTime");
	By submitBtn = By.xpath( "//*[@value='Calculate']");
	
	/*
	 * @FindBy(xpath = "//*[@name='StartingTimeAMPM'][1]")
	 * 
	 * @CacheLookup WebElement rdbtnStartingTimeAMPM;
	 * 
	 * @FindBy(xpath = "//*[@name='LeavingTimeAMPM'][1]")
	 * 
	 * @CacheLookup WebElement rdbtnLeavingTimeAMPM;
	 */

	@Parameters("Browser")
	@BeforeTest 
	public void launch_browser(String Browser)
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
			Select ParkingLot= new Select(dr.findElement(By.name("ParkingLot")));
			ParkingLot.selectByValue("Valet");

		}

	@AfterTest
	public void close_Browser()
	{
		dr.quit();
	}	
	
	@Test
	public void TC01() 
	{
		
	}
	
	@Test
	public void TC02() 
	{
	dr.findElement(startingDate).clear();
	dr.findElement(startingDate).sendKeys("01/01/2021");
	
	dr.findElement(leavingDate).clear();
	dr.findElement(leavingDate).sendKeys("01/01/2021");
	
	dr.findElement(startingTime).clear();
	dr.findElement(startingTime).sendKeys("01:00");
	
	dr.findElement(leavingTime).clear();
	dr.findElement(leavingTime).sendKeys("02:00");
	
	dr.findElement(submitBtn).click();
	
	List<WebElement> price = dr.findElements(By.className("SubHead"));
	assertEquals("$ 12.00", price.get(1).getText());
	
	List<WebElement> totalTime = dr.findElements(By.className("BodyCopy"));
	assertEquals("        (0 Days, 1 Hours, 0 Minutes)", totalTime.get(7).getText());
	}
}
