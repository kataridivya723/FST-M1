package Activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Activity1 {
	
	WebDriver driver;
	
	
	@BeforeClass
	public void launchBrowser()
	{
		driver=new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
		
		
	}
	//Get the title of the website
	@Test(priority=1)
	public void getPageTitle()
	{
		String pageTitle=driver.getTitle();
		System.out.println("original title of the page:"+driver.getTitle());
		
		
	}
	// Checking it is matching with "OrangeCRM" and it should Match
	@Test(priority=2)
	public void verifyPageTitle()
	{
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	//Close the browser
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}

}
