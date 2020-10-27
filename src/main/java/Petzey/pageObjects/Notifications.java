package Petzey.pageObjects;


import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Petzey.utilities.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Notifications {
	
	Logger log = LogManager.getLogger(BaseClass.class);
	
	public Notifications(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@AndroidFindBy (xpath ="//*[@text='Clear all']")
	private WebElement clearNotification;

	
	public void notificationPage_Validation()
	{
		String expected= "Clear all";
		String actual = clearNotification.getText();
		log.debug("Clear all button text stored into the actual var");
		Assert.assertEquals(actual, expected);
	}
	
}
