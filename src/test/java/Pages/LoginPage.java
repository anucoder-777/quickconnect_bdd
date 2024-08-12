package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// elements
	@FindBy(css= "input[name='user']")
	WebElement emailPhoneField;
	
	@FindBy(css= "input[name='password']")
	WebElement passwordField;
	
	@FindBy(css= "form button")
	WebElement loginButton;

	// Action
	public void fillLoginForm(String emailPhone, String password) {
		emailPhoneField.sendKeys(emailPhone);
		passwordField.sendKeys(password);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
}
