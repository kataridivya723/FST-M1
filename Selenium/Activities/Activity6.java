package Activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Activity6 {

	public static void main(String[] args) {
		 WebDriver driver = new FirefoxDriver();

	        // Open the page
	        driver.get("https://training-support.net/webelements/dynamic-controls");
	        // Print the title of the page
	        System.out.println("Page title: " + driver.getTitle());
	        
	        
	        WebElement checkbox=driver.findElement(By.xpath("//input[@name='checkbox']"));
	        
	       boolean checkboxSelected = driver.findElement(By.xpath("//input[@name='checkbox']")).isSelected();
	       System.out.println("Check the chcebox is selected: " + checkboxSelected);
	       
	       driver.findElement(By.xpath("//input[@name='checkbox']")).click();
	       
	       boolean checkboxSelected1 = driver.findElement(By.xpath("//input[@name='checkbox']")).isSelected();
	       System.out.println("Check the chcebox is selected: " + checkboxSelected1);
	       driver.close();
	      
	}
}