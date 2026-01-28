package activities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity3 
{
	AndroidDriver driver;
	 // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException
    {
    	File apkFile=new File("src/test/resources/calculator.apk");
	//Desired Capabilities
	UiAutomator2Options options =new UiAutomator2Options();
	options.setPlatformName("android");
	options.setAutomationName("UiAutomator2");
	options.setApp(apkFile.getAbsolutePath());
	options.noReset();
	
	 // Server Address
    URL serverURL = new URI("http://localhost:4723").toURL();
	
	//Driver Initialization
	driver =new AndroidDriver(serverURL, options);
	
    }
    
    @Test(priority=1)
    public void addTest()
    {
    	driver.findElement(AppiumBy.id("digit_5")).click();
    	driver.findElement(AppiumBy.accessibilityId("plus")).click();
    	driver.findElement(AppiumBy.accessibilityId("9")).click();
    	driver.findElement(AppiumBy.accessibilityId("equals")).click();
    	String result= driver.findElement(AppiumBy.id("result_final")).getText();
    	Assert.assertEquals("14", result);
    }
    @Test(priority=2)
    public void subTest()
    {
    	driver.findElement(AppiumBy.id("digit_1")).click();
    	driver.findElement(AppiumBy.id("digit_0")).click();
    	driver.findElement(AppiumBy.accessibilityId("minus")).click();
    	driver.findElement(AppiumBy.id("digit_5")).click();
    	driver.findElement(AppiumBy.accessibilityId("equals")).click();
    	
    	String result= driver.findElement(AppiumBy.id("result_final")).getText();
    	Assert.assertEquals("5", result);
    }
 // Test method
    @Test(priority=3)
    public void multiplyTest() {
        // Perform the calculation
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        driver.findElement(AppiumBy.id("digit_1")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
 
        // Find the result
        String result = driver.findElement(AppiumBy.id("result_final")).getText();
 
        // Assertion
        Assert.assertEquals(result, "500");
    }
 
    // Test method
    @Test(priority=4)
    public void divideTest() {
        // Perform the calculation
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("divide")).click();
        driver.findElement(AppiumBy.id("digit_2")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
 
        // Find the result
        String result = driver.findElement(AppiumBy.id("result_final")).getText();
 
        // Assertion
        Assert.assertEquals(result, "25");
    }
 
    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }

}


	
	