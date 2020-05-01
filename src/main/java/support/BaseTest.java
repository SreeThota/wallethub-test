package support;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private static WebDriver driver = null;
	private static Reader reader = new Reader();

	
	@BeforeSuite(alwaysRun = true)
	public void initializeProperties() {
		Shared.facebookUrl = reader.getBaseUrl();
		Shared.fbUserName = reader.getFbUserName();
		Shared.fbPassword = reader.getFbPassword();
		Shared.walletHubPassword = reader.getWalletHubPassword();
		Shared.walletHubUrl = reader.getWalletHubUrl();
		Shared.walletHubUserName = reader.getWalletHubUserName();
	}
	
	@Parameters({ "browser"})
	@BeforeTest(alwaysRun = true)
	public void initializeBrowser(String browser) {
		switch (browser) {
		default:
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			break;
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Shared.driver = driver;
	}
	

	@AfterTest(alwaysRun = true)
	public void quitBrowser() {
		driver.quit();
		Shared.driver = null;
		reader = null;
	}

	@AfterSuite(alwaysRun = true)
	public void nullifyValues() {
		Shared.fbUserName = null;
		Shared.fbPassword = null;
		Shared.facebookUrl = null;
		Shared.walletHubPassword = null;
		Shared.walletHubUrl = null;
		Shared.walletHubUserName = null;
	}

}
