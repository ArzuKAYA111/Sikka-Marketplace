package com.sikka.stepdefinitions;


import java.io.IOException;

import com.sikka.utilities.CommonMethods;
import com.sikka.utilities.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;



public class Tesk1_stepdefinition extends CommonMethods{
	@Given("user navigate the application login Page")
	public void user_navigate_the_application_login_page() {
	
	driver.get(ConfigsReader.getProperty(("url")));	
		
	}

	@Then("user select {string} from Industry options and {string} from App type options and reads tiles then writes them into the excel {string} sheet")
	public void user_select_from_industry_options_and_from_app_type_options_and_reads_tiles_then_writes_them_into_the_excel_sheet(String industry, String appType, String sheetName) throws IOException {
		   
		
			login.clickIndsAndApp(industry,appType,sheetName);	
		
			
		}
}
