package com.stepdefinitions;

import java.util.List;

import com.pages.CustomerPage;
import com.pages.HomePage;
import com.pages.LTCPage;
import com.pages.LoginPage;
import com.utils.DriverFactory;
import com.utils.PropertiesReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomeSteps {
	
    LoginPage loginPage;
    HomePage homePage;
    CustomerPage customerPage;
    LTCPage ltcpage;

    @Given("user navigates to LTC page by quick navigation")
    public void naviageToLTCPage(List<String> data) throws InterruptedException {
    	PropertiesReader.loadProperties();
        customerPage = new CustomerPage(DriverFactory.driver);
        homePage = new HomePage(DriverFactory.driver);
        homePage.navigateToQuickNavigation(data.get(0),data.get(1));
      }

    @Given("user navigates to Customers page by quick navigation")
    public void naviageToCustomerPage(List<String> data) throws InterruptedException {
    	PropertiesReader.loadProperties();
        customerPage = new CustomerPage(DriverFactory.driver);
        homePage = new HomePage(DriverFactory.driver);
        homePage.navigateToQuickNavigationWithCustomers(data.get(0),data.get(1));
      }

    @Given("user modifies the contract")
    public void modifyContract(List<String> data) {
    	PropertiesReader.loadProperties();
        customerPage = new CustomerPage(DriverFactory.driver);
        homePage = new HomePage(DriverFactory.driver);
        homePage.navigateToModifyContract(data.get(0),data.get(1));
        homePage.modifyBtn(); 
      }

    @Given("user validates and approves the quote")
    public void approvesQuote() throws InterruptedException {
    	PropertiesReader.loadProperties();
        customerPage = new CustomerPage(DriverFactory.driver);
        homePage = new HomePage(DriverFactory.driver);
        Thread.sleep(3000);
        homePage.validateAndapproves();
        Thread.sleep(3000);
        homePage.version2Document();
      }

    @Given("user navigates to LTC page by mega")
    public void naviageToLTCPageBymega() {
    	PropertiesReader.loadProperties();
        customerPage = new CustomerPage(DriverFactory.driver);
        homePage = new HomePage(DriverFactory.driver);
        homePage.navigateToContracts();
        homePage.navigateToLTC();
        homePage.searchLTC("225036");
    }

    @Then("user modifies new distance and duration")
    public void ltcModification() {
    	PropertiesReader.loadProperties();
        customerPage = new CustomerPage(DriverFactory.driver);
        homePage = new HomePage(DriverFactory.driver);
        ltcpage = new LTCPage(DriverFactory.driver);   
    }
    
}
