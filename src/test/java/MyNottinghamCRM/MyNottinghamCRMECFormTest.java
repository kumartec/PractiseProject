package MyNottinghamCRM;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import pages.MyNottinghamHomePage;

/**
 * Created by Senthil kumar
 */

public class MyNottinghamCRMECFormTest  extends BaseLoginTest {

    private MyNottinghamHomePage mynottinghamhomepage = new MyNottinghamHomePage();

    @Test
    public void loginTest(){ loginUKTest();  }

    @Test
    public void oneCRMECFormTest() {
        mynottinghamhomepage.clickSupportSection();
        mynottinghamhomepage.crmECFormCaseCreation();
    }

    @AfterSuite(enabled = false)
    public void exitTest(){ quitTest(); }

}
