package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

public class Activity4 {
	public static void main(String args[])
	{
		WebDriver driver=new FirefoxDriver();
		driver.get(" https://training-support.net/webelements/target-practice");
		//Printing the page title
		System.out.println("Page title is:"+driver.getTitle());
		// Finding the 3rd header and printing text
		String thirdHeaderText = driver.findElement(By.xpath("//h3[contains(text(),'Heading #3')]")).getText();
		System.out.println(thirdHeaderText );
		
		// Finding the 5th header and printing it's color		
		 WebElement element_2 = driver.findElement(By.xpath("//h5"));
		 String color=element_2.getCssValue("background-color");
		 System.out.println(color);
		    
		String purpleButton=driver.findElement(By.xpath("//button[contains(text(),'Purple')]")).getAttribute("class");
		System.out.println(purpleButton);
		
		 String slateButtonText =driver.findElement(By.xpath("//button[contains(text(),'Slate')]")).getText();
		 System.out.println(slateButtonText);
		
		driver.quit();
	
	

}
}
