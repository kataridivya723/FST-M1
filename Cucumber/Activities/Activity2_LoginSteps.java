package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity2_LoginSteps extends BaseClass
{

	@Given("the user is on the login page")
	public void loginPage()
	{
		driver.get("https://training-support.net/webelements/login-form");
	}
	@When("the user enters username and password")
	public void enterCredentials()
	{
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
	}
	@And("clicks the submit button")
	public void submitButton()
	{
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}
	@Then("get the confirmation message and verify it")
	public void confirmMessage()
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2.mt-5"))).getText();
		String meesageConfirm=driver.findElement(By.cssSelector("h2.mt-5")).getText();
		Assertions.assertEquals("Welcome Back, Admin!", meesageConfirm);
	}
}
