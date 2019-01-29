package com.selenium.test;

import com.selenium.test.listeners.ScreenShotOnFailListener;
import com.selenium.test.pages.DashboardPage;
import com.selenium.test.pages.LoginPage;
import com.selenium.test.webtestbase.WebDriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ScreenShotOnFailListener.class})
public class SecondTest {

    public String testURL = "https://dev.integrivideo.com/demo/chat/new";

    @BeforeMethod
    public void setupTest() {
        WebDriverFactory.startBrowser();
    }

    @Test
    public void firstTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage();

        String title1 = WebDriverFactory.getDriver().getTitle();

        System.out.println("Page Title: " + title1);

        Assert.assertEquals(title1, "IntegriVideo - Video components for your website", "Title s");

        DashboardPage dashboardPage = loginPage.loginInto();

        String title2 = WebDriverFactory.getDriver().getTitle();

        Assert.assertEquals(title2, "IntegriVideo - Video components for your website", "Title s");
    }

    @AfterMethod
    public void teardownTest(){
        WebDriverFactory.finishBrowser();
    }
}
