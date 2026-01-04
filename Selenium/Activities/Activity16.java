package Activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity16 {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/selects");
		System.out.println("Title of the page:"+driver.getTitle());
		
		WebElement dropDown= driver.findElement(By.xpath("//select"));
		Select select =new Select(dropDown);
		
		//Select the second option using visible text
		select.selectByVisibleText("Two");
		System.out.println("Second option: " + select.getFirstSelectedOption().getText());

		//Select the third option using visible text
		select.selectByIndex(3);//Three
		System.out.println("Third option: " + select.getFirstSelectedOption().getText());
		
		//Select the fourth option using visible text
		select.selectByValue("four");
		System.out.println("Fourth option: " + select.getFirstSelectedOption().getText());
		
		
		List<WebElement> options=select.getOptions();
		for(WebElement ls: options)
		{
			System.out.println(ls.getText());
		}
		
		driver.quit();


	}

}
