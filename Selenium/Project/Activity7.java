package Activities;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity7 {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void login()
	{
		driver= new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
		//enter user name
    	driver.findElement(By.id("txtUsername")).sendKeys("orange");
    	//enter password
    	driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
    	//click on login 
    	driver.findElement(By.id("btnLogin")).click();
		
	}
	@Test(priority=1)
	public void MyInfo()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewMyDetails")));
		Assert.assertTrue(driver.findElement(By.id("menu_pim_viewMyDetails")).isDisplayed());
    	System.out.println("MyInfo is visible in the menu");
    	Assert.assertTrue(driver.findElement(By.id("menu_pim_viewMyDetails")).isEnabled());
    	System.out.println("MyInfo is clickable in the menu");
    	driver.findElement(By.id("menu_pim_viewMyDetails")).click();
	}
	
	@Test(priority=2)
	public void clickonQualification()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='sidenav']//*[text()='Qualifications']")));
		//click on qualifications
		driver.findElement(By.xpath("//ul[@id='sidenav']//*[text()='Qualifications']")).click();
		
	}
	
	@Test(priority=3)
	public void Add()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("addWorkExperience")));
		//click on add
		driver.findElement(By.id("addWorkExperience")).click();
		driver.findElement(By.id("experience_employer")).sendKeys("ibm");
		//job title
    	driver.findElement(By.id("experience_jobtitle")).sendKeys("Tester");
    	//comment
    	driver.findElement(By.id("experience_comments")).sendKeys("Selenium Project-Activity7");
    	//click on save 
    	driver.findElement(By.id("btnWorkExpSave")).click();
		
	}
	
	// 	close the browser.
    @AfterClass
    public void closeBrowser() 
    {
    	// Close the browser
       driver.quit();
	}
}

