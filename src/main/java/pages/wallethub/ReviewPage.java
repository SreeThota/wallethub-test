package pages.wallethub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewPage {
	
	private WebDriver driver;
	
	@FindBy(css = "div[class=\"dropdown second\"]")
	private WebElement policyDropdown;
	
	@FindBy(xpath = "//*[contains(@class,\"dropdown-item\") and text()=\"Health Insurance\"]")
	private WebElement healthInsuranceOption;
	
	@FindBy(css = "textarea[placeholder=\"Write your review...\"]")
	private WebElement reviewTextBox;
	
	@FindBy(xpath = "//*[text()=\"Submit\"]")
	private WebElement submitButton;
	
	public ReviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void clickOnPolicyDropdown() {
		this.policyDropdown.click();
	}
	
	public WebElement getOptionElementToSelect() {
		return this.healthInsuranceOption;
	}
	
	public void clickOnHealthInsuranceOption() {
		this.healthInsuranceOption.click();
	}
	
	public void enterReviewRemarks(String review) {
		this.reviewTextBox.sendKeys(review);
	}
	
	public void clickOnReviewSubmitButton() {
		this.submitButton.click();
	}

}
