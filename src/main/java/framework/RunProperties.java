package framework;

import java.io.InputStream;
import java.util.Properties;

public class RunProperties {

    private static String PROP_FILE	= "";
    public static String testEnv;
    private static RunProperties runprop;
    public static String testBrowser;
    public static String testBrowserLocation;
    private static String OS = System.getProperty("os.name").toLowerCase();
    public static String browserLocation;

    public RunProperties() {
        try {
            System.out.println("Reading and loading Run Properties");
            Properties prop = new Properties();

            String propFileName = "run.properties";
            InputStream is =  RunProperties.class.getClassLoader().getResourceAsStream(propFileName);

            prop.load(is);
            RunProperties.testEnv = prop.getProperty("test.env");
            RunProperties.testBrowser = System.getProperty("BROWSER", prop.getProperty("test.browser"));


            if (OS.contains("win")){
                RunProperties.testBrowserLocation = prop.getProperty("test.browser.location.win");
            } else {
                RunProperties.testBrowserLocation = prop.getProperty("test.browser.location.linux");
                RunProperties.browserLocation = prop.getProperty("browser.binary.location.linux");
            }

            is.close();
            System.out.println("Reading and loading Run Properties sucessful");
        } catch (Exception e) {
            System.out.println("Failed to read from " + PROP_FILE + " file Stack :" + e);
        }
    }

    public static RunProperties getRunProperties() {

        if (runprop == null) {
            runprop = new RunProperties();
        }
        return runprop;
    }
}
