package com.stepdefinitions;

import org.testng.Assert;

import com.pages.LoginPage;
import com.utils.DriverFactory;
import com.utils.ExtentManager;
import com.utils.PropertiesReader;
import com.utils.Reporting;
import com.utils.SeleniumUtils;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    LoginPage loginPage;
    
   // ExcelUtils excelUtils = new ExcelUtils("src/test/resources/testdata.xlsx");

    @Given("user launches application")
    public void launchApp() {
    	PropertiesReader.loadProperties();
        String url = PropertiesReader.getProperty("url");
        DriverFactory.initDriver().get(url);
        loginPage = new LoginPage(DriverFactory.driver);
    }

    @When("user enters valid credentials from Excel")
    public void enterCredentialsFromExcel() {
    	String username = PropertiesReader.getProperty("username");
       
        String password = PropertiesReader.getProperty("password");
     
        loginPage.login(username, password);
        Reporting.test.info("Login is completed");
    }
    
    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {
    	String username = PropertiesReader.getProperty("username1");
      
         String password = PropertiesReader.getProperty("password1");
         
         loginPage.login(username, password);
         Reporting.test.info("Login is completed");
    }

    @Then("user should login successfully")
    public void verifyLogin() {
        Assert.assertTrue(DriverFactory.driver.getTitle().contains("Miles"));
        
    }

 
}

