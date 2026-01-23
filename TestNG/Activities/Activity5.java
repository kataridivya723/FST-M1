package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.Color;

public class Activity5 
{
WebDriver driver;
	
	@BeforeClass(alwaysRun=true)
	public void setUp()
	{
		driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice");
	}
	
	@Test(groups= {"HeaderTests","ButtonTests"})
	public void pageTitleTest()
	{
		String title=driver.getTitle();
		System.out.println("Current Page title is :"+ title);
		Assert.assertEquals("Selenium: Target Practice", title);	
	}
	
	@Test(dependsOnMethods= {"pageTitleTest"},groups={"HeaderTests"})
	public void HeaderTest1()
	{
		
		//Find the third header and assert the text in the h3 tag.
		String thirdHeader=driver.findElement(By.xpath("//h3[text()='Heading #3']")).getText();
		Assert.assertEquals(thirdHeader, "Heading #3");
		
				
	}
	@Test(dependsOnMethods= {"pageTitleTest"},groups={"HeaderTests"})
	public void HeaderTest2()
	{
	//Find and assert the colour of the fifth header tag element.
		
			WebElement fifthHeaderColor=driver.findElement(By.xpath("//h5[text()='Heading #5']"));
			
			// Get CSS color value (rgba format) 
			String cssColor = fifthHeaderColor.getCssValue("color"); 
			// Convert to hex using Selenium's Color class 
			String hexColor = Color.fromString(cssColor).asHex(); 
			System.out.println(hexColor);
			// Assert 
			Assert.assertEquals(hexColor, "#9333ea");
	}
	@Test(dependsOnMethods= {"pageTitleTest"},groups={"ButtonTests"})
	public void ButtenTest1()
	{
		//Find the button with the class emerald and assert it text.
		String emerald=driver.findElement(By.xpath("//button[text()='Emerald']")).getText();
		Assert.assertEquals(emerald, "Emerald");
		
	}
	@Test(dependsOnMethods= {"pageTitleTest"},groups={"ButtonTests"})
	public void ButtenTest2()
	{
		//Find and assert the colour of the first button in the third row
		WebElement element3color=driver.findElement(By.xpath("//button[text()='Purple']"));
		// Get CSS color value (rgba format) 
		String cssColor = element3color.getCssValue("color"); 
		// Convert to hex using Selenium's Color class 
		String hexColor = Color.fromString(cssColor).asHex(); 
		System.out.println(hexColor);
		// Assert 
		Assert.assertEquals(hexColor, "#581c87");
	}
	@AfterClass(alwaysRun=true)
    public void afterClass() 
    {
        // Close browser
        driver.close();
    }

	
	}
	

