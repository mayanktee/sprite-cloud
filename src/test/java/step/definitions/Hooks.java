package step.definitions;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeSuite;
import testBase.BaseTest;

import java.io.IOException;
public class Hooks extends BaseTest {


    @Before("@deleteOrderId")
    public static void beforeDelete() throws IOException {
        MyStepdefsAPI stepDef = new MyStepdefsAPI();
            stepDef.iCreateANewOrderWithTheFollowingGivenPet("11111", "01");
            stepDef.theAPIShouldRespondForAPIWithANewOrderID("CREATESTOREID");
            stepDef.theAPIShouldRespondWithAStatusCodeOf(200);
    }

    @BeforeSuite
    public static void logger(){
        Logger logger = org.apache.log4j.Logger.getLogger(Hooks.class);
        PropertyConfigurator.configure("src/test/resources/log4j.properties");
    }

    @AfterStep("@executeAfterStep")
    public static void fnTakescreenShot(Scenario scenario){

        final byte [] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png","image");
    }
}

