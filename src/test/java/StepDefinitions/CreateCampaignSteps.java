package StepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;

import Pages.CreateCampaignForm;
import Pages.DashboardPage;
import Pages.LandingPage;
import Pages.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.chromium.ChromiumDriverCommandExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateCampaignSteps {
	
	WebDriver driver = null;
	LandingPage landingPage = null;
	LoginPage loginPage = null;
	DashboardPage dashboardPage = null;
	CreateCampaignForm createCampaignForm = null;

	@Given("the anonymous user is on the Landing page")
	public void the_anonymous_user_is_on_the_Landing_page() {
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		landingPage = new LandingPage(driver);
		landingPage.goTo();
	}

	@And("^that anuonymous goes to login page and fill the login form with (.*) and (.*)$")
	public void that_anuonymous_goes_to_login_page_and_fill_the_login_form(String email, String password) {
		landingPage.goToLoginPage();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String>it = windows.iterator();
		it.next();

		String childId = it.next();
		
		driver.switchTo().window(childId);
		
		loginPage = new LoginPage(driver);
		
		loginPage.fillLoginForm(email, password);
	}
	
	@When("the anonymous user logs in the system")
	public void the_user_logs_in_the_system() {
		loginPage.clickLogin();
	}

	@And("the user goes to Create Campaign")
	public void the_user_goes_to_create_campaign() {
		dashboardPage = new DashboardPage(driver);
		dashboardPage.clickCreateCampaignButton();
	}

	@And("the user fills the form")
	public void the_user_fills_the_form(){
		Faker faker = new Faker();
		
		String title = faker.name().title();
		String category = faker.cat().breed();
		String message = faker.company().catchPhrase();
		//String phoneNumber = "98" + faker.numerify("########");

		String phoneNumber = "9867861096";
		createCampaignForm = new CreateCampaignForm(driver);
		createCampaignForm.fillCampaignForm(title, category, message, phoneNumber);
	}

	@And("the user clicks Create button")
	public void the_user_clicks_create_button() throws InterruptedException {
		Thread.sleep(5000);
		createCampaignForm.clickDoneButton();
	}

	@Then("the campaign is created successfully")
	public void the_campaign_is_created_successfully() {
		String successMessage = createCampaignForm.verifySuccessMessage();
		assertEquals("Campaign Scheduled Successfully!", successMessage);
	}
}
