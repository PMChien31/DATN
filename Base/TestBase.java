package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestBase {
 protected static WebDriver driver;

 @BeforeClass
 @Parameters({"browser"})
 public void setUp(@Optional("chrome") String browserName) {
   switch (browserName.toLowerCase()) {
    case "chrome":
     driver = new ChromeDriver();
     break;
    case "edge":
     driver = new EdgeDriver();
     break;
    case "firefox":
     driver = new FirefoxDriver();
     break;
    default:
     throw new IllegalArgumentException("Unsupported browser: " + browserName);
   }

  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
 }

 @AfterClass
 public static void afterClass(){
  driver.close();
 }

 public WebDriver getDriver() {
  return driver;
 }

 public static void setUsername(String username){
  By inputUsername = By.xpath("//input[@id='username']");
  CoreUI.waitForElementVisible(inputUsername);
  WebElement setUsername = driver.findElement(inputUsername);
  CoreUI.sleep(2);
  setUsername.clear();
  CoreUI.sleep(2);
  setUsername.sendKeys(username);
  CoreUI.sleep(2);
 }

 public static void setPassword(String password){
  By inputPassword = By.xpath("//input[@id='password']");
  CoreUI.waitForElementVisible(inputPassword);
  WebElement setPassword = driver.findElement(inputPassword);
  setPassword.clear();
  setPassword.sendKeys(password);
 }

 public static void clickBtnLogin(){
  By submit = By.xpath("//input[@id='btn_login']");
  CoreUI.waitForElementVisible(submit);
  driver.findElement(submit).click();
  CoreUI.sleep(3);
 }


 public static void Login_IBook(String username, String password){
  driver.navigate().to(ConfigData.URL);
  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

  setUsername(username);
  setPassword(password);
  clickBtnLogin();
 }


 public static void logout_IBook() {
  By logout = By.xpath("//a[contains(text(),'Đăng xuất')]");
  CoreUI.waitForElementVisible(logout);
  driver.findElement(logout).click();
  CoreUI.sleep(5);
 }
}
