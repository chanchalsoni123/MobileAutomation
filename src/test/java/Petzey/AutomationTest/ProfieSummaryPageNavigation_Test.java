package Petzey.AutomationTest;

import static io.appium.java_client.touch.offset.PointOption.point;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import Petzey.pageObjects.HomePage;
import Petzey.pageObjects.LoginPage;
import Petzey.utilities.BaseClass;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ProfieSummaryPageNavigation_Test extends BaseClass {
	
	static Logger log = LogManager.getLogger(NotificationPageNavigationAfterLogin_Test.class);
	@Test
	public void profileSummaryNavigation() throws IOException, InterruptedException {

		service =startServer();
		AndroidDriver<AndroidElement> driver = capabilities("PetzeyApp");
		log.info("App name sent to the Base class");
		HomePage homePage = new HomePage(driver);
		homePage.gotoLoginPage();
        log.info("User redirected to the Login page");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.fill_Email("p@p.com");
		log.info("Email ID provided");
		loginPage.fill_pwd("p");
		log.info("Password provided");
		loginPage.logIn();
		log.info("Login action taken and user redirected to the login page");
		Thread.sleep(10000);
         
		TouchAction touchAction1 = new TouchAction(driver);
		touchAction1.tap(point(877, 1952)).perform();
		log.info("User redirected to the profile summary page");
		service.stop();
	}

}
