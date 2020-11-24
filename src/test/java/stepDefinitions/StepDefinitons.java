package stepDefinitions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import PageObjects.ParkingCost;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitons {

	public WebDriver driver;
	public ParkingCost pc;

	@Given("^User launch \"([^\"]*)\" browser$")
	public void user_launch_chrome_browser(String Browser) {
		if (Browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", 
					System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (Browser.equalsIgnoreCase("InternetExplorer")) {
			System.setProperty("webdriver.ie.driver", 
					System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		} else if (Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();

			driver.manage().window().maximize();
			pc = new ParkingCost(driver);
		}
	}

	@When("^User opens URL \"([^\"]*)\"$")
	public void user_opens_URL(String url) {
		driver.get(url);
	}

	@When("^User selects \"([^\"]*)\" Parking$")
	public void user_selects_parking(String string) {
		pc.clickParkingLot();
		pc.selectParkingType(string);
	}

	@When("^User selects \"([^\"]*)\" Starting date$")
	public void user_selects_starting_date(String sdate) {
		pc.setStartingDate(sdate);
	}

	@When("^User selects \"([^\"]*)\" Leaving date$")
	public void user_selects_leaving_date(String ldate) {
		pc.setLeavingDate(ldate);
	}

	@When("^User enters \"([^\"]*)\" of stimings$")
	public void user_enters_of_stimings(String stime) {
		pc.setStartingTime(stime);
	}

	@When("^User enters \"([^\"]*)\" of ltimings$")
	public void user_enters_of_ltimings(String ltime) {
		pc.setLeavingTime(ltime);
	}

	@When("^User clicks on radio buttons \"([^\"]*)\" of stimings$")
	public void user_clicks_on_radio_buttons_of_stimings(String am) {
		pc.clickStartingTimeAM();
		// pc.StartingTimePM(pm);		
	}

	@When("^User clicks on radio buttons \"([^\"]*)\" of ltiming$")
	public void user_clicks_on_radio_buttons_of_ltimings(String am) {
		pc.clickLeavingTimeAM();
		// pc.LeavingTimePM(pm);		
	}

	@When("^User clicks \"([^\"]*)\" on the Calculate button$")
	public void user_clicks_on_the_calculate_button(String string) throws InterruptedException, ParseException  {
		
		pc.clickCalculate();
		
		Select sel= new Select(driver.findElement(By.xpath("//*[@id='ParkingLot']")));
		WebElement option = sel.getFirstSelectedOption();
		String parkingtype = option.getText();
		System.out.println(parkingtype);
		String sdate = driver.findElement(By.xpath("//input[@id='StartingDate']")).getAttribute("value");
		String stime = driver.findElement(By.xpath("//input[@id='StartingTime']")).getAttribute("value");
		
		String ldate = driver.findElement(By.xpath("//input[@id='LeavingDate']")).getAttribute("value");
		String ltime = driver.findElement(By.xpath("//input[@id='LeavingTime']")).getAttribute("value");
		
		sdate = sdate +" "+stime; 
		ldate = ldate +" "+ltime;
	
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try {
		Date firstDate = sdf.parse(sdate);
		Date secondDate = sdf.parse(ldate);
		long diff = Math.abs(secondDate.getTime() - firstDate.getTime());
		
		long hoursDiff = diff/(1000*60*60);       
		long daysDiff = diff/(1000*60*60*24);

		} catch (ParseException e) {
            e.printStackTrace();
        }  
	}		

	@Then("^relevant results should displayed$")
	public void relevant_results_should_displayed() {
	}

	@Then("^close browser$")
	public void close_browser() {
		//driver.quit();

	}

}
