package com.example.sereg.ortnec;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;

public class OrtnecTest {

    private WebDriver driver;
    AppiumDriver appiumDriver;

    @Before
    public void setUp() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Meizu m3 note");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("platformName", "Android");
        cap.setCapability(CapabilityType.VERSION, "5.1");
        cap.setCapability("appPackage", "com.example.android.contactmanager");
        cap.setCapability("appActivity", "com.example.android.contactmanager.ContactManager");

        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new RemoteWebDriver(url, cap);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void FirstTest() throws InterruptedException {
        System.out.print("first test");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        System.out.print(scrFile);
        Thread.sleep(30000);
}

    @After
    public void End() {driver.quit();}
}

