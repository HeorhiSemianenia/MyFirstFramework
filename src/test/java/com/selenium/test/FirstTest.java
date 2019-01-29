package com.selenium.test;

import com.selenium.test.listeners.ScreenShotOnFailListener;
import com.selenium.test.webtestbase.WebDriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ScreenShotOnFailListener.class})
public class FirstTest {

    public String testURL = "https://dev.integrivideo.com/demo/chat/new";

    @BeforeMethod
    public void setupTest() {
        WebDriverFactory.startBrowser();
    }

    @Test
    public void firstTest() {
        WebDriverFactory.getDriver().get(testURL);

        String title = WebDriverFactory.getDriver().getTitle();

        System.out.println("Page Title: " + title);

        Assert.assertEquals(title, "IntegriVideo - Video components for your website[DELETEME]", "Title s");
    }

    @AfterMethod
    public void teardownTest(){
        WebDriverFactory.getDriver().quit();
    }
}
