package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {

    private WebDriver driver;

    public WebDriver getDriver() {
        return this.driver;
    }

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterMethod
    public void tearDown(Method method, ITestResult iTestResult) throws IOException {

        if(!iTestResult.isSuccess()){
            MyUtils.takeScreenshot(getDriver(), method.getName(), this.getClass().getName());
        }
        getDriver().quit();
    }

}
