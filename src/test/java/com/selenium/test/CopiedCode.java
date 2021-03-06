package com.selenium.test;

import com.selenium.test.listeners.ScreenShotOnFailListener;
import com.selenium.test.pages.ChatPage;
import com.selenium.test.webtestbase.WebDriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ScreenShotOnFailListener.class})
public class CopiedCode {

    @BeforeMethod
    public void setupTest() {
        WebDriverFactory.startBrowser();
    }

    @Test
    public void firstTest() {
        ChatPage chatPage = new ChatPage();
        Assert.assertTrue(chatPage.сopyMarkup().contains("https://dev.integrivideo.com/integri.js"), "Incorrect link");
    }

    @AfterMethod
    public void teardownTest(){
        WebDriverFactory.finishBrowser();
    }
}
