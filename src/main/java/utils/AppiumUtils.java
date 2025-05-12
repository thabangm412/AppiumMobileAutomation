package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public abstract class AppiumUtils {

    public double getFormattedAmount(String amount)
    {
        return Double.parseDouble(amount.substring(1));

    }

    public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException
    {
        //convert json file content to json string
        String jsonContent = FileUtils.readFileToString(
                //new File(System.getProperty("user.dir") + "//src//test//java//testData//eCommerce.json"),
                new File(jsonFilePath),
                StandardCharsets.UTF_8
        );
        // Convert JSON string to List<HashMap<String, String>>
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(
                jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {}
        );
        return data;
    }

    public void waitForElementToAppear(WebElement element, String attr, String value, AppiumDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(element,attr, value));
    }
}
