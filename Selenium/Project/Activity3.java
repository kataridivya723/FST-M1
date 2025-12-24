package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Activity3 {
		WebDriver driver;
		
		@BeforeTest
		public void launchBrowser()
		{
		
		driver=new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
		}
		
		@Test(priority=1)
		public void login() {
	
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		driver.findElement(By.id("btnLogin")).click();
		}
		
		//Verify the home page is opened
		@Test(priority=2)
		public void homePage()
		{
			System.out.println("Homepage URL:" + driver.getCurrentUrl());
	        Assert.assertEquals(driver.getCurrentUrl(), "http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/dashboard");
				
	        
		}
		@AfterTest
		public void tearDown()
		{
			driver.close();

		}

}
