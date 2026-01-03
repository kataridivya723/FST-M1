package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity15 {
	public static void main(String[] args) {
	WebDriver driver=new FirefoxDriver();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	driver.get("https://training-support.net/webelements/dynamic-attributes");
	System.out.println("Title of the page:"+driver.getTitle());
	
	WebElement fullName= driver.findElement(By.xpath("//input[starts-with(@id, 'full-name')]"));
	WebElement emailAddress= driver.findElement(By.xpath("//input[contains(@id, '-email')]"));
	WebElement eventDate= driver.findElement(By.xpath("//input[contains(@name, '-event-date-')]"));
	WebElement details = driver.findElement(By.xpath("//textarea[contains(@id, '-additional-details-')]"));
     
   
	//enter all the details here
	fullName.sendKeys("Katari Divya");
	emailAddress.sendKeys("kdivyafst@gmail.com");
	eventDate.sendKeys("2025-09-03");
	details.sendKeys("FST Selenium");
	
	//click on submit button
	driver.findElement(By.xpath("//button[text()='Submit']")).click();
	
	
	//wait and print success message
	WebElement message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
	System.out.println("Success message:"+message.getText());
	
	driver.quit();
	}
}
