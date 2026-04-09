package com.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver driver;

    public static WebDriver initDriver() {
      //  PropertiesReader.loadProperties("src/test/resources/config.properties");
        String browser = PropertiesReader.getProperty("browser");
        int timeout = PropertiesReader.getIntProperty("timeout");

        if (browser.equals("chrome")) {
        	 ChromeOptions chromeOptions = new ChromeOptions();
        	 chromeOptions.addArguments("--ignore-certificate-errors");
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
        driver.manage().window().maximize();
        return driver;
    }
}

