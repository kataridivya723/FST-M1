package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10 {
	public static void main(String args[])
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/drag-drop");
		System.out.println("Original Page:"+driver.getTitle());
		Actions builder=new Actions(driver);
		WebElement football=driver.findElement(By.id("ball"));
		WebElement dropZone1=driver.findElement(By.id("dropzone1"));
		WebElement dropZone2=driver.findElement(By.id("dropzone2"));
		
		builder.clickAndHold(football).moveToElement(dropZone1).pause(5000).release().build().perform();
		String dropped1=dropZone1.findElement(By.className("dropzone-text")).getText();
		if(dropped1.equals("Dropped!"))
		{
			System.out.println("ball is dropped in the dropzone1");
		}
		builder.dragAndDrop(football, dropZone2).pause(5000).build().perform();
		
		String dropped2=dropZone2.findElement(By.className("dropzone-text")).getText();
		if(dropped2.equals("Dropped!"))
		{
			System.out.println("ball is dropped in the dropzone2");
		}
			
		
		driver.close();
	}

	
		


}
