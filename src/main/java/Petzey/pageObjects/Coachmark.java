package Petzey.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Coachmark {

	Logger log = LogManager.getLogger(Coachmark.class);

	public Coachmark(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath = "//*[@text='I will do it later']")
	private WebElement addLater;

	@AndroidFindBy(xpath = "//*[@text='ADD PAYMENT METHOD']")
	private WebElement addPaymentMethod;

	@AndroidFindBy(xpath = "//*[@text='I will add it later']")
	private WebElement addPhotoLater;

	@AndroidFindBy(xpath = "//*[@text='ADD PHOTO']")
	private WebElement addPhoto;

	public void AddPaymentLater() {
		addLater.click();
		log.debug("Add Payment Later option clicked");
	}

	public void AddPhotoLater() {
		addPhotoLater.click();
		log.debug("Add Photo Later option clicked");
	}

}
