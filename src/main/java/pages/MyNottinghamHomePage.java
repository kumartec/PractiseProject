package pages;

import framework.WebBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by Senthil kumar
 */

public class MyNottinghamHomePage extends WebBrowser {

    public MyNottinghamHomePage(){
        try {
            WebBrowser.getWebdriverWait();
            System.out.println("Page Title = "+ WebBrowser.driver.getTitle());

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong in Page Title");
        }

    }

    public void clickSupportSection(){
        try {
            WebBrowser.getWebdriverWait();
            WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='ptpglts']/div[1]/div/div/div/div[4]"))).click();
            WebBrowser.getWebdriverWait();
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
            String timeStamp = currentSystemTime();
            String caseText = "Test Auto - Details for One Case Creation "+timeStamp;
            System.out.println(caseText);
            WebBrowser.getWebdriverWait();
            ((JavascriptExecutor)driver).executeScript("document.getElementById('UN_CASE_LIST1_4.00').click();");
            WebBrowser.getWebdriverWait();
            ((JavascriptExecutor)driver).executeScript("document.getElementById('UN_CASE_LIST2_2.00').click();");
            WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("UN_CASE_SMUMMARY"))).sendKeys(caseText);
            WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("UN_SRVC_REQ_COMMENTS"))).sendKeys(caseText);
            WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("saveSrvcReq"))).click();
            WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.linkText("×"))).click();
            clickSupportCaseLink(timeStamp);

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong in One CRM case creation");
        }
    }

    public void selectTypeAndSubtypeForMultiCaseCreation (){
        try {

            for(int i = 0; i<5; i++) {
                String caseText = "Test Auto - Summary for "+(i+1)+" Case Creation";
                ((JavascriptExecutor) driver).executeScript("document.getElementById('UN_CASE_LIST1_2.00').click();");
                WebBrowser.getWebdriverWait();
                ((JavascriptExecutor) driver).executeScript("document.getElementById('UN_CASE_LIST2_2.00').click();");
                WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("UN_CASE_SMUMMARY"))).sendKeys("Test Auto - Summary for "+(i+1)+" Case Creation ");
                WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("UN_SRVC_REQ_COMMENTS"))).sendKeys("Test Auto - Details for "+(i+1)+" Case Creation ");
                WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("saveSrvcReq"))).click();
                WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.linkText("×"))).click();
                clickHomePage();
                clickSupportCaseLink(caseText);
                clickHomePage();
                clickSupportSection();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong in One CRM case creation");
        }
    }

    public void clickSupportCaseLink(String CaseLinkText){
        try {

            Boolean FirstLink = WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("table#UN_IH_ALL_SUPPORT_STATUS > tbody:nth-child(2) tr:nth-child(1) td:nth-child(1) a"))).isEnabled();
            String FirstLinkName = WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("table#UN_IH_ALL_SUPPORT_STATUS > tbody:nth-child(2) tr:nth-child(1) td:nth-child(1) a"))).getText();
            System.out.println("First Link Present "+FirstLink);
            System.out.println("First Link Name "+FirstLinkName);
            clickHomePage();
            WebBrowser.getWebdriverWait();
            List<WebElement> list = driver.findElements(By.cssSelector("table#UN_IH_ALL_SUPPORT_STATUS > tbody:nth-child(2)"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click()", list.get(0));
            //WebBrowser.getWebdriverWait();
            //WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(FirstLinkName))).click();
            //WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("table#UN_IH_ALL_SUPPORT_STATUS > tbody:nth-child(2) tr:nth-child(1) td:nth-child(1) a"))).click();
            //WebBrowser.getWebdriverWait();
            System.out.println(WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("EOTL_SS_HDR_TITLE#EOTL_SS_TITLE"))).getText());

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong in clicking Support link");
        }

    }

    public void crmECFormCaseCreation(){
        try {

            //WebBrowser.getWebdriverWait();
            ((JavascriptExecutor)driver).executeScript("document.getElementById('UN_CASE_LIST1_2.00').click();");
            WebBrowser.getWebdriverWait();
            ((JavascriptExecutor)driver).executeScript("document.getElementById('UN_CASE_LIST2_1.00').click();");
            WebBrowser.getWebdriverWait();
            ((JavascriptExecutor)driver).executeScript("document.getElementById('UN_IH_CONTINUE').click();");
            /*WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("UN_CASE_SMUMMARY"))).sendKeys("Test Auto - Summary for One Case Creation ");
            WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("UN_SRVC_REQ_COMMENTS"))).sendKeys("Test Auto - Details for One Case Creation ");
            WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("saveSrvcReq"))).click();
            WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.linkText("×"))).click();*/

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong in CRM EC Form case creation");
        }
    }

}
