package pages.facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookHomepage {

	private WebDriver driver;
	
	@FindBy(xpath = "//*[contains(@placeholder, \"Write something here...\")]")
	private WebElement postMessageSpace;
	
	@FindBy(xpath = "(//*[@type=\"submit\"]//*[text()=\"Post\"])[1]")
	private WebElement postButton;
	
	@FindBy(xpath = "//*[contains(@aria-label, \"Write something here...\")]")
	private WebElement spaceToEnterMessage;
	
	public FacebookHomepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void clickOnCreatePostBox() {
		this.postMessageSpace.click();
	}
	
	public void enterMesageToPost(String message) {
		this.spaceToEnterMessage.sendKeys(message);
	}
	
	public void clickOnMessagePostButton() {
		this.postButton.click();
	}
	
	public WebElement postButtonElement() {
		return this.postButton;
	}
	
	public WebElement postMessageBoxElement() {
		return this.postMessageSpace;
	}
}
