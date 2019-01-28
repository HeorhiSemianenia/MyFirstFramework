import com.selenium.test.webtestbase.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

        Assert.assertEquals(title, "IntegriVideo - Video components for your website", "Title s");
    }

    @AfterMethod
    public void teardownTest(){
        WebDriverFactory.getDriver().quit();
    }
}
