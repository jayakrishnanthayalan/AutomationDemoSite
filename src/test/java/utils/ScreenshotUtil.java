package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String stepName) {
        String path = "target/screenshots/" + stepName + ".png";
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] source = ts.getScreenshotAs(OutputType.BYTES);
            java.nio.file.Files.createDirectories(
                    java.nio.file.Paths.get("target/screenshots"));
            java.nio.file.Files.write(java.nio.file.Paths.get(path), source);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }
}
