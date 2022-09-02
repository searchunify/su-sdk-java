/**
 * 
 */
package com.searchunify.sdk.exceptions;

/**
 * This class is @author ankur
 * This class is created at 22-Mar-2021
 */
public class SearchUnifyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private int responseCode;

	/**
	 * @return
	 */
	public int getResponseCode() {
		return responseCode;
	}

	/**
	 * Parameters @param responseCode
	 */
	public void setResponseCode(final int responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * Parameters @param message
	 */
	public SearchUnifyException(final String message) {
		super(message);
	}

	/**
	 * Parameters @param message
	 * Parameters @param cause
	 */
	public SearchUnifyException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Parameters @param message
	 * Parameters @param responseCode
	 */
	public SearchUnifyException(final String message, final int responseCode) {
		super(message);
		this.responseCode = responseCode;
	}

	/**
	 * Parameters @param message
	 * Parameters @param cause
	 * Parameters @param responseCode
	 */
	public SearchUnifyException(final String message, final Throwable cause, final int responseCode) {
		super(message, cause);
		this.responseCode = responseCode;
	}
}
