package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity22 {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/popups");
		System.out.println("Page Title is:"+driver.getTitle());
		
		//click on button to launch popup
		driver.findElement(By.id("launcher")).click();
		
		//Wait for the popup to appear
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("username"))));
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		String message=driver.findElement(By.cssSelector("h2.text-center")).getText();
		System.out.println("After Login Message is:"+message);
		driver.quit();
		

	}

}
