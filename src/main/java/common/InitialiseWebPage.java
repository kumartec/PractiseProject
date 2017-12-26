package common;

import framework.AppProperties;
import framework.WebBrowser;

public class InitialiseWebPage extends WebBrowser {

    public void openMyNottinghamUkLoginPage() {
        String URL;
        URL = AppProperties.getAppProperties().TestOnlineBaseURL;
        //WebBrowser.driver.get(URL);
        System.out.println("URL to open = " + URL);
        driver().get(URL);
    }

}
