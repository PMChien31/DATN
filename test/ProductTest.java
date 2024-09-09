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
import Base.CoreUI;
import LoginIBook.Login;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.support.ui.Select;


public class ProductTest extends TestBase {
    @BeforeClass
    public void initializePages() {
        Login loginPage = new Login(driver);
        CoreUI coreUI = new CoreUI(driver);
    }
    @Test(priority=1, description="TC_2")
    protected void SP_01(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        CoreUI.clickMenuProduct();
        CoreUI.sleep(2);
        CoreUI.getSelectBoxText("//select[@name='select']");
    }
    @Test(priority=2, description="TC_2")
    protected void SP_02(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        CoreUI.clickMenuProduct();
        CoreUI.sleep(2);
        CoreUI.sortProduct(driver, CoreUI.FilterOption.PRICE_HIGH_TO_LOW);
        CoreUI.sleep(2);
    }
    @Test(priority=3, description="TC_2")
    protected void SP_03(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        CoreUI.clickMenuProduct();
        CoreUI.sleep(2);
        CoreUI.sortProduct(driver, CoreUI.FilterOption.PRICE_LOW_TO_HIGH);
        CoreUI.sleep(2);
    }
    @Test(priority=4, description="TC_2")
    protected void SP_04(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        CoreUI.clickMenuProduct();
        CoreUI.sleep(2);
        CoreUI.sortProduct(driver, CoreUI.FilterOption.ASCENDING);
        CoreUI.sleep(2);
    }
    @Test(priority=5, description="TC_2")
    protected void SP_05(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        CoreUI.clickMenuProduct();
        CoreUI.sleep(2);
        CoreUI.sortProduct(driver, CoreUI.FilterOption.DESCENDING);
        CoreUI.sleep(2);
    }
    @Test(priority=6, description="TC_2")
    protected void SP_021(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        CoreUI.clickMenuProduct();
        CoreUI.sleep(2);
        CoreUI.sortProduct(driver, CoreUI.FilterOption.PRICE_HIGH_TO_LOW);
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//a[normalize-space()='2']")).click();
        CoreUI.sleep(2);
    }
    @Test(priority=7, description="TC_2")
    protected void SP_031(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        CoreUI.clickMenuProduct();
        CoreUI.sleep(2);
        CoreUI.sortProduct(driver, CoreUI.FilterOption.PRICE_LOW_TO_HIGH);
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//a[normalize-space()='2']")).click();
        CoreUI.sleep(2);
    }
    @Test(priority=8, description="TC_2")
    protected void SP_041(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        CoreUI.clickMenuProduct();
        CoreUI.sleep(2);
        CoreUI.sortProduct(driver, CoreUI.FilterOption.ASCENDING);
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//a[normalize-space()='2']")).click();
        CoreUI.sleep(2);
    }
    @Test(priority=9, description="TC_2")
    protected void SP_051(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        CoreUI.clickMenuProduct();
        CoreUI.sleep(2);
        CoreUI.sortProduct(driver, CoreUI.FilterOption.DESCENDING);
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//a[normalize-space()='2']")).click();
        CoreUI.sleep(2);
    }
    @Test(priority=10, description="TC_2")
    protected void SP_06(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//div[@class='section-detail']//div[2]//li[1]//div[2]//a[2]")).click();
        CoreUI.sleep(2);
        CoreUI.verifyElementDisplay("//h3[contains(text(),'Ươm mầm hạnh phúc')]");
        CoreUI.verifyElementNotDisplayed("//div[@class='desc']");
        CoreUI.verifyElementDisplay("//a[@class='add-cart']");
        CoreUI.verifyElementDisplay("//h3[contains(text(),'Mô tả sản phẩm')]");
        CoreUI.verifyElementDisplay("//h3[contains(text(),'Cùng chuyên mục')]");
    }
}
