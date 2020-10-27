package Petzey.pageObjects;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class signUPage {

	static Logger log = LogManager.getLogger(signUPage.class);

	public signUPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@AndroidFindBy(className = "android.widget.EditText")
	//@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText")

	// @AndroidFindBy (xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.EditText")
	private WebElement email_field;
    
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[5]/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.EditText")

	private WebElement password_field;
	//@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View[3]/android.widget.CheckBox/android.widget.Button")
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[5]/android.view.View[3]/android.widget.CheckBox/android.widget.Button")
	private WebElement termsNCnd_check;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[5]/android.view.View[4]/android.widget.Button")
	private WebElement signUp_action;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[5]/android.widget.Button")
	private WebElement facebook_signup;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[6]/android.widget.Button")
	private WebElement google_signup;

	@AndroidFindBy(xpath = "/.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View")
	private WebElement login_Page;

	// to fill email field

	public void provide_email(String email) {
		email_field.click();
		log.debug("Email field clicked");
		email_field.clear();
		log.debug("Email field cleared");
		email_field.sendKeys(email);

	}

	// to fill password
	public void provide_password(String pwd) {
		password_field.click();
		log.debug("Password field clicked");
		password_field.clear();
		log.debug("Password field provided");
		password_field.sendKeys(pwd);

	}

	// to perform signup action
	public void signUp() {
		signUp_action.click();
		log.debug("Signup button clicked");
	}

	public void validate_signUpPage() {

		String expected = "SIGN UP";
		String actual = signUp_action.getText();
		log.debug("Sign up button text stored into the actual var");
		Assert.assertEquals(actual, expected);
	}

	public void TermsNCondition() {
		termsNCnd_check.click();
		log.debug("Terms and services checkbox clicked");
	}

	// to navigate to facebook login page
	public void facebook_loginPage() {
		facebook_signup.click();
		log.debug("Facebook signup button clicked");
	}

	// to navigate to google login page
	public void google_loginPage() {
		google_signup.click();
		log.debug("Google signup button clicked");
	}

	// navigate to login page
	public void loginPage() {
		login_Page.click();
		log.debug("Login link clicked");

	}

}
