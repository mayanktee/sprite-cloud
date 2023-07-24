package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.log4testng.Logger;
import testBase.BaseTest;
import testUtils.Utils;

import java.io.IOException;
import java.util.List;


public class CommonAppLaunch extends BaseTest {

    Logger log = Logger.getLogger(CommonAppLaunch.class);

    @FindBy(id = "title")
    WebElement lblHomeTitle;

    @FindBy(xpath = "//*[contains(text(),'Text Input')]")
    WebElement lnkTextInput;

    @FindBy(id="newButtonName")
      WebElement txtInputTextNewButtonName;

    @FindBy(id="updatingButton")
    WebElement btnUpdateTextButton;


    @FindBy(xpath = "//*[@class='container']/h3")
    WebElement lblPageLanding;



    @FindBy(xpath = "//*[@class='container']/h3")
    WebElement lblInputTextPageLanding;


    @FindBy(xpath = "//*[contains(text(),'Dynamic Table')]")
    WebElement lnkDynamicTable;


    @FindBy(xpath = "//*[@class='bg-warning']")
    WebElement tbChromeCPUUsage;


    // Initializing the Page Object
    public CommonAppLaunch(){
        PageFactory.initElements(driver,this);
    }

//**************************************** ACTIONS *******************************************************************

    public static String chromeCPUValue;
    public static String chromeProcessTableValue;

    public void fnLaunchApp() throws IOException {
      // App launch from Before class
        driver.get(Utils.getGlobalValues("appUrl"));
    }
    public void fnValidateLoginPageTitle(){
         driver.getTitle();
    }

    public void fnValidateLoginPageTitleWithText(String title){

        String actualTitle = lblHomeTitle.getText();
        Assert.assertTrue(actualTitle.contains(title),"Verify that the user is on Home Page : ");

    }

    public void fnClickTextInput(){
        try {
            lnkTextInput.click();
        }catch(WebDriverException e){
            log.error("Unable to click due to " + e);
        }
    }

    public void fnInputTextPageLanding(){
        Assert.assertTrue(lblInputTextPageLanding.isDisplayed(),"Verify landing on click page");
    }

    public void fnValidateButtonTextInputDisplayed(){

        //utils.waitForVisibilityOfElement(txtInputTextNewButtonName);
        Assert.assertTrue(txtInputTextNewButtonName.isDisplayed(),"Verify that the Text box with Button" +
                " name is displayed ");
        Assert.assertTrue(btnUpdateTextButton.isDisplayed(),"Verify that the Button is displayed ");

    }

    public void fnSetTextInButton(String inputText){
        try {
            txtInputTextNewButtonName.sendKeys(inputText);
            btnUpdateTextButton.click();
        }catch(WebDriverException e){
            log.error("Exception occurred : " + e);
        }
       }

    public void fnValidateTheButtonTextChanged(String inputText){
        String getButtonText = btnUpdateTextButton.getText();
        Assert.assertTrue(getButtonText.contains(inputText),"Verify that the input text passed in input field, " +
                "displayed in button name :");
        log.info("Set Input text on button validation is done.");
    }

    public void fnClickOnDynamicTable() {
        try {
            lnkDynamicTable.click();
        } catch (WebDriverException e) {
            log.error("Unable to click due to " + e);
        }
    }

    public void fnGetChromeProcessFromDynamicTable(){
        chromeCPUValue= tbChromeCPUUsage.getText();
        List<WebElement> tbRow = driver.findElements(By.xpath("//*[@role='table']/div[3]/div"));
        List<WebElement> tbCol = driver.findElements(By.xpath("//*[@role='table']/div[3]/div[1]/span"));
        try {
            for (WebElement row : tbRow) {
                if (row.getText().contains("Chrome")) {
                    for (WebElement col : tbCol) {
                        if (col.getText().contains("%")) {
                            chromeProcessTableValue = col.getText();
                            log.info("Value for the Chrome Process Load in the dynamic table :" + chromeProcessTableValue);
                        }

                    }
                }
            }
        }catch(WebDriverException e){
            log.error("Exception occurred " + e);
        }
    }

    public void fnChromeProcessValueValidation(){
        Assert.assertTrue(chromeCPUValue.contains(chromeProcessTableValue),"The value of chrome process from the " +
                "dynamic table is equal to value in Yellow label ");
        log.info("Dynamic Table validation is done.");
    }


    public void fnLandingPageValidation(String pageName){
        Assert.assertTrue(lblPageLanding.isDisplayed(),"Verify that the user is on landed on "+pageName);
        Assert.assertTrue(lblPageLanding.getText().contains(pageName),"Verify the heading title on the page " +
                "matches with given title "+pageName);
        log.info("Landing on Page is done.");
    }
}
