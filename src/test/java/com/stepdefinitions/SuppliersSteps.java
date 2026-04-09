package com.stepdefinitions;

import com.pages.LoginPage;
import com.pages.SuppliersPage;
import com.utils.DriverFactory;
import com.utils.PropertiesReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class SuppliersSteps {

    LoginPage loginPage;
    SuppliersPage suppliersPage;
    
   // ExcelUtils excelUtils = new ExcelUtils("src/test/resources/testdata.xlsx");

    @Given("user navigates to suppliers page")
    public void naviageToCustomerPage() {
    	PropertiesReader.loadProperties();
        suppliersPage = new SuppliersPage(DriverFactory.driver);
        suppliersPage.navigateToRelationManagement();
        suppliersPage.navigateToBusinessPartner();
        suppliersPage.navigateToSuppliersPage();
        suppliersPage.navigateToNewCustomer();
    }


    @When("user creates new Supplier profile")
    public void newCustomerProfile() {
    	suppliersPage = new SuppliersPage(DriverFactory.driver);
    	System.out.println("Before entering legal entity");
    	suppliersPage.selectLegalEntity("NV");//Private Person
    	System.out.println("After entering legal entity");
    	suppliersPage.enterContactDetails();
    	System.out.println("Entring into fincaial tab");
    	suppliersPage.navigateToFinancial();
    	System.out.println("Entered into fincial tab");
    	suppliersPage.addIban();
    	
    }

}

