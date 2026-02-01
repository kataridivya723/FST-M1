package examples;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
	
	// Driver Declaration
    AndroidDriver driver;
 
    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
        // Desired Capabilities
        File appFile = new File("src/test/resources/ts-todo-list-v1.apk");
        UiAutomator2Options options = new UiAutomator2Options();
        
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setApp(appFile.getAbsolutePath());
        
        // Core Fixes for "Instrumentation Process not running"
        options.setCapability("appium:systemPort", 8201);
        options.setCapability("appium:uiautomator2ServerLaunchTimeout", 90000);
        options.setCapability("appium:adbExecTimeout", 60000);
        
        // Activity Management
        options.setCapability("appium:appPackage", "com.app.todolist");
        options.setCapability("appium:appWaitActivity", "com.app.todolist.*");
        options.setCapability("appium:appWaitActivity", "com.app.todolist.view.SplashActivity,com.app.todolist.view.MainActivity,com.app.todolist.*");
        options.noReset();
        //options.setNoReset(false); 

        // Server Address
        URL serverURL = new URI("http://localhost:4723").toURL();
        
     // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }
   
    // Method1: Add activities to the list
    // ==========================
    @Test(priority=1)
    public void todoListMethod() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@resource-id=\"com.app.todolist:id/fab_new_task\"]\r\n"
    			+ "")).click();
     wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.app.todolist:id/et_new_task_name")));
    	 driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.app.todolist:id/et_new_task_name\"]\r\n"
    	 		+ "")).sendKeys("Activity1");
    	 driver.findElement(AppiumBy.id("com.app.todolist:id/et_new_task_description")).
    	 sendKeys("Complete Appium Project");
    	 driver.findElement(AppiumBy.id("com.app.todolist:id/tv_new_task_priority")).click();
    	 driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" "
    	 		+ "and @text=\"High\"]")).click();
    	 driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok")).click();

    //Adding activity2 with Priority Medium
    	 driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@resource-id=\"com.app.todolist:id/fab_new_task\"]\r\n"
     			+ "")).click();
      wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.app.todolist:id/et_new_task_name")));
     	 driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.app.todolist:id/et_new_task_name\"]\r\n"
     	 		+ "")).sendKeys("Activity2");
     	 driver.findElement(AppiumBy.id("com.app.todolist:id/et_new_task_description")).
     	 sendKeys("Write Test cases for LDAP API node");
     	 driver.findElement(AppiumBy.id("com.app.todolist:id/tv_new_task_priority")).click();
     	 driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Medium\"]\r\n"
     	 		+ "")).click();
     	 driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok")).click();
     	 
     	//Adding activity3 with Priority Low
   	 driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@resource-id=\"com.app.todolist:id/fab_new_task\"]\r\n"
    			+ "")).click();
     wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.app.todolist:id/et_new_task_name")));
    	 driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.app.todolist:id/et_new_task_name\"]")).sendKeys("Activity3");
    	 driver.findElement(AppiumBy.id("com.app.todolist:id/et_new_task_description")).
    	 sendKeys("Complete Regression testing for EURA");
    	 driver.findElement(AppiumBy.id("com.app.todolist:id/tv_new_task_priority")).click();
    	 driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Low\"]")).click();
    	 driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok")).click(); 

    	 Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_name\" and @text=\"Activity1\"]")).isDisplayed());
    	 Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_name\" and @text=\"Activity2\"]")).isDisplayed());
    	 Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_name\" and @text=\"Activity3\"]")).isDisplayed());
    } 
    
    // Method2: Edit Task & Add Deadline
    // ==========================
    @Test(priority = 2)
    public void editTaskAddDeadlineTest() {

    	WebElement firstTask =
    	        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_name\" and @text=\"Activity1\"]"));

    	RemoteWebElement remoteElement = (RemoteWebElement) firstTask;

    	driver.executeScript("mobile: longClickGesture", Map.of(
    	        "elementId", remoteElement.getId(),
    	        "duration", 2000
    	));

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Edit To-Do Task\"]")).click();
        driver.findElement(AppiumBy.id("com.app.todolist:id/tv_todo_list_deadline")).click();

        // Select next Saturday (03 Jan, 2026)
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Next month\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"03 January 2026\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.app.todolist:id/bt_deadline_ok\"]")).click();

        // Assertion
        Assert.assertTrue(
                driver.findElement(AppiumBy.id("com.app.todolist:id/tv_todo_list_deadline")).isDisplayed(),
                "Deadline is not displayed"
        );
        driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok")).click(); 
    } 
    
    // Method3: Complete Tasks
    // ==========================
    @Test(priority = 3)
    public void completeTasksTest() {

        // Mark first two tasks complete
        driver.findElement(AppiumBy.xpath("(//android.widget.CheckBox[@resource-id=\"com.app.todolist:id/cb_task_done\"])[1]")).click();
        driver.findElement(AppiumBy.xpath("(//android.widget.CheckBox[@resource-id=\"com.app.todolist:id/cb_task_done\"])[2]")).click();

        // Long press third task (Activity3)
        WebElement thirdTask = driver.findElement(
                AppiumBy.xpath("//android.widget.TextView[@resource-id='com.app.todolist:id/tv_exlv_task_name' and @text='Activity3']")
        );

        RemoteWebElement remoteElement = (RemoteWebElement) thirdTask;

        driver.executeScript("mobile: longClickGesture", Map.of(
                "elementId", remoteElement.getId(),
                "duration", 2000
        ));

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Edit To-Do Task\"]")).click();

        // Slide progress bar to 50%
        WebElement slider = driver.findElement(AppiumBy.xpath("//android.widget.SeekBar[@resource-id=\"com.app.todolist:id/sb_new_task_progress\"]"));

        driver.executeScript("mobile: swipeGesture", Map.of(
                "elementId", ((RemoteWebElement) slider).getId(),
                "direction", "right",
                "percent", 0.5
        ));

        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.app.todolist:id/bt_new_task_ok\"]")).click();

        // View completed tasks
        driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"More options\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.androidUIAutomator(
                		 "new UiSelector().text(\"Completed tasks\")")));
       // driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/title\" and @text=\"Completed tasks\"]")).click();
        driver.findElement(
        	    AppiumBy.androidUIAutomator(
        	        "new UiSelector().text(\"Completed tasks\")"
        	    )
        	).click(); 
        // Assertion: Only 2 completed tasks
        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"Activity\")"
                )
        ));

        List<WebElement> completedTasks =
                driver.findElements(
                    AppiumBy.androidUIAutomator(
                        "new UiSelector().textContains(\"Activity\")"
                    )
        );

        System.out.println("Completed tasks found: " + completedTasks.size());
        Assert.assertEquals(completedTasks.size(), 2,
                "Only 2 tasks should be marked completed");
    }


    
 // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
    
   

}