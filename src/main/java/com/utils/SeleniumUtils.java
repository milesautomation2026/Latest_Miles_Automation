package com.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import dev.failsafe.internal.util.Durations;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class SeleniumUtils {

    private static WebDriver driver;

    public SeleniumUtils(WebDriver driver) {
        this.driver = driver;
    }

    // Wait for visibility of an element
    public WebElement waitForElement(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementByClick(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    public WebElement waitForElementBy(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
    // Click on an element
    public void clickElement(By locator) {
        WebElement element = waitForElement(locator, Timer.long_secs);
        element.click();
    }

    public List<WebElement> findelements(By locator) {
    	List<WebElement> elements= driver.findElements(locator);
    	return elements;
    }
    public void clickElementBy(By locator) {
    	WebElement element = waitForElementByClick(locator, Timer.long_secs);
        element.click();
    }

    public void clickElementByjs(By locator) {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("", locator);
    }
    
    // Enter text into a text field
    public void sendKeysToElement(By locator, String text) {
        WebElement element = waitForElement(locator, Timer.long_secs);
        element.clear();
        element.sendKeys(text);
    }

    public void sendKeysToElement(By locator, Keys key) {
        WebElement element = waitForElement(locator, Timer.long_secs);
        element.sendKeys(key);
    }

    public void clearField(By locator) {
    	 WebElement element = waitForElement(locator, Timer.long_secs);
    	 element.click();
         element.clear();
    }
    
    // Get the text of an element
    public String getElementText(By locator) {
        WebElement element = waitForElement(locator, 10);
        return element.getText();
    }

    // Take a screenshot
	public static String takeScreenshot(String screenshotName) throws IOException {

		String timestamp = new SimpleDateFormat("yyyMMdd_HHmmss").format(new Date());
		String path = System.getProperty("user.dir") + "\\Screenshots\\" + screenshotName + "_" + timestamp + ".png";

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src, new File(path));

		return path;

	}

    // Get the page title
    public String getPageTitle() {
        return driver.getTitle();
    }

    public void waitImplicit() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(Timer.medium_big_millisecs));
    }
    
    public void waitImplicitWithLargeTimeOut() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(Timer.big_millisecs));
    }
    // Switch to alert and accept
    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void jsClick(WebDriver driver,WebElement element) {
    	JavascriptExecutor execute = (JavascriptExecutor) this.driver;
    	execute.executeScript("arguments[0].click();", element);
    }

	public void selectDropdown(WebElement element,String dropdownvalue) {
		Select sel = new Select(element);
		sel.selectByVisibleText(dropdownvalue);
	}
	
	public void windowHandles() {
		String parentWindow= driver.getWindowHandle();
		
		Set<String> allwindows = driver.getWindowHandles();
		
		
	}

}

