package Petzey.AutomationTest;

import java.io.IOException;
import static io.appium.java_client.touch.offset.PointOption.point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import Petzey.pageObjects.AddPhoto;
import Petzey.pageObjects.Coachmark;
import Petzey.pageObjects.HomePage;
import Petzey.pageObjects.Onboarding;
import Petzey.pageObjects.signUPage;
import Petzey.utilities.BaseClass;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Onboarding_Pet_Test extends BaseClass {

	static Logger log = LogManager.getLogger(Onboarding_Pet_Test.class);


	@Test
	public void petOnboarding() throws IOException, InterruptedException {
		service =startServer();
		AndroidDriver<AndroidElement> driver = capabilities("PetzeyApp");
		log.info("App name sent to the Base Class");
		HomePage homePage = new HomePage(driver);
		homePage.goToSignUPage();
		log.info("Redirected to the sign up page");
		Thread.sleep(2000);
		signUPage signup = new signUPage(driver);
		signup.validate_signUpPage();
		log.error("Validate that the sign up page is loaded");
		signup.provide_email("automation101@example.com");
		log.info("Email is provided");
		signup.provide_password("12345");
		log.info("Password is provided");
		signup.TermsNCondition();
		log.info("Terms and condition selected");
		signup.signUp();
		log.info("Signup action taken and user successfully signed up");
		Thread.sleep(8000);
		Onboarding onBrd = new Onboarding(driver);
		onBrd.onboard_navigation();
		log.info("User navigated to PetOnboarding first page page");
		onBrd.providePetName("Gogo");
		log.info("The pet name is provided");
		onBrd.NextStep();
		log.info("User navigated to the pet category page");
		onBrd.petCategory();
		log.info("Pet category provided");
		onBrd.Breed();
		log.info("The Pet's breed provided");
		onBrd.genderMale();
		log.info("The pet's gender provided");
		onBrd.neuteredYES();
		log.info("For the male pet neutered information provided");
		onBrd.finalOnboard();
		log.info("The pet onboarded successfully");
		Coachmark cm = new Coachmark(driver);
		Thread.sleep(2000);
		cm.AddPaymentLater();
		log.info("Add Payment latet coachmark selected");
		Thread.sleep(2000);
		cm.AddPhotoLater();
        log.info("Add photo later coachmark selected");
		AddPhoto photo = new AddPhoto(driver);
		photo.addPhoto();
		log.info("Redirected to the Add Photo pop up");
		photo.TakePhoto();
		log.info("Selected camera option to click photo");
		photo.Allow();
		log.info("Allowed the camera action");
		Thread.sleep(2000);// to capture photo from camera
		driver.pressKey(new KeyEvent(AndroidKey.CAMERA));
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(point(542, 1896)).perform();
		log.info("Picture taken successfully from camera");
		Thread.sleep(2000);
        service.stop();
	}
}
