package dataDrivenTests;


import basicTests.BaseTestConfig;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import productStorePageObjects.HomeScreen;
import productStorePageObjects.ProductsPage;
import utils.AndroidActions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

//Here wea are driving data from jason file
//packages needeed -- mvn-- commons

//Steps
    //1. Parse Json file -> Json string (using commons-io package)
    //2. Json String -> Hash map (using jacksons)
    //3. HashMAP -> Testcase (TestNg Data provider)

@Test(dataProvider ="getMultipleDataSets")
public class eCommerceJsonData_tc_1 extends BaseTestConfig {

    public void FillForm(HashMap<String,String> input) throws InterruptedException {
        HomeScreen homeScreen = new HomeScreen(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        AndroidActions androidActions = new AndroidActions(driver);
        androidActions.scrollToTextAndClick(input.get("country"));
        androidActions.sendKeysAction(homeScreen.getNameInputField(),input.get("name"));
        //Hide Keyboard
        driver.hideKeyboard();
        homeScreen.setGender(input.get("gender"));
        homeScreen.clickLetsShopButton();
        Assert.assertEquals(productsPage.getProductIcon(),"Products");
        Thread.sleep(3000);
        productsPage.clickBack();

    }

    @DataProvider
    public Object[] [] getMultipleDataSets() throws IOException {

        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//testData//eCommerce.json");
        //result here { {hash}, {hash} }
        return new Object[][]{{data.get(0)},
                {data.get(1)}
        };
    }
}
