package basicTests;

import PageObjects.SelectViewsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.AndroidActions;

public class GestureTests extends BaseTestConfig {

    @Test
    public void LongPressGestureTest() throws InterruptedException {
        // Select Views >> Select Expandable Lists >> Click Customer Adapter
        // Documentation 'appium github gesture
        SelectViewsPage selectViewsPage = new SelectViewsPage(driver);
        AndroidActions androidActions = new AndroidActions(driver);
        selectViewsPage.clickSelectViewsButton();
        selectViewsPage.clickExpandableListButton();
        selectViewsPage.clickCustomerAdapterButton();
        // xpath syntax to note -- //tagname[@attribute='value']
        androidActions.longPressAction(selectViewsPage.getPeoplesName());
//        WebElement peoplesName = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
//        // Inject java script into the code for long-press
//        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
//                ImmutableMap.of("elementId",((RemoteWebElement)peoplesName).getId(),
//                        "duration",2000));
        Assert.assertEquals(selectViewsPage.getSampleMenuTextText(), "Sample menu");
        //Assert.assertEquals(selectViewsPage.getSampleActionTextText(), "Sample action");

    }

    @Test
    public void ScrollGestureTest()
    {
        // Click Views >> Click WebView
        // Shortcut for scrolling by google
        // Opt 1: driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"))
        SelectViewsPage selectViewsPage = new SelectViewsPage(driver);
        AndroidActions androidActions = new AndroidActions(driver);
        selectViewsPage.clickSelectViewsButton();
        androidActions.scrollToText("WebView");
    }

    @Test
    public void SwipeGestureTest()
    {
        // Click Views >> Click Gallery >> Click Photos
        SelectViewsPage selectViewsPage = new SelectViewsPage(driver);
        AndroidActions androidActions = new AndroidActions(driver);
        selectViewsPage.clickSelectViewsButton();
        selectViewsPage.clickGalleryButton();
        selectViewsPage.clickPhotosButton();
        WebElement firstPhoto = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
        Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getDomAttribute("focusable"),"true");
        //Scrolling to second picture
        androidActions.swipeToAction(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")), "left");
        Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getDomAttribute("focusable"),"false");

    }

}
