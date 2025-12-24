package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
	WebDriver driver;

@BeforeClass
public void launchBrowser()
{
	driver=new FirefoxDriver();
	driver.get("http://alchemy.hguy.co/orangehrm");
	
	
}
//Get the current page url and print into the console
@Test
public void getPageUrl()
{
	    	String currentPageTitle = driver.getCurrentUrl();
	    	System.out.println("Page URL : "+currentPageTitle );
	    
		 
		  
	}

@AfterClass
public void tearDown()
{
	driver.close();
}

}
