package IBook;
import Base.ConfigData;
import com.google.gson.Gson;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.json.TypeToken;
import org.testng.Assert;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import static Base.ConfigData.readTestObjectsFromJson;
public class SeleniumConfig {
    protected WebDriver driver;
    protected String chromedriverfilePath = "C:\\Users\\thanh\\IdeaProjects\\DoAn\\chromedriver.exe";
    protected String URL = "http://localhost/ibook/?mod=users&action=login";
    protected SeleniumConfig(){
        System.setProperty("webdriver.chrome.driver", chromedriverfilePath);
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_setting.popups", 0);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get(URL);

        this.driver = driver;
    }
    protected void verifyElementDisplay(String xpath_Element) throws InterruptedException {
        boolean Element;
        try {
            Element = driver.findElement(By.xpath("" + xpath_Element + "")).isDisplayed();
        } catch (NoSuchElementException e) {
            Element = false;
        }
        Assert.assertTrue(Element, xpath_Element);
        Thread.sleep(1000);
    }
    protected void verifyElementNotDisplayed(String xpath_Element) throws InterruptedException {
        boolean Element;
        try {
            Element = driver.findElement(By.xpath("" + xpath_Element + "")).isDisplayed();
        } catch (NoSuchElementException e) {
            Element = false;
        }
        Assert.assertFalse(Element, xpath_Element);
        Thread.sleep(1000);
    }
}
