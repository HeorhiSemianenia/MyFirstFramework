package com.selenium.test.pages;

import com.selenium.test.utils.TimeUtils;
import com.selenium.test.webtestbase.BasePage;
import com.selenium.test.webtestbase.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ChatPage extends BasePage {
    private static final String CHAT_PAGE_URL = "https://dev.integrivideo.com/demo/chat/new";

    @FindBy(xpath = "//button[@class='btn']/span")
    private WebElement statisticsTitle;

    private static final String inputMessageFieldCSS = "integri-chat-input textarea";

    @FindBy(xpath = "//div[@class='integri-chat-action-buttons']//span[contains(@class,'plane')]")
    private WebElement sendMessageButton;

    @FindBy(xpath = "//button[contains(text(),'Invite')]")
    private WebElement inviteUsersButton;

    @FindBy(css = "code.component-code")
    private WebElement copyCodeArea;

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
        TimeUtils.waitForSeconds(2);
        jse.executeScript(String.format("document.querySelector(\".%s\").value=\"%s\"", inputMessageFieldCSS, text));
        sendMessageButton.click();
        TimeUtils.waitForSeconds(4);
    }

    public String copyLink(){
        inviteUsersButton.click();
        String clipboard = null;
        try {
            clipboard = (String) Toolkit.getDefaultToolkit()
                    .getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clipboard;
    }

    public String сopyMarkup(){
        int width = copyCodeArea.getSize().getWidth();
        int height = copyCodeArea.getSize().getHeight();
        Actions actions = new Actions(WebDriverFactory.getDriver());
        actions.moveToElement(copyCodeArea).moveByOffset(width/2,height/2).click().perform();
        String clipboard = null;
        try {
            clipboard = (String) Toolkit.getDefaultToolkit()
                    .getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clipboard;
    }
}
