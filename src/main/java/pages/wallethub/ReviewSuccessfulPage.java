package pages.wallethub;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewSuccessfulPage {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//*[@class=\"rating-box-wrapper\"]//*[@width=\"22\"]//*[@stroke-miterlimit=\"10\"]")
	private List<WebElement> reviewdStars;
	
	@FindBy(xpath = "//*[@class=\"rvc-header\"]//*[text()=\"Your review has been posted.\"]")
	private WebElement reviewSuccessfulMessage;
	
	@FindBy(xpath = "//*[@class=\"rvc-body-middle\"]/p")
	private WebElement postedReview;
	
	
	public ReviewSuccessfulPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public int getStarRatingPosted() {
		return this.reviewdStars.size();
	}
	
	public boolean getReviewSuccessfulMessage() {
		return this.reviewSuccessfulMessage.isDisplayed();
	}
	
	public String getPostedReview() {
		return this.postedReview.getText();
	}
	
	
	

}
