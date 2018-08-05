import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;

public class AppiumLaunchTest {

	static String appiumURL = "http://127.0.0.1:4723/wd/hub";
	static AndroidDriver<?> driver;

	public static void main(String[] args) {

		try {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("platformVersion", "6.0.1");
			capabilities.setCapability("deviceName", "Nexus");

			// app will be launched directly if app location is not provided.

			// capabilities.setCapability("app",
			// "//testBuilds//MultiAppForSmokeTestAutomation.apk");

			capabilities.setCapability("appPackage", "com.quickmobile.app4567");
			capabilities.setCapability("appActivity", "com.quickmobile.conference.ApplicationInitialLoadActivity");
			// capabilities.setCapability("automationName", "UiAutomator2");
			capabilities.setCapability("autoLaunch", false);
			capabilities.setCapability("newCommandTimeout", 900);
			// This capability ensure that on close and re-launch, the app does
			// not undergo fast reset.
			capabilities.setCapability("noReset", true);

			// reset app on mobile
			// TODO : Setting this capability will reset the app data all
			// the time after calling closeApp method.Relaunch the app will
			// always start form Multi Event Disclaimer page and would
			// eventually break the remaining tests.
			// capabilities.setCapability("fullReset", true);

			// not reset
			capabilities.setCapability("noReset", true);

			driver = new AndroidDriver<WebElement>(new URL(appiumURL), capabilities);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.launchApp();
		} catch (MalformedURLException e) {
			System.err.println("Failed to launch AndroidDriver: on appium server " + appiumURL);
		}

	}

}
