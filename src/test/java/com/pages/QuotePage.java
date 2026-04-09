package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.SeleniumUtils;
import com.utils.Timer;

public class QuotePage {
	
	public QuotePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofMillis(Timer.big_millisecs));
        utils = new SeleniumUtils(this.driver);
    }
	
	WebDriver driver;
	WebDriverWait wait;
	SeleniumUtils utils;

	private By qtnTemple = By.xpath("//input[@name='R418']");
	private By vehicleName= By.xpath("//input[@name='A10182']");
	private By vehicleModel = By.xpath("//input[@name='A10183']");
	private By vehicleType= By.xpath("//input[@name='A10185']");
	private By dealer = By.xpath("//input[@name='R2031']");
	private By Driver = By.xpath("//input[@name='R3']");
	private By broker = By.xpath("//input[@name='R35']");
	private By duration = By.xpath("//input[@name='A627']");
	private By distance = By.xpath("//input[@name='A629']");
	private By leaseService = By.xpath("(//td[@class='ribbonButton']/span[contains(text(),'Edit')])[1]");
	private By includedServices = By.xpath("(//td[@class='ribbonButton']/span[contains(text(),'Edit')])[2]");
	private By searchOrAddCatalog = By.xpath("//input[@name='quickSearchOption']");
	
	private By Qtntemplate1 = By.xpath("//span[contains(text(),'Operating Lease (Sofico Lease)')]");
	private By Qtntemplate2 = By.xpath("//span[contains(text(),'Finance Lease (Sofico Lease)')]");
 
	public void selectQtnTemplate(String template) {
		utils.waitForElement(qtnTemple, Timer.big_secs);
		utils.clickElement(qtnTemple);
		utils.clearField(qtnTemple);
		utils.sendKeysToElement(qtnTemple, template);
		if(template.equals("Operating lease")) {
			utils.clickElement(Qtntemplate1);
		}
		else {
			utils.clickElement(Qtntemplate2);
		}
	}
	
	public void selectDriver(String driverName) {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//utils.waitForElementByClick(Driver, Timer.big_secs);
		utils.clickElement(Driver);
		utils.clickElement(By.xpath("//span[contains(text(),'"+driverName+"')]"));
	}
	
	public void selectVehicleMake(String vehicle) {
		utils.clickElement(vehicleName);
		utils.sendKeysToElement(vehicleName, vehicle);
		utils.clickElement(By.xpath("//span[contains(text(),'"+vehicle+"')]"));
	}
	
	public void selectVehicleModel(String model) {
		utils.clickElement(vehicleModel);
		utils.sendKeysToElement(vehicleModel, model);
		utils.clickElement(By.xpath("//span[contains(text(),'"+model+"')]"));
	}
	
	public void selectVehicleType(String type) {
		utils.clickElement(vehicleType);
		utils.sendKeysToElement(vehicleType, type);
		utils.clickElement(By.xpath("//div[contains(text(),'"+type+"')]"));
	}
	
	public void selectDealer(String cardealer) {
		utils.clickElement(dealer);
		utils.sendKeysToElement(dealer, cardealer);
		utils.clickElement(By.xpath("//div[contains(text(),'"+cardealer+"')]"));
	}
	
	public void broker(String carbroker) {
		utils.clickElement(broker);
		utils.sendKeysToElement(broker, carbroker);
		utils.clickElement(By.xpath("//div[contains(text(),'"+carbroker+"')]"));
	}

	public void durationAndDitance(String carduration, String cardistance) {
		utils.clickElement(duration);
		utils.sendKeysToElement(duration, carduration);
		utils.clickElement(distance);
		utils.sendKeysToElement(distance, cardistance);
	}
	
	public void leaseService() {
		utils.clickElement(leaseService);
		//utils.waitForElementBy(searchOrAddCatalog, Timer.big_secs);
		//utils.clickElement(searchOrAddCatalog);
		//utils.sendKeysToElement(searchOrAddCatalog,catalog1 );
	}
}
