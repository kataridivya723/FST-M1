package stepDefinitions;

import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity1Steps extends BaseClass
{
	@Given("user is on the TS homepage")
	public void openTSHomepage()
	{
		driver.get("https://training-support.net");
		System.out.println("HomePage Title:"+driver.getTitle());
		Assertions.assertEquals("Training Support",driver.getTitle());
	}
	@When("the user clicks on the About Us link")
	public void clickAboutUs()
	{
		driver.findElement(By.xpath("//a[text()='About Us']")).click();
	}

	@Then("they are redirected to another page")
	public void redirectionPage()
	{
		//System.out.println("After click on About Us Page Redirect to:"+driver.getTitle());
		wait.until(ExpectedConditions.titleIs("About Training Support"));
		//Assertions.assertEquals("About Training Support",driver.getTitle());
		String pageHeading = driver.findElement(By.xpath("//h1[text()='About Us']")).getText();
		System.out.println("New page title is: " + pageHeading);
		Assertions.assertEquals(pageHeading, "About Us");
	}
		
}


