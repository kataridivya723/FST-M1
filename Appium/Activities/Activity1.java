package activities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {


	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp()throws MalformedURLException, URISyntaxException
	{
		//setting apk path here
		File appFile=new File("src/test/resources/Calculator.apk");
		UiAutomator2Options caps=new UiAutomator2Options();
		caps.setPlatformName("Android");
		caps.setAutomationName("UiAutomator2");
		caps.setApp(appFile.getAbsolutePath());
	
	//Appiumserver url
	URL serverURL =new URI("http://localhost:4723").toURL();
	driver = new AndroidDriver(serverURL, caps);

}
	
	@Test
	public void CalMultiplication()
	{	
		//enter digit 2
		driver.findElement(AppiumBy.id("digit_2")).click();
		//click on multiply
		driver.findElement(AppiumBy.accessibilityId("multiply")).click();
		//enter digit 5
		driver.findElement(AppiumBy.id("digit_5")).click();
		//click on =
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		
		String res=driver.findElement(AppiumBy.id("result_final")).getText();
		//Perform AssertionEquals 
		Assert.assertEquals(res,"10");//true
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
