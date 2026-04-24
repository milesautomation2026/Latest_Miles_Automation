package com.stepdefinitions;

import java.util.List;

import org.testng.Assert;
import com.pages.CustomerPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.DriverFactory;
import com.utils.PropertiesReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerSteps {

    LoginPage loginPage;
    HomePage homePage;
    CustomerPage customerPage;
    
   // ExcelUtils excelUtils = new ExcelUtils("src/test/resources/testdata.xlsx");

    public CustomerSteps() {
    	loginPage = new LoginPage(DriverFactory.driver);
    	homePage = new HomePage(DriverFactory.driver);
    	customerPage = new CustomerPage(DriverFactory.driver);
    	
    }
    @Given("user navigates to customer page")
    public void naviageToCustomerPage() {
    	PropertiesReader.loadProperties();
        //customerPage = new CustomerPage(DriverFactory.driver);
        homePage = new HomePage(DriverFactory.driver);
        homePage.navigateToRelationManagement();
        customerPage.navigateToBusinessPartner();
        customerPage.navigateToCustomerPage();
        
    }

    @When("user finds existing customer")
    public void searchCustomer(String tradingName) {
    	customerPage.tradingName(tradingName);
    	customerPage.navigateToFind();
    }

    @When("user searches existing customer")
    public void navigateToExistingCustomer() {
    	customerPage.navigateToFind();
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Then("user selects customer from the list")
    public void selectCustomer(List<String> data) {
    	customerPage.selectCustomer(data.get(0));
    }

    @And("user navigates to quote page")
    public void navigateToQuote() {
    	customerPage.navigateToQuote();
    }

    
    @When("user creates new customer profile")
    public void newCustomerProfile(List<String> data) throws InterruptedException {
    	customerPage = new CustomerPage(DriverFactory.driver);
    	customerPage.navigateToNewCustomer();
    	customerPage.selectLegalEntity(data.get(0));
    	customerPage.name(data.get(1), data.get(2));
    	customerPage.address(data.get(3),data.get(4),data.get(5));
    	customerPage.saveBtn();
    	customerPage.addIbanDetails(data.get(6));
    }
    
    @When("user enters")
    public void user_enters_valid_credentials() {
    	String username = PropertiesReader.getProperty("username");
      
         String password = PropertiesReader.getProperty("password");
         
         loginPage.login(username, password);
    }

    @Then("user shou")
    public void verifyLogin() {
    	String title = DriverFactory.driver.getTitle();
        Assert.assertTrue(DriverFactory.driver.getTitle().contains("Miles"));
        DriverFactory.driver.quit();
    }

 
}

