package com.sikka.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (
		features ="src/test/resources/features/", 
					
		glue="com/sikka/stepdefinitions", 
					
		dryRun=false, 
		monochrome = true
				,strict= true 
				,tags= ""
		,plugin= {
				"pretty",
				"html:target/cucumber-default-report",
				"json:target/cucumber.json", 
				 "rerun:target/failed.txt" 
		}
		)

public class TaskRunner {

}
