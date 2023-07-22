package cucumber.Options;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/feature/apiPetDetails.feature"},
        glue = {"step.definitions"},
        monochrome = false,
        tags = "@addPet",
        plugin = {
                "json:target/jsonReports/cucumber-report.json",
                "html:target/cucumber-reports",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "pretty"
        })
public class TestRunnerAPI {

}
