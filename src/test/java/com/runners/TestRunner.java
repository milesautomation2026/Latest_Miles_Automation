package com.runners;

import org.testng.annotations.AfterTest;

import com.utils.PropertiesReader;
import com.utils.Reporting;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.stepdefinitions", "com.hooks"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	
	@AfterTest
	public static void afterclass() {
		Reporting.generatesExtentreports(PropertiesReader.getProperty("extentReports"));
	}
}


