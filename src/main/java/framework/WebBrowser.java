package framework;

import common.ConstantValue;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class WebBrowser extends ConstantValue {

    public static boolean javascriptEnabled = true;
    public static WebDriver driver;
    private static String OS = System.getProperty("os.name").toLowerCase();

    public void setUp() throws Exception {
        RunProperties.getRunProperties();
        AppProperties.getAppProperties();
    }

    public WebDriver driver()

    {
        if (driver != null) return driver;

        RunProperties.getRunProperties();

        System.out.println(RunProperties.testBrowser);

        switch (Browser.valueOf(RunProperties.testBrowser)) {
            case ie:
                File IDDriver32filePath;
                String OSArchitecture = System.getProperty("os.arch");

                if (OSArchitecture.equalsIgnoreCase("x86"))
                {
                    IDDriver32filePath = new File("DigtalSMB\\src\\test\\resources\\IE_BrowserDrivers\\IEDriverServer32", "IEDriverServer.exe");
                }
                else
                {
                    IDDriver32filePath = new File("DigtalSMB\\src\\test\\resources\\IE_BrowserDrivers\\IEDriverServer64", "IEDriverServer.exe");
                }

                System.setProperty("webdriver.ie.driver", IDDriver32filePath.getAbsolutePath());
                DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
                capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
                capability.setCapability("useLegacyInternalServer", true);
                driver = new InternetExplorerDriver(capability);
                driver.manage().window().maximize();
                break;

            case chrome:

                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + RunProperties.testBrowserLocation);
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("test-type");
                // capabilities.setCapability("chrome.binary", System.getProperty(RunProperties.testBrowserLocation));
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                driver = new ChromeDriver(capabilities);
                driver.manage().window().maximize();
                break;

            case safari:
                driver = new SafariDriver();
                driver.manage().window().maximize();
                break;

            case firefox:
            default:
                //DesiredCapabilities capabilities = null;
                capabilities = DesiredCapabilities.firefox();
                capabilities.setJavascriptEnabled(true);
                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                driver = new FirefoxDriver(capabilities);
                driver.manage().window().maximize();
                javascriptEnabled = true;
        }

        driver.manage().timeouts().implicitlyWait(240000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(240000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(240000, TimeUnit.MILLISECONDS);
        return driver;
    }

    public static WebDriverWait getWebdriverWaitObject() {
        return new WebDriverWait(driver, 50);
    }

    public static void closeBrowser() {
        driver.close();
    }

    public static void deleteCookies() {
        driver.manage().deleteAllCookies();
    }

    public static JavascriptExecutor getJavascriptExecutor() {
        return (JavascriptExecutor) driver;
    }

    public static void navigateTo(final String url) {
        driver.manage().window().maximize();
        driver.get(url);
    }

    public static void getWebdriverWait() throws InterruptedException {
        Thread.sleep(5000);
    }
    public static String getTitle() {
        return driver.getTitle();
    }

    public static String getPageSource() {
        return driver.getPageSource();
    }

    public static void switchTo(String frameName) {
        driver.switchTo().frame(frameName);
    }

    public static void switchTo(WebElement element) {
        driver.switchTo().frame(element);
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public static void refresh() {
        driver.navigate().refresh();
    }

    public static void browserBack() {
        driver.navigate().back();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    public static String getWindowhandle() {
        return driver.getWindowHandle();
    }

    public static WebDriver getPopUp(String handle) {
        return driver.switchTo().window(handle);
    }

    public boolean isElementPresentOnScreen(By locator) {
        try {
            driver().findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}

