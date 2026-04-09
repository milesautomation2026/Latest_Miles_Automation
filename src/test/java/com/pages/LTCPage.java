package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.utils.SeleniumUtils;

public class LTCPage {
	
	
	public LTCPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utils = new SeleniumUtils(this.driver);
    }

	WebDriver driver;
    SeleniumUtils utils;

    public void distanceChange(String distance) {
		utils.clickElement(By.xpath("//input[@name='A629']"));
		utils.sendKeysToElement(By.xpath("//input[@name='A629']"), distance);
	}
    
    public void durationChange(String duration) {
    	utils.clickElement(By.xpath("//input[@name='A627']"));
    	utils.sendKeysToElement(By.xpath("//input[@name='A627']"), duration);
    }
	
}
