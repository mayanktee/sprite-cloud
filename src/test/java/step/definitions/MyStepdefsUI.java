package step.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonAppLaunch;
import testBase.BaseTest;

import java.io.IOException;

public class MyStepdefsUI extends BaseTest {

    CommonAppLaunch com = new CommonAppLaunch();

    @Given("Launch the application UITestingPlayground")
    public void launchTheApplicationUITestingPlayground() throws IOException {
        com.fnLaunchApp();
    }

    @And("User is on the {string} application home page")
    public void userIsOnTheApplicationHomePage(String title) {
        com.fnValidateLoginPageTitle();
        com.fnValidateLoginPageTitleWithText(title);
    }


    @When("User navigate to the test input page")
    public void userNavigateToTheTestInputPage() {
        com.fnClickTextInput();
        com.fnInputTextPageLanding();
    }

    @Then("User should see the text box input field and button")
    public void userShouldSeeTheTextBoxInputFieldAndButton() {
        com.fnValidateButtonTextInputDisplayed();
    }

    @And("User should be able to set the text {string}")
    public void userShouldBeAbleToSetTheText(String newButtonName) {
        com.fnSetTextInButton(newButtonName);
    }

    @And("User should be able to press the button and validate the text {string}")
    public void userShouldBeAbleToPressTheButtonAndValidateTheText(String newButtonName) {
        com.fnValidateTheButtonTextChanged(newButtonName);
    }

    @When("User navigate to the Dynamic Table page")
    public void userNavigateToTheDynamicTablePage() {
        com.fnClickOnDynamicTable();
    }

    @Then("User should able to get the value from the table for Chrome Process")
    public void userShouldAbleToGetTheValueFromTheTableForChromeProcess() {
        com.fnGetChromeProcessFromDynamicTable();
    }

    @And("User should be able to compare the value with Yellow label CPU load")
    public void userShouldBeAbleToCompareTheValueWithYellowLabelCPULoad() {
        com.fnChromeProcessValueValidation();
    }
}
