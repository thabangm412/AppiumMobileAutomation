package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class SelectViewsPage {
    protected AndroidDriver driver;

    public SelectViewsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Views\"]")
    private WebElement viewsButtn;

    @AndroidFindBy(accessibility = "Expandable Lists")
    private WebElement expandablesListButtn;

    @AndroidFindBy(accessibility = "1. Custom Adapter")
    private WebElement customerAdapterButtn;

    @AndroidFindBy(id = "android:id/title")
    private WebElement sampleMenuButtn;

    @AndroidFindBy(id = "android:id/content")
    private WebElement sampleActionButtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"People Names\"]")
    private WebElement peoplesNameButton;

    @AndroidFindBy(id = "android:id/text1")
    private WebElement webViewButtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Gallery\"]")
    private  WebElement galleryButtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"1. Photos\"]")
    private WebElement photosButtn;

    public void clickSelectViewsButton(){
        viewsButtn.click();
    }

    public void clickExpandableListButton(){
        expandablesListButtn.click();
    }

    public void clickCustomerAdapterButton(){
        customerAdapterButtn.click();

    }

    public WebElement getPeoplesName(){
        return peoplesNameButton;

    }

    public String getSampleActionTextText(){
        return  sampleActionButtn.getText();

    }

    public String getSampleMenuTextText(){
        return  sampleMenuButtn.getText();

    }

    public String getWebView(){
        return  webViewButtn.getText();
    }


    public void clickGalleryButton() {
        galleryButtn.click();
    }

    public void clickPhotosButton() {
        photosButtn.click();
    }
}
