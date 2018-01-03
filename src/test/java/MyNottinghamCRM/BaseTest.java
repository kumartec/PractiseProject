package MyNottinghamCRM;

import common.InitialiseWebPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.MyNottinghamLoginPage;

/**
 * Created by Senthil kumar
 */

public class BaseTest {

    private MyNottinghamLoginPage mynottinghamloginpage = new MyNottinghamLoginPage();
    private InitialiseWebPage openwebpage = new InitialiseWebPage();

    public void loginUKTest(){
        openwebpage.openMyNottinghamLoginPage("UK");
        mynottinghamloginpage.enterLoginDetails("aaxan1", "password1");
        mynottinghamloginpage.clickloginbutton();

    }

    public void loginMalaysiaTest(){
        openwebpage.openMyNottinghamLoginPage("Malaysia");
        mynottinghamloginpage.enterLoginDetails("ebxmp1", "password1");
        mynottinghamloginpage.clickloginbutton();

    }

    public void loginChinaTest(){
        openwebpage.openMyNottinghamLoginPage("China");
        mynottinghamloginpage.enterLoginDetails("hexgb1", "Password1!");
        mynottinghamloginpage.clickloginbutton();

    }

    public void clickUKApplyCourse(){
        openwebpage.openMyNottinghamLoginPage("UK");
        mynottinghamloginpage.clickUKApplyCoursebutton();

    }

    public void clickUKAccountCreation(){
        openwebpage.openMyNottinghamLoginPage("UKAcc");

    }

    @AfterTest(enabled = false)
    public void quitTest(){
        mynottinghamloginpage.quitBrowser();
    }

}
