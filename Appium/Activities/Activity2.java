package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp()throws MalformedURLException, URISyntaxException
	{
		UiAutomator2Options caps=new UiAutomator2Options();
		caps.setPlatformName("Android");
		caps.setAutomationName("UiAutomator2");
		caps.setAppPackage("com.android.chrome");
		caps.setAppActivity("com.google.android.apps.chrome.Main");
		caps.noReset();
		
		// Server Address
		URL serverURL = new URI("http://localhost:4723").toURL();
		// Driver Initialization
		driver = new AndroidDriver(serverURL, caps);
		driver.get("https://training-support.net");
}
	 @Test
	    public void trainingSupport() 
	 	{
		 // Find heading of new page and print to console
	        String pageHeading = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Training Support\"]")).getText();
	        System.out.println("trainingsupport page heading is :"+pageHeading);
	        Assert.assertEquals(pageHeading,"Training Support");
	        
	       
	     // Find and click the About Us link
	        driver.findElement(AppiumBy.accessibilityId("About Us")).click();
	      
	        //Find AboutUs Button Page Heading
	        String aboutButton = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"About Us\"]")).getText();
	        System.out.println("aboutUsButtonPage Heading is:"+aboutButton);
	      
	      
	 	}
	 @AfterClass
	 public void tearDown() 
	 {
		 driver.quit();
		 
	 }
}
