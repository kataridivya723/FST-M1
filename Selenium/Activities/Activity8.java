package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity8 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://training-support.net/webelements/mouse-events");
        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());
        
      Actions builder = new Actions(driver);
     WebElement  cargolock=driver.findElement(By.xpath("//h1[contains(text(),'Cargo.lock')]"));
     WebElement  cargotoml=driver.findElement(By.xpath("//h1[contains(text(),'Cargo.toml')]"));
      WebElement src=driver.findElement(By.xpath("//h1[contains(text(),'src')]"));
      WebElement target=driver.findElement(By.xpath("//h1[contains(text(),'target')]"));

     builder.click(cargolock).pause(1000).moveToElement(cargotoml).pause(5000).click(cargotoml).build().perform();
      String actionMessage = driver.findElement(By.id("result")).getText();
      System.out.println(actionMessage);
     
      
      builder.doubleClick(src).pause(1000).contextClick(target).pause(5000).build().perform();
      
      builder.click(driver.findElement(By.xpath("//div[@id='menu']/div/ul/li[1]"))).pause(5000).build().perform();
      
      String actionMessage1= driver.findElement(By.id("result")).getText();
      System.out.println(actionMessage1);
      driver.quit();
      
      
     
      
	}

}
