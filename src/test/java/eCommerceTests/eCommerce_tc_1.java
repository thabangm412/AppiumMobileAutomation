package eCommerceTests;


import basicTests.BaseTestConfig;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import productStorePageObjects.HomeScreen;
import productStorePageObjects.ProductsPage;
import utils.AndroidActions;

import java.time.Duration;

public class eCommerce_tc_1 extends BaseTestConfig {

    @Test
    public void FillForm() throws InterruptedException {
        HomeScreen homeScreen = new HomeScreen(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        AndroidActions androidActions = new AndroidActions(driver);
        androidActions.scrollToTextAndClick("Austria");
        androidActions.sendKeysAction(homeScreen.getNameInputField(),"Test");
        //Hide Keyboard
        driver.hideKeyboard();
        homeScreen.clickMale();
        homeScreen.clickLetsShopButton();
        Assert.assertEquals(productsPage.getProductIcon(),"Products");

    }

    @Test
    public void ToastValidation()
    {
        HomeScreen homeScreen = new HomeScreen(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        AndroidActions androidActions = new AndroidActions(driver);
        androidActions.scrollToTextAndClick("Austria");
        //sendKeysAction(homeScreen.getNameInputField(),"Test");
        //Hide Keyboard
//        driver.hideKeyboard();
        homeScreen.clickMale();
        homeScreen.clickLetsShopButton();
        String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getDomAttribute("name");
        Assert.assertEquals(toastMessage,"Please enter your name");
    }

    @Test
    public void AddProductToCart()
    {
        HomeScreen homeScreen = new HomeScreen(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        AndroidActions androidActions = new AndroidActions(driver);
        androidActions.scrollToTextAndClick("Austria");
        androidActions.sendKeysAction(homeScreen.getNameInputField(),"Test");
        driver.hideKeyboard();
        homeScreen.clickMale();
        homeScreen.clickLetsShopButton();

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));

        int productCount =	driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        for(int i=0; i<productCount; i++)
        {
            String productName =driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if(productName.equalsIgnoreCase("Jordan 6 Rings"))
            {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
                //System.out.println("Clicked on: ");
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
        //Checking if we have arrived at the cart page before doing validations
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text" , "Cart"));

        String lastPageProduct =driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals(lastPageProduct, "Jordan 6 Rings");
    }

}


