package com.saucelab.qa.base;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.interactions.Interaction;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseTest {

	static Properties prop;// For implementing Properties(in config file)
	public static AppiumDriver driver;
	private static AppiumDriverLocalService server;// Server instance of appium server

	public BaseTest() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);//For initializing each of the pages
	}
	
	@BeforeSuite
	public void setUp() throws IOException {

		server = getAppiumServerDefault(); // built the Appuim local server info

		if (checkIfAppiumServerIsRunning(4723)) {
			server.start();// start the server
			server.clearOutPutStreams();// remove server related logs
			System.out.println("Appium Server is started");
		} else {

			System.out.println("Appium Server is already running");

		}

		prop = new Properties();
		/* For reading Properties */
		// return type of getResAsStream is Input stream
		InputStream ip = getClass().getClassLoader().getResourceAsStream("config.properties");
		prop.load(ip);
		DesiredCapabilities caps = new DesiredCapabilities();

		/* Setting up desired Capabilities */
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_4");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("androidAutomationName"));
		caps.setCapability(MobileCapabilityType.APP, prop.getProperty("androidAppLocation"));
		caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		caps.setCapability("appPackage", prop.get("androidAppPackage"));// give app package name
		caps.setCapability("appActivity", prop.get("androidAppActivity"));// give activity name

		URL url = new URL(prop.getProperty("appiumURL")); // Info where my appium server is running

		/* Declaring Android Driver */

		driver = new AndroidDriver(url, caps);

	}

	boolean checkIfAppiumServerIsRunning(int port) {
		boolean flag = true;

		ServerSocket socket;

		try {
			socket = new ServerSocket(port);
			socket.close();
		} catch (IOException e) {
			flag = false;
		} finally {
			socket = null;
		}
		return flag;
	}

	// For Windows
	public AppiumDriverLocalService getAppiumServerDefault() {
		return AppiumDriverLocalService.buildDefaultService();
	}

	public void waitForVisibility(MobileElement e) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(e));

	}

	public void clear(MobileElement e) {

		waitForVisibility(e);//wait for the element to be visible
		e.clear();
	}
	
	public void sendKeys(MobileElement e, String txt) {
		waitForVisibility(e);
		e.clear();
	}

	public void click(MobileElement e) {
		waitForVisibility(e);
		e.click();
	}

	public String getAttribute(MobileElement e, String attribute) {
		waitForVisibility(e);
		return e.getAttribute(attribute);
	}

	public String getText(MobileElement e) {
		return getAttribute(e,"text");
	}

	public MobileElement scrollToElement() {
		return (MobileElement) ((FindsByAndroidUIAutomator) driver)
				.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
						+ ".scrollable(true)).scrollIntoView(" + "new UiSelector().description(\"CHECKOUT\"));");
	}
	
	/*public MobileElement scrollToElementFinish() {
		return (MobileElement) ((FindsByAndroidUIAutomator) driver)
				.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
						+ ".scrollable(true)).scrollIntoView(" + "new UiSelector().description(\"FINISH\"));");
	}
	*/
	
	
	
	public void closeApp() {
		
		((InteractsWithApps) driver).closeApp();
	
	}
	
	public void launchApp() {
		((InteractsWithApps) driver).launchApp();
	}

	@AfterSuite
	public void tearDown() {

	}

}
