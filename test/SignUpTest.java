package test;
import Base.ConfigData;
import Base.CoreUI;
import Base.TestBase;
import IBook.HomePage;
import IBook.Order;
import IBook.SignUp;
import LoginIBook.Login;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static Base.ConfigData.readTestObjectsFromJson;
public class SignUpTest extends TestBase {
    @BeforeClass
    public void initializePages() {
        Login loginPage = new Login(driver);
        CoreUI coreUI = new CoreUI(driver);
    }

    private static int methodCount;

    @Test(priority = 1, description = "TC_1")
    protected void DK_01() {
        driver.navigate().to(ConfigData.URL);
        driver.findElement(By.xpath("//a[2]")).click();
        String currentURL = "http://localhost/ibook/?mod=users&action=reg";
        String expectedSubstring = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains(expectedSubstring), "URL does not contain expected substring:" + expectedSubstring);
    }

    @Test(priority = 2, description = "TC_1")
    protected void DK_02() {
        driver.navigate().to(ConfigData.URL);
        driver.findElement(By.xpath("//a[2]")).click();
        String currentURL = "http://localhost/ibook/?mod=users&action=reg";
        String expectedSubstring = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains(expectedSubstring), "URL does not contain expected substring:" + expectedSubstring);
    }

    @Test(priority = 3, description = "")
    public void DK_3() {
        driver.navigate().to(ConfigData.URL);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//a[2]")).click();
        methodCount = 1;
        int i = 1;
        SignUp.signup(i);
        driver.findElement(By.xpath("//input[@id='btn-reg']")).click();
        CoreUI.sleep(1);
        String[] errorMessage = {
                "Không được để trống họ tên",
                "Không được để trống email",
                "Không được để trống tên đăng nhập",
                "Không được để trống mật khẩu"
        };
        for (String message : errorMessage) {
            CoreUI.softAssert.assertTrue(CoreUI.checkErrorMessageDisplayed(message));
        }
        CoreUI.softAssert.assertAll();
    }

    @Test(priority = 4, description = "")
    public void DK_4() {
        driver.navigate().to(ConfigData.URL);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//a[2]")).click();
        methodCount = 2;
        int i = 2;
        SignUp.signup(i);
        driver.findElement(By.xpath("//input[@id='btn-reg']")).click();
        CoreUI.sleep(1);
        String[] errorMessage = {
                "Họ tên không đúng định dạng",
                "Email không đúng định dạng",
                "Tên tài khoản không đúng định dạng",
                "Mật khẩu không đúng định dạng"
        };
        for (String message : errorMessage) {
            CoreUI.softAssert.assertTrue(CoreUI.checkErrorMessageDisplayed(message));
        }
        CoreUI.softAssert.assertAll();
    }

    @Test(priority = 5, description = "")
    public void DK_5() {
        driver.navigate().to(ConfigData.URL);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//a[2]")).click();
        methodCount = 3;
        int i = 3;
        SignUp.signup(i);
        driver.findElement(By.xpath("//input[@id='btn-reg']")).click();
        CoreUI.sleep(1);
        String[] errorMessage = {
                "Họ tên không vượt quá 255 ký tự",
                "Email không đúng định dạng",
        };
        for (String message : errorMessage) {
            CoreUI.softAssert.assertTrue(CoreUI.checkErrorMessageDisplayed(message));
        }
        CoreUI.softAssert.assertAll();
    }

    @Test(priority = 6, description = "")
    public void DK_6() {
        driver.navigate().to(ConfigData.URL);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//a[2]")).click();
        methodCount = 4;
        int i = 4;
        SignUp.signup(i);
        driver.findElement(By.xpath("//input[@id='btn-reg']")).click();
        CoreUI.sleep(1);
        String[] errorMessage = {
                "Email không đúng định dạng",
        };
        for (String message : errorMessage) {
            CoreUI.softAssert.assertTrue(CoreUI.checkErrorMessageDisplayed(message));
        }
        CoreUI.softAssert.assertAll();
    }

    @Test(priority = 7, description = "")
    public void DK_7() {
        driver.navigate().to(ConfigData.URL);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//a[2]")).click();
        methodCount = 5;
        int i = 5;
        SignUp.signup(i);
        driver.findElement(By.xpath("//input[@id='btn-reg']")).click();
        CoreUI.sleep(1);
        String[] errorMessage = {
                "Email không đúng định dạng",
        };
        for (String message : errorMessage) {
            CoreUI.softAssert.assertTrue(CoreUI.checkErrorMessageDisplayed(message));
        }
        CoreUI.softAssert.assertAll();
    }

    @Test(priority = 8, description = "")
    public void DK_8() {
        driver.navigate().to(ConfigData.URL);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//a[2]")).click();
        methodCount = 6;
        int i = 6;
        SignUp.signup(i);
        driver.findElement(By.xpath("//input[@id='btn-reg']")).click();
        CoreUI.sleep(1);
        String[] errorMessage = {
                "Tên tài khoản không vượt quá 255 ký tự",
        };
        for (String message : errorMessage) {
            CoreUI.softAssert.assertTrue(CoreUI.checkErrorMessageDisplayed(message));
        }
        CoreUI.softAssert.assertAll();
    }

    @Test(priority = 9, description = "")
    public void DK_9() {
        driver.navigate().to(ConfigData.URL);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//a[2]")).click();
        methodCount = 7;
        int i = 7;
        SignUp.signup(i);
        driver.findElement(By.xpath("//input[@id='btn-reg']")).click();
        CoreUI.sleep(1);
        String[] errorMessage = {
                "Tên tài khoản phải lớn hơn 6 ký tự",
        };
        for (String message : errorMessage) {
            CoreUI.softAssert.assertTrue(CoreUI.checkErrorMessageDisplayed(message));
        }
        CoreUI.softAssert.assertAll();
    }

    @Test(priority = 10, description = "")
    public void DK_10() {
        driver.navigate().to(ConfigData.URL);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//a[2]")).click();
        methodCount = 8;
        int i = 8;
        SignUp.signup(i);
        driver.findElement(By.xpath("//input[@id='btn-reg']")).click();
        CoreUI.sleep(1);
        String[] errorMessage = {
                "Email đã được đăng ký tài khoản. Vui lòng nhập email khác",
        };
        for (String message : errorMessage) {
            CoreUI.softAssert.assertTrue(CoreUI.checkErrorMessageDisplayed(message));
        }
        CoreUI.softAssert.assertAll();
    }

    @Test(priority = 11, description = "")
    public void DK_11() {
        driver.navigate().to(ConfigData.URL);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//a[2]")).click();
        methodCount = 9;
        int i = 9;
        SignUp.signup(i);
        driver.findElement(By.xpath("//input[@id='btn-reg']")).click();
        CoreUI.sleep(1);
        String[] errorMessage = {
                "Đăng ký thành công",
        };
        for (String message : errorMessage) {
            CoreUI.softAssert.assertTrue(CoreUI.checkErrorMessageDisplayed(message));
        }
        CoreUI.softAssert.assertAll();
        String currentURL = driver.getCurrentUrl();
        String expectedSubstring = "http://localhost/ibook/?mod=users&action=login";
        Assert.assertTrue(currentURL.contains(expectedSubstring), "URL does not contain expected substring:" + expectedSubstring);
    }

    @Test(priority = 12, description = "")
    public void DK_12() {
        driver.navigate().to(ConfigData.URL);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//a[2]")).click();
        methodCount = 10;
        int i = 10;
        SignUp.signup(i);
        driver.findElement(By.xpath("//input[@id='btn-reg']")).click();
        CoreUI.sleep(1);
        String[] errorMessage = {
                "Email không vượt quá 64 ký tự",
        };
        for (String message : errorMessage) {
            CoreUI.softAssert.assertTrue(CoreUI.checkErrorMessageDisplayed(message));
        }
        CoreUI.softAssert.assertAll();
    }
}
