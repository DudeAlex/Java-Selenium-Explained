import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.io.IOException;

public class ScreenshotTest extends BaseTest {
    @Test
    public void getScreenshot() throws IOException {
        getDriver().get("https://askomdch.com/store/");

        WebElement element = getDriver().findElement(By.id("woocommerce_top_rated_products-3"));
    }
}
