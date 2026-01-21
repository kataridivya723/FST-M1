package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp()
	{
		driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice/");
		
	}
	
	//This testcase will pass
	@Test
	public void testCase1()
	{
		String title= driver.getTitle();
		System.out.println("Original Title:"+title);
		Assert.assertEquals(title, "Selenium: Target Practice");
	}
	
	// This test case will Fail
	@Test
	public void testCase2()
	{
		
		WebElement blackButton=driver.findElement(By.xpath("//button[contains(text(),'Black')]"));
		Assert.assertTrue(blackButton.isDisplayed());
		Assert.assertEquals(blackButton.getText(), "Black");
		
	}
	 // This test will be skipped and not counted
	@Test(enabled=false)
	public void testCase3()
	{
		WebElement pinkButton=driver.findElement(By.xpath("//button[contains(text(),'Pink')]"));
		Assert.assertTrue(pinkButton.isDisplayed());
		Assert.assertEquals(pinkButton.getText(), "Pink");
	}
	
	// This test will be skipped and will be be shown as skipped
	@Test
	public void testCase4()
	{
		throw new SkipException("Skipping the testcase");
	}
	
	
	
	public void tearDown()
	{
		driver.close();
	}
	

}

