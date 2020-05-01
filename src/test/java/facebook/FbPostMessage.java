package facebook;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.facebook.FacebookHomepage;
import pages.facebook.FacebookLoginPage;
import support.BaseTest;
import support.Shared;

public class FbPostMessage extends BaseTest {

	@Test(priority = 1)
	public void navigateToFbLoginPage() {
		Shared.driver.get(Shared.facebookUrl);
		WebDriverWait wait = new WebDriverWait(Shared.driver, 30);
		wait.until(ExpectedConditions.titleIs("Facebook – log in or sign up"));
	}

	@Test(dependsOnMethods = {"navigateToFbLoginPage"})
	public void LoginFacebook() {
		FacebookLoginPage page = new FacebookLoginPage(Shared.driver);
		assertEquals(page.getFbLoginPageTitle(), "Facebook – log in or sign up");
		page.enterFbUserName(Shared.fbUserName);
		page.enterFbUserPassword(Shared.fbPassword);
		page.clickOnFbLoginButton();
	}

	@Test(dependsOnMethods = {"LoginFacebook"})
	public void postMessage() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(Shared.driver, 30);
		wait.until(ExpectedConditions.titleContains("Facebook"));
		FacebookHomepage page = new FacebookHomepage(Shared.driver);
		page.clickOnCreatePostBox();
		page.enterMesageToPost("Hello World");
		wait.until(ExpectedConditions.elementToBeClickable(page.postButtonElement()));
		page.clickOnMessagePostButton();
	}
	
}
