package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Utils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Description: WebDriver is a class which configures different drivers
 * code to handle Chrome browser * @author Mayank Tiwari
 *
 */

public class BaseTest {

	public static WebDriver driver;

	public static void initialization() throws IOException {
		String browserName = Utils.getGlobalValues("browserName");
		if(browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/mayanktiwari/Documents/sprite-cloud/libs/chromedriver");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	}

}
