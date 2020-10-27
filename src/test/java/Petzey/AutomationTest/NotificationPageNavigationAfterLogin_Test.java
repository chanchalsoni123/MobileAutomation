package Petzey.AutomationTest;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import Petzey.pageObjects.HomePage;
import Petzey.pageObjects.LoginPage;
import Petzey.pageObjects.Notifications;
import Petzey.pageObjects.PetDashboard;
import Petzey.utilities.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class NotificationPageNavigationAfterLogin_Test extends BaseClass {

	static Logger log = LogManager.getLogger(NotificationPageNavigationAfterLogin_Test.class);

	@Test
	public void notificationNavigation() throws IOException, InterruptedException {
		service =startServer();
		AndroidDriver<AndroidElement> driver = capabilities("PetzeyApp");
		log.info("App name sent to the base class");
		HomePage homePage = new HomePage(driver);
		homePage.gotoLoginPage();
        log.info("Redirected to the login page");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.fill_Email("automation9@example.com");
        log.info("Email ID provided");
		loginPage.fill_pwd("12345");
		log.info("Password provided");
		loginPage.logIn();
		log.info("Login action performed successfully and user landed to the Dashboard");
		Thread.sleep(10000);
		PetDashboard pdash = new PetDashboard(driver);
		pdash.NavigateToNotification();
		log.info("User redirected to the notification page");
		Notifications ntf = new Notifications(driver);
		ntf.notificationPage_Validation();
		log.info("Notification page load is validated");
        service.stop();
	}

}
