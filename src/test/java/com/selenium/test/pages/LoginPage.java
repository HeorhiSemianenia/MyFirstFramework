package com.selenium.test.pages;

import com.selenium.test.utils.TimeUtils;
import com.selenium.test.utils.TimeUtilsNew;
import com.selenium.test.webtestbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private static final String LOGIN_PAGE_URL = "https://dev.integrivideo.com/login";

    @FindBy(xpath = "//div[@class='logo']//img")
    private WebElement logo;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement password;

    @FindBy(xpath = "//button/i")
    private WebElement loginButton;

    public LoginPage(){
        super(true);
    }

    @Override
    public void openPage() {
        getDriver().get(LOGIN_PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return logo.isDisplayed();
    }

    public DashboardPage loginInto(){
        email.sendKeys("integriuser2@mailinator.com");
        password.sendKeys("integripassword");
        TimeUtilsNew.waitForSeconds(4);
        loginButton.click();
        TimeUtilsNew.waitForSeconds(4);
        return new DashboardPage();
    }
}
