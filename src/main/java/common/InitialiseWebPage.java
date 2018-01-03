package common;

import framework.AppProperties;
import framework.WebBrowser;

public class InitialiseWebPage extends WebBrowser {

    public String URL;

    public void openMyNottinghamLoginPage(String CampusName) {

        if(CampusName == "UK") {
            //System.out.println("TestUKURL = " + AppProperties.TestUKURL);
            URL = AppProperties.getAppProperties().TestUKURL;
            System.out.println("UK URL to open = " + URL);
            driver().get(URL);
        } else if(CampusName == "Malaysia") {
            URL = AppProperties.getAppProperties().TestMalaysiaURL;
            System.out.println("Malaysia URL to open = " + URL);
            driver().get(URL);
        } else if (CampusName == "China") {
            URL = AppProperties.getAppProperties().TestChinaURL;
            System.out.println("China URL to open = " + URL);
            driver().get(URL);
        } else if (CampusName == "UKAcc") {
            URL = AppProperties.getAppProperties().TestUKAccURL;
            System.out.println("UK Account creation URL to open = " + URL);
            driver().get(URL);
        }
    }

}
