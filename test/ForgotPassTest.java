package test;
import Base.ConfigData;
import Base.CoreUI;
import Base.TestBase;
import IBook.HomePage;
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
public class ForgotPassTest extends TestBase {
    @BeforeClass
    public void initializePages() {
        Login loginPage = new Login(driver);
        CoreUI coreUI = new CoreUI(driver);
    }

    @Test(priority=1, description="TC_2")
    protected void Blog_01(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        CoreUI.clickMenuBlog();
        CoreUI.sleep(2);
        CoreUI.verifyElementNotDisplayed("//a[contains(text(),'Trước')]");
        CoreUI.verifyElementDisplay("//a[normalize-space()='Sau']");
        driver.findElement(By.xpath("//a[contains(text(),'Doanh nghiệp EU tìm kiếm cơ hội hợp tác đầu tư côn')]")).click();
    }


    @Test(priority = 1, description = "TC_1")
    protected void QMK_01() {
        driver.navigate().to(ConfigData.URL);
        CoreUI.verifyElementDisplay("//a[1]");
        driver.findElement(By.xpath("//a[1]")).click();
        String currentURL = "http://localhost/ibook/?mod=users&action=reset";
        String expectedSubstring = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains(expectedSubstring), "URL does not contain expected substring:" + expectedSubstring);
    }

    @Test(priority = 2, description = "TC_1")
    protected void QMK_02() {
        driver.navigate().to(ConfigData.URL);
        CoreUI.verifyElementDisplay("//a[1]");
        driver.findElement(By.xpath("//a[1]")).click();
        CoreUI.verifyElementDisplay("//input[@id='username']");
        CoreUI.verifyElementDisplay("//input[@id='btn_login']");
        CoreUI.verifyElementDisplay("//a[1]");
        CoreUI.verifyElementDisplay("//a[1]");
    }

    @Test(priority = 3, description = "TC_1")
    protected void QMK_03() {
        driver.navigate().to(ConfigData.URL);
        CoreUI.verifyElementDisplay("//a[1]");
        driver.findElement(By.xpath("//a[1]")).click();
        WebElement email = driver.findElement(By.xpath("//input[@id='username']"));
        email.sendKeys("t@gmail.com");
        driver.findElement(By.xpath("//input[@id='btn_login']")).click();
        WebElement errorMessage = driver.findElement(By.xpath("//p[@class='error']"));
        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals("Email không đúng định dạng",actualErrorMessage);
    }

    @Test(priority = 4, description = "TC_1")
    protected void QMK_04() {
        driver.navigate().to(ConfigData.URL);
        CoreUI.verifyElementDisplay("//a[1]");
        driver.findElement(By.xpath("//a[1]")).click();
        WebElement email = driver.findElement(By.xpath("//input[@id='username']"));
        email.sendKeys("@gmail.com");
        driver.findElement(By.xpath("//input[@id='btn_login']")).click();
        WebElement errorMessage = driver.findElement(By.xpath("//p[@class='error']"));
        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals("Email không đúng định dạng",actualErrorMessage);
    }

    @Test(priority = 4, description = "TC_1")
    protected void QMK_05() {
        driver.navigate().to(ConfigData.URL);
        CoreUI.verifyElementDisplay("//a[1]");
        driver.findElement(By.xpath("//a[1]")).click();
        WebElement email = driver.findElement(By.xpath("//input[@id='username']"));
        email.sendKeys("tester..@gmail.com");
        driver.findElement(By.xpath("//input[@id='btn_login']")).click();
        WebElement errorMessage = driver.findElement(By.xpath("//p[@class='error']"));
        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals("Email không đúng định dạng",actualErrorMessage);
    }

    @Test(priority = 6, description = "TC_1")
    protected void QMK_06() {
        driver.navigate().to(ConfigData.URL);
        CoreUI.verifyElementDisplay("//a[1]");
        driver.findElement(By.xpath("//a[1]")).click();
        WebElement email = driver.findElement(By.xpath("//input[@id='username']"));
        email.sendKeys("hello@gmail.com");
        driver.findElement(By.xpath("//input[@id='btn_login']")).click();
        CoreUI.sleep(2);
        WebElement errorMessage = driver.findElement(By.xpath("//p[@class='error']"));
        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals("Email không tồn tại trên hệ thống",actualErrorMessage);
    }

    @Test(priority = 7, description = "TC_1")
    protected void QMK_07() {
        driver.navigate().to(ConfigData.URL);
        CoreUI.verifyElementDisplay("//a[1]");
        driver.findElement(By.xpath("//a[1]")).click();
        WebElement email = driver.findElement(By.xpath("//input[@id='username']"));
        email.sendKeys("tester@gmail.com");
        driver.findElement(By.xpath("//input[@id='btn_login']")).click();
        CoreUI.sleep(2);
        WebElement errorMessage = driver.findElement(By.xpath("//p[@class='error']"));
        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals("Hệ thống đã gửi thư xác nhận. Vui lòng truy cập email để xác nhận",actualErrorMessage);
    }
}
