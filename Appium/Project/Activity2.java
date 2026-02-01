package examples;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {
	
	AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException  {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();
        // options.setNoReset(false); 

        // Server Address
        URL serverURL = new URI("http://localhost:4723/").toURL();

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Open the page in Chrome
        driver.get("https://training-support.net/webelements");
    }
    @Test(priority=1)
    public void todoAdd() throws InterruptedException {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View")));
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));

        //selecting To-Do card
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"To-Do List\"]")).click();
        Thread.sleep(100);
        //Adding First Task
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"todo-input\"]")).sendKeys("Add tasks to list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"todo-add\"]")).click();
        //Adding Second Task
        Thread.sleep(100);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"todo-input\"]")).sendKeys("Get number of tasks");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"todo-add\"]")).click();
        //Adding Third Task
        Thread.sleep(100);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"todo-input\"]")).sendKeys("Clear the list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"todo-add\"]")).click();

        //striking the tasks out
        driver.findElement(AppiumBy.xpath("//android.widget.ListView/android.view.View[3]/android.view.View/android.widget.CheckBox")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.ListView/android.view.View[4]/android.view.View/android.widget.CheckBox")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.ListView/android.view.View[5]/android.view.View/android.widget.CheckBox")).click();

       //Assertions
        List<WebElement> tasks = driver.findElements(AppiumBy.androidUIAutomator(
    	        "new UiSelector().className(\"android.widget.CheckBox\")"));
        System.out.println("Todo list size: " +tasks.size());
        Assert.assertEquals(tasks.size(), 5,
                "Task count mismatch in To-Do list");
    } 
    
    // ==============================
    // Activity 2: Login - Correct
    // ==============================
    @Test(priority = 2)
    public void loginWithCorrectCredentials() throws InterruptedException {

        driver.get("https://training-support.net/webelements");
        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"Login Form\"))"
                )
        ).click();
        
        Thread.sleep(10);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("admin");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Submit\"]")).click();
       
        
        WebElement message =driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Welcome Back, Admin!\"]"));
        Assert.assertEquals(message.getText(),"Welcome Back, Admin!","Welcome message mismatch");
    }

    //Login - With Invalid Credentials
    @Test(priority = 3)
    public void loginWithIncorrectCredentials() throws InterruptedException {
    	

        driver.get("https://training-support.net/webelements");
        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"Login Form\"))"
                )
        ).click();
        
        Thread.sleep(10);
      
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("admin");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password30");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Submit\"]")).click();
        
        WebElement message =driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"subheading\"]"));
     
        Assert.assertEquals(message.getText(),"Invalid credentials","message mismatch");
    	
    } 
    
    // ==============================
    // Activity 3: PoPup Login
    // ==============================
    @Test(priority = 4)
    public void popupLoginTest() throws InterruptedException {

        driver.get("https://training-support.net/webelements");
        
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View")));
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollForward()"));
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollForward()"));

        //selecting PopUp card
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Popups Work with popups!\"]")).click();       
        Thread.sleep(100);


        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"launcher\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text=\"Selenium: Popups\"]/android.view.View")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("admin");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Submit\"]")).click();

        WebElement message = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Welcome Back, Admin!\"]"));

        Assert.assertEquals(message.getText(),
                "Welcome Back,Admin!",
                "Popup login success message mismatch");
    }  
    
    @AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}