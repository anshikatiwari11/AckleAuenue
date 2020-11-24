package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ParkingCost {
	public WebDriver ldriver;

	public ParkingCost(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ParkingLot")
	@CacheLookup
	WebElement drpdwnParkingLot;

	@FindBy(id = "StartingDate")
	@CacheLookup
	WebElement calStartingDate;

	@FindBy(id = "LeavingDate")
	@CacheLookup
	WebElement calLeavingDate;

	@FindBy(id = "StartingTime")
	@CacheLookup
	WebElement calStartingTime;

	@FindBy(id = "LeavingTime")
	@CacheLookup
	WebElement calLeavingTime;

	@FindBy(xpath = "//*[@name='StartingTimeAMPM'][1]")
	@CacheLookup
	WebElement rdbtnStartingTimeAMPM;

	@FindBy(xpath = "//*[@name='LeavingTimeAMPM'][1]")
	@CacheLookup
	WebElement rdbtnLeavingTimeAMPM;

	@FindBy(xpath = "//*[@value='Calculate']")
	@CacheLookup
	WebElement btnCalculate;
	
	public void clickParkingLot()
	{
		drpdwnParkingLot.click();
	}	
	public void selectParkingType(String parkingType)
	{
		Select sel= new Select(drpdwnParkingLot);
		sel.selectByIndex(1);
	}	
	public void setStartingDate(String sdate) 
	{
		calStartingDate.clear();
		calStartingDate.sendKeys(sdate);
	}
	public void setLeavingDate(String ldate) 
	{
		calLeavingDate.clear();
		calLeavingDate.sendKeys(ldate);
	}	
	public void setStartingTime(String stime) 
	{
		calStartingTime.clear();
		calStartingTime.sendKeys(stime);
	}
	public void setLeavingTime(String ltime) 
	{
		calLeavingTime.clear();
		calLeavingTime.sendKeys(ltime);
	}	
	public void clickStartingTimeAM() 
	{
		rdbtnStartingTimeAMPM.click();
	}	
	public void clickStartingTimePM() 
	{
		rdbtnStartingTimeAMPM.click();
	}
	public void clickLeavingTimeAM()
	{
		rdbtnLeavingTimeAMPM.click();
	}
	public void clickLeavingTimePM() 
	{
		rdbtnLeavingTimeAMPM.click();
	}
	public void clickCalculate() 
	{
		btnCalculate.click();
	}
	
}
