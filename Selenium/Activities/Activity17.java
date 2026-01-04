package Activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/selects");
		System.out.println("Title of the page:"+driver.getTitle());
		
		WebElement dropDown= driver.findElement(By.cssSelector("select.h-80"));
		Select select =new Select(dropDown);
		
		select.selectByVisibleText("HTML");
		
		
		 // Select 4th, 5th, and 6th index options
		for(int i=3;i<=5;i++)
		{
			select.selectByIndex(i);
		
		}	
		
		// Select "Node" using value attribute
		select.selectByValue("nodejs");	
		
		List<WebElement> options= select.getAllSelectedOptions();
		System.out.println("All selected options:");
		for (WebElement option : options)
		{
				System.out.println(option.getText());
		}
		
		//Deselect 4th index value
		select.deselectByIndex(4);
	
		options= select.getAllSelectedOptions();
		System.out.println("After deselct selected options:");
		for (WebElement option : options) 
		{
			System.out.println(option.getText());
		}
		driver.quit();
		
		
		 
      
       
	}

}
