package com.java.design.patterns;
import com.java.design.patterns.business.logic.implementation.BusinessLogicImplementation;
import com.java.design.patterns.business.logic.implementation.EligibleDrivers;

import java.io.IOException;

public class mainClass {

	public static void main(String []args) throws IOException 
	{
		
		EligibleDrivers edobj= new EligibleDrivers();
		edobj.calculateEligibleDriverAndRating("c3");
		
		System.out.println("Customer Rating:");
		
		BusinessLogicImplementation blobj= new BusinessLogicImplementation();
		blobj.CalculateCustomerRating("c3");
		
		
		 
		
	}
}
