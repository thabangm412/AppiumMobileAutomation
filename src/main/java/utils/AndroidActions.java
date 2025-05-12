package utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndroidActions extends AppiumUtils {

    AndroidDriver driver;

    public AndroidActions(AndroidDriver driver)
    {
        this.driver = driver;
    }
    public void longPressAction(WebElement element)
    {
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
                        "duration",2000));
    }

    public void sendKeysAction(WebElement element, String string)
    {
        element.sendKeys(string);
    }

    public String scrollToText(String visibleText) {
        WebElement element = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"" + visibleText + "\"))"));
        return element.getText();
    }

    public void scrollToTextAndClick(String visibleText) {
        WebElement element = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"" + visibleText + "\"))"
        ));
        element.click();
    }

    public void swipeToAction(WebElement element, String direction)
    {
        ((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
                        "direction", direction,
                        "percent",0.5));
    }
}
