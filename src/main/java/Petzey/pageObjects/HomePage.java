package Petzey.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

	Logger log = LogManager.getLogger(HomePage.class);

	public HomePage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath = "//*[@text='I already have an account']")
	// @AndroidFindBy(xpath=
	// "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View")
	private WebElement loginLink;

	@AndroidFindBy(xpath = "//*[@text='JOIN FOR FREE']")
	private WebElement signUpLink;

	public void goToSignUPage() throws InterruptedException {
		Thread.sleep(1000);
		signUpLink.click();
		log.debug("Signup link clicked");
	}

	public void gotoLoginPage() {
		loginLink.click();
		log.debug("Login link clicked");
	}

}
