package com.sikka.stepdefinitions;


import com.sikka.utilities.CommonMethods;

import com.sikka.testbase.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass {
	@Before
	public void start() {
		BaseClass.setUp();
	}
	
	@After
	public void end(Scenario scenario) {
		
		byte[] pic;
		if(scenario.isFailed()) {
			pic=CommonMethods.takeScreenshot("failed/"+scenario.getName());
		}else {
			pic=CommonMethods.takeScreenshot("passed/"+scenario.getName());
		}
		
		scenario.attach(pic, "image/png", scenario.getName());
		
		BaseClass.tearDown();
	}
}
