package IBook;
import Base.ConfigData;
import Base.CoreUI;
import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Base.ConfigData.readTestObjectsFromJson;
import static Base.CoreUI.getWebElement;
import static Base.CoreUI.verifyElementDisplay;

public class HomePage {
    protected static WebDriver driver;
    public static String menuTitle1 = "//a[@id='payment-link']";
    public static String menuTitle2 = "//a[@href='?'][contains(text(),'Trang chủ')]";
    public static String menuTitle3 = "//a[contains(text(),'Sản phẩm')]";
    public static String menuTitle4 = "//a[@href='?mod=blog']";
    public static String menuTitle5 = "//a[contains(text(),'Giới thiệu')]";
    public static String menuTitle6 = "//ul[@id='main-menu']//a[contains(text(),'Liên hệ')]";
    public static String menuTitle7 = "//a[contains(text(),'Đăng xuất')]";
    public static String menuTitle8 = "//h3[contains(text(),'Danh mục sản phẩm')]";
    public static String menuTitle9 = "//h3[contains(text(),'Sản phẩm bán chạy')]";
    public static String menuTitle10 = "//h3[contains(text(),'Sản phẩm nổi bật')]";
    public static String menuTitle11 = "//h3[contains(text(),'Sách kỹ năng')]";
    public static String menuTitle12 = "//h3[normalize-space()='Sách kinh doanh']";
    public static String menuTitle13 = "//h3[contains(text(),'Sách học tập')]";

    public static void checkMenuTitleDispalyed(){
        verifyElementDisplay(menuTitle1);
        verifyElementDisplay(menuTitle2);
        verifyElementDisplay(menuTitle3);
        verifyElementDisplay(menuTitle4);
        verifyElementDisplay(menuTitle5);
        verifyElementDisplay(menuTitle6);
        verifyElementDisplay(menuTitle7);
        verifyElementDisplay(menuTitle8);
        verifyElementDisplay(menuTitle9);
        verifyElementDisplay(menuTitle10);
        verifyElementDisplay(menuTitle11);
        verifyElementDisplay(menuTitle12);
        verifyElementDisplay(menuTitle13);
    }

}
