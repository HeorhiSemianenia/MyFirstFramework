package com.selenium.test.pages;

import com.selenium.test.webtestbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    private static final String LOGIN_PAGE_URL = "https://dev.integrivideo.com/app/projects";

    @FindBy(xpath = "//div[@id='statistics-column']/h2")
    private WebElement statisticsTitle;

    public DashboardPage(){
        super(false);
    }

    @Override
    protected void openPage() {
        getDriver().get(LOGIN_PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return statisticsTitle.isDisplayed();
    }
}
