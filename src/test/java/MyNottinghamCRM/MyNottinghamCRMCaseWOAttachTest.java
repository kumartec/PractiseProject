package MyNottinghamCRM;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import pages.MyNottinghamHomePage;

/**
 * Created by Senthil kumar
 */

public class MyNottinghamCRMCaseWOAttachTest extends BaseTest {

    private MyNottinghamHomePage mynottinghamhomepage = new MyNottinghamHomePage();

    @Test
    public void loginTest(){
        loginUKTest();
    }

    @Test(enabled = true)
    public void oneCRMCaseTest(){
        mynottinghamhomepage.clickSupportSection();
        mynottinghamhomepage.selectTypeAndSubtypeForOneCaseCreation();
    }

    @Test(enabled = false)
    public void multiCRMCaseTest(){
        mynottinghamhomepage.clickSupportSection();
        mynottinghamhomepage.selectTypeAndSubtypeForMultiCaseCreation();
    }

    @AfterSuite(enabled = false)
    public void exitTest(){ quitTest(); }

}
