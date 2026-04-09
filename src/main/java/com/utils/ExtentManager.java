package com.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentManager {

    private static final ExtentReports extent = createInstance("Milles_Testing"); // report base name
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    private ExtentManager() {}

    private static ExtentReports createInstance(String reportName) {
        try {
            String reportsDir = System.getProperty("user.dir") + File.separator + "Reports";
            File dir = new File(reportsDir);
            if (!dir.exists() && !dir.mkdirs()) {
                throw new IllegalStateException("Failed to create reports directory: " + reportsDir);
            }

            // Correct pattern and formatting
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String reportPath = reportsDir + File.separator + reportName + "__" + timestamp + ".html";

            // Use Spark (preferred) — change to ExtentHtmlReporter if your project depends on v3
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("Milles_Testing");

            ExtentReports e = new ExtentReports();
            e.attachReporter(spark);

            System.out.println("Extent Report Generated at: " + reportPath);
            return e;
        } catch (Exception ex) {
            throw new RuntimeException("Failed to initialize ExtentReports", ex);
        }
    }

    // ----- Public API -----
    public static ExtentReports getExtent() {
        return extent;
    }

    public static void setTest(ExtentTest extentTest) {
        test.set(extentTest);
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void unload() {
        test.remove();
    }

    public static void flush() {
        extent.flush();
    }
}

	
