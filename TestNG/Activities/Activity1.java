package Activities;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
	WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		driver=new FirefoxDriver();
		driver.get("https://training-support.net");
	}
	
	@Test(priority=1)
	public void homepageTitle()
	{ 
		// Assert page title
		Assert.assertEquals(driver.getTitle(), "Training Support");
		 // Find and click the About page link
		driver.findElement(By.xpath("//a[contains(text(),'About Us')]")).click();
		
	}
	
	@Test(priority=2)
	public void loginPage()
	{
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "About Training Support");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	



}