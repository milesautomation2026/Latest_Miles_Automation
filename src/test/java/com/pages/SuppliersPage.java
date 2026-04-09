package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuppliersPage{

	public SuppliersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofMillis(15000));
    }

	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath  = "(//span[contains(text(),'Relation Management')])[1]")
	private  WebElement relationManagement;
	
	@FindBy(xpath  = "//span[contains(text(),'Business Partner')]")
	private  WebElement businessPartner;
	
	@FindBy(xpath  = "//span[contains(text(),'Suppliers')]")
	private  WebElement supplierPage;
	
	@FindBy(xpath  = "(//span[contains(text(),'New')])[1]")
	private  WebElement newSuppliersPage;
	
	@FindBy(xpath  = "//span[contains(text(),'Search')])")
	private  WebElement findCustomer;
	
	@FindBy(xpath  = "(//input[@name='A345'])[2]")
	private WebElement legalEntity;
	
	@FindBy(xpath ="//div/span[contains(text(),'NV')]")
	private WebElement legalEntityOptions;
	
	@FindBy(xpath = "(//td[@class='ribbonButton']/img[@eventpart='icon'])[18]")
	private WebElement addIban;
	
	@FindBy(xpath= "//span[contains(text(),'IBAN')]")
	private WebElement ibanOption;

	@FindBy(xpath ="//span[contains(text(),'NV')]")
	private WebElement legalEntityOption1;
	
	@FindBy(xpath="//input[@name='A94']")
	private WebElement ibanadd;
	
	@FindBy(xpath = "//input[@name='R881']")
	private WebElement tradingName;
	
	@FindBy(xpath="(//img[@class='ribbonButtonVIcon'])[1]")
	private WebElement saveBtn;
	
	@FindBy(xpath ="//*[@id='id_menu_8_valueCell2']/div")
	private WebElement Financial;
	
	@FindBy(xpath="")
	private WebElement TTradingName;
	
	public void navigateToRelationManagement() {
		WebElement relation_mgt = wait.until(ExpectedConditions.visibilityOf(relationManagement));
		relation_mgt.click();
	}
	
	public void navigateToBusinessPartner() {
		WebElement business_partner = wait.until(ExpectedConditions.visibilityOf(businessPartner));
		business_partner.click();
	}
	
	public void navigateToSuppliersPage() {
		WebElement customer_page = wait.until(ExpectedConditions.visibilityOf(supplierPage));
		customer_page.click();
	}
	
	public void navigateToNewCustomer() {
		WebElement new_customer_page = wait.until(ExpectedConditions.visibilityOf(newSuppliersPage));
		new_customer_page.click();
	}
	
	public void navigateToFinancial() {
		WebElement financial_tab = wait.until(ExpectedConditions.visibilityOf(Financial));
		financial_tab.click();
	}
	
	public void navigateToFind() {
		findCustomer.click();
	}

	public void selectLegalEntity(String name) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement legal_entite = wait.until(ExpectedConditions.visibilityOf(legalEntity));
		legal_entite.click();
		WebElement legal_option = wait.until(ExpectedConditions.visibilityOf(legalEntityOption1));
		legal_option.click();
	}

	public void enterContactDetails() {
		WebElement trading_name = wait.until(ExpectedConditions.visibilityOf(tradingName));
		trading_name.click();
		trading_name.sendKeys("RRK Logistics");
		saveBtn.click();
	}
	
	public void addIban() {
		System.out.println("Entering Iban ");
		WebElement add_iban= wait.until(ExpectedConditions.visibilityOf(addIban));
		add_iban.click();
		System.out.println("Entering Iban----2 ");
		WebElement iban_option= wait.until(ExpectedConditions.visibilityOf(ibanOption));
		iban_option.click();
		System.out.println("Entering Iban----3 ");
		ibanadd.click();
		ibanadd.clear();
		ibanadd.sendKeys("BE42878513883154");
		saveBtn.click();
	}
}
