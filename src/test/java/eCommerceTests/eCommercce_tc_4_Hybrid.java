package eCommerceTests;


import basicTests.BaseTestConfig;
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

public class eCommercce_tc_4_Hybrid extends BaseTestConfig {

    @Test
    public void FillForm()
    {
        HomeScreen homeScreen = new HomeScreen(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        AndroidActions androidActions = new AndroidActions(driver);
        androidActions.scrollToTextAndClick("Austria");
        androidActions.sendKeysAction(homeScreen.getNameInputField(),"Test");
        homeScreen.clickMale();
        homeScreen.clickLetsShopButton();
        Assert.assertEquals(productsPage.getProductIcon(),"Products");

        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text", "Cart"));
        List<WebElement> productsPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        int count = productsPrices.size();
        double totalSum = 0;
        for(int i =0; i<count; i++)
        {
           String amountString = productsPrices.get(i).getText();
           Double price = getFormattedAmount(amountString);
           totalSum = totalSum + price; //160.97 + 120 = 280.97
        }

    }

}
