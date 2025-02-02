package com.java.design.patterns.exceptions;

public class PropertyNotAvailable extends RuntimeException {
	public PropertyNotAvailable(String message) {
		super(message);
	}
}
