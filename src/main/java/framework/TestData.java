package framework;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "gmailaccounts")
    public Object[][] loginCredentialsdetails() {
        return new Object[][] {
                { "kumarteck", "india007", "Kumar G" }
        };
    }

    @DataProvider(name = "gmailAccountCreation")
    public Object[][] loginCredentials() {
        return new Object[][] {
                { "kumar1", "teck1", "meteck", "testsample1", "testsample1", "June", "20", "1985", "Male", "07466197114", }
        };
    }

}
