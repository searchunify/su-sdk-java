/**
 * 
 */
package com.searchunify.sdk.exceptions;

/**
 * @author ankur
 * @crated 22-Mar-2021
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
	 * @param responseCode
	 */
	public void setResponseCode(final int responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @param message
	 */
	public SearchUnifyException(final String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SearchUnifyException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param responseCode
	 */
	public SearchUnifyException(final String message, final int responseCode) {
		super(message);
		this.responseCode = responseCode;
	}

	/**
	 * @param message
	 * @param cause
	 * @param responseCode
	 */
	public SearchUnifyException(final String message, final Throwable cause, final int responseCode) {
		super(message, cause);
		this.responseCode = responseCode;
	}
}
