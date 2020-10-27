package Petzey.AutomationTest;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import Petzey.pageObjects.HomePage;
import Petzey.pageObjects.LoginPage;
import Petzey.utilities.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginTest extends BaseClass {

	static Logger log = LogManager.getLogger(LoginTest.class);

	@Test
	public void login() throws IOException, InterruptedException {
		service =startServer();
		AndroidDriver<AndroidElement> driver = capabilities("PetzeyApp");
		log.info("Application name sent to the base class");
		HomePage homePage = new HomePage(driver);
		homePage.gotoLoginPage();
		log.info("Redirected to the login page");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.fill_Email("automation21@example.com");
		log.info("Email Id provided");
		loginPage.fill_pwd("12345");
		log.info("Password provided");
		loginPage.logIn();
		log.info("Login action taken successfully");
		service.stop();
	}

}
