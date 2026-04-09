package com.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.utils.SeleniumUtils;
import com.utils.Timer;

public class CustomerPage {

	public CustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofMillis(Timer.big_millisecs));
        utils = new SeleniumUtils(this.driver);
    }
	
	WebDriver driver;
	WebDriverWait wait;
	SeleniumUtils utils;
	
	@FindBy(xpath  = "(//span[contains(text(),'Relation Management')])[1]")
	private  WebElement relationManagement;
	
	//@FindBy(xpath  = "//span[contains(text(),'Business Partner')]")
	//private  By businessPartner ="";
	
	@FindBy(xpath  = "//span[contains(text(),'Customers')]")
	private  WebElement customerPage;
	
	@FindBy(xpath  = "(//span[contains(text(),'New')])[1]")
	private  WebElement newCustomerPage;
	
	@FindBy(xpath  = "//span[contains(text(),'Search')])")
	private  WebElement findCustomer;
	
	@FindBy(xpath  = "(//span[@role='button'])[6]")
	private WebElement legalEntity;
	
	@FindBy(xpath ="//span[contains(text(),'Private Person')]")
	private WebElement legalEntityOption1;
	
	@FindBy(xpath = "(//input[@name='A343'])[2]")
	private WebElement titleSelect;
	
	@FindBy(xpath = "(//span[contains(text(),'Mr')])[1]")
	private WebElement titleOption;
	
	@FindBy(xpath="//input[@name='A8']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@name='A9']")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@name='A28']")
	private WebElement address;
	
	@FindBy(xpath = "//input[@name='A30']")
	private WebElement postalCode;
	
	@FindBy(xpath = "//input[@name='A31']")
	private WebElement city;
	
	@FindBy(xpath = "//input[@name='A32']")
	private WebElement state;
	
	@FindBy(xpath ="//div[@id='id_menu_3_valueCell4']/div")
	private WebElement financialTab;

	@FindBy(xpath="(//img[@class='ribbonButtonVIcon'])[1]")
	private WebElement saveBtn;
	
	@FindBy(xpath="//div[@eventproxy='toolstrip_addBankAccount_1_5']//img")
	private WebElement plus;
	
	@FindBy(xpath="//span[contains(text(),'IBAN')]")
	private WebElement ibanOption;
	
	@FindBy(xpath="//input[@name='A94']")
	private WebElement accountNumber;

	@FindBy(xpath="//input[@name='A2126']")
	private WebElement ibanSelect;
	
	public By treadingName = By.xpath("(//input[@name='silk_search_condValue'])[25]");

	private  By searchCustomer = By.xpath("//span[contains(text(),'Search')]/preceding::img[1]");
	
	private By listOfCustomers= By.xpath("(//table[@class='listTable'])[2]");
	
	public void navigateToBusinessPartner() {
		utils.clickElement(By.xpath("//span[contains(text(),'Business Partner')]"));
	}
	
	public void navigateToQuote() {
		utils.waitForElement(By.xpath("//td[contains(text(),'Create Quote')]"), Timer.big_secs);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		utils.clickElement(By.xpath("//td[contains(text(),'Create Quote')]"));
	}

	public void navigateToSuppliersPage() {
		WebElement customer_page = wait.until(ExpectedConditions.visibilityOf(customerPage));
		customer_page.click();
	}
	
	public void navigateToCustomerPage() {
		utils.clickElement(By.xpath("//span[contains(text(),'Customers')]"));
	}
	
	public void navigateToNewCustomer() {
		utils.clickElementBy(By.xpath("(//span[contains(text(),'New')])[1]"));
	}
	
	public void tradingName(String tradingname) {
		utils.waitForElement(treadingName, Timer.med_secs);
		utils.clickElement(treadingName);
		utils.clearField(treadingName);
		utils.sendKeysToElement(treadingName, tradingname);
	}
	
	public void navigateToFind() {
		utils.clickElement(searchCustomer);
	}

	public void selectCustomer(String customer) {
		utils.waitForElement(listOfCustomers, Timer.big_secs);
		System.out.println("Blist click"+customer);
		List<WebElement> customers=utils.findelements(listOfCustomers);
		for(int i=0;i<customers.size();i++) {
			System.out.println("length"+customers.size());
			System.out.println("Beforeeeee click:"+customers.get(i).getText());
			System.out.println("Before click:"+customers.get(i).toString().startsWith(customer));
			System.out.println("After click:"+customer);
			if(!customers.get(i).toString().contains(customer)) {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Before click");
				////td[@class='cellSelected']//a[@class='silkClickableLink'][normalize-space()='CU KP Brakefast logistics']
				//utils.sendKeysToElement(listOfCustomers, Keys.ARROW_DOWN);
				//utils.sendKeysToElement(listOfCustomers, Keys.ENTER);
				utils.clickElement(By.cssSelector("a.silkClickableLink"));
				System.out.println("After click");
			}
		}
	}
	public void selectLegalEntity(String name) throws InterruptedException {
		utils.clickElement(By.xpath("(//span[@role='button'])[6]"));
		//utils.waitForElementByClick(By.xpath("//span[contains(text(),'"+name+"')]", Timer.big_secs);
		utils.waitForElement(By.xpath("//span[contains(text(),'"+name+"')]"), Timer.big_secs);
		utils.clickElement(By.xpath("//span[contains(text(),'"+name+"')]"));
	}

	public void name(String fname,String lname) {
		utils.clickElement(By.xpath("(//input[@name='A343'])[2]"));
		utils.clickElement(By.xpath("(//span[contains(text(),'Mr')])[1]"));
		utils.clickElement(By.xpath("//input[@name='A8']"));
		utils.sendKeysToElement(By.xpath("//input[@name='A8']"), fname);
		utils.clickElement(By.xpath("//input[@name='A9']"));
		utils.sendKeysToElement(By.xpath("//input[@name='A9']"), lname);
	}

	public void address(String address,String postalCode,String city) {
		utils.clickElement(By.xpath("//input[@name='A28']"));
		utils.sendKeysToElement(By.xpath("//input[@name='A28']"), address);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		utils.clickElement(By.xpath("//input[@name='A30']"));
		utils.clickElement(By.xpath("//input[@name='A31']"));
		utils.sendKeysToElement(By.xpath("//input[@name='A31']"),city );
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		utils.clickElement(By.xpath("//input[@name='A30']"));
		utils.sendKeysToElement(By.xpath("//input[@name='A30']"), postalCode);
	}

	public void saveBtn() {
		utils.clickElement(By.xpath("(//img[@class='ribbonButtonVIcon'])[1]"));
	}

	public void enterContactDetails(String fname,String lname,String address1) {
		utils.clickElement(By.xpath("//input[@name='A28']"));
		utils.sendKeysToElement(By.xpath(""), address1);
		//address_add.sendKeys(address1);
		WebElement postal_code = wait.until(ExpectedConditions.visibilityOf(postalCode));
		city.click();
		city.sendKeys("GENT");
		state.click();
		postal_code.click();
		saveBtn.click();
		WebElement finacial_tab= wait.until(ExpectedConditions.visibilityOf(financialTab));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finacial_tab.click();
		
	}
	
	
	public void addIbanDetails() {
		utils.clickElement(By.xpath("//div[@id='id_menu_3_valueCell4']/div"));
		utils.clickElement(By.xpath("//input[@name='A94']"));
		WebElement iban_option= wait.until(ExpectedConditions.visibilityOf(ibanOption));
		iban_option.click();
		WebElement account_number= wait.until(ExpectedConditions.visibilityOf(accountNumber));
				account_number.click();
				account_number.clear();
				account_number.sendKeys("BE98519269216993");
		saveBtn.click();
	}
}

