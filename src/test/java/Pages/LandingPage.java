package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css= "li#menu-item-146 a")
	WebElement loginButton;
	
	public void goTo() {
		driver.get("https://quickconnect.biz/");
	}
	
	public void goToLoginPage() {
		loginButton.click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(loginButton.getText());
	}
	
}
