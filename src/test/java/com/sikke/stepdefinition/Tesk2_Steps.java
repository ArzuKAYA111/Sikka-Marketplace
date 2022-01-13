package com.sikke.stepdefinition;

import java.io.IOException;

import com.sikke.utilities.CommonMethods;
import com.sikke.utilities.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Tesk2_Steps extends CommonMethods{
	
	@Given("user navigate the application login Page")
	public void user_navigate_the_application_login_page() {
	driver.get(ConfigsReader.getProperty("url"));
	}
	
	@Then("user select {string} from Industry options and  {string} from App type options")
	public void user_select_from_industry_options_and_from_app_type_options(String industry, String appTypes) {
	// login.clickInds(industry);
	//login.clickApp(appTypes);
	}
	
	@Then("User gets the tiles writes the tiles, {string} and {string}  into the {string} sheet")
	public void user_gets_the_tiles_writes_the_tiles_and_into_the_sheet(String indstry, String appType, String shettName) throws IOException {
	login.createExel(indstry,appType,shettName);
	
	
	
}
	@Then("user select Dental from Industry options and  Patient Marketing from App type options")
	public void user_select_dental_from_industry_options_and_patient_marketing_from_app_type_options() {
		click(login.DentalCheckBox);
		click(login.PetMarkCheckBox);

	}
	

	

	@Then("User get the tiles writes the tiles, {string} and {string}  into the {string} sheet")
	public void user_get_the_tiles_writes_the_tiles_and_into_the_sheet(String indstry, String appType, String sheettName) throws IOException {
		
		
		
	}
//	@Then("user select Dental from Industry options and  Payments from App type options")
//	public void user_select_dental_from_industry_options_and_payments_from_app_type_options() {
//	  click(login.PAyCheckBox);
//	}























//	@Then("user gets the Industries")
//	public void user_gets_the_industries() {
//	System.out.println(login.getIndNames());
//
//	}
//	
//	@Then("user gets the App Types")
//	public void user_gets_the_app_types() {
//	   
//	//System.out.println(	login.getAppTypes());
//	}
//	
//	
//	
//	@Then("User validate the tiles")
//	public void user_validate_the_industry() {
//	
//	}
//	
}
