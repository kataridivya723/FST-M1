package Activities;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 {
	WebDriver driver;
	WebDriverWait wait;
	
	
	// login
    @BeforeClass
    public void login() {
        // Initialize Firefox driver
        driver = new FirefoxDriver();
        
    	//driver=new ChromeDriver();
        
 
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.manage().window().maximize();
      //enter user name
    	driver.findElement(By.id("txtUsername")).sendKeys("orange");
    	//enter password
    	driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
    	//click on login 
    	driver.findElement(By.id("btnLogin")).click();
    }
    @Test(priority = 1)
    public void clickonDirectory() {
    	wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    	wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_directory_viewDirectory")));
    	
 
    	Assert.assertTrue(driver.findElement(By.id("menu_directory_viewDirectory")).isDisplayed());
    	System.out.println("Directory is visible in the menu");
    	Assert.assertTrue(driver.findElement(By.id("menu_directory_viewDirectory")).isEnabled());
    	System.out.println("Directory is clickable in the menu");
    	driver.findElement(By.id("menu_directory_viewDirectory")).click();
    }
    @Test(priority = 2)
    public void clickon() {
    String dirMenuHeading=driver.findElement(By.xpath("//div[@class='head']/h1")).getText();
	Assert.assertEquals(dirMenuHeading, "Search Directory");    
    }
// 	close the browser.
    @AfterClass
    public void closeBrowser() {
    	// Close the browser
       driver.quit();
    }
}