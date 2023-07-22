package step.definitions;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import testBase.BaseTest;

import java.io.IOException;


public class Hooks extends BaseTest {


    @Before("@deleteOrderId")
    public static void beforeDelete() throws IOException {
        MyStepdefsAPI stepDef = new MyStepdefsAPI();
        if(MyStepdefsAPI.newOrderId ==0) {
            stepDef.iCreateANewOrderWithTheFollowingGivenPet("11111", "01");
            stepDef.theAPIShouldRespondForAPIWithANewOrderID("CREATESTOREID");
            stepDef.theAPIShouldRespondWithAStatusCodeOf(200);
        }
    }

    @AfterStep
    public static void fnTakescreenShot(Scenario scenario){

        final byte [] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png","image");
    }
}

