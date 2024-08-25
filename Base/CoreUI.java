package Base;

import com.google.gson.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoreUI extends TestBase {
    private static WebDriver driver;

    private static int TIMEOUT = 10;
    private static double STEP_TIME = 0.5;
    private static int PAGE_LOAD_TIMEOUT = 20;
    public static SoftAssert softAssert = new SoftAssert();

    public CoreUI(WebDriver driver) {
        CoreUI.driver = driver;
    }

    /**
     * @param second
     */
    public static void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void logConsole(Object message) {
        System.out.println(message);
    }


    public static WebElement getWebElement(By by) {
        return driver.findElement(by);
    }

    public static void openURL(String url) {
        driver.get(url);
        sleep(STEP_TIME);
        logConsole("Open: " + url);
    }


    public static void clickElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(STEP_TIME);
        driver.findElement(by).click();
        logConsole("Click element: " + by);
    }


    public static void clickElement(By by, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(STEP_TIME);
        driver.findElement(by).click();
        logConsole("Click element: " + by);
    }

    public static void clickBtnAddNew() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement btnAddNew = driver.findElement(
                By.xpath("//a[@class='btn btn-primary btn-action-primary margin-left-xs' " +
                        "or @class='btn btn-action-primary btn-primary' " +
                        "or @class='btn btn-action-primary' " +
                        "or @class='btn btn-primary ml-5 btn-action-primary' " +
                        "or @class='btn btn-primary btn-action-primary add-survey3 mr-10']"));
        js.executeScript("arguments[0].click();", btnAddNew);
        CoreUI.sleep(3);
    }


    public static void clickBtnSave() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement btnSave = driver.findElement(By.xpath("//input[@type='submit']"));
        js.executeScript("arguments[0].click();", btnSave);
        CoreUI.sleep(3);
    }

    public static void clickRadioButton(int index) {
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
        radioButtons.get(index).click();
    }

    public static void clickCheckbox(int index) {
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        checkboxes.get(index).click();
    }


    public static void setText(By by, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(STEP_TIME);
        driver.findElement(by).sendKeys(value);
        logConsole("Set text: " + value + " on element " + by);
    }


    public static String getElementText(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(STEP_TIME);
        String text = driver.findElement(by).getText();
        logConsole("Get text: " + text);
        return text; //Trả về một giá trị kiểu String
    }

    /**
     * Được sử dụng để kiểm tra xem một phần tử có tồn tại trong DOM của một trang và hiển thị hay không.
     * Nó sử dụng đối tượng By thay vì đối tượng WebElement với chức năng có thể gọi để tìm phần tử đó trước rồi kiểm tra phần tử đó có hiển thị hay không. Chứ nó không tìm kiếm liền.
     * WebDriver sẽ chờ đợi tối đa TIMEOUT giây trước khi ném ra một ngoại lệ nếu điều kiện không được đáp ứng.
     * Trong khoảng thời gian chờ đợi, nó sẽ kiểm tra điều kiện mỗi 500 mili giây.
     *
     * @param by
     */
    public static void waitForElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
            logConsole("Timeout waiting for the element Visible. " + by.toString());
        }
    }

    /**
     * @param by
     * @param timeOut thời gian chờ(s)
     */
    public static void waitForElementVisible(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(100));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
            logConsole("Timeout waiting for the element Visible. " + by.toString());
        }
    }

    /**
     * Được sử dụng để kiểm tra xem một phần tử hiện có tồn tại trong DOM của một trang hay không.
     * Có nghĩa là bạn đã tìm thấy Element đó rồi nhưng nó có thể chưa hiển thị lên.
     * (có thể nó dị disable, nhưng nó vẫn có tồn tại trong DOM)
     *
     * @param by
     */
    public static void waitForElementPresent(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Element not exist. " + by.toString());
            logConsole("Element not exist. " + by.toString());
        }
    }

    /**
     * @param by
     * @param timeOut
     */
    public static void waitForElementPresent(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Element not exist. " + by.toString());
            logConsole("Element not exist. " + by.toString());
        }
    }

    /**
     * Điều kiện mong đợi là chờ một phần tử có thể click được, tức là phần tử đó phải hiện diện / được hiển thị trên màn hình và phải enabled (có thể click).
     *
     * @param by
     */
    public static void waitForElementClickable(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(getWebElement(by)));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element ready to click. " + by.toString());
            logConsole("Timeout waiting for the element ready to click. " + by.toString());
        }
    }

    /**
     * @param by
     * @param timeOut thời gian có thể chờ tối đa
     */
    public static void waitForElementClickable(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(getWebElement(by)));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element ready to click. " + by.toString());
            logConsole("Timeout waiting for the element ready to click. " + by.toString());
        }
    }

    /**
     * Điều kiện mong đợi là chờ một phần tử chứa đoạn text được chỉ định.
     *
     * @param by
     * @param text Nội dung đoạn text của element
     */
    public static void waitForTextToBePresentInElement(By by, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.textToBePresentInElement(getWebElement(by), text));
        } catch (Throwable error) {
            Assert.fail("Timeout for an element containing the specified text. " + by.toString());
            logConsole("Timeout for an element containing the specified text." + by.toString());
        }
    }

    /**
     * Điều kiện mong đợi là chờ một trang có tiêu đề cụ thể.
     *
     * @param titlePage tiêu đề page
     */
    public static void waitForTitleIsPage(String titlePage) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.titleIs(titlePage));
        } catch (Throwable error) {
            logConsole("Timeout for a page with a specific title.");
        }
    }

    /**
     * Chờ đợi trang tải xong (Javascript) với thời gian thiết lập sẵn
     */
    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(PAGE_LOAD_TIMEOUT), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // wait for Javascript to loaded
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState")
                .toString().equals("complete");

        //Get JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            logConsole("Javascript in NOT Ready!");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("Timeout waiting for page load (Javascript). (" + PAGE_LOAD_TIMEOUT + "s)");
            }
        }
    }


    public static boolean verifyEquals(Object actual, Object expected) {
        waitForPageLoaded();
        System.out.println("Verify equals: " + actual + " and " + expected);
        boolean check = actual.equals(expected);
        return check;
    }

    public static void assertEquals(Object actual, Object expected, String message) {
        waitForPageLoaded();
        System.out.println("Assert equals: " + actual + " and " + expected);
        Assert.assertEquals(actual, expected, message);
    }

    public static void assertEqualsDataFile(Object actual, Object expected) {
        System.out.println("Assert equals: " + actual + " and " + expected);
        Assert.assertEquals(actual, expected);
    }

    public static boolean verifyContains(String actual, String expected) {
        waitForPageLoaded();
        System.out.println("Verify contains: " + actual + " and " + expected);
        boolean check = actual.contains(expected);
        return check;
    }

    public static void assertContains(String actual, String expected, String message) {
        waitForPageLoaded();
        System.out.println("Assert contains: " + actual + " and " + expected);
        boolean check = actual.contains(expected);
        Assert.assertTrue(check, message);
    }


    public static void refreshPage() {
        driver.navigate().refresh();
        CoreUI.sleep(3);
    }


    public static void backPage() {
        driver.navigate().back();
        CoreUI.sleep(3);
    }


    public static void forwardPage() {
        driver.navigate().forward();
        CoreUI.sleep(3);
    }


    public static void closeBrowser() {
        CoreUI.sleep(2);
        driver.quit();
    }


    public static String getCurrentUrl() {
        CoreUI.sleep(2);
        return driver.getCurrentUrl();
    }


    public static String getTitlePage() {
        CoreUI.sleep(2);
        return driver.getTitle();
    }


    public static String getPageSource() {
        CoreUI.sleep(2);
        return driver.getPageSource();
    }


    public static String getRecordStatus() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean isFormValid = Boolean.parseBoolean(js.executeScript("return VHV.isFormValid;").toString());
        if (!isFormValid) {
            System.out.println(js.executeScript("return VHV.lastValidator.errorMap;"));
            return js.executeScript("return VHV.lastValidator.errorMap;").toString();
        } else {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(js.executeScript("return VHV.lastResponseText;").toString(), JsonObject.class);
            System.out.println("Status: " + jsonObject.get("status").getAsString());
            return jsonObject.get("status").getAsString();
        }
    }


    public static String getResponseStatus() {
        CoreUI.sleep(3);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (Boolean) js.executeScript("return typeof VHV.lastResponseText !== 'undefined';");
            }
        });

        String responseText = (String) js.executeScript("return VHV.lastResponseText;");

        if (responseText == null || responseText.isEmpty()) {
            System.out.println("VHV.lastResponseText is null or empty");
            return null;
        }

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(responseText, JsonObject.class);

        if (jsonObject != null && jsonObject.has("status")) {
            System.out.println("Status: " + jsonObject.get("status").getAsString());
            return jsonObject.get("status").getAsString();
        } else {
            System.out.println("jsonObject is null or does not have 'status' field");
            return null;
        }
    }


    public static String getResponseMessage() {
        CoreUI.sleep(3);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (Boolean) js.executeScript("return typeof VHV.lastResponseText !== 'undefined';");
            }
        });

        String responseText = (String) js.executeScript("return VHV.lastResponseText;");

        if (responseText == null || responseText.isEmpty()) {
            System.out.println("VHV.lastResponseText is null or empty");
            return null;
        }

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(responseText, JsonObject.class);

        if (jsonObject != null && jsonObject.has("message")) {
            String message = jsonObject.get("message").getAsString().trim();
            System.out.println("Message: " + message);
            return message;
        } else {
            System.out.println("jsonObject is null or does not have 'message' field");
            return null;
        }
    }

    public static String getSecurityToken(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String securityToken = null;

        try {
            // Thực hiện JavaScript để lấy giá trị securityToken
            Object scriptResult = js.executeScript("return VHV.securityToken;");
            if (scriptResult != null) {
                Gson gson = new Gson();

                // Kiểm tra nếu scriptResult là một JSON String
                JsonElement jsonElement = JsonParser.parseString(scriptResult.toString());

                if (jsonElement.isJsonObject()) {
                    JsonObject jsonObject = jsonElement.getAsJsonObject();
                    // Thay "propertyName" bằng tên property thực tế chứa token trong JSON của bạn
                    if (jsonObject.has("propertyName")) {
                        securityToken = jsonObject.get("propertyName").getAsString();
                        System.out.println("securityToken: " + securityToken);
                        CoreUI.sleep(5); // Đoạn này chắc chắn là bạn đã cần thiết cho nghiệp vụ của mình
                    }
                } else if (jsonElement.isJsonPrimitive()) {
                    securityToken = jsonElement.getAsString();
                    System.out.println("securityToken: " + securityToken);
                    CoreUI.sleep(5); // Đoạn này chắc chắn là bạn đã cần thiết cho nghiệp vụ của mình
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý exception theo yêu cầu của bạn
        }

        return securityToken;
    }



    public static String getRecordMessage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean isFormValid = Boolean.parseBoolean(js.executeScript("return VHV.isFormValid;").toString());
        if (!isFormValid) {
            System.out.println(js.executeScript("return VHV.lastValidator.errorMap;"));
            return js.executeScript("return VHV.lastValidator.errorMap;").toString();
        } else {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(js.executeScript("return VHV.lastResponseText;").toString(), JsonObject.class);
            System.out.println("Message: " + jsonObject.get("message").getAsString());
            return jsonObject.get("message").getAsString();
        }
    }


    public static void getLocation(WebElement element) {
        Point coordinate = element.getLocation();
        System.out.println("location: " + coordinate.x + "," + coordinate.y);
    }

    public static void verifyBestSellingProductListCount(WebDriver driver, String productListLocator, int expectedCount) {
        try {
            List<WebElement> productList = driver.findElements(By.xpath(productListLocator));
            int actualCount = productList.size();
            Assert.assertEquals(actualCount, expectedCount, "Product list count mismatch. Expected: " + expectedCount + ", Actual: " + actualCount);
        } catch (NoSuchElementException e) {
            System.out.println("Product list not found: " + productListLocator);
        }
    }

    public static void verifyMenuTitle(WebDriver driver, String menuLocator, String expectedTitle) {
        try {
            WebElement menuElement = driver.findElement(By.xpath(menuLocator));
            String actualTitle = menuElement.getText();
            Assert.assertEquals(actualTitle, expectedTitle, "Menu title mismatch. Expected: " + expectedTitle + ", Actual: " + actualTitle);
        } catch (NoSuchElementException e) {
            System.out.println("Menu element not found: " + menuLocator);
        }
    }


    public static void verifyElementDisplay(String elementXpath) {
        boolean isElementDisplayed;
        try {
            CoreUI.waitForElementVisible(By.xpath("" + elementXpath + ""));
            isElementDisplayed = driver.findElement(By.xpath("" + elementXpath + "")).isDisplayed();
        } catch (NoSuchElementException e) {
            isElementDisplayed = false;
        }
        Assert.assertTrue(isElementDisplayed, "Element not found or not displayed: " + elementXpath);
    }


    public static void verifyElementNotDisplayed(String elementXpath) {
        boolean isElementNotDisplayed;
        try {
            isElementNotDisplayed = driver.findElement(By.xpath("" + elementXpath + "")).isDisplayed();
        } catch (NoSuchElementException e) {
            isElementNotDisplayed = false;
        }
        Assert.assertFalse(isElementNotDisplayed, "Element found or displayed: " + elementXpath);
    }


    public static boolean checkErrorMessageDisplayed(String textError) {
        try {
            By errorElement = By.xpath("//p[contains(.,'" + textError + "')]");
            System.out.println("Checking error message: " + textError);
            CoreUI.waitForElementVisible(errorElement);
            softAssert.assertTrue(driver.findElement(errorElement).isDisplayed());
            return true;
        } catch (AssertionError e) {
            System.err.println("AssertionError occurred while checking error message: " + textError);
            softAssert.fail("Timeout waiting for the element Visible. " + textError);
            return false;
        } catch (Exception e) {
            System.err.println("Exception occurred while checking error message: " + textError);
            e.printStackTrace();
            return false;
        }
    }


    public static void searchUnitType(String idUnitType) {
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//div[@class='smartselect dropdown']")).click();
        CoreUI.sleep(1);
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[@data-value='" + idUnitType + "']")).click();
        CoreUI.sleep(1);
    }


    public static void selectDataValue(String idUnit) {
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[@data-value='" + idUnit + "']")).click();
        CoreUI.sleep(1);
    }


    public static void testProductSearch(String keyWord) {

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='s']"));
        searchBox.clear();
        // Enter search keywords
        searchBox.sendKeys(keyWord);

        // Submit the search
        driver.findElement(By.xpath("//button[@id='sm-s']")).click();

        // Verify search results
        WebElement resultList = driver.findElement(By.xpath("//ul[@class='list-item list-items']"));

        // Option 1: Verify presence of search results list
        Assert.assertTrue(resultList.isDisplayed(), "Search results list is not displayed");

        // Option 2: Verify number of search results (replace 5 with expected number)
        List<WebElement> productItems = resultList.findElements(By.xpath("//ul[@class='list-item list-items']//li"));
        Assert.assertEquals(productItems.size(), 2, "Number of search results doesn't match expectation");
        for (WebElement productItem : productItems) {
            String productName = productItem.findElement(By.xpath(".//a[@class='product-name']")).getText();
            System.out.println("Product name: " + productName);
        }
    }
}

