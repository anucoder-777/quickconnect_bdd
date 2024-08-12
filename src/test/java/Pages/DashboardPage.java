package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Elements
	@FindBy(xpath= "//div[contains(text(), 'Create Campaign')]")
	WebElement createCampaignButton;

	@FindBy(xpath= "//button[contains(text(), 'Create Campaign')]")
	WebElement createCampaignButtonForFirstTime;

	// Actions
	public void clickCreateCampaignButton() {
		// createCampaignButtonForFirstTime.click();
		createCampaignButton.click();
	}
}
