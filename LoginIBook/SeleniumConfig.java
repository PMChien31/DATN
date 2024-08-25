package LoginIBook;

import Base.ConfigData;
import com.google.gson.Gson;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.json.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import static Base.ConfigData.readTestObjectsFromJson;

public class SeleniumConfig {
    protected WebDriver driver;
    protected String jsonfilepath1 = "src/LoginIbook/account.json";
    protected String chromedriverfilePath = "C:\\Users\\thanh\\IdeaProjects\\DoAn\\chromedriver.exe";
    protected String URL = "http://localhost/ibook/?mod=users&action=login";
    ConfigData.TestObject[] account = readTestObjectsFromJson(jsonfilepath1);
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
    public ConfigData.TestObject[] readTestObjectsFromJson(String filepath) {
        try {
            //Read file JSON
            FileReader reader = new FileReader(filepath);

            //Parse JSON string
            Gson gson = new Gson();
            TypeToken<ConfigData.TestObject[]> token = new TypeToken<ConfigData.TestObject[]>() {};
            ConfigData.TestObject[] testObjects = gson.fromJson(reader, token.getType());
            reader.close();
            return testObjects;
        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
            return new ConfigData.TestObject[0];
        }
    }
    static class TestObject {
        protected String username;
        protected String password;
        protected String group;
        protected String title;
        protected String description;
        protected int totalTurn;
        protected String question;
        protected String choice1;
        protected String choice2;
        protected String choice3;
        protected String choice4;
    }
    protected void Login(int i) throws InterruptedException {
        driver.navigate().to(ConfigData.URL);
        Thread.sleep(1000);
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.clear();
        Thread.sleep(1000);
        username.sendKeys(account[i].username);

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.clear();
        Thread.sleep(1000);
        password.sendKeys(account[i].password);
        driver.findElement(By.xpath("//input[@id='btn_login']")).click();
    }
    protected void searchTitle(String title) {
        WebElement suggestTitle = driver.findElement(By.id("page-title"));
        suggestTitle.sendKeys(title);
        suggestTitle.submit();
    }
    protected void Goto_Home() throws InterruptedException {
        driver.navigate().to("http://localhost/ibook/?");
        Thread.sleep(2000);
    }
    protected void Goto_Blog() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='?mod=blog']"));
        Thread.sleep(2000);
    }
    protected void Goto_Introduction() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Giới thiệu')]"));
        Thread.sleep(2000);
    }
    protected void Goto_Product() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Sản phẩm')]"));
        Thread.sleep(2000);
    }
    protected void Goto_Contact() throws InterruptedException {
        driver.findElement(By.xpath("//ul[@id='main-menu']//a[contains(text(),'Liên hệ')]"));
        Thread.sleep(2000);
    }
}
