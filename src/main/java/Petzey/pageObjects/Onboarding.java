package Petzey.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Onboarding {

	Logger log = LogManager.getLogger(Onboarding.class);

	public Onboarding(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.app.Dialog/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View[1]/android.widget.EditText")
	private WebElement petName;

	@AndroidFindBy(xpath = "//*[@text='NEXT STEP']")
	private WebElement nextStep;

	@AndroidFindBy(xpath = "//*[@text='Dog']")
	private WebElement petCategory;

	@AndroidFindBy(xpath = "//*[@text='Affenpinscher']")
	private WebElement petBreed;

	@AndroidFindBy(xpath = "//*[@text='Male']")
	private WebElement genderMale;

	@AndroidFindBy(xpath = "//*[@text='Female']")
	private WebElement genderFemale;

	@AndroidFindBy(xpath = "//*[@text='Yes']")
	private WebElement neuteredYes;

	@AndroidFindBy(xpath = "//*[@text='No']")
	private WebElement neuteredNo;

	@AndroidFindBy(xpath = "//*[@text='Yes']")
	private WebElement spayedYes;

	@AndroidFindBy(xpath = "//*[@text='No']")
	private WebElement spayedNo;

	@AndroidFindBy(xpath = "//*[@text='DONE']")
	private WebElement finalQtn;

	public void providePetName(String Name) {
		petName.click();
		log.debug("PetName text field clicked");
		petName.clear();
		log.debug("PetName text field clicked");
		petName.sendKeys(Name);

	}

	public void NextStep() {
		nextStep.click();
		log.debug("Next Step button clicked");

	}

	public void onboard_navigation() {
		String actual = "NEXT STEP";
		String expected = nextStep.getText();
		Assert.assertEquals(actual, expected);

	}

	public void petCategory() {
		petCategory.click();
		log.debug("Pet Category selected");

	}

	public void Breed() throws InterruptedException {
		Thread.sleep(500);
		petBreed.click();
		log.debug("Pet breed selected");

	}

	public void genderMale() {
		genderMale.click();
		log.debug("Gender is selected as Male");
	}

	public void genderFemale() {
		genderFemale.click();
		log.debug("Gender is selected as Female");

	}

	public void neuteredYES() {
		neuteredYes.click();
		log.debug("Neutered options selected as yes");
	}

	public void neuteredNO() {
		neuteredNo.click();
		log.debug("Neutered options selected as No");
	}

	public void spayedYES() {
		spayedYes.click();
		log.debug("Spayed options selected as yes");
	}

	public void spayedNO() {
		spayedNo.click();
		log.debug("Spayed options selected as No");
	}

	public void finalOnboard() {
		finalQtn.click();
		log.debug("Final onboard- Done button clicked");
	}

}
