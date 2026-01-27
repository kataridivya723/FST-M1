package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity4_LoginSteps extends BaseClass
{
	@Given("the user is on the login page")
	public void login()
	{
		driver.get("https://training-support.net/webelements/login-form");
	}
	@When("the user enters username and password")
	public void enterCredentials()
	{
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
	}

	@When("the user enters {string} and {string}")
    public void enterCredentialsFromInputs(String username, String password) {
        // Find the input fields
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        // Clear the fields
        usernameField.clear();
        passwordField.clear();
        // Find username field and enter username
        usernameField.sendKeys(username);
        // Find password field and enter password
        passwordField.sendKeys(password);
	}
    @And("clicks the submit button")
    public void submit()
    {
    	  driver.findElement(By.xpath("//button[text()='Submit']")).click();
    }
    @Then("get the confirmation text and verify message as verify it")
    public void confirmMessage()
    {
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2.mt-5"))).getText();
		String meesageConfirm=driver.findElement(By.cssSelector("h2.mt-5")).getText();
		Assertions.assertEquals("Welcome Back, Admin!", meesageConfirm);
    }
    @Then("get the confirmation text and verify message as {string}")
    public void confirmMessageAsInput(String expectedMessage)
    {
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2.mt-5"))).getText();
		String meesageConfirm=driver.findElement(By.cssSelector("h2.mt-5")).getText();
		Assertions.assertEquals("Welcome Back, Admin!", meesageConfirm);
    }
}
