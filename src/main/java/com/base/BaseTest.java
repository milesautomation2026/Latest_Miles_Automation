package com.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.utils.*;



public class BaseTest {

	
    public static String captureScreenshot(String testName) {
        TakesScreenshot ts = (TakesScreenshot)DriverFactory.driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String path = "reports/screenshots/" + testName + ".png";
        try {
            FileUtils.copyFile(src, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
