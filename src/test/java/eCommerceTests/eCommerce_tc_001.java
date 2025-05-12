package eCommerceTests;


import basicTests.BaseTestConfig;
import io.appium.java_client.android.Activity;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import productStorePageObjects.HomeScreen;
import productStorePageObjects.ProductsPage;
import utils.AndroidActions;

import java.util.HashMap;
import java.util.Map;

public class eCommerce_tc_001 extends BaseTestConfig {

//    @BeforeMethod
//    public void preSetUp() {
//        //Start app from a homePage
//        Map<String, Object> args = new HashMap<>();
//        args.put("appPackage", "io.appium.android.apis");
//        args.put("appActivity", "io.appium.android.apis.preference.PreferenceDependencies");
//        driver.executeScript("mobile: startActivity", args);
//    }


    @Test
    public void FillForm_PositiveFlow() throws InterruptedException {
        HomeScreen homeScreen = new HomeScreen(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        AndroidActions androidActions = new AndroidActions(driver);
        androidActions.scrollToTextAndClick("Austria");
        Thread.sleep(3000);
        androidActions.sendKeysAction(homeScreen.getNameInputField(),"Test");
        //Hide Keyboard
        driver.hideKeyboard();
        homeScreen.clickMale();
        homeScreen.clickLetsShopButton();
        Assert.assertTrue(driver.findElements(By.xpath("(//android.widget.Toast)[1]")).isEmpty());
        //Assert.assertEquals(productsPage.getProductIcon(),"Products");

    }

    @Test
    public void FillForm_NegativeFlow()
    {
        HomeScreen homeScreen = new HomeScreen(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        AndroidActions androidActions = new AndroidActions(driver);
        androidActions.scrollToTextAndClick("Austria");
        //sendKeysAction(homeScreen.getNameInputField(),"Test");
        //Hide Keyboard
        driver.hideKeyboard();
        homeScreen.clickMale();
        homeScreen.clickLetsShopButton();
        String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getDomAttribute("name");
        Assert.assertEquals(toastMessage,"Please enter your name");
    }
}
