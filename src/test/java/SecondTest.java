import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.annotations.Test;

import java.util.List;

public class SecondTest {

    @Test
    public void newFeatures(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        driver.findElement(new ByIdOrName("my-password"));
        driver.findElement(new ByIdOrName("my-text-id"));
        driver.findElement(new ByIdOrName("my-text"));
        List<WebElement> elements = driver.findElements(new ByAll(By.tagName("form"), By.tagName("input")));

        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
        System.out.println(elements.size());

        driver.quit();
    }
    @Test
    public void newFeaturesRelativeLocators() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://askomdch.com/store/");

        WebElement mainElement = driver.findElement(By.xpath("//h2[contains(text(),'Blue Denim Shorts')]"));
        RelativeLocator.RelativeBy relativeBy = RelativeLocator.with(By.tagName("h2"));
        WebElement searchResult = driver.findElement(relativeBy.above(mainElement));
        System.out.println(searchResult.getText());

        driver.quit();
    }
}
