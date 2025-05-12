package basicTests;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.AppiumUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTestConfig extends AppiumUtils {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    @BeforeClass
//    public  void ConfigureAppium() throws MalformedURLException {
//        service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\tmono\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//                .withIPAddress("127.0.0.1").usingPort(4723)
//                .withTimeout(Duration.ofSeconds(60));
//        service.build().start();
//
//        UiAutomator2Options options = new UiAutomator2Options();
//        options.setDeviceName("Pixel 6");
//        options.setApp("C:\\Users\\tmono\\Desktop\\Udemy\\Automation Projects\\MobileAutomation\\AppiumProject\\src\\test\\java\\resources\\General-Store.apk");
//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }
    public void ConfigureAppium() throws MalformedURLException {
        // Initialize AppiumDriverLocalService using the builder
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\tmono\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withTimeout(Duration.ofSeconds(60))
                .build();

        // Start the Appium server
        service.start();

        // Set the desired capabilities or options for the Android driver
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 6");
        options.setApp("C:\\Users\\tmono\\Desktop\\Udemy\\Automation Projects\\MobileAutomation\\AppiumProject\\src\\test\\java\\resources\\General-Store.apk");

        // Initialize the Android driver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (service != null && service.isRunning()) {
            service.stop();
        }
    }
//    public void longPressAction(WebElement element)
//    {
//        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
//                ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
//                        "duration",2000));
//    }
//
//    public void sendKeysAction(WebElement element, String string)
//    {
//        element.sendKeys(string);
//    }
//
//    public String scrollToText(String visibleText) {
//        WebElement element = driver.findElement(AppiumBy.androidUIAutomator(
//                "new UiScrollable(new UiSelector().scrollable(true))" +
//                        ".scrollIntoView(new UiSelector().text(\"" + visibleText + "\"))"));
//        return element.getText();
//    }
//
//    public void scrollToTextAndClick(String visibleText) {
//        WebElement element = driver.findElement(AppiumBy.androidUIAutomator(
//                "new UiScrollable(new UiSelector().scrollable(true))" +
//                        ".scrollIntoView(new UiSelector().text(\"" + visibleText + "\"))"
//        ));
//        element.click();
//    }
//
//    public void swipeToAction(WebElement element, String direction)
//    {
//        ((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",
//                ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
//                        "direction", direction,
//                        "percent",0.5));
//    }

}
