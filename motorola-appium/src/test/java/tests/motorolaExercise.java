package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
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
}