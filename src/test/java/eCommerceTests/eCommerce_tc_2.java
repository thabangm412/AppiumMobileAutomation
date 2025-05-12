package eCommerceTests;


import basicTests.BaseTestConfig;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import productStorePageObjects.HomeScreen;
import productStorePageObjects.ProductsPage;
import utils.AndroidActions;

import java.time.Duration;
import java.util.List;

public class eCommerce_tc_2 extends BaseTestConfig {

    @Test
    public void AddProductToCartAndValidate() throws InterruptedException {
        HomeScreen homeScreen = new HomeScreen(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        AndroidActions androidActions = new AndroidActions(driver);
        androidActions.scrollToTextAndClick("Austria");
        androidActions.sendKeysAction(homeScreen.getNameInputField(),"Test");
        driver.hideKeyboard();
        homeScreen.clickMale();
        homeScreen.clickLetsShopButton();

        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        //Thread.sleep(2000);
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text" , "Cart"));
        List<WebElement> productPrices =driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        int count = productPrices.size();
        double totalSum =0;
        for(int i =0; i< count; i++)
        {
            String amountString =productPrices.get(i).getText();
            //Here returned amount is $160.97 and we are converting it to 160.97
            double price = Double.parseDouble(amountString.substring(1));
            totalSum = totalSum + price;  //160.97 + 120 =280.97

        }
        String dispalySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        double displayFormattedSum = getFormattedAmount(dispalySum);
        Assert.assertEquals(totalSum, displayFormattedSum);
        WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        androidActions.longPressAction(ele);
        //add alert popup assertion here
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(2000);

    }
}
