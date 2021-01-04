package training.bdd.stepdefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import training.bdd.config.WebDriverConfig;

public class LoginStepDef {

	private WebDriver driver;

	@Given("^User navigate to the application$")
	public void user_navigate_to_the_application_and_swith_to_signin_mode() throws Throwable {
		driver = WebDriverConfig.webConfig();
		driver.get("http://adactinhotelapp.com/index.php");
	}

	@When("^user enter credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enter_credentials_and(String username, String password) throws Throwable {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	}

	@When("^user enters credentials (.+) and (.+)$")
	public void user_enter_credentials(String username, String password) throws Throwable {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	}

	@When("^user clicks on signin button$")
	public void user_clicks_on_signin_button() throws Throwable {
		driver.findElement(By.xpath("//input[@id='login']")).click();
	}

	@Then("^user logs in successfully$")
	public void user_logs_in_successfully() throws Throwable {
		String actual = driver.findElement(By.xpath("//input[@id='username_show']")).getAttribute("value");
//		Assert.assertEquals("Hello kanth123!", actual);
		System.out.println(actual);
	}

	@Then("^user logout$")
	public void user_logout() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		driver.quit();
	}

	@Then("^user receives bad credential error$")
	public void user_receives_bad_credential_error() throws Throwable {
		String actual = driver.findElement(By.xpath("//div[@class='auth_error']/child::b")).getText();
		String expected = "Invalid Login details or Your Password might have expired. Click here to reset your password";
		Assert.assertEquals(expected, actual);
		driver.quit();
	}

}
