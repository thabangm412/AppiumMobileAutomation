package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class PreferencePage {
    protected AndroidDriver driver;

    public PreferencePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Preference\"]")
    private WebElement preferenceTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")
    private WebElement preferenceDependencies;

    @AndroidFindBy(id = "android:id/checkbox")
    private WebElement wifiCheckbox;

    @AndroidFindBy(xpath = "//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout")
    private static WebElement wifiSettings;

    @AndroidFindBy(id = "android:id/edit")
    private WebElement getWifiSettingsInputField;

    @AndroidFindBy(id = "android:id/button2")
    private WebElement wifiSettingsCancelBttn;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement wifiSettingsOkButtn;


    public void clickPreference() {
        preferenceTab.click();
    }

    public void clickPrefDependencies(){
        preferenceDependencies.click();
    }

    public void clickWifiCheckbox(){
        if(!wifiCheckbox.isSelected()){
            wifiCheckbox.click();
        }
    }

    public static boolean getWifiSettings() {
        return wifiSettings.isEnabled();
    }

    public void clickWifiSettings(){
//        if(!wifiSettings.isDisplayed()){
//            wifiSettings.click();
//        }
        wifiSettings.click();
    }

    public WebElement enterWifiSettingsComments()
    {
        return getWifiSettingsInputField;
//        getWifiSettingsInputField.sendKeys(comment);
//        wifiSettingsOkButtn.click();
    }

    public void clickWifiSettingsOkButton()
    {
        wifiSettingsOkButtn.click();
    }

    public String getWifiSettingText(){
        return getWifiSettingsInputField.getText();
    }
}

