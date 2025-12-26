package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11 {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
		
	
		driver.get("https://training-support.net/webelements/dynamic-controls");
		System.out.println("Page Title:" +driver.getTitle());
		
		
		//check and print is checkbox display
		WebElement checkbox=driver.findElement(By.xpath("//input[@name='checkbox']"));
		System.out.println("isDisplayed the checkbox:"+checkbox.isDisplayed());//true
		
	
		
		//click on the toggle button
		driver.findElement(By.xpath("//button[contains(text(),'Toggle Checkbox')]")).click();
		
		
		wait.until(ExpectedConditions.invisibilityOf(checkbox));
		System.out.println("isDisplayed after click on button:"+checkbox.isDisplayed());//false
		
		//click on the toggle button
		driver.findElement(By.xpath("//button[contains(text(),'Toggle Checkbox')]")).click();
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
		checkbox.click();
		
		//Check is checkbox selected
		System.out.println("Is checkbox selected:"+checkbox.isSelected());//true
		
		
		driver.close();
}
}
