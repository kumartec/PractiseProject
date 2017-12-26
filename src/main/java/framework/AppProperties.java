package framework;

import java.io.InputStream;
import java.util.Properties;

public class AppProperties {

    private String PROP_FILE = null;
    public static String TestOnlineBaseURL;
    public static AppProperties appprop;

    public AppProperties() {
        try {
            PROP_FILE = RunProperties.getRunProperties().testEnv+"-app.properties";
            System.out.println("Reading and loading "+ PROP_FILE + " Properties");
            InputStream is =  RunProperties.class.getClassLoader().getResourceAsStream(PROP_FILE);

            Properties prop = new Properties();
            prop.load(is);

            AppProperties.TestOnlineBaseURL = prop.getProperty("sit.baseurl");


            is.close();
            System.out.println("Reading and loading App Properties successful");
            System.out.println("TestOnlineBaseURL = "+AppProperties.TestOnlineBaseURL);
        } catch (Exception e) {
            System.out.println("Failed to read from " + PROP_FILE + " file."
                    + "\n Stack :" + e);
        }

    }

    public static AppProperties getAppProperties() {

        if (appprop == null) {
            appprop = new AppProperties();
        }

        return appprop;

    }
}
