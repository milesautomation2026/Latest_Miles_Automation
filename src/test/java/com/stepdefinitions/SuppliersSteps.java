package com.stepdefinitions;

import com.pages.LoginPage;
import com.pages.SuppliersPage;
import com.sun.tools.javac.util.List;
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
    public void newCustomerProfile(List<String> data) {
    	suppliersPage = new SuppliersPage(DriverFactory.driver);
    	//System.out.println("Before entering legal entity");
    	suppliersPage.selectLegalEntity(data.getFirst());//Private Person
    	//System.out.println("After entering legal entity");
    	suppliersPage.enterContactDetails(data.get(1));
    	//System.out.println("Entring into fincaial tab");
    	suppliersPage.navigateToFinancial();
    	//System.out.println("Entered into fincial tab");
    	suppliersPage.addIban(data.get(2));
    	
    }

}
