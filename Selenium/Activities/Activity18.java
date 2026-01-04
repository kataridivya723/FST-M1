package Activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity18 {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		//WebDriverWait wait=new WebDriverWait(Duration,);
		
		driver.get("https://training-support.net/webelements/alerts");
		System.out.println("Title of the page:"+driver.getTitle());
		
		driver.findElement(By.id("simple")).click();
		Alert simpleAlert=driver.switchTo().alert();
		System.out.println("alert text:"+simpleAlert.getText());
		simpleAlert.accept();
		System.out.println(driver.findElement(By.id("result")).getText());
		
		
		driver.quit();
		
	}

}
