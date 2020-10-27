package Petzey.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Petzey.utilities.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddPhoto {

	Logger log = LogManager.getLogger(AddPhoto.class);
	
	public AddPhoto(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindBy (xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]/android.widget.Button")
	private WebElement addPhoto;
	
	@AndroidFindBy (xpath ="//*[@text='TAKE A PICTURE']")
	private WebElement takePhoto;
	
	
    @AndroidFindBy (xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]")	
	private WebElement allow;
    
	public void addPhoto()
	{
		addPhoto.click();
		log.debug("Add photo icon clicked");
	}
	
	public void TakePhoto()
	{
		takePhoto.click();
		log.debug("Take photo option clicked");
	}
	
	public void Allow()
	{
		allow.click();
		log.debug("Allow button clicked");
	}
}
