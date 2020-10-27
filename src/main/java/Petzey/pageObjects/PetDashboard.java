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

public class PetDashboard {

	static Logger log = LogManager.getLogger(PetDashboard.class);

	public PetDashboard(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[3]/android.view.View/android.widget.Button")
	private WebElement bellNotification;

	public void NavigateToNotification() {
		bellNotification.click();
		log.debug("Bell button clicked");
	}

}
