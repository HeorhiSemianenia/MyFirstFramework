package com.selenium.test.pages;

import com.selenium.test.utils.TimeUtils;
import com.selenium.test.utils.TimeUtilsNew;
import com.selenium.test.webtestbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChatPage extends BasePage {

    private static final String CHAT_PAGE_URL = "https://dev.integrivideo.com/demo/chat/new";

    @FindBy(xpath = "//button[@class='btn']/span")
    private WebElement statisticsTitle;

    @FindBy(xpath = "//div[@class='integri-chat-input']//textarea")
    private WebElement inputMessageField;

    @FindBy(xpath = "//div[@class='integri-chat-action-buttons']//span[contains(@class,'plane')]")
    private WebElement sendMessageButton;

    public ChatPage(){
        super(true);
    }

    @Override
    protected void openPage() {
        getDriver().get(CHAT_PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return statisticsTitle.isDisplayed();
    }

    public void addMessage(String text){
        inputMessageField.sendKeys(text);
        sendMessageButton.click();
        TimeUtilsNew.waitForSeconds(4);
    }
}
