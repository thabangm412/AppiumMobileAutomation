package productStorePageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ProductsPage {
    protected AndroidDriver driver;

    public ProductsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/toolbar_title\"]")
    private WebElement homeProductsIcon;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_back")
    private WebElement backButton;


    public String getProductIcon()
    {
        return homeProductsIcon.getText();
    }

    public void clickBack()
    {
        backButton.click();
    }
}
