package com.sikka.testbase;

import com.sikka.pages.LoginPage;

/**
 * initializes all pages class and stores references in static varibales
 * that will called/used in test classes
 * @author Arzu Kaya
 *
 */

public class PageInitializer extends BaseClass {
	
	public static LoginPage login;
	
	

public static void initialize() {
		
		login=new LoginPage();
		
	}	
	
}
