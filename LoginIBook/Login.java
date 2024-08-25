package LoginIBook;

import Base.ConfigData;
import Base.CoreUI;
import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Base.ConfigData.readTestObjectsFromJson;

public class Login {
    public static ConfigData.TestObject[] input = readTestObjectsFromJson("src/LoginIbook/account.json");
    public static String forgetPasswordXpath = "(//a[contains(text(),'Quên mật khẩu?')])[1]";
    public static String registerLinkXpath = "(//a[contains(text(),'Đăng ký')])[1]";
    public static String homePageBtnXpath = "//a[@id='logo']";
    public  static  String rememberAccCheckboxXpath = "//input[@id='remember_me']";
    private static WebDriver driver;
    public By notionUser = By.id("//p[@class='error']");
    public By notionPass = By.id("//p[@class='error']");

    public Login(WebDriver driver) {
        Login.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public static void goToLoginPage(){
        driver.get(ConfigData.URL);
        CoreUI.sleep(3);
    }

    public static void setUsername(int i){
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.clear();
        CoreUI.sleep(1);
        username.sendKeys(input[i].username);
    }

    public static void setPassWord(int i){
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.clear();
        CoreUI.sleep(1);
        password.sendKeys(input[i].password);
    }

    public static void clickBtnSubmit(){
        driver.findElement(By.xpath("//input[@id='btn_login']")).click();
        CoreUI.sleep(2);
    }

    public static void clickForgetPassword() {
        driver.findElement(By.xpath(forgetPasswordXpath)).click();
        CoreUI.sleep(3);
    }


    public static void clickRememberAcc() {
        driver.findElement(By.xpath(rememberAccCheckboxXpath)).click();
        CoreUI.sleep(3);
    }

    public static void login(int i){
        TestBase.Login_IBook(input[i].username, input[i].password);
        CoreUI.sleep(2);
    }
}
