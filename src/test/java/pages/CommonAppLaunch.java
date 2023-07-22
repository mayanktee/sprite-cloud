package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.log4testng.Logger;
import testBase.BaseTest;
import testUtils.Utils;

import java.io.IOException;
import java.util.List;


public class CommonAppLaunch extends BaseTest {

    WebDriverWait wait = new WebDriverWait(driver, 10);
    Logger log = Logger.getLogger(CommonAppLaunch.class);

    @FindBy(id = "title")
    WebElement lblHomeTitle;

    @FindBy(xpath = "//*[contains(text(),'Text Input')]")
    WebElement lnkTextInput;

    @FindBy(id="newButtonName")
      WebElement txtInputTextNewButtonName;

    @FindBy(id="updatingButton")
    WebElement btnUpdateTextButton;

    @FindBy(xpath = "//*[contains(text(),'Click')]")
    WebElement lnkClick;

    @FindBy(xpath = "//*[@class='container']/h3")
    WebElement lblClickPageLanding;

    @FindBy(xpath = "//*[@id='badButton']")
    WebElement btnColourChange;

    @FindBy(xpath = "//*[@class='container']/h3")
    WebElement lblInputTextPageLanding;

    @FindBy(xpath = "//*[@class='btn btn-success']")
    WebElement btnGreen;

    @FindBy(xpath = "//*[contains(text(),'Dynamic Table')]")
    WebElement lnkDynamicTable;

    @FindBy(xpath = "//*[@role='table']/div[3]/div[1]/span[3]")
    WebElement tbChromeCPUUsageInTable;

    @FindBy(xpath = "//*[@class='bg-warning']")
    WebElement tbChromeCPUUsage;


    //*[@role="table"]/div[3]/div[1]/span[3]

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
    public String fnValidateLoginPageTitle(){
        return driver.getTitle();
    }

    public void fnValidateLoginPageTitleWithText(String title){

        String actualTitle = lblHomeTitle.getText();
        Assert.assertTrue(actualTitle.contains(title),"Verify that the user is on Home Page : ");

    }

    public void fnClickTextInput(){
        lnkTextInput.click();
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
        txtInputTextNewButtonName.sendKeys(inputText);
        btnUpdateTextButton.click();

       }

    public void fnValidateTheButtonTextChanged(String inputText){
        String getButtonText = btnUpdateTextButton.getText();
        Assert.assertTrue(getButtonText.contains(inputText),"Verify that the input text passed in input field, " +
                "displayed in button name :");
    }

    public void fnClickOnDynamicTable(){
        lnkDynamicTable.click();
    }

    public void fnGetChromeProcessFromDynamicTable(){
        chromeCPUValue= tbChromeCPUUsage.getText();
        String value;
        List<WebElement> tbRow = driver.findElements(By.xpath("//*[@role='table']/div[3]/div"));
        List<WebElement> tbCol = driver.findElements(By.xpath("//*[@role='table']/div[3]/div[1]/span"));
        for(WebElement row : tbRow){
            if(row.getText().contains("Chrome")){
                for(WebElement col : tbCol){
                    if(col.getText().contains("%")){
                        chromeCPUValue = col.getText();
                        log.info("Value for the Chrome Process Load in the dynamic table :"+chromeProcessTableValue);
                    }

                }
            }
        }
    }

    public void fnChromeProcessValueValidation(){
        Assert.assertTrue(chromeCPUValue.contains(chromeCPUValue),"The value of chrome process from the " +
                "dynamic table is equal to value in Yellow label ");
    }
}
