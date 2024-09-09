package test;
import Base.ConfigData;
import Base.CoreUI;
import Base.TestBase;
import IBook.HomePage;
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
public class PayTest extends TestBase {
    @BeforeClass
    public void initializePages() {
        Login loginPage = new Login(driver);
        CoreUI coreUI = new CoreUI(driver);
    }
    @Test(priority=1, description="Check menu title")
    protected void TT_01(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//div[4]//div[2]//ul[1]//li[3]//div[2]//a[1]")).click();
        CoreUI.sleep(1);
        PayMent.checkMenuTitleDispalyed();
    }

    @Test(priority=2, description="Check add to cart success")
    protected void TT_02(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//div[4]//div[2]//ul[1]//li[3]//div[2]//a[1]")).click();
        CoreUI.sleep(1);
        PayMent.checkMenuTitleDispalyed();
        PayMent.addOneBookToCart();
    }

    @Test(priority=3, description="")
    protected void TT_03(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//div[4]//div[2]//ul[1]//li[3]//div[2]//a[1]")).click();
        CoreUI.sleep(1);
        PayMent.checkMenuTitleDispalyed();
        driver.findElement(By.xpath("//a[@class='add-cart']")).click();
        PayMent.checkTitleCart();
    }

    @Test(priority=4, description="")
    protected void TT_04(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        driver.findElement(By.xpath("(//a[@title='Xem thêm'][normalize-space()='Xem thêm'])[13]")).click();
        CoreUI.sleep(1);
        PayMent.checkMenuTitleDispalyed();
        driver.findElement(By.xpath("//a[@class='add-cart']")).click();
        PayMent.continueShop();
    }

    @Test(priority=5, description="")
    protected void TT_05(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        driver.findElement(By.xpath("(//a[@title='Xem thêm'][normalize-space()='Xem thêm'])[13]")).click();
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//a[@class='add-cart']")).click();
        PayMent.deleteCart();
        PayMent.checkTitleCartNotDisplayed();
    }

    @Test(priority=6, description="")
    protected void TT_06(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        driver.findElement(By.xpath("(//a[@title='Xem thêm'][normalize-space()='Xem thêm'])[13]")).click();
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//a[@class='add-cart']")).click();
        PayMent.deleteBook();
        PayMent.checkTitleCartNotDisplayed();
    }

    @Test(priority=7, description="")
    protected void TT_07(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        driver.findElement(By.xpath("(//a[@title='Xem thêm'][normalize-space()='Xem thêm'])[13]")).click();
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//a[@class='add-cart']")).click();
        WebElement quantity = driver.findElement(By.xpath("//input[@name='qty"));
        quantity.clear();
        CoreUI.sleep(2);
        quantity.sendKeys("4");
        CoreUI.verifyMenuTitle(driver,"//td[@id='sub-total-3']","476,000đ");
    }

    @Test(priority=8, description="")
    protected void TT_08(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        driver.findElement(By.xpath("(//a[@title='Xem thêm'][normalize-space()='Xem thêm'])[13]")).click();
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//a[@class='add-cart']")).click();
        CoreUI.sleep(2);
        CoreUI.verifyMenuTitle(driver,"//div[@id='btn-cart']//span[@id='num']","1");
    }

