package com.java.lld.design.java.model.common;

import lombok.Builder;
import lombok.Value;

@Builder(builderMethodName = "hiddenBuilder")
@Value
public class PersonalInfo {

	String firstName;

	String lastName;

	String dob;

	String gender;

	Address address;

	String company;

	public static PersonalInfoBuilder builder(String firstName) {
		return hiddenBuilder().firstName(firstName);
	}
}
