package framework;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
    public static boolean javascriptEnabled = true;
    public static WebDriver driver;
    private static String OS = System.getProperty("os.name").toLowerCase();

    /**
     * @param driver
     * @return
     */
    public static WebDriverWait getWebdriverWaitObject(WebDriver driver) {
        return new WebDriverWait(driver, 20);
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
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
