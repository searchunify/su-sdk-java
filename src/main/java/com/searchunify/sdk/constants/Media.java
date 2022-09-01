/**
 * 
 */
package com.searchunify.sdk.constants;

/**
 * @author ankur
 * @crated 08-Jun-2021
 */
public enum Media {

	JSON("application/json"), FORM_URLENCODED("application/x-www-form-urlencoded");

	private String value;

	private Media(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}

	/**
	 * Use this in place of valueOf.
	 *
	 * @param value real value
	 * @return UserType corresponding to the value
	 * @throws IllegalArgumentException
	 */
	public static Media fromValue(String value) throws IllegalArgumentException {
		switch (value) {
		case "application/json":
			return Media.JSON;
		case "application/x-www-form-urlencoded":
			return Media.FORM_URLENCODED;
		default:
			throw new IllegalArgumentException("Cannot create DataType from [" + value + "] value!");
		}
	}

}
