package MyNottinghamCRM;

import common.InitialiseWebPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import pages.MyNottinghamHomePage;
import pages.MyNottinghamLoginPage;

public class MyNottinghamCRMCaseWOAttach {

    private MyNottinghamLoginPage mynottinghamloginpage = new MyNottinghamLoginPage();
    private MyNottinghamHomePage mynottinghamhomepage = new MyNottinghamHomePage();
    private InitialiseWebPage openwebpage = new InitialiseWebPage();

    @Test
    public void loginTest(){
        openwebpage.openMyNottinghamUkLoginPage();
        mynottinghamloginpage.enterLoginDetails("khay6hkd", "password1");
        mynottinghamloginpage.clickloginbutton();

    }

    @Test
    public void oneCRMCaseTest(){
        mynottinghamhomepage.clickSupportCaseLink();
        mynottinghamhomepage.selectTypeAndSubtypeForOneCaseCreation();
        mynottinghamhomepage.clickSupportCaseLink();
    }

    @Test
    public void multiCRMCaseTest(){
        mynottinghamhomepage.clickSupportCaseLink();
        mynottinghamhomepage.selectTypeAndSubtypeForMultiCaseCreation();
        mynottinghamhomepage.clickSupportCaseLink();
    }

    @AfterSuite
    public void exitTest(){
        mynottinghamloginpage.quitBrowser();
    }

}
