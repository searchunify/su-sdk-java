/**
 * 
 */
package com.searchunify.sdk.constants;

/**
 * This class is @author ankur
 * This class is created at 22-Mar-2021
 */
public enum HttpMethod {
	GET, PUT, POST, DELETE;

	/**
	 * Parameters @param stringValue
	 * @return {@link HttpMethod}
	 */
	public static HttpMethod fromString(final String stringValue) {
		try {
			return HttpMethod.valueOf(stringValue.toUpperCase());
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String toString() {
		return super.toString().toUpperCase();
	}
}
