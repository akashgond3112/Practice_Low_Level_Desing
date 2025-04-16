package com.java.lld.design.enums;

import lombok.Getter;

@Getter
public enum DirectionEnum {

	N("North"), S("South"), W("West"), E("East"),
	;

	/**
	 * key -- GETTER -- Getter method for property code.
	 *
	 * @return property value of code
	 */
	private final String code;

	/**
	 * @param code
	 * 		key
	 */
	DirectionEnum(String code) {
		this.code = code;
	}

}