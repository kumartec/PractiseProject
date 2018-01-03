package MyNottinghamCRM;

import org.testng.annotations.Test;
import pages.AccountCreationPage;
import pages.MyNottinghamHomePage;

public class MyNottinghamAccountCreation extends BaseTest {

    public AccountCreationPage accountcreatepage = new AccountCreationPage();

    @Test(priority = 1)
    public void loginpageTest(){
        clickUKAccountCreation();
    }

    @Test(priority = 2)
    public void accountCreationPageTest(){
        accountcreatepage.enterApplicantDetails();
        accountcreatepage.enterAddressDetails();
        /* accountcreationpage.enterContactInformation();
        accountcreationpage.enterLoginDetails();
        accountcreationpage.enterSecurityReminder();
        accountcreationpage.enterSubmitButton();*/
    }
}
