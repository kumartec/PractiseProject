package pages;

import framework.WebBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationPage extends WebBrowser {

    public void enterApplicantDetails() {
        System.out.println("Inside method 1");
        try {
            //WebBrowser.getWebdriverWait();
            System.out.println("Inside method 2");
            System.out.println("Element Enabled "+WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("CIBAA_RGSTR_WRK_FIRST_NAME"))).isEnabled());
            WebBrowser.getWebdriverWait();
            ((JavascriptExecutor)driver).executeScript("document.getElementById('CIBAA_RGSTR_WRK_FIRST_NAME').value = 'TestFirstName';");
            WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("CIBAA_RGSTR_WRK_FIRST_NAME"))).sendKeys("TestFirstName");
            WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("CIBAA_RGSTR_WRK_LAST_NAME"))).sendKeys("TestLastName");
            WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("CIBAA_RGSTR_WRK_BIRTHDATE"))).sendKeys("01/01/2002");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong in Applicant Details Section");
        }
    }

    public void enterAddressDetails() {
        WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("DERIVED_ADDR_COUNTRY"))).sendKeys("GBR");
        WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("DERIVED_ADDR_UPDATE_ADDRESS"))).click();
        WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("DERIVED_ADDRESS_ADDRESS1"))).sendKeys("Test1");
        WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("DERIVED_ADDRESS_ADDRESS2"))).sendKeys("Test1");
        WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("DERIVED_ADDRESS_ADDRESS3"))).sendKeys("Test1");
        WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("DERIVED_ADDRESS_CITY"))).sendKeys("Nottingham");
        WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("DERIVED_ADDRESS_POSTAL"))).sendKeys("NG7 1NR");
        WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.name("DERIVED_ADDRESS_OK_PB$IMG"))).click();
    }

    public void enterContactInformation() {
        WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("CIBAA_RGSTR_WRK_EMAILID"))).sendKeys("testinfo1245@name.com");
        WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("CIBAA_RGSTR_WRK_EMAIL_ADDR"))).sendKeys("testinfo1245@name.com");
    }

    public void enterLoginDetails() {
        WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("CIBAA_REGISTER_HRS_OPRNAME"))).sendKeys("testinfo1245@name.com");
        WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("CIBAA_RGSTR_WRK_HRS_OPRPSWD"))).sendKeys("password11");
        WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("CIBAA_RGSTR_WRK_HRS_CONFMPSWD"))).sendKeys("password11");
    }


    public void enterSecurityReminder(){
        Select securityQuestion1 = new Select(WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("CIBAA_RGSTR_WRK_CIBAA_QUESTION1"))));
        Select securityQuestion2 = new Select(WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("CIBAA_RGSTR_WRK_CIBAA_QUESTION2"))));
        Select securityQuestion3 = new Select(WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("CIBAA_RGSTR_WRK_CIBAA_QUESTION3"))));
        securityQuestion1.selectByIndex(0);
        WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("CIBAA_RGSTR_WRK_CIBAA_ANSWER1"))).sendKeys("testanswer1");
        securityQuestion2.selectByIndex(1);
        WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("CIBAA_RGSTR_WRK_CIBAA_ANSWER2"))).sendKeys("testanswer2");
        securityQuestion3.selectByIndex(2);
        WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("CIBAA_RGSTR_WRK_CIBAA_ANSWER3"))).sendKeys("testanswer3");
    }

    public void enterSubmitButton(){
        WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='CIBAA_RGSTR_WRK_SUBMIT_BTN']/img"))).click();
    }



}
