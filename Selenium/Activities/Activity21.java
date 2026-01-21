package Activities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity21 {
	
	public static void main(String[] args) 
	{
        WebDriver driver = new FirefoxDriver();
        // Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the page
        driver.get("https://training-support.net/webelements/tabs");
        // Print the title of the page
        System.out.println("Title of the Page: " + driver.getTitle());
        // Print the handle of the parent window
        System.out.println("Current tab: " + driver.getWindowHandle());

        // Find button to open new tab
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Open A New Tab']"))).click();
        // Wait for the second tab to open
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        // Print all window handles
        System.out.println("Currently open windows: " + driver.getWindowHandles());

        Set<String> handles=driver.getWindowHandles();
    	
    	//switch to latest tab
    	for(String handle : handles)
    	{
    			driver.switchTo().window(handle);
    	}
    	
    	System.out.println("----------");

        // Wait for the new page to load
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Open Another One']")));
        // Print the handle of the current tab
        System.out.println("Current tab: " + driver.getWindowHandle());
        // Print the title and heading of the new page
        System.out.println("New Page title: " + driver.getTitle());
        System.out.println("New Page message: " + driver.findElement(By.cssSelector("h2.mt-5")).getText());
        // Find and click the button on page to open another tab
        driver.findElement(By.xpath("//button[text()='Open Another One']")).click();

        // Wait for new tab to open
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        // Switch focus
        for (String handle : handles) {
            driver.switchTo().window(handle);
        }

        // Close the browser
        driver.quit();
    }
}