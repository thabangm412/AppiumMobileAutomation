package basicTests;

import PageObjects.PreferencePage;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.AndroidActions;

import java.net.MalformedURLException;

public class AppiumTests extends BaseTestConfig {

//    @Test
//    public void AppiumTest() throws MalformedURLException, URISyntaxException {
//
//        //Code to start server
//        //AndroidDriver, IOSDriver
//        //Starting Appium server programmatically
//        AppiumServiceBuilder service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\ThabangM\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//            .withIPAddress("127.0.0.1").usingPort(4723)
//                .withTimeout(Duration.ofSeconds(60));
//        service.build().start();
//
////        if (!service.isRunning()) {
////            throw new RuntimeException("Appium server did not start!");
////        }
//
//        //Appium code -> Appium Server -> Mobile
//        UiAutomator2Options options = new UiAutomator2Options();
//        options.setDeviceName("ThabangEmulator");
//        options.setApp("C:\\Users\\ThabangM\\Desktop\\Udemy\\Automation Projects\\MobileAutomation\\AppiumProject\\src\\test\\java\\resources\\ApiDemos-debug.apk");
//        //File app = new File("C:\\Users\\ThabangM\\Desktop\\Udemy\\Automation Projects\\src\\test\\java\\resources\\ApiDemos-debug.apk");
//        AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
//        //Actual automation
//        driver.quit();
//        service.build().close();
//    }

    @Test
    public  void WifiSettingsName() throws MalformedURLException {

        //ConfigureAppium(); Since @Before class is added
        //driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        PreferencePage preferencePage = new PreferencePage(driver);
        AndroidActions androidActions = new AndroidActions(driver);
        preferencePage.clickPreference();
        preferencePage.clickPrefDependencies();
        preferencePage.clickWifiCheckbox();
        Assert.assertTrue(PreferencePage.getWifiSettings());
        preferencePage.clickWifiSettings();
        androidActions.sendKeysAction(preferencePage.enterWifiSettingsComments(),"Testing");
        preferencePage.clickWifiSettingsOkButton();
        //preferencePage.enterWifiSettingsComments("Testing");
        preferencePage.clickWifiSettings();
        Assert.assertEquals(preferencePage.getWifiSettingText(), "Testing");

    }
}