    @Test(priority=9, description="Check quantity cart")
    protected void TT_09(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        driver.findElement(By.xpath("(//a[@title='Xem thêm'][normalize-space()='Xem thêm'])[13]")).click();
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//a[@class='add-cart']")).click();
        CoreUI.sleep(2);
        CoreUI.verifyMenuTitle(driver,"//div[@id='btn-cart']//span[@id='num']","1");
        driver.findElement(By.xpath("//a[@id='buy-more']")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//div[@class='owl-wrapper']//div[1]//li[1]//div[2]//a[1]")).click();
        CoreUI.sleep(1);
        CoreUI.verifyMenuTitle(driver,"//div[@id='btn-cart']//span[@id='num']","2");
    }

    @Test(priority=10, description="Check quantity cart when delete all")
    protected void TT_10(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        driver.findElement(By.xpath("(//a[@title='Xem thêm'][normalize-space()='Xem thêm'])[13]")).click();
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//a[@class='add-cart']")).click();
        CoreUI.sleep(2);
        CoreUI.verifyMenuTitle(driver,"//div[@id='btn-cart']//span[@id='num']","1");
       PayMent.deleteCart();
        CoreUI.verifyMenuTitle(driver,"//div[@id='btn-cart']//span[@id='num']","2");
    }

    @Test(priority=11, description="Check quantity cart when delete one product")
    protected void TT_11(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        driver.findElement(By.xpath("(//a[@title='Xem thêm'][normalize-space()='Xem thêm'])[13]")).click();
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//a[@class='add-cart']")).click();
        CoreUI.sleep(2);
        CoreUI.verifyMenuTitle(driver,"//div[@id='btn-cart']//span[@id='num']","1");
        driver.findElement(By.xpath("//a[@id='buy-more']")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//div[@class='owl-wrapper']//div[1]//li[1]//div[2]//a[1]")).click();
        CoreUI.sleep(1);
        CoreUI.verifyMenuTitle(driver,"//div[@id='btn-cart']//span[@id='num']","2");
        PayMent.deleteBook();
        CoreUI.verifyMenuTitle(driver,"//div[@id='btn-cart']//span[@id='num']","1");
    }

    @Test(priority=12, description="Hover cart")
    protected void TT_12(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//a[@href='?mod=blog']")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//li[1]//div[1]//a[2]")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost/ibook/?mod=cart");
    }

    @Test(priority=13, description="Hover cart")
    protected void TT_13(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//a[contains(text(),'Giới thiệu')]")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//li[1]//div[1]//a[2]")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost/ibook/?mod=cart");
    }

    @Test(priority=14, description="Hover cart")
    protected void TT_14(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//ul[@id='main-menu']//a[contains(text(),'Liên hệ')]")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//li[1]//div[1]//a[2]")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost/ibook/?mod=cart");
    }

    @Test(priority=15, description="Hover cart")
    protected void TT_15(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//div[4]//div[2]//ul[1]//li[3]//div[2]//a[1]")).click();
        CoreUI.sleep(2);
        CoreUI.hoverCart();
        CoreUI.sleep(3);
    }

    @Test(priority=16, description="Hover cart")
    protected void TT_16(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//div[4]//div[2]//ul[1]//li[3]//div[2]//a[1]")).click();
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//ul[@id='main-menu']//a[contains(text(),'Liên hệ')]")).click();
        CoreUI.sleep(2);
        CoreUI.hoverCart();
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//a[contains(text(),'Giỏ hàng')]")).click();
        CoreUI.sleep(1);
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost/ibook/?mod=cart");
    }

    @Test(priority=17, description="Hover cart")
    protected void TT_17(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//li[6]//div[2]//a[1]")).click();
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//ul[@id='main-menu']//a[contains(text(),'Liên hệ')]")).click();
        CoreUI.sleep(2);
        CoreUI.hoverCart();
        CoreUI.sleep(2);
        CoreUI.verifyMenuTitle(driver,"//span[contains(text(),'1 sản phẩm')]","1");
        CoreUI.verifyMenuTitle(driver,"//p[@class='price fl-right']","59,000đ");
        CoreUI.sleep(1);
    }

    @Test(priority=18, description="Hover cart")
    protected void TT_18(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//div[4]//div[2]//ul[1]//li[3]//div[2]//a[1]")).click();
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//ul[@id='main-menu']//a[contains(text(),'Liên hệ')]")).click();
        CoreUI.sleep(2);
        CoreUI.hoverCart();
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//a[@title='Thanh toán']")).click();
        CoreUI.sleep(1);
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost/ibook/?mod=cart&action=checkout");
    }

    @Test(priority=19, description="Hover cart")
    protected void TT_19(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//div[4]//div[2]//ul[1]//li[3]//div[2]//a[1]")).click();
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//ul[@id='main-menu']//a[contains(text(),'Liên hệ')]")).click();
        CoreUI.sleep(2);
        CoreUI.hoverCart();
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//ul[@class='list-cart']")).click();
        CoreUI.sleep(1);
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost/ibook/?mod=product&action=detail&id=3");
    }
}
