package testScripts;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import configuration.BaseClass;

public class EconomyLot extends BaseClass {

	By startingDate = By.id("StartingDate");
	By leavingDate = By.id("LeavingDate");
	By startingTime = By.id("StartingTime");
	By leavingTime = By.id("LeavingTime");
	By submitBtn = By.xpath("//*[@value='Calculate']");

	Select ParkingLot;

	public void drpDwn() {
		ParkingLot = new Select(dr.findElement(By.name("ParkingLot")));
		ParkingLot.selectByValue("Economy");
	}

	@Test
	public void TC01() {
		/*
		 * ParkingLot= new Select(dr.findElement(By.name("ParkingLot")));
		 * dr.findElement(submitBtn).click(); WebElement error =
		 * dr.findElement(By.xpath("//*[contains(text(),'ERROR')]"));
		 * assertEquals("ERROR! ENTER A CORRECTLY FORMATTED DATE", error.getText());
		 * System.out.println(ParkingLot.getFirstSelectedOption().getText());
		 * assertEquals("Short-Term Parking",ParkingLot.getFirstSelectedOption().getText
		 * ());
		 */
	}

	@Test
	public void TC02() {
		drpDwn();
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
		assertEquals("$ 2.00", price.get(1).getText());

		List<WebElement> totalTime = dr.findElements(By.className("BodyCopy"));
		assertEquals("        (0 Days, 1 Hours, 0 Minutes)", totalTime.get(7).getText());
	}

	@Test
	public void TC03() {
		drpDwn();
		dr.findElement(startingDate).clear();
		dr.findElement(startingDate).sendKeys("01/01/2021");

		dr.findElement(leavingDate).clear();
		dr.findElement(leavingDate).sendKeys("01/01/2021");

		dr.findElement(startingTime).clear();
		dr.findElement(startingTime).sendKeys("01:00");

		dr.findElement(leavingTime).clear();
		dr.findElement(leavingTime).sendKeys("03:30");

		dr.findElement(submitBtn).click();

		List<WebElement> price = dr.findElements(By.className("SubHead"));
		assertEquals("$ 6.00", price.get(1).getText());

		List<WebElement> totalTime = dr.findElements(By.className("BodyCopy"));
		assertEquals("        (0 Days, 2 Hours, 30 Minutes)", totalTime.get(7).getText());
	}

	@Test
	public void TC04() {
		drpDwn();
		dr.findElement(startingDate).clear();
		dr.findElement(startingDate).sendKeys("01/01/2021");

		dr.findElement(leavingDate).clear();
		dr.findElement(leavingDate).sendKeys("01/01/2021");

		dr.findElement(startingTime).clear();
		dr.findElement(startingTime).sendKeys("01:00");

		dr.findElement(leavingTime).clear();
		dr.findElement(leavingTime).sendKeys("06:00");

		dr.findElement(submitBtn).click();

		List<WebElement> price = dr.findElements(By.className("SubHead"));
		assertEquals("$ 9.00", price.get(1).getText());

		List<WebElement> totalTime = dr.findElements(By.className("BodyCopy"));
		assertEquals("        (0 Days, 5 Hours, 0 Minutes)", totalTime.get(7).getText());
	}

	@Test
	public void TC05() {
		drpDwn();
		dr.findElement(startingDate).clear();
		dr.findElement(startingDate).sendKeys("01/01/2021");

		dr.findElement(leavingDate).clear();
		dr.findElement(leavingDate).sendKeys("01/02/2021");

		dr.findElement(startingTime).clear();
		dr.findElement(startingTime).sendKeys("01:00");

		dr.findElement(leavingTime).clear();
		dr.findElement(leavingTime).sendKeys("00:59");

		dr.findElement(submitBtn).click();

		List<WebElement> price = dr.findElements(By.className("SubHead"));
		assertEquals("$ 9.00", price.get(1).getText());

		List<WebElement> totalTime = dr.findElements(By.className("BodyCopy"));
		assertEquals("        (0 Days, 23 Hours, 59 Minutes)", totalTime.get(7).getText());
	}

	@Test
	public void TC06() {
		drpDwn();
		dr.findElement(startingDate).clear();
		dr.findElement(startingDate).sendKeys("01/01/2021");

		dr.findElement(leavingDate).clear();
		dr.findElement(leavingDate).sendKeys("01/02/2021");

		dr.findElement(startingTime).clear();
		dr.findElement(startingTime).sendKeys("01:00");

		dr.findElement(leavingTime).clear();
		dr.findElement(leavingTime).sendKeys("01:00");

		dr.findElement(submitBtn).click();

		List<WebElement> price = dr.findElements(By.className("SubHead"));
		assertEquals("$ 9.00", price.get(1).getText());

		List<WebElement> totalTime = dr.findElements(By.className("BodyCopy"));
		assertEquals("        (1 Days, 0 Hours, 0 Minutes)", totalTime.get(7).getText());
	}

