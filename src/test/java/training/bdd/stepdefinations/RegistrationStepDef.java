package training.bdd.stepdefinations;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import training.bdd.config.WebDriverConfig;

public class RegistrationStepDef {

	private WebDriver driver;

	@Given("^User navigate to the phptravels site$")
	public void user_navigate_to_the_phptravels_site() throws Throwable {
		System.out.println("Background setup");
		driver = WebDriverConfig.webConfig();
		driver.get("https://www.phptravels.net/home");
	}

	@Given("^user in home page$")
	public void user_in_home_page() throws Throwable {
		System.out.println("Get Page title ==>" + driver.getTitle());
	}

	@When("^he click on My Account dropdown and select sigin up option$")
	public void he_click_on_My_Account_dropdown_and_select_sigin_up_option() throws Throwable {
		driver.findElement(By.xpath("//div[@class='dropdown dropdown-login dropdown-tab']/child::a")).click();
		driver.findElement(By.xpath("//a[text()='Sign Up']")).click();
		Thread.sleep(2000);
	}

	@When("^user fills the following registraion details$")
	public void user_fills_the_following_registraion_details(DataTable details) throws Throwable {
		List<String> userDetails = details.asList(String.class);
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(userDetails.get(0));
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(userDetails.get(1));
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(userDetails.get(2));
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(userDetails.get(3));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(userDetails.get(4));
		driver.findElement(By.xpath("//input[@name='confirmpassword']")).sendKeys(userDetails.get(5));
	}

	@And("^user click on sign up button$")
	public void user_click_on_sign_up_button() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Sign Up')]")));
		Thread.sleep(3000);
	}

	@Then("^redirect to welcome page$")
	public void redirect_to_home_page() throws Throwable {
		String actual = driver.findElement(By.xpath("//h3[contains(text(), 'Hi,')]")).getText();
		String expected = "Hi, Lakshmikanth N";
		Assert.assertEquals(expected, actual);
		driver.quit();
	}

}
