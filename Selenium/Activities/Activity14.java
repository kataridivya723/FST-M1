package Activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity14 {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/tables");
		System.out.println("Title of the page:"+driver.getTitle());

		List<WebElement> columns=driver.findElements(By.xpath("//thead//tr//th"));
		System.out.println("Columns size:"+columns.size());
		
		
		List<WebElement> rows=driver.findElements(By.xpath("//table//tbody//tr"));
		System.out.println("Rows size:"+rows.size());
		
		// Book Name in the 5th row
		WebElement row5=driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
		System.out.println("BookName in 5th row is :"+row5.getText());
		
		driver.findElement(By.xpath("//th[text()='Price']")).click();
		
		//Print BookName in the 5th Row Again AFter sorting
		WebElement rowValue=driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
		System.out.println("BookName in 5th row After Sort is :"+rowValue.getText());
		driver.quit();
	}

}
