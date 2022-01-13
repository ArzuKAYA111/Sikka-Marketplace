package com.sikke.testbase;

import com.sikke.pages.LoginPage;


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
