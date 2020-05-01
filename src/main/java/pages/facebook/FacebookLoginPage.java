package pages.facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPage {
	
	private WebDriver driver;
	
	@FindBy(css = "input#email")
	private WebElement fbUserNameElement;
	
	@FindBy(css = "input#pass")
	private WebElement fbUserPassword;
	
	@FindBy(css = "input[value=\"Log In\"]")
	private WebElement fbLoginButton;
	
	public FacebookLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getFbLoginPageTitle() {
		return this.driver.getTitle();
	}
	
	public void enterFbUserName(String username) {
		this.fbUserNameElement.sendKeys(username);
	}
	
	public void enterFbUserPassword(String password) {
		this.fbUserPassword.sendKeys(password);
	}
	
	public void clickOnFbLoginButton() {
		this.fbLoginButton.click();
	}
	
	

}