	@Test
	public void TC07() {
		drpDwn();
		dr.findElement(startingDate).clear();
		dr.findElement(startingDate).sendKeys("01/01/2021");

		dr.findElement(leavingDate).clear();
		dr.findElement(leavingDate).sendKeys("01/02/2021");

		dr.findElement(startingTime).clear();
		dr.findElement(startingTime).sendKeys("01:00");

		dr.findElement(leavingTime).clear();
		dr.findElement(leavingTime).sendKeys("20:45");

		dr.findElement(submitBtn).click();

		List<WebElement> price = dr.findElements(By.className("SubHead"));
		assertEquals("$ 18.00", price.get(1).getText());

		List<WebElement> totalTime = dr.findElements(By.className("BodyCopy"));
		assertEquals("        (1 Days, 19 Hours, 45 Minutes)", totalTime.get(7).getText());
	}

	@Test
	public void TC08() {
		drpDwn();
		dr.findElement(startingDate).clear();
		dr.findElement(startingDate).sendKeys("01/01/2021");

		dr.findElement(leavingDate).clear();
		dr.findElement(leavingDate).sendKeys("01/03/2021");

		dr.findElement(startingTime).clear();
		dr.findElement(startingTime).sendKeys("01:00");

		dr.findElement(leavingTime).clear();
		dr.findElement(leavingTime).sendKeys("20:00");

		dr.findElement(submitBtn).click();

		List<WebElement> price = dr.findElements(By.className("SubHead"));
		assertEquals("$ 27.00", price.get(1).getText());

		List<WebElement> totalTime = dr.findElements(By.className("BodyCopy"));
		assertEquals("        (2 Days, 19 Hours, 0 Minutes)", totalTime.get(7).getText());
	}

	@Test
	public void TC09() {
		drpDwn();
		dr.findElement(startingDate).clear();
		dr.findElement(startingDate).sendKeys("01/01/2021");

		dr.findElement(leavingDate).clear();
		dr.findElement(leavingDate).sendKeys("02/01/2021");

		dr.findElement(startingTime).clear();
		dr.findElement(startingTime).sendKeys("01:00");

		dr.findElement(leavingTime).clear();
		dr.findElement(leavingTime).sendKeys("21:00");

		dr.findElement(submitBtn).click();

		List<WebElement> price = dr.findElements(By.className("SubHead"));
		assertEquals("$ 252.00", price.get(1).getText());

		List<WebElement> totalTime = dr.findElements(By.className("BodyCopy"));
		assertEquals("        (31 Days, 20 Hours, 0 Minutes)", totalTime.get(7).getText());
	}

	@Test
	public void TC10() {
		drpDwn();
		dr.findElement(startingDate).clear();
		dr.findElement(startingDate).sendKeys("01/01/2021");

		dr.findElement(leavingDate).clear();
		dr.findElement(leavingDate).sendKeys("05/03/2021");

		dr.findElement(startingTime).clear();
		dr.findElement(startingTime).sendKeys("01:00");

		dr.findElement(leavingTime).clear();
		dr.findElement(leavingTime).sendKeys("08:30");

		dr.findElement(submitBtn).click();

		List<WebElement> price = dr.findElements(By.className("SubHead"));
		assertEquals("$ 956.00", price.get(1).getText());

		List<WebElement> totalTime = dr.findElements(By.className("BodyCopy"));
		assertEquals("        (122 Days, 7 Hours, 30 Minutes)", totalTime.get(7).getText());
	}

	@Test
	public void TC11() {
		drpDwn();
		dr.findElement(startingDate).clear();
		dr.findElement(startingDate).sendKeys("01/01/2021");

		dr.findElement(leavingDate).clear();
		dr.findElement(leavingDate).sendKeys("01/01/2022");

		dr.findElement(startingTime).clear();
		dr.findElement(startingTime).sendKeys("01:00");

		dr.findElement(leavingTime).clear();
		dr.findElement(leavingTime).sendKeys("01:00");

		dr.findElement(submitBtn).click();

		List<WebElement> price = dr.findElements(By.className("SubHead"));
		assertEquals("$ 2,817.00", price.get(1).getText());

		List<WebElement> totalTime = dr.findElements(By.className("BodyCopy"));
		assertEquals("        (365 Days, 0 Hours, 0 Minutes)", totalTime.get(7).getText());
	}

	@Test
	public void TC12() {
		drpDwn();
		dr.findElement(startingDate).clear();
		dr.findElement(startingDate).sendKeys("01/01/2021");

		dr.findElement(leavingDate).clear();
		dr.findElement(leavingDate).sendKeys("01/01/2022");

		dr.findElement(startingTime).clear();
		dr.findElement(startingTime).sendKeys("01:00");

		dr.findElement(leavingTime).clear();
		dr.findElement(leavingTime).sendKeys("04:00");

		dr.findElement(submitBtn).click();

		List<WebElement> price = dr.findElements(By.className("SubHead"));
		assertEquals("$ 2,823.00", price.get(1).getText());

		List<WebElement> totalTime = dr.findElements(By.className("BodyCopy"));
		assertEquals("        (365 Days, 3 Hours, 0 Minutes)", totalTime.get(7).getText());
	}

