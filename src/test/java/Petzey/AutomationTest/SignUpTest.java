package Petzey.AutomationTest;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import Petzey.pageObjects.HomePage;
import Petzey.pageObjects.signUPage;
import Petzey.utilities.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SignUpTest extends BaseClass {
	
	static Logger log = LogManager.getLogger(SignUpTest.class);
	@Test
	public void SignUP() throws IOException, InterruptedException
	{   service =startServer();
		AndroidDriver<AndroidElement> driver = capabilities("PetzeyApp");
		log.info("App name sent to the Base class");
		HomePage homePage = new HomePage(driver);
		homePage.goToSignUPage();
		log.info("User redirected to the signup page");
		signUPage signup = new signUPage(driver);
		signup.provide_email("automation16@example.com");
		log.info("User ID provided");
		Thread.sleep(10000);
		signup.provide_password("12345");
		log.info("Password Provided");
		signup.TermsNCondition();
		log.info("Terms and condition selected");
		signup.signUp();	
		log.info("Signup action taken and redirected to the dashboard");
        service.stop();
	}
	
}
