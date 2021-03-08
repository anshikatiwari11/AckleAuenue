package testScripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class HomePage extends BaseClass {
	
	@Test
	public void TC00() throws InterruptedException
	{
		Actions act= new Actions(dr);
		act.moveToElement(dr.findElement(By.xpath("(//a[text()='Men'])[1]"))).build().perform();
				
		dr.findElement(By.xpath("//*[text()='Phone Cases']")).click();
		
		dr.findElement(By.xpath("//ul[@class='results-base']/li[11]")).click();
		
		String parent = dr.getWindowHandle();
		Set <String> wins = dr.getWindowHandles();
		for (String w: wins)
		{
			if (!w.equals(parent))
			{
				dr.switchTo().window(w);
			}
		}
		
		if (dr.findElement(By.xpath("//span[@class='PriceInfo-price']")).isDisplayed())
		{
			String priceofcover = dr.findElement(By.xpath("//span[@class='PriceInfo-price']")).getText();
			String [] price = priceofcover.split(" ");
			
			int price1 = Integer.parseInt(price[1]);
			if(price1>10)
			{
				System.out.println("My Given scenaio is passed");
			}
		}
		
		Assert.assertEquals(dr.findElement(By.xpath("//*[text()='ADD TO BAG']")).isDisplayed(), true,"Add to Bag is displaying");
		dr.switchTo().window(parent);
	}
	
	

}
