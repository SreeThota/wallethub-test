package wallethub;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.wallethub.ReviewPage;
import pages.wallethub.ReviewSuccessfulPage;
import pages.wallethub.UserProfilePage;
import pages.wallethub.WalletHubHomepage;
import support.BaseTest;
import support.Generics;
import support.Shared;

public class WalletHubPostReview extends BaseTest {
	
	WalletHubHomepage page;
	WebDriverWait wait;
	Actions actions;
	ReviewPage reviewPage;
	ReviewSuccessfulPage successPage;
	UserProfilePage userProfile;
	
	@Test(priority = 1)
	public void navigateToWalletHubHomePage() {
		Shared.driver.get(Shared.walletHubUrl);
		wait = new WebDriverWait(Shared.driver, 30);
		wait.until(ExpectedConditions.titleContains("Test Insurance Company Reviews"));
	}
	
	@Test(dependsOnMethods = {"navigateToWalletHubHomePage"})
	public void loginToWalletHub() {
		page = new WalletHubHomepage(Shared.driver);
		page.clickOnLoginOption();
		wait = new WebDriverWait(Shared.driver, 30);
		wait.until(ExpectedConditions.titleIs("Login"));
		page.enterUserName(Shared.walletHubUserName);
		page.enterPassword(Shared.walletHubPassword);
		page.clickOnLoginOption();
		wait.until(ExpectedConditions.titleContains("Test Insurance Company Reviews"));
	}
	
	@Test(dependsOnMethods = {"loginToWalletHub"})
	public void selectingStarRating() {
		page = new WalletHubHomepage(Shared.driver);
		actions = new Actions(Shared.driver);
		actions.moveToElement(page.fourthStarElement()).perform();;
		assertEquals(page.getLitUpStarsCount(), 4);
		page.clickOnFourthStar();
	}
	
	@Test(dependsOnMethods = {"selectingStarRating"})
	public void fillAndSubmitYourReview() {
		page = new WalletHubHomepage(Shared.driver);
		assertEquals(page.getLitUpStarsCount(), (4 * 2));
		reviewPage = new ReviewPage(Shared.driver);
		reviewPage.clickOnPolicyDropdown();
		wait = new WebDriverWait(Shared.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(reviewPage.getOptionElementToSelect()));
		reviewPage.clickOnHealthInsuranceOption();
		int reviewCommentLength = Generics.generateRandomNumberBetweenMinAndMax(200, 300);
		Shared.reviewComment = Generics.randomString("Aa1", reviewCommentLength);
		reviewPage.enterReviewRemarks(Shared.reviewComment);
		reviewPage.clickOnReviewSubmitButton();
	}
	
	@Test(dependsOnMethods = {"fillAndSubmitYourReview"})
	public void reviewConfirmationPostSuccessful() {
		successPage = new ReviewSuccessfulPage(Shared.driver);
		assertTrue(successPage.getReviewSuccessfulMessage());
		assertEquals(successPage.getStarRatingPosted(), 4);
		assertEquals(successPage.getPostedReview(), Shared.reviewComment);
	}
	
	@Test(dependsOnMethods = {"reviewConfirmationPostSuccessful"})
	public void goToProfileConfirmReviewFeed() {
		actions = new Actions(Shared.driver);
		userProfile = new UserProfilePage(Shared.driver);
		page = new WalletHubHomepage(Shared.driver);
		wait = new WebDriverWait(Shared.driver, 30);
		actions.moveToElement(page.getProfileElement()).perform();
		wait.until(ExpectedConditions.elementToBeClickable(page.getProfileOptionElement()));
		page.clickOnProfile();
		wait.until(ExpectedConditions.titleContains("| WalletHub"));
		assertEquals(userProfile.getRatedStarsInProfilePage(), 4);
	}

}
