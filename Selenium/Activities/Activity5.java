package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/dynamic-controls");
		System.out.println("Page Title:" +driver.getTitle());
		
		WebElement Checkbox=driver.findElement(By.xpath("//input[@name='checkbox']"));
		
		
		//checking and printing is Checkbox is displaying
		boolean checkboxDis=driver.findElement(By.xpath("//input[@name='checkbox']")).isDisplayed();
		System.out.println("isDisplayed the checkbox:"+checkboxDis);//true
		
		//clicking on the button
		driver.findElement(By.xpath("//button[contains(text(),'Toggle Checkbox')]")).click();
		
		boolean checkboxDis1=driver.findElement(By.xpath("//input[@name='checkbox']")).isDisplayed();
		System.out.println("isDisplayed after click on button:"+checkboxDis1);//false
		
		
		driver.close();

	}

}
