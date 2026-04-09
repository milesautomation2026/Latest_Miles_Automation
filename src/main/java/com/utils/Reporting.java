package com.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting {
	public static ExtentReports extent;
	public static ExtentTest test;

	public static void generatesExtentreports(String reportName) {
		// Build folder path
		String reportFolderPath = System.getProperty("user.dir") + "\\Reports";

		File folder = new File(reportFolderPath);

		// create Reports folder if not present
		if (!folder.exists()) {
			folder.mkdir();
		}

		// Add timestamp to report file name

		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

		String reportPath = reportFolderPath + "\\" + reportName + "_" + timestamp + ".html";

		// setup html reporter
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Milles_Testing");
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Operating System", "Windows 10");
		System.out.println("Extent Report initialized at : " + reportPath);

	}
	public static void flushReports() {
		try {
			if(extent !=null) {
				extent.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
