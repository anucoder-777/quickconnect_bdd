package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateCampaignForm {
	
	WebDriver driver;

	public CreateCampaignForm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// elements using Page factory
	@FindBy(css= "input[name='campaign_name']")
	WebElement campaignNameField;
	
	@FindBy(css= "div.css-hlgwow")
	WebElement selectCategoryDropdown;

	@FindBy(css= "div.css-d7l1ni-option")
	WebElement categoryField;
	
	@FindBy(css= "div.input-item input[type='checkbox']")
	WebElement checkbox;
	
	@FindBy(xpath= "//button[contains(text(), 'Next Step')]")
	WebElement nextStepButton;

	// elements by POM
	/*
	 * driver.findElement(By.cssSelector("input[name='campaign_name']")).sendKeys("Testing Oneeeeeeee");
		driver.findElement(By.cssSelector("div.css-hlgwow")).click();
		driver.findElement(By.cssSelector("div.css-hlgwow input")).sendKeys("Cat008" + Keys.ENTER);
		driver.findElement(By.cssSelector("div.input-item input[type='checkbox']")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'Next Step')]")).click();
		driver.findElement(By.cssSelector("textarea[placeholder='Type text here...']")).sendKeys("Testing Message");
		driver.findElement(By.xpath("//button[contains(text(), 'Next Step')]")).click();
		driver.findElement(By.xpath("//p[contains(text(), 'Enter Numbers Manually')]")).click();
		driver.findElement(By.cssSelector("input[placeholder=\"Enter mobile number and press enter\"]")).sendKeys("9876543212" + Keys.ENTER);
		driver.findElement(By.xpath("//button[contains(text(), 'Next Step')]")).click();
		driver.findElement(By.cssSelector("label[for='schedule']")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'Next Step')]")).click();
	 * */
	
	@FindBy(css= "textarea[placeholder='Type text here...']")
	WebElement messageTextArea;

	@FindBy(xpath= "//p[contains(text(), 'Enter Numbers Manually')]")
	WebElement enterNumberBox;
	
	@FindBy(css= "input[placeholder='Enter mobile number and press enter']")
	WebElement phoneField;
	
	@FindBy(css= "label[for='schedule']")
	WebElement scheduleButton;
	
	@FindBy(xpath= "//button[contains(text(), 'Done')]")
	WebElement doneButton;
	
	@FindBy(css= "div.common-container h1")
	WebElement successMessage;

	// Actions
	public void fillCampaignForm(String title, String category, String message, String phoneNumber) {
		campaignNameField.sendKeys(title);
		selectCategoryDropdown.click();
		categoryField.sendKeys(category + Keys.ENTER);
		checkbox.click();
		nextStepButton.click();
		messageTextArea.sendKeys(message);
		nextStepButton.click();
		enterNumberBox.click();
		phoneField.click();
		phoneField.sendKeys(phoneNumber + Keys.ENTER);
		nextStepButton.click();
		scheduleButton.click();
		nextStepButton.click();
	}
	
	public void clickDoneButton() {
		doneButton.click();
	}
	
	public String verifySuccessMessage() {
		return successMessage.getText();
	}
	
}
