package Petzey.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass {

	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	static Logger log = LogManager.getLogger(BaseClass.class);

	@BeforeSuite()
	public void start_server() throws IOException, InterruptedException {

		//service=startServer();
		// driver = capabilities("PetzeyApp");
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// PropertyConfigurator.configure(System.getProperty("user.dir")+ File.separator
		// + "Log4j.properties");

	}

	@AfterSuite
   public void mail() throws InterruptedException
	{
	    Thread.sleep(15000);
		SendMail.sendReport();
		service.stop();
	}

	public AppiumDriverLocalService startServer() {

		boolean flag = checkIfServerIsRunning(4723);
		if (!flag) {
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;
	}

	public static boolean checkIfServerIsRunning(int port) {
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}

		return isServerRunning;

	}

	public static void startEmulator() throws IOException, InterruptedException {
		log.info("Starting emulator...............");
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\startEmulator.bat");
		Thread.sleep(10000);

	}

	public static AndroidDriver<AndroidElement> capabilities(String AppName) throws IOException, InterruptedException {
		/**
		 * to get the current project directory use the following command
		 * System.getProperty("user.dir")
		 */
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\global.properties");
		log.info("Global.prorperties path loaded");
		Properties prop = new Properties();
		prop.load(fis);
		log.info("Global.prorperties file loaded successfully");
		File appDir = new File("src");
		File app = new File(appDir, (String) prop.get(AppName));
		log.info("apk file fetched from the properties file " + app);
		String device = (String) prop.get("device");
		log.info("Device name fetched form the properties file" + device);

		// to start emulator with batch file
		 if(device.contains("Emulator"))
		{
		startEmulator();
	     }

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		log.info("App capabilities set" + app.getAbsolutePath());

		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		log.info("App Platform capability set as Android");

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		log.info("Device name capabilities set = " + device);
		 cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		log.info("Platform version capabilities set as Version 9");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		log.info("Automation Name capability set as UiAutomator2");
		//cap.setCapability(MobileCapabilityType.UDID, "RZ8M235WTDK");
		log.info("UDID capability set as RZ8M235WTDK");
		cap.setCapability("appPackage", "us.petzey.apppetzey");
		log.info("App package capability set as us.petzey.apppetzey");
		cap.setCapability("appActivity", "us.petzey.apppetzey.MainActivity");
		log.info("App activity capability set as us.petzey.apppetzey.MainActivity");

		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		log.info("Capabilities and local apppium server set and sent to android driver");

		// driver.context("WEBVIEW_us.petzey.apppetzey");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		log.info("Implicit wait set to 20 seconds");
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
			System.out.println(contextName); // set context to WEBVIEW
		}
		log.info("Application context got printed");
		Thread.sleep(15000);
		return driver;

	}

	// to capture a screenshot
	public static void getScreenShot(String s) throws IOException {
		log.info("Screenshot method called");
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,
				new File(System.getProperty("user.dir") + "\\src\\main\\java\\Screenshots\\" + s + ".png"));
		log.info("Screenshot taken and saved under screenshots folder");
	}

}
