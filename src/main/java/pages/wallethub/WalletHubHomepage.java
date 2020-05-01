package pages.wallethub;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WalletHubHomepage {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//span[text()=\"Login\"]")
	private WebElement loginOption;
	
	@FindBy(css = "input[placeholder=\"Email Address\"]")
	private WebElement userNameTextBox;
	
	@FindBy(css = "input[placeholder=\"Password\"]")
	private WebElement passwordTextBox;
	
	@FindBy(xpath = "//*[@type=\"button\"]//*[text()=\"Login\"]")
	private WebElement submitLogin;
	
	@FindBy(xpath = "//*[@class=\"rating-box-wrapper\"]//*[@width=\"38\"][4]")
	private WebElement fourthStar;
	
	@FindBy(xpath = "//*[@class=\"rating-box-wrapper\"]//*[@width=\"38\"]//*[@stroke-miterlimit=\"10\"]")
	private List<WebElement> starsLitUpConfirmation;
	
	@FindBy(css = "div[class=\"brgm-button brgm-user brgm-list-box\"]")
	private WebElement profileAvatar;
	
	@FindBy(xpath = "//*[@class=\"brgm-list brgm-user-list\"]//a[contains(@href, \"/profile/\")]")
	private WebElement profileOption;
	
	public WalletHubHomepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void clickOnLoginOption() {
		this.loginOption.click();
	}
	
	public void enterUserName(String userName) {
		this.userNameTextBox.sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		this.passwordTextBox.sendKeys(password);
	}
	
	public void submitLogin() {
		this.submitLogin.click();
	}
	
	public WebElement fourthStarElement() {
		return this.fourthStar;
	}
	
	public void clickOnFourthStar() {
		this.fourthStar.click();
	}
	
	public int getLitUpStarsCount() {
		return this.starsLitUpConfirmation.size();
	}
	
	public WebElement getProfileElement() {
		return this.profileAvatar;
	}
	
	public WebElement getProfileOptionElement() {
		return this.profileOption;
	}
	
	public void clickOnProfile() {
		this.profileOption.click();
	}
	

}
