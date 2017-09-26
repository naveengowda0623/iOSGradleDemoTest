package main;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoiOSTest {

	WebDriver driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "iOS");
		desiredCapabilities.setCapability("platformVersion", "10.3.1");
		desiredCapabilities.setCapability("deviceName", "iPhone Simulator");
		desiredCapabilities.setCapability("bundleId", "com.apple.MobileSMS");
		desiredCapabilities.setCapability("noReset", true);
		desiredCapabilities.setCapability("udid", "44963DF3-5767-4060-8EE0-BAA9FFE74E77");

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		driver = new RemoteWebDriver(remoteUrl, desiredCapabilities);
	}

	@Test
	public void sampleTest() throws InterruptedException {
		String el3 = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Messages\"]")).getText();
		Thread.sleep(5000);
		System.out.println(el3);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}