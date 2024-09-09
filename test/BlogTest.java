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
public class BlogTest extends TestBase {
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

    @Test(priority=2, description="TC_2")
    protected void Blog_02(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        CoreUI.clickMenuBlog();
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//a[normalize-space()='2']")).click();
        CoreUI.verifyElementDisplay("//a[contains(text(),'Trước')]");
        CoreUI.verifyElementDisplay("//a[normalize-space()='Sau']");
        CoreUI.sleep(2);
    }

    @Test(priority=2, description="TC_2")
    protected void Blog_03(){
        Login_IBook("minhchien","12345678");
        CoreUI.sleep(2);
        CoreUI.clickMenuBlog();
        CoreUI.sleep(2);
        driver.findElement(By.xpath("//a[normalize-space()='3']")).click();
        CoreUI.verifyElementDisplay("//a[contains(text(),'Trước')]");
        CoreUI.verifyElementNotDisplayed("//a[normalize-space()='Sau']");
        CoreUI.sleep(2);
    }



}
