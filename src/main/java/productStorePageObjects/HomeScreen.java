package productStorePageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.time.Duration;
import java.util.Objects;

public class HomeScreen {

    protected AndroidDriver driver;

    public HomeScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
    private WebElement countryDropDownMenu;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameInputField;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    private WebElement maleGenderButtn;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement femaleGenderButtn;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement letsShopButtn;

    @AndroidFindBy(id = "android:id/text1")
    private WebElement selectedCountry;

    @AndroidFindBy(xpath = "//android.widget.Toast[@text=\"Please enter your name\"]")
    private WebElement errorToastMessg;


    public WebElement getNameInputField()
    {
        return nameInputField;
    }

    public void clickLetsShopButton()
    {
        letsShopButtn.click();
    }

    public void clickMale()
    {
        maleGenderButtn.click();
    }

    public  void clickFemale()
    {
        femaleGenderButtn.click();
    }

    public void clickDropDownButton() {

        countryDropDownMenu.click();
    }

    public String getSelectedCountry()
    {
       return selectedCountry.getText();
    }

    public String getErrorToastMessage()
    {

        return errorToastMessg.getText();
    }

    public void setGender(String gender)
    {
        if(Objects.equals(gender, "female"))
        {
            femaleGenderButtn.click();
        } else if (Objects.equals(gender, "male")) {
            maleGenderButtn.click();

        }
    }
}
