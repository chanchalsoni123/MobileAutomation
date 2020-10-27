package Petzey.AutomationTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Petzey.pageObjects.HomePage;
import Petzey.pageObjects.signUPage;
import Petzey.utilities.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SignUPPageNavigation_Test extends BaseClass {

	static Logger log = LogManager.getLogger(SignUPPageNavigation_Test.class);
	@Test
	public void SignUPNavigation() throws IOException, InterruptedException {
		service =startServer();
		AndroidDriver<AndroidElement> driver = capabilities("PetzeyApp");
		log.info("App name sent to the Base class");
		HomePage homePage = new HomePage(driver);
		homePage.goToSignUPage();
		log.info("User redirected to the login page");
		signUPage signup = new signUPage(driver);
		// Assertion to validate signup page
		signup.validate_signUpPage();
		log.info("Signup page load validated");
		service.stop();
	}

}
