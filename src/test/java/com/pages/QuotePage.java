package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//utils.waitForElementByClick(Driver, Timer.big_secs);
		utils.clickElement(Driver);
		utils.sendKeysToElement(Driver, driverName);  //ZAM, ZAM
		utils.clickElement(By.xpath("//td[@class='tallCellSelected']/div/span[contains(text(),'"+driverName+"')]"));
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
		utils.waitForElementByClick(broker, Timer.med_secs);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		utils.clickElement(broker);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		utils.sendKeysToElement(broker, carbroker);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		utils.clickElement(By.xpath("//div[contains(text(),'"+carbroker+"')]"));
	}

	public void durationAndDitance(String carduration, String cardistance) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		utils.clickElement(duration);
		utils.sendKeysToElement(duration, carduration);
		utils.clickElement(distance);
		utils.sendKeysToElement(distance, cardistance);
	}
	
	public void addEquipments(List<String> data) {
		utils.waitForElementBy(leaseService, Timer.med_secs);
		utils.clickElement(leaseService);
		utils.waitForElementBy(searchOrAddCatalog, Timer.big_secs);
		utils.clickElement(searchOrAddCatalog);
		utils.sendKeysToElement(searchOrAddCatalog,data.get(0));
		utils.waitForElementByClick(By.xpath("(//div[contains(text(),'55S')])[2]"), Timer.med_secs);
		utils.clickElement(By.xpath("(//div[contains(text(),'55S')])[2]"));
		// catalog search 2
		utils.waitForElementBy(searchOrAddCatalog, Timer.big_secs);
		utils.clickElement(searchOrAddCatalog);
		utils.sendKeysToElement(searchOrAddCatalog,data.get(1));
		utils.waitForElementByClick(By.xpath("(//div[contains(text(),'764F')])[2]"), Timer.med_secs);
		utils.clickElement(By.xpath("(//div[contains(text(),'764F')])[2]"));

		utils.clearField(By.xpath("//input[@name='quickSearchOption']"));
		utils.waitForElementBy(searchOrAddCatalog, Timer.big_secs);
		utils.clickElement(searchOrAddCatalog);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		utils.sendKeysToElement(searchOrAddCatalog,data.get(2));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		utils.waitForElementByClick(By.xpath("(//div[contains(text(),'JATO764F')])[2]"), Timer.med_secs);
		utils.clickElement(By.xpath("(//div[contains(text(),'JATO764F')])[2]"));
		utils.waitForElementByClick(By.xpath("//td[contains(text(),'OK')]"), Timer.med_secs);
		utils.clickElementBy(By.xpath("//td[contains(text(),'OK')]"));
	}
	
	
	public void addLeaseServices() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		utils.waitForElementBy(By.xpath("//div[contains(text(),'Included Services')]//following::span[contains(text(),'Edit')]"), Timer.med_secs);
		utils.clickElement(By.xpath("//div[contains(text(),'Included Services')]//following::span[contains(text(),'Edit')]"));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		utils.waitForElementBy(By.xpath("(//span[contains(@id,'isc_')]/following-sibling::span)[2]"), Timer.med_secs);
		utils.clickElement(By.xpath("(//span[contains(@id,'isc_')]/following-sibling::span)[2]"));
		utils.clickElement(By.xpath("//td[contains(text(),'OK')]"));
		
	}
	public void quoteCreate() {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		utils.waitForElementBy(By.xpath("//td[contains(@onfocus,'toolstrip_calculateSingleQuote')]//img[@class='ribbonButtonVIcon']"), Timer.med_secs);
		utils.clickElement(By.xpath("//td[contains(@onfocus,'toolstrip_calculateSingleQuote')]//img[@class='ribbonButtonVIcon']"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		utils.waitForElementBy(By.xpath("//td[contains(@onfocus,'toolstrip_validateSingleQuote')]//img[@class='ribbonButtonVIcon']"), Timer.med_secs);
		utils.clickElement(By.xpath("//td[contains(@onfocus,'toolstrip_validateSingleQuote')]//img[@class='ribbonButtonVIcon']"));
		
		//utils.waitForElement(By.xpath("//td[@onfocus='toolstrip_validateSingleQuote_6.$47()']//img[@class='ribbonButtonVIcon']"), Timer.med_secs);
		//utils.clickElementBy(By.xpath("//td[@onfocus='toolstrip_validateSingleQuote_6.$47()']//img[@class='ribbonButtonVIcon']"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		utils.waitForElementBy(By.xpath("//td[contains(@onfocus,'toolstrip_approveSingleQuote')]//img[@class='ribbonButtonVIcon']"), Timer.med_secs);
		utils.clickElement(By.xpath("//td[contains(@onfocus,'toolstrip_approveSingleQuote')]//img[@class='ribbonButtonVIcon']"));
		
		
		//utils.waitForElementBy(By.xpath("//td[@onfocus='toolstrip_approveSingleQuote_6.$47()']//img[@class='ribbonButtonVIcon']"), Timer.med_secs);
		//utils.clickElement(By.xpath("//td[@onfocus='toolstrip_approveSingleQuote_6.$47()']//img[@class='ribbonButtonVIcon']"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block  -> toolstrip_calculateSingleQuote_5.$47()
			e.printStackTrace();
		}
		
		utils.waitForElementBy(By.xpath("//td[contains(@onfocus,'toolstrip_generateContract')]//img[@class='ribbonButtonVIcon']"), Timer.med_secs);
		utils.clickElement(By.xpath("//td[contains(@onfocus,'toolstrip_generateContract')]//img[@class='ribbonButtonVIcon']"));
		
		//utils.waitForElementBy(By.xpath("(//td[@class='ribbonButton']//img[@class='ribbonButtonVIcon'])[7]"), Timer.med_secs);
		//utils.clickElement(By.xpath("(//td[@class='ribbonButton']//img[@class='ribbonButtonVIcon'])[7]"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block  -> toolstrip_calculateSingleQuote_5.$47()
			e.printStackTrace();
		}
		boolean contract_condition=utils.getPageTitle().contains(" is created");
		System.out.println(" ->"+contract_condition);
		Assert.assertTrue(contract_condition);
	}

	public void navigateToLTC() {
		
	}
	
}
