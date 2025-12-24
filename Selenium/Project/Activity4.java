package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity4 {
	WebDriver driver;
	WebDriverWait wait;
	String firstName = "divya";
	String lastName ="katari";
	
	// login
    @BeforeClass
    public void login() {
        // Initialize Firefox driver
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.manage().window().maximize();
      //enter user name
    	driver.findElement(By.id("txtUsername")).sendKeys("orange");
    	//enter password
    	driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
    	//click on login 
    	driver.findElement(By.id("btnLogin")).click();
    }
    
//	 click on PIm in menu
    @Test(priority = 1)
    public void clickOnPIM() {
    	wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewPimModule")));
    	driver.findElement(By.id("menu_pim_viewPimModule")).click();
    	
    	
    }
  //Add the employee
    @Test(priority = 2)
    public void addEmployee() {
    	wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnAdd")));
    	//click on add
    	driver.findElement(By.id("btnAdd")).click();   	
    	driver.findElement(By.id("firstName")).sendKeys(firstName);
    	driver.findElement(By.id("lastName")).sendKeys(lastName);
    	driver.findElement(By.id("btnSave")).click();
   	
    }
    
    @Test(priority=3)
    public void emList()
    {
    	driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("empsearch_employee_name_empName")));
    	driver.findElement(By.id("empsearch_employee_name_empName")).clear();
    	driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys(firstName+" "+lastName);
    	driver.findElement(By.id("searchBtn")).click();
    	//get employee name
    	String actualFN = driver.findElement(By.xpath("//table/tbody/tr/td[3]")).getText();
    	String actualLN = driver.findElement(By.xpath("//table/tbody/tr/td[4]")).getText();
    	
    	//Verify
    	System.out.println("Added Employee:" + actualFN+" "+actualLN);
    	Assert.assertEquals(firstName+" "+lastName, actualFN+" "+actualLN);
    }

@AfterClass
public void tearDown()
{
	driver.close();

}
}
