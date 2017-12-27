package MyNottinghamCRM;

import common.InitialiseWebPage;
import org.testng.annotations.Test;
import pages.MyNottinghamHomePage;
import pages.MyNottinghamLoginPage;

public class MyNottinghamLoginTest {

    private MyNottinghamLoginPage mynottinghamloginpage = new MyNottinghamLoginPage();
    private InitialiseWebPage openwebpage = new InitialiseWebPage();

    @Test
    public void loginTest(){
        openwebpage.openMyNottinghamUkLoginPage();
        mynottinghamloginpage.enterLoginDetails("keby6akh", "Password1!");
        mynottinghamloginpage.clickloginbutton();

    }
}
