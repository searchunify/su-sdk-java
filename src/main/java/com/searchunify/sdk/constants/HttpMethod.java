/**
 * 
 */
package com.searchunify.sdk.constants;

/**
 * @author ankur
 * @crated 22-Mar-2021
 */
public enum HttpMethod {
	GET, PUT, POST, DELETE;

	/**
	 * @param stringValue
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
