package framework;

import java.io.InputStream;
import java.util.Properties;

public class AppProperties {

    private String PROP_FILE = null;
    public static String TestUKURL;
    public static String TestMalaysiaURL;
    public static String TestChinaURL;
    public static AppProperties appprop;

    public AppProperties() {
        try {
            PROP_FILE = RunProperties.getRunProperties().testEnv+"-app.properties";
            System.out.println("Reading and loading "+ PROP_FILE + " Properties");
            InputStream is =  RunProperties.class.getClassLoader().getResourceAsStream(PROP_FILE);

            Properties prop = new Properties();
            prop.load(is);

            AppProperties.TestUKURL = prop.getProperty("sit.ukurl");

            AppProperties.TestMalaysiaURL = prop.getProperty("sit.malaysiaurl");

            AppProperties.TestChinaURL = prop.getProperty("sit.chinaurl");

            is.close();
            //System.out.println("AppProperties.TestMalaysiaURL URL = "+ AppProperties.TestMalaysiaURL);
            System.out.println("Reading and loading App Properties successful");
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
