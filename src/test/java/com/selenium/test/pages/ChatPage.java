package com.selenium.test.pages;

import com.selenium.test.utils.TimeUtils;
import com.selenium.test.utils.TimeUtilsNew;
import com.selenium.test.webtestbase.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ChatPage extends BasePage {

    private static final String CHAT_PAGE_URL = "https://dev.integrivideo.com/demo/chat/new";

    @FindBy(xpath = "//button[@class='btn']/span")
    private WebElement statisticsTitle;

    private static final String inputMessageFieldCSS = "integri-chat-input textarea";

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
        JavascriptExecutor jse = (JavascriptExecutor) super.getDriver();
        TimeUtilsNew.waitForSeconds(2);
        jse.executeScript(String.format("document.querySelector(\".%s\").value=\"%s\"", inputMessageFieldCSS, text));
        sendMessageButton.click();
        TimeUtilsNew.waitForSeconds(4);
    }
}
