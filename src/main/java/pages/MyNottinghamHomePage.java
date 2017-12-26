package pages;

import framework.WebBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class MyNottinghamHomePage extends WebBrowser {

    public MyNottinghamHomePage(){
        try {

            System.out.println("Page Title = "+ WebBrowser.driver.getTitle());

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong in Page Title");
        }

    }

    public void clickSupportSection(){
        try {

            WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='ptpglts']/div[1]/div/div/div/div[3]"))).click();

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong in Support Section");
        }

    }

    public void clickHomePage(){
        try {

            WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("uonhomeText"))).click();

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong in clicking Home Page");
        }

    }

    public void selectTypeAndSubtypeForOneCaseCreation (){
        try {

            ((JavascriptExecutor)driver).executeScript("document.getElementById('UN_CASE_LIST1_2.00').click();");
            WebBrowser.getWebdriverWait();
            ((JavascriptExecutor)driver).executeScript("document.getElementById('UN_CASE_LIST2_3.00').click();");
            WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("UN_CASE_SMUMMARY"))).sendKeys("Test Auto - Summary for One Case Creation ");
            WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("UN_SRVC_REQ_COMMENTS"))).sendKeys("Test Auto - Details for One Case Creation ");
            WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("saveSrvcReq"))).click();
            WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.linkText("×"))).click();

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong in One CRM case creation");
        }
    }

    public void selectTypeAndSubtypeForMultiCaseCreation (){
        try {

            for(int i = 0; i<5; i++) {
                ((JavascriptExecutor) driver).executeScript("document.getElementById('UN_CASE_LIST1_2.00').click();");
                WebBrowser.getWebdriverWait();
                ((JavascriptExecutor) driver).executeScript("document.getElementById('UN_CASE_LIST2_3.00').click();");
                WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("UN_CASE_SMUMMARY"))).sendKeys("Test Auto - Summary for "+(i+1)+" Case Creation ");
                WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("UN_SRVC_REQ_COMMENTS"))).sendKeys("Test Auto - Details for "+(i+1)+" Case Creation ");
                WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("saveSrvcReq"))).click();
                WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.linkText("×"))).click();
                clickHomePage();
                clickSupportCaseLink();
                clickHomePage();
                clickSupportSection();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong in One CRM case creation");
        }
    }

    public void clickSupportCaseLink(){
        try {

            Boolean FirstLink = WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("UN_SUPPORT_1"))).isEnabled();
            System.out.println("First Link Present "+FirstLink);
            clickHomePage();
            WebBrowser.getWebdriverWait();
            WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("UN_SUPPORT_1"))).click();
            //((JavascriptExecutor)driver).executeScript("document.getElementById('UN_SUPPORT_1').click();");
            System.out.println(WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("EOTL_SS_HDR_TITLE#EOTL_SS_TITLE"))).getText());

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong in clicking Support link");
        }

    }

}
