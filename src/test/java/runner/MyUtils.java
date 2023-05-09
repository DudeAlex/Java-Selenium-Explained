package runner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtils {
    public static <T> void takeScreenshot(T driver, String methodName, String className) throws IOException {
        Date currentDate = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        String formattedDate = formatter.format(currentDate);

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(String
                .format(".\\src\\test\\java\\screenshots\\%s-%s-%s.png",
                        methodName, className, formattedDate)));
    }
}
