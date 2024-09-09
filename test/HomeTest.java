package test;
import Base.ConfigData;
import Base.CoreUI;
import Base.TestBase;
import IBook.HomePage;
import LoginIBook.Login;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static Base.ConfigData.readTestObjectsFromJson;

public class HomeTest extends TestBase {
    @BeforeClass
    public void initializePages() {
        Login loginPage = new Login(driver);
        CoreUI coreUI = new CoreUI(driver);
    }

    @Test(priority = 1, description = "TC_1")
    protected void getMenuTitle() {
        Login_IBook("admin111", "annguyen111");
        System.out.println("Đăng nhập trang " + CoreUI.getTitlePage() + " thành công");
        HomePage.checkMenuTitleDispalyed();

        CoreUI.verifyMenuTitle(driver, "//a[@id='payment-link']", "Hình thức thanh toán");
        CoreUI.verifyMenuTitle(driver, "//a[@href='?'][contains(text(),'Trang chủ')]", "Trang chủ");
        CoreUI.verifyMenuTitle(driver, "//a[contains(text(),'Sản phẩm')]", "Sản phẩm");
        CoreUI.verifyMenuTitle(driver, "//a[@href='?mod=blog']", "Blog");
        CoreUI.verifyMenuTitle(driver, "//a[contains(text(),'Giới thiệu')]", "Giới thiệu");
        CoreUI.verifyMenuTitle(driver, "//ul[@id='main-menu']//a[contains(text(),'Liên hệ')]", "Liên hệ");
        CoreUI.verifyMenuTitle(driver, "//a[contains(text(),'Đăng xuất')]", "Đăng xuất");

        System.out.println("Kiểm tra tiêu đề Menu thành công");
        CoreUI.verifyBestSellingProductListCount(driver, "//div[@id='feature-product-wp']//li", 10);
        System.out.println("Kiểm tra danh sách Sản phẩm nổi bật thành công");

    }

    @Test(priority=2, description="TC_2")
    protected void TK_01(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        CoreUI.testProductSearch("NHỮNG");
    }

    @Test(priority=3, description="TC_3")
    protected void TK_02(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        CoreUI.testProductSearch("nhung");
    }

    @Test(priority=4, description="TC_4")
    protected void TK_03(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        CoreUI.testProductSearch("  NHỮNG    ");
    }

    @Test(priority=5, description="TC_5")
    protected void TK_04(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        CoreUI.testProductSearch("NhỮNg");
    }

    @Test(priority=5, description="TC_5")
    protected void TK_05(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.xpath("//div[@class='owl-next']")).click();
            CoreUI.sleep(1);
            driver.findElement(By.xpath("//div[@class='owl-prev']")).click();
            CoreUI.sleep(1);
        }
        CoreUI.sleep(3);
        TestBase.logout_IBook();
    }

    @Test(priority=5, description="TC_5")
    protected void TK_06(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.xpath("//div[@class='owl-next']")).click();
            CoreUI.sleep(1);
            driver.findElement(By.xpath("//div[@class='owl-prev']")).click();
            CoreUI.sleep(1);
        }
        CoreUI.sleep(3);
        TestBase.logout_IBook();
    }
}


