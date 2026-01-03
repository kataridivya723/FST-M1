package Activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity13 {
	
	public static void main(String args[])
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/tables");
		System.out.println("Title of the page:"+driver.getTitle());
		
		List<WebElement> colomns=driver.findElements(By.xpath("//table/thead//tr//th"));
		System.out.println(colomns.size());
		
		
		List<WebElement> rows=driver.findElements(By.xpath("//table//tbody//tr"));
		System.out.println(rows.size());
		
		//Third row of the table.
		List<WebElement> thirdrow=driver.findElements(By.xpath("//table//tbody//tr[3]//td"));
		System.out.println("Third row cell values:");
		 for(WebElement cell : thirdrow) {
	            System.out.println(cell.getText());
	        }
		 
		 
		 // second row second column.
		 WebElement cellValue=driver.findElement(By.xpath("//tbody/tr/td[3]"));
		 System.out.println("2nd Row 2nd cloumn text is :"+cellValue.getText());
		 driver.quit();
	}
	
	

}
