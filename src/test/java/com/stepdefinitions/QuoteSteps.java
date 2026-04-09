package com.stepdefinitions;

import java.util.List;

import com.pages.CustomerPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.QuotePage;
import com.utils.DriverFactory;

import io.cucumber.java.en.And;

public class QuoteSteps {

    LoginPage loginPage;
    HomePage homePage;
    CustomerPage customerPage;
    QuotePage quotePage;
	
	 public QuoteSteps() {
	    	loginPage = new LoginPage(DriverFactory.driver);
	    	homePage = new HomePage(DriverFactory.driver);
	    	customerPage = new CustomerPage(DriverFactory.driver);
	    	quotePage = new QuotePage(DriverFactory.driver);
	    }
	 
	 @And("select the quotation template and others field")
	    public void selectQtnTemplateAndOthers(List<String> data) {
	    	quotePage.selectQtnTemplate(data.get(0));
	    	quotePage.selectDriver(data.get(1));
	    }

	 @And("select the vehicle name, type and model")
	    public void selectVehicle(List<String> data) {
	    	quotePage.selectVehicleMake(data.get(0));
	    	quotePage.selectVehicleModel(data.get(1));
	    	quotePage.selectVehicleType(data.get(2));
	    }

	 @And("select broker,dealer and duration and distance")
	 public void selectBrokerDealerDistanceDuration(List<String> data) {
		 quotePage.broker(data.get(0));
		 //quotePage.selectDealer(data.get(1));
		 quotePage.durationAndDitance(data.get(2), data.get(3));
	 }

	 @And("Add equipment and lease services")
	 public void addLease() {
		 quotePage.leaseService();;
		// quotePage.
		 
	 }
}