package Activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity20
{
	public static void main(String[] args) 
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/alerts");
		System.out.println("Title of the page:"+driver.getTitle());
		
		driver.findElement(By.id("prompt")).click();
		Alert promptAlert=driver.switchTo().alert();
		
		String alertText=promptAlert.getText();
		System.out.println("Prmo:"+alertText);
		
		promptAlert.sendKeys("Hello");
		promptAlert.accept();
	       
		// Print the message
	       System.out.println(driver.findElement(By.id("result")).getText());

		
}
}
