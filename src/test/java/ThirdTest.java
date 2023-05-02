import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class ThirdTest {

    @Test
    public void testSelect() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://askomdch.com/store/");

        WebElement selectElement = driver.findElement(By.xpath("//select[@id='product_cat']"));
        Select select = new Select(selectElement);

        List<WebElement> options = select.getOptions();

        for (WebElement option : options) {
            if(option.getText().equals("Men’s Shirts  (1)")){
                option.click();
                Thread.sleep(12000);
                break;
            }
            //System.out.println(option.getText());
        }

        driver.quit();
    }
    @Test
    public void testNoSelect() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://askomdch.com/store/");
        WebElement selectElement = driver.findElement(By.xpath("//select[@id='product_cat']"));
        selectElement.click();
        List<WebElement> options = selectElement.findElements(By.tagName("option"));

        for (WebElement option : options) {
            if (option.getText().equals("Men’s Shirts  (1)")) {
                option.click();
                Thread.sleep(12000);
                break;
            }
        }
        driver.quit();
    }
    @Test
    public void testBootstrap() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.jqueryscript.net/demo/enhance-native-select-box");

        List<WebElement> menuList = driver.
                findElements(By.xpath("//div[@class='vselect-selected-display']/span"));

        menuList.get(0).click();

        List<WebElement> productsList = driver.
                findElements(By.xpath("//div[contains(@id, 'vselect-tray')]/div/input"));

        // System.out.println(productsList.size());
        for (WebElement product : productsList) {
            if (product.getAttribute("data-type").equals("child")) {
                product.click();
            }

        }
        Thread.sleep(3000);

        driver.quit();

    }
}
