package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    public static void takeScreenshot(WebDriver driver, String fileName) {
        // Cast driver object to TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        // Call getScreenshotAs method to create an image file
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        // Specify the destination file path
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        File destDir = new File("screenshots");
        if (!destDir.exists()) {
            destDir.mkdirs();  // Create the directory if it doesn't exist
        }
        File destFile = new File("screenshots/" + fileName + "_" + timestamp + ".png");
        // Copy the source file to the destination
        try {
            FileHandler.copy(srcFile, destFile);
            System.out.println("Screenshot taken: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
