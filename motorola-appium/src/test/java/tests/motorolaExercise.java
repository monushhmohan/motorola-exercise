package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class motorolaExercise {

	AppiumDriver<MobileElement> driver;
	DesiredCapabilities caps = new DesiredCapabilities();

	@BeforeTest
	public void setup() throws MalformedURLException 
	{		

		caps.setCapability(CapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
		caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		caps.setCapability("appPackage", "com.amazon.mShop.android.shopping");
		caps.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, caps);

	}	

	@Test
	public void test() throws InterruptedException
	{
		// To skip initial login stage
		Thread.sleep(3000);
		driver.findElement(By.id("com.amazon.mShop.android.shopping:id/skip_sign_in_button")).click();

		//Scroll down to find 'All Departments' link
		Thread.sleep(3000);
		scrollByID("All Departments", 0);

		//Click on 'All Departments' link
		driver.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
		driver.findElement(By.id("com.amazon.mShop.android.shopping:id/drawer_item_title")).click();

	}
	//method to scroll down the current page
	public void scrollByID(String Id, int index) {

		try {

			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\""+Id+"\").instance("+index+"));")); 

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void teardown()
	{
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
	}
}