	@Test
	public void TC13() {
		drpDwn();
		dr.findElement(startingDate).clear();

		dr.findElement(leavingDate).clear();
		dr.findElement(leavingDate).sendKeys("01/21/2021");

		dr.findElement(startingTime).clear();
		dr.findElement(leavingTime).clear();

		dr.findElement(submitBtn).click();
		WebElement error = dr.findElement(By.xpath("//*[contains(text(),'ERROR')]"));
		assertEquals("ERROR! YOUR LEAVING DATE OR TIME IS BEFORE YOUR STARTING DATE OR TIME", error.getText());
	}

	@Test
	public void TC14() {
		drpDwn();
		dr.findElement(startingDate).clear();
		dr.findElement(startingDate).sendKeys("01/21/2021");

		dr.findElement(leavingDate).clear();
		dr.findElement(leavingDate).sendKeys("01/20/2021");

		dr.findElement(startingTime).clear();
		dr.findElement(leavingTime).clear();

		dr.findElement(submitBtn).click();
		WebElement error = dr.findElement(By.xpath("//*[contains(text(),'ERROR')]"));
		assertEquals("ERROR! YOUR LEAVING DATE OR TIME IS BEFORE YOUR STARTING DATE OR TIME", error.getText());
	}

	@Test
	public void TC15() {
		drpDwn();
		dr.findElement(startingDate).clear();
		dr.findElement(startingDate).sendKeys("01/21/2021");

		dr.findElement(leavingDate).clear();

		dr.findElement(startingTime).clear();
		dr.findElement(leavingTime).clear();

		dr.findElement(submitBtn).click();
		WebElement error = dr.findElement(By.xpath("//*[contains(text(),'ERROR')]"));
		assertEquals("ERROR! YOUR LEAVING DATE OR TIME IS BEFORE YOUR STARTING DATE OR TIME", error.getText());
	}

	@Test
	public void TC16() {
		drpDwn();
		dr.findElement(startingDate).clear();
		dr.findElement(leavingDate).clear();

		dr.findElement(startingTime).clear();
		dr.findElement(leavingTime).clear();

		dr.findElement(submitBtn).click();
		WebElement error = dr.findElement(By.xpath("//*[contains(text(),'ERROR')]"));
		assertEquals("ERROR! ENTER A CORRECTLY FORMATTED DATE", error.getText());
	}

	@Test
	public void TC17() {
		drpDwn();
		dr.findElement(startingDate).clear();
		dr.findElement(startingDate).sendKeys("sffhbyh");

		dr.findElement(leavingDate).clear();
		dr.findElement(leavingDate).sendKeys("gyjuiki");

		dr.findElement(startingTime).clear();
		dr.findElement(startingTime).sendKeys("01:00");

		dr.findElement(leavingTime).clear();
		dr.findElement(leavingTime).sendKeys("04:00");

		dr.findElement(submitBtn).click();
		WebElement error = dr.findElement(By.xpath("//*[contains(text(),'ERROR')]"));
		assertEquals("ERROR! ENTER A CORRECTLY FORMATTED DATE", error.getText());
	}

	@Test
	public void TC18() {
		drpDwn();
		dr.findElement(startingDate).clear();
		dr.findElement(startingDate).sendKeys("sffhbyh");

		dr.findElement(leavingDate).clear();
		dr.findElement(leavingDate).sendKeys("gyjuiki");

		dr.findElement(startingTime).clear();
		dr.findElement(startingTime).sendKeys("mdckld");

		dr.findElement(leavingTime).clear();
		dr.findElement(leavingTime).sendKeys("klmsf");

		dr.findElement(submitBtn).click();
		WebElement error = dr.findElement(By.xpath("//*[contains(text(),'ERROR')]"));
		assertEquals("ERROR! ENTER A CORRECTLY FORMATTED DATE", error.getText());
	}

	@Test
	public void TC19() {
		drpDwn();
		dr.findElement(startingDate).clear();
		dr.findElement(startingDate).sendKeys("@#$%");

		dr.findElement(leavingDate).clear();
		dr.findElement(leavingDate).sendKeys("^%&$#*");

		dr.findElement(startingTime).clear();
		dr.findElement(startingTime).sendKeys("^%&$#*");

		dr.findElement(leavingTime).clear();
		dr.findElement(leavingTime).sendKeys("@#$%^&");

		dr.findElement(submitBtn).click();
		WebElement error = dr.findElement(By.xpath("//*[contains(text(),'ERROR')]"));
		assertEquals("ERROR! ENTER A CORRECTLY FORMATTED DATE", error.getText());
	}

	@Test
	public void TC20() {
		drpDwn();
		dr.findElement(startingDate).clear();
		dr.findElement(startingDate).sendKeys("-134");

		dr.findElement(leavingDate).clear();
		dr.findElement(leavingDate).sendKeys("-23");

		dr.findElement(startingTime).clear();
		dr.findElement(startingTime).sendKeys("-156");

		dr.findElement(leavingTime).clear();
		dr.findElement(leavingTime).sendKeys("-176");

		dr.findElement(submitBtn).click();
		WebElement error = dr.findElement(By.xpath("//*[contains(text(),'ERROR')]"));
		assertEquals("ERROR! ENTER A CORRECTLY FORMATTED DATE", error.getText());
	}

}
