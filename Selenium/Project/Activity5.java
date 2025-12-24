package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity5 {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
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
    //Click on my Info
    @Test(priority = 1)
    public void clickOnMyInfo() {
    	wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewMyDetails")));
    	driver.findElement(By.id("menu_pim_viewMyDetails")).click();
	}
    //Add the employee
    @Test(priority=2)
    public void clickOnEdit()
    {
    	wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    	wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));
    	driver.findElement(By.id("btnSave")).click();
    	
    }
    //Edit details
    @Test(priority=3)
    public void editDetails()
    {
    	driver.findElement(By.id("personal_txtEmpFirstName")).clear();
    	driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("katari");
    	
    	driver.findElement(By.id("personal_txtEmpLastName")).clear();
    	driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("divya");
    	
    	driver.findElement(By.id("personal_optGender_1")).click();
    	
    	Select nationality =new Select(driver.findElement(By.id("personal_cmbNation")));
    	
    	nationality.selectByVisibleText("French");
    	driver.findElement(By.id("personal_DOB")).click();
    	
    	String day="8";
    	String month="Dec";
    	String year="1999";
    	
    	 driver.findElement(By.className("ui-datepicker-month")).click();
         WebElement monthElement = driver.findElement(By.className("ui-datepicker-month"));
         Select month1 = new Select(monthElement);
         month1.selectByVisibleText(month);
         
         driver.findElement(By.className("ui-datepicker-year")).click();
         Select year1 = new Select(driver.findElement(By.className("ui-datepicker-year")));
         year1.selectByVisibleText(year);

    	//select the day
    	driver.findElement(By.xpath("//table/tbody/tr/td/a[text()='"+day+"']")).click();
    	
    }
    @Test(priority = 4)
    public void clickonSave() {
    	driver.findElement(By.id("btnSave")).click();
    }
  //Close the browser
  	@AfterClass
  	public void tearDown()
  	{
  		driver.close();
  	}
}
