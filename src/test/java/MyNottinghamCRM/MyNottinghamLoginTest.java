package MyNottinghamCRM;

import common.InitialiseWebPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MyNottinghamLoginPage;

/**
 * Created by Senthil kumar
 */

public class MyNottinghamLoginTest {

    private MyNottinghamLoginPage mynottinghamloginpage = new MyNottinghamLoginPage();
    private InitialiseWebPage openwebpage = new InitialiseWebPage();

    @Test (enabled = false)
    public void loginUKTest(){
        openwebpage.openMyNottinghamLoginPage("UK");
        mynottinghamloginpage.enterLoginDetails("keby6akh", "Password1!");
        mynottinghamloginpage.clickloginbutton();

    }

    @Test (enabled = true, priority = 1)
    public void loginMalaysiaTest(){
        openwebpage.openMyNottinghamLoginPage("Malaysia");
        mynottinghamloginpage.enterLoginDetails("ebxmp1", "password1");
        mynottinghamloginpage.clickloginbutton();

    }

    @Test (enabled = true, priority = 2)
    public void loginChinaTest(){
        openwebpage.openMyNottinghamLoginPage("China");
        mynottinghamloginpage.enterLoginDetails("hexgb1", "Password1!");
        mynottinghamloginpage.clickloginbutton();

    }

    @AfterMethod
    public void exitTest(){
        mynottinghamloginpage.quitBrowser();
    }

}
