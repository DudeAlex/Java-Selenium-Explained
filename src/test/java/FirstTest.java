import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import java.util.*;
import org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.NoSuchElementException;

public class FirstTest {
    @Ignore
    @Test
    public void myFirstTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[name='q']"))
                .sendKeys("Selenium" + Keys.RETURN);
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void secondTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@href='/store']")).click();
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void findPicture() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

        for (int i = 0; ; i++) {
            if (i >= 10)
                throw new TimeoutException();

            try {
                driver.findElement(By.id("compas"));
                break;
            } catch (NoSuchElementException e) {
                Thread.sleep(500);
            }
            finally {
                System.out.println("finally");
            }
        }
        driver.quit();
    }
    @Test
    public void testExplicitWait(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement landscapeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("landscape")));

        Assert.assertTrue(landscapeElement.getAttribute("src").contains("landscape"));

        driver.quit();
    }
    @Test
    public void testExplicitWaitLambda(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement landscapeElement = wait.until(d -> d.findElement(By.id("landscape")));

        Assert.assertTrue(landscapeElement.getAttribute("src").contains("landscape"));

        driver.quit();
    }
    @Test
    public void testFluentWait() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);
        WebElement landscapeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("landscape")));
        Assert.assertTrue(landscapeElement.getAttribute("src").contains("landscape"));

        driver.quit();
    }
    @Test
    void testUploadFile() throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        String initUrl = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
        driver.get(initUrl);
        WebElement inputFile = driver.findElement(By.name("my-file"));
        Path tempFile = Files.createTempFile("tempfiles", ".tmp");
        System.out.println(tempFile);
        String filename = tempFile.toAbsolutePath().toString();

        inputFile.sendKeys(filename);
        Thread.sleep(3000);
        driver.findElement(By.tagName("form")).submit();
        Assert.assertFalse(driver.getCurrentUrl().equalsIgnoreCase(initUrl));
    }
    @Test
    void testByChained() {
        WebDriver driver = new ChromeDriver();
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        List<WebElement> rowsInForm = driver.findElements(
                new ByChained(By.tagName("form"), By.className("row")));
        for (WebElement element: rowsInForm) {
            System.out.println(element.getAttribute("clientHeight"));
        }
        Assert.assertEquals(rowsInForm.size(), 1);
        driver.quit();
    }
    @Test
    void testByAll() {
        WebDriver driver = new ChromeDriver();
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        List<WebElement> rowsInForm = driver.findElements(
                new ByAll(By.tagName("form"), By.className("row")));
        for (WebElement element: rowsInForm) {
            System.out.println(element.getAttribute("clientHeight"));
            System.out.println(element.getAttribute("nodeName"));
            System.out.println(element.getAttribute("firstElementChild"));
        }
        Assert.assertEquals(rowsInForm.size(), 5);
        driver.quit();
    }
    @Test
    public void testRelativeLocator() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        WebElement anchorElement = driver
                .findElement(new By.ByXPath("//label[contains(text(),'datalist')]"));
        RelativeBy relativeBy = RelativeLocator.with(By.cssSelector("a[href*=index]"));
        WebElement searchElement = driver.findElement(relativeBy.below(anchorElement));

        System.out.println(searchElement.getAttribute("innerText"));
        System.out.println(relativeBy.getRemoteParameters());
        driver.quit();
    }
    @Test
    public void testShopNearProducts(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/store/");

        WebElement anchorElement = driver.findElement(By.xpath("//h2[contains(text(), 'Blue Tshirt')]"));
        RelativeBy relativeBy = RelativeLocator.with(By.tagName("h2"));
        WebElement targetElement = driver.findElement(relativeBy.near(anchorElement, 1000));

        System.out.println(targetElement.getAttribute("innerText"));
        driver.quit();
    }
    @Test
    public void testSelectOption() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/store/");

        Select selectElement =new Select(driver.findElement(By.id("product_cat")));

        List<WebElement> options = selectElement.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        Thread.sleep(2000);
        selectElement.getFirstSelectedOption();
        Thread.sleep(2000);
        selectElement.selectByVisibleText("Women  (7)");
        Thread.sleep(2000);


        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void testSelectOptionWithoutSelectClass() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/store/");

        WebElement selectElement = driver.findElement(By.id("product_cat"));
        List<WebElement> options = selectElement.findElements(By.tagName("option"));
        System.out.println(options.size());
        System.out.println(options.get(4).getText());
        driver.quit();
    }
    @Test
    public void testBootstrapOptionWithoutSelectClass() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/");
        WebElement selectElement = driver.findElement(By.id("dropdownMenuButton"));

//        List<WebElement> options = select.getOptions();
//        System.out.println(options.size());
        driver.quit();

    }
}





















