package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {
	public static void main(String[] args) {
		 WebDriver driver = new FirefoxDriver();

	        // Open the page
	        driver.get("https://training-support.net/webelements/dynamic-controls");
	        // Print the title of the page
	        System.out.println("Page title: " + driver.getTitle());
	        
	        
	        WebElement textField=driver.findElement(By.xpath("//input[@name='textInput']"));
	        
	      // boolean TextFieldEnable=driver.findElement(By.xpath("//input[@name='textInput']")).isEnabled();
	       System.out.println("Is TextField enabled:"+textField.isEnabled());
	       
	       //click on button to enable 
	       driver.findElement(By.xpath("//button[contains(text(),'Enable Input')]")).click();
	       
	       System.out.println("Is TextField enabled:"+textField.isEnabled());
	       
	       textField.sendKeys("Selenium");
	        System.out.println(textField.getDomProperty("value"));
	       
	       driver.close();
	       
	       
	       
	       
	       
	        
	}

}
