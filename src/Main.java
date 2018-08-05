import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
	public static void main(String[] args) throws Exception {
		// // SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
		// // SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
		// // Date date = parseFormat.parse("00:01 AM");
		// // System.out.println(parseFormat.format(date) + " = " +
		// // displayFormat.format(date));
		//
		// System.out.println("\u2713");
		// String CHECK_MARK = "\u2713";
		// System.out.println(CHECK_MARK);
		//
		// Process process = Runtime.getRuntime()
		// .exec("adb shell dumpsys window windows | grep -E
		// 'mCurrentFocus|mFocusedApp'");
		// Thread.sleep(1000);
		// process.waitFor();
		//
		// BufferedReader r = new BufferedReader(new
		// InputStreamReader(process.getInputStream()));
		//
		// String xcodeversion = r.readLine();
		//
		// System.out.println(xcodeversion);
		//
		// String pk1 = xcodeversion.substring(0, xcodeversion.indexOf('/'));
		//
		// System.out.println(pk1);
		//
		// String packageName = pk1.substring(pk1.indexOf("com"));
		// System.out.println(packageName);

		System.out.println(getActivityOfCurrentScreen());

		try {

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE, MMMM d, YYYY");
			LocalDate localDate = LocalDate.now();
			System.out.println(dtf.format(localDate));
			System.out.println("Thursday, July 27, 2017 3:43 AM");

			String eventStartDate = "Thu 6 Jul, 2017";

			DateFormat srcDf = new SimpleDateFormat("EEE d MMM, yyyy");

			Date date = srcDf.parse(eventStartDate);

			DateFormat destDf = new SimpleDateFormat("dd/MM/yyyy");

			eventStartDate = destDf.format(date);

			System.out.println("Converted date is : " + eventStartDate);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void clickOnElemnt() {

	}

	public void sendKeyToField() {

	}

	public static String getActivityOfCurrentScreen() {
		try {
			Process process = Runtime.getRuntime()
					.exec("adb shell dumpsys window windows | grep -E 'mCurrentFocus|mFocusedApp'");
			Thread.sleep(1000);
			process.waitFor();
			BufferedReader r = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String appDetails = r.readLine();
			// Trim out characters before the '/'
			String pageAct = appDetails.substring(appDetails.indexOf('/') + 1);
			// Trim the '}' at the end of the string and return the exact
			// activity name.
			String pageActivity = pageAct.substring(0, pageAct.indexOf('}'));
			System.out.println("Activity name of the current focused screen : " + pageActivity);
			return pageActivity;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "";
		}
	}

	static WebDriver driver;

	@BeforeClass
	public static void setUpDriver() {

		driver = new FirefoxDriver();

	}

	@Test
	public void test1() {

		waitElementIsVisible(driver, By.xpath("a"));

		waitElementIsVisible(driver.findElement(By.xpath("")), By.xpath(""));
	}

	public WebElement waitElementIsVisible(SearchContext context, By by) {
		WebDriverWait wait = new WebDriverWait((WebDriver) context, 5);
		return wait.until(ExpectedConditions.presenceOfElementLocated(by));

	}

}