package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.utils.SeleniumUtils;
import com.utils.Timer;

public class HomePage {

	private WebDriver driver;

	private SeleniumUtils utils;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		utils = new SeleniumUtils(this.driver);
	}

	private static By relationManagement = By.xpath("(//span[contains(text(),'Relation Management')])[1]");
	private static By modifyBtn = By.xpath("(//td[@class='buttonRounded']/img)[1]");
	private static By sales = By.xpath("//span[contains(text(),'Sales')]");
	private static By documentv2 = By.xpath("//a[contains(text(),'New contract version 2 has been created and activated.')]");
	private By quickNavigation = By.xpath("//input[@placeholder='Quick navigation']");
	@FindBy(xpath = "//span[contains(text(),'Fleet')]")
	private WebElement fleet;

	@FindBy(xpath = "(//td[@class='buttonRounded']/img)[1]")
	private WebElement modifyLtc;

	public WebDriver getDriver() {
		return driver;
	}

	public void navigateToFleet() {
		fleet.click();
	}

	public void getSales() { 
		utils.clickElement(sales);
	}
	 

	public void navigateToRelationManagement() {
		utils.clickElement(relationManagement);
	}

	public void navigateToContracts() {
		utils.clickElement(By.xpath("(//span[contains(text(),'Contracts')])[1]"));
	}

	public void navigateToLTC() {
		utils.clickElement(By.xpath("(//span[contains(text(),'Long Term Contracts')])[1]"));
		String current = driver.getTitle();
		// Assert.assertEquals(current, driver.getPageSource().contains("Long Term
		// Contracts"));
	}

	public void searchLTC(String ltc) {
		utils.clickElement(By.xpath("//input[@oninput='isc_SilkFormItem_143._handleInput()']"));
		utils.sendKeysToElement(By.xpath("//input[@oninput='isc_SilkFormItem_143._handleInput()']"), ltc);
		utils.clearField(By.xpath("(//input[@class='silkTextItem'])[9]"));
		utils.clearField(By.xpath("(//input[@class='silkTextItem'])[11]"));
		utils.clearField(By.xpath("//input[@tabindex='9450']"));
		utils.clearField(By.xpath("//input[@tabindex='10374']"));
		utils.clearField(By.xpath("//input[@tabindex='10902']"));
		utils.clickElement(By.xpath("(//span[contains(text(),'Search')])[3]"));
	}

	public void navigateToModifyContract(String distance, String duration) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		utils.clickElement(By.xpath("//span[contains(text(),'Modify Contract')]"));
		utils.clickElement(By.xpath("//input[@name='A3369']"));
		utils.sendKeysToElement(By.xpath("//input[@name='A3369']"), "Total distance and duration change");
		utils.clickElement(By.xpath("(//img[@class='silkCheckboxImg'])[1]"));
		utils.clickElement(By.xpath("(//td[@class='buttonRounded'])[4]"));
		utils.clickElement(By.xpath("//input[@name='A13084']"));
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		utils.sendKeysToElement(By.xpath("//input[@name='A13084']"), Keys.BACK_SPACE);
		utils.sendKeysToElement(By.xpath("//input[@name='A13084']"), duration);
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		utils.waitImplicit();
		utils.clickElement(By.xpath("//input[@name='A13083']"));
		utils.waitForElementByClick(By.xpath("//input[@name='A13083']"), Timer.big_secs);
		utils.sendKeysToElement(By.xpath("//input[@name='A13083']"), Keys.BACK_SPACE);
		utils.clickElement(By.xpath("//input[@name='A13084']"));
		utils.waitForElementByClick(By.xpath("//input[@name='A13083']"), Timer.long_secs);
		utils.clickElement(By.xpath("//input[@name='A13083']"));
		utils.sendKeysToElement(By.xpath("//input[@name='A13083']"), Keys.BACK_SPACE);
		utils.waitForElementByClick(By.xpath("//input[@name='A13083']"), Timer.big_secs);
		utils.sendKeysToElement(By.xpath("//input[@name='A13083']"), distance);
		utils.waitImplicit();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void modifyBtn() {
		utils.clickElement(modifyBtn);
	}
	/*
	 * public void distanceAndDuration(String distance,String duration) {
	 * utils.clickElement(By.xpath("//input[@name='A13084']"));
	 * utils.sendKeysToElement(By.xpath("//input[@name='A13084']"), duration);
	 * utils.clickElement(By.xpath("//input[@name='A13083']"));
	 * utils.sendKeysToElement(By.xpath("//input[@name='A13083']"), distance);
	 * utils.clickElement(By.xpath("//td[contains(text(),'Modify')]")); }
	 */

	public void changeReason() {
		// utils.clickElement(By.xpath("//input[@name='A3369']"));
		utils.sendKeysToElement(By.xpath("//input[@name='A3369']"), "Total distance and duration change");
		// utils.clickElement(By.xpath("(//table[@class='silkTextItemControl'])[10]//span"));
		utils.clickElement(By.xpath("//span[contains(text(),'Total distance and duration change')]"));
		utils.clickElement(By.xpath("//td[contains(text(),'Next')]"));
	}

	public void validateAndapproves() throws InterruptedException {
		utils.clickElement(modifyBtn);
		// utils.waitImplicitWithLargeTimeOut();
		Thread.sleep(5000);
		// utils.waitForElementBy(By.xpath("(//img[@class='ribbonButtonVIcon'])[8]"),Timer.big_secs
		// );
		utils.clickElement(By.xpath("(//img[@class='ribbonButtonVIcon'])[8]"));
		Thread.sleep(3000);
		//utils.waitForElementByClick(By.xpath("(//img[@class='ribbonButtonVIcon'])[9]"), Timer.long_secs);
		utils.clickElement(By.xpath("(//img[@class='ribbonButtonVIcon'])[9]"));
		Thread.sleep(3000);
		//utils.waitForElementByClick(By.xpath("(//img[@class='ribbonButtonVIcon'])[10]"), Timer.long_secs);
		utils.clickElement(By.xpath("(//img[@class='ribbonButtonVIcon'])[10]"));
	}

	public void version2Document() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		utils.clickElement(documentv2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(driver.getPageSource().contains("Amendment Quote"));
	}

	public void navigateToQuickNavigation(String quick_navigation, String ltc) throws InterruptedException {

		Thread.sleep(8000);
		utils.clickElement(By.xpath("//input[@placeholder='Quick navigation']"));
		utils.sendKeysToElement(By.xpath("//input[@placeholder='Quick navigation']"), quick_navigation);
		utils.clickElementBy(By.xpath("//div[contains(text(),'Contracts - Long Term Contracts')]"));
		utils.waitForElement(By.xpath("//input[@id='sofid_id_quicknavigation_field']"), Timer.long_secs);
		utils.sendKeysToElement(By.xpath("//input[@id='sofid_id_quicknavigation_field']"), ltc);
		utils.clickElement(By.xpath("//div[contains(text(),'" + ltc + "')]"));
		Thread.sleep(8000);
	}
	
	public void navigateToQuickNavigationWithCustomers(String quick_navigation, String customername) throws InterruptedException {

		Thread.sleep(8000);
		utils.clickElement(quickNavigation);
		utils.sendKeysToElement(quickNavigation, quick_navigation);
		utils.clickElementBy(By.xpath("//div[contains(text(),'Relation Management - Business Partners - Customers')]"));
		utils.waitForElement(By.xpath("//input[@id='sofid_id_quicknavigation_field']"), Timer.long_secs);
		utils.sendKeysToElement(By.xpath("//input[@id='sofid_id_quicknavigation_field']"), customername);
		Thread.sleep(3000);
		utils.clickElement(By.xpath("(//td/div[contains(text(),'Customers')])[last()]"));
		Thread.sleep(7000);
		utils.waitForElement(By.xpath("//span[contains(text(),'Trading Name')]/following::input[2]"), Timer.big_secs);

		utils.clickElement(By.xpath("//span[contains(text(),'Trading Name')]/following::input[2]"));
		utils.clearField(By.xpath("//span[contains(text(),'Trading Name')]/following::input[2]"));
		Thread.sleep(7000);
		utils.clickElement(By.xpath("//span[contains(text(),'Trading Name')]/following::input[2]"));
		utils.sendKeysToElement(By.xpath("//span[contains(text(),'Trading Name')]/following::input[2]"),customername);
	}
}
