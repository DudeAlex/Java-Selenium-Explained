import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class JSExecutorTest extends BaseTest {
    @Test
    public void testJSExecutorHelloAlert0() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.alert('Hello');");
        Thread.sleep(3000);
    }
    @Test
    public void testJSExecutorHelloAlert1() throws InterruptedException {
        getJsExecutor().executeScript("window.alert('Hello');");
        Thread.sleep(3000);
    }
    @Test
    public void testJSExecutorButtonClick() throws InterruptedException {
        getDriver().get("https://www.litecart.net/en/demo");

        Thread.sleep(3000);

        getJsExecutor().executeScript("document.querySelector(\"[id='box-demo'] p a\").click();");

        Thread.sleep(3000);
    }

    @Test
    public void testJSExecutorButtonClick1() throws InterruptedException {
        getDriver().get("https://www.litecart.net/en/demo");

        Thread.sleep(3000);

        String script = "return document.querySelector(\"[id='box-demo'] p a\")";

        ((WebElement) getJsExecutor().executeScript(script)).click();

        Thread.sleep(3000);
    }
    @Test
    public void testJSExecutorButtonClick2() throws InterruptedException {
        getDriver().get("https://www.litecart.net/en/demo");
        WebElement element = getDriver().findElement(By.cssSelector("[id='box-demo'] p a"));

        Thread.sleep(3000);

        getJsExecutor().executeScript("arguments[0].click()", element);

        Thread.sleep(3000);
    }
    @Test
    public void testJSExecutorScrollByLongPage() throws InterruptedException {
        getDriver().get("https://bonigarcia.dev/selenium-webdriver-java/long-page.html");

        Thread.sleep(3000);

        getJsExecutor().executeScript("window.scrollBy(0,500)");

        Thread.sleep(3000);
    }
    @Test
    public void testJSExecutorScrollByLongPage1() throws InterruptedException {
        getDriver().get("https://bonigarcia.dev/selenium-webdriver-java/long-page.html");

        Thread.sleep(3000);

        getJsExecutor().executeScript("window.scrollBy(0,document.body.scrollHeight)");

        Thread.sleep(3000);
    }

    //Test with error
    @Test
    public void testScrollToElement() throws InterruptedException {
        getDriver().get("https://bonigarcia.dev/selenium-webdriver-java/long-page.html");
        WebElement element = getDriver().findElement(By.xpath("//*[contains(text(),'Copyright © 2021-2023')]"));

        Assert.assertTrue(element.getText().contains("Copyright © 2021-2023"));

        Thread.sleep(3000);

        Actions action = new Actions(getDriver());
        action.scrollToElement(element)
                .perform();

        Thread.sleep(3000);


    }
    @Test
    public void testScrollToElement1() throws InterruptedException {
        getDriver().get("https://bonigarcia.dev/selenium-webdriver-java/long-page.html");

        Thread.sleep(3000);

        WebElement footer = getDriver().findElement(By.xpath("//*[contains(text(),'Copyright © 2021-2023')]"));

        Rectangle rectangle = footer.getRect();
        int deltaY = rectangle.getY();

        new Actions(getDriver())
                .scrollByAmount(0, deltaY)
                .perform();

        Thread.sleep(3000);
    }
    @Test
    public void testCreateButton() throws InterruptedException {
        getDriver().get("https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html");

        Thread.sleep(3000);

        String script = "var button = document.createElement('button');" +
                        "button.textContent = 'Click Me!';" +
                        "document.body.appendChild(button);";


        getJsExecutor().executeScript(script);

        Thread.sleep(10000);
    }
    @Test
    public void testScrollIntoView(){

        
    }
}
