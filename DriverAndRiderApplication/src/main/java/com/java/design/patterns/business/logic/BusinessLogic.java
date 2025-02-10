package com.java.design.patterns.business.logic;
import java.util.ArrayList;
import java.util.HashMap;

abstract public class BusinessLogic {
	public abstract HashMap<String,ArrayList<Integer>> eligibleDrivers(String CustomerName);
	public abstract void CalculateCustomerRating(String CustomerName); 
}
