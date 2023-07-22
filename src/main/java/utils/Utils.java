package utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public static String getGlobalValues(String key) throws IOException {

        Properties prop = new Properties();
        FileInputStream fis= new FileInputStream("src/test/resources/global.properties");

        prop.load(fis);
        return prop.getProperty(key);
    }


    public static String getJsonPath(Response response, String key)
    {
        String resp=response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }

    public void WaitUtils(WebDriver driver, int waitTimeInSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, waitTimeInSeconds);
    }

    // Wait for element visibility
    public WebElement waitForVisibilityOfElement(WebElement ele) throws IOException {
        try {
            return wait.until(ExpectedConditions.visibilityOf(ele));
        } catch (TimeoutException e) {
            throw new TimeoutException("Element with locator " + ele + " not visible within the specified wait time.");
        }

    }
}
