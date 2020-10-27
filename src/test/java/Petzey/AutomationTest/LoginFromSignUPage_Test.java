package Petzey.AutomationTest;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import Petzey.pageObjects.HomePage;
import Petzey.pageObjects.LoginPage;
import Petzey.pageObjects.signUPage;
import Petzey.utilities.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginFromSignUPage_Test extends BaseClass {
	
	static Logger log = LogManager.getLogger(LoginFromSignUPage_Test.class);
	
	@Test (priority=2)
	public void LoginFromSignUP() throws IOException, InterruptedException
	{   service =startServer();
		AndroidDriver<AndroidElement> driver = capabilities("PetzeyApp");
		log.info("Application name sent to the base class");
		HomePage homePage = new HomePage(driver);
		homePage.goToSignUPage();
		log.info("Redirected to the signup page");
		signUPage signup = new signUPage(driver);
	    signup.loginPage();
	    log.info("Redirected to the login page");
	    LoginPage loginPage = new LoginPage(driver);
	    loginPage.fill_Email("p@p.com");
	    log.info("email provided");
	    Thread.sleep(2000);
	    loginPage.fill_pwd("p");
	    log.info("Password Provided");
	    loginPage.logIn();
	    log.info("Login action executed successfully");
		service.stop();
	}
}
