package MyNottinghamCRM;

import org.testng.annotations.Test;
import pages.MyNottinghamHomePage;

public class MyNottinghamCRMCaseWAttachTest extends BaseTest {

    private MyNottinghamHomePage mynottinghamhomepage = new MyNottinghamHomePage();

    @Test
    public void loginTest(){
        loginUKTest();
    }

    @Test(enabled = true)
    public void oneCRMCaseTest(){
        mynottinghamhomepage.clickSupportSection();
        mynottinghamhomepage.selectTypeAndSubtypeForOneAttachmentCaseCreation();
    }

}
