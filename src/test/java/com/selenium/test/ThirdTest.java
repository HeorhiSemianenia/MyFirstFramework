package com.selenium.test;

import com.selenium.test.listeners.ScreenShotOnFailListener;
import com.selenium.test.pages.ChatPage;
import com.selenium.test.pages.DashboardPage;
import com.selenium.test.pages.LoginPage;
import com.selenium.test.webtestbase.WebDriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ScreenShotOnFailListener.class})
public class ThirdTest {

    @BeforeMethod
    public void setupTest() {
        WebDriverFactory.startBrowser();
    }

    @Test
    public void firstTest() {
        ChatPage loginPage = new ChatPage();
        String title1 = WebDriverFactory.getDriver().getTitle();
        System.out.println("Page Title: " + title1);
        Assert.assertEquals(title1, "IntegriVideo - Video components for your website", "Title s");
        loginPage.addMessage("Hello Automation testing");
    }

    @AfterMethod
    public void teardownTest(){
        WebDriverFactory.finishBrowser();
    }
}
