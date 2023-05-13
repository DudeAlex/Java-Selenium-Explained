import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class ActionsTest extends BaseTest {
    @Test
    public void fileUploadTest() throws IOException, InterruptedException {
        getDriver().get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        Path newFile = Files.createTempFile("tempMyTestFile", "txt");
        String fileName =newFile.toAbsolutePath().toString();
        WebElement inputElement = getDriver().findElement(By.xpath("//input[@name='my-file']"));
        inputElement.sendKeys(fileName);
        getDriver().findElement(By.cssSelector("button[type=submit]")).submit();
        Thread.sleep(3000);
    }

    @Test
    public void sliderMoveTest() throws InterruptedException {
        getDriver().get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement slider = getDriver().findElement(By.cssSelector("input[type='range']"));
        String value = slider.getAttribute("value");

        Assert.assertTrue(value.equalsIgnoreCase("5"));

        for (int i=0; i<5; i++){
            Thread.sleep(500);
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        Thread.sleep(1000);

        value=slider.getAttribute("value");

        Assert.assertTrue(value.equalsIgnoreCase("10"));
    }
    @Test
    public void testDayPicker() throws InterruptedException {
        getDriver().get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        getDriver().findElement(By.xpath("//input[@name='my-date']")).click();
        Thread.sleep(2000);
        WebElement dateYear = getDriver()
                .findElement(By.xpath("//th[@class='datepicker-switch' and contains(text(), 'May 2023')]"));
        //I did not finish it yet, but it gives you some idea how to perform further steps
        Thread.sleep(2000);

    }
    @Test
    public void testSpooker() throws InterruptedException {
        getDriver().get("https://webflow.com/made-in-webflow/website/vladimirmab");
        getDriver().switchTo().frame(0);
        getDriver().findElement(By.xpath("//*[contains(text(), 'Press START')]")).click();

        Actions action = new Actions(getDriver());
        WebElement letterS = getDriver().findElement(By.xpath("//img[contains(@src, 'S.svg')]"));
        WebElement letterP = getDriver().findElement(By.xpath("//img[contains(@src, 'P.svg')]"));
        WebElement letterO1 = getDriver().findElement(By.xpath("//img[contains(@src, 'O1.svg')]"));
        WebElement board = getDriver().findElement(By.xpath("//*[contains(@src, 'SpookerWall')]"));

        // getAttribute() method allows us to retrieve x and y coordinates
        //of a certain WebElement, but be informed tht it doesn't work in some cases and returns null as a result.

        int xBoard = Integer.parseInt(board.getAttribute("x"));
        int yBoard = Integer.parseInt(board.getAttribute("y"));

        var xLetterS = Integer.parseInt(letterS.getAttribute("x"));
        var yLetterS = Integer.parseInt(letterS.getAttribute("y"));

        var xLetterP = Integer.parseInt(letterP.getAttribute("x"));
        var yLetterP = Integer.parseInt(letterP.getAttribute("y"));


        var xLetterO1 = Integer.parseInt(letterO1.getAttribute("x"));
        var yLetterO1 = Integer.parseInt(letterO1.getAttribute("y"));

        System.out.println(xBoard + " " + yBoard);
        System.out.println(xLetterS + " " + yLetterS);
        System.out.println(xLetterP + " " + yLetterP);
        System.out.println(xLetterO1 + " " + yLetterO1);

        Thread.sleep(1000);

        //action.dragAndDrop(letterS, board).build().perform();
        action.dragAndDropBy(letterO1, 107, -260).build().perform();

        Thread.sleep(1000);
    }
    @Test
    public void testActionXY() throws InterruptedException {
        getDriver().get("https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html");

        WebElement dragAble =getDriver().findElement(By.xpath("//*[@id=\"draggable\"]"));
        WebElement toDrag = getDriver().findElement(By.xpath("//*[@id=\"target\"]"));



        //With Rectangle class we can retrieve information about
        //web element's top-left coordinates, its width and its length.

        Rectangle rectDragAble = dragAble.getRect();
        int dragAbleX = rectDragAble.getX();
        int dragAbleY = rectDragAble.getY();
        int dragAbleWidth = rectDragAble.getWidth();
        int dragAbleHeight = rectDragAble.getHeight();

        Rectangle rectToDrag = toDrag.getRect();
        int toDragX = rectToDrag.getX();
        int toDragY = rectToDrag.getY();
        int toDragWidth = rectToDrag.getWidth();
        int toDragHeight = rectToDrag.getHeight();


        Thread.sleep(1000);
        Actions actions = new Actions(getDriver());
        actions.dragAndDrop(dragAble,toDrag).perform();
        Thread.sleep(1000);
        actions.dragAndDropBy(dragAble,0,200)
                .pause(Duration.ofSeconds(1))
                .dragAndDropBy(dragAble,-200,0)
                .pause(Duration.ofSeconds(1))
                .dragAndDropBy(dragAble,0,-200)
                .pause(Duration.ofSeconds(1))
                .dragAndDropBy(dragAble,200,0)
                .pause(Duration.ofSeconds(2))
                .perform();
    }
    @Test
    public void testMouseOver() {
        getDriver().get("https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html");

        WebElement compass = getDriver().findElement(By.xpath("//img[contains(@src, 'calendar')]"));
        Actions actions = new Actions(getDriver());

        actions.pause(Duration.ofSeconds(2))
                .moveToElement(compass)
                .pause(Duration.ofSeconds(2))
                .perform();
    }
}













