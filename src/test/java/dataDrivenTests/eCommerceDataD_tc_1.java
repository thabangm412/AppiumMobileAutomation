package dataDrivenTests;


import basicTests.BaseTestConfig;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import productStorePageObjects.HomeScreen;
import productStorePageObjects.ProductsPage;
import utils.AndroidActions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class eCommerceDataD_tc_1 extends BaseTestConfig {

    @Test(dataProvider = "getMultipleDataSets")
    public void FillForm(String country, String name, String gender) throws InterruptedException {
        HomeScreen homeScreen = new HomeScreen(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        AndroidActions androidActions = new AndroidActions(driver);
        androidActions.scrollToTextAndClick(country);
        androidActions.sendKeysAction(homeScreen.getNameInputField(),name);
        //Hide Keyboard
        driver.hideKeyboard();
        homeScreen.setGender(gender);
        homeScreen.clickLetsShopButton();
        Assert.assertEquals(productsPage.getProductIcon(),"Products");
        Thread.sleep(3000);
        productsPage.clickBack();
//        Thread.sleep(3000);

    }

    @DataProvider
    public Object[] [] getSingleDataSet()
    {
        //@DataProvide uses two dimensional data array
        //Use Object 'superClass' to accommodate string and int data

         return new Object[][]{{"Austria", "Test", "male"}};

    }

//    @BeforeMethod
//    public  void preSetup()
//    {
//        //shell command to get activity and package -- adb shell dumpsys window | findstr mCurrentFocus
//        Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
//        // For Appium Java client 8+
//        Map<String, Object> args = new HashMap<>();
//        args.put("appPackage", activity.getAppPackage());
//        args.put("appActivity", activity.getAppActivity());
//        driver.executeScript("mobile: startActivity", args);
//    }
    @BeforeMethod
    public void preSetup() {
//        Map<String, Object> args = new HashMap<>();
//        args.put("appPackage", "com.androidsample.generalstore");
//        args.put("appActivity", "com.androidsample.generalstore.MainActivity");
//        args.put("intentAction", "android.intent.action.MAIN");
//        args.put("intentCategory", "android.intent.category.LAUNCHER");
//        args.put("flags", "0x10200000"); // FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_RESET_TASK_IF_NEEDED
//        args.put("dontStopAppOnReset", true); // optional, preserves app state
//
//        driver.executeScript("mobile: startActivity", args);

//        Activity activity = new Activity("com.androidsample.generalstore",
//                "com.androidsample.generalstore.MainActivity");
//        activity.setIntentAction("android.intent.action.MAIN");
//        activity.setIntentCategory("android.intent.category.LAUNCHER");
//        activity.setIntentFlags("0x10200000");
//        activity.setStopApp(false); // equivalent to dontStopAppOnReset
//
//        try {
//            ((AndroidDriver) driver).startActivity(activity);
//        } catch (Exception e) {
//            e.printStackTrace();
//            // Fallback to ADB
//            String adbCommand = "adb shell am start -n com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity";
//            try {
//                Runtime.getRuntime().exec(adbCommand);
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//        }

//        driver.executeScript("mobile: startActivity",
//                ImmutableMap.of(
//                        "appPackage", "com.generalstore",
//                        "appActivity", "com.generalstore.MainActivity",
//                        "intentAction", "android.intent.action.MAIN",
//                        "intentCategory", "android.intent.category.LAUNCHER"
//                )
//        );
        ((JavascriptExecutor)driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"));
    }



    @DataProvider
    public Object[] [] getMultipleDataSets()
    {
        return new Object[][]{{"Austria", "Test", "male"},
                {"Canada","Test2","female"}
        };
    }
}
