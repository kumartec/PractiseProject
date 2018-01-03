package pages;

import framework.WebBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Senthil kumar
 */

public class MyNottinghamLoginPage extends WebBrowser {

    /*private static final String Type_Emailid="//*[@id='email']";
    private static final String Type_Password="//*[@id='passwd']";
    private static final String LoginButton ="//*[@id='SubmitLogin']";*/

    public void enterLoginDetails(String Emailid, String Password)
    {

        try {

            WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("userid"))).sendKeys(Emailid);
            WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("pwd"))).sendKeys(Password);

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong");
        }
    }

    public void clickloginbutton()
    {

        try {

            WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.name("Submit"))).click();

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong");
        }
    }

    public void clickUKApplyCoursebutton()
    {

        try {

            WebBrowser.getWebdriverWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.id("sgnup"))).click();

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong");
        }
    }


    public void quitBrowser(){

        WebBrowser.closeBrowser();
    }

}
