package test;
import Base.CoreUI;
import Base.TestBase;
import LoginIBook.Login;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
public class LoginTest extends TestBase {
    private static int methodCount;

    @BeforeClass
    public void initializePages() {
        Login loginPage = new Login(driver);
        CoreUI coreUI = new CoreUI(driver);
    }

    @Test(priority = 1, description = "")
    public void DN_1() {
        methodCount = 1;
        int i = 1;
        Login.login(i);
        String[] errorMessage = {
                "Không được để trống tên đăng nhập",
                "Không được để trống mật khẩu"
        };
        for (String message : errorMessage){
            CoreUI.softAssert.assertTrue(CoreUI.checkErrorMessageDisplayed(message));
        }
        CoreUI.softAssert.assertAll();
    }
    @Test(priority = 2, description = "")
    public void DN_2() {
        methodCount = 2; int i=2;
        Login.login(i);
        CoreUI.sleep(3);
        String[] errorMessage = {
                "Tên đăng nhập hoặc mật khẩu không tồn tại"
        };

        for (String message : errorMessage){
            CoreUI.softAssert.assertTrue(CoreUI.checkErrorMessageDisplayed(message));
        }
        CoreUI.softAssert.assertAll();
    }
    @Test(priority = 3, description = "")
    public void DN_3() {
        methodCount = 3; int i=3;
        Login.login(i);
        String[] errorMessage = {
                "Không được để trống mật khẩu"
        };

        for (String message : errorMessage){
            CoreUI.softAssert.assertTrue(CoreUI.checkErrorMessageDisplayed(message));
        }
        CoreUI.softAssert.assertAll();
    }
    @Test(priority = 4, description = "")
    public void DN_4() {
        methodCount = 4; int i=4;
        Login.login(i);
        CoreUI.sleep(3);
        Assert.assertEquals(CoreUI.getTitlePage(),"IBOOK STORE");
        CoreUI.sleep(4);
        TestBase.logout_IBook();
    }
    @Test(priority = 5, description = "")
    public void DN_5() {
        methodCount = 5; int i = 5;
        Login.goToLoginPage();
        Login.clickForgetPassword();
        Assert.assertEquals(CoreUI.getTitlePage(), "Khôi phục mật khẩu");
    }
    @Test(priority = 6, description = "")
    public void DN_6() {
        methodCount = 6; int i=4;
        Login.goToLoginPage();
        Login.setUsername(i);
        Login.setPassWord(i);
        Login.clickRememberAcc();
        Login.clickBtnSubmit();
        CoreUI.sleep(3);
        TestBase.logout_IBook();
        Login.goToLoginPage();
        Login.clickBtnSubmit();
        CoreUI.sleep(2);
        Assert.assertEquals(CoreUI.getTitlePage(),"IBOOK STORE");
    }
    @AfterMethod
    protected void afterMethod(){
        List<Integer> methodCounts = Arrays.asList(6);
        if(methodCounts.contains(methodCount)){
            driver.navigate().refresh();
            CoreUI.sleep(2);
            TestBase.logout_IBook();
        }
    }
}
