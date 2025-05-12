package productStoreTests;


import basicTests.BaseTestConfig;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import productStorePageObjects.HomeScreen;
import productStorePageObjects.ProductsPage;
import utils.AndroidActions;

import java.util.List;

public class ProductStoreTests extends BaseTestConfig {

    @Test
    public void CountrySelectionTest(){

        HomeScreen homeScreen = new HomeScreen(driver);
        AndroidActions androidActions = new AndroidActions(driver);
        homeScreen.clickDropDownButton();
        androidActions.scrollToTextAndClick("South Africa");
        Assert.assertEquals(homeScreen.getSelectedCountry(),"South Africa");
    }

    @Test
    public  void LoginTest()
    {
        HomeScreen homeScreen = new HomeScreen(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        AndroidActions androidActions = new AndroidActions(driver);
        androidActions.scrollToTextAndClick("Austria");
        androidActions.sendKeysAction(homeScreen.getNameInputField(),"Test");
        homeScreen.clickMale();
        homeScreen.clickLetsShopButton();
        Assert.assertEquals(productsPage.getProductIcon(),"Products");

    }

    @Test
    public void ErrorValidationTest()
    {
        HomeScreen homeScreen = new HomeScreen(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        AndroidActions androidActions = new AndroidActions(driver);
        androidActions.scrollToTextAndClick("Austria");
        homeScreen.clickMale();
        homeScreen.clickLetsShopButton();
        Assert.assertEquals(homeScreen.getErrorToastMessage(),"Please enter your name");
    }

    @Test
    public void SelectingProductDynamically() throws InterruptedException {
        HomeScreen homeScreen = new HomeScreen(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        AndroidActions androidActions = new AndroidActions(driver);
        androidActions.scrollToTextAndClick("Austria");
        androidActions.sendKeysAction(homeScreen.getNameInputField(),"Test");
        homeScreen.clickMale();
        homeScreen.clickLetsShopButton();

        List<WebElement> products = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
        int productCount = ((List<?>) products).size();
        System.out.println("Number of products found: " + productCount);

        for (int i = 0; i < productCount; i++) {
            String productName = products.get(i).getText();
            System.out.println("Product " + i + ": " + productName);

            if (productName.equalsIgnoreCase("Air Jordan 1 Mid SE")) {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
                System.out.println("Clicked on: " + productName);
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\"]")).getText(),"Air Jordan 1 Mid SE");
    }

    @Test
    public void ScrollToDesiredProductTest() {
        HomeScreen homeScreen = new HomeScreen(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        AndroidActions androidActions = new AndroidActions(driver);

        androidActions.scrollToTextAndClick("Austria"); // Assuming this method exists
        androidActions.sendKeysAction(homeScreen.getNameInputField(), "Test");
        homeScreen.clickMale();
        homeScreen.clickLetsShopButton();

        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"Air Jordan 9 Retro\"))"));

        // Find all product names and "Add to Cart" buttons
        List<WebElement> productNames = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
        List<WebElement> addToCartButtons = driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart"));

        // Loop through the product names to find the match
        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).getText().equalsIgnoreCase("Air Jordan 9 Retro")) {
                addToCartButtons.get(i).click(); // Click corresponding Add to Cart button
                System.out.println("✅ Clicked Add to Cart for: " + "Air Jordan 9 Retro");
                break;
            }
        }

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        System.out.println("✅ Clicked Add to Cart Button");
        Assert.assertEquals(
                driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName']")).getText(),
                "Air Jordan 9 Retro"
        );
    }
}