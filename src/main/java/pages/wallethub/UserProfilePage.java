package pages.wallethub;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserProfilePage {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//*[@class=\"rating-box-wrapper\"]//*[@width=\"16\"]//*[@stroke-miterlimit=\"10\"]")
	private List<WebElement> starRatingInProfile;
	
	public UserProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public int getRatedStarsInProfilePage() {
		return this.starRatingInProfile.size();
	}

}
