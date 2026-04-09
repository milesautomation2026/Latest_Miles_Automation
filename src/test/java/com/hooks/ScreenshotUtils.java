package com.hooks;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.BaseTest;
import com.utils.DriverFactory;

public class ScreenshotUtils extends DriverFactory {
	
	public static String takeScreenshot(String screenshotName) throws IOException {

		String timestamp = new SimpleDateFormat("yyyMMdd_HHmmss").format(new Date());
		String path = System.getProperty("user.dir") + "\\Screenshots\\" + screenshotName + "_" + timestamp + ".png";

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src, new File(path));

		return path;

	}



}
