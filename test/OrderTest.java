package test;
import Base.ConfigData;
import Base.CoreUI;
import Base.TestBase;
import IBook.HomePage;
import IBook.Order;
import IBook.OrderConfig;
import IBook.PayMent;
import LoginIBook.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Base.CoreUI;
import LoginIBook.Login;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.support.ui.Select;
import java.util.Arrays;
import java.util.List;
public class OrderTest extends TestBase {
    private static int methodCount;

    @BeforeClass
    public void initializePages() {
        Login loginPage = new Login(driver);
        CoreUI coreUI = new CoreUI(driver);
    }

    @Test(priority = 1, description = "")
    public void TT_1() {
        Login.login(4);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("(//a[@title='Thêm giỏ hàng'][contains(text(),'Thêm giỏ hàng')])[16]")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//a[@id='checkout-cart']")).click();
        methodCount = 1;
        int i = 1;
        Order.order(i);
        driver.findElement(By.xpath("//input[@id='payment-home']")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//input[@id='order-now']")).click();
        String[] errorMessage = {
                "Không được để trống họ và tên",
                "Không được để trống email",
                "Không được để trống địa chỉ",
                "Không được để trống số điện thoại"
        };
        for (String message : errorMessage) {
            CoreUI.softAssert.assertTrue(CoreUI.checkErrorMessageDisplayed(message));
        }
        CoreUI.softAssert.assertAll();
    }

    @Test(priority = 2, description = "")
    public void TT_2() {
        Login.login(4);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("(//a[@title='Thêm giỏ hàng'][contains(text(),'Thêm giỏ hàng')])[16]")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//a[@id='checkout-cart']")).click();
        methodCount = 2;
        int i = 2;
        Order.order(i);
        driver.findElement(By.xpath("//input[@id='payment-home']")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//input[@id='order-now']")).click();
        String[] errorMessage = {
                "Không được để trống họ và tên",
                "Không được để trống email",
                "Không được để trống địa chỉ",
                "Không được để trống số điện thoại"
        };
        for (String message : errorMessage) {
            CoreUI.softAssert.assertTrue(CoreUI.checkErrorMessageDisplayed(message));
        }
        CoreUI.softAssert.assertAll();
    }

    @Test(priority = 3, description = "")
    public void TT_3() {
        Login.login(4);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("(//a[@title='Thêm giỏ hàng'][contains(text(),'Thêm giỏ hàng')])[16]")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//a[@id='checkout-cart']")).click();
        methodCount = 3;
        int i = 3;
        Order.order(i);
        driver.findElement(By.xpath("//input[@id='payment-home']")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//input[@id='order-now']")).click();
        CoreUI.sleep(1);
        CoreUI.verifyElementDisplay("//h1[contains(text(),'Đặt hàng thành công')]");
    }

    @Test(priority = 4, description = "")
    public void TT_4() {
        Login.login(4);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("(//a[@title='Thêm giỏ hàng'][contains(text(),'Thêm giỏ hàng')])[16]")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//a[@id='checkout-cart']")).click();
        methodCount = 4;
        int i = 4;
        Order.order(i);
        driver.findElement(By.xpath("//input[@id='payment-home']")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//input[@id='order-now']")).click();
        String[] errorMessage = {
                "Mail không đúng định dạng",
                "Số điện thoại không đúng định dạng"
        };
        for (String message : errorMessage) {
            CoreUI.softAssert.assertTrue(CoreUI.checkErrorMessageDisplayed(message));
        }
        CoreUI.softAssert.assertAll();
    }

    @Test(priority = 5, description = "")
    public void TT_5() {
        Login.login(4);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("(//a[@title='Thêm giỏ hàng'][contains(text(),'Thêm giỏ hàng')])[16]")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//a[@id='checkout-cart']")).click();
        methodCount = 5;
        int i = 5;
        Order.order(i);
        driver.findElement(By.xpath("//input[@id='payment-home']")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//input[@id='order-now']")).click();
        String[] errorMessage = {
                "Mail không đúng định dạng",
                "Số điện thoại không đúng định dạng"
        };
        for (String message : errorMessage) {
            CoreUI.softAssert.assertTrue(CoreUI.checkErrorMessageDisplayed(message));
        }
        CoreUI.softAssert.assertAll();
    }

    @Test(priority = 6, description = "")
    public void TT_6() {
        Login.login(4);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("(//a[@title='Thêm giỏ hàng'][contains(text(),'Thêm giỏ hàng')])[16]")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//a[@id='checkout-cart']")).click();
        methodCount = 6;
        int i = 6;
        Order.order(i);
        driver.findElement(By.xpath("//input[@id='payment-home']")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//input[@id='order-now']")).click();
        String[] errorMessage = {
                "Mail không đúng định dạng",
        };
        for (String message : errorMessage) {
            CoreUI.softAssert.assertTrue(CoreUI.checkErrorMessageDisplayed(message));
        }
        CoreUI.softAssert.assertAll();
    }

    @Test(priority = 7, description = "")
    public void TT_7() {
        Login.login(4);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("(//a[@title='Thêm giỏ hàng'][contains(text(),'Thêm giỏ hàng')])[16]")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//a[@id='checkout-cart']")).click();
        methodCount = 7;
        int i = 7;
        Order.order(i);
        driver.findElement(By.xpath("//input[@id='payment-home']")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//input[@id='order-now']")).click();
        String[] errorMessage = {
                "Mail không đúng định dạng",
        };
        for (String message : errorMessage) {
            CoreUI.softAssert.assertTrue(CoreUI.checkErrorMessageDisplayed(message));
        }
        CoreUI.softAssert.assertAll();
    }

    @Test(priority = 8, description = "")
    public void TT_8() {
        Login.login(4);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("(//a[@title='Thêm giỏ hàng'][contains(text(),'Thêm giỏ hàng')])[16]")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//a[@id='checkout-cart']")).click();
        methodCount = 8;
        int i = 8;
        Order.order(i);
        driver.findElement(By.xpath("//input[@id='payment-home']")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//input[@id='order-now']")).click();
        String[] errorMessage = {
                "Mail không đúng định dạng",
        };
        for (String message : errorMessage) {
            CoreUI.softAssert.assertTrue(CoreUI.checkErrorMessageDisplayed(message));
        }
        CoreUI.softAssert.assertAll();
    }

    @Test(priority = 9, description = "")
    public void TT_9() {
        Login.login(4);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("(//a[@title='Thêm giỏ hàng'][contains(text(),'Thêm giỏ hàng')])[16]")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//a[@id='checkout-cart']")).click();
        methodCount = 9;
        int i = 9;
        Order.order(i);
        driver.findElement(By.xpath("//input[@id='payment-home']")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//input[@id='order-now']")).click();
        String[] errorMessage = {
                "Họ và tên không quá 255 ký tự",
                "Mail không đúng định dạng",
                "Địa chị không quá 255 ký tự"
        };
        for (String message : errorMessage) {
            CoreUI.softAssert.assertTrue(CoreUI.checkErrorMessageDisplayed(message));
        }
        CoreUI.softAssert.assertAll();
    }

    @Test(priority = 10, description = "")
    public void TT_10() {
        Login.login(4);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("(//a[@title='Thêm giỏ hàng'][contains(text(),'Thêm giỏ hàng')])[16]")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//a[@id='checkout-cart']")).click();
        methodCount = 10;
        int i = 10;
        Order.order(i);
        driver.findElement(By.xpath("//input[@id='payment-home']")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//input[@id='order-now']")).click();
        String[] errorMessage = {
                "Mail không đúng định dạng",
        };
        for (String message : errorMessage) {
            CoreUI.softAssert.assertTrue(CoreUI.checkErrorMessageDisplayed(message));
        }
        CoreUI.softAssert.assertAll();
    }

    @Test(priority = 11, description = "")
    public void TT_11() {
        Login.login(4);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("(//a[@title='Thêm giỏ hàng'][contains(text(),'Thêm giỏ hàng')])[16]")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//a[@id='checkout-cart']")).click();
        methodCount = 3;
        int i = 3;
        Order.order(i);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//input[@id='order-now']")).click();
        CoreUI.sleep(1);
        String[] errorMessage = {
                "Vui lòng chọn phương thức thanh toán",
        };
        for (String message : errorMessage) {
            CoreUI.softAssert.assertTrue(CoreUI.checkErrorMessageDisplayed(message));
        }
        CoreUI.softAssert.assertAll();
    }

    @Test(priority = 12, description = "")
    public void TT_12() {
        Login.login(4);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("(//a[@title='Thêm giỏ hàng'][contains(text(),'Thêm giỏ hàng')])[16]")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//a[@id='checkout-cart']")).click();
        methodCount = 3;
        int i = 3;
        Order.order(i);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//input[@name='atm']")).click();
        String currentURL = driver.getCurrentUrl();
        String expectedSubstring = "https://test-payment.momo.vn/v2/gateway/pay?t=";
        Assert.assertTrue(currentURL.contains(expectedSubstring), "URL does not contain expected substring:" + expectedSubstring);
        driver.findElement(By.xpath("//input[@id='card-number']")).sendKeys("9704 0000 0000 0018");
        driver.findElement(By.xpath("//input[@id='card-expire']")).sendKeys("0307");
        driver.findElement(By.xpath("//input[@id='card-name']")).sendKeys("NGUYEN VAN A");
        driver.findElement(By.xpath("//input[@id='number-phone']")).sendKeys("0958473658");
        driver.findElement(By.xpath("//button[@id='btn-pay-card']")).click();
        driver.findElement(By.xpath("//input[@id='napasOtpCode']")).sendKeys("OTP");
        driver.findElement(By.xpath("//button[@id='napasProcessBtn1']")).click();
        Assert.assertEquals(currentURL,"http://localhost/ibook/");
    }

    @Test(priority = 13, description = "")
    public void TT_13() {
        Login.login(4);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("(//a[@title='Thêm giỏ hàng'][contains(text(),'Thêm giỏ hàng')])[16]")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//a[@id='checkout-cart']")).click();
        methodCount = 3;
        int i = 3;
        Order.order(i);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//input[@name='atm']")).click();
        String currentURL = driver.getCurrentUrl();
        String expectedSubstring = "https://test-payment.momo.vn/v2/gateway/pay?t=";
        Assert.assertTrue(currentURL.contains(expectedSubstring), "URL does not contain expected substring:" + expectedSubstring);
        driver.findElement(By.xpath("//input[@id='card-number']")).sendKeys("9704 0000 0000 0000");
        driver.findElement(By.xpath("//input[@id='card-expire']")).sendKeys("1210");
        driver.findElement(By.xpath("//input[@id='card-name']")).sendKeys("NGUYEN VAN A");
        driver.findElement(By.xpath("//input[@id='number-phone']")).sendKeys("0958473658");
        driver.findElement(By.xpath("//button[@id='btn-pay-card']")).click();
        String[] errorMessage = {
                "Tên chủ thẻ không chính xác. Quý khách vui lòng kiểm tra lại thông tin.",
                "Thời gian hết hạn thẻ không đúng.",
        };
        for (String message : errorMessage) {
            CoreUI.softAssert.assertTrue(CoreUI.checkErrorMessageDisplayed(message));
        }
        CoreUI.softAssert.assertAll();
    }

    @Test(priority = 14, description = "")
    public void TT_14() {
        Login.login(4);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("(//a[@title='Thêm giỏ hàng'][contains(text(),'Thêm giỏ hàng')])[16]")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//a[@id='checkout-cart']")).click();
        methodCount = 1;
        int i = 1;
        Order.order(i);
        driver.findElement(By.xpath("//input[@name='momo']")).click();
        CoreUI.sleep(1);
        String[] errorMessage = {
                "Không được để trống họ và tên",
                "Không được để trống email",
                "Không được để trống địa chỉ",
                "Không được để trống số điện thoại"
        };
        for (String message : errorMessage) {
            CoreUI.softAssert.assertTrue(CoreUI.checkErrorMessageDisplayed(message));
        }
        CoreUI.softAssert.assertAll();
    }

    @Test(priority = 15, description = "")
    public void TT_15() {
        Login.login(4);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("(//a[@title='Thêm giỏ hàng'][contains(text(),'Thêm giỏ hàng')])[16]")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//a[@id='checkout-cart']")).click();
        methodCount = 1;
        int i = 1;
        Order.order(i);
        driver.findElement(By.xpath("//input[@name='atm']")).click();
        CoreUI.sleep(1);
        String[] errorMessage = {
                "Không được để trống họ và tên",
                "Không được để trống email",
                "Không được để trống địa chỉ",
                "Không được để trống số điện thoại"
        };
        for (String message : errorMessage) {
            CoreUI.softAssert.assertTrue(CoreUI.checkErrorMessageDisplayed(message));
        }
        CoreUI.softAssert.assertAll();
    }

    @Test(priority = 16, description = "")
    public void TT_16() {
        Login.login(4);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("(//a[@title='Thêm giỏ hàng'][contains(text(),'Thêm giỏ hàng')])[16]")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//a[@id='checkout-cart']")).click();
        methodCount = 3;
        int i = 3;
        Order.order(i);
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//input[@name='momo']")).click();
        String currentURL = driver.getCurrentUrl();
        String expectedSubstring = "https://test-payment.momo.vn/v2/gateway/pay?t=";
        Assert.assertTrue(currentURL.contains(expectedSubstring), "URL does not contain expected substring:" + expectedSubstring);
    }
}
