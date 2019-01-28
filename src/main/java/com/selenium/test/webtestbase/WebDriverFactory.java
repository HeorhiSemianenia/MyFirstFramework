package com.selenium.test.webtestbase;

import com.selenium.test.configuration.TestsConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    private static WebDriver driver;


    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        } else {
            throw new IllegalStateException("Driver has not been initialized. " +
                    "Please call WebDriverFactory.startBrowser() before use this method");
        }
    }

    public static void startBrowser() {
        Browser browser = TestsConfig.getConfig().getBrowser();
        switch (browser.getBrowserName()){
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            default: throw new IllegalStateException("Unsupported browser type");
        }
        driver.manage().window().maximize();
    }


    public static void finishBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
