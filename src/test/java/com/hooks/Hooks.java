package com.hooks;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Report;
import com.base.BaseTest;
import com.utils.DriverFactory;
import com.utils.ExtentManager;
import com.utils.Reporting;
import com.utils.SeleniumUtils;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends SeleniumUtils {
	public Hooks(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Before
	public static void beforeScenario(Scenario scenario) {

		System.out.println(" Hooks loaded ");
		if (Reporting.extent == null) {
			Reporting.generatesExtentreports("ExtentReport");
		}

		Reporting.test = Reporting.extent.createTest(scenario.getName());
		Reporting.test.info("Infomation cheks"+scenario.getName());

	}

	@AfterStep
	public static void afterStep(Scenario scenario) {

		try {
			String screenshotPath = ScreenshotUtils.takeScreenshot(scenario.getName() + "_step");
			if (Reporting.test != null) {
				if (scenario.isFailed()) {
					Reporting.test.fail("Step failed").addScreenCaptureFromPath(screenshotPath);
				} else {
					Reporting.test.info("Step screenshot").addScreenCaptureFromPath(screenshotPath);
				}
				Reporting.flushReports();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@After
	public static void afterScenario(Scenario scenario) {
		try {
			String screenshotPath= ScreenshotUtils.takeScreenshot(scenario.getName());
			if (Reporting.test!=null) {
				if (scenario.isFailed()) {
					Reporting.test.fail("Scenario failed").addScreenCaptureFromPath(screenshotPath);
				}else {
					Reporting.test.info("Scenario Passed").addScreenCaptureFromPath(screenshotPath);
				}
			Reporting.flushReports();
			}}catch (Exception e) {
				// TODO: handle exception
			}
		
			if(DriverFactory.driver !=null ) 
			try{
				DriverFactory.driver.quit();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}

	@AfterTest
	public static void closeUp() {
		DriverFactory.driver.quit();
	}
}
