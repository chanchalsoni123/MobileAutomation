package Petzey.pageObjects;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	
	static Logger log = LogManager.getLogger(LoginPage.class);
	public LoginPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  
		
	}
	
	@AndroidFindBy (xpath ="//*[@text='Join now']")
	private WebElement joinNowLink;

	@AndroidFindBy (xpath="//*[@text='Vet Professional Sign in']")
	private WebElement vetSignIn;
	 
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.EditText")
	//@AndroidFindBy (className="android.widget.EditText")
    private WebElement email;
	
	//@AndroidFindBy (xpath="//*[@id=\"petOwnerPassword\"]/input")
	@AndroidFindBy (xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.EditText")
	private WebElement password;
	
	@AndroidFindBy(xpath="//*[@text='LOGIN']")
	private WebElement login;
	
	public void joinNow()
	{
		joinNowLink.click();
		log.debug("Join now link clicked");
	}
	
	public void navigateToVetSignInPage()
	{
		vetSignIn.click();
		log.info("Vet professional signin link clicked");
	}
	
	public void fill_Email(String userID)
	{
	  email.click();
      log.debug("Email field clicked");
      email.clear();
      log.debug("Email field cleared");
      email.sendKeys(userID);
      log.debug("Email ID sent to the email field");
	}
	public void fill_pwd(String pwd)
	{
		
		
		password.click();
		log.debug("password field clicked");
		password.clear();
		log.debug("password field cleared");
		password.sendKeys(pwd);
		log.debug("password sent to the password field");
	}
	
	public void logIn()
	{
		try{
			login.click();
			log.debug("Login link clickded");
		}
		catch(Exception ex) {
			log.error("Login link clicked failed due to:" +ex);
		}
		
	}
	
}
