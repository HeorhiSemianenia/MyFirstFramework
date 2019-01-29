package com.selenium.test.webtestbase;

import com.selenium.test.configuration.TestsConfig;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WebDriverFactory {
    private static WebDriver driver;
    private static String testName;

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
        MutableCapabilities options;
        switch (browser.getBrowserName()) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("disable-infobars");
                driver = new ChromeDriver(optionsChrome);
                break;
            default:
                throw new IllegalStateException("Unsupported browser type");
        }
        driver.manage().window().maximize();
    }


    public static void finishBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    /**
     * Define path for Screenshot file.
     */
    private static String getScreenshotSavePath(String instanceName) {
        File dir = new File(System.getProperty("user.dir") + File.separator + "screenshot" + File.separator + instanceName);
        dir.mkdirs();
        return dir.getAbsolutePath();
    }

    /**
     * Take Screenshot on failure.
     */
    public static void getScreenshot(String instanceName) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String date = sdf.format(new Date());
        String ext = ".png";
        String path = getScreenshotSavePath(instanceName) + File.separator + date + ext;

        try {
            if (driver instanceof TakesScreenshot) {
                File tmpFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                org.openqa.selenium.io.FileHandler.copy(tmpFile, new File(path));
//                log.error("Captured Screenshot for Failure: "+path);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